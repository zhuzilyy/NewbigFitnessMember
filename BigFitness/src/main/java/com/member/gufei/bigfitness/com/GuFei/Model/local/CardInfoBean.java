package com.member.gufei.bigfitness.com.GuFei.Model.local;

/**
 * Description
 *
 * @author Song.gl
 * @version 2017 06 21 22:58
 */
public class CardInfoBean {

    /**
     * message :
     * result : {"BuyRemark":"","BargainNo":"","STATUS":"已开卡","MemberCardTypeName":"单年卡","CardBalance":"334天","MemberNameList":"","ConsumeType":"时卡","MemberCardId":229,"PayMoney":0,"CreateUserName":"Aaron","UseTime":"2017/05/21","ExpireTime":"2018/05/21","BuyTime":"2017/05/21","RemainLockedCount":0}
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
         * BargainNo :
         * STATUS : 已开卡
         * MemberCardTypeName : 单年卡
         * CardBalance : 334天
         * MemberNameList :
         * ConsumeType : 时卡
         * MemberCardId : 229
         * PayMoney : 0
         * CreateUserName : Aaron
         * UseTime : 2017/05/21
         * ExpireTime : 2018/05/21
         * BuyTime : 2017/05/21
         * RemainLockedCount : 0
         */

        private String BuyRemark;
        private String BargainNo;
        private String STATUS;
        private String MemberCardTypeName;
        private String CardBalance;
        private String MemberNameList;
        private String ConsumeType;
        private int MemberCardId;
        private int PayMoney;



        private int BuyMoney;
        private String CreateUserName;
        private String UseTime;
        private String ExpireTime;
        private String BuyTime;

        public String getMemberCardNo() {
            return MemberCardNo;
        }

        public void setMemberCardNo(String memberCardNo) {
            MemberCardNo = memberCardNo;
        }

        private  String MemberCardNo;
        private int RemainLockedCount;

        public int getBuyMoney() {
            return BuyMoney;
        }

        public void setBuyMoney(int buyMoney) {
            BuyMoney = buyMoney;
        }
        public String getBuyRemark() {
            return BuyRemark;
        }

        public void setBuyRemark(String BuyRemark) {
            this.BuyRemark = BuyRemark;
        }

        public String getBargainNo() {
            return BargainNo;
        }

        public void setBargainNo(String BargainNo) {
            this.BargainNo = BargainNo;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        public String getMemberCardTypeName() {
            return MemberCardTypeName;
        }

        public void setMemberCardTypeName(String MemberCardTypeName) {
            this.MemberCardTypeName = MemberCardTypeName;
        }

        public String getCardBalance() {
            return CardBalance;
        }

        public void setCardBalance(String CardBalance) {
            this.CardBalance = CardBalance;
        }

        public String getMemberNameList() {
            return MemberNameList;
        }

        public void setMemberNameList(String MemberNameList) {
            this.MemberNameList = MemberNameList;
        }

        public String getConsumeType() {
            return ConsumeType;
        }

        public void setConsumeType(String ConsumeType) {
            this.ConsumeType = ConsumeType;
        }

        public int getMemberCardId() {
            return MemberCardId;
        }

        public void setMemberCardId(int MemberCardId) {
            this.MemberCardId = MemberCardId;
        }

        public int getPayMoney() {
            return PayMoney;
        }

        public void setPayMoney(int PayMoney) {
            this.PayMoney = PayMoney;
        }

        public String getCreateUserName() {
            return CreateUserName;
        }

        public void setCreateUserName(String CreateUserName) {
            this.CreateUserName = CreateUserName;
        }

        public String getUseTime() {
            return UseTime;
        }

        public void setUseTime(String UseTime) {
            this.UseTime = UseTime;
        }

        public String getExpireTime() {
            return ExpireTime;
        }

        public void setExpireTime(String ExpireTime) {
            this.ExpireTime = ExpireTime;
        }

        public String getBuyTime() {
            return BuyTime;
        }

        public void setBuyTime(String BuyTime) {
            this.BuyTime = BuyTime;
        }

        public int getRemainLockedCount() {
            return RemainLockedCount;
        }

        public void setRemainLockedCount(int RemainLockedCount) {
            this.RemainLockedCount = RemainLockedCount;
        }
    }
}
