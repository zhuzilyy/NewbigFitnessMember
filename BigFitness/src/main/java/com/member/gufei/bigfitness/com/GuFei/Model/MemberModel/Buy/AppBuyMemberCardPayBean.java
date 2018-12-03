package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy;

/**
 * Created by GuFei on 2018/3/27.
 * #会员卡购买-支付

 */

public class AppBuyMemberCardPayBean {


    /**
     * Msg : 微信支付订单信息
     * Ret : 0
     * rows : {"Price":"99.99","APPUserId":"36","Amount":"100","MemberCardTypeId":"34","TotalMoney":"9999","ClubId":"1","OrderId":20180327020850337,"PayMode":"0"}
     */

    private String Msg;
    private int Ret;
    private RowsBean rows;

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

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
         * Price : 99.99
         * APPUserId : 36
         * Amount : 100
         * MemberCardTypeId : 34
         * TotalMoney : 9999
         * ClubId : 1
         * OrderId : 20180327020850337
         * PayMode : 0
         */

        private String Price;
        private String APPUserId;
        private String Amount;
        private String MemberCardTypeId;
        private String TotalMoney;
        private String ClubId;
        private long OrderId;
        private String PayMode;

        public String getPrice() {
            return Price;
        }

        public void setPrice(String Price) {
            this.Price = Price;
        }

        public String getAPPUserId() {
            return APPUserId;
        }

        public void setAPPUserId(String APPUserId) {
            this.APPUserId = APPUserId;
        }

        public String getAmount() {
            return Amount;
        }

        public void setAmount(String Amount) {
            this.Amount = Amount;
        }

        public String getMemberCardTypeId() {
            return MemberCardTypeId;
        }

        public void setMemberCardTypeId(String MemberCardTypeId) {
            this.MemberCardTypeId = MemberCardTypeId;
        }

        public String getTotalMoney() {
            return TotalMoney;
        }

        public void setTotalMoney(String TotalMoney) {
            this.TotalMoney = TotalMoney;
        }

        public String getClubId() {
            return ClubId;
        }

        public void setClubId(String ClubId) {
            this.ClubId = ClubId;
        }

        public long getOrderId() {
            return OrderId;
        }

        public void setOrderId(long OrderId) {
            this.OrderId = OrderId;
        }

        public String getPayMode() {
            return PayMode;
        }

        public void setPayMode(String PayMode) {
            this.PayMode = PayMode;
        }
    }
}
