package com.member.gufei.bigfitness.com.GuFei.Model;

public class TimeBean {
    /**
     * Ret : 0
     * Msg : 操作成功!
     * rows : {"SignInTime":"2018-07-11 13:29:40","PlanFinishTime":"2018-07-11 20:02:52","LessonLen":60}
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
         * SignInTime : 2018-07-11 13:29:40
         * PlanFinishTime : 2018-07-11 20:02:52
         * LessonLen : 60
         */

        private String SignInTime;
        private String PlanFinishTime;
        private int LessonLen;

        public String getSignInTime() {
            return SignInTime;
        }

        public void setSignInTime(String SignInTime) {
            this.SignInTime = SignInTime;
        }

        public String getPlanFinishTime() {
            return PlanFinishTime;
        }

        public void setPlanFinishTime(String PlanFinishTime) {
            this.PlanFinishTime = PlanFinishTime;
        }

        public int getLessonLen() {
            return LessonLen;
        }

        public void setLessonLen(int LessonLen) {
            this.LessonLen = LessonLen;
        }
    }
}
