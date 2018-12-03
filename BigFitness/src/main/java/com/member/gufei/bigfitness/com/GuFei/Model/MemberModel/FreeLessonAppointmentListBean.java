package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/6/15.
 */

public class FreeLessonAppointmentListBean {

    /**
     * Ret : 0
     * Msg : 操作成功!
     * rows : [{"Status":1,"AppointmentId":281,"AppointmentTime":"2017-08-18 12:00-12:50","TeacherName":null,"FLessonName":null},{"Status":1,"AppointmentId":282,"AppointmentTime":"2017-08-18 12:00-12:50","TeacherName":"汉MI","FLessonName":"普拉提"},{"Status":1,"AppointmentId":283,"AppointmentTime":"2017-08-21 12:00-12:50","TeacherName":"文慧","FLessonName":"瑜伽"},{"Status":1,"AppointmentId":284,"AppointmentTime":"2017-09-10 18:00-19:00","TeacherName":"吴京","FLessonName":"动感单车"},{"Status":1,"AppointmentId":285,"AppointmentTime":"2017-09-09 18:00-19:00","TeacherName":"李连杰","FLessonName":"动感单车"},{"Status":1,"AppointmentId":289,"AppointmentTime":"2017-09-11 18:00-19:00","TeacherName":"张学友","FLessonName":"高温瑜伽"}]
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

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public int getTotalPage() {
        return TotalPage;
    }

    public void setTotalPage(int totalPage) {
        TotalPage = totalPage;
    }

    public static class RowsBean {
        /**
         * Status : 1
         * AppointmentId : 281
         * AppointmentTime : 2017-08-18 12:00-12:50
         * TeacherName : null
         * FLessonName : null
         * IsSignIn
         */

        private int Status;
        private int AppointmentId;
        private String AppointmentTime;
        private Object TeacherName;
        private Object FLessonName;
        private int IsSignIn;
        private int Number;

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public int getAppointmentId() {
            return AppointmentId;
        }

        public void setAppointmentId(int AppointmentId) {
            this.AppointmentId = AppointmentId;
        }

        public String getAppointmentTime() {
            return AppointmentTime;
        }

        public void setAppointmentTime(String AppointmentTime) {
            this.AppointmentTime = AppointmentTime;
        }

        public Object getTeacherName() {
            return TeacherName;
        }

        public void setTeacherName(Object TeacherName) {
            this.TeacherName = TeacherName;
        }

        public Object getFLessonName() {
            return FLessonName;
        }

        public void setFLessonName(Object FLessonName) {
            this.FLessonName = FLessonName;
        }

        public int getIsSignIn() {
            return IsSignIn;
        }

        public void setIsSignIn(int isSignIn) {
            IsSignIn = isSignIn;
        }

        public int getNumber() {
            return Number;
        }

        public void setNumber(int number) {
            Number = number;
        }
    }
}
