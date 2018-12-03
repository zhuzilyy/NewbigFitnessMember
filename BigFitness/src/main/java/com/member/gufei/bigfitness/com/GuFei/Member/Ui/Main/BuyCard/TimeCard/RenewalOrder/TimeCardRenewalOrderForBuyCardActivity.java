package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.BuyCard.TimeCard.RenewalOrder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.Cashier.CashierActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ItemPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.ID_CARD_BUY;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.RESULT_ID;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;

public class TimeCardRenewalOrderForBuyCardActivity extends BaseActivity<TimeCardRenewalOrderForBuyCardActivityPresenter> implements TimeCardRenewalOrderForBuyCardActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_type_card)
    TextView textTypeCard;
    @BindView(R.id.text_num)
    EditText textNum;
    @BindView(R.id.text_price)
    TextView textPrice;
    @BindView(R.id.text_money_total)
    TextView textMoneyTotal;
    @BindView(R.id.btn_submit)
    TextView btnSubmit;


    private int UserId;
    private String token;
    private int MemberCardId;
    private int mMinNum;
    private String ConsumeType;//卡类型
    private String MemberCardTypeId;

    private String Clubid;
    private String mNameCocat;
    private String mIdCocat;
    int maxNum = 0;
    int mniNum = 99999;
    private int MoneyTotal;
    private String InfoBuy;
    private int TypeId;
    private String mTextMoneyTotal;
    private String mTextForSecond;

    private final int charMaxNum = 10; // 允许输入的字数
    private CharSequence temp;    // 监听前的文本
    private int editStart;      // 光标开始位置
    private int editEnd;        // 光标结束位置
    private double Total;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_renewalorder_time_card_buy;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("确认订单");
        btnComplete.setVisibility(View.GONE);
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        Intent intent = getIntent();
        MemberCardId = intent.getIntExtra(PUT_STR + "MemberCardId", 0);
        TypeId = intent.getIntExtra(PUT_STR + "TypeId", 0);
        ConsumeType = intent.getStringExtra(PUT_STR + "ConsumeType");
        MemberCardTypeId = intent.getStringExtra(PUT_STR + "MemberCardTypeId");
        InfoBuy = intent.getStringExtra(PUT_STR + "textInfoBuy");
        mTextForSecond = intent.getStringExtra(PUT_STR + "TextForSecond");
        mTextMoneyTotal = intent.getStringExtra(PUT_STR + "textMoneyTotal");
        textTypeCard.setText(InfoBuy);
        textPrice.setText("¥"+mTextForSecond);
        textMoneyTotal.setText("¥"+mTextMoneyTotal);

        textNum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){

                }else{
                    if (!textNum.getText().toString().equals("")) {
                        Total = Integer.valueOf(textNum.getText().toString()) * Double.valueOf(mTextForSecond);
                        BigDecimal bigDecimal = new BigDecimal(Total);
                        textMoneyTotal.setText("¥"+ bigDecimal.setScale(1,BigDecimal.ROUND_DOWN));
                        mTextMoneyTotal=textMoneyTotal.getText().toString();
                    }
                }

            }
        });


    }

//
//
//    TextWatcher textWatcher = new TextWatcher() {
//        // 输入文本之前的状态
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//        }
//
//        // 输入文本中的状态
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before, int count) {
//            temp = s; //temp = s   用于记录当前正在输入文本的个数
//
//        }
//
//
//
//        // 输入文本之后的状态
//        @Override
//        public void afterTextChanged(Editable s) {
//            editStart = textNum.getSelectionStart();
//            editEnd = textNum.getSelectionEnd();
//            textNum.setText("" + temp.length());  //把输入temp中记录的字符个数显示在TextView上
//            if (temp.length() >10) {
//                s.delete(editStart - 1, editEnd);
//                int tempSelection = editStart;
//                textNum.setText(s);
//                textNum.setSelection(tempSelection);
//            }
//
//        }
//    };
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
    public void succeed(PublicSeaBean publicSeaBean) {

    }




    @OnClick(R.id.btn_submit)
    public void onViewClicked() {
        if (!textNum.getText().toString().equals("")) {
            if (!textNum.getText().toString().equals("0")) {
                Intent Cashier = new Intent(mContext, CashierActivity.class);

                Cashier.putExtra(PUT_STR + "MemberCardId", MemberCardId);
                Cashier.putExtra(PUT_STR + "TypeId", ID_CARD_BUY);
                Cashier.putExtra(PUT_STR + "ConsumeType", ConsumeType);
                Cashier.putExtra(PUT_STR + "MemberCardTypeId", MemberCardTypeId);
                Cashier.putExtra(PUT_STR + "titleInfoBuy", "购买会员卡");
                Cashier.putExtra(PUT_STR + "textInfoBuy", textTypeCard.getText().toString());
                Cashier.putExtra(PUT_STR + "TitleForFirst", "购买张数");
                Cashier.putExtra(PUT_STR + "TextForFirst", textNum.getText().toString());
                Cashier.putExtra(PUT_STR + "IdForSecond", "");
                Cashier.putExtra(PUT_STR + "TitleForSecond", "单张价格");
                Cashier.putExtra(PUT_STR + "TextForSecond", mTextForSecond);
                Cashier.putExtra(PUT_STR + "textMoneyTotal",mTextMoneyTotal);
                Cashier.putExtra(RESULT_ID, "9999");
                startActivityForResult(Cashier, 9999);
            } else {
                Toast.makeText(mContext, "不能购买0张", Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(mContext, "请输入购买张数", Toast.LENGTH_LONG).show();
        }
    }
}


