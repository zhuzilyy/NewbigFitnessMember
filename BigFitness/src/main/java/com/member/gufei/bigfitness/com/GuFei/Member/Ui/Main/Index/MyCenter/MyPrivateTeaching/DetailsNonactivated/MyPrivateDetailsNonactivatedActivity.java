package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.DetailsNonactivated;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.APPBuyLessonOrderDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;

public class MyPrivateDetailsNonactivatedActivity extends BaseActivity<MyPrivateDetailsNonactivatedActivityPresenter> implements MyPrivateDetailsNonactivatedActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_status)
    TextView textStatus;
    @BindView(R.id.text_name_lesson)
    TextView textNameLesson;
    @BindView(R.id.text_number_lesson)
    TextView textNumberLesson;
    @BindView(R.id.text_money_total)
    TextView textMoneyTotal;
    @BindView(R.id.text_coach_lesson)
    TextView textCoachLesson;
    @BindView(R.id.text_order_number)
    TextView textOrderNumber;
    @BindView(R.id.text_type_pay)
    TextView textTypePay;
    @BindView(R.id.text_time_buy)
    TextView textTimeBuy;
    @BindView(R.id.btn4)
    TextView btn4;
    private int UserId;
    private String token;
    private String ClubId;
    private String Status;
    private String OrderId;
    private int PayMode;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_nonactivated_my_private;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
//
        setToolBar(toolbar, "");

        tvTitle.setText("私教课详情");

        btnComplete.setVisibility(View.GONE);
        Intent intent = getIntent();
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        OrderId = intent.getStringExtra(PUT_STR + "OrderId");
        Status = intent.getStringExtra(PUT_STR + "Status");
        mPresenter.getMyAPPBuyLessonOrderDetailNo(String.valueOf(UserId),
                ClubId,
                OrderId,
                Status,
                token);

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

    }

    @Override
    public void succeed(APPBuyLessonOrderDetailBean appBuyLessonOrderDetailBean) {
        if (appBuyLessonOrderDetailBean.getRows().getStatus() .equals("5")){
            textStatus.setText("退款申请中");
            btn4.setVisibility(View.GONE);
        }else {
            textStatus.setText("未激活");
        }
        textNameLesson.setText(appBuyLessonOrderDetailBean.getRows().getLessonName());
        textNumberLesson.setText(appBuyLessonOrderDetailBean.getRows().getAmount() + "节");
        textMoneyTotal.setText(appBuyLessonOrderDetailBean.getRows().getTotalMoney() + "元");
        textCoachLesson.setText(appBuyLessonOrderDetailBean.getRows().getTeacherName());
        textOrderNumber.setText(appBuyLessonOrderDetailBean.getRows().getOrderId() + "");
        PayMode = appBuyLessonOrderDetailBean.getRows().getPayMode();
        if (PayMode == 0){
            textTypePay.setText("微信");
        }else {
            textTypePay.setText("支付宝");
        }

        textTimeBuy.setText(appBuyLessonOrderDetailBean.getRows().getCreateTime());
    }

    @Override
    public void succeedRefund(CodeBean codeBean) {
        finish();
    }


    @OnClick(R.id.btn4)
    public void onViewClicked() {
        mPresenter.getAppMyMemberLessonApplyRefund(String.valueOf(UserId),
                ClubId,
                token,
                OrderId);
    }
}


