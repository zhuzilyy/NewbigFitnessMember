package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy;

/**
 * Created by LiuShengYuan on 2018/9/3.
 * #会员卡购买-支付

 */

public class NewAppBuyMemberCardPayBean {

    /**
     * Msg : {"parameterMap":{"appid":"wxaf0ab09f52188483","noncestr":"VI93GH7MTGGHhTI5e2fg1dsWvwE8AIZQ","package":"Sign=WXPay","partnerid":"1500099612","prepayid":"wx03112920468550b4d5d68d6f3926781697","sign":"A2FA93295A8BACFD7CFAB72A88292B4A","timestamp":1535945359}}
     * Ret : 0
     * Price : 0.01
     * APPUserId : 18
     * Amount : 1
     * MemberCardTypeId : 275
     * TotalMoney : 0.01
     * OrderId : 0120180903112918433
     * ClubId : 15
     * PayMode : 0
     * token : eyJBbGciOiJNRDUifQ==.eyJVc2VySWQiOjE4LCJDcmVhdGVUaW1lIjoiMjAxOC0wOS0wMyAxMToyNzo0MiIsIkRldmljZUNvZGUiOiJjOWFiOWIzYzg4YzU0ZmNjN2IxYmEwNmMyNjIwY2Q4NCJ9.7997baf7035177d8ef4dc47597ded957
     */

    private String Msg;
    private int Ret;
    private String Price;
    private String APPUserId;
    private String Amount;
    private String MemberCardTypeId;
    private String TotalMoney;
    private String OrderId;
    private String ClubId;
    private String PayMode;
    private String token;

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public int getRet() {
        return Ret;
    }

    public void setRet(int Ret) {
        this.Ret = Ret;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getAPPUserId() {
        return APPUserId;
    }

    public void setAPPUserId(String APPUserId) {
        this.APPUserId = APPUserId;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    public String getMemberCardTypeId() {
        return MemberCardTypeId;
    }

    public void setMemberCardTypeId(String MemberCardTypeId) {
        this.MemberCardTypeId = MemberCardTypeId;
    }

    public String getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(String TotalMoney) {
        this.TotalMoney = TotalMoney;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
    }

    public String getClubId() {
        return ClubId;
    }

    public void setClubId(String ClubId) {
        this.ClubId = ClubId;
    }

    public String getPayMode() {
        return PayMode;
    }

    public void setPayMode(String PayMode) {
        this.PayMode = PayMode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
