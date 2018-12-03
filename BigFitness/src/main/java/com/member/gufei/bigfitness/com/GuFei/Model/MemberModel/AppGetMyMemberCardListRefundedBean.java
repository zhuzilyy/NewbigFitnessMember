package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/4/5.
 */

public class AppGetMyMemberCardListRefundedBean {


    /**
     * Ret : 0
     * Msg :
     * rows : {"TotalPage":1,"notActivedList":[{"STATUS":8,"ConsumeType":1,"IsAllowLock":0,"CreateTime":"2018-03-30","MemberCardTypeName":"单年卡","ImageURL":"","IsAllowAddFeem":0,"MemberCardId":0,"IsAllowUp":0,"OrderId":"2","IsEvaluate":0}]}
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
         * notActivedList : [{"STATUS":8,"ConsumeType":1,"IsAllowLock":0,"CreateTime":"2018-03-30","MemberCardTypeName":"单年卡","ImageURL":"","IsAllowAddFeem":0,"MemberCardId":0,"IsAllowUp":0,"OrderId":"2","IsEvaluate":0}]
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
             * STATUS : 8
             * ConsumeType : 1
             * IsAllowLock : 0
             * CreateTime : 2018-03-30
             * MemberCardTypeName : 单年卡
             * ImageURL :
             * IsAllowAddFeem : 0
             * MemberCardId : 0
             * IsAllowUp : 0
             * OrderId : 2
             * IsEvaluate : 0
             */

            private int STATUS;
            private int ConsumeType;
            private int IsAllowLock;
            private String CreateTime;
            private String MemberCardTypeName;
            private String ImageURL;
            private int IsAllowAddFeem;
            private int MemberCardId;
            private int IsAllowUp;
            private String OrderId;
            private int IsEvaluate;
            private int MemberCardTypeId;

            public int getMemberCardTypeId() {
                return MemberCardTypeId;
            }

            public void setMemberCardTypeId(int memberCardTypeId) {
                MemberCardTypeId = memberCardTypeId;
            }


            public int getSTATUS() {
                return STATUS;
            }

            public void setSTATUS(int STATUS) {
                this.STATUS = STATUS;
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

            public int getIsAllowAddFeem() {
                return IsAllowAddFeem;
            }

            public void setIsAllowAddFeem(int IsAllowAddFeem) {
                this.IsAllowAddFeem = IsAllowAddFeem;
            }

            public int getMemberCardId() {
                return MemberCardId;
            }

            public void setMemberCardId(int MemberCardId) {
                this.MemberCardId = MemberCardId;
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
        }
    }
}
