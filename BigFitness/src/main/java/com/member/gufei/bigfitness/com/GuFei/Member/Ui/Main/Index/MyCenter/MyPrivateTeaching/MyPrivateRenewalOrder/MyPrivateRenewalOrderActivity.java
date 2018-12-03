package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.MyPrivateRenewalOrder;

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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.ID_CARD_RENEWAL;
import static com.member.gufei.bigfitness.Constants.ID_PRIVATE_CLASS_RENEWAL;
import static com.member.gufei.bigfitness.Constants.PUT_STR;

public class MyPrivateRenewalOrderActivity extends BaseActivity<MyPrivateRenewalOrderActivityPresenter> implements MyPrivateRenewalOrderActivityContract.View {


    @BindView(R.id.iv_myorder_back)
    ImageView ivMyorderBack;
    @BindView(R.id.text_classname)
    TextView textClassname;
    @BindView(R.id.text_number)
    TextView textNumber;
    @BindView(R.id.tv_mylesson_name)
    TextView tvMylessonName;
    @BindView(R.id.tv_mylesson_price)
    TextView tvMylessonPrice;
    @BindView(R.id.btn_add)
    ImageView btnAdd;
    @BindView(R.id.tv_myorder_num)
    TextView tvMyorderNum;
    @BindView(R.id.btn_sub)
    ImageView btnSub;
    @BindView(R.id.submit)
    TextView submit;
    private String LessonName;
    private int AddFeeMinAmount;
    private double MoneyTotal;
    private Double Price;
    private int Id;
    int maxNum = 0;
    int mniNum = 99999;
    int num;

    private List<ItemPayBean.PriceListBean> PriceList = new ArrayList<ItemPayBean.PriceListBean>();

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_renewalorder_my_private;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        LessonName = intent.getStringExtra(PUT_STR + "LessonName");
        AddFeeMinAmount = intent.getIntExtra(PUT_STR + "AddFeeMinAmount", 0);
        Price = intent.getDoubleExtra(PUT_STR + "UnitPrice", 0.0);
        Id = intent.getIntExtra(PUT_STR + "ID", 0);
        String json = intent.getStringExtra(PUT_STR + "PriceList");
        PriceList = new Gson().fromJson(json, new TypeToken<List<ItemPayBean.PriceListBean>>() {
        }.getType());
        tvMylessonName.setText(LessonName);

//        tvMyorderNum.setText(String.valueOf(AddFeeMinAmount));
        num = AddFeeMinAmount == 0 ? 1 : AddFeeMinAmount;
        tvMyorderNum.setText(num + "");

    }

    @Override
    protected void initData() {
//        Price = 0.0;
        for (int j = 0; j < PriceList.size(); j++) {
            if (maxNum < PriceList.get(j).getMaxAmount()) {
                maxNum = PriceList.get(j).getMaxAmount();
            } else {
                if (PriceList.get(j).getMaxAmount() == 0 ) {
                    maxNum = 9999;
                }
            }
            if (mniNum > PriceList.get(j).getMinAmount()) {
                mniNum = PriceList.get(j).getMinAmount();
                Price = PriceList.get(j).getPrice();
            }
        }
//        textNumber.setText(("¥" + (mniNum == 0 ? 1 : mniNum) * mniNum));

        tvMylessonPrice.setText("¥" + Price);
        MoneyTotal = (AddFeeMinAmount == 0 ? 1 : AddFeeMinAmount) * Price;
        textNumber.setText(("¥" + MoneyTotal));
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

    @OnClick({R.id.iv_myorder_back, R.id.btn_add, R.id.btn_sub, R.id.submit})
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
            case R.id.submit:
                Intent Cashier = new Intent(mContext, CashierActivity.class);
                Cashier.putExtra(PUT_STR + "TypeId", ID_PRIVATE_CLASS_RENEWAL);
                Cashier.putExtra(PUT_STR + "titleInfoBuy", "私教课续费");
                Cashier.putExtra(PUT_STR + "textInfoBuy", LessonName);
                Cashier.putExtra(PUT_STR + "TitleForFirst", "续费节数");
                Cashier.putExtra(PUT_STR + "TextForFirst", String.valueOf(num));
                Cashier.putExtra(PUT_STR + "TitleForSecond", "单节价格");
                Cashier.putExtra(PUT_STR + "TextForSecond",("¥" + Price));
                Cashier.putExtra(PUT_STR + "textMoneyTotal", String.valueOf(MoneyTotal));
                Cashier.putExtra(PUT_STR + "ID", String.valueOf(Id));
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
            if (num > (AddFeeMinAmount == 0 ? 1 : AddFeeMinAmount)) {
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
            } else {
                if (num >= PriceList.get(j).getMinAmount() && PriceList.get(j).getMaxAmount() == 0) {
                    Price = PriceList.get(j).getPrice();
                }
            }
        }
        tvMylessonPrice.setText(("¥" + Price));
        tvMyorderNum.setText(num + "");
        MoneyTotal = num * Price;
        textNumber.setText(("¥" + MoneyTotal));
    }

}


