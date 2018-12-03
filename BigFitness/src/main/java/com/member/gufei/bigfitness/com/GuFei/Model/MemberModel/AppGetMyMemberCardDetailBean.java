package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

/**
 * Created by GuFei on 2018/4/7.
 */

public class AppGetMyMemberCardDetailBean {


    /**
     * Ret : 0
     * Msg :
     * rows : {"BuyTime":"2015-08-31","UnLockTime":"","ConsumeType":1,"IsAllowLock":1,"BuyMoney":0,"RemainUseCount":0,"ImageURL":"","IsAllowUp":0,"IsEvaluate":0,"TotalLockCount":1,"LockTime":"","TotalCount":0,"UseTime":"2015-08-31","STATUS":3,"RemainLockedCount":1,"MemberCardTypeName":"单月卡","MemberCardTypeId":42,"BargainNo":"","MemberCardId":70030,"ExpireTime":"2018-10-01","IsAllowAddFee":1,"Balance":1127,"OwnManagerName":"王泽"}
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
         * BuyTime : 2015-08-31
         * UnLockTime :
         * ConsumeType : 1
         * IsAllowLock : 1
         * BuyMoney : 0
         * RemainUseCount : 0
         * ImageURL :
         * IsAllowUp : 0
         * IsEvaluate : 0
         * TotalLockCount : 1
         * LockTime :
         * TotalCount : 0
         * UseTime : 2015-08-31
         * STATUS : 3
         * RemainLockedCount : 1
         * MemberCardTypeName : 单月卡
         * MemberCardTypeId : 42
         * BargainNo :
         * MemberCardId : 70030
         * ExpireTime : 2018-10-01
         * IsAllowAddFee : 1
         * Balance : 1127
         * OwnManagerName : 王泽
         */

        private String BuyTime;
        private String Status;
        private String UnLockTime;
        private int ConsumeType;
        private int IsAllowLock;
        private Double BuyMoney;
        private int RemainUseCount;
        private String ImageURL;
        private int IsAllowUp;
        private int IsEvaluate;
        private int TotalLockCount;
        private String LockTime;
        private int TotalCount;
        private String UseTime;
        private int STATUS;
        private int RemainLockedCount;
        private String MemberCardTypeName;
        private int MemberCardTypeId;
        private String BargainNo;
        private int MemberCardId;
        private String ExpireTime;
        private int IsAllowAddFee;
        private int Balance;
        private String OwnManagerName;

        public String getBuyTime() {
            return BuyTime;
        }

        public void setBuyTime(String BuyTime) {
            this.BuyTime = BuyTime;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getUnLockTime() {
            return UnLockTime;
        }

        public void setUnLockTime(String UnLockTime) {
            this.UnLockTime = UnLockTime;
        }

        public int getConsumeType() {
            return ConsumeType;
        }

        public void setConsumeType(int ConsumeType) {
            this.ConsumeType = ConsumeType;
        }

        public int getIsAllowLock() {
            return IsAllowLock;
        }

        public void setIsAllowLock(int IsAllowLock) {
            this.IsAllowLock = IsAllowLock;
        }

        public Double getBuyMoney() {
            return BuyMoney;
        }

        public void setBuyMoney(Double buyMoney) {
            BuyMoney = buyMoney;
        }

        public int getRemainUseCount() {
            return RemainUseCount;
        }

        public void setRemainUseCount(int RemainUseCount) {
            this.RemainUseCount = RemainUseCount;
        }

        public String getImageURL() {
            return ImageURL;
        }

        public void setImageURL(String ImageURL) {
            this.ImageURL = ImageURL;
        }

        public int getIsAllowUp() {
            return IsAllowUp;
        }

        public void setIsAllowUp(int IsAllowUp) {
            this.IsAllowUp = IsAllowUp;
        }

        public int getIsEvaluate() {
            return IsEvaluate;
        }

        public void setIsEvaluate(int IsEvaluate) {
            this.IsEvaluate = IsEvaluate;
        }

        public int getTotalLockCount() {
            return TotalLockCount;
        }

        public void setTotalLockCount(int TotalLockCount) {
            this.TotalLockCount = TotalLockCount;
        }

        public String getLockTime() {
            return LockTime;
        }

        public void setLockTime(String LockTime) {
            this.LockTime = LockTime;
        }

        public int getTotalCount() {
            return TotalCount;
        }

        public void setTotalCount(int TotalCount) {
            this.TotalCount = TotalCount;
        }

        public String getUseTime() {
            return UseTime;
        }

        public void setUseTime(String UseTime) {
            this.UseTime = UseTime;
        }

        public int getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(int STATUS) {
            this.STATUS = STATUS;
        }

        public int getRemainLockedCount() {
            return RemainLockedCount;
        }

        public void setRemainLockedCount(int RemainLockedCount) {
            this.RemainLockedCount = RemainLockedCount;
        }

        public String getMemberCardTypeName() {
            return MemberCardTypeName;
        }

        public void setMemberCardTypeName(String MemberCardTypeName) {
            this.MemberCardTypeName = MemberCardTypeName;
        }

        public int getMemberCardTypeId() {
            return MemberCardTypeId;
        }

        public void setMemberCardTypeId(int MemberCardTypeId) {
            this.MemberCardTypeId = MemberCardTypeId;
        }

        public String getBargainNo() {
            return BargainNo;
        }

        public void setBargainNo(String BargainNo) {
            this.BargainNo = BargainNo;
        }

        public int getMemberCardId() {
            return MemberCardId;
        }

        public void setMemberCardId(int MemberCardId) {
            this.MemberCardId = MemberCardId;
        }

        public String getExpireTime() {
            return ExpireTime;
        }

        public void setExpireTime(String ExpireTime) {
            this.ExpireTime = ExpireTime;
        }

        public int getIsAllowAddFee() {
            return IsAllowAddFee;
        }

        public void setIsAllowAddFee(int IsAllowAddFee) {
            this.IsAllowAddFee = IsAllowAddFee;
        }

        public int getBalance() {
            return Balance;
        }

        public void setBalance(int Balance) {
            this.Balance = Balance;
        }

        public String getOwnManagerName() {
            return OwnManagerName;
        }

        public void setOwnManagerName(String OwnManagerName) {
            this.OwnManagerName = OwnManagerName;
        }
    }
}
