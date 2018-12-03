package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.Active.DetailsFrozen;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.FrozenCard.FrozenCardActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.MYCARDTYPE;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;

/**
 * 我的会员卡-已冻结
 */
public class MyCardDetailsFrozenActivity extends BaseActivity<MyCardDetailsFrozenActivityPresenter> implements MyCardDetailsFrozenActivityContract.View {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.text_status)
    TextView textStatus;
    @BindView(R.id.text_id_order)
    TextView textIdOrder;
    @BindView(R.id.text_id_card)
    TextView textIdCard;
    @BindView(R.id.text_type_card)
    TextView textTypeCard;
    @BindView(R.id.text_mone_pay)
    TextView textMonePay;
    @BindView(R.id.text_number_remaining)
    TextView textNumberRemaining;
    @BindView(R.id.text_name_counselor)
    TextView textNameCounselor;

    @BindView(R.id.text_openedtime_card)
    TextView textOpenedtimeCard;
    @BindView(R.id.text_time_end)
    TextView textTimeEnd;
    @BindView(R.id.text_time_buy)
    TextView textTimeBuy;

    @BindView(R.id.text_number_frozen)
    TextView textNumberFrozen;

    @BindView(R.id.btn2)
    TextView btn2;
    @BindView(R.id.btn3)
    TextView btn3;
    @BindView(R.id.btn4)
    TextView btn4;
    @BindView(R.id.btn5)
    TextView btn5;


    int UserId ;
    String token ;
    String Id ;
    String Status ;
    String MemberCardId ;
    String ClubId;
    String ConsumeType;
    String EndTime;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_details_frozen_my_card;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
          UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
         token = (String) SpUtil.get(mContext, TOKENKEY, "");
         Id = intent.getStringExtra(PUT_STR + "id");
         Status = intent.getStringExtra(PUT_STR + "Status");
         MemberCardId = intent.getStringExtra(PUT_STR + "MemberCardId");

         ConsumeType = intent.getStringExtra(PUT_STR + "ConsumeType");
        String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        mPresenter.appGetMyMemberCardDetail(String.valueOf(UserId), ClubId, token, Status, MemberCardId, ConsumeType);

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
    public void succeed(AppGetMyMemberCardDetailBean appGetMyMemberCardDetailBean) {
//        textStatus.setText(MYCARDTYPE[appGetMyMemberCardDetailBean.getRows().getStatus()]);
        textStatus.setText(MYCARDTYPE[Integer.valueOf(appGetMyMemberCardDetailBean.getRows().getStatus())]);
        textIdOrder.setText(appGetMyMemberCardDetailBean.getRows().getBargainNo()+"");
        textIdCard.setText(appGetMyMemberCardDetailBean.getRows().getMemberCardId()+"");
        textTypeCard.setText(appGetMyMemberCardDetailBean.getRows().getMemberCardTypeName());
        textMonePay.setText(appGetMyMemberCardDetailBean.getRows().getBuyMoney()+"元");
        textNumberRemaining.setText(appGetMyMemberCardDetailBean.getRows().getBalance()+
                appGetMyMemberCardDetailBean.getRows().getTotalCount()+"次");
        textNameCounselor.setText(appGetMyMemberCardDetailBean.getRows().getMemberCardTypeName());
/*
        textOpenedtimeCard.setText(appGetMyMemberCardDetailBean.getRows().getUseTime().getYear() + "/"
                + appGetMyMemberCardDetailBean.getRows().getUseTime().getMonth() + "/"
                + appGetMyMemberCardDetailBean.getRows().getUseTime().getDay());*/

        textOpenedtimeCard.setText(appGetMyMemberCardDetailBean.getRows().getUseTime());

        textTimeEnd.setText(appGetMyMemberCardDetailBean.getRows().getExpireTime());

/*        textTimeEnd.setText(appGetMyMemberCardDetailBean.getRows().getExpireTime().getYear() + "/"
                + appGetMyMemberCardDetailBean.getRows().getExpireTime().getMonth() + "/"
                + appGetMyMemberCardDetailBean.getRows().getExpireTime().getDay());*/
        textTimeBuy.setText(appGetMyMemberCardDetailBean.getRows().getBuyTime());

        textNumberFrozen.setText(appGetMyMemberCardDetailBean.getRows().getRemainLockedCount());
    }

    @Override
    public void Refundsucceed(CodeBean codeBean) {

    }


    @OnClick({R.id.btn_back})
    public void onViewClicked(View view) {
        Intent   intent=null;
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;

        }
    }
}


