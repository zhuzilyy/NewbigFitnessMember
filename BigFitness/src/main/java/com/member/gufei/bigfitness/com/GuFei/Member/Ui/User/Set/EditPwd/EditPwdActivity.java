package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.EditPwd;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.member.gufei.bigfitness.Presenter.SpinnerPopContract;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.ResetPwd.ResetPwdActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.TelVerify.TelVerifyActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.PwdCheckBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;
import com.member.gufei.bigfitness.util.SpUtil;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.App.SCREEN_WIDTH;
import static com.member.gufei.bigfitness.Constants.ACCOUNTKEY;
import static com.member.gufei.bigfitness.Constants.CUSTOMERINTRODUCERID;
import static com.member.gufei.bigfitness.Constants.CUSTOMERSOURCEID;
import static com.member.gufei.bigfitness.Constants.CUSTOMERTAGID;
import static com.member.gufei.bigfitness.Constants.MEMBERINTENTID;
import static com.member.gufei.bigfitness.Constants.MOBLIEKEY;
import static com.member.gufei.bigfitness.Constants.NICKNAMEKEY;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.RESULT_ID;
import static com.member.gufei.bigfitness.Constants.RESULT_STRING;
import static com.member.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.member.gufei.bigfitness.Constants.RESULT_TEL;
import static com.member.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

public class EditPwdActivity extends BaseActivity<EditPwdActivityPresenter> implements SpinnerPopContract, EditPwdActivityContract.View {


    @BindView(R.id.main_title)
    TextView tvTitle;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.main_head_layout)
    RelativeLayout mainHeadLayout;
    @BindView(R.id.edit_psw_img)
    ImageView editPswImg;
    @BindView(R.id.text_pwd_edit)
    EditText textPwdEdit;
    @BindView(R.id.edit_psw_btn)
    RelativeLayout editPswBtn;
    @BindView(R.id.edit_tel_img)
    ImageView editTelImg;
    @BindView(R.id.text_tel_user)
    EditText textTelUser;
    @BindView(R.id.edit_tel_btn)
    RelativeLayout editTelBtn;
//    @BindView(R.id.edit_protocol_img)
//    ImageView editProtocolImg;
//    @BindView(R.id.edit_protocol_btn)
//    RelativeLayout editProtocolBtn;
//    @BindView(R.id.edit_about_img)
//    ImageView editAboutImg;
//    @BindView(R.id.edit_about_btn)
//    RelativeLayout editAboutBtn;
    @BindView(R.id.btn_exit)
    TextView btnExit;
    @BindView(R.id.activity_address_details)
    LinearLayout activityAddressDetails;


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {

        return R.layout.member_activity_edit_pwd;

    }

    @Override
    protected void initView() {

//        toolbar.setNavigationIcon(R.mipmap.left);
//
//        setToolBar(toolbar, "");

        tvTitle.setText("设置");
        textTelUser.setText(SpUtil.get(mContext, MOBLIEKEY, "").toString());

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
    public void Success(CustomerInfoBean customerInfoBean) {

//        userName.setText(customerInfoBean.getResult().getCustomerName());
//
//        collectionUserTel.setText(customerInfoBean.getResult().getTel());
//        oldTel=customerInfoBean.getResult().getTel();
//        int sex = customerInfoBean.getResult().getSex();
//
//        userSxy.setText(sex == 1 ? "男" : "女");
//        mUserName = userName.getText().toString();
//        mUserSex = userSxy.getText().toString();
//
//
//        references.setText(customerInfoBean.getResult().getIntroduceMemberName());
//
//        customerSource.setText(customerInfoBean.getResult().getSourceName());
//
//        customerWill.setText(customerInfoBean.getResult().getIntentName());
//
//        customerIdentification.setText(customerInfoBean.getResult().getLabelName());
//
//
//        collectors.setText(customerInfoBean.getResult().getCreateUserName());
//
//        membershipConsultant.setText(customerInfoBean.getResult().getOwnManagerName());
//
//        cardType.setText(customerInfoBean.getResult().getMemberCardTypeName());
//
//        prepareMoney.setText(customerInfoBean.getResult().getPreSaleMoney());
//
//        noteContent.setText(customerInfoBean.getResult().getRemark());
//
//        CustomerId = String.valueOf(customerInfoBean.getResult().getCustomerId());
//
//        mId = String.valueOf(customerInfoBean.getResult().getIntentId());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_back, R.id.edit_psw_btn, R.id.edit_tel_img,  R.id.btn_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.edit_psw_btn:
                EditPwdPopup(view, "0");
                break;
            case R.id.edit_tel_img:
                String UserName = (String) SpUtil.get(mContext, ACCOUNTKEY, "");
                String   mTel = (String) SpUtil.get(mContext, MOBLIEKEY, "");
                Intent intent = new Intent(mContext, TelVerifyActivity.class);

                intent.putExtra(PUT_STR + "Tel", mTel);
                startActivity(intent);

                break;
//            case R.id.edit_about_btn:
//                break;
            case R.id.btn_exit:
                SpUtil.clear(this);
                Intent intent1=new Intent(EditPwdActivity.this,LoginActivity.class);
                startActivity(intent1);
                finish();
                break;
        }
    }

    @Override
    public void succeed(PwdCheckBean normalResponse) {
        if (normalResponse.getRet() == 0) {
            //
            String UserName = (String) SpUtil.get(mContext, ACCOUNTKEY, "");
            int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
            Intent intent = new Intent(mContext, ResetPwdActivity.class);
            intent.putExtra(PUT_STR + "AccountName", UserName);
            intent.putExtra(PUT_STR + "APPUserId", UserId);
            startActivity(intent);

        }
    }

    public void EditPwdPopup(View v, final String id) {
        if (contentView != null) contentView = null;
        if (popupWindow != null) popupWindow = null;
        // 一个自定义的布局，作为显示的内容

        contentView = LayoutInflater.from(mContext).inflate(R.layout.member_pop_view_edit, null);
        popupWindow = new PopupWindow(contentView, SCREEN_WIDTH - 200, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
//                backgroundAlpha(1f);
            }
        });

        final TextView textResult = (TextView) contentView.findViewById(R.id.text_result);
        final TextView btnConfirm = (TextView) contentView.findViewById(R.id.btn_confirm);
        final TextView btnCancel = (TextView) contentView.findViewById(R.id.btn_cancel);
        final EditText editPwdOld = (EditText) contentView.findViewById(R.id.edit_pwd_old);
        textResult.setText("请填写原密码");
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

                btnConfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editPwdOld.getText().toString().equals("")) {
                            s(mContext, "请输入原密码");

                            return;
                        } else {

                            int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
                            String token = (String) SpUtil.get(mContext, TOKENKEY, "");
                            String PwdOld = editPwdOld.getText().toString();
                            mPresenter.PwdCheck(String.valueOf(UserId), PwdOld, token);

                        }

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

}
