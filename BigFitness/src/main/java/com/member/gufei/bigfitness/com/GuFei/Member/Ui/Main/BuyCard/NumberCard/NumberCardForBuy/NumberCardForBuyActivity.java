package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.BuyCard.NumberCard.NumberCardForBuy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.AdaptionLinearLayoutManager;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.BuyCard.NumberCard.RenewalOrder.NumberCardRenewalOrderActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.BuyCard.TimeCard.RenewalOrder.TimeCardRenewalOrderForBuyCardActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubMemberCardTypeDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ItemPayBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.widget.LinearLayout.VERTICAL;
import static com.member.gufei.bigfitness.Constants.ID_CARD_BUY;
import static com.member.gufei.bigfitness.Constants.ID_PRIVATE_CLASS;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.RESULT_ID;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.LoadImage.loadBgImg;

/**
 * 购买会员卡
 */
public class NumberCardForBuyActivity extends BaseActivity<NumberCardForBuyActivityPresenter> implements NumberCardForBuyActivityContract.View {


    int UserId;
    String token;
    String Id;
    String Status;
    String MemberCardId;
    String ClubId;
    String ConsumeType;
    String EndTime;
    @BindView(R.id.img_bananr)
    ImageView imgBananr;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.text_name_card)
    TextView textNameCard;
    @BindView(R.id.text_type_card)
    TextView textTypeCard;
    @BindView(R.id.text_content)
    TextView textContent;
    @BindView(R.id.text_money)
    TextView textMoney;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.text_number_min)
    TextView textNumberMin;
    @BindView(R.id.text_content_card)
    TextView textContentCard;
    @BindView(R.id.btn_submit)
    TextView btnSubmit;
    private List<ItemPayBean.PriceListBean> datas = new ArrayList<ItemPayBean.PriceListBean>();
    private List<ItemPayBean.PriceListBean> Paydatas = new ArrayList<ItemPayBean.PriceListBean>();
    private CommonAdapter<ItemPayBean.PriceListBean> commonAdapter;
    private String InfoBuy;
    private int mMinNum;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_details_number_forbuy_card;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        Id = intent.getStringExtra(PUT_STR + "MemberCardTypeId");
        Status = intent.getStringExtra(PUT_STR + "Status");
        MemberCardId = intent.getStringExtra(PUT_STR + "MemberCardId");
        textTypeCard.setText("次卡");
        ConsumeType = intent.getStringExtra(PUT_STR + "ConsumeType");
        String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        mPresenter.getClubMemberCardTypeDetail(String.valueOf(UserId), token, ClubId, Id);
        datas = new ArrayList<>();
        commonAdapter = new CommonAdapter<ItemPayBean.PriceListBean>(R.layout.member_item_unit_pay_card, mContext, datas) {
            @Override
            protected void convert(ViewHolder holder, final ItemPayBean.PriceListBean msgBean, int position) {
                holder.setText(R.id.text_content, msgBean.getMinAmount() + "-" + msgBean.getMaxAmount() + "节");
                holder.setText(R.id.text_money, msgBean.getPrice() + "");
            }
        };
        recyclerView.setAdapter(commonAdapter);

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




        InfoBuy=clubMemberCardTypeDetailBean.getData().getMemberCardTypeName();
        textNameCard.setText(InfoBuy);


        mMinNum=clubMemberCardTypeDetailBean.getData().getOnlineBuyMinAmount();
        textNumberMin.setText(mMinNum + "");
        textContentCard.setText(clubMemberCardTypeDetailBean.getData().getIntroduce());
        loadBgImg(mContext, clubMemberCardTypeDetailBean.getData().getImageURL(), R.mipmap.img_bg_bananr, imgBananr);


        if (clubMemberCardTypeDetailBean.getPriceList().size() > 1) {

            textContent.setText(clubMemberCardTypeDetailBean.getPriceList().get(0).getStartAmount()
                    + "-" + clubMemberCardTypeDetailBean.getPriceList().get(0).getEndAmount() + "节");
            textMoney.setText(clubMemberCardTypeDetailBean.getPriceList().get(0).getPrice() + "");
            ItemPayBean.PriceListBean PayBean = new ItemPayBean.PriceListBean();
            PayBean.setMaxAmount(clubMemberCardTypeDetailBean.getPriceList().get(0).getEndAmount());
            PayBean.setMinAmount(clubMemberCardTypeDetailBean.getPriceList().get(0).getStartAmount());
            PayBean.setPrice(clubMemberCardTypeDetailBean.getPriceList().get(0).getPrice());
            Paydatas.add(PayBean);

            try {
                for (int i =clubMemberCardTypeDetailBean.getPriceList().size()-1; i >0 ; i--) {
                    ItemPayBean.PriceListBean bean = new ItemPayBean.PriceListBean();
                    bean.setMaxAmount(clubMemberCardTypeDetailBean.getPriceList().get(i).getEndAmount());
                    bean.setMinAmount(clubMemberCardTypeDetailBean.getPriceList().get(i).getStartAmount());
                    bean.setPrice(clubMemberCardTypeDetailBean.getPriceList().get(i).getPrice());
                    datas.add(bean);
                    Paydatas.add(bean);
                }

                commonAdapter.replaceData(datas);
                final AdaptionLinearLayoutManager layoutManager = new AdaptionLinearLayoutManager(mContext, VERTICAL, true, datas.size()) {
                    @Override
                    public boolean canScrollVertically() {
                        //{｝内部分可以开启滑动
                        return false;
                    }
                };
                layoutManager.setAutoMeasureEnabled(false);
                recyclerView.setLayoutManager(layoutManager);
                commonAdapter.setShowFooter(false);


            } catch (Exception e) {
                e.printStackTrace();

            }
        } else if (clubMemberCardTypeDetailBean.getPriceList().size() ==1) {
            textContent.setText(clubMemberCardTypeDetailBean.getPriceList().get(0).getStartAmount()
                    + "-" + clubMemberCardTypeDetailBean.getPriceList().get(0).getEndAmount() + "节");
            textMoney.setText(clubMemberCardTypeDetailBean.getPriceList().get(0).getPrice() + "");
            ItemPayBean.PriceListBean PayBean = new ItemPayBean.PriceListBean();
            PayBean.setMaxAmount(clubMemberCardTypeDetailBean.getPriceList().get(0).getEndAmount());
            PayBean.setMinAmount(clubMemberCardTypeDetailBean.getPriceList().get(0).getStartAmount());
            PayBean.setPrice(clubMemberCardTypeDetailBean.getPriceList().get(0).getPrice());
            Paydatas.add(PayBean);

        }else{

            textContent.setText("0节");
            textMoney.setText( "0");
            ItemPayBean.PriceListBean PayBean = new ItemPayBean.PriceListBean();
            PayBean.setMaxAmount(1);
            PayBean.setMinAmount(0);
            PayBean.setPrice(0);
            Paydatas.add(PayBean);

        }


    }


    @OnClick({R.id.btn_back, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_submit:
                Intent Cashier = new Intent(mContext, NumberCardRenewalOrderActivity.class);
                Cashier.putExtra(PUT_STR + "MemberCardId", MemberCardId);
                Cashier.putExtra(PUT_STR + "TypeId", ID_PRIVATE_CLASS);
                Cashier.putExtra(PUT_STR + "MemberCardTypeId", Id);
                Cashier.putExtra(PUT_STR + "minNum",mMinNum);
                Cashier.putExtra(PUT_STR + "PriceList",new Gson().toJson(Paydatas));
                Cashier.putExtra(PUT_STR + "titleInfoBuy", "购买私教课");
                Cashier.putExtra(PUT_STR + "textInfoBuy",InfoBuy);
                Cashier.putExtra(PUT_STR + "TitleForFirst", "私教课教练");
                Cashier.putExtra(PUT_STR + "TitleForSecond", "购买节数");
                startActivity(Cashier);

                break;
        }
    }


}


