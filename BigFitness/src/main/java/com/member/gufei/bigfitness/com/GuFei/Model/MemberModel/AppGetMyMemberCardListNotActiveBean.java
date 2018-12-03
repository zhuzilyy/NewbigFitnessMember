package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/4/5.
 */

public class AppGetMyMemberCardListNotActiveBean {


    /**
     * Ret : 0
     * Msg :
     * rows : {"TotalPage":1,"notActivedList":[{"Status":7,"ConsumeType":0,"IsAllowLock":0,"CreateTime":"2018-09-11","RemainUseCount":0,"ImageURL":"uploadFiles/uploadImgs/20180910/694a4bc2181c4919999bd5a03001cab2.png","IsAllowUp":0,"OrderId":"0120180911134513614","IsEvaluate":0,"TotalCount":0,"RemainLockedCount":0,"OnlineAddFeeMinAmount":0,"MemberCardTypeName":"1次卡","MemberCardTypeId":280,"MemberCardId":0,"IsAllowAddFee":0}]}
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
         * TotalPage : 1
         * notActivedList : [{"Status":7,"ConsumeType":0,"IsAllowLock":0,"CreateTime":"2018-09-11","RemainUseCount":0,"ImageURL":"uploadFiles/uploadImgs/20180910/694a4bc2181c4919999bd5a03001cab2.png","IsAllowUp":0,"OrderId":"0120180911134513614","IsEvaluate":0,"TotalCount":0,"RemainLockedCount":0,"OnlineAddFeeMinAmount":0,"MemberCardTypeName":"1次卡","MemberCardTypeId":280,"MemberCardId":0,"IsAllowAddFee":0}]
         */

        private int TotalPage;
        private List<NotActivedListBean> notActivedList;

        public int getTotalPage() {
            return TotalPage;
        }

        public void setTotalPage(int TotalPage) {
            this.TotalPage = TotalPage;
        }

        public List<NotActivedListBean> getNotActivedList() {
            return notActivedList;
        }

        public void setNotActivedList(List<NotActivedListBean> notActivedList) {
            this.notActivedList = notActivedList;
        }

        public static class NotActivedListBean {
            /**
             * Status : 7
             * ConsumeType : 0
             * IsAllowLock : 0
             * CreateTime : 2018-09-11
             * RemainUseCount : 0
             * ImageURL : uploadFiles/uploadImgs/20180910/694a4bc2181c4919999bd5a03001cab2.png
             * IsAllowUp : 0
             * OrderId : 0120180911134513614
             * IsEvaluate : 0
             * TotalCount : 0
             * RemainLockedCount : 0
             * OnlineAddFeeMinAmount : 0
             * MemberCardTypeName : 1次卡
             * MemberCardTypeId : 280
             * MemberCardId : 0
             * IsAllowAddFee : 0
             */

            private int Status;
            private int ConsumeType;
            private int IsAllowLock;
            private String CreateTime;
            private int RemainUseCount;
            private String ImageURL;
            private int IsAllowUp;
            private String OrderId;
            private int IsEvaluate;
            private int TotalCount;
            private int RemainLockedCount;
            private int OnlineAddFeeMinAmount;
            private String MemberCardTypeName;
            private int MemberCardTypeId;
            private int MemberCardId;
            private int IsAllowAddFee;

            public int getStatus() {
                return Status;
            }

            public void setStatus(int Status) {
                this.Status = Status;
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

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
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

            public String getOrderId() {
                return OrderId;
            }

            public void setOrderId(String OrderId) {
                this.OrderId = OrderId;
            }

            public int getIsEvaluate() {
                return IsEvaluate;
            }

            public void setIsEvaluate(int IsEvaluate) {
                this.IsEvaluate = IsEvaluate;
            }

            public int getTotalCount() {
                return TotalCount;
            }

            public void setTotalCount(int TotalCount) {
                this.TotalCount = TotalCount;
            }

            public int getRemainLockedCount() {
                return RemainLockedCount;
            }

            public void setRemainLockedCount(int RemainLockedCount) {
                this.RemainLockedCount = RemainLockedCount;
            }

            public int getOnlineAddFeeMinAmount() {
                return OnlineAddFeeMinAmount;
            }

            public void setOnlineAddFeeMinAmount(int OnlineAddFeeMinAmount) {
                this.OnlineAddFeeMinAmount = OnlineAddFeeMinAmount;
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

            public int getMemberCardId() {
                return MemberCardId;
            }

            public void setMemberCardId(int MemberCardId) {
                this.MemberCardId = MemberCardId;
            }

            public int getIsAllowAddFee() {
                return IsAllowAddFee;
            }

            public void setIsAllowAddFee(int IsAllowAddFee) {
                this.IsAllowAddFee = IsAllowAddFee;
            }
        }
    }
}
