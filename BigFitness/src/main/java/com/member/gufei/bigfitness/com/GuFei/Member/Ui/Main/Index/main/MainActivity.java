package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.design.widget.TabItem;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.igexin.sdk.PushManager;
import com.member.gufei.bigfitness.Presenter.FragMentListening;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.CardIndex.CardIndexFragMent;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C1.IndexFragMentC1;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.IndexFragMent;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyIndex.MyIndexFragMent;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyScheduleFragMent;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.ReservationRecordList.ReservationRecordListActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.TimeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Push.IntentService;
import com.member.gufei.bigfitness.util.MyCountDownTimer;
import com.member.gufei.bigfitness.util.SpUtil;
import com.member.gufei.bigfitness.util.TimeUtil;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.App.context;
import static com.member.gufei.bigfitness.Constants.ACCOUNTKEY;
import static com.member.gufei.bigfitness.Constants.BASEURL;
import static com.member.gufei.bigfitness.Constants.CLIENTID;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 */


public class MainActivity extends BaseActivity<MainActivityPresenter> implements MainActivityContract.View, FragMentListening {


    private static final int REQUEST_CODE = 1;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_left)
    ImageView btnLeft;
    @BindView(R.id.btn_right)
    ImageView btnRight;
    /**
     * Tab 图片
     */
    private int[] images_selector = {R.mipmap.index_selected, R.mipmap.card_selected,
            R.mipmap.appointment_selected, R.mipmap.my_selected,};
    private int[] images_normal = {R.mipmap.index_btn, R.mipmap.card_btn,
            R.mipmap.appointment_btn, R.mipmap.my_btn};

    private String[] tabTitles; // 标题数组
    private int userid;
    private String cid;
    private int recLen;
    private String AddAppointment;

    private int closeF = 0;
    private ArrayList<TabItem> mTableItemList;
    public MyCountDownTimer myCountDownTimer;


    long exitTime;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_main;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        AddAppointment = intent.getStringExtra(PUT_STR + "AddAppointment");
        SpUtil.put(mContext, CLIENTID, PushManager.getInstance().getClientid(mContext));
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("主页");
        btnLeft.setVisibility(View.GONE);
        btnRight.setImageResource(R.mipmap.right_btn);

        // 从资源文件中获取标题
        tabTitles = getResources().getStringArray(R.array.tabTitle);
        initTabData();
        initTabHost();

        userid = (int) SpUtil.get(mContext, USERIDKEY, 1);
        cid = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        http();
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myCountDownTimer.cancelTimer();
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    //初始化Tab数据
    private void initTabData() {
        mTableItemList = new ArrayList<>();
        //添加tab
        mTableItemList.add(new TabItem(images_normal[0], images_selector[0], tabTitles[0], IndexFragMent.class));
        mTableItemList.add(new TabItem(images_normal[1], images_selector[1], tabTitles[1], CardIndexFragMent.class));
        mTableItemList.add(new TabItem(images_normal[2], images_selector[2], tabTitles[2], MyScheduleFragMent.class));
        mTableItemList.add(new TabItem(images_normal[3], images_selector[3], tabTitles[3], MyIndexFragMent.class));


    }

    //初始化主页选项卡视图
    private void initTabHost() {
        //实例化FragmentTabHost对象
        FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        //去掉分割线
        fragmentTabHost.getTabWidget().setDividerDrawable(null);

        for (int i = 0; i < mTableItemList.size(); i++) {
            TabItem tabItem = mTableItemList.get(i);
            //实例化一个TabSpec,设置tab的名称和视图
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(tabItem.getTitleString()).setIndicator(tabItem.getView());

            fragmentTabHost.addTab(tabSpec, tabItem.getFragmentClass(), null);

            //给Tab按钮设置背景
            fragmentTabHost.getTabWidget().getChildAt(i).setBackgroundColor(getResources().getColor(R.color.member_view_bg_color));
            //默认选中第一个tab
//            if (i == 0) {
//                tabItem.setChecked(true);
//            }
            if (AddAppointment.equals(String.valueOf(i))){
                fragmentTabHost.setCurrentTab(i);
                tabItem.setChecked(true);
            }

        }

        fragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {

                //重置Tab样式
                for (int i = 0; i < mTableItemList.size(); i++) {
                    TabItem tabitem = mTableItemList.get(i);
                    if (tabId.equals(tabitem.getTitleString())) {
                        tabitem.setChecked(true);

                        switch (i) {

                            case 0:
                                toolbar.setVisibility(View.VISIBLE);

                                break;
                            case 1:
                                toolbar.setVisibility(View.VISIBLE);

                                break;
                            case 2:
                                toolbar.setVisibility(View.GONE);

                                break;
                            case 3:
                                toolbar.setVisibility(View.GONE);

                                break;


                        }

                    } else {
                        tabitem.setChecked(false);
                    }
                }
            }
        });
    }


    @OnClick(R.id.btn_right)
    public void onViewClicked() {
    }


    @Override
    protected void initData() {


    }


    @Override
    public void showError(String msg) {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void outLogin() {


        s(this, "您的帐号在其他设备登录");
        Intent intent = new Intent(mContext, LoginActivity.class);
        remove();

        startActivity(intent);

    }


    @Override
    public void Loading() {

    }

    @Override
    public void succeed(MainMsgBean testBean) {

    }

    private void http() {
        RequestParams params = new RequestParams(BASEURL + "/appMember/memberLesson/getClassCountdownInfo");
        params.addQueryStringParameter("APPUserId", userid + "");
        params.addQueryStringParameter("ClubId", cid + "");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Log.e("ss", result);
                TimeBean timeBean = new Gson().fromJson(result, TimeBean.class);
                String endtime = timeBean.getRows().getPlanFinishTime();
                Log.e("time", endtime);
                String nowTime = TimeUtil.getCurTimeString();
                Log.e("time", nowTime);
                Date enddate = TimeUtil.string2Date(endtime);
                Date nowdate = TimeUtil.string2Date(nowTime);
                long timeLong = enddate.getTime() - nowdate.getTime();

                String time = TimeUtil.getTime(enddate, nowdate);
                Log.e("time", time);
                //解析result
                setTimeShow(time);
            }

            //请求异常后的回调方法
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }

            //主动调用取消请求的回调方法
            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
            }
        });
    }

    @OnClick({R.id.btn_left, R.id.btn_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_left:

                break;
            case R.id.btn_right:


                Intent intent = new Intent(MainActivity.this, ReservationRecordListActivity.class);
                startActivity(intent);

                break;
        }
    }


//    @OnClick({R.id.address_btn, R.id.main_btn, R.id.my_btn})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.address_btn:
//                break;
//            case R.id.main_btn:
//                break;
//            case R.id.my_btn:
//                break;
//        }
//    }


    /**
     * 扫描二维码回调方法
     *
     * @param requestCode  请求码
     * @param permissions  请求权限
     * @param grantResults 请求状态
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 8444:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
//                    Intent intent = new Intent(mContext, ScanActivity.class);
//                    startActivityForResult(intent, REQUEST_CODE);
                } else {
                    // Permission Denied
                    Toast.makeText(mContext, "无法打开摄像头，缺少必要权限，您应在应用管理中授予权限", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    /**
     * 处理二维码扫描结果
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(mContext, "无法进行上课打卡!请扫描会员二维码", Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }

//        if (requestCode == REQUEST_CODE) {
//            //处理扫描结果（在界面上显示）
//            if (null != data) {
//                Bundle bundle = data.getExtras();
//                if (bundle == null) {
//                    return;
//                }
//                // 获取扫描结果, 并显示在 webView 中
//                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
//                    String result = bundle.getString(CodeUtils.RESULT_STRING);
//                    Toast.makeText(mContext, "无法进行上课打卡!请扫描会员二维码", Toast.LENGTH_LONG).show();
//
////                    webView.loadUrl(result);
//                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
//                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
//                }
//            }
//        }
    }


    /**
     * 扫描
     */

    public void Scan() {

//
//        Intent Scan = new Intent(mContext, CaptureActivity.class);
//        Intent Scan = new Intent(mContext, ScanActivity.class);
//        // 6.0版本后 动态权限处理
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(mContext, new String[]{Manifest.permission.CAMERA}, 8444);
//            } else {
//
//                startActivityForResult(Scan, REQUEST_CODE);
//            }
//        } else {
//            if (PermissionTool.isCameraCanUse()) {
//
//                startActivityForResult(Scan, REQUEST_CODE);
//            } else {
//                Toast.makeText(mContext, "无法打开摄像头，缺少必要权限，您应在应用管理中授予权限", Toast.LENGTH_LONG).show();
//            }
//        }


    }


    @Override
    public void BtnScan() {

        Scan();

    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
//
//            if ((System.currentTimeMillis() - exitTime) > 2000)  //System.currentTimeMillis()无论何时调用，肯定大于2000
//            {
//                Toast.makeText(getApplicationContext(), "再按一次返回键退出", Toast.LENGTH_SHORT).show();
//                exitTime = System.currentTimeMillis();
//            } else {
//                finish();
//                System.exit(0);
//            }
//
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("确定要退出吗?");
        builder.setTitle("提示");
        builder.setPositiveButton("确认",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //AccoutList.this.finish();
                        //System.exit(1);
                        Process.killProcess(Process.myPid());
                    }
                });
        builder.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }


    class TabItem {
        //正常情况下显示的图片
        private int imageNormal;
        //选中情况下显示的图片
        private int imagePress;
        //tab的名字
        private String title;
        private String titleString;

        //tab对应的fragment
        public Class<? extends Fragment> fragmentClass;

        public View view;
        public ImageView imageView;
        public TextView textView;

        public TabItem(int imageNormal, int imagePress, String title, Class<? extends Fragment> fragmentClass) {
            this.imageNormal = imageNormal;
            this.imagePress = imagePress;
            this.title = title;
            this.fragmentClass = fragmentClass;
        }

        public Class<? extends Fragment> getFragmentClass() {
            return fragmentClass;
        }

        public int getImageNormal() {
            return imageNormal;
        }

        public int getImagePress() {
            return imagePress;
        }

        public String getTitle() {
            return title;
        }

        public String getTitleString() {
            if (title == null) {
                return "";
            }
            if (TextUtils.isEmpty(titleString)) {
                titleString = title;
            }
            return titleString;
        }

        public View getView() {
            if (this.view == null) {
                this.view = getLayoutInflater().inflate(R.layout.member_view_tab_indicator, null);
                this.imageView = (ImageView) this.view.findViewById(R.id.tab_iv_image);
                this.textView = (TextView) this.view.findViewById(R.id.tab_tv_text);
                if (this.title == null) {
                    this.textView.setVisibility(View.GONE);
                } else {
                    this.textView.setVisibility(View.VISIBLE);
                    this.textView.setText(getTitleString());
                }
                this.imageView.setImageResource(imageNormal);
            }
            return this.view;
        }

        //切换tab的方法
        public void setChecked(boolean isChecked) {
            if (imageView != null) {
                if (isChecked) {
                    imageView.setImageResource(imagePress);
                } else {
                    imageView.setImageResource(imageNormal);
                }
            }
            if (textView != null) {
                if (isChecked) {
                    textView.setTextColor(getResources().getColor(R.color.green_btn));
                } else {
                    textView.setTextColor(getResources().getColor(R.color.bogegray));
                }
            }
        }
    }


}

