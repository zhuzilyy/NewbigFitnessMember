package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

/**
 * Created by GuFei on 2018/4/6.
 */

public class AppGetMyAPPBuyCardOrderDetailBean {

    /**
     * Ret : 0
     * Msg :
     * rows : {"RefundTime":"","BuyTime":"2018-03-30","Status":null,"MemberCardTypeName":"单年卡","ImageURL":"","TotalMoney":1000,"OrderId":"4","PayMode":1}
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
         * RefundTime :
         * BuyTime : 2018-03-30
         * Status : null
         * MemberCardTypeName : 单年卡
         * ImageURL :
         * TotalMoney : 1000
         * OrderId : 4
         * PayMode : 1
         */
        private int ConsumeType;

        public int getAmount() {
            return Amount;
        }

        public void setAmount(int amount) {
            Amount = amount;
        }

        public int getConsumeType() {

            return ConsumeType;
        }

        public void setConsumeType(int consumeType) {
            ConsumeType = consumeType;
        }

        private String RefundTime;
        private String BuyTime;
        private int Status;
        private String MemberCardTypeName;
        private String ImageURL;
        private double TotalMoney;
        private String OrderId;
        private int PayMode;
        private int ActiveCount;

        public int getActiveCount() {
            return ActiveCount;
        }

        public void setActiveCount(int activeCount) {
            ActiveCount = activeCount;
        }

        private int      Amount;
        public String getRefundTime() {
            return RefundTime;
        }

        public void setRefundTime(String RefundTime) {
            this.RefundTime = RefundTime;
        }

        public String getBuyTime() {
            return BuyTime;
        }

        public void setBuyTime(String BuyTime) {
            this.BuyTime = BuyTime;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getMemberCardTypeName() {
            return MemberCardTypeName;
        }

        public void setMemberCardTypeName(String MemberCardTypeName) {
            this.MemberCardTypeName = MemberCardTypeName;
        }

        public String getImageURL() {
            return ImageURL;
        }

        public void setImageURL(String ImageURL) {
            this.ImageURL = ImageURL;
        }

        public double getTotalMoney() {
            return TotalMoney;
        }

        public void setTotalMoney(double TotalMoney) {
            this.TotalMoney = TotalMoney;
        }

        public String getOrderId() {
            return OrderId;
        }

        public void setOrderId(String OrderId) {
            this.OrderId = OrderId;
        }

        public int getPayMode() {
            return PayMode;
        }

        public void setPayMode(int PayMode) {
            this.PayMode = PayMode;
        }
    }
}
