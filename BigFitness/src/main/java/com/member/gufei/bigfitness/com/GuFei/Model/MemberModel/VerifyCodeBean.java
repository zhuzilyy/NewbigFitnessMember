package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

/**
 * Created by GuFei on 2018/6/14.
 */

public  class VerifyCodeBean {


    /**
     * Ret : 0
     * Msg :
     * VerifyCode : 717858
     */

    private int Ret;
    private String Msg;
    private String VerifyCode;

    public int getRet() {
        return Ret;
    }

    public void setRet(int Ret) {
        this.Ret = Ret;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public String getVerifyCode() {
        return VerifyCode;
    }

    public void setVerifyCode(String VerifyCode) {
        this.VerifyCode = VerifyCode;
    }
}
