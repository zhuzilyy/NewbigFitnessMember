package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy;

/**
 * Created by GuFei on 2018/3/27.
 *
 * APP支付订单信息

 */

public class AppBuyLessonPayBean {


    /**
     * Msg : {"parameterMap":{"appid":"wxaf0ab09f52188483","noncestr":"aYbkmAyz5e6pJtsRtKmL73NhziJNwvkq","package":"Sign=WXPay","partnerid":"1500099612","prepayid":"wx2110330210155657cd0a4cae3703709557","sign":"B3C94E753B5F6DFEEA7239EF8BE53515","timestamp":1529548374305}}
     * Ret : 0
     * OrderId : 0420180621103253930
     */

    private String Msg;
    private int Ret;
    private String OrderId;

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

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
    }
}
