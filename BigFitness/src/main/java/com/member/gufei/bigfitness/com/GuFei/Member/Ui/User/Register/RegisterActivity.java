package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Pay.PayActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Register.Sex.SexActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.welcome.WelcomeActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.RegisterAppUserBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.VerificationAccountNameBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.VerifyCodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.LoginBean;
import com.member.gufei.bigfitness.util.DownTimerUtil.DownTimerInterface;
import com.member.gufei.bigfitness.util.MyCountDownTimer;
import com.member.gufei.bigfitness.util.SpUtil;
import com.member.gufei.bigfitness.util.StringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.App.SCREEN_WIDTH;
import static com.member.gufei.bigfitness.Constants.ACCOUNTKEY;
import static com.member.gufei.bigfitness.Constants.CLIENTID;
import static com.member.gufei.bigfitness.Constants.DEVICECODEKEY;
import static com.member.gufei.bigfitness.Constants.INTERVAL;
import static com.member.gufei.bigfitness.Constants.LOGINKEY;
import static com.member.gufei.bigfitness.Constants.PASSWRODKEY;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SEXKEY;
import static com.member.gufei.bigfitness.Constants.TIME;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERID;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.StringUtil.length;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 登录页面 实现
 */


public class RegisterActivity extends BaseActivity<RegisterActivityPresenter> implements RegisterActivityContract.View, PopupWindow.OnDismissListener {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.edit_tel)
    EditText editTel;
    @BindView(R.id.edit_psw)
    EditText editPsw;
    @BindView(R.id.edit_psw_confirm)
    EditText editPswConfirm;
    @BindView(R.id.edit_verification)
    EditText editVerification;
    @BindView(R.id.btn_Verification)
    TextView btnVerification;
    @BindView(R.id.btn_register)
    Button btnRegister;
    private boolean isHidden = true;

    String clientId;
    private String TexteditName;
    private String TexteditTel;
    private String TexteditPsw;
    private String TexteditPswConfirm;
    private String TexteditVerification;
    private String mVerifyCode = "";
    public MyCountDownTimer myCountDownTimer;

    @Override
    protected void initInject() {

        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_register;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("注册");
        String name = (String) SpUtil.get(mContext, ACCOUNTKEY, "");
        String pwd = (String) SpUtil.get(mContext, PASSWRODKEY, "");
        String login = (String) SpUtil.get(mContext, LOGINKEY, "");
        clientId = (String) SpUtil.get(mContext, CLIENTID, "");


        if (!StringUtil.isSpace(name) && !StringUtil.isSpace(pwd)) {
//            username.setText(name);
//            password.setText(pwd);
//            remberCheckBox.setChecked(true);
//            if (login.equals("1")) {
//                mPresenter.login(name, pwd, clientId, remberCheckBox.isChecked());//设备码未填写 为假数据
//                SpUtil.put(mContext, LOGINKEY, "0");
//            }
        }

//        Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
//        startActivity(intent);
//        finish();

//        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//        startActivity(intent);
//        finish();

        editName.setOnFocusChangeListener(new android.view.View.
                OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    //当用户名失去焦点时发送用户名重复交验请求
                    TexteditName = editName.getText().toString();
                    String token = (String) SpUtil.get(mContext, TOKENKEY, "");
                    mPresenter.checkTAppuserByAccountName(TexteditName, token);
                }
            }
        });

        editPsw.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    if (editPsw.getText().toString().length() < 6){
                        s(mContext, "密码不能少于6位");
                    }
                }
            }
        });
    }

//
//    /**
//     * 固化用户信息
//     *
//     * @param account    帐号
//     * @param password   密码
//     * @param deviceCode 设备号
//     * @param loginBean  登录返回信息
//     * @param flag       记录标识
//     */
//    @Override
//    public void remember(String account, String password, String deviceCode, LoginBean loginBean, boolean flag) {
//
//        if (flag) {
//            SpUtil.put(mContext, ACCOUNTKEY, account);
//            SpUtil.put(mContext, PASSWRODKEY, password);
//            SpUtil.put(mContext, LOGINKEY, "1");
//        }
//
//
//        SpUtil.put(mContext, DEVICECODEKEY, deviceCode);
////        SpUtil.put(mContext, USERLEVELKEY, loginBean.getUserLevel());
//        SpUtil.put(mContext, USERIDKEY, loginBean.getUserId());
////        SpUtil.put(mContext, USERNAMEKEY, loginBean.getUserName());
//        SpUtil.put(mContext, SEXKEY, loginBean.getSex());
////        SpUtil.put(mContext, CLUBIDKEY, loginBean.getClubId());
//        SpUtil.put(mContext, TOKENKEY, loginBean.getToken());
////        SpUtil.put(mContext, PERSONTYPEKEY, loginBean.getPersonType());
////        SpUtil.put(mContext, ISDERPARTMANAGERKEY, loginBean.getIsdepartmanager());
////        SpUtil.put(mContext, DEPARTIDKEY, loginBean.getDepartId());
////        SpUtil.put(mContext, CLUBLISTKEY, new Gson().toJson(loginBean.getClubList()));
////        String s = (String) SpUtil.get(mContext, CLUBLISTKEY, "");
//
//
//    }
//
//
//    @Override
//    public void remove() {
//
//        SpUtil.remove(mContext, ACCOUNTKEY);
//        SpUtil.remove(mContext, PASSWRODKEY);
//        SpUtil.remove(mContext, DEVICECODEKEY);
//        SpUtil.remove(mContext, USERIDKEY);
////        SpUtil.remove(mContext, USERNAMEKEY);
//        SpUtil.remove(mContext, SEXKEY);
////        SpUtil.remove(mContext, CLUBIDKEY);
//        SpUtil.remove(mContext, TOKENKEY);
////        SpUtil.remove(mContext, PERSONTYPEKEY);
////        SpUtil.remove(mContext, ISDERPARTMANAGERKEY);
////        SpUtil.remove(mContext, DEPARTIDKEY);
//
//    }

    @Override
    protected void initData() {

//        JPushInterface.init(getApplicationContext());

    }


    @Override
    public void showError(String msg) {

        s(this, msg);

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void outLogin() {

//        Intent intent = new Intent(mContext, LoginActivity.class);
//        startActivity(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        myCountDownTimer.cancelTimer();
    }

    @Override
    public void Loading() {

    }


    @Override
    public void succeed(VerifyCodeBean verifyCodeBean) {
        mVerifyCode = verifyCodeBean.getVerifyCode();
    }

    @Override
    public void RegisterSucceed(RegisterAppUserBean normalResponse) {
        SpUtil.put(mContext, ACCOUNTKEY, normalResponse.getRows().getAccountName());
        SpUtil.put(mContext, USERIDKEY,  normalResponse.getRows().getAPPUserId());
//        finishPopup(btnVerification,"1");
        myCountDownTimer.cancelTimer();
        Intent intent = new Intent(RegisterActivity.this, SexActivity.class);

        intent.putExtra(PUT_STR + "popCode", "1");
        startActivity(intent);
        finish();

    }

    @Override
    public void AccountNameSucceed(VerificationAccountNameBean verificationAccountNameBean) {

    }

    @Override
    public void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                if (fm != null && fm.getBackStackEntryCount() > 0) {
                    myCountDownTimer.cancelTimer();
                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                } else {
                    myCountDownTimer.cancelTimer();
                    finish();
                }
            }
        });
    }

    @OnClick({R.id.btn_Verification, R.id.btn_register})
    public void onViewClicked(View view) {
        TexteditName = editName.getText().toString();
        TexteditTel = editTel.getText().toString();
        TexteditPsw = editPsw.getText().toString();
        TexteditPswConfirm = editPswConfirm.getText().toString();
        TexteditVerification = editVerification.getText().toString();

        switch (view.getId()) {
            case R.id.btn_Verification:
                if (TexteditTel.equals("")) {
                    s(mContext, "电话不能为空!");
                    break;
                }
                btnVerification.setEnabled(false);

                myCountDownTimer = new MyCountDownTimer(1 * TIME, INTERVAL);
                myCountDownTimer.setDownTimerInterface(new DownTimerInterface() {
                    @Override
                    public void setText(String time) {

                    }

                    @Override
                    public void setSecText(String time) {
                        btnVerification.setText("重新发送"+"(" + time + ")");
                        if (time.equals("01")){
                            btnVerification.setText("获取验证码");
                            btnVerification.setEnabled(true);
                            myCountDownTimer.cancelTimer();
                        }
                    }

                    @Override
                    public void setThirdText(String time) {

                    }
                });
                myCountDownTimer.startTimer();
                mPresenter.getVerifyCode(TexteditTel);
//                s(this,"成功发送验证码!");
                break;


            case R.id.btn_register:


                if (TexteditName.equals("")) {
                    s(mContext, "用户名不能为空!");
                    break;
                }
                if (TexteditPsw.length() < 6){
                    s(mContext, "请输入6位以上密码");
                }
                if (TexteditPsw.equals("") || TexteditPswConfirm.equals("")) {
                    s(mContext, "请填写正确密码!");
                    break;
                }

                if (TexteditTel.equals("")) {
                    s(mContext, "电话不能为空!");
                    break;
                }


                if (mVerifyCode.equals("") || !mVerifyCode.equals(TexteditVerification)|| length(TexteditVerification) != 6) {
                    s(mContext, "请输入正确的验证码!");
                    break;
                }
                if (TexteditPswConfirm.equals(TexteditPsw) || TexteditPsw.length() >= 6) {
                    mPresenter.registerAppUser(TexteditName, TexteditTel, TexteditPsw, TexteditVerification);
                } else {
                    s(mContext, "两次密码输入不一致!");
                }

                break;
        }
    }

    public void finishPopup(View v, final String id) {
        if (contentView != null) contentView = null;
        if (popupWindow != null) popupWindow = null;
        // 一个自定义的布局，作为显示的内容

        contentView = LayoutInflater.from(mContext).inflate(R.layout.member_pop_view_edit, null);
        popupWindow = new PopupWindow(contentView, SCREEN_WIDTH - 200, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setOnDismissListener(this);


        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

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

    @Override
    public void onDismiss() {

        Intent intent = new Intent(RegisterActivity.this, SexActivity.class);
        startActivity(intent);
        finish();
    }
}

