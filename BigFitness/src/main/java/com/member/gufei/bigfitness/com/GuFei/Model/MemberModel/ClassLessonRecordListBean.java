package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/6/18.
 */

public class ClassLessonRecordListBean {

    /**
     * Ret : 0
     * Msg :
     * TotalPage : 1
     * rows : [{"IsSignIn":0,"ComeLogId":123123123,"IsMakeUp":0,"IsAllowMakeUp":0,"AppointmentId":336,"IsEvaluated":0,"LessonId":30,"ApplyStatus":-1,"ClassTime":"2018-05-05 08:56-09:56","LessonName":"减脂课","TeacherName":"郭富城","IsFinished":0}]
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
         * IsSignIn : 0
         * ComeLogId : 123123123
         * IsMakeUp : 0
         * IsAllowMakeUp : 0
         * AppointmentId : 336
         * IsEvaluated : 0
         * LessonId : 30
         * ApplyStatus : -1
         * ClassTime : 2018-05-05 08:56-09:56
         * LessonName : 减脂课
         * TeacherName : 郭富城
         * IsFinished : 0
         */

        private int IsSignIn;
        private int ComeLogId;
        private int IsMakeUp;
        private int IsAllowMakeUp;
        private int AppointmentId;
        private int IsEvaluated;
        private int LessonId;
        private int ApplyStatus;
        private String ClassTime;
        private String LessonName;
        private String TeacherName;
        private int IsFinished;

        public int getIsSignIn() {
            return IsSignIn;
        }

        public void setIsSignIn(int IsSignIn) {
            this.IsSignIn = IsSignIn;
        }

        public int getComeLogId() {
            return ComeLogId;
        }

        public void setComeLogId(int ComeLogId) {
            this.ComeLogId = ComeLogId;
        }

        public int getIsMakeUp() {
            return IsMakeUp;
        }

        public void setIsMakeUp(int IsMakeUp) {
            this.IsMakeUp = IsMakeUp;
        }

        public int getIsAllowMakeUp() {
            return IsAllowMakeUp;
        }

        public void setIsAllowMakeUp(int IsAllowMakeUp) {
            this.IsAllowMakeUp = IsAllowMakeUp;
        }

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

        public int getLessonId() {
            return LessonId;
        }

        public void setLessonId(int LessonId) {
            this.LessonId = LessonId;
        }

        public int getApplyStatus() {
            return ApplyStatus;
        }

        public void setApplyStatus(int ApplyStatus) {
            this.ApplyStatus = ApplyStatus;
        }

        public String getClassTime() {
            return ClassTime;
        }

        public void setClassTime(String ClassTime) {
            this.ClassTime = ClassTime;
        }

        public String getLessonName() {
            return LessonName;
        }

        public void setLessonName(String LessonName) {
            this.LessonName = LessonName;
        }

        public String getTeacherName() {
            return TeacherName;
        }

        public void setTeacherName(String TeacherName) {
            this.TeacherName = TeacherName;
        }

        public int getIsFinished() {
            return IsFinished;
        }

        public void setIsFinished(int IsFinished) {
            this.IsFinished = IsFinished;
        }
    }
}
