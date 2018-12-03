package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;
/**
 * Created by LiuShengYuan on 2018/9/27.
 *
 */

public class MemberIdBean {

    /**
     * Ret : 0
     * Msg :
     * rows : {"MemberId":0,"IsLock":0}
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
         * MemberId : 0
         * IsLock : 0
         */

        private int MemberId;
        private int IsLock;

        public int getMemberId() {
            return MemberId;
        }

        public void setMemberId(int MemberId) {
            this.MemberId = MemberId;
        }

        public int getIsLock() {
            return IsLock;
        }

        public void setIsLock(int IsLock) {
            this.IsLock = IsLock;
        }
    }
}
