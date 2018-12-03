package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

/**
 * Created by GuFei on 2018/3/27.
 * #获取我的私教课详细信息
 */

public class AppGetMyMemberLessonDetailBean {


    /**
     * Ret : 0
     * Msg :
     * rows : {"TotalBuyCount":10000,"Status":"0","TotalBuyMoney":100000,"LessonId":26,"BargainNo":"666666","LessonName":"220私教","Balance":10000,"TeacherName":"刘熠","StopTime":"2018-09-08"}
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

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public RowsBean getRows() {
        return rows;
    }

    public void setRows(RowsBean rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * TotalBuyCount : 10000
         * Status : 0
         * TotalBuyMoney : 100000
         * LessonId : 26
         * BargainNo : 666666
         * LessonName : 220私教
         * Balance : 10000
         * TeacherName : 刘熠
         * StopTime : 2018-09-08
         */

        private int TotalBuyCount;
        private String Status;
        private Double TotalBuyMoney;
        private int LessonId;
        private String BargainNo;
        private String LessonName;
        private int Balance;
        private String TeacherName;
        private String StopTime;

        public int getTotalBuyCount() {
            return TotalBuyCount;
        }

        public void setTotalBuyCount(int TotalBuyCount) {
            this.TotalBuyCount = TotalBuyCount;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public Double getTotalBuyMoney() {
            return TotalBuyMoney;
        }

        public void setTotalBuyMoney(Double totalBuyMoney) {
            TotalBuyMoney = totalBuyMoney;
        }

        public int getLessonId() {
            return LessonId;
        }

        public void setLessonId(int LessonId) {
            this.LessonId = LessonId;
        }

        public String getBargainNo() {
            return BargainNo;
        }

        public void setBargainNo(String BargainNo) {
            this.BargainNo = BargainNo;
        }

        public String getLessonName() {
            return LessonName;
        }

        public void setLessonName(String LessonName) {
            this.LessonName = LessonName;
        }

        public int getBalance() {
            return Balance;
        }

        public void setBalance(int Balance) {
            this.Balance = Balance;
        }

        public String getTeacherName() {
            return TeacherName;
        }

        public void setTeacherName(String TeacherName) {
            this.TeacherName = TeacherName;
        }

        public String getStopTime() {
            return StopTime;
        }

        public void setStopTime(String StopTime) {
            this.StopTime = StopTime;
        }
    }
}
