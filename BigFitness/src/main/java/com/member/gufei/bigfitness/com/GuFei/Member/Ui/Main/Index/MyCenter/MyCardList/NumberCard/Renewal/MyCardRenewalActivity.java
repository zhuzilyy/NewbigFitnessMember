package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.NumberCard.Renewal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.AdaptionLinearLayoutManager;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.NumberCard.RenewalOrder.MyCardRenewalOrderActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ItemPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MembershipRenewalBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.widget.LinearLayout.VERTICAL;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;

public class MyCardRenewalActivity extends BaseActivity<MyCardRenewalActivityPresenter> implements MyCardRenewalActivityContract.View {


    @BindView(R.id.tv_mycard_type)
    TextView tvMycardType;
    @BindView(R.id.tv_mycard_days_title)
    TextView tvMycardDaysTitle;
    @BindView(R.id.tv_mycard_days)
    TextView tvMycardDays;
    @BindView(R.id.tv_mycard_section)
    TextView tvMycardSection;
    @BindView(R.id.tv_mycard_money)
    TextView tvMycardMoney;
    @BindView(R.id.tv_mycard_section1)
    TextView tvMycardSection1;
    @BindView(R.id.tv_mycard_money1)
    TextView tvMycardMoney1;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerviewid;
    @BindView(R.id.tv_mycard_renew)
    TextView tvMycardRenew;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    @BindView(R.id.iv_mycard_back)
    ImageView ivMycardBack;
    private int UserId;
    private String token;
    private String ClubId;
    private String MemberCardTypeId;
    private String typeName;
    private int ConsumeType;
    private int Minimum;
    private int RemainUseCount;
    private String MemberCardTypeName;
    private String ExpireTime;
    private Double Price;
    private String MemberCardId;
    private List<ItemPayBean.PriceListBean> datas = new ArrayList<ItemPayBean.PriceListBean>();
    private List<ItemPayBean.PriceListBean> Paydatas = new ArrayList<ItemPayBean.PriceListBean>();
    private CommonAdapter<ItemPayBean.PriceListBean> commonAdapter;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_renewal_my_private;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        MemberCardId = intent.getStringExtra(PUT_STR + "MemberCardId");
        MemberCardTypeId = intent.getStringExtra(PUT_STR + "MemberCardType");
        ConsumeType = intent.getIntExtra(PUT_STR + "ConsumeType", 0);
        MemberCardTypeName = intent.getStringExtra(PUT_STR + "MemberCardTypeName");
        RemainUseCount = intent.getIntExtra(PUT_STR + "RemainUseCount", 0);
        Minimum = intent.getIntExtra(PUT_STR + "Minimum", 0);
        ExpireTime = intent.getStringExtra(PUT_STR + "ExpireTime");
        tvMycardType.setText(MemberCardTypeName);
        mPresenter.getMemberCardAddFeePriceList(String.valueOf(UserId),
                token,
                ClubId,
                MemberCardTypeId);
        if (ConsumeType == 0) {
            tvMycardDaysTitle.setText("最低续费次数");
            typeName = "次";
        } else {
            tvMycardDaysTitle.setText("最低续费天数");
            typeName = "天";
        }
        datas = new ArrayList<>();
        commonAdapter = new CommonAdapter<ItemPayBean.PriceListBean>(R.layout.member_item_unit_pay_card, mContext, datas) {
            @Override
            protected void convert(ViewHolder holder, final ItemPayBean.PriceListBean msgBean, int position) {

                holder.setText(R.id.text_content, msgBean.getMinAmount() + "-" + msgBean.getMaxAmount() + typeName);
                holder.setText(R.id.text_money, msgBean.getPrice() + "");
            }
        };
        recyclerviewid.setAdapter(commonAdapter);
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
    public void succeed(MembershipRenewalBean membershipRenewalBean) {
//        if (ConsumeType == 0){
//            tvMycardDays.setText(membershipRenewalBean.getTotalPage() + "次");
//        }
        Price = membershipRenewalBean.getRows().get(0).getPrice();
        tvMycardDays.setText(Minimum + typeName);
        if (membershipRenewalBean.getRows().size() > 1) {

            tvMycardSection.setText(membershipRenewalBean.getRows().get(0).getStartAmount()
                    + "-" + membershipRenewalBean.getRows().get(0).getEndAmount() + typeName);
            tvMycardMoney.setText(membershipRenewalBean.getRows().get(0).getPrice() + "");
            ItemPayBean.PriceListBean PayBean = new ItemPayBean.PriceListBean();
            PayBean.setMaxAmount(membershipRenewalBean.getRows().get(0).getEndAmount());
            PayBean.setMinAmount(membershipRenewalBean.getRows().get(0).getStartAmount());
            PayBean.setPrice(membershipRenewalBean.getRows().get(0).getPrice());
            Paydatas.add(PayBean);

            try {
                for (int i = membershipRenewalBean.getRows().size() - 1; i > 0; i--) {
                    if (i == 1) {
                        if (membershipRenewalBean.getRows().get(i).getEndAmount() == 0) {
                            tvMycardSection1.setText(membershipRenewalBean.getRows().get(i).getStartAmount()
                                    + typeName + "以上");
                            tvMycardMoney1.setText(membershipRenewalBean.getRows().get(i).getPrice() + "");
                            ItemPayBean.PriceListBean PayBean1 = new ItemPayBean.PriceListBean();
                            PayBean1.setMaxAmount(membershipRenewalBean.getRows().get(i).getEndAmount());
                            PayBean1.setMinAmount(membershipRenewalBean.getRows().get(i).getStartAmount());
                            PayBean1.setPrice(membershipRenewalBean.getRows().get(i).getPrice());
                            Paydatas.add(PayBean1);
                        } else {
                            tvMycardSection1.setText(membershipRenewalBean.getRows().get(i).getStartAmount()
                                    + "-" + membershipRenewalBean.getRows().get(i).getEndAmount() + typeName);
                            tvMycardMoney1.setText(membershipRenewalBean.getRows().get(i).getPrice() + "");
                            ItemPayBean.PriceListBean PayBean1 = new ItemPayBean.PriceListBean();
                            PayBean1.setMaxAmount(membershipRenewalBean.getRows().get(i).getEndAmount());
                            PayBean1.setMinAmount(membershipRenewalBean.getRows().get(i).getStartAmount());
                            PayBean1.setPrice(membershipRenewalBean.getRows().get(i).getPrice());
                            Paydatas.add(PayBean1);
                        }

                    } else {
                        ItemPayBean.PriceListBean bean = new ItemPayBean.PriceListBean();
                        bean.setMaxAmount(membershipRenewalBean.getRows().get(i).getEndAmount());
                        bean.setMinAmount(membershipRenewalBean.getRows().get(i).getStartAmount());
                        bean.setPrice(membershipRenewalBean.getRows().get(i).getPrice());
                        datas.add(bean);
                        Paydatas.add(bean);
                    }

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
                recyclerviewid.setLayoutManager(layoutManager);
                commonAdapter.setShowFooter(false);


            } catch (Exception e) {
                e.printStackTrace();

            }
        } else if (membershipRenewalBean.getRows().size() == 1) {
            tvMycardSection.setText(membershipRenewalBean.getRows().get(0).getStartAmount()
                    + "-" + membershipRenewalBean.getRows().get(0).getEndAmount() + typeName);
            tvMycardMoney.setText(membershipRenewalBean.getRows().get(0).getPrice() + "");
            ItemPayBean.PriceListBean PayBean = new ItemPayBean.PriceListBean();
            PayBean.setMaxAmount(membershipRenewalBean.getRows().get(0).getEndAmount());
            PayBean.setMinAmount(membershipRenewalBean.getRows().get(0).getStartAmount());
            PayBean.setPrice(membershipRenewalBean.getRows().get(0).getPrice());
            Paydatas.add(PayBean);

        } else {

            tvMycardSection.setText("0" + typeName);
            tvMycardMoney.setText("0");
            ItemPayBean.PriceListBean PayBean = new ItemPayBean.PriceListBean();
            PayBean.setMaxAmount(1);
            PayBean.setMinAmount(0);
            PayBean.setPrice(0);
            Paydatas.add(PayBean);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_mycard_back, R.id.tv_mycard_renew})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_mycard_back:
                finish();
                break;
            case R.id.tv_mycard_renew:
                Intent intent = new Intent(mContext, MyCardRenewalOrderActivity.class);
                intent.putExtra(PUT_STR + "PriceList",new Gson().toJson(Paydatas));
                intent.putExtra(PUT_STR + "MemberCardId", MemberCardId);
                intent.putExtra(PUT_STR + "MemberCardTypeName", MemberCardTypeName);
                intent.putExtra(PUT_STR + "ConsumeType", ConsumeType);
                intent.putExtra(PUT_STR + "Minimum", Minimum);
                intent.putExtra(PUT_STR + "RemainUseCount", RemainUseCount);
                intent.putExtra(PUT_STR + "ExpireTime", ExpireTime);
                intent.putExtra(PUT_STR + "UnitPrice", Price);
                startActivity(intent);
                break;
        }
    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // TODO: add setContentView(...) invocation
//        ButterKnife.bind(this);
//    }
}


