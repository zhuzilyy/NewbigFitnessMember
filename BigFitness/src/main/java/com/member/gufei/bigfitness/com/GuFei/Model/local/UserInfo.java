package com.member.gufei.bigfitness.com.GuFei.Model.local;

/**
 * 用户信息
 *
 * @author GuFei
 * @version 2016 12 20 11:01
 */
@SuppressWarnings("unused")
public class UserInfo {


    /**
     * result : {"Age":0,"JobNumber":"1","ProtectDays":0,"CustomerLimit":0,"DepartName":"系统管理","IDCard":"a","UserName":"管理员","HeaderURL":"s","ClubName":"测试会所","PersonType":"其它","Email":"a","OfficeName":"系统管理员","Tel":"1","Sex":"男"}
     * code : 0
     */

    private ResultBean result;
    private int code;

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
         * Age : 0
         * JobNumber : 1
         * ProtectDays : 0
         * CustomerLimit : 0
         * DepartName : 系统管理
         * IDCard : a
         * UserName : 管理员
         * HeaderURL : s
         * ClubName : 测试会所
         * PersonType : 其它
         * Email : a
         * OfficeName : 系统管理员
         * Tel : 1
         * Sex : 男
         */

        private int Age;
        private String JobNumber;
        private int ProtectDays;
        private int CustomerLimit;
        private String DepartName;
        private String IDCard;
        private String UserName;
        private String HeaderURL;
        private String ClubName;
        private String PersonType;
        private String Email;
        private String OfficeName;
        private String Tel;
        private String Sex;

        public int getAge() {
            return Age;
        }

        public void setAge(int Age) {
            this.Age = Age;
        }

        public String getJobNumber() {
            return JobNumber;
        }

        public void setJobNumber(String JobNumber) {
            this.JobNumber = JobNumber;
        }

        public int getProtectDays() {
            return ProtectDays;
        }

        public void setProtectDays(int ProtectDays) {
            this.ProtectDays = ProtectDays;
        }

        public int getCustomerLimit() {
            return CustomerLimit;
        }

        public void setCustomerLimit(int CustomerLimit) {
            this.CustomerLimit = CustomerLimit;
        }

        public String getDepartName() {
            return DepartName;
        }

        public void setDepartName(String DepartName) {
            this.DepartName = DepartName;
        }

        public String getIDCard() {
            return IDCard;
        }

        public void setIDCard(String IDCard) {
            this.IDCard = IDCard;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getHeaderURL() {
            return HeaderURL;
        }

        public void setHeaderURL(String HeaderURL) {
            this.HeaderURL = HeaderURL;
        }

        public String getClubName() {
            return ClubName;
        }

        public void setClubName(String ClubName) {
            this.ClubName = ClubName;
        }

        public String getPersonType() {
            return PersonType;
        }

        public void setPersonType(String PersonType) {
            this.PersonType = PersonType;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }

        public String getOfficeName() {
            return OfficeName;
        }

        public void setOfficeName(String OfficeName) {
            this.OfficeName = OfficeName;
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