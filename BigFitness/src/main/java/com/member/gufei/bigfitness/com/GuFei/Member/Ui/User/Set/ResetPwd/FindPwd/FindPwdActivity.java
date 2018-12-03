package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.ResetPwd.FindPwd;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.member.gufei.bigfitness.Presenter.SpinnerPopContract;
import com.member.gufei.bigfitness.Presenter.SpinnerPopupWindow;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.ResetPwd.ResetPwdActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppUserResetPwdCheckBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.VerifyCodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;
import com.member.gufei.bigfitness.util.DownTimerUtil.DownTimerInterface;
import com.member.gufei.bigfitness.util.MyCountDownTimer;
import com.member.gufei.bigfitness.util.SpUtil;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.CUSTOMERINTRODUCERID;
import static com.member.gufei.bigfitness.Constants.CUSTOMERSOURCEID;
import static com.member.gufei.bigfitness.Constants.CUSTOMERTAGID;
import static com.member.gufei.bigfitness.Constants.INTERVAL;
import static com.member.gufei.bigfitness.Constants.MEMBERINTENTID;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.RESULT_ID;
import static com.member.gufei.bigfitness.Constants.RESULT_SEX;
import static com.member.gufei.bigfitness.Constants.RESULT_STRING;
import static com.member.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.member.gufei.bigfitness.Constants.RESULT_TEL;
import static com.member.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.member.gufei.bigfitness.Constants.TIME;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.MobileUtil.isMobile;
import static com.member.gufei.bigfitness.util.MobileUtil.isPhone;
import static com.member.gufei.bigfitness.util.StringUtil.isEmpty;
import static com.member.gufei.bigfitness.util.StringUtil.length;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

public class FindPwdActivity extends BaseActivity<FindPwdActivityPresenter> implements FindPwdActivityContract.View {


    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.main_head_layout)
    RelativeLayout mainHeadLayout;
    @BindView(R.id.edit_tel_user)
    EditText editTelUser;
    @BindView(R.id.edit_verifica_tel)
    EditText editVerificaTel;
    @BindView(R.id.btn_Verification)
    TextView btnVerification;
    @BindView(R.id.btn_next)
    TextView btnNext;

    private boolean mNext = false;
    private String mAccountName = "";
    private String mVerifyCode;
    public MyCountDownTimer myCountDownTimer;
    private String TexteditVerification;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {

        return R.layout.member_activity_find_pwd;

    }

    @Override
    protected void initView() {


        mainTitle.setText("找回密码");


//
//        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
//
//        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
//
//        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
//
//        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
//
//        Intent intent = getIntent();
//
//        String CustomerId = intent.getStringExtra(PUT_STR + "CustomerId");
//
//        mPresenter.getCustomerInfoById(UserId, token, ClubId, UserName, CustomerId);


    }

    @Override
    protected void initData() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void Loading() {

    }

    @Override
    public void succeed(AppUserResetPwdCheckBean appUserResetPwdCheckBean) {
        if (appUserResetPwdCheckBean.getRet() == 0) {
            Intent intent = new Intent(mContext, ResetPwdActivity.class);
            intent.putExtra(PUT_STR + "AccountName", appUserResetPwdCheckBean.getRows().getAccountName());
            intent.putExtra(PUT_STR + "Verifica", editVerificaTel.getText().toString());
            intent.putExtra(PUT_STR + "APPUserId", appUserResetPwdCheckBean.getRows().getAPPUserId());
//                    intent.putExtra(PUT_STR + "ConsumeType", dataBean.getConsumeType());
//                    intent.putExtra(PUT_STR + "MemberCardId", dataBean.getMemberCardId());
//                    intent.putExtra(PUT_STR + "Status", dataBean.getStatus());
            startActivity(intent);
        }
    }

    @Override
    public void succeedVerifyCode(VerifyCodeBean verifyCodeBean) {
        mVerifyCode = verifyCodeBean.getVerifyCode();
    }

    @Override
    public void outLogin() {

        s(this, "您的帐号在其他设备登录");
        Intent intent = new Intent(mContext, LoginActivity.class);
        remove();
        startActivity(intent);

    }


    @OnClick({R.id.btn_back, R.id.btn_Verification, R.id.btn_next})
    public void onViewClicked(View view) {
        TexteditVerification = editVerificaTel.getText().toString();
        switch (view.getId()) {
            case R.id.btn_back:
                myCountDownTimer.cancelTimer();
                finish();
                break;
            case R.id.btn_Verification:
                TexteditVerification = editVerificaTel.getText().toString();
                if (editTelUser.getText().toString().equals("")) {
                    s(mContext, "电话不能为空!");
                    return;
                }
                String mobile=editTelUser.getText().toString();

                btnVerification.setEnabled(false);

                myCountDownTimer = new MyCountDownTimer(1 * TIME, INTERVAL);
                myCountDownTimer.setDownTimerInterface(new DownTimerInterface() {
                    @Override
                    public void setText(String time) {

                    }

                    @Override
                    public void setSecText(String time) {
                        btnVerification.setText("重新发送" + time + "");
                        if (time.equals("01")) {
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
                if (mPresenter!=null){
                    mPresenter.getVerifyCode(mobile);
                }
//                s(this,"成功发送验证码!");
                break;
            case R.id.btn_next:
                if (!isMobile(editTelUser.getText().toString())) {
                    s(mContext, "请填写正确的手机号");
                    break;
                }
                if (isEmpty(editVerificaTel.getText().toString())
                        || length(editVerificaTel.getText().toString()) != 6
                        || !TexteditVerification.equals(mVerifyCode)
                        ) {
                    s(mContext, "请填写正确的验证码");
                    break;

                }
                myCountDownTimer.cancelTimer();
                String token = (String) SpUtil.get(mContext, TOKENKEY, "");
                mPresenter.appUserResetPwdCheck(editTelUser.getText().toString(), editVerificaTel.getText().toString(), token);
                break;
        }
    }


}
