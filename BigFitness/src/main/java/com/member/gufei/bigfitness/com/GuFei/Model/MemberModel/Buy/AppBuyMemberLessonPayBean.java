package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy;

/**
 * Created by LiuShengYuan on 2018/8/29.
 *
 * APP支付订单信息

 */
public class AppBuyMemberLessonPayBean {

    /**
     * Msg : {"parameterMap":{"appid":"wxaf0ab09f52188483","noncestr":"Eyh7tP1AC0oFQ8PlNwHqkdFi7J33ZS02","package":"Sign=WXPay","partnerid":"1500099612","prepayid":"wx29143754713497d0951d76181630700725","sign":"6D2BEABD8F7537FEDD325970F66C6FC6","timestamp":1535524673}}
     * Ret : 0
     * Price : 0.1
     * APPUserId : 18
     * LessonId : 30
     * Amount : 1
     * TotalMoney : 0.1
     * OrderId : 0420180829143752644
     * ClubId : 15
     * TeacherId : 496
     * PayMode : 0
     * token : eyJBbGciOiJNRDUifQ==.eyJVc2VySWQiOjE4LCJDcmVhdGVUaW1lIjoiMjAxOC0wOC0yOSAxNDozNzoxNCIsIkRldmljZUNvZGUiOiI5MTYwYmFiZDkzZDNhN2E0MGNmZThjODMyMzExOGRhOSJ9.29fe48e5c6515c5cab1ba0882da1af66
     */

    private String Msg;
    private int Ret;
    private String Price;
    private String APPUserId;
    private String LessonId;
    private String Amount;
    private String TotalMoney;
    private String OrderId;
    private String ClubId;
    private String TeacherId;
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

    public String getLessonId() {
        return LessonId;
    }

    public void setLessonId(String LessonId) {
        this.LessonId = LessonId;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
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

    public String getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(String TeacherId) {
        this.TeacherId = TeacherId;
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
