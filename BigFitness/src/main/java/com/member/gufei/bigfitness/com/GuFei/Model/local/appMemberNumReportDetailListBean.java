package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/9/27.
 */

public class appMemberNumReportDetailListBean {


    /**
     * code : 0
     * message :
     * result : [{"HeaderURL":"","LastContactTime":"","MemberId":32283,"MemberName":"123123","Sex":"男","Tel":"15940170853"}]
     */

    private int code;
    private String message;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * HeaderURL :
         * LastContactTime :
         * MemberId : 32283
         * MemberName : 123123
         * Sex : 男
         * Tel : 15940170853
         */

        private String HeaderURL;
        private String LastContactTime;
        private int MemberId;
        private String MemberName;
        private String Sex;
        private String Tel;

        public String getHeaderURL() {
            return HeaderURL;
        }

        public void setHeaderURL(String HeaderURL) {
            this.HeaderURL = HeaderURL;
        }

        public String getLastContactTime() {
            return LastContactTime;
        }

        public void setLastContactTime(String LastContactTime) {
            this.LastContactTime = LastContactTime;
        }

        public int getMemberId() {
            return MemberId;
        }

        public void setMemberId(int MemberId) {
            this.MemberId = MemberId;
        }

        public String getMemberName() {
            return MemberName;
        }

        public void setMemberName(String MemberName) {
            this.MemberName = MemberName;
        }

        public String getSex() {
            return Sex;
        }

        public void setSex(String Sex) {
            this.Sex = Sex;
        }

        public String getTel() {
            return Tel;
        }

        public void setTel(String Tel) {
            this.Tel = Tel;
        }
    }
}
