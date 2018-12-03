package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.TelVerify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.member.gufei.bigfitness.Presenter.SpinnerPopContract;
import com.member.gufei.bigfitness.Presenter.SpinnerPopupWindow;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.VerifyCodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;
import com.member.gufei.bigfitness.util.DownTimerUtil.DownTimerInterface;
import com.member.gufei.bigfitness.util.MyCountDownTimer;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.INTERVAL;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.TIME;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.StringUtil.length;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

public class TelVerifyActivity extends BaseActivity<TelVerifyActivityPresenter> implements SpinnerPopContract, TelVerifyActivityContract.View {


    @BindView(R.id.main_title)
    TextView tvTitle;
    @BindView(R.id.btn_edit)
    TextView btnEdit;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.edit_tel)
    EditText editTel;
    @BindView(R.id.edit_verification)
    EditText editVerification;
    @BindView(R.id.btn_Verification)
    TextView btnVerification;
    @BindView(R.id.text_tel_old)
    TextView textTelOld;
    @BindView(R.id.btn_next)
    ImageView btnNext;

    String mId = "";


    String mTel = "";

    private String mVerifyCode = "";
    public MyCountDownTimer myCountDownTimer;
    private String TexteditTel;
    private String TexteditVerification;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    /**
     * @return
     */
    @Override
    protected int getLayout() {

        return R.layout.member_activity_verify_tel;

    }

    @Override
    protected void initView() {

//        toolbar.setNavigationIcon(R.mipmap.left);
//
//        setToolBar(toolbar, "");

        tvTitle.setText("验证手机号");

        btnEdit.setVisibility(View.INVISIBLE);

//        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
//
//        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
//
//        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
//
//        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
//
        Intent intent = getIntent();
//
        String mTel = intent.getStringExtra(PUT_STR + "Tel");

        textTelOld.setText("当前手机号:" + mTel.substring(0, 3) + " " + mTel.substring(3, 7) + " " + mTel.substring(7, 11));


//        当前手机号: 136 2020 0303
//
//         mPresenter.getCustomerInfoById(UserId, token, ClubId, UserName, CustomerId);


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
    public void outLogin() {

        s(this, "您的帐号在其他设备登录");
        Intent intent = new Intent(mContext, LoginActivity.class);
        remove();

        startActivity(intent);

    }


    @Override
    public void dismiss() {
        backgroundAlpha(1f);
    }


    @Override
    public void Success(VerifyCodeBean verifyCodeBean) {
        if (verifyCodeBean.getRet() == 0) {
            mVerifyCode = verifyCodeBean.getVerifyCode();
        }

    }

    @Override
    public void succeedEdit(CodeBean codeBean) {

    }

    @Override
    protected void onDestroy() {
        if (myCountDownTimer != null)
            myCountDownTimer.cancelTimer();
        super.onDestroy();
    }

    @OnClick({R.id.btn_Verification, R.id.btn_next,R.id.btn_back})
    public void onViewClicked(View view) {
        TexteditTel = editTel.getText().toString();
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
                        btnVerification.setText("重新发送" + time );
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
                mPresenter.getVerifyCode(TexteditTel);
                break;
            case R.id.btn_next:


                if (TexteditTel.equals("")) {
                    s(mContext, "电话不能为空!");
                    break;
                }


                if (mVerifyCode.equals("") || !mVerifyCode.equals(TexteditVerification) || length(TexteditVerification) != 6) {
                    s(mContext, "请输入正确的验证码!");
                    break;
                }
                int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
                mPresenter.updateAPPUserMobile(String.valueOf(UserId), TexteditTel, TexteditVerification);
                break;
                case R.id.btn_back:
                    myCountDownTimer.cancelTimer();
                        finish();
                break;
        }
    }
}
