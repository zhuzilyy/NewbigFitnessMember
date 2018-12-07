package com.member.gufei.bigfitness.base;


import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.igexin.sdk.PushManager;
import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.com.GuFei.Component.ActivityComponent;
import com.member.gufei.bigfitness.com.GuFei.Component.DaggerActivityComponent;
import com.member.gufei.bigfitness.com.GuFei.Push.PushService;
import com.member.gufei.bigfitness.component.ActivityCollector;
import com.member.gufei.bigfitness.util.FloatTips;
import com.member.gufei.bigfitness.util.PermissionHelper;
import com.member.gufei.bigfitness.util.SpUtil;
import com.member.gufei.bigfitness.util.ToastUtil;
import com.zhy.autolayout.AutoLayoutActivity;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.member.gufei.bigfitness.App.SCREEN_WIDTH;
import static com.member.gufei.bigfitness.Constants.ACCOUNTKEY;
import static com.member.gufei.bigfitness.Constants.DEVICECODEKEY;
import static com.member.gufei.bigfitness.Constants.LOCATIONKEY;
import static com.member.gufei.bigfitness.Constants.PASSWRODKEY;
import static com.member.gufei.bigfitness.Constants.SEXKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;


/**
 * Created by GuFei_lyf on 2017/3/21
 * <p>
 * 基类
 * <p>
 * 键盘遮挡 Tag标签  ButterKnife绑定对象 简单时间格式化
 */


public abstract class BaseActivity<T extends BasePresenter> extends AutoLayoutActivity implements BaseView {

    @Inject
    protected T mPresenter;
    /**
     * presenter MVP的P
     */
    protected Activity mContext;
    protected String TAG;
    /**
     * TAG 标签
     */
    private Unbinder mUnBinder;
    /**
     * ButterKnife绑定对象,用于解绑.
     */
    protected int REQUEST_CODE;
    /**
     * 扫描回调接收标识
     */
    protected PermissionHelper mHelper = new PermissionHelper(this);
    /**
     * 系统权限申请类
     */
    protected Handler handler = new Handler();
    protected LocationManager locationManager;
    protected double latitude = 0.0;
    protected double longitude = 0.0;

    protected View contentView;
    protected PopupWindow popupWindow;
    public static boolean isForeground = false;
    protected FloatTips floatTips;
    private boolean show = false;
    public static int OVERLAY_PERMISSION_REQ_CODE = 1234;
    private String mMin;
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();
    private AtyContainer.NotificationReceiver myReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myReceiver = new AtyContainer.NotificationReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.action.receive.message");
        registerReceiver(myReceiver,intentFilter);
        int layoutId = getLayout();
        if (layoutId != 0) {
            setContentView(layoutId);
        }

        mUnBinder = ButterKnife.bind(this);
        mContext = this;
        TAG = this.getClass().getSimpleName();
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        ButterKnife.bind(this);


        initView();
        initData();
//        initListener();
        ActivityCollector.addActivity(this); // 保存可用 Activity 集合 , 实现任意位置退出程序
        /*      registerMessageReceiver();  // used for receive msg*/
        //关闭自动弹出输入法
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

//       注册个推
        PushManager.getInstance().initialize(this.getApplicationContext(), PushService.class);
        floatTips = new FloatTips(this.getApplicationContext());
        AtyContainer.getInstance().addActivity(this);
    }


    /**
     * 初始注入
     */
    protected abstract void initInject();

    /**
     * 绑定布局
     */
    protected abstract int getLayout();

    /**
     * 添加id
     */
    protected abstract void initView();

    /**
     * 添加本地数据
     */
    protected abstract void initData();


    protected <T extends View> T id(int id) {
        return (T) findViewById(id);
    }


    @Override
    protected void onResume() {
        isForeground = true;

        super.onResume();
        /*        JPushInterface.onResume(this);*/
    }

    public void setTimeShow(String time) {
        if (show) {
            floatTips.hide();
            show = false;
        } else {
            this.mMin = time;
            requestDrawOverLays();
            show = true;
        }
    }

    @Override
    protected void onPause() {
        isForeground = false;

        /*        JPushInterface.onPause(this);*/
        super.onPause();
    }

    public void clear() {
        AtyContainer.getInstance().removeActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /* unregisterReceiver(mMessageReceiver);*/

        if (mPresenter != null) {
            mPresenter.detachView();
        }
        if (myReceiver!=null){
            unregisterReceiver(myReceiver);
        }
        mUnBinder.unbind();

        ActivityCollector.removeActivity(this); // 移除 Activity
        AtyContainer.getInstance().removeActivity(this);
    }

    @Override
    public void showError(String msg) {
        ToastUtil.s(mContext, msg);
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .build();
    }


    //for receive customer msg from jpush server
    /*    private MessageReceiver mMessageReceiver;*/
    public static final String MESSAGE_RECEIVED_ACTION = "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION";
    public static final String KEY_TITLE = "title";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";


    private void setCostomMsg(String msg) {

        System.out.println(msg);
//        if (null != msgText) {
//            msgText.setText(msg);
//            msgText.setVisibility(android.view.View.VISIBLE);
//        }
    }

    //输入框 失去焦点  关闭软键盘
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            boolean hideInputResult = isShouldHideInput(v, ev);

            if (hideInputResult) {
                v.clearFocus();
                InputMethodManager imm = (InputMethodManager) BaseActivity.this
                        .getSystemService(Activity.INPUT_METHOD_SERVICE);
                if (v != null) {
                    if (imm.isActive()) {
                        imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            //之前一直不成功的原因是,getX获取的是相对父视图的坐标,getRawX获取的才是相对屏幕原点的坐标！！！
//            Log.v("leftTop[]", "zz--left:" + left + "--top:" + top + "--bottom:" + bottom + "--right:" + right);
//            Log.v("event", "zz--getX():" + event.getRawX() + "--getY():" + event.getRawY());
            if (event.getRawX() > left && event.getRawX() < right
                    && event.getRawY() > top && event.getRawY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }

    public void LessonPopup(View v) {
        if (contentView != null) contentView = null;
        if (popupWindow != null) popupWindow = null;
        // 一个自定义的布局，作为显示的内容

        contentView = LayoutInflater.from(mContext).inflate(R.layout.member_pop_view_time_lesson, null);
        popupWindow = new PopupWindow(contentView, SCREEN_WIDTH - 200, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
//                backgroundAlpha(1f);
            }
        });


        final TextView NameLesson = (TextView) contentView.findViewById(R.id.text_name_lesson);
        final TextView NameCoach = (TextView) contentView.findViewById(R.id.text_name_coach);
        final TextView btnClose = (TextView) contentView.findViewById(R.id.btn_close);


//        btnPublicSea.setVisibility(mtype != 0 ? View.GONE : View.VISIBLE);


        //        final TextView textLabel = (TextView) contentViekehu kehu kehu  w.findViewById(R.id.text_label);
//        final TextView btnreset = (TextView) contentView.findViewById(R.id.btn_reset);
//        final TextView btnconfirm = (TextView) contentView.findViewById(R.id.btn_confirm);

//        textPublicSea.setText(mPostCustomerListBean.getPublicSeaName());

//        final ImageView btnReferences = (ImageView) contentView.findViewById(R.id.btn_references);
//        final ImageView btnSource = (ImageView) contentView.findViewById(R.id.btn_source);
//        final ImageView btnIntention = (ImageView) contentView.findViewById(R.id.btn_intention);
//        final ImageView btnLabel = (ImageView) contentView.findViewById(R.id.btn_label);
//        final ImageView btnConsultant = (ImageView) contentView.findViewById(R.id.btn_consultant);
//        final ImageView btnCollect = (ImageView) contentView.findViewById(R.id.btn_collect);
//        textLabel.setText(mPostCustomerListBean.getLabelName());//标签
//        textConsultant.setText(mPostCustomerListBean.getOwnManagerName());//会籍顾问
//        textReferences.setText(mPostCustomerListBean.getIntroduceMemberName());//介绍人
//        textIntention.setText(mPostCustomerListBean.getIntentName());//意向
//        textSource.setText(mPostCustomerListBean.getSourceName());//来源
//        switch (layoutId) {
//            case R.layout.pop_view_customer_screening:
//                //客户列表
//                break;
//            case R.layout.pop_view_non_customer_screening:
//                //过期会员列表
//                TextView textCoachPos = (TextView) contentView.findViewById(R.id.text_coach_pos);
//                TextView textCoachTrack = (TextView) contentView.findViewById(R.id.text_coach_track);
//                textCoachPos.setText(mPostCustomerListBean.getPOSTeacherName());//POS教练
//                textCoachTrack.setText(mPostCustomerListBean.getOwnTeacherName());//跟踪教练
//                break;
//        }
//
//        popupWindow.update();
////        backgroundAlpha(0.5f);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
                return false;

                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));
        // 设置好参数之后再show
        //获取点击View的坐标

        int[] point = {0, 0};

        v.getLocationOnScreen(point);

//        popupWindow.showAtLocation(v, Gravity.CENTER, 0, point[1] + v.getHeight());
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 150);


//        popupWindow.setAnimationStyle(R.style.take_photo_anim);
    }

    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                if (fm != null && fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                } else {
                    finish();
                }
            }
        });
    }

    protected String getDataTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String s = format.format(date);
        return s;
    }


    protected String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    protected String getDateTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }

    protected String getHourMin(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(date);
    }

    protected String getDayForMember(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        return format.format(date);
    }

    protected String getTimes(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    public void remove() {

        SpUtil.remove(mContext, ACCOUNTKEY);
        SpUtil.remove(mContext, PASSWRODKEY);
        SpUtil.remove(mContext, DEVICECODEKEY);
        SpUtil.remove(mContext, USERIDKEY);
        SpUtil.remove(mContext, SEXKEY);
        SpUtil.remove(mContext, TOKENKEY);


    }

    public static void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

    //    public void InitGPS() {
//
//        locationManager = (LocationManager) getSystemService(mContext.LOCATION_SERVICE);
//        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
//            getLocation();
//            //gps已打开
//        } else {
//            toggleGPS();
//            new Handler() {
//            }.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    getLocation();
//                }
//            }, 2000);
//
//        }
//    }
//
//
//    private void toggleGPS() {
//        Intent gpsIntent = new Intent();
//        gpsIntent.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
//        gpsIntent.addCategory("android.intent.category.ALTERNATIVE");
//        gpsIntent.setData(Uri.parse("custom:3"));
//        try {
//            PendingIntent.getBroadcast(this, 0, gpsIntent, 0).send();
//        } catch (PendingIntent.CanceledException e) {
//            e.printStackTrace();
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                // TODO: Consider calling
//                //    ActivityCompat#requestPermissions
//                // here to request the missing permissions, and then overriding
//                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                //                                          int[] grantResults)
//                // to handle the case where the user grants the permission. See the documentation
//                // for ActivityCompat#requestPermissions for more details.
//                return;
//            } else {
//                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, locationListener);
//                Location location1 = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//                if (location1 != null) {
//                    latitude = location1.getLatitude(); // 经度
//                    longitude = location1.getLongitude(); // 纬度
//                }
//
//            }
//
//        }
//    }
//
//    private void getLocation() {
//        Location location = null;
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        } else {
//
//            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//
//        }
//
//        if (location != null) {
//            latitude = location.getLatitude();
//            longitude = location.getLongitude();
//        } else {
//
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                // TODO: Consider calling
//                //    ActivityCompat#requestPermissions
//                // here to request the missing permissions, and then overriding
//                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                //                                          int[] grantResults)
//                // to handle the case where the user grants the permission. See the documentation
//                // for ActivityCompat#requestPermissions for more details.
//                return;
//            } else {
//                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, locationListener);
//            }
//
//        }
////        info.setText("纬度：" + latitude + "\n" + "经度：" + longitude);
//    }
//
//
//    LocationListener locationListener = new LocationListener() {
//        // Provider的状态在可用、暂时不可用和无服务三个状态直接切换时触发此函数
//        @Override
//        public void onStatusChanged(String provider, int status, Bundle extras) {
//        }
//
//        // Provider被enable时触发此函数，比如GPS被打开
//        @Override
//        public void onProviderEnabled(String provider) {
//            Log.e(TAG, provider);
//        }
//
//        // Provider被disable时触发此函数，比如GPS被关闭
//        @Override
//        public void onProviderDisabled(String provider) {
//            Log.e(TAG, provider);
//        }
//
//        // 当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发
//        @Override
//        public void onLocationChanged(Location location) {
//            if (location != null) {
//                Log.e("Map", "Location changed : Lat: " + location.getLatitude() + " Lng: " + location.getLongitude());
//                latitude = location.getLatitude(); // 经度
//                longitude = location.getLongitude(); // 纬度
//            }
//        }
//    };
    public void InitGPS() {
        mLocationClient = new LocationClient(getApplicationContext());     //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);    //注册监听函数
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Battery_Saving
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 0;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤GPS仿真结果，默认需要
        mLocationClient.setLocOption(option);
        //开启定位
        mLocationClient.start();
    }


    // 打开和关闭gps第二种方法
    public void openGPSSettings() {
        //获取GPS现在的状态（打开或是关闭状态）
        boolean gpsEnabled = Settings.Secure.isLocationProviderEnabled(getContentResolver(), LocationManager.GPS_PROVIDER);
        if (gpsEnabled) {
            //关闭GPS
            Settings.Secure.setLocationProviderEnabled(getContentResolver(), LocationManager.GPS_PROVIDER, false);
        } else {
            //打开GPS
            Settings.Secure.setLocationProviderEnabled(getContentResolver(), LocationManager.GPS_PROVIDER, true);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (!Settings.canDrawOverlays(this)) {
                // SYSTEM_ALERT_WINDOW permission not granted...
                Toast.makeText(this, "请赋予提示框显示权限!否则无法提示上课时间!", Toast.LENGTH_SHORT).show();
            } else {
                requestDrawOverLays();
            }
        }
    }


    public void requestDrawOverLays() {

        if (Build.VERSION.SDK_INT >= 23) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
                show = false;
                return;
            } else {
                floatTips.setGravity(FloatTips.BOTTOM);
                floatTips.show(mMin);
            }
        } else {
            floatTips.setGravity(FloatTips.BOTTOM);
            floatTips.show(mMin);
        }


    }

    private class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            StringBuffer sb = new StringBuffer(256);
            sb.append("time : ");
            sb.append(bdLocation.getTime());
            sb.append("\nerror code : ");
            sb.append(bdLocation.getLocType());
            sb.append("\nlatitude : ");
            sb.append(bdLocation.getLatitude());
            sb.append("\nlontitude : ");
            sb.append(bdLocation.getLongitude());
            sb.append("\nradius : ");
            sb.append(bdLocation.getRadius());
            if (bdLocation.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
                sb.append("\nspeed : ");
                sb.append(bdLocation.getSpeed());// 单位：公里每小时
                sb.append("\nsatellite : ");
                sb.append(bdLocation.getSatelliteNumber());
                sb.append("\nheight : ");
                sb.append(bdLocation.getAltitude());// 单位：米
                sb.append("\ndirection : ");
                sb.append(bdLocation.getDirection());// 单位度
                sb.append("\naddr : ");
                sb.append(bdLocation.getAddrStr());
                sb.append("\ndescribe : ");
                sb.append("gps定位成功");

            } else if (bdLocation.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
                sb.append("\naddr : ");
                sb.append(bdLocation.getAddrStr());
                //运营商信息
                sb.append("\noperationers : ");
                sb.append(bdLocation.getOperators());
                sb.append("\ndescribe : ");
                sb.append("网络定位成功");
            } else if (bdLocation.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");
            } else if (bdLocation.getLocType() == BDLocation.TypeServerError) {
                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
            } else if (bdLocation.getLocType() == BDLocation.TypeNetWorkException) {
                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");
            } else if (bdLocation.getLocType() == BDLocation.TypeCriteriaException) {
                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
            }
            sb.append("\nlocationdescribe : ");
            sb.append(bdLocation.getLocationDescribe());// 位置语义化信息
            List<Poi> list = bdLocation.getPoiList();// POI数据
            if (list != null) {
                sb.append("\npoilist size = : ");
                sb.append(list.size());
                for (Poi p : list) {
                    sb.append("\npoi= : ");
                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }
            }
            Log.e("描述：", sb.toString());
//          SpUtil.put(mContext, LONGITUDEKEY, longitude = bdLocation.getLongitude());
//          SpUtil.put(mContext, LATITUDEKEY, latitude = bdLocation.getLatitude());
            SpUtil.put(mContext, LOCATIONKEY, bdLocation.getLongitude() + "," + bdLocation.getLatitude());
        }
    }
}

class AtyContainer {

    private AtyContainer() {
    }

    private static AtyContainer instance = new AtyContainer();
    private static List<Activity> activityStack = new ArrayList<Activity>();

    public static AtyContainer getInstance() {
        return instance;
    }

    public void addActivity(Activity aty) {
        activityStack.add(aty);
    }

    public void removeActivity(Activity aty) {
        activityStack.remove(aty);
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }
    //注册广播接收到通送的广播显示对话框
    static class NotificationReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("com.action.receive.message")){
                String title = intent.getStringExtra("title");
                String message = intent.getStringExtra("message");
                AlertDialog.Builder dialog=new AlertDialog.Builder(context);
                dialog.setTitle(title);//设置标题
                dialog.setMessage(message);//设置信息具体内容
                dialog.setCancelable(false);//设置是否可取消
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        }
    }

}