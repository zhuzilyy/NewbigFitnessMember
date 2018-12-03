package com.member.gufei.bigfitness.com.GuFei.Model.local;

/**
 * Created by GuFei_lyf on 2017/6/6
 */

public class CustomerInfoBean {


    /**
     * result : {"LastContactTime":"2017-03-07 10:18:33","LabelId":"1","LabelName":"客户标签test1","CreateUserId":1,"OwnManagerId":1,"CustomerName":"zltesttest11111133333222ssss","SourceId":"6","MemberCardTypeName":"","IntroduceMemberName":"哈哈","CreateUserName":"admi","PreSaleMoney":"","CustomerId":1,"IntroduceMemberId":"1","sourceName":"客户来源2","CreateTime":"2017-03-07 10:19:35","IntentId":"4","IntentName":"客户意向2","Remark":"11111aaa大叔大婶大所多d ff","OwnManagerName":"admi","Tel":"15842268852","Sex":1}
     * message :
     * code : 0
     */

    private ResultBean result;
    private String message;
    private int code;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean {
        /**
         * LastContactTime : 2017-03-07 10:18:33
         * LabelId : 1
         * LabelName : 客户标签test1
         * CreateUserId : 1
         * OwnManagerId : 1
         * CustomerName : zltesttest11111133333222ssss
         * SourceId : 6
         * MemberCardTypeName :
         * IntroduceMemberName : 哈哈
         * CreateUserName : admi
         * PreSaleMoney :
         * CustomerId : 1
         * IntroduceMemberId : 1
         * sourceName : 客户来源2
         * CreateTime : 2017-03-07 10:19:35
         * IntentId : 4
         * IntentName : 客户意向2
         * Remark : 11111aaa大叔大婶大所多d ff
         * OwnManagerName : admi
         * Tel : 15842268852
         * Sex : 1
         */

        private String LastContactTime;
        private String LabelId;
        private String LabelName;
        private int CreateUserId;
        private int OwnManagerId;
        private String CustomerName;
        private String SourceId;
        private String MemberCardTypeName;
        private String IntroduceMemberName;
        private String CreateUserName;
        private String PreSaleMoney;
        private int CustomerId;
        private String IntroduceMemberId;
        private String sourceName;
        private String CreateTime;
        private String IntentId;
        private String IntentName;
        private String Remark;
        private String OwnManagerName;
        private String Tel;
        private int Sex;

        public String getLastContactTime() {
            return LastContactTime;
        }

        public void setLastContactTime(String LastContactTime) {
            this.LastContactTime = LastContactTime;
        }

        public String getLabelId() {
            return LabelId;
        }

        public void setLabelId(String LabelId) {
            this.LabelId = LabelId;
        }

        public String getLabelName() {
            return LabelName;
        }

        public void setLabelName(String LabelName) {
            this.LabelName = LabelName;
        }

        public int getCreateUserId() {
            return CreateUserId;
        }

        public void setCreateUserId(int CreateUserId) {
            this.CreateUserId = CreateUserId;
        }

        public int getOwnManagerId() {
            return OwnManagerId;
        }

        public void setOwnManagerId(int OwnManagerId) {
            this.OwnManagerId = OwnManagerId;
        }

        public String getCustomerName() {
            return CustomerName;
        }

        public void setCustomerName(String CustomerName) {
            this.CustomerName = CustomerName;
        }

        public String getSourceId() {
            return SourceId;
        }

        public void setSourceId(String SourceId) {
            this.SourceId = SourceId;
        }

        public String getMemberCardTypeName() {
            return MemberCardTypeName;
        }

        public void setMemberCardTypeName(String MemberCardTypeName) {
            this.MemberCardTypeName = MemberCardTypeName;
        }

        public String getIntroduceMemberName() {
            return IntroduceMemberName;
        }

        public void setIntroduceMemberName(String IntroduceMemberName) {
            this.IntroduceMemberName = IntroduceMemberName;
        }

        public String getCreateUserName() {
            return CreateUserName;
        }

        public void setCreateUserName(String CreateUserName) {
            this.CreateUserName = CreateUserName;
        }

        public String getPreSaleMoney() {
            return PreSaleMoney;
        }

        public void setPreSaleMoney(String PreSaleMoney) {
            this.PreSaleMoney = PreSaleMoney;
        }

        public int getCustomerId() {
            return CustomerId;
        }

        public void setCustomerId(int CustomerId) {
            this.CustomerId = CustomerId;
        }

        public String getIntroduceMemberId() {
            return IntroduceMemberId;
        }

        public void setIntroduceMemberId(String IntroduceMemberId) {
            this.IntroduceMemberId = IntroduceMemberId;
        }

        public String getSourceName() {
            return sourceName;
        }

        public void setSourceName(String sourceName) {
            this.sourceName = sourceName;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getIntentId() {
            return IntentId;
        }

        public void setIntentId(String IntentId) {
            this.IntentId = IntentId;
        }

        public String getIntentName() {
            return IntentName;
        }

        public void setIntentName(String IntentName) {
            this.IntentName = IntentName;
        }

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }

        public String getOwnManagerName() {
            return OwnManagerName;
        }

        public void setOwnManagerName(String OwnManagerName) {
            this.OwnManagerName = OwnManagerName;
        }

        public String getTel() {
            return Tel;
        }

        public void setTel(String Tel) {
            this.Tel = Tel;
        }

        public int getSex() {
            return Sex;
        }

        public void setSex(int Sex) {
            this.Sex = Sex;
        }
    }
}
