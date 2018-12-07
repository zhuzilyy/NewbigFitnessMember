package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.Cashier;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.MyCardListActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.main.MainActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.AddFeeMemberLessonPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.AppBuyLessonPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.AppBuyMemberLessonPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.NewAppBuyMemberCardPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.OrderIdForWX;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.PayForAliPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.RenewMemberCardPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.UpMemberCardPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;
//import com.member.gufei.bigfitness.util.Pay.asyncTask.WXPayTask;
//import com.member.gufei.bigfitness.util.Pay.entity.Order;
import com.member.gufei.bigfitness.util.SpUtil;
import com.member.gufei.bigfitness.util.WXPayUtils;
import com.tsy.sdk.pay.alipay.Alipay;
import com.tsy.sdk.pay.alipay.AlipayResult;
import com.tsy.sdk.pay.weixin.WXPay;

import org.json.JSONObject;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.ID_CARD_BUY;
import static com.member.gufei.bigfitness.Constants.ID_CARD_RENEWAL;
import static com.member.gufei.bigfitness.Constants.ID_CARD_UP;
import static com.member.gufei.bigfitness.Constants.ID_GROUPLESSON;
import static com.member.gufei.bigfitness.Constants.ID_PRIVATE_CLASS;
import static com.member.gufei.bigfitness.Constants.ID_PRIVATE_CLASS_RENEWAL;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

public class CashierActivity extends BaseActivity<CashierActivityPresenter> implements CashierActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title_info_buy)
    TextView titleInfoBuy;
    @BindView(R.id.text_info_buy)
    TextView textInfoBuy;
    @BindView(R.id.title_select_buy)
    TextView mTitleForFirst;
    @BindView(R.id.text_select_buy)
    TextView mTextForFirst;
    @BindView(R.id.title_count_buy)
    TextView mTitleForSecond;
    @BindView(R.id.text_count_buy)
    TextView mTextForSecond;
    @BindView(R.id.text_classname)
    TextView textClassname;
    @BindView(R.id.text_money_total)
    TextView textMoneyTotal;
    @BindView(R.id.wxpay_id)
    RadioButton wxpayId;
    @BindView(R.id.alipay_id)
    RadioButton alipayId;
    @BindView(R.id.radioGroup_pay_id)
    RadioGroup radioGroupPayId;
    @BindView(R.id.btn_submit)
    TextView btnSubmit;
    @BindView(R.id.layout_second)
    LinearLayout layoutSecond;

    private int LessonId;
    private String mTextMoneyTotal;
    private String mTitleInfoBuy;
    private String mTextInfoBuy;
    private String TitleForFirst;
    private String IdForSecond;
    private String TitleForSecond;
    private String TextForSecond;
    private String TextForFirst;
    private int TypeId;
    private int UserId;
    private String ConsumeType;//卡类型
    private String MemberCardTypeId;
    private String NewMemberCardTypeId;
    private String token;
    private String ClubId;
    private int TeacherId = 0;
    private double Price=0;
    private String MemberCardId;
    private String Id;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_cashier_privateclass;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
//
        setToolBar(toolbar, "");

        tvTitle.setText("收银台");

        btnComplete.setVisibility(View.GONE);
        Intent intent = getIntent();
        ConsumeType = intent.getStringExtra(PUT_STR + "ConsumeType");
        MemberCardId = intent.getStringExtra(PUT_STR + "MemberCardId");
        MemberCardTypeId = intent.getStringExtra(PUT_STR + "MemberCardTypeId");
        NewMemberCardTypeId = intent.getStringExtra(PUT_STR + "NewMemberCardTypeId");
        Id = intent.getStringExtra(PUT_STR + "ID");
        mTitleInfoBuy = intent.getStringExtra(PUT_STR + "titleInfoBuy");//购买内容描述
        titleInfoBuy.setText(mTitleInfoBuy);
        mTextInfoBuy = intent.getStringExtra(PUT_STR + "textInfoBuy");//购买内容
        textInfoBuy.setText(mTextInfoBuy);

        TitleForFirst = intent.getStringExtra(PUT_STR + "TitleForFirst");//第一行内容描述
        mTitleForFirst.setText(TitleForFirst);
        TextForFirst = intent.getStringExtra(PUT_STR + "TextForFirst");//第一行内容
        mTextForFirst.setText(TextForFirst);

        TitleForSecond = intent.getStringExtra(PUT_STR + "TitleForSecond");//第二行内容描述

        TextForSecond = intent.getStringExtra(PUT_STR + "TextForSecond");//第二行内容

        if (!TitleForSecond.equals("") || TitleForSecond != null) {
            layoutSecond.setVisibility(View.VISIBLE);
            mTitleForSecond.setText(TitleForSecond);
            mTextForSecond.setText(TextForSecond);
        }


        mTextMoneyTotal = intent.getStringExtra(PUT_STR + "textMoneyTotal");//总价
        textMoneyTotal.setText("¥" + mTextMoneyTotal);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        //提交数据部分
        LessonId = intent.getIntExtra(PUT_STR + "LessonId", 0);
//        IdForSecond = intent.getStringExtra(PUT_STR + "IdForSecond");//教练id 提交用
        TeacherId = intent.getIntExtra(PUT_STR + "TeacherId", 0);//教练ID
        Price = intent.getDoubleExtra(PUT_STR + "Price", 0);
        TypeId = intent.getIntExtra(PUT_STR + "TypeId", 0);//分辨付款类型
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        TextForSecond = TextForSecond.substring(1, TextForSecond.length());
        switch (TypeId) {
            case ID_CARD_BUY:
                if (!TitleForSecond.equals("") || TitleForSecond != null) {
                    mTextForSecond.setText(TextForSecond);
                }
                break;
            case ID_PRIVATE_CLASS:
                if (!TitleForSecond.equals("") || TitleForSecond != null) {
                    mTextForSecond.setText(TextForSecond + "节");
                }
                break;
            case ID_GROUPLESSON:
                if (!TitleForSecond.equals("") || TitleForSecond != null) {
                    mTextForSecond.setText(TextForSecond);
                }
                break;
            case ID_CARD_RENEWAL:
                if (ConsumeType.equals("0")){
                    mTextForFirst.setText(TextForFirst + "次");
                }else {
                    mTextForFirst.setText(TextForFirst + "天");
                }

        }


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
    public void succeed(AppBuyMemberLessonPayBean appBuyMemberLessonPayBean) {
        if (appBuyMemberLessonPayBean.getPayMode().equals("0")){
            OrderIdForWX orderIdForWX=new Gson().fromJson(appBuyMemberLessonPayBean.getMsg().toString(),OrderIdForWX.class);
            String mString = "{'appid':"+"'"+orderIdForWX.getParameterMap().getAppid()+"'"
                    +",'partnerid':"+"'"+orderIdForWX.getParameterMap().getPartnerid()+"'"
                    +",'prepayid':"+"'"+orderIdForWX.getParameterMap().getPrepayid()+"'"
                    +",'package':"+"'"+orderIdForWX.getParameterMap().getPackageX()+"'"
                    +",'noncestr':"+"'"+orderIdForWX.getParameterMap().getNoncestr()+"'"
                    +",'timestamp':"+"'"+orderIdForWX.getParameterMap().getTimestamp()+"'"
                    +",'sign':"+"'"+orderIdForWX.getParameterMap().getSign()+"'}";
            String wx_appid = "wxaf0ab09f52188483";//替换为自己的appid
            WXPay.init(getApplicationContext(), wx_appid);      //要在支付前调用
//            stringByKey(orderIdForWX.getParameterMap(),":",",");
            WXPay.getInstance().doPay(mString, new WXPay.WXPayResultCallBack() {
                @Override
                public void onSuccess() {
                    Toast.makeText(getApplication(), "支付成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, MainActivity.class);
                    intent.putExtra(PUT_STR + "AddAppointment", "3");
                    startActivity(intent);
                    finish();
                }
                @Override
                public void onError(int error_code) {
                    switch (error_code) {
                        case WXPay.NO_OR_LOW_WX:
                            Toast.makeText(getApplication(), "未安装微信或微信版本过低", Toast.LENGTH_SHORT).show();
                            break;

                        case WXPay.ERROR_PAY_PARAM:
                            Toast.makeText(getApplication(), "参数错误", Toast.LENGTH_SHORT).show();
                            break;

                        case WXPay.ERROR_PAY:
                            Toast.makeText(getApplication(), "支付失败", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

                @Override
                public void onCancel() {
                    Toast.makeText(getApplication(), "支付取消", Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            new Alipay(this, appBuyMemberLessonPayBean.getMsg(), new Alipay.AlipayResultCallBack() {
                @Override
                public void onSuccess() {
                    Toast.makeText(getApplication(), "支付成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, MainActivity.class);
                    intent.putExtra(PUT_STR + "AddAppointment", "3");
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onDealing() {
                    Toast.makeText(getApplication(), "支付处理中...", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(int error_code) {
                    switch (error_code) {
                        case Alipay.ERROR_RESULT:
                            Toast.makeText(getApplication(), "支付失败:支付结果解析错误", Toast.LENGTH_SHORT).show();
                            break;

                        case Alipay.ERROR_NETWORK:
                            Toast.makeText(getApplication(), "支付失败:网络连接错误", Toast.LENGTH_SHORT).show();
                            break;

                        case Alipay.ERROR_PAY:
                            Toast.makeText(getApplication(), "支付错误:支付码支付失败", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(getApplication(), "支付错误", Toast.LENGTH_SHORT).show();
                            break;
                    }

                }

                @Override
                public void onCancel() {
                    Toast.makeText(getApplication(), "支付取消", Toast.LENGTH_SHORT).show();
                }
            }).doPay();
        }

    }

    @Override
    public void succeedCard(NewAppBuyMemberCardPayBean newAppBuyMemberCardPayBean) {
        if (newAppBuyMemberCardPayBean.getPayMode().equals("0")){
            OrderIdForWX orderIdForWX=new Gson().fromJson(newAppBuyMemberCardPayBean.getMsg().toString(),OrderIdForWX.class);
            String mString = "{'appid':"+"'"+orderIdForWX.getParameterMap().getAppid()+"'"
                    +",'partnerid':"+"'"+orderIdForWX.getParameterMap().getPartnerid()+"'"
                    +",'prepayid':"+"'"+orderIdForWX.getParameterMap().getPrepayid()+"'"
                    +",'package':"+"'"+orderIdForWX.getParameterMap().getPackageX()+"'"
                    +",'noncestr':"+"'"+orderIdForWX.getParameterMap().getNoncestr()+"'"
                    +",'timestamp':"+"'"+orderIdForWX.getParameterMap().getTimestamp()+"'"
                    +",'sign':"+"'"+orderIdForWX.getParameterMap().getSign()+"'}";
            String wx_appid = "wxaf0ab09f52188483";//替换为自己的appid
            WXPay.init(getApplicationContext(), wx_appid);      //要在支付前调用
//            stringByKey(orderIdForWX.getParameterMap(),":",",");
            WXPay.getInstance().doPay(mString, new WXPay.WXPayResultCallBack() {
                @Override
                public void onSuccess() {
                    Toast.makeText(getApplication(), "支付成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, MainActivity.class);
                    intent.putExtra(PUT_STR + "AddAppointment", "3");
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onError(int error_code) {
                    switch (error_code) {
                        case WXPay.NO_OR_LOW_WX:
                            Toast.makeText(getApplication(), "未安装微信或微信版本过低", Toast.LENGTH_SHORT).show();
                            break;

                        case WXPay.ERROR_PAY_PARAM:
                            Toast.makeText(getApplication(), "参数错误", Toast.LENGTH_SHORT).show();
                            break;

                        case WXPay.ERROR_PAY:
                            Toast.makeText(getApplication(), "支付失败", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

                @Override
                public void onCancel() {
                    Toast.makeText(getApplication(), "支付取消", Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            new Alipay(this, newAppBuyMemberCardPayBean.getMsg(), new Alipay.AlipayResultCallBack() {
                @Override
                public void onSuccess() {
                    Toast.makeText(getApplication(), "支付成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, MainActivity.class);
                    intent.putExtra(PUT_STR + "AddAppointment", "3");
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onDealing() {
                    Toast.makeText(getApplication(), "支付处理中...", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(int error_code) {
                    switch (error_code) {
                        case Alipay.ERROR_RESULT:
                            Toast.makeText(getApplication(), "支付失败:支付结果解析错误", Toast.LENGTH_SHORT).show();
                            break;

                        case Alipay.ERROR_NETWORK:
                            Toast.makeText(getApplication(), "支付失败:网络连接错误", Toast.LENGTH_SHORT).show();
                            break;

                        case Alipay.ERROR_PAY:
                            Toast.makeText(getApplication(), "支付错误:支付码支付失败", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(getApplication(), "支付错误", Toast.LENGTH_SHORT).show();
                            break;
                    }

                }

                @Override
                public void onCancel() {
                    Toast.makeText(getApplication(), "支付取消", Toast.LENGTH_SHORT).show();
                }
            }).doPay();
        }


    }

    @Override
    public void succeedRenew(RenewMemberCardPayBean renewMemberCardPayBean) {
        if (renewMemberCardPayBean.getPayMode().equals("0")){
            OrderIdForWX orderIdForWX=new Gson().fromJson(renewMemberCardPayBean.getMsg().toString(),OrderIdForWX.class);
            String wx_appid = "wxaf0ab09f52188483";//替换为自己的appid
            WXPay.init(getApplicationContext(), wx_appid);      //要在支付前调用
            String mString = "{'appid':"+"'"+orderIdForWX.getParameterMap().getAppid()+"'"
                    +",'partnerid':"+"'"+orderIdForWX.getParameterMap().getPartnerid()+"'"
                    +",'prepayid':"+"'"+orderIdForWX.getParameterMap().getPrepayid()+"'"
                    +",'package':"+"'"+orderIdForWX.getParameterMap().getPackageX()+"'"
                    +",'noncestr':"+"'"+orderIdForWX.getParameterMap().getNoncestr()+"'"
                    +",'timestamp':"+"'"+orderIdForWX.getParameterMap().getTimestamp()+"'"
                    +",'sign':"+"'"+orderIdForWX.getParameterMap().getSign()+"'}";

//            stringByKey(orderIdForWX.getParameterMap(),":",",");
            WXPay.getInstance().doPay(mString, new WXPay.WXPayResultCallBack() {
                @Override
                public void onSuccess() {
                    Toast.makeText(getApplication(), "支付成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, MainActivity.class);
                    intent.putExtra(PUT_STR + "AddAppointment", "3");
                    startActivity(intent);
                    finish();

                }

                @Override
                public void onError(int error_code) {
                    switch (error_code) {
                        case WXPay.NO_OR_LOW_WX:
                            Toast.makeText(getApplication(), "未安装微信或微信版本过低", Toast.LENGTH_SHORT).show();
                            break;

                        case WXPay.ERROR_PAY_PARAM:
                            Toast.makeText(getApplication(), "参数错误", Toast.LENGTH_SHORT).show();
                            break;

                        case WXPay.ERROR_PAY:
                            Toast.makeText(getApplication(), "支付失败", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

                @Override
                public void onCancel() {
                    Toast.makeText(getApplication(), "支付取消", Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            new Alipay(this, renewMemberCardPayBean.getMsg(), new Alipay.AlipayResultCallBack() {
                @Override
                public void onSuccess() {
                    Toast.makeText(getApplication(), "支付成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, MainActivity.class);
                    intent.putExtra(PUT_STR + "AddAppointment", "3");
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onDealing() {
                    Toast.makeText(getApplication(), "支付处理中...", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(int error_code) {
                    switch (error_code) {
                        case Alipay.ERROR_RESULT:
                            Toast.makeText(getApplication(), "支付失败:支付结果解析错误", Toast.LENGTH_SHORT).show();
                            break;

                        case Alipay.ERROR_NETWORK:
                            Toast.makeText(getApplication(), "支付失败:网络连接错误", Toast.LENGTH_SHORT).show();
                            break;

                        case Alipay.ERROR_PAY:
                            Toast.makeText(getApplication(), "支付错误:支付码支付失败", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(getApplication(), "支付错误", Toast.LENGTH_SHORT).show();
                            break;
                    }

                }

                @Override
                public void onCancel() {
                    Toast.makeText(getApplication(), "支付取消", Toast.LENGTH_SHORT).show();
                }
            }).doPay();

        }
    }

    @Override
    public void succeedRenewLesson(AddFeeMemberLessonPayBean addFeeMemberLessonPayBean) {
        if (addFeeMemberLessonPayBean.getPayMode().equals("0")){
            OrderIdForWX orderIdForWX=new Gson().fromJson(addFeeMemberLessonPayBean.getMsg().toString(),OrderIdForWX.class);

            String mString = "{'appid':"+"'"+orderIdForWX.getParameterMap().getAppid()+"'"
                    +",'partnerid':"+"'"+orderIdForWX.getParameterMap().getPartnerid()+"'"
                    +",'prepayid':"+"'"+orderIdForWX.getParameterMap().getPrepayid()+"'"
                    +",'package':"+"'"+orderIdForWX.getParameterMap().getPackageX()+"'"
                    +",'noncestr':"+"'"+orderIdForWX.getParameterMap().getNoncestr()+"'"
                    +",'timestamp':"+"'"+orderIdForWX.getParameterMap().getTimestamp()+"'"
                    +",'sign':"+"'"+orderIdForWX.getParameterMap().getSign()+"'}";
            String wx_appid = "wxaf0ab09f52188483";//替换为自己的appid
            WXPay.init(getApplicationContext(), wx_appid);      //要在支付前调用
//            stringByKey(orderIdForWX.getParameterMap(),":",",");
            WXPay.getInstance().doPay(mString, new WXPay.WXPayResultCallBack() {
                @Override
                public void onSuccess() {
                    Toast.makeText(getApplication(), "支付成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, MainActivity.class);
                    intent.putExtra(PUT_STR + "AddAppointment", "3");
                    startActivity(intent);
                    finish();

                }

                @Override
                public void onError(int error_code) {
                    switch (error_code) {
                        case WXPay.NO_OR_LOW_WX:
                            Toast.makeText(getApplication(), "未安装微信或微信版本过低", Toast.LENGTH_SHORT).show();
                            break;

                        case WXPay.ERROR_PAY_PARAM:
                            Toast.makeText(getApplication(), "参数错误", Toast.LENGTH_SHORT).show();
                            break;

                        case WXPay.ERROR_PAY:
                            Toast.makeText(getApplication(), "支付失败", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

                @Override
                public void onCancel() {
                    Toast.makeText(getApplication(), "支付取消", Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            new Alipay(this, addFeeMemberLessonPayBean.getMsg(), new Alipay.AlipayResultCallBack() {
                @Override
                public void onSuccess() {
                    Toast.makeText(getApplication(), "支付成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, MainActivity.class);
                    intent.putExtra(PUT_STR + "AddAppointment", "3");
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onDealing() {
                    Toast.makeText(getApplication(), "支付处理中...", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(int error_code) {
                    switch (error_code) {
                        case Alipay.ERROR_RESULT:
                            Toast.makeText(getApplication(), "支付失败:支付结果解析错误", Toast.LENGTH_SHORT).show();
                            break;

                        case Alipay.ERROR_NETWORK:
                            Toast.makeText(getApplication(), "支付失败:网络连接错误", Toast.LENGTH_SHORT).show();
                            break;

                        case Alipay.ERROR_PAY:
                            Toast.makeText(getApplication(), "支付错误:支付码支付失败", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(getApplication(), "支付错误", Toast.LENGTH_SHORT).show();
                            break;
                    }

                }

                @Override
                public void onCancel() {
                    Toast.makeText(getApplication(), "支付取消", Toast.LENGTH_SHORT).show();
                }
            }).doPay();

        }
    }

    @Override
    public void succeedUpCard(UpMemberCardPayBean upMemberCardPayBean) {
        if (upMemberCardPayBean.getPayMode().equals("0")){
            OrderIdForWX orderIdForWX=new Gson().fromJson(upMemberCardPayBean.getMsg().toString(),OrderIdForWX.class);

            String mString = "{'appid':"+"'"+orderIdForWX.getParameterMap().getAppid()+"'"
                    +",'partnerid':"+"'"+orderIdForWX.getParameterMap().getPartnerid()+"'"
                    +",'prepayid':"+"'"+orderIdForWX.getParameterMap().getPrepayid()+"'"
                    +",'package':"+"'"+orderIdForWX.getParameterMap().getPackageX()+"'"
                    +",'noncestr':"+"'"+orderIdForWX.getParameterMap().getNoncestr()+"'"
                    +",'timestamp':"+"'"+orderIdForWX.getParameterMap().getTimestamp()+"'"
                    +",'sign':"+"'"+orderIdForWX.getParameterMap().getSign()+"'}";
            String wx_appid = "wxaf0ab09f52188483";//替换为自己的appid
            WXPay.init(getApplicationContext(), wx_appid);      //要在支付前调用
//            stringByKey(orderIdForWX.getParameterMap(),":",",");
            WXPay.getInstance().doPay(mString, new WXPay.WXPayResultCallBack() {
                @Override
                public void onSuccess() {
                    Toast.makeText(getApplication(), "支付成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, MainActivity.class);
                    intent.putExtra(PUT_STR + "AddAppointment", "3");
                    startActivity(intent);
                    finish();

                }

                @Override
                public void onError(int error_code) {
                    switch (error_code) {
                        case WXPay.NO_OR_LOW_WX:
                            Toast.makeText(getApplication(), "未安装微信或微信版本过低", Toast.LENGTH_SHORT).show();
                            break;

                        case WXPay.ERROR_PAY_PARAM:
                            Toast.makeText(getApplication(), "参数错误", Toast.LENGTH_SHORT).show();
                            break;

                        case WXPay.ERROR_PAY:
                            Toast.makeText(getApplication(), "支付失败", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

                @Override
                public void onCancel() {
                    Toast.makeText(getApplication(), "支付取消", Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            new Alipay(this, upMemberCardPayBean.getMsg(), new Alipay.AlipayResultCallBack() {
                @Override
                public void onSuccess() {
                    Toast.makeText(getApplication(), "支付成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, MainActivity.class);
                    intent.putExtra(PUT_STR + "AddAppointment", "3");
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onDealing() {
                    Toast.makeText(getApplication(), "支付处理中...", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(int error_code) {
                    switch (error_code) {
                        case Alipay.ERROR_RESULT:
                            Toast.makeText(getApplication(), "支付失败:支付结果解析错误", Toast.LENGTH_SHORT).show();
                            break;

                        case Alipay.ERROR_NETWORK:
                            Toast.makeText(getApplication(), "支付失败:网络连接错误", Toast.LENGTH_SHORT).show();
                            break;

                        case Alipay.ERROR_PAY:
                            Toast.makeText(getApplication(), "支付错误:支付码支付失败", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(getApplication(), "支付错误", Toast.LENGTH_SHORT).show();
                            break;
                    }

                }

                @Override
                public void onCancel() {
                    Toast.makeText(getApplication(), "支付取消", Toast.LENGTH_SHORT).show();
                }
            }).doPay();

        }
    }

    @OnClick(R.id.btn_submit)
    public void onViewClicked() {

        switch (TypeId) {

            case ID_CARD_BUY:
                mPresenter.appBuyMemberCardPay(String.valueOf(UserId),
                        token,
                        ClubId,
                        MemberCardTypeId,
                        TextForFirst,
                        TextForSecond,
                        String.valueOf(mTextMoneyTotal),
                        wxpayId.isChecked() ? "0" : "1");
                break;
            case ID_PRIVATE_CLASS:
                mPresenter.appBuyMemberLessonPay(String.valueOf(UserId),
                        token,
                        ClubId,
                        String.valueOf(LessonId),
                        String.valueOf(TeacherId),
                        TextForSecond,
                        Price,
                        Double.valueOf(mTextMoneyTotal),
                        wxpayId.isChecked() ? "0" : "1");
                break;
            case ID_GROUPLESSON:

                break;
            case ID_CARD_RENEWAL:
                mPresenter.appRenewMemberCardPay(String.valueOf(UserId),
                        token,
                        ClubId,
                        MemberCardId,
                        TextForFirst,
                        TextForSecond,
                        mTextMoneyTotal,
                        wxpayId.isChecked() ? "0" : "1");
                break;
            case ID_PRIVATE_CLASS_RENEWAL:
                mPresenter.appRenewMemberLessonPay(String.valueOf(UserId),
                        token,
                        ClubId,
                        Id,
                        TextForFirst,
                        TextForSecond,
                        mTextMoneyTotal,
                        wxpayId.isChecked() ? "0" : "1");
                break;
            case ID_CARD_UP:
                mPresenter.appUpMemberCardPay(String.valueOf(UserId),
                        token,
                        ClubId,
                        MemberCardId,
                        NewMemberCardTypeId,
                        mTextMoneyTotal,
                        wxpayId.isChecked() ? "0" : "1");
                break;
        }

    }
    public static String stringByKey(Map<String, String> map, String eqaulsType,
                                     String spliceType) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() == 0) {
                sb.append(entry.getKey()).append(eqaulsType).append(entry.getValue());
            } else {
                sb.append(spliceType).append(entry.getKey()).append(eqaulsType)
                        .append(entry.getValue());
            }
        }

        return sb.toString();
    }
}


