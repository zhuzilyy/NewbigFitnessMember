package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by LiuShengYuan on 2018/9/17.
 */

public class DistanceClassTimeBean {

    /**
     * Ret : 2
     * Msg : 课程未开始！
     * rows : {"IsSignIn":0,"SignInTime":"","Position":[],"DistanceClassStartTime":11290,"LessonLen":60}
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
         * IsSignIn : 0
         * SignInTime :
         * Position : []
         * DistanceClassStartTime : 11290
         * LessonLen : 60
         */

        private int IsSignIn;
        private String SignInTime;
        private int DistanceClassStartTime;
        private int LessonLen;
        private List<?> Position;

        public int getIsSignIn() {
            return IsSignIn;
        }

        public void setIsSignIn(int IsSignIn) {
            this.IsSignIn = IsSignIn;
        }

        public String getSignInTime() {
            return SignInTime;
        }

        public void setSignInTime(String SignInTime) {
            this.SignInTime = SignInTime;
        }

        public int getDistanceClassStartTime() {
            return DistanceClassStartTime;
        }

        public void setDistanceClassStartTime(int DistanceClassStartTime) {
            this.DistanceClassStartTime = DistanceClassStartTime;
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
