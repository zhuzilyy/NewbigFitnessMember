package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.NoActive.DetailsNotActive;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyAPPBuyCardOrderDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.MYCARDTYPE;
import static com.member.gufei.bigfitness.Constants.PAYTYPE;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

/**
 *
 *
 * 我的会员卡-未激活
 */
public class MyCardDetailsNotActiveActivity extends BaseActivity<MyCardDetailsNotActiveActivityPresenter> implements MyCardDetailsNotActiveActivityContract.View {



    @BindView(R.id.text_status)
    TextView textStatus;
    @BindView(R.id.text_type)
    TextView textType;
    @BindView(R.id.text_money_total)
    TextView textMoneyTotal;
    @BindView(R.id.text_id_order)
    TextView textIdOrder;
    @BindView(R.id.text_type_pay)
    TextView textTypePay;
    @BindView(R.id.text_time_buy)
    TextView textTimeBuy;
    @BindView(R.id.text_many)
    TextView text_many;
    @BindView(R.id.text_many2)
    TextView text_many2;
    @BindView(R.id.text_many3)
    TextView text_many3;
    @BindView(R.id.btn5)
    TextView btn5;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.ll_year)
    LinearLayout ll_year;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_details_noactive_my_card;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        String Id = intent.getStringExtra(PUT_STR + "Id");
        String Status = intent.getStringExtra(PUT_STR + "Status");

        String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        mPresenter.appGetMyAPPBuyCardOrderDetail(String.valueOf(UserId), ClubId, token, Id, Status);

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
    public void succeed(AppGetMyAPPBuyCardOrderDetailBean appGetMyAPPBuyCardOrderDetailBean) {

        textStatus.setText(MYCARDTYPE[appGetMyAPPBuyCardOrderDetailBean.getRows().getStatus()]);
        textType.setText(appGetMyAPPBuyCardOrderDetailBean.getRows().getMemberCardTypeName());
        textMoneyTotal.setText(appGetMyAPPBuyCardOrderDetailBean.getRows().getTotalMoney() + "元");
        textIdOrder.setText(appGetMyAPPBuyCardOrderDetailBean.getRows().getOrderId());
        textTypePay.setText(PAYTYPE[appGetMyAPPBuyCardOrderDetailBean.getRows().getPayMode()]);
        textTimeBuy.setText(appGetMyAPPBuyCardOrderDetailBean.getRows().getBuyTime());
        if(appGetMyAPPBuyCardOrderDetailBean.getRows().getConsumeType()==0){
           ll_year.setVisibility(View.GONE);

        }else {
            ll_year.setVisibility(View.VISIBLE);
            text_many.setText(appGetMyAPPBuyCardOrderDetailBean.getRows().getAmount()+"");
            text_many2.setText(appGetMyAPPBuyCardOrderDetailBean.getRows().getActiveCount()+"");
            text_many3.setText((appGetMyAPPBuyCardOrderDetailBean.getRows().getAmount()-appGetMyAPPBuyCardOrderDetailBean.getRows().getActiveCount())+"");
        }
//        ll_year

    }


    @Override
    public void Refundsucceed(CodeBean codeBean) {

        if (codeBean.getRet()==0){
            s(mContext,"退款申请成功!");
            finish();
        }

    }



    @OnClick({R.id.btn_back, R.id.btn5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn5:

                Intent intent = getIntent();
                int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
                String token = (String) SpUtil.get(mContext, TOKENKEY, "");
                String Id = intent.getStringExtra(PUT_STR + "Id");
                String Status = intent.getStringExtra(PUT_STR + "Status");

                String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
                mPresenter.appMyMemberCardApplyRefund(String.valueOf(UserId), ClubId, token, Id);
                break;
        }
    }
}


