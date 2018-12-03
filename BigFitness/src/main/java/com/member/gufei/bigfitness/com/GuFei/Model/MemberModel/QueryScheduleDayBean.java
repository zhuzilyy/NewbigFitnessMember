package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/6/13.
 */

public class QueryScheduleDayBean {


    /**
     * Ret : 0
     * Msg : 操作成功!
     * rows : [{"EndTime":"21:00","AppointmentId":106,"LessonId":28,"StartTime":"20:00","LessonName":"减脂","AppointmentDate":"2018-06-13","TeacherName":"王晓峰"}]
     */

    private int Ret;
    private String Msg;
    private List<RowsBean> rows;

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

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * EndTime : 21:00
         * AppointmentId : 106
         * IsSignIn : 0
         * LessonId : 28
         * StartTime : 20:00
         * LessonName : 减脂
         * AppointmentDate : 2018-06-13
         * TeacherName : 王晓峰
         */

        private String EndTime;
        private int AppointmentId;
        private int LessonId;
        private int IsSignIn;
        private String StartTime;
        private String LessonName;
        private String AppointmentDate;
        private String TeacherName;

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public int getAppointmentId() {
            return AppointmentId;
        }

        public void setAppointmentId(int AppointmentId) {
            this.AppointmentId = AppointmentId;
        }

        public int getLessonId() {
            return LessonId;
        }

        public void setLessonId(int LessonId) {
            this.LessonId = LessonId;
        }

        public int getIsSignIn() {
            return IsSignIn;
        }

        public void setIsSignIn(int isSignIn) {
            IsSignIn = isSignIn;
        }

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(String StartTime) {
            this.StartTime = StartTime;
        }

        public String getLessonName() {
            return LessonName;
        }

        public void setLessonName(String LessonName) {
            this.LessonName = LessonName;
        }

        public String getAppointmentDate() {
            return AppointmentDate;
        }

        public void setAppointmentDate(String AppointmentDate) {
            this.AppointmentDate = AppointmentDate;
        }

        public String getTeacherName() {
            return TeacherName;
        }

        public void setTeacherName(String TeacherName) {
            this.TeacherName = TeacherName;
        }
    }
}
