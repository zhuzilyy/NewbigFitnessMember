package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.BuyCard.TimeCard.TimeCardForBuy;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.BuyCard.TimeCard.RenewalOrder.TimeCardRenewalOrderForBuyCardActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubMemberCardTypeDetailBean;
import com.member.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.ID_CARD_BUY;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.RESULT_ID;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.LoadImage.loadBgImg;

/**
 * 购买会员卡
 */
public class TimeCardForBuyActivity extends BaseActivity<TimeCardForBuyActivityPresenter> implements TimeCardForBuyActivityContract.View {


    int UserId;
    String token;
    String Id;
    String Status;
    String MemberCardId;
    String ClubId;
    String ConsumeType; //卡类型
    String EndTime;
    String MemberCardTypeId;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.img_bananr)
    ImageView imgBananr;
    @BindView(R.id.text_name_card)
    TextView textNameCard;
    @BindView(R.id.text_type_card)
    TextView textTypeCard;
    @BindView(R.id.text_money_card)
    TextView textMoneyCard;
    @BindView(R.id.text_time_card)
    TextView textTimeCard;
    @BindView(R.id.text_frozen_card)
    TextView textFrozenCard;
    @BindView(R.id.text_content_card)
    TextView textContentCard;
    @BindView(R.id.btn_submit)
    TextView btnSubmit;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_details_time_forbuy_card;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        Id = intent.getStringExtra(PUT_STR + "MemberCardTypeId");
        Status = intent.getStringExtra(PUT_STR + "Status");
        MemberCardId = intent.getStringExtra(PUT_STR + "MemberCardId");
        textTypeCard.setText("时卡");
        ConsumeType = intent.getStringExtra(PUT_STR + "ConsumeType");
        MemberCardTypeId = intent.getStringExtra(PUT_STR + "MemberCardTypeId");
        String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        mPresenter.getClubMemberCardTypeDetail(String.valueOf(UserId), token, ClubId, Id);

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
    public void succeed(ClubMemberCardTypeDetailBean clubMemberCardTypeDetailBean) {


        textNameCard.setText(clubMemberCardTypeDetailBean.getRows().getMemberCardTypeName());

        textMoneyCard.setText(clubMemberCardTypeDetailBean.getRows().getPrice()+"");
        textTimeCard.setText(clubMemberCardTypeDetailBean.getRows().getAmount()+"");
        textFrozenCard.setText(clubMemberCardTypeDetailBean.getRows().getLockCount()+"");
        textContentCard.setText(clubMemberCardTypeDetailBean.getRows().getIntroduce());
        loadBgImg(mContext,clubMemberCardTypeDetailBean.getRows().getImageURL(),R.mipmap.img_bg_bananr,imgBananr);


    }



    @OnClick({R.id.btn_back, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_submit:
                Intent Cashier = new Intent(mContext, TimeCardRenewalOrderForBuyCardActivity.class);
                Cashier.putExtra(PUT_STR + "MemberCardId", MemberCardId);
                Cashier.putExtra(PUT_STR + "TypeId", ID_CARD_BUY);
                Cashier.putExtra(PUT_STR + "titleInfoBuy", "购买会员卡");
                Cashier.putExtra(PUT_STR + "textInfoBuy", textNameCard.getText().toString());
                Cashier.putExtra(PUT_STR + "TitleForFirst", "购买张数");
                Cashier.putExtra(PUT_STR + "TextForFirst", 1);
                Cashier.putExtra(PUT_STR + "IdForSecond", "");
                Cashier.putExtra(PUT_STR + "TitleForSecond", "单张价格");
                Cashier.putExtra(PUT_STR + "TextForSecond",textMoneyCard.getText().toString());
                Cashier.putExtra(PUT_STR + "textMoneyTotal", textMoneyCard.getText().toString());
                Cashier.putExtra(PUT_STR + "ConsumeType", ConsumeType);
                Cashier.putExtra(PUT_STR + "MemberCardTypeId", MemberCardTypeId);
                Cashier.putExtra(RESULT_ID, "9999");
                startActivityForResult(Cashier, 9999);

                break;
        }
    }
}


