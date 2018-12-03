package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/4/5.
 */

public class AppGetMyMemberCardListActivedBean {

    /**
     * Ret : 0
     * Msg :
     * rows : {"TotalPage":1,"activedList":[{"Status":3,"ConsumeType":1,"IsAllowLock":0,"CreateTime":"2018-08-31","RemainUseCount":0,"ImageURL":"uploadFiles/uploadImgs/20180911/41220e2aaddd4a589dedb31228d6b25b.png","IsAllowUp":0,"OrderId":"","IsEvaluate":1,"TotalCount":0,"RemainLockedCount":0,"OnlineAddFeeMinAmount":1,"MemberCardTypeName":"测试卡","MemberCardTypeId":275,"MemberCardId":165482,"IsAllowAddFee":1,"ExpireTime":"2018-09-01"},{"Status":3,"ConsumeType":1,"IsAllowLock":1,"CreateTime":"2018-08-31","RemainUseCount":0,"ImageURL":"uploadFiles/uploadImgs/20180911/41220e2aaddd4a589dedb31228d6b25b.png","IsAllowUp":0,"OrderId":"","IsEvaluate":1,"TotalCount":0,"RemainLockedCount":1,"OnlineAddFeeMinAmount":1,"MemberCardTypeName":"测试卡","MemberCardTypeId":275,"MemberCardId":165483,"IsAllowAddFee":1,"ExpireTime":"2018-09-01"},{"Status":3,"ConsumeType":1,"IsAllowLock":1,"CreateTime":"2018-08-31","RemainUseCount":0,"ImageURL":"uploadFiles/uploadImgs/20180911/41220e2aaddd4a589dedb31228d6b25b.png","IsAllowUp":0,"OrderId":"","IsEvaluate":1,"TotalCount":0,"RemainLockedCount":1,"OnlineAddFeeMinAmount":1,"MemberCardTypeName":"测试卡","MemberCardTypeId":275,"MemberCardId":165484,"IsAllowAddFee":1,"ExpireTime":"2018-09-01"},{"Status":3,"ConsumeType":1,"IsAllowLock":1,"CreateTime":"2018-08-31","RemainUseCount":0,"ImageURL":"uploadFiles/uploadImgs/20180911/41220e2aaddd4a589dedb31228d6b25b.png","IsAllowUp":0,"OrderId":"","IsEvaluate":1,"TotalCount":0,"RemainLockedCount":1,"OnlineAddFeeMinAmount":1,"MemberCardTypeName":"测试卡","MemberCardTypeId":275,"MemberCardId":165485,"IsAllowAddFee":1,"ExpireTime":"2018-09-01"},{"Status":3,"ConsumeType":1,"IsAllowLock":1,"CreateTime":"2018-08-31","RemainUseCount":0,"ImageURL":"uploadFiles/uploadImgs/20180911/41220e2aaddd4a589dedb31228d6b25b.png","IsAllowUp":0,"OrderId":"","IsEvaluate":1,"TotalCount":0,"RemainLockedCount":1,"OnlineAddFeeMinAmount":1,"MemberCardTypeName":"测试卡","MemberCardTypeId":275,"MemberCardId":165486,"IsAllowAddFee":1,"ExpireTime":"2018-09-01"},{"Status":3,"ConsumeType":1,"IsAllowLock":1,"CreateTime":"2018-08-31","RemainUseCount":0,"ImageURL":"uploadFiles/uploadImgs/20180912/8d2cbf3a122c494ca7aaaaf4fa98be87.png","IsAllowUp":1,"OrderId":"","IsEvaluate":1,"TotalCount":0,"RemainLockedCount":2,"OnlineAddFeeMinAmount":10,"MemberCardTypeName":"便宜卡","MemberCardTypeId":277,"MemberCardId":165495,"IsAllowAddFee":1,"ExpireTime":"2018-09-10"},{"Status":3,"ConsumeType":1,"IsAllowLock":1,"CreateTime":"2018-08-31","RemainUseCount":0,"ImageURL":"uploadFiles/uploadImgs/20180911/41220e2aaddd4a589dedb31228d6b25b.png","IsAllowUp":0,"OrderId":"","IsEvaluate":1,"TotalCount":0,"RemainLockedCount":1,"OnlineAddFeeMinAmount":1,"MemberCardTypeName":"测试卡","MemberCardTypeId":275,"MemberCardId":165534,"IsAllowAddFee":1,"ExpireTime":"2018-09-01"},{"Status":3,"ConsumeType":1,"IsAllowLock":1,"CreateTime":"2018-08-31","RemainUseCount":0,"ImageURL":"uploadFiles/uploadImgs/20180912/8d2cbf3a122c494ca7aaaaf4fa98be87.png","IsAllowUp":1,"OrderId":"","IsEvaluate":1,"TotalCount":0,"RemainLockedCount":2,"OnlineAddFeeMinAmount":10,"MemberCardTypeName":"便宜卡","MemberCardTypeId":277,"MemberCardId":165535,"IsAllowAddFee":1,"ExpireTime":"2018-09-10"}]}
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
         * activedList : [{"Status":3,"ConsumeType":1,"IsAllowLock":0,"CreateTime":"2018-08-31","RemainUseCount":0,"ImageURL":"uploadFiles/uploadImgs/20180911/41220e2aaddd4a589dedb31228d6b25b.png","IsAllowUp":0,"OrderId":"","IsEvaluate":1,"TotalCount":0,"RemainLockedCount":0,"OnlineAddFeeMinAmount":1,"MemberCardTypeName":"测试卡","MemberCardTypeId":275,"MemberCardId":165482,"IsAllowAddFee":1,"ExpireTime":"2018-09-01"},{"Status":3,"ConsumeType":1,"IsAllowLock":1,"CreateTime":"2018-08-31","RemainUseCount":0,"ImageURL":"uploadFiles/uploadImgs/20180911/41220e2aaddd4a589dedb31228d6b25b.png","IsAllowUp":0,"OrderId":"","IsEvaluate":1,"TotalCount":0,"RemainLockedCount":1,"OnlineAddFeeMinAmount":1,"MemberCardTypeName":"测试卡","MemberCardTypeId":275,"MemberCardId":165483,"IsAllowAddFee":1,"ExpireTime":"2018-09-01"},{"Status":3,"ConsumeType":1,"IsAllowLock":1,"CreateTime":"2018-08-31","RemainUseCount":0,"ImageURL":"uploadFiles/uploadImgs/20180911/41220e2aaddd4a589dedb31228d6b25b.png","IsAllowUp":0,"OrderId":"","IsEvaluate":1,"TotalCount":0,"RemainLockedCount":1,"OnlineAddFeeMinAmount":1,"MemberCardTypeName":"测试卡","MemberCardTypeId":275,"MemberCardId":165484,"IsAllowAddFee":1,"ExpireTime":"2018-09-01"},{"Status":3,"ConsumeType":1,"IsAllowLock":1,"CreateTime":"2018-08-31","RemainUseCount":0,"ImageURL":"uploadFiles/uploadImgs/20180911/41220e2aaddd4a589dedb31228d6b25b.png","IsAllowUp":0,"OrderId":"","IsEvaluate":1,"TotalCount":0,"RemainLockedCount":1,"OnlineAddFeeMinAmount":1,"MemberCardTypeName":"测试卡","MemberCardTypeId":275,"MemberCardId":165485,"IsAllowAddFee":1,"ExpireTime":"2018-09-01"},{"Status":3,"ConsumeType":1,"IsAllowLock":1,"CreateTime":"2018-08-31","RemainUseCount":0,"ImageURL":"uploadFiles/uploadImgs/20180911/41220e2aaddd4a589dedb31228d6b25b.png","IsAllowUp":0,"OrderId":"","IsEvaluate":1,"TotalCount":0,"RemainLockedCount":1,"OnlineAddFeeMinAmount":1,"MemberCardTypeName":"测试卡","MemberCardTypeId":275,"MemberCardId":165486,"IsAllowAddFee":1,"ExpireTime":"2018-09-01"},{"Status":3,"ConsumeType":1,"IsAllowLock":1,"CreateTime":"2018-08-31","RemainUseCount":0,"ImageURL":"uploadFiles/uploadImgs/20180912/8d2cbf3a122c494ca7aaaaf4fa98be87.png","IsAllowUp":1,"OrderId":"","IsEvaluate":1,"TotalCount":0,"RemainLockedCount":2,"OnlineAddFeeMinAmount":10,"MemberCardTypeName":"便宜卡","MemberCardTypeId":277,"MemberCardId":165495,"IsAllowAddFee":1,"ExpireTime":"2018-09-10"},{"Status":3,"ConsumeType":1,"IsAllowLock":1,"CreateTime":"2018-08-31","RemainUseCount":0,"ImageURL":"uploadFiles/uploadImgs/20180911/41220e2aaddd4a589dedb31228d6b25b.png","IsAllowUp":0,"OrderId":"","IsEvaluate":1,"TotalCount":0,"RemainLockedCount":1,"OnlineAddFeeMinAmount":1,"MemberCardTypeName":"测试卡","MemberCardTypeId":275,"MemberCardId":165534,"IsAllowAddFee":1,"ExpireTime":"2018-09-01"},{"Status":3,"ConsumeType":1,"IsAllowLock":1,"CreateTime":"2018-08-31","RemainUseCount":0,"ImageURL":"uploadFiles/uploadImgs/20180912/8d2cbf3a122c494ca7aaaaf4fa98be87.png","IsAllowUp":1,"OrderId":"","IsEvaluate":1,"TotalCount":0,"RemainLockedCount":2,"OnlineAddFeeMinAmount":10,"MemberCardTypeName":"便宜卡","MemberCardTypeId":277,"MemberCardId":165535,"IsAllowAddFee":1,"ExpireTime":"2018-09-10"}]
         */

        private int TotalPage;
        private List<ActivedListBean> activedList;

        public int getTotalPage() {
            return TotalPage;
        }

        public void setTotalPage(int TotalPage) {
            this.TotalPage = TotalPage;
        }

        public List<ActivedListBean> getActivedList() {
            return activedList;
        }

        public void setActivedList(List<ActivedListBean> activedList) {
            this.activedList = activedList;
        }

        public static class ActivedListBean {
            /**
             * Status : 3
             * ConsumeType : 1
             * IsAllowLock : 0
             * CreateTime : 2018-08-31
             * RemainUseCount : 0
             * ImageURL : uploadFiles/uploadImgs/20180911/41220e2aaddd4a589dedb31228d6b25b.png
             * IsAllowUp : 0
             * OrderId :
             * IsEvaluate : 1
             * TotalCount : 0
             * RemainLockedCount : 0
             * OnlineAddFeeMinAmount : 1
             * MemberCardTypeName : 测试卡
             * MemberCardTypeId : 275
             * MemberCardId : 165482
             * IsAllowAddFee : 1
             * ExpireTime : 2018-09-01
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
            private String ExpireTime;

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

            public String getExpireTime() {
                return ExpireTime;
            }

            public void setExpireTime(String ExpireTime) {
                this.ExpireTime = ExpireTime;
            }
        }
    }
}
