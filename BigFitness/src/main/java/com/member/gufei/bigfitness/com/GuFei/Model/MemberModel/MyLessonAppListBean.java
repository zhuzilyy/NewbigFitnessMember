package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/6/15.
 */

public class MyLessonAppListBean {


    /**
     * Ret : 0
     * Msg :
     * TotalPage : 1
     * rows : [{"ClassStatus":0,"EndTime":"13:00","AppointmentId":234,"AppointmentOwner":1,"StartTime":"2018/09/12 12:00","AppointmentCata":0,"IsForClass":0,"AppointmentStatus":4,"LessonName":"腹肌有氧","LessonLen":0,"TeacherName":"罗小熙"},{"ClassStatus":0,"EndTime":"12:00","AppointmentId":233,"AppointmentOwner":1,"StartTime":"2018/09/12 11:00","AppointmentCata":0,"IsForClass":0,"AppointmentStatus":4,"LessonName":"腹肌有氧","LessonLen":0,"TeacherName":"罗小熙"},{"ClassStatus":0,"EndTime":"13:00","AppointmentId":179,"AppointmentOwner":0,"StartTime":"2018/08/31 12:00","AppointmentCata":0,"IsForClass":0,"AppointmentStatus":4,"LessonName":"减脂课","LessonLen":0,"TeacherName":"郭小晏"},{"ClassStatus":0,"EndTime":"13:00","AppointmentId":178,"AppointmentOwner":1,"StartTime":"2018/08/31 12:00","AppointmentCata":0,"IsForClass":0,"AppointmentStatus":3,"LessonName":"减脂课","LessonLen":0,"TeacherName":"郭小晏"},{"ClassStatus":0,"EndTime":"12:00","AppointmentId":177,"AppointmentOwner":1,"StartTime":"2018/08/31 11:00","AppointmentCata":0,"IsForClass":0,"AppointmentStatus":3,"LessonName":"减脂课","LessonLen":0,"TeacherName":"郭小晏"}]
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
         * ClassStatus : 0
         * EndTime : 13:00
         * AppointmentId : 234
         * AppointmentOwner : 1
         * StartTime : 2018/09/12 12:00
         * AppointmentCata : 0
         * IsForClass : 0
         * AppointmentStatus : 4
         * LessonName : 腹肌有氧
         * LessonLen : 0
         * TeacherName : 罗小熙
         * IsExpire:0
         */

        private int ClassStatus;
        private String EndTime;
        private int AppointmentId;
        private int AppointmentOwner;
        private String StartTime;
        private int AppointmentCata;
        private int IsForClass;
        private int AppointmentStatus;
        private String LessonName;
        private int LessonLen;
        private String TeacherName;
        private int IsExpire;

        public int getClassStatus() {
            return ClassStatus;
        }

        public void setClassStatus(int ClassStatus) {
            this.ClassStatus = ClassStatus;
        }

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

        public int getAppointmentOwner() {
            return AppointmentOwner;
        }

        public void setAppointmentOwner(int AppointmentOwner) {
            this.AppointmentOwner = AppointmentOwner;
        }

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(String StartTime) {
            this.StartTime = StartTime;
        }

        public int getAppointmentCata() {
            return AppointmentCata;
        }

        public void setAppointmentCata(int AppointmentCata) {
            this.AppointmentCata = AppointmentCata;
        }

        public int getIsForClass() {
            return IsForClass;
        }

        public void setIsForClass(int IsForClass) {
            this.IsForClass = IsForClass;
        }

        public int getAppointmentStatus() {
            return AppointmentStatus;
        }

        public void setAppointmentStatus(int AppointmentStatus) {
            this.AppointmentStatus = AppointmentStatus;
        }

        public String getLessonName() {
            return LessonName;
        }

        public void setLessonName(String LessonName) {
            this.LessonName = LessonName;
        }

        public int getLessonLen() {
            return LessonLen;
        }

        public void setLessonLen(int LessonLen) {
            this.LessonLen = LessonLen;
        }

        public String getTeacherName() {
            return TeacherName;
        }

        public void setTeacherName(String TeacherName) {
            this.TeacherName = TeacherName;
        }

        public int getIsExpire() {
            return IsExpire;
        }

        public void setIsExpire(int isExpire) {
            IsExpire = isExpire;
        }
    }
}
