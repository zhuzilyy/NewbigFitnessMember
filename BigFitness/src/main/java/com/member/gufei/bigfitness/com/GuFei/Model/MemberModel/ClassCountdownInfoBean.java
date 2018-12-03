package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by LiuShengYuan on 2018/9/18.
 */

public class ClassCountdownInfoBean {

    /**
     * Ret : 0
     * Msg : 操作成功!
     * rows : {"SignInTime":"2018-09-18 15:43:21","Position":[],"PlanFinishTime":"2018-09-18 16:43:21","LessonLen":0}
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
         * SignInTime : 2018-09-18 15:43:21
         * Position : []
         * PlanFinishTime : 2018-09-18 16:43:21
         * LessonLen : 0
         */

        private String SignInTime;
        private String PlanFinishTime;
        private int LessonLen;
        private List<?> Position;

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

        public List<?> getPosition() {
            return Position;
        }

        public void setPosition(List<?> Position) {
            this.Position = Position;
        }
    }
}
