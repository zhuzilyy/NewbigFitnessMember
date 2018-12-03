package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/4/19.
 */

public class ClubFLessonListBean {

    /**
     * Ret : 0
     * Msg :
     * TotalPage : 1
     * rows : [{"FLessonId":0,"NowPersonCount":0,"EndTime":"02:00","IsAllowAppointment":1,"AppointmentId":0,"StartTime":"01:00","ImageURL":"","MaxPersonCount":0,"IsAppointment":0,"TeacherName":"","FLessonName":null,"LessonDate":"2017-11-20"}]
     */

    private int Ret;
    private String Msg;
    private int TotalPage;
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

    public int getTotalPage() {
        return TotalPage;
    }

    public void setTotalPage(int TotalPage) {
        this.TotalPage = TotalPage;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * FLessonId : 0
         * NowPersonCount : 0
         * EndTime : 02:00
         * IsAllowAppointment : 1
         * AppointmentId : 0
         * StartTime : 01:00
         * ImageURL :
         * MaxPersonCount : 0
         * IsAppointment : 0
         * TeacherName :
         * FLessonName : null
         * LessonDate : 2017-11-20
         */

        private int FLessonId;
        private int NowPersonCount;
        private String EndTime;
        private int IsAllowAppointment;
        private int AppointmentId;
        private String StartTime;
        private String ImageURL;
        private int MaxPersonCount;
        private int IsAppointment;
        private String TeacherName;
        private String FLessonName;
        private String LessonDate;

        public int getFLessonId() {
            return FLessonId;
        }

        public void setFLessonId(int FLessonId) {
            this.FLessonId = FLessonId;
        }

        public int getNowPersonCount() {
            return NowPersonCount;
        }

        public void setNowPersonCount(int NowPersonCount) {
            this.NowPersonCount = NowPersonCount;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public int getIsAllowAppointment() {
            return IsAllowAppointment;
        }

        public void setIsAllowAppointment(int IsAllowAppointment) {
            this.IsAllowAppointment = IsAllowAppointment;
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

        public String getImageURL() {
            return ImageURL;
        }

        public void setImageURL(String ImageURL) {
            this.ImageURL = ImageURL;
        }

        public int getMaxPersonCount() {
            return MaxPersonCount;
        }

        public void setMaxPersonCount(int MaxPersonCount) {
            this.MaxPersonCount = MaxPersonCount;
        }

        public int getIsAppointment() {
            return IsAppointment;
        }

        public void setIsAppointment(int IsAppointment) {
            this.IsAppointment = IsAppointment;
        }

        public String getTeacherName() {
            return TeacherName;
        }

        public void setTeacherName(String TeacherName) {
            this.TeacherName = TeacherName;
        }

        public String getFLessonName() {
            return FLessonName;
        }

        public void setFLessonName(String FLessonName) {
            this.FLessonName = FLessonName;
        }

        public String getLessonDate() {
            return LessonDate;
        }

        public void setLessonDate(String LessonDate) {
            this.LessonDate = LessonDate;
        }
    }
}
