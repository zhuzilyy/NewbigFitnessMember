package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.ResetPwd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;
import com.member.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.StringUtil.isEmpty;
import static com.member.gufei.bigfitness.util.StringUtil.length;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

public class ResetPwdActivity extends BaseActivity<ResetPwdActivityPresenter> implements ResetPwdActivityContract.View {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.text_accountname)
    TextView textAccountname;
    @BindView(R.id.edit_pwd)
    EditText editPwd;
    @BindView(R.id.edit_confirm_pwd)
    EditText editConfirmPwd;
    @BindView(R.id.btn_confirm)
    TextView btnConfirm;
    @BindView(R.id.main_title)
    TextView mainTitle;
    private String AccountName;
    private String Verifica;
    private int APPUserId;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {

        return R.layout.member_activity_reset_pwd;

    }

    @Override
    protected void initView() {

        mainTitle.setText("重置密码");

        Intent intent = getIntent();
        AccountName = intent.getStringExtra(PUT_STR + "AccountName");
        Verifica = intent.getStringExtra(PUT_STR + "Verifica");
        APPUserId = intent.getIntExtra(PUT_STR + "APPUserId",1);
        textAccountname.setText(AccountName);


    }

    @Override
    protected void initData() {

    }


    @Override
    public void showEmpty() {

    }

    @Override
    public void showError(String msg) {

        s(mContext, msg);
        super.showError(msg);
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
    public void succeed(CodeBean codeBean) {
        s(mContext, codeBean.getMsg());
        Intent intent = new Intent(mContext, LoginActivity.class);
        remove();
        startActivity(intent);
    }

    @OnClick({R.id.btn_back, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_confirm:


                if (isEmpty(editPwd.getText().toString())) {
                    s(mContext, "请填写新的密码");
                    break;

                }

                if (length(editPwd.getText().toString()) > 12 || length(editPwd.getText().toString()) < 6) {
                    s(mContext, "请输入6-12位的密码");
                    break;

                }

                if (!editPwd.getText().toString().equals(editConfirmPwd.getText().toString())) {
                    s(mContext, "两次密码不一致!请重新填写");
                    break;
                }



                String token = (String) SpUtil.get(mContext, TOKENKEY, "");
                mPresenter.appUserResetPwd(AccountName, editConfirmPwd.getText().toString(), String.valueOf(APPUserId), token);

                break;
        }
    }


}
