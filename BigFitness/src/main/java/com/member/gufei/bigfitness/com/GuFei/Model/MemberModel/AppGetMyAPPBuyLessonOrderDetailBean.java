package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

/**
 * Created by GuFei on 2018/3/27.
 * #我的私教课购买订单详情
 */

public class AppGetMyAPPBuyLessonOrderDetailBean {


    /**
     * Ret : 0
     * rows : {"Price":100,"Amount":10,"CreateTime":"2018-02-01","ImageURL":"","TotalMoney":1000,"OrderId":"20180208135526991","LessonName":"200私教","IsRefund":1,"TeacherName":"姚佳"}
     */

    private int Ret;
    private RowsBean rows;

    public int getRet() {
        return Ret;
    }

    public void setRet(int Ret) {
        this.Ret = Ret;
    }

    public RowsBean getRows() {
        return rows;
    }

    public void setRows(RowsBean rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * Price : 100
         * Amount : 10
         * CreateTime : 2018-02-01
         * ImageURL :
         * TotalMoney : 1000
         * OrderId : 20180208135526991
         * LessonName : 200私教
         * IsRefund : 1
         * TeacherName : 姚佳
         */

        private int Price;
        private int Amount;
        private String CreateTime;
        private String ImageURL;
        private int TotalMoney;
        private String OrderId;
        private String LessonName;
        private int IsRefund;
        private String TeacherName;

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
        }

        public int getAmount() {
            return Amount;
        }

        public void setAmount(int Amount) {
            this.Amount = Amount;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getImageURL() {
            return ImageURL;
        }

        public void setImageURL(String ImageURL) {
            this.ImageURL = ImageURL;
        }

        public int getTotalMoney() {
            return TotalMoney;
        }

        public void setTotalMoney(int TotalMoney) {
            this.TotalMoney = TotalMoney;
        }

        public String getOrderId() {
            return OrderId;
        }

        public void setOrderId(String OrderId) {
            this.OrderId = OrderId;
        }

        public String getLessonName() {
            return LessonName;
        }

        public void setLessonName(String LessonName) {
            this.LessonName = LessonName;
        }

        public int getIsRefund() {
            return IsRefund;
        }

        public void setIsRefund(int IsRefund) {
            this.IsRefund = IsRefund;
        }

        public String getTeacherName() {
            return TeacherName;
        }

        public void setTeacherName(String TeacherName) {
            this.TeacherName = TeacherName;
        }
    }
}
