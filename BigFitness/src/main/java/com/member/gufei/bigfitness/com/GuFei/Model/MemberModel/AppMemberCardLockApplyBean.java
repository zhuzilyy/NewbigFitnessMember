package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

/**
 * Created by GuFei on 2018/3/27.
 * #会员卡冻结申请

 */

public class AppMemberCardLockApplyBean {


    /**
     * Ret : 6
     * Msg : 冻结开始时间或冻结结束时间不正确！
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
