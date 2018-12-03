package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/6/12.
 */

public class MyGroupLessonDetailBean {

    /**
     * Ret : 0
     * rows : [{"Status":0,"BuyTime":"2017-09-28 15:35","GLessonName":"小团体课","GroupLessonId":22,"EndTime":"2018-04-30","Amount":4,"BuyMoney":3000,"StartTime":"2017-12-01","Id":81,"LessonTeacherNames":"刘东东,姚佳,王十","IsEvaluate":0}]
     */

    private int Ret;
    private List<RowsBean> rows;

    public int getRet() {
        return Ret;
    }

    public void setRet(int Ret) {
        this.Ret = Ret;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * Status : 0
         * BuyTime : 2017-09-28 15:35
         * GLessonName : 小团体课
         * GroupLessonId : 22
         * EndTime : 2018-04-30
         * Amount : 4
         * BuyMoney : 3000
         * StartTime : 2017-12-01
         * Id : 81
         * LessonTeacherNames : 刘东东,姚佳,王十
         * IsEvaluate : 0
         */

        private int Status;
        private String BuyTime;
        private String GLessonName;
        private int GroupLessonId;
        private String EndTime;
        private int Amount;
        private int BuyMoney;
        private String StartTime;
        private int Id;
        private String LessonTeacherNames;
        private int IsEvaluate;

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getBuyTime() {
            return BuyTime;
        }

        public void setBuyTime(String BuyTime) {
            this.BuyTime = BuyTime;
        }

        public String getGLessonName() {
            return GLessonName;
        }

        public void setGLessonName(String GLessonName) {
            this.GLessonName = GLessonName;
        }

        public int getGroupLessonId() {
            return GroupLessonId;
        }

        public void setGroupLessonId(int GroupLessonId) {
            this.GroupLessonId = GroupLessonId;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public int getAmount() {
            return Amount;
        }

        public void setAmount(int Amount) {
            this.Amount = Amount;
        }

        public int getBuyMoney() {
            return BuyMoney;
        }

        public void setBuyMoney(int BuyMoney) {
            this.BuyMoney = BuyMoney;
        }

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(String StartTime) {
            this.StartTime = StartTime;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getLessonTeacherNames() {
            return LessonTeacherNames;
        }

        public void setLessonTeacherNames(String LessonTeacherNames) {
            this.LessonTeacherNames = LessonTeacherNames;
        }

        public int getIsEvaluate() {
            return IsEvaluate;
        }

        public void setIsEvaluate(int IsEvaluate) {
            this.IsEvaluate = IsEvaluate;
        }
    }
}
