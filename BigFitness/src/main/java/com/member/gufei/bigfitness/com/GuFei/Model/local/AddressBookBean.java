package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/6/1
 */

public class AddressBookBean {


    /**
     * result : [{"HeaderURL":"","OfficeName":"12313","DepartName":"综合部1","UserName":"mhy000","UserId":10,"Tel":"2313"},{"HeaderURL":"","OfficeName":"1111111","DepartName":"综合部1","UserName":"fwefew","UserId":9,"Tel":"1"},{"HeaderURL":"","OfficeName":"123","DepartName":"教练部","UserName":"我是教练","UserId":8,"Tel":"15084047851"},{"HeaderURL":"","OfficeName":"2","DepartName":"综合部1","UserName":"b","UserId":7,"Tel":"2"},{"HeaderURL":"uploadFiles/uploadImgs/20170309/7d87d989be7049dabcea38632e35ec01.png","OfficeName":"道","DepartName":"运营部","UserName":"test4","UserId":5,"Tel":"1"},{"HeaderURL":"uploadFiles/uploadImgs/20170309/7d87d989be7049dabcea38632e35ec01.png","OfficeName":"道","DepartName":"运营部","UserName":"test3","UserId":4,"Tel":"1"},{"HeaderURL":"uploadFiles/uploadImgs/20170518/cc871778790b4266be0a0e77ea5e8121.png","OfficeName":"非常好","DepartName":"综合部","UserName":"test2","UserId":3,"Tel":"1"}]
     * code : 0
     */

    private int code;
    private List<ResultBean> result;

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
         * HeaderURL :
         * OfficeName : 12313
         * DepartName : 综合部1
         * UserName : mhy000
         * UserId : 10
         * Tel : 2313
         */

        private String HeaderURL;
        private String OfficeName;
        private String DepartName;
        private String UserName;
        private String sex ;
        private int UserId;
        private String Tel;

        public String getHeaderURL() {
            return HeaderURL;
        }

        public void setHeaderURL(String HeaderURL) {
            this.HeaderURL = HeaderURL;
        }

        public String getOfficeName() {
            return OfficeName;
        }

        public void setOfficeName(String OfficeName) {
            this.OfficeName = OfficeName;
        }

        public String getDepartName() {
            return DepartName;
        }

        public void setDepartName(String DepartName) {
            this.DepartName = DepartName;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public int getUserId() {
            return UserId;
        }

        public void setUserId(int UserId) {
            this.UserId = UserId;
        }

        public String getTel() {
            return Tel;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setTel(String Tel) {
            this.Tel = Tel;
        }
    }
}
