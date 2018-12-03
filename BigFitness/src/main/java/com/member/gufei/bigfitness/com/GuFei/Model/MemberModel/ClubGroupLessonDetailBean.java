package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/3/27.
 *
 * #指定小团体课详情信息
 */

public class ClubGroupLessonDetailBean {

    /**
     * Ret : 0
     * rows : {"Status":0,"BuyTime":"2018-02-01","GLessonName":"小团体课","GroupLessonId":22,"EndTime":"04/30","PersonCount":5,"IsBuy":1,"Amount":4,"StartTime":"12/01","teacherList":"刘东东,姚佳,王十","EvaluateCount":7,"AvgEvaluateStar":2.9,"ClassPersonCount":6,"Pcount":0,"SaleMoney":3000,"Introduce":"","GroupLessonClassTime":[{"ClassTime":"14:00~15:00","LessonDate":"2017-12-01"},{"ClassTime":"14:00~15:00","LessonDate":"2017-12-08"},{"ClassTime":"14:00~15:00","LessonDate":"2017-12-15"},{"ClassTime":"14:00~15:00","LessonDate":"2017-12-22"}],"imageList":"aaa.jpg,aaa.jpg,bbb.jpg,ccc.jpg"}
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

    public void setMsg(String msg) {
        Msg = msg;
    }

    public RowsBean getRows() {
        return rows;
    }

    public void setRows(RowsBean rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * Status : 0
         * BuyTime : 2018-02-01
         * GLessonName : 小团体课
         * GroupLessonId : 22
         * EndTime : 04/30
         * PersonCount : 5
         * IsBuy : 1
         * Amount : 4
         * StartTime : 12/01
         * teacherList : 刘东东,姚佳,王十
         * EvaluateCount : 7
         * AvgEvaluateStar : 2.9
         * ClassPersonCount : 6
         * Pcount : 0
         * SaleMoney : 3000
         * Introduce :
         * GroupLessonClassTime : [{"ClassTime":"14:00~15:00","LessonDate":"2017-12-01"},{"ClassTime":"14:00~15:00","LessonDate":"2017-12-08"},{"ClassTime":"14:00~15:00","LessonDate":"2017-12-15"},{"ClassTime":"14:00~15:00","LessonDate":"2017-12-22"}]
         * imageList : aaa.jpg,aaa.jpg,bbb.jpg,ccc.jpg
         */

        private int Status;
        private String BuyTime;
        private String GLessonName;
        private int GroupLessonId;
        private String EndTime;
        private int PersonCount;
        private int IsBuy;
        private int Amount;
        private String StartTime;
        private String teacherList;
        private int EvaluateCount;
        private double AvgEvaluateStar;
        private int ClassPersonCount;
        private int Pcount;
        private int SaleMoney;
        private String Introduce;
        private String imageList;
        private List<GroupLessonClassTimeBean> GroupLessonClassTime;

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

        public int getPersonCount() {
            return PersonCount;
        }

        public void setPersonCount(int PersonCount) {
            this.PersonCount = PersonCount;
        }

        public int getIsBuy() {
            return IsBuy;
        }

        public void setIsBuy(int IsBuy) {
            this.IsBuy = IsBuy;
        }

        public int getAmount() {
            return Amount;
        }

        public void setAmount(int Amount) {
            this.Amount = Amount;
        }

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(String StartTime) {
            this.StartTime = StartTime;
        }

        public String getTeacherList() {
            return teacherList;
        }

        public void setTeacherList(String teacherList) {
            this.teacherList = teacherList;
        }

        public int getEvaluateCount() {
            return EvaluateCount;
        }

        public void setEvaluateCount(int EvaluateCount) {
            this.EvaluateCount = EvaluateCount;
        }

        public double getAvgEvaluateStar() {
            return AvgEvaluateStar;
        }

        public void setAvgEvaluateStar(double AvgEvaluateStar) {
            this.AvgEvaluateStar = AvgEvaluateStar;
        }

        public int getClassPersonCount() {
            return ClassPersonCount;
        }

        public void setClassPersonCount(int ClassPersonCount) {
            this.ClassPersonCount = ClassPersonCount;
        }

        public int getPcount() {
            return Pcount;
        }

        public void setPcount(int Pcount) {
            this.Pcount = Pcount;
        }

        public int getSaleMoney() {
            return SaleMoney;
        }

        public void setSaleMoney(int SaleMoney) {
            this.SaleMoney = SaleMoney;
        }

        public String getIntroduce() {
            return Introduce;
        }

        public void setIntroduce(String Introduce) {
            this.Introduce = Introduce;
        }

        public String getImageList() {
            return imageList;
        }

        public void setImageList(String imageList) {
            this.imageList = imageList;
        }

        public List<GroupLessonClassTimeBean> getGroupLessonClassTime() {
            return GroupLessonClassTime;
        }

        public void setGroupLessonClassTime(List<GroupLessonClassTimeBean> GroupLessonClassTime) {
            this.GroupLessonClassTime = GroupLessonClassTime;
        }

        public static class GroupLessonClassTimeBean {
            /**
             * ClassTime : 14:00~15:00
             * LessonDate : 2017-12-01
             */

            private String ClassTime;
            private String LessonDate;

            public String getClassTime() {
                return ClassTime;
            }

            public void setClassTime(String ClassTime) {
                this.ClassTime = ClassTime;
            }

            public String getLessonDate() {
                return LessonDate;
            }

            public void setLessonDate(String LessonDate) {
                this.LessonDate = LessonDate;
            }
        }
    }
}


