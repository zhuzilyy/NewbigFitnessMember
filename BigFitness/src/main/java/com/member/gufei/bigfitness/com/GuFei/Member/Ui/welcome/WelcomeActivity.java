package com.member.gufei.bigfitness.com.GuFei.Member.Ui.welcome;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.WelcomeAdapter;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.AllCulbsListActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.local.LoginBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

import static com.member.gufei.bigfitness.Constants.ACCOUNTKEY;
import static com.member.gufei.bigfitness.Constants.LOGINKEY;
import static com.member.gufei.bigfitness.Constants.PASSWRODKEY;
import static com.member.gufei.bigfitness.Constants.SEXKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.Constants.WELCOMESHOWKEY;


/**
 * Created by Administrator on 2017/8/4.
 * 欢迎页面<br></>
 * 初始化推送<br></>
 * 申请相关权限
 */
@RuntimePermissions
public class WelcomeActivity extends BaseActivity<WelcomeActivityPresenter> implements WelcomeActivityContract.View, ViewPager.OnPageChangeListener {

    @BindView(R.id.btn_go)
    TextView btnGo;
    @BindView(R.id.btn_lauout)
    RelativeLayout btnLauout;
    private Handler handler = new Handler();

    String deviceCode;
    public static int OVERLAY_PERMISSION_REQ_CODE = 1234;

    private ViewPager vp;
    private WelcomeAdapter vpAdapter;
    private List<View> views;

    //引导图片资源
    private static final int[] pics = {R.mipmap.img_welcome1,
            R.mipmap.img_welcome2, R.mipmap.img_welcome3,
    };

    //底部小点图片
    private ImageView[] dots;

    //记录当前选中位置
    private int currentIndex;

    @Override
    public void showEmpty() {


    }

    @Override
    public void Error() {
//
//        Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
//        startActivity(intent);
//        finish();

    }

    @Override
    public void Loading() {

    }

    @Override
    public void outLogin() {

    }

    @Override
    public void succeed(LoginBean loginBean) {

//        if (loginBean.getPersonType().equals("会籍") || loginBean.getPersonType().equals("教练")) {
//
//            mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 1000);//1秒跳转
//
//
//        } else {
//
//            mHandler.sendEmptyMessageDelayed(GOTO_MAIN2_ACTIVITY, 1000);//1秒跳转
//        }


    }


    @Override
    public void remember(String account, String password, String deviceCoded, LoginBean loginBean, boolean flag) {
        if (flag) {
            SpUtil.put(mContext, ACCOUNTKEY, account);
            SpUtil.put(mContext, PASSWRODKEY, password);
            SpUtil.put(mContext, LOGINKEY, "1");
        }


//        SpUtil.put(mContext, DEVICECODEKEY, deviceCode);
//        SpUtil.put(mContext, USERLEVELKEY, loginBean.getUserLevel());
        SpUtil.put(mContext, USERIDKEY, loginBean.getUserId());
//        SpUtil.put(mContext, USERNAMEKEY, loginBean.getUserName());
        SpUtil.put(mContext, SEXKEY, loginBean.getSex());
//        SpUtil.put(mContext, CLUBIDKEY, loginBean.getClubId());
        SpUtil.put(mContext, TOKENKEY, loginBean.getToken());
//        SpUtil.put(mContext, PERSONTYPEKEY, loginBean.getPersonType());
//        SpUtil.put(mContext, ISDERPARTMANAGERKEY, loginBean.getIsdepartmanager());
//        SpUtil.put(mContext, DEPARTIDKEY, loginBean.getDepartId());
//        SpUtil.put(mContext, CLUBLISTKEY, new Gson().toJson(loginBean.getClubList()));
//        int s = (int) SpUtil.get(mContext, USERLEVELKEY, 9);


    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {

//        needP();
        InitPermissions();

        views = new ArrayList<View>();


        String s = (String) SpUtil.get(mContext, WELCOMESHOWKEY, "");

        if (s.equals("1")) {
            String login = (String) SpUtil.get(mContext, LOGINKEY, "");
            if (login.equals("1")) {
                Intent intent = new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();

            }else {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }

        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        //初始化引导图片列表
        for (int i = 0; i < pics.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setLayoutParams(mParams);
            iv.setImageResource(pics[i]);


            views.add(iv);


        }
        vp = (ViewPager) findViewById(R.id.viewpager);
        //初始化Adapter
        vpAdapter = new WelcomeAdapter(views);
        vp.setAdapter(vpAdapter);
        //绑定回调
        vp.setOnPageChangeListener(this);

        //初始化底部小点
        initDots();

    }

    private void initDots() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);

        dots = new ImageView[pics.length];

        //循环取得小点图片
        for (int i = 0; i < pics.length; i++) {
            dots[i] = (ImageView) ll.getChildAt(i);
            dots[i].setEnabled(true);//都设为灰色
//            dots[i].setOnClickListener(mContext);
            dots[i].setTag(i);//设置位置tag，方便取出与当前位置对应
        }

        currentIndex = 0;
        dots[currentIndex].setEnabled(false);//设置为白色，即选中状态
    }

    /**
     * 设置当前的引导页
     */
    private void setCurView(int position) {
        if (position < 0 || position >= pics.length) {
            return;
        }

        vp.setCurrentItem(position);
    }

    /**
     * 这只当前引导小点的选中
     */
    private void setCurDot(int positon) {
        if (positon < 0 || positon > pics.length - 1 || currentIndex == positon) {
            return;
        }

        dots[positon].setEnabled(false);
        dots[currentIndex].setEnabled(true);

        currentIndex = positon;
    }

    //当滑动状态改变时调用
    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub

    }

    //当当前页面被滑动时调用
    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub

    }

    //当新的页面被选中时调用
    @Override
    public void onPageSelected(int arg0) {
        //设置底部小点选中状态
        setCurDot(arg0);
        if (arg0 == 2) {
            btnLauout.setVisibility(View.VISIBLE);
        } else {
            btnLauout.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void initData() {


    }

    private static final int GOTO_MAIN_ACTIVITY = 0;
    private static final int GOTO_LOGIN_ACTIVITY = 1;
    private static final int GOTO_MAIN2_ACTIVITY = 2;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
/**
 * 判断用户是否为实际业务用户 跳转不同的页面
 */
            switch (msg.what) {
//                case GOTO_MAIN_ACTIVITY:
//
//                    Intent intent = new Intent();
//                    intent.setAction("reciver");
//                    sendBroadcast(intent);
//                    intent.setClass(WelcomeActivity.this, LoginActivity.class);
//                    startActivity(intent);
//                    overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
//                    finish();
//
//                    break;
                case GOTO_LOGIN_ACTIVITY:
                    Intent login = new Intent();
                    login.setAction("reciver");
                    sendBroadcast(login);
                    login.setClass(WelcomeActivity.this, LoginActivity.class);
                    startActivity(login);
                    overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                    finish();
                    break;
//                case GOTO_MAIN2_ACTIVITY:
//                    Intent intent1 = new Intent(WelcomeActivity.this, Main2Activity.class);
//                    intent1.setAction("reciver");
//                    sendBroadcast(intent1);
//                    intent1.setClass(WelcomeActivity.this, LoginActivity.class);
//                    startActivity(intent1);
//                    overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
//                    finish();
//                    break;

                default:
                    break;
            }
        }

        ;
    };


    private void init() {

//

//
        String name = (String) SpUtil.get(this, ACCOUNTKEY, "");
        String pwd = (String) SpUtil.get(this, PASSWRODKEY, "");
        String login = (String) SpUtil.get(this, LOGINKEY, "");

//        mHandler.sendEmptyMessageDelayed(GOTO_LOGIN_ACTIVITY, 1000);//1秒跳转

//        deviceCode = (String) SpUtil.get(mContext, CLIENTID, "");
//
//        if (!StringUtil.isSpace(name) && !StringUtil.isSpace(pwd)) {
//
////            if (login.equals("1")) {
////            mPresenter.login(name, pwd, deviceCode, true);//设备码未填写 为假数据
//            mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 1000);//1秒跳转
////                SpUtil.put(mContext, LOGINKEY, "0");
////            }
//        } else {
//
//            mHandler.sendEmptyMessageDelayed(GOTO_LOGIN_ACTIVITY, 1000);//1秒跳转
//
//        }
//
    }
//    @TargetApi(Build.VERSION_CODES.M)
//    public void requestDrawOverLays() {
//        if (!Settings.canDrawOverlays(WelcomeActivity.this)) {
//            Toast.makeText(this, "can not DrawOverlays", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + WelcomeActivity.this.getPackageName()));
//            startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
//        } else {
//            // Already hold the SYSTEM_ALERT_WINDOW permission, do addview or something.
//        }
//    }
//
//
//    @TargetApi(Build.VERSION_CODES.M)
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
//            if (!Settings.canDrawOverlays(this)) {
//                // SYSTEM_ALERT_WINDOW permission not granted...
//                Toast.makeText(this, "请赋予提示框显示权限!", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "已允许提示框权限", Toast.LENGTH_SHORT).show();
//                // Already hold the SYSTEM_ALERT_WINDOW permission, do addview or something.
//            }
//        }
//    }


    //定义请求
    private static final int READ_CONTACTS_REQUEST = 1;

    @NeedsPermission({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE})
    void InitPermissions() {

        /**
         * 1)使用ContextCompat.chefkSelfPermission(),因为Context.permission
         * 只在棒棒糖系统中使用
         * 2）总是检查权限（即使权限被授予）因为用户可能会在设置中移除你的权限*/
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //权限为获取，检查用户是否被询问过并且拒绝了，如果是这样的话，给予更多
            //解释
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)) {
                //在界面上展示为什么需要读取联系人
                Toast.makeText(this, "无法使用推送信息,请授权!", Toast.LENGTH_SHORT).show();
            }


            //发起请求获得用户许可,可以在此请求多个权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.ACCESS_FINE_LOCATION,

                            Manifest.permission.READ_PHONE_STATE},
                    READ_CONTACTS_REQUEST);
        } else {

            init();
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //确保是我们的请求
        if (requestCode == READ_CONTACTS_REQUEST) {
            if (grantResults.length == 5 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                init();

            } else if (grantResults.length == 3 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "授权失败,请到设置内开启推送权限", Toast.LENGTH_SHORT).show();
            } else if (grantResults.length == 3 && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                init();
            } else {
                init();
            }

        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        WelcomeActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }


    @OnClick(R.id.btn_go)
    public void onViewClicked() {
        mHandler.sendEmptyMessageDelayed(GOTO_LOGIN_ACTIVITY, 500);//1秒跳转
    }
}
