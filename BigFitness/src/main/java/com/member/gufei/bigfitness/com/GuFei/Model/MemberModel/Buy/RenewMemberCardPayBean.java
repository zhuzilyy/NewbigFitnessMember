package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy;

/**
 * Created by LiuShengYuan on 2018/9/7.
 */

public class RenewMemberCardPayBean {

    /**
     * Msg : alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2018062960423509&biz_content=%7B%22body%22%3A%22%E8%AE%A2%E5%8D%95%E8%AF%A6%E6%83%85%3A%E7%BB%AD%E8%B4%B9%E4%BC%9A%E5%91%98%E5%8D%A1%3A%E6%B5%8B%E8%AF%95%E5%8D%A1.+%E8%B4%AD%E4%B9%B0%E5%8D%95%E4%BB%B7%3A0.01.+%E8%B4%AD%E4%B9%B0%E6%95%B0%E9%87%8F%3A1.+%E6%80%BB%E9%87%91%E9%A2%9D%3A0.01%22%2C%22out_trade_no%22%3A%220220180907160232496%22%2C%22passback_params%22%3A%22%257B%2522Price%2522%253A%25220.01%2522%252C%2522APPUserId%2522%253A%252222%2522%252C%2522Amount%2522%253A%25221%2522%252C%2522TotalMoney%2522%253A%25220.01%2522%252C%2522MemberCardId%2522%253A%2522165482%2522%252C%2522ClubId%2522%253A%252215%2522%257D%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E7%BB%AD%E8%B4%B9%E4%BC%9A%E5%91%98%E5%8D%A1%3A%E6%B5%8B%E8%AF%95%E5%8D%A1%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%220.01%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fwww.18bai6.cn%3A8080%2FappPay%2Falipay%2FasynchronousNotify&sign=SK3hKtP6wHzJFB9NrR%2BRxgM9OwKaFre4UmQyYZlqG%2F%2BFeDMmXi1wRnJmZKZvtkE3IQ5Ra3eMUHIDSiOAmiKDu3uNCB1Aaz9j3nzPn5giXh3BIx%2BfFcYRgz8T1DZSRGjCeN0gAKatcc2tPQjiR2sK80kmzf9%2B7ccUItPtJkeccw5KrpevvywFu23fapB5xBR%2FcKpinm%2Bj%2BC2blJAGt7mvL%2FxC1GM5u%2BZjatCKjSfEfsL0MJHXan2q6EcE95D5JKzo3Lj6L3w%2FHL9iTY6VgGEQa8kwAnoD7VijQoYLHrG2BJMD0rz3zqr2luWM%2FHUmHATesWgA6qfi7d4fYlc4%2F3jMrg%3D%3D&sign_type=RSA2&timestamp=2018-09-07+16%3A02%3A32&version=1.0
     * Ret : 0
     * Price : 0.01
     * APPUserId : 22
     * Amount : 1
     * Token : eyJBbGciOiJNRDUifQ==.eyJVc2VySWQiOjIyLCJDcmVhdGVUaW1lIjoiMjAxOC0wOS0wNyAxNjowMTo1OSIsIkRldmljZUNvZGUiOiJjODcxMTk1MDQ3ZTYxYzQ5OGQwNTZjNjc2ZjY1OWJlYSJ9.0c3b0c565ed5516c84d09b7a0fe0b1bc
     * TotalMoney : 0.01
     * MemberCardId : 165482
     * OrderId : 0220180907160232496
     * ClubId : 15
     * PayMode : 1
     */

    private String Msg;
    private int Ret;
    private String Price;
    private String APPUserId;
    private String Amount;
    private String Token;
    private String TotalMoney;
    private String MemberCardId;
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

    public String getMemberCardId() {
        return MemberCardId;
    }

    public void setMemberCardId(String MemberCardId) {
        this.MemberCardId = MemberCardId;
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
