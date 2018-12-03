package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/6/16.
 */

public class TeacherScheduleDayBean {

    /**
     * Ret : 0
     * Msg : 私教课预约成功!
     * rows : [{"EndTime":"2018-06-17 12:00:00","AppointmentId":107,"StartTime":"2018-06-17 11:05:00","LessonName":"240私教"},{"EndTime":"2018-06-16 19:40:00","AppointmentId":136,"StartTime":"2018-06-16 18:40:00","LessonName":"240私教"}]
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
         * EndTime : 2018-06-17 12:00:00
         * AppointmentId : 107
         * StartTime : 2018-06-17 11:05:00
         * LessonName : 240私教
         */

        private String EndTime;
        private int AppointmentId;
        private String StartTime;
        private String LessonName;

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
    }
}
