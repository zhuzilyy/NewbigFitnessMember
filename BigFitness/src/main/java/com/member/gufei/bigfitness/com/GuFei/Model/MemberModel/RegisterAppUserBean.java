package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

/**
 * Created by GuFei on 2018/3/27.
 */

public class RegisterAppUserBean {
    /**
     * Ret : 0
     * Msg : 用户注册成功！
     * rows : {"APPUserId":52,"AccountName":"tre"}
     */

    private int Ret;
    private String Msg;
    private RowsBean rows;

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

    public RowsBean getRows() {
        return rows;
    }

    public void setRows(RowsBean rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * APPUserId : 52
         * AccountName : tre
         */

        private int APPUserId;
        private String AccountName;

        public int getAPPUserId() {
            return APPUserId;
        }

        public void setAPPUserId(int APPUserId) {
            this.APPUserId = APPUserId;
        }

        public String getAccountName() {
            return AccountName;
        }

        public void setAccountName(String AccountName) {
            this.AccountName = AccountName;
        }
    }
}
