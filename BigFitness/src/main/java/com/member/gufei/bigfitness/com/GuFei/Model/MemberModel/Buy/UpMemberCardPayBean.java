package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy;
/**
 * Created by LiuShengYuan on 2018/9/11.
 */
public class UpMemberCardPayBean {

    /**
     * Msg : {"parameterMap":{"appid":"wxaf0ab09f52188483","noncestr":"sljVamnW9iV7lKMTa83r0ffXyNaKaILL","package":"Sign=WXPay","partnerid":"1500099612","prepayid":"wx111421277192183b47826b8a1841345528","sign":"6BD512C495BACA440D1187C49B224AD7","timestamp":1536646886}}
     * Ret : 0
     * APPUserId : 22
     * Token : eyJBbGciOiJNRDUifQ==.eyJVc2VySWQiOjIyLCJDcmVhdGVUaW1lIjoiMjAxOC0wOS0xMSAxNDoxODoyNiIsIkRldmljZUNvZGUiOiIyMDQ0YThhZGZhN2EwZTQwYjNmZTBhOTZkMjQ5NjAxOSJ9.a7c87aeee39989264f70690bb45751dd
     * TotalMoney : 999.9
     * MemberCardId : 165495
     * NewMemberCardTypeId : 139
     * OrderId : 0320180911142125833
     * ClubId : 15
     * PayMode : 0
     */

    private String Msg;
    private int Ret;
    private String APPUserId;
    private String Token;
    private String TotalMoney;
    private String MemberCardId;
    private String NewMemberCardTypeId;
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

    public String getAPPUserId() {
        return APPUserId;
    }

    public void setAPPUserId(String APPUserId) {
        this.APPUserId = APPUserId;
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

    public String getNewMemberCardTypeId() {
        return NewMemberCardTypeId;
    }

    public void setNewMemberCardTypeId(String NewMemberCardTypeId) {
        this.NewMemberCardTypeId = NewMemberCardTypeId;
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
