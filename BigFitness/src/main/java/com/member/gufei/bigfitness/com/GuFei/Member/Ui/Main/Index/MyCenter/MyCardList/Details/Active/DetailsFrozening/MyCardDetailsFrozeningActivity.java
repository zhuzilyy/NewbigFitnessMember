package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.Active.DetailsFrozening;

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
import static com.member.gufei.bigfitness.util.ToastUtil.s;

/**
 * 我的会员卡-冻结申请中
 */
public class MyCardDetailsFrozeningActivity extends BaseActivity<MyCardDetailsFrozeningActivityPresenter> implements MyCardDetailsFrozeningActivityContract.View {


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

    @BindView(R.id.btn5)
    TextView btn5;


    int UserId;
    String token;
    String Id;
    String Status;
    String MemberCardId;
    String ClubId;
    String ConsumeType;
    String EndTime;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_details_frozening_my_card;
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
        ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
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
        textIdOrder.setText(appGetMyMemberCardDetailBean.getRows().getBargainNo() + "");
        textIdCard.setText(appGetMyMemberCardDetailBean.getRows().getMemberCardId() + "");
        textTypeCard.setText(appGetMyMemberCardDetailBean.getRows().getMemberCardTypeName());
        textMonePay.setText(appGetMyMemberCardDetailBean.getRows().getBuyMoney() + "元");
        textNumberRemaining.setText(appGetMyMemberCardDetailBean.getRows().getBalance() +
                appGetMyMemberCardDetailBean.getRows().getTotalCount() + "次");
        textNameCounselor.setText(appGetMyMemberCardDetailBean.getRows().getOwnManagerName());

        textOpenedtimeCard.setText(appGetMyMemberCardDetailBean.getRows().getUseTime());

        textTimeEnd.setText(appGetMyMemberCardDetailBean.getRows().getExpireTime());



    /*    textOpenedtimeCard.setText(appGetMyMemberCardDetailBean.getRows().getUseTime().getYear() + "/"
                + appGetMyMemberCardDetailBean.getRows().getUseTime().getMonth() + "/"
                + appGetMyMemberCardDetailBean.getRows().getUseTime().getDay());

        textTimeEnd.setText(appGetMyMemberCardDetailBean.getRows().getExpireTime().getYear() + "/"
                + appGetMyMemberCardDetailBean.getRows().getExpireTime().getMonth() + "/"
                + appGetMyMemberCardDetailBean.getRows().getExpireTime().getDay());*/
        textTimeBuy.setText(appGetMyMemberCardDetailBean.getRows().getBuyTime());

        textNumberFrozen.setText(appGetMyMemberCardDetailBean.getRows().getRemainLockedCount()+"次");


    }

    @Override
    public void Refundsucceed(CodeBean codeBean) {
        s(mContext, "冻结申请成功!");
        finish();
    }

    @Override
    public void SendMsgsucceed(CodeBean codeBean) {
        s(mContext, "催办申请成功!");
        finish();
    }

    @OnClick({R.id.btn_back, R.id.btn5})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
//            case R.id.btn2:
//
//                intent   = new Intent(mContext, UpGradeCardActivity.class);
//                intent.putExtra(PUT_STR + "MemberCardId",MemberCardId);
//                intent.putExtra(PUT_STR + "MemberCardType",textTypeCard.getText());
//                intent.putExtra(PUT_STR + "NumberRemaining",textNumberRemaining.getText());
//                intent.putExtra(PUT_STR + "Id",Id);
//
//                intent.putExtra(PUT_STR + "TimeExpire",textTimeEnd.getText());
////                intent.putExtra(PUT_STR + "ConsumeType", dataBean.getConsumeType());
////                intent.putExtra(PUT_STR + "MemberCardId", dataBean.getMemberCardId());
////                intent.putExtra(PUT_STR + "Status", dataBean.getStatus());
//                startActivity(intent);
//                break;
//            case R.id.btn3:
//                intent   = new Intent(mContext, FrozenCardActivity.class);
//              intent.putExtra(PUT_STR + "MemberCardId",MemberCardId);
//              intent.putExtra(PUT_STR + "MemberCardType",textTypeCard.getText());
//              intent.putExtra(PUT_STR + "NumberRemaining",textNumberRemaining.getText());
//              intent.putExtra(PUT_STR + "Id",Id);
//
//              intent.putExtra(PUT_STR + "TimeExpire",textTimeEnd.getText());
////                intent.putExtra(PUT_STR + "ConsumeType", dataBean.getConsumeType());
////                intent.putExtra(PUT_STR + "MemberCardId", dataBean.getMemberCardId());
////                intent.putExtra(PUT_STR + "Status", dataBean.getStatus());
//                startActivity(intent);
//                break;
//            case R.id.btn4:
//                break;
            case R.id.btn5:
                mPresenter.appMemberCardLockSendMsg(String.valueOf(UserId), ClubId, token, MemberCardId);
                break;
        }
    }
}


