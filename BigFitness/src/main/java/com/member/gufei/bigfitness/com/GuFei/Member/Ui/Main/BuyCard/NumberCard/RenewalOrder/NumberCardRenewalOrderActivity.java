package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.BuyCard.NumberCard.RenewalOrder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
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
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.ID_CARD_BUY;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.RESULT_ID;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;

public class NumberCardRenewalOrderActivity extends BaseActivity<NumberCardRenewalOrderActivityPresenter> implements NumberCardRenewalOrderActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_name_card)
    TextView textNameCard;
    @BindView(R.id.text_number_min)
    TextView textNumberMin;
    @BindView(R.id.btn_add)
    ImageView btnAdd;
    @BindView(R.id.text_num)
    TextView textNum;
    @BindView(R.id.btn_sub)
    ImageView btnSub;
    @BindView(R.id.text_money)
    TextView textPrice;
    @BindView(R.id.text_money_total)
    TextView textMoneyTotal;
    @BindView(R.id.btn_submit)
    TextView btnSubmit;

    private int UserId;
    private String token;
    private int MemberCardId;
    private int mMinNum;

    private List<ItemPayBean.PriceListBean> PriceList = new ArrayList<ItemPayBean.PriceListBean>();
    private String Clubid;
    private String mNameCocat;
    private String mIdCocat;
    int maxNum = 0;
    int mniNum = 99999;
    private double MoneyTotal;
    private String InfoBuy;
    private int TypeId;
    private String MemberCardTypeId;


    @Override
    protected void initInject() {

        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_renewalorder_number_card_buy;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
//
        setToolBar(toolbar, "");

        tvTitle.setText("确认订单");

        btnComplete.setVisibility(View.GONE);


    }

    @Override
    protected void initData() {

        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        Intent intent = getIntent();
        MemberCardTypeId = intent.getStringExtra(PUT_STR + "MemberCardTypeId");
        MemberCardId = intent.getIntExtra(PUT_STR + "MemberCardId", 0);
        TypeId = intent.getIntExtra(PUT_STR + "TypeId", 0);
        mMinNum = intent.getIntExtra(PUT_STR + "minNum", 0);
        InfoBuy = intent.getStringExtra(PUT_STR + "textInfoBuy");
        textNameCard.setText(InfoBuy);
        String json = intent.getStringExtra(PUT_STR + "PriceList");
        PriceList = new Gson().fromJson(json, new TypeToken<List<ItemPayBean.PriceListBean>>() {
        }.getType());
        Clubid = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        textNumberMin.setText((mMinNum == 0 ? 1 : mMinNum) + "节");

        textNum.setText((mMinNum == 0 ? 1 : mMinNum) + "");

        double Price=0;
        for (int j = 0; j < PriceList.size(); j++) {
            if (maxNum < PriceList.get(j).getMaxAmount()) {
                maxNum = PriceList.get(j).getMaxAmount();
            }
            if (mniNum > PriceList.get(j).getMinAmount()) {
                mniNum = PriceList.get(j).getMinAmount();
                Price = PriceList.get(j).getPrice();
            }
        }
//        textNumber.setText(("¥" + (mniNum == 0 ? 1 : mniNum) * mniNum));
        textPrice.setText("¥" +Price);
        MoneyTotal =  (mMinNum == 0 ? 1 : mMinNum) * Price;
        textMoneyTotal.setText(("¥" + MoneyTotal));
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



    @OnClick({R.id.btn_add, R.id.btn_sub, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                setNumberForBuy(1);
                break;
            case R.id.btn_sub:
                setNumberForBuy(-1);
                break;
            case R.id.btn_submit:
                Intent Cashier = new Intent(mContext,CashierActivity.class);
                Cashier.putExtra(PUT_STR + "MemberCardTypeId", MemberCardTypeId);
                Cashier.putExtra(PUT_STR + "TypeId", ID_CARD_BUY);
                Cashier.putExtra(PUT_STR + "titleInfoBuy", "购买会员卡");
                Cashier.putExtra(PUT_STR + "textInfoBuy", InfoBuy);
                Cashier.putExtra(PUT_STR + "TitleForFirst", "购买节数");
                Cashier.putExtra(PUT_STR + "TextForFirst", textNum.getText().toString());
                Cashier.putExtra(PUT_STR + "IdForSecond", "");
                Cashier.putExtra(PUT_STR + "TitleForSecond", "单次价格");
                Cashier.putExtra(PUT_STR + "TextForSecond", textPrice.getText().toString());
                Cashier.putExtra(PUT_STR + "textMoneyTotal",String.valueOf(MoneyTotal));
                Cashier.putExtra(RESULT_ID, "9999");
                startActivityForResult(Cashier, 9999);
                break;
        }
    }


    private void setNumberForBuy(int i) {
        int num = Integer.parseInt(textNum.getText().toString());
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
            if (num > (mMinNum == 0 ? 1 : mMinNum)) {
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

        double Price = 0;
        for (int j = 0; j < PriceList.size(); j++) {
            if (num >= PriceList.get(j).getMinAmount() && num <= PriceList.get(j).getMaxAmount()) {
                Price = PriceList.get(j).getPrice();
            }
        }
        textPrice.setText(("¥" + Price));
        textNum.setText(num + "");
        MoneyTotal = num * Price;
        textMoneyTotal.setText(("¥" + MoneyTotal));
    }

}


