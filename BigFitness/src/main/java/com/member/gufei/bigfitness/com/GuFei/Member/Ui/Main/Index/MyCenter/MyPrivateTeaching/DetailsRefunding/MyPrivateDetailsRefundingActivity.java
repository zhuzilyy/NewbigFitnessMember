package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.DetailsRefunding;

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
import com.member.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;

public class MyPrivateDetailsRefundingActivity extends BaseActivity<MyPrivateDetailsRefundingActivityPresenter> implements MyPrivateDetailsRefundingActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_type_name)
    TextView tvTypeName;
    @BindView(R.id.tv_class_name)
    TextView tvClassName;
    @BindView(R.id.tv_class_num)
    TextView tvClassNum;
    @BindView(R.id.tv_money_total)
    TextView tvMoneyTotal;
    @BindView(R.id.tv_coach_name)
    TextView tvCoachName;
    @BindView(R.id.tv_order_num)
    TextView tvOrderNum;
    @BindView(R.id.tv_pay_type)
    TextView tvPayType;
    @BindView(R.id.tv_buy_time)
    TextView tvBuyTime;
    @BindView(R.id.btn4)
    TextView btn4;
    private int PayMode;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_refunding_my_private;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
//
        setToolBar(toolbar, "");

        //tvTitle.setText("私教课详情");

        btnComplete.setVisibility(View.GONE);
        Intent intent = getIntent();
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        String Id = intent.getStringExtra(PUT_STR + "id");
        String OrderId = intent.getStringExtra(PUT_STR + "OrderId");
        String Status = intent.getStringExtra(PUT_STR + "Status");
        String title = intent.getStringExtra(PUT_STR + "lessonName");
        tvTitle.setText(title);
        String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
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
        tvTypeName.setText("退款申请中");
        tvClassName.setText(appBuyLessonOrderDetailBean.getRows().getLessonName());
        tvClassNum.setText(appBuyLessonOrderDetailBean.getRows().getAmount() + "节");
        tvMoneyTotal.setText(appBuyLessonOrderDetailBean.getRows().getTotalMoney() + "元");
        tvCoachName.setText(appBuyLessonOrderDetailBean.getRows().getTeacherName());
        tvOrderNum.setText(appBuyLessonOrderDetailBean.getRows().getOrderId() + "");
        PayMode = appBuyLessonOrderDetailBean.getRows().getPayMode();
        if (PayMode == 0){
            tvPayType.setText("微信");
        }else {
            tvPayType.setText("支付宝");
        }
        tvBuyTime.setText(appBuyLessonOrderDetailBean.getRows().getCreateTime());

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}


