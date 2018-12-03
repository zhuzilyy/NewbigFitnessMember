package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Pay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.Cashier.CashierActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.SelectCocat.SelectCocatActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ItemPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.RESULT_ID;
import static com.member.gufei.bigfitness.Constants.RESULT_STRING;
import static com.member.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.member.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;

/*
* 购买私教课  确认订单
* */
public class PayActivity extends BaseActivity<PayActivityPresenter> implements PayActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_name_coach)
    TextView textNameCoach;
    @BindView(R.id.img_right)
    ImageView imgRight;
    @BindView(R.id.btn_select_coach)
    RelativeLayout btnSelectCoach;
    @BindView(R.id.text_classname)
    TextView textClassname;
    @BindView(R.id.text_number)
    TextView textNumber;
    @BindView(R.id.btn_sub)
    ImageView btnSub;
    @BindView(R.id.text_num_buy)
    TextView textNumBuy;
    @BindView(R.id.btn_add)
    ImageView btnAdd;
    @BindView(R.id.text_unit)
    TextView textUnit;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.text_min_amount)
    TextView textMinAmount;
    @BindView(R.id.text_price)
    TextView textPrice;
    @BindView(R.id.btn_submit)
    TextView btnSubmit;
    @BindView(R.id.text_info_buy)
    TextView textInfoBuy;

    private int UserId;
    private String token;
    private int LessonId;
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
    private String TeacherName;
    private int TeacherId = 0;
    private double Price=0;
    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_pay_privateclass;
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
        LessonId = intent.getIntExtra(PUT_STR + "LessonId", 0);
        TypeId = intent.getIntExtra(PUT_STR + "TypeId", 0);
        mMinNum = intent.getIntExtra(PUT_STR + "minNum", 0);
        InfoBuy = intent.getStringExtra(PUT_STR + "textInfoBuy");
        TeacherName = intent.getStringExtra(PUT_STR + "TeacherName");
        TeacherId = intent.getIntExtra(PUT_STR + "TeacherId", 0);
        textInfoBuy.setText(InfoBuy);
        String json = intent.getStringExtra(PUT_STR + "PriceList");
        PriceList = new Gson().fromJson(json, new TypeToken<List<ItemPayBean.PriceListBean>>() {
        }.getType());
        Clubid = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        textMinAmount.setText((mMinNum == 0 ? 1 : mMinNum) + "节");

        textNumBuy.setText((mMinNum == 0 ? 1 : mMinNum) + "");

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
        textNumber.setText(("¥" + MoneyTotal));
        btnSub.setImageResource(R.mipmap.img_buy_sub_no_active);
        btnSub.setEnabled(false);
        if (TeacherName!=null && !TeacherName.equals("")){
            textNameCoach.setText(TeacherName);
            btnSelectCoach.setEnabled(false);
            imgRight.setVisibility(View.INVISIBLE);
        }

//        mPresenter.getClubLessonDetail(String.valueOf(UserId),
//                token, Clubid, String.valueOf(LessonId));
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (null != data) {
            Bundle bundle = data.getExtras();
            if (bundle == null) {
                return;
            }
            if (bundle.getInt(RESULT_TYPE) == RESULT_SUCCESS) {
                if (requestCode == 8888) {
                    //昵称
                    mNameCocat = bundle.getString(RESULT_STRING);
                    mIdCocat = bundle.getString(RESULT_ID);
                    TeacherId = Integer.parseInt(mIdCocat);
                    textNameCoach.setText(mNameCocat);


                }

            }


        }

    }


    @OnClick({R.id.btn_add, R.id.btn_sub, R.id.btn_select_coach, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                setNumberForBuy(1);
                break;
            case R.id.btn_sub:
                setNumberForBuy(-1);
                break;
            case R.id.btn_select_coach:
                Intent intent = new Intent(mContext, SelectCocatActivity.class);
                intent.putExtra(PUT_STR + "LessonId", LessonId);
                intent.putExtra(RESULT_ID, "8888");
                intent.putExtra(PUT_STR + "code", "0");
                startActivityForResult(intent, 8888);
                break;
            case R.id.btn_submit:
                if (textNameCoach.getText().toString().equals("请选择") || textNameCoach.getText().toString().equals("")){
                    Toast.makeText(this, "请选择教练！", Toast.LENGTH_SHORT).show();
                }else {
                Intent Cashier = new Intent(mContext, CashierActivity.class);
                Cashier.putExtra(PUT_STR + "LessonId", LessonId);
                Cashier.putExtra(PUT_STR + "TypeId", TypeId);
                Cashier.putExtra(PUT_STR + "titleInfoBuy", "购买私教课");
                Cashier.putExtra(PUT_STR + "textInfoBuy", InfoBuy);
                Cashier.putExtra(PUT_STR + "TitleForFirst", "私教课教练");
                Cashier.putExtra(PUT_STR + "TextForFirst", textNameCoach.getText().toString());
                Cashier.putExtra(PUT_STR + "IdForSecond", mIdCocat);
                Cashier.putExtra(PUT_STR + "TitleForSecond", "购买节数");
                Cashier.putExtra(PUT_STR + "TextForSecond",textNumBuy.getText().toString());
                Cashier.putExtra(PUT_STR + "textMoneyTotal", String.valueOf(MoneyTotal));
                Cashier.putExtra(PUT_STR + "Price", Price);
                Cashier.putExtra(PUT_STR + "TeacherId", TeacherId);
                Cashier.putExtra(RESULT_ID, "9999");
                startActivityForResult(Cashier, 9999);
                      }
                break;
        }
    }

    private void setNumberForBuy(int i) {
        int num = Integer.parseInt(textNumBuy.getText().toString());
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
        textNumBuy.setText(num + "");
        MoneyTotal = num * Price;
        textNumber.setText(("¥" + MoneyTotal));
    }


}


