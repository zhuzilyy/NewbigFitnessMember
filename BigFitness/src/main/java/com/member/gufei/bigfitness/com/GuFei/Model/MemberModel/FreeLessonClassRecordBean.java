package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/6/10.
 */

public class FreeLessonClassRecordBean {

    /**
     * Ret : 0
     * Msg :
     * TotalPage : 1
     * rows : [{"AppointmentId":281,"IsEvaluated":0,"FreeLessonId":36,"ClassTime":"2017-08-18 12:00-12:50","TeacherName":null,"FLessonName":null},{"AppointmentId":282,"IsEvaluated":0,"FreeLessonId":1009,"ClassTime":"2017-08-18 12:00-12:50","TeacherName":"汉MI","FLessonName":"普拉提"},{"AppointmentId":283,"IsEvaluated":0,"FreeLessonId":1049,"ClassTime":"2017-08-21 12:00-12:50","TeacherName":"文慧","FLessonName":"瑜伽"},{"AppointmentId":284,"IsEvaluated":0,"FreeLessonId":1202,"ClassTime":"2017-09-10 18:00-19:00","TeacherName":"吴京","FLessonName":"动感单车"},{"AppointmentId":285,"IsEvaluated":0,"FreeLessonId":1200,"ClassTime":"2017-09-09 18:00-19:00","TeacherName":"李连杰","FLessonName":"动感单车"},{"AppointmentId":289,"IsEvaluated":0,"FreeLessonId":1203,"ClassTime":"2017-09-11 18:00-19:00","TeacherName":"张学友","FLessonName":"高温瑜伽"}]
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
         * AppointmentId : 281
         * IsEvaluated : 0
         * FreeLessonId : 36
         * ClassTime : 2017-08-18 12:00-12:50
         * TeacherName : null
         * FLessonName : null
         */

        private int AppointmentId;
        private int IsEvaluated;
        private int FreeLessonId;
        private String ClassTime;
        private String TeacherName;
        private String FLessonName;

        public int getAppointmentId() {
            return AppointmentId;
        }

        public void setAppointmentId(int AppointmentId) {
            this.AppointmentId = AppointmentId;
        }

        public int getIsEvaluated() {
            return IsEvaluated;
        }

        public void setIsEvaluated(int IsEvaluated) {
            this.IsEvaluated = IsEvaluated;
        }

        public int getFreeLessonId() {
            return FreeLessonId;
        }

        public void setFreeLessonId(int FreeLessonId) {
            this.FreeLessonId = FreeLessonId;
        }

        public String getClassTime() {
            return ClassTime;
        }

        public void setClassTime(String ClassTime) {
            this.ClassTime = ClassTime;
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
    }
}
