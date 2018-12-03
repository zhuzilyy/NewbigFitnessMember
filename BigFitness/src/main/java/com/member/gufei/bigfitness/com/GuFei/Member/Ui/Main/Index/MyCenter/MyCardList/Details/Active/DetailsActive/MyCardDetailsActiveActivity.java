package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.Active.DetailsActive;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.CardEvaluationing.CardEvaluationingActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.FrozenCard.FrozenCardActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.NumberCard.Renewal.MyCardRenewalActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.UpGradeCard.UpGradeCardActivity;
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
import static com.member.gufei.bigfitness.util.ToastUtil.s;

/**
 * 我的会员卡-激活
 */
public class MyCardDetailsActiveActivity extends BaseActivity<MyCardDetailsActiveActivityPresenter> implements MyCardDetailsActiveActivityContract.View {


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
    @BindView(R.id.text_number_frozen)
    TextView textNumberFrozen;
    @BindView(R.id.text_openedtime_card)
    TextView textOpenedtimeCard;
    @BindView(R.id.text_time_end)
    TextView textTimeEnd;
    @BindView(R.id.text_time_buy)
    TextView textTimeBuy;
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
    int MemberCardTypeId;
    String MemberCardTypeName;
    String ExpireTime;
    int RemainUseCount;
    int Minimum;


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_details_active_my_card;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
          UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
         token = (String) SpUtil.get(mContext, TOKENKEY, "");
         Id = intent.getStringExtra(PUT_STR + "Id");
         Status = intent.getStringExtra(PUT_STR + "Status");
         MemberCardId = intent.getStringExtra(PUT_STR + "MemberCardId");

         ConsumeType = intent.getStringExtra(PUT_STR + "ConsumeType");
         Minimum = intent.getIntExtra(PUT_STR + "Minimum", 0);
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
        textStatus.setText(MYCARDTYPE[Integer.valueOf(appGetMyMemberCardDetailBean.getRows().getStatus())]);
        MemberCardTypeId = appGetMyMemberCardDetailBean.getRows().getMemberCardTypeId();
        MemberCardTypeName = appGetMyMemberCardDetailBean.getRows().getMemberCardTypeName();
        ExpireTime = appGetMyMemberCardDetailBean.getRows().getExpireTime();
        RemainUseCount = appGetMyMemberCardDetailBean.getRows().getRemainUseCount();


        textIdOrder.setText(appGetMyMemberCardDetailBean.getRows().getBargainNo()+"");
        textIdCard.setText(appGetMyMemberCardDetailBean.getRows().getMemberCardId()+"");
        textTypeCard.setText(MemberCardTypeName);
        textMonePay.setText(appGetMyMemberCardDetailBean.getRows().getBuyMoney()+"元");
        textNumberRemaining.setText(appGetMyMemberCardDetailBean.getRows().getBalance()+"天");
        textNameCounselor.setText(appGetMyMemberCardDetailBean.getRows().getOwnManagerName());
        textNumberFrozen.setText(appGetMyMemberCardDetailBean.getRows().getRemainLockedCount()+"");
        textOpenedtimeCard.setText(appGetMyMemberCardDetailBean.getRows().getUseTime());
        textTimeEnd.setText(ExpireTime);
//        textOpenedtimeCard.setText(appGetMyMemberCardDetailBean.getRows().getUseTime().getYear() + "/"
//                + appGetMyMemberCardDetailBean.getRows().getUseTime().getMonth() + "/"
//                + appGetMyMemberCardDetailBean.getRows().getUseTime().getDay());
//
//        textTimeEnd.setText(appGetMyMemberCardDetailBean.getRows().getExpireTime().getYear() + "/"
//                + appGetMyMemberCardDetailBean.getRows().getExpireTime().getMonth() + "/"
//                + appGetMyMemberCardDetailBean.getRows().getExpireTime().getDay());
        textTimeBuy.setText(appGetMyMemberCardDetailBean.getRows().getBuyTime());
        btn2.setVisibility(appGetMyMemberCardDetailBean.getRows().getIsAllowUp() == 1 ? View.VISIBLE : View.GONE);
        btn3.setVisibility(appGetMyMemberCardDetailBean.getRows().getIsAllowLock() == 1 ? View.VISIBLE : View.GONE);
        btn4.setVisibility(appGetMyMemberCardDetailBean.getRows().getIsAllowAddFee() == 1 ? View.VISIBLE : View.GONE);
        btn5.setVisibility(appGetMyMemberCardDetailBean.getRows().getIsEvaluate() == 1 ? View.VISIBLE : View.GONE);

    }

    @Override
    public void Refundsucceed(CodeBean codeBean) {

    }


    @OnClick({R.id.btn_back, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5})
    public void onViewClicked(View view) {
        Intent   intent=null;
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn2:

                intent   = new Intent(mContext, UpGradeCardActivity.class);
                intent.putExtra(PUT_STR + "MemberCardId",MemberCardId);
                intent.putExtra(PUT_STR + "MemberCardType",textTypeCard.getText());
                intent.putExtra(PUT_STR + "NumberRemaining",textNumberRemaining.getText());
                intent.putExtra(PUT_STR + "Id",Id);

                intent.putExtra(PUT_STR + "TimeExpire",textTimeEnd.getText());
//                intent.putExtra(PUT_STR + "ConsumeType", dataBean.getConsumeType());
//                intent.putExtra(PUT_STR + "MemberCardId", dataBean.getMemberCardId());
//                intent.putExtra(PUT_STR + "Status", dataBean.getStatus());
                startActivity(intent);
                break;
            case R.id.btn3:

                intent   = new Intent(mContext, FrozenCardActivity.class);
                intent.putExtra(PUT_STR + "MemberCardId",MemberCardId);
                intent.putExtra(PUT_STR + "MemberCardType",textTypeCard.getText());
                intent.putExtra(PUT_STR + "NumberRemaining",textNumberRemaining.getText());
                intent.putExtra(PUT_STR + "Id",Id);

                intent.putExtra(PUT_STR + "TimeExpire",textTimeEnd.getText());
//                intent.putExtra(PUT_STR + "ConsumeType", dataBean.getConsumeType());
//                intent.putExtra(PUT_STR + "MemberCardId", dataBean.getMemberCardId());
//                intent.putExtra(PUT_STR + "Status", dataBean.getStatus());
                startActivity(intent);
//                mPresenter.appMyMemberCardApplyRefund(String.valueOf(UserId), ClubId, token, Id);
                break;
            case R.id.btn4:
                intent = new Intent(mContext, MyCardRenewalActivity.class);
                intent.putExtra(PUT_STR + "MemberCardId", MemberCardId);
                intent.putExtra(PUT_STR + "MemberCardType",String.valueOf(MemberCardTypeId));
                intent.putExtra(PUT_STR + "ConsumeType", ConsumeType);
                intent.putExtra(PUT_STR + "MemberCardTypeName", MemberCardTypeName);
                intent.putExtra(PUT_STR + "Id",Id);
                intent.putExtra(PUT_STR + "ExpireTime", ExpireTime);
                intent.putExtra(PUT_STR + "RemainUseCount", RemainUseCount);
                intent.putExtra(PUT_STR + "Status",Status);
                intent.putExtra(PUT_STR + "Minimum", Minimum);
                startActivity(intent);
                break;
            case R.id.btn5:
//
                intent   = new Intent(mContext, CardEvaluationingActivity.class);
                intent.putExtra(PUT_STR + "MemberCardId",MemberCardId);
                intent.putExtra(PUT_STR + "MemberCardType",textTypeCard.getText());
                intent.putExtra(PUT_STR + "NumberRemaining",textNumberRemaining.getText());
                intent.putExtra(PUT_STR + "Id",Id);
                intent.putExtra(PUT_STR + "TimeExpire",textTimeEnd.getText());
//                intent.putExtra(PUT_STR + "ConsumeType", dataBean.getConsumeType());
//                intent.putExtra(PUT_STR + "MemberCardId", dataBean.getMemberCardId());
//                intent.putExtra(PUT_STR + "Status", dataBean.getStatus());
                startActivity(intent);
//                mPresenter.appMyMemberCardApplyRefund(String.valueOf(UserId), ClubId, token, Id);
                break;
        }
    }
}


