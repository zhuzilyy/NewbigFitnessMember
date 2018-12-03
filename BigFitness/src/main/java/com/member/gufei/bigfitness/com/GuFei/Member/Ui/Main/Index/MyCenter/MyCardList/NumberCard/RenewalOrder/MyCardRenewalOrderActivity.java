package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.NumberCard.RenewalOrder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.Cashier.CashierActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ItemPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.ID_CARD_RENEWAL;
import static com.member.gufei.bigfitness.Constants.PUT_STR;

public class MyCardRenewalOrderActivity extends BaseActivity<MyCardRenewalOrderActivityPresenter> implements MyCardRenewalOrderActivityContract.View {


    @BindView(R.id.iv_myorder_back)
    ImageView ivMyorderBack;
    @BindView(R.id.tv_myorder_type)
    TextView tvMyorderType;
    @BindView(R.id.tv_myorder_numName)
    TextView tvMyorderNumName;
    @BindView(R.id.tv_myorder_num)
    TextView tvMyorderNum;
    @BindView(R.id.tv_myorder_expiryTime)
    TextView tvMyorderExpiryTime;
    @BindView(R.id.tv_myorder_priceName)
    TextView tvMyorderPriceName;
    @BindView(R.id.tv_myorder_price)
    TextView tvMyorderPrice;
    @BindView(R.id.tv_myorder_totalPrice)
    TextView tvMyorderTotalPrice;
    @BindView(R.id.tv_myorder_payment)
    TextView tvMyorderPayment;
    @BindView(R.id.tv_myorder_surplus)
    TextView tvMyorderSurplus;
    @BindView(R.id.btn_add)
    ImageView btnAdd;
    @BindView(R.id.btn_sub)
    ImageView btnSub;

    private String MemberCardTypeName;
    private String MemberCardId;
    private int ConsumeType;
    private int Minimum;
    private int RemainUseCount;
    private String ExpireTime;
    private Double Price;
    private String typeName;
    private double MoneyTotal;
    int maxNum = 0;
    int mniNum = 99999;
    Date date = null;
    DateFormat format;
    Calendar c;
    int num;

    private List<ItemPayBean.PriceListBean> PriceList = new ArrayList<ItemPayBean.PriceListBean>();

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_renewalorder_number_card;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        MemberCardId = intent.getStringExtra(PUT_STR + "MemberCardId");
        MemberCardTypeName = intent.getStringExtra(PUT_STR + "MemberCardTypeName");
        ConsumeType = intent.getIntExtra(PUT_STR + "ConsumeType", 0);
        Minimum = intent.getIntExtra(PUT_STR + "Minimum", 0);
        RemainUseCount = intent.getIntExtra(PUT_STR + "RemainUseCount", 0);
        ExpireTime = intent.getStringExtra(PUT_STR + "ExpireTime");
//        Price = intent.getDoubleExtra(PUT_STR + "UnitPrice", 0.0);
        String json = intent.getStringExtra(PUT_STR + "PriceList");
        PriceList = new Gson().fromJson(json, new TypeToken<List<ItemPayBean.PriceListBean>>() {
        }.getType());
        tvMyorderType.setText(MemberCardTypeName);
        num = Minimum == 0 ? 1 : Minimum;
        tvMyorderNum.setText(num + "");
        if (ConsumeType == 0) {
            tvMyorderNumName.setText("续费次数");
            tvMyorderPriceName.setText("单次价格");
            typeName = "次";
        } else {
            tvMyorderNumName.setText("续费天数");
            tvMyorderPriceName.setText("单日价格");
            typeName = "天";
        }
        format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = format.parse(ExpireTime);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void initData() {
        Price = 0.0;
        for (int j = 0; j < PriceList.size(); j++) {
            if (maxNum < PriceList.get(j).getMaxAmount()) {
                maxNum = PriceList.get(j).getMaxAmount();
            } else {
                if (PriceList.get(j).getMaxAmount() == 0) {
                    maxNum = 9999;
                }
            }
            if (mniNum > PriceList.get(j).getMinAmount()) {
                mniNum = PriceList.get(j).getMinAmount();
                Price = PriceList.get(j).getPrice();
            }
        }
//        textNumber.setText(("¥" + (mniNum == 0 ? 1 : mniNum) * mniNum));
        if (ConsumeType == 0) {
            tvMyorderExpiryTime.setText(ExpireTime);
        } else {
            c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, (Minimum == 0 ? 1 : Minimum));
            tvMyorderExpiryTime.setText(format.format(c.getTime()));
        }

        tvMyorderPrice.setText("¥" + Price);
        MoneyTotal = (Minimum == 0 ? 1 : Minimum) * Price;
        tvMyorderTotalPrice.setText(("¥" + MoneyTotal));
        tvMyorderSurplus.setText((RemainUseCount + (Minimum == 0 ? 1 : Minimum)) + typeName);
        btnSub.setImageResource(R.mipmap.img_buy_sub_no_active);
        btnSub.setEnabled(false);
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
    public void succeed(PublicSeaBean publicSeaBean) {

    }

    @Override
    public void succeedEdit(CodeBean codeBean) {

    }

    @Override
    public void succeedoperate() {

    }

    @Override
    public void membersucceed(PublicSeaMemberBean publicSeaBean) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_myorder_back, R.id.btn_add, R.id.btn_sub, R.id.tv_myorder_payment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_myorder_back:
                finish();
                break;
            case R.id.btn_add:
                setNumberForBuy(1);
                break;
            case R.id.btn_sub:
                setNumberForBuy(-1);
                break;
            case R.id.tv_myorder_payment:
                Intent Cashier = new Intent(mContext, CashierActivity.class);
                Cashier.putExtra(PUT_STR + "TypeId", ID_CARD_RENEWAL);
                Cashier.putExtra(PUT_STR + "MemberCardId", MemberCardId);
                Cashier.putExtra(PUT_STR + "titleInfoBuy", "会员卡续费");
                Cashier.putExtra(PUT_STR + "textInfoBuy", MemberCardTypeName);
                Cashier.putExtra(PUT_STR + "ConsumeType", String.valueOf(ConsumeType));
                if (ConsumeType == 0) {
                    Cashier.putExtra(PUT_STR + "TitleForFirst", "续费次数");
                    Cashier.putExtra(PUT_STR + "TextForFirst", String.valueOf(num));
                    Cashier.putExtra(PUT_STR + "TitleForSecond", "单次价格");
                } else {
                    Cashier.putExtra(PUT_STR + "TitleForFirst", "续费天数");
                    Cashier.putExtra(PUT_STR + "TextForFirst", String.valueOf(num));
                    Cashier.putExtra(PUT_STR + "TitleForSecond", "单日价格");
                }
                Cashier.putExtra(PUT_STR + "TextForSecond", ("¥" + Price));
                Cashier.putExtra(PUT_STR + "textMoneyTotal", String.valueOf(MoneyTotal));
                startActivity(Cashier);
                break;
        }
    }

    private void setNumberForBuy(int i) {
        num = Integer.parseInt(tvMyorderNum.getText().toString());
        if (i > 0) {
            if (num < maxNum) {
                num += i;
                btnAdd.setImageResource(R.mipmap.img_buy_add_active);
                btnAdd.setEnabled(true);
                btnSub.setImageResource(R.mipmap.img_buy_sub_active);
                btnSub.setEnabled(true);
            } else {
                btnAdd.setImageResource(R.mipmap.img_buy_add_no_active);
                btnAdd.setEnabled(false);
            }

        } else {
            if (num > (Minimum == 0 ? 1 : Minimum)) {
                num += i;
                btnSub.setImageResource(R.mipmap.img_buy_sub_active);
                btnSub.setEnabled(true);
                btnAdd.setImageResource(R.mipmap.img_buy_add_active);
                btnAdd.setEnabled(true);
            } else {
                btnSub.setImageResource(R.mipmap.img_buy_sub_no_active);
                btnSub.setEnabled(false);
            }


        }

        Price = 0.0;
        for (int j = 0; j < PriceList.size(); j++) {
            if (num >= PriceList.get(j).getMinAmount() && num <= PriceList.get(j).getMaxAmount()) {
                Price = PriceList.get(j).getPrice();
            }else{
                if (num >= PriceList.get(j).getMinAmount() && PriceList.get(j).getMaxAmount()==0) {
                    Price = PriceList.get(j).getPrice();
                }
            }
        }
        if (ConsumeType == 0) {
            tvMyorderExpiryTime.setText(ExpireTime);
        } else {
            c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, num);
            tvMyorderExpiryTime.setText(format.format(c.getTime()));
        }
        tvMyorderPrice.setText(("¥" + Price));
        tvMyorderNum.setText(num + "");
        MoneyTotal = num * Price;
        tvMyorderSurplus.setText((RemainUseCount + num) + typeName);
        tvMyorderTotalPrice.setText(("¥" + MoneyTotal));
    }

}


