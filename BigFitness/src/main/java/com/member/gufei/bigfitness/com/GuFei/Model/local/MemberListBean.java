package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/6/9
 */

public class MemberListBean {

    /**
     * result : [{"LastContactTime":"2017/05/26 15:29","CustomerId":41,"CreateTime":"2017/05/17 14:43","CustomerName":"2","Tel":"234234234","Sex":"男"},{"LastContactTime":"2017/06/01 13:11","CustomerId":49,"CreateTime":"2017/05/23 10:57","CustomerName":"jhhgh","Tel":"4444","Sex":"男"}]
     * message :
     * code : 0
     */

    private String message;
    private int code;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * LastContactTime : 2017/05/26 15:29
         * CustomerId : 41
         * CreateTime : 2017/05/17 14:43
         * CustomerName : 2
         * Tel : 234234234
         * Sex : 男
         */

        private String LastContactTime;
        private int CustomerId;
        private String CreateTime;
        private String CustomerName;
        private String Tel;
        private String Sex;

        public String getLastContactTime() {
            return LastContactTime;
        }

        public void setLastContactTime(String LastContactTime) {
            this.LastContactTime = LastContactTime;
        }

        public int getCustomerId() {
            return CustomerId;
        }

        public void setCustomerId(int CustomerId) {
            this.CustomerId = CustomerId;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getCustomerName() {
            return CustomerName;
        }

        public void setCustomerName(String CustomerName) {
            this.CustomerName = CustomerName;
        }

        public String getTel() {
            return Tel;
        }

        public void setTel(String Tel) {
            this.Tel = Tel;
        }

        public String getSex() {
            return Sex;
        }

        public void setSex(String Sex) {
            this.Sex = Sex;
        }
    }
}
