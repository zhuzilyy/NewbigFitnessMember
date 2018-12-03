package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.MyPrivateRenewal;

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
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.MyPrivateRenewalOrder.MyPrivateRenewalOrderActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.MyPrivateTeachingActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ItemPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.LessonAddFeePriceBean;
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

public class MyPrivateRenewalActivity extends BaseActivity<MyPrivateRenewalActivityPresenter> implements MyPrivateRenewalActivityContract.View {


    @BindView(R.id.iv_mycard_back)
    ImageView ivMycardBack;
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
    @BindView(R.id.tv_mycard_renew)
    TextView tvMycardRenew;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_type_name)
    TextView tvTypeName;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerviewid;

    private int UserId;
    private String token;
    private String ClubId;
    private String LessonName;
    private int AddFeeMinAmount;
    private int MemberLessonTypeId;
    private int LessonId;
    private Double Price;
    private int Minimum;

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
        tvTitle.setText("私教课续费");
        tvTypeName.setText("私教课名称");
        tvMycardDaysTitle.setText("最低续费节数");
        Intent intent = getIntent();
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");

        LessonName = intent.getStringExtra(PUT_STR + "LessonName");
        AddFeeMinAmount = intent.getIntExtra(PUT_STR + "AddFeeMinAmount", 0);
        MemberLessonTypeId = intent.getIntExtra(PUT_STR + "MemberLessonTypeId", 0);
        LessonId = intent.getIntExtra(PUT_STR + "LessonId", 0);
        tvMycardType.setText(LessonName);
        tvMycardDays.setText(AddFeeMinAmount + "节");
        mPresenter.getMemberLessonAddFeePriceList(String.valueOf(UserId),
                token,
                ClubId,
                String.valueOf(LessonId));
        datas = new ArrayList<>();
        commonAdapter = new CommonAdapter<ItemPayBean.PriceListBean>(R.layout.member_item_unit_pay_card, mContext, datas) {
            @Override
            protected void convert(ViewHolder holder, final ItemPayBean.PriceListBean msgBean, int position) {

                holder.setText(R.id.text_content, msgBean.getMinAmount() + "-" + msgBean.getMaxAmount() + "节");
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
    public void succeed(LessonAddFeePriceBean lessonAddFeePriceBean) {

        Price = lessonAddFeePriceBean.getRows().get(0).getPrice();
//        tvMycardDays.setText(Minimum + "节");
        if (lessonAddFeePriceBean.getRows().size() > 1) {

            tvMycardSection.setText(lessonAddFeePriceBean.getRows().get(0).getStartAmount()
                    + "-" + lessonAddFeePriceBean.getRows().get(0).getEndAmount() + "节");
            tvMycardMoney.setText(lessonAddFeePriceBean.getRows().get(0).getPrice() + "");
            ItemPayBean.PriceListBean PayBean = new ItemPayBean.PriceListBean();
            PayBean.setMaxAmount(lessonAddFeePriceBean.getRows().get(0).getEndAmount());
            PayBean.setMinAmount(lessonAddFeePriceBean.getRows().get(0).getStartAmount());
            PayBean.setPrice(lessonAddFeePriceBean.getRows().get(0).getPrice());
            Paydatas.add(PayBean);

            try {
//                for (int i = lessonAddFeePriceBean.getRows().size() - 1; i > 0; i--) {
                    for (int i = 1; i < lessonAddFeePriceBean.getRows().size(); i++) {
                    if (i == lessonAddFeePriceBean.getRows().size()-1) {
                        if (lessonAddFeePriceBean.getRows().get(i).getEndAmount() == 0) {
                            tvMycardSection1.setText(lessonAddFeePriceBean.getRows().get(i).getStartAmount()
                                    + "节" + "以上");
                            tvMycardMoney1.setText(lessonAddFeePriceBean.getRows().get(i).getPrice() + "");
                            ItemPayBean.PriceListBean PayBean1 = new ItemPayBean.PriceListBean();
                            PayBean1.setMaxAmount(lessonAddFeePriceBean.getRows().get(i).getEndAmount());
                            PayBean1.setMinAmount(lessonAddFeePriceBean.getRows().get(i).getStartAmount());
                            PayBean1.setPrice(lessonAddFeePriceBean.getRows().get(i).getPrice());
                            Paydatas.add(PayBean1);
                        } else {
                            tvMycardSection1.setText(lessonAddFeePriceBean.getRows().get(i).getStartAmount()
                                    + "-" + lessonAddFeePriceBean.getRows().get(i).getEndAmount() + "节");
                            tvMycardMoney1.setText(lessonAddFeePriceBean.getRows().get(i).getPrice() + "");
                            ItemPayBean.PriceListBean PayBean1 = new ItemPayBean.PriceListBean();
                            PayBean1.setMaxAmount(lessonAddFeePriceBean.getRows().get(i).getEndAmount());
                            PayBean1.setMinAmount(lessonAddFeePriceBean.getRows().get(i).getStartAmount());
                            PayBean1.setPrice(lessonAddFeePriceBean.getRows().get(i).getPrice());
                            Paydatas.add(PayBean1);
                        }

                    } else {
                        ItemPayBean.PriceListBean bean = new ItemPayBean.PriceListBean();
                        bean.setMaxAmount(lessonAddFeePriceBean.getRows().get(i).getEndAmount());
                        bean.setMinAmount(lessonAddFeePriceBean.getRows().get(i).getStartAmount());
                        bean.setPrice(lessonAddFeePriceBean.getRows().get(i).getPrice());
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
        } else if (lessonAddFeePriceBean.getRows().size() == 1) {
            tvMycardSection.setText(lessonAddFeePriceBean.getRows().get(0).getStartAmount()
                    + "-" + lessonAddFeePriceBean.getRows().get(0).getEndAmount() + "节");
            tvMycardMoney.setText(lessonAddFeePriceBean.getRows().get(0).getPrice() + "");
            ItemPayBean.PriceListBean PayBean = new ItemPayBean.PriceListBean();
            PayBean.setMaxAmount(lessonAddFeePriceBean.getRows().get(0).getEndAmount());
            PayBean.setMinAmount(lessonAddFeePriceBean.getRows().get(0).getStartAmount());
            PayBean.setPrice(lessonAddFeePriceBean.getRows().get(0).getPrice());
            Paydatas.add(PayBean);

        } else {

            tvMycardSection.setText("0" + "节");
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
                Intent intent = new Intent(mContext, MyPrivateRenewalOrderActivity.class);
                intent.putExtra(PUT_STR + "PriceList",new Gson().toJson(Paydatas));
                intent.putExtra(PUT_STR + "LessonName", LessonName);
                intent.putExtra(PUT_STR + "AddFeeMinAmount", AddFeeMinAmount);
                intent.putExtra(PUT_STR + "ID", MemberLessonTypeId);
                intent.putExtra(PUT_STR + "UnitPrice", Price);
                startActivity(intent);
                break;
        }
    }
}


