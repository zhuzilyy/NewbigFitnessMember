package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

public class VerificationAccountNameBean {

    /**
     * Ret : 1
     * Msg : 您输入的用户名系统中已存在，请重新输入！
     */

    private int Ret;
    private String Msg;

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
}
