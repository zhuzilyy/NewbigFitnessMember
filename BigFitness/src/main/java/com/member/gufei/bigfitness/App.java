package com.member.gufei.bigfitness;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.igexin.sdk.PushManager;
import com.lzy.okgo.OkGo;
import com.member.gufei.bigfitness.com.GuFei.Component.AppComponent;
import com.member.gufei.bigfitness.com.GuFei.Component.DaggerAppComponent;
import com.member.gufei.bigfitness.com.GuFei.Moudel.AppModule;
import com.member.gufei.bigfitness.com.GuFei.Push.IntentService;
import com.member.gufei.bigfitness.component.CrashHandler;
import com.member.gufei.bigfitness.util.FileUtil;
import com.orhanobut.logger.Logger;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import org.xutils.x;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * 为基础Application类  <br>
 * 用于基础conetext与设备相关参数以及三方类库的初始化
 */
public class App extends Application {

    private static App instance;
    private Set<Activity> allActivities; // 保存所有 Activity 的集合

    public static int SCREEN_WIDTH = -1; // 屏幕宽 像素
    public static int SCREEN_HEIGHT = -1; // 屏幕高 像素
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;
    public static Context context;
    //    public static float RADIUS = 40.0f;
    public static synchronized App getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {

        super.onCreate();

        instance = this;
        x.Ext.init(this);
        x.Ext.setDebug(true);
        App.context = getApplicationContext();
        OkGo.getInstance().init(this);

        getAppComponent().inject(this);


//         百度地图初始化
//        SDKInitializer.initialize(this);

        //初始化屏幕宽高
        getScreenSize();

        //初始化Realm
        checkDataBase();

        Realm.init(this);

        RealmConfiguration config = new RealmConfiguration.Builder()
                //.deleteRealmIfMigrationNeeded()
                .name(Constants.DATABASE_NAME)
                .build();
        Realm.setDefaultConfiguration(config);

        //初始化日志 使用包名做 TAG , 隐藏线程信息
        Logger.init(getPackageName()).hideThreadInfo();

        //初始化错误收集
        CrashHandler.init(new CrashHandler(getApplicationContext()));

        //初始化内存泄漏检测
//        LeakCanary.install(this);

        //初始化过度绘制检测
        //BlockCanary.install(this, new AppBlockCanaryContext()).start();
        //初始化二维码扫描方法
        ZXingLibrary.initDisplayOpinion(this);
        //初始化推送
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), IntentService.class);

    }

    private void checkDataBase() {
        if (!FileUtil.isFileExists(getFilesDir() + "/" + Constants.DATABASE_NAME)) {
            try {
                InputStream is = getAssets().open(Constants.DATABASE_NAME);
                String outFileName = getFilesDir() + "/" + Constants.DATABASE_NAME;
                OutputStream os = new FileOutputStream(outFileName);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
                os.flush();
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (this) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    public void getScreenSize() {
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if (SCREEN_WIDTH > SCREEN_HEIGHT) {
            SCREEN_WIDTH = SCREEN_WIDTH ^ SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH ^ SCREEN_HEIGHT;
            SCREEN_WIDTH = SCREEN_WIDTH ^ SCREEN_HEIGHT;
        }
    }

    public static AppComponent getAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .build();
    }


}
