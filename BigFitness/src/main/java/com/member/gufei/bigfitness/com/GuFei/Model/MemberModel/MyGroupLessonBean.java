package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/6/11.
 */

public class MyGroupLessonBean {

    /**
     * Ret : 0
     * TotalPage : 2
     * rows : [{"Status":0,"GLessonName":"小团体课","GroupLessonId":22,"SaleMoney":3000,"Amount":4,"Id":81,"IsEvaluate":0},{"Status":0,"GLessonName":"小团体课","GroupLessonId":22,"SaleMoney":3000,"Amount":4,"Id":82,"IsEvaluate":0},{"Status":0,"GLessonName":"小团体课","GroupLessonId":22,"SaleMoney":3000,"Amount":4,"Id":83,"IsEvaluate":0},{"Status":0,"GLessonName":"小团体课","GroupLessonId":22,"SaleMoney":3000,"Amount":4,"Id":84,"IsEvaluate":0},{"Status":0,"GLessonName":"小团体课","GroupLessonId":22,"SaleMoney":3000,"Amount":4,"Id":85,"IsEvaluate":0},{"Status":0,"GLessonName":"小团体课","GroupLessonId":22,"SaleMoney":3000,"Amount":4,"Id":86,"IsEvaluate":0},{"Status":0,"GLessonName":"团课","GroupLessonId":23,"SaleMoney":1000,"Amount":2,"Id":87,"IsEvaluate":1},{"Status":0,"GLessonName":"团课","GroupLessonId":23,"SaleMoney":1000,"Amount":2,"Id":88,"IsEvaluate":1},{"Status":0,"GLessonName":"实验团课","GroupLessonId":24,"SaleMoney":500,"Amount":4,"Id":89,"IsEvaluate":0},{"Status":0,"GLessonName":"实验团课","GroupLessonId":24,"SaleMoney":500,"Amount":4,"Id":90,"IsEvaluate":0}]
     */

    private int Ret;
    private int TotalPage;
    private List<RowsBean> rows;

    public int getRet() {
        return Ret;
    }

    public void setRet(int Ret) {
        this.Ret = Ret;
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
         * Status : 0
         * GLessonName : 小团体课
         * GroupLessonId : 22
         * SaleMoney : 3000
         * Amount : 4
         * Id : 81
         * IsEvaluate : 0
         */

        private int Status;
        private String GLessonName;
        private int GroupLessonId;
        private int SaleMoney;
        private int Amount;
        private int Id;
        private int IsEvaluate;

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
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

        public int getSaleMoney() {
            return SaleMoney;
        }

        public void setSaleMoney(int SaleMoney) {
            this.SaleMoney = SaleMoney;
        }

        public int getAmount() {
            return Amount;
        }

        public void setAmount(int Amount) {
            this.Amount = Amount;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public int getIsEvaluate() {
            return IsEvaluate;
        }

        public void setIsEvaluate(int IsEvaluate) {
            this.IsEvaluate = IsEvaluate;
        }
    }
}
