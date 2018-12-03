package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy;
/**
 * Created by LiuShengYuan on 2018/9/11.
 *

 */

public class AddFeeMemberLessonPayBean {

    /**
     * Msg : {"parameterMap":{"appid":"wxaf0ab09f52188483","noncestr":"e6VJjPYg9WJbhARSDvM7YhtqAwGSDolv","package":"Sign=WXPay","partnerid":"1500099612","prepayid":"wx11101616980282d6435803c71520335910","sign":"74A8BD212E72BF36B7C8BF7B442CC795","timestamp":1536632175}}
     * Ret : 0
     * Price : 0.1
     * APPUserId : 22
     * Amount : 15
     * Token : eyJBbGciOiJNRDUifQ==.eyJVc2VySWQiOjIyLCJDcmVhdGVUaW1lIjoiMjAxOC0wOS0xMSAxMDoxNDo1OSIsIkRldmljZUNvZGUiOiIyMDQ0YThhZGZhN2EwZTQwYjNmZTBhOTZkMjQ5NjAxOSJ9.d005aff66dbf11fddd6f8d5be0cf546f
     * TotalMoney : 1.5
     * Id : 2524
     * OrderId : 0620180911101614840
     * ClubId : 15
     * PayMode : 0
     */

    private String Msg;
    private int Ret;
    private String Price;
    private String APPUserId;
    private String Amount;
    private String Token;
    private String TotalMoney;
    private String Id;
    private String OrderId;
    private String ClubId;
    private String PayMode;

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

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public String getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(String TotalMoney) {
        this.TotalMoney = TotalMoney;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
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
}
