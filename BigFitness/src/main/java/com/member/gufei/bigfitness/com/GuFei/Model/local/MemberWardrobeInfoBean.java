package com.member.gufei.bigfitness.com.GuFei.Model.local;

/**
 * Created by Administrator on 2017/6/18.
 */

public class MemberWardrobeInfoBean {

    /**
     * message :
     * result : {"BuyRemark":"","id":10,"Status":"已使用","WardrobeId":75,"UseTime":"2017-05-31","WardrobeNo":"VIP5","ExpireTime":"2017-12-30","BargainNo":"","WardrobeBalance":"7月","TotalBuyMoney":"3500元","UserName":"李琦","BuyTime":"2017-05-31","Deposit":"100元"}
     * code : 0
     */

    private String message;
    private ResultBean result;
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean {
        /**
         * BuyRemark :
         * id : 10
         * Status : 已使用
         * WardrobeId : 75
         * UseTime : 2017-05-31
         * WardrobeNo : VIP5
         * ExpireTime : 2017-12-30
         * BargainNo :
         * WardrobeBalance : 7月
         * TotalBuyMoney : 3500元
         * UserName : 李琦
         * BuyTime : 2017-05-31
         * Deposit : 100元
         */

        private String BuyRemark;
        private int id;
        private String Status;
        private int WardrobeId;
        private String UseTime;
        private String WardrobeNo;
        private String ExpireTime;
        private String BargainNo;
        private String WardrobeBalance;
        private String TotalBuyMoney;
        private String UserName;
        private String BuyTime;
        private String Deposit;

        public String getBuyRemark() {
            return BuyRemark;
        }

        public void setBuyRemark(String BuyRemark) {
            this.BuyRemark = BuyRemark;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public int getWardrobeId() {
            return WardrobeId;
        }

        public void setWardrobeId(int WardrobeId) {
            this.WardrobeId = WardrobeId;
        }

        public String getUseTime() {
            return UseTime;
        }

        public void setUseTime(String UseTime) {
            this.UseTime = UseTime;
        }

        public String getWardrobeNo() {
            return WardrobeNo;
        }

        public void setWardrobeNo(String WardrobeNo) {
            this.WardrobeNo = WardrobeNo;
        }

        public String getExpireTime() {
            return ExpireTime;
        }

        public void setExpireTime(String ExpireTime) {
            this.ExpireTime = ExpireTime;
        }

        public String getBargainNo() {
            return BargainNo;
        }

        public void setBargainNo(String BargainNo) {
            this.BargainNo = BargainNo;
        }

        public String getWardrobeBalance() {
            return WardrobeBalance;
        }

        public void setWardrobeBalance(String WardrobeBalance) {
            this.WardrobeBalance = WardrobeBalance;
        }

        public String getTotalBuyMoney() {
            return TotalBuyMoney;
        }

        public void setTotalBuyMoney(String TotalBuyMoney) {
            this.TotalBuyMoney = TotalBuyMoney;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getBuyTime() {
            return BuyTime;
        }

        public void setBuyTime(String BuyTime) {
            this.BuyTime = BuyTime;
        }

        public String getDeposit() {
            return Deposit;
        }

        public void setDeposit(String Deposit) {
            this.Deposit = Deposit;
        }
    }
}
