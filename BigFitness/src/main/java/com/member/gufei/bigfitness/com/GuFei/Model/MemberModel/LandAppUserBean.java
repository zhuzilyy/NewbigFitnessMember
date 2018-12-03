package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/3/27.
 */

public class LandAppUserBean {

    /**
     * Ret : 0
     * Msg : 用户登录成功！
     * rows : {"IsAppUserInfo":1,"APPUserId":36,"Sex":1,"HeaderURL":"222111.jpg","Birthday":"1996-06-06","Height":170,"FitnessRequest":["448","449","450"],"NickName":"隔壁老王","Mobile":"15142200021","Weight":180,"token":"eyJBbGciOiJNRDUifQ==.eyJVc2VySWQiOm51bGwsIkNyZWF0ZVRpbWUiOiIyMDE4LTA1LTMwIDEyOjQ1OjA3IiwiRGV2aWNlQ29kZSI6IjM5MWIwYWRhZjM2NDY1MmZmMjEzZDA2ODAwZjMyNGFjIn0=.c42a67b59de03c664c954da9bf6ef584","FitnessRequestName":["大连外国语大学","大连东软","大连大学"]}
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
         * IsAppUserInfo : 1
         * APPUserId : 36
         * Sex : 1
         * HeaderURL : 222111.jpg
         * Birthday : 1996-06-06
         * Height : 170
         * FitnessRequest : ["448","449","450"]
         * NickName : 隔壁老王
         * Mobile : 15142200021
         * Weight : 180
         * token : eyJBbGciOiJNRDUifQ==.eyJVc2VySWQiOm51bGwsIkNyZWF0ZVRpbWUiOiIyMDE4LTA1LTMwIDEyOjQ1OjA3IiwiRGV2aWNlQ29kZSI6IjM5MWIwYWRhZjM2NDY1MmZmMjEzZDA2ODAwZjMyNGFjIn0=.c42a67b59de03c664c954da9bf6ef584
         * FitnessRequestName : ["大连外国语大学","大连东软","大连大学"]
         */

        private int IsAppUserInfo;
        private int APPUserId;
        private int Sex;
        private String HeaderURL;
        private String Birthday;
        private int Height;
        private String NickName;
        private String Mobile;
        private String Weight;
        private String token;

        public String getFitnessRequest() {
            return FitnessRequest;
        }

        public void setFitnessRequest(String fitnessRequest) {
            FitnessRequest = fitnessRequest;
        }

        private String FitnessRequest;
//        private List<String> FitnessRequestName;

        public int getIsAppUserInfo() {
            return IsAppUserInfo;
        }

        public void setIsAppUserInfo(int IsAppUserInfo) {
            this.IsAppUserInfo = IsAppUserInfo;
        }

        public int getAPPUserId() {
            return APPUserId;
        }

        public void setAPPUserId(int APPUserId) {
            this.APPUserId = APPUserId;
        }

        public int getSex() {
            return Sex;
        }

        public void setSex(int Sex) {
            this.Sex = Sex;
        }

        public String getHeaderURL() {
            return HeaderURL;
        }

        public void setHeaderURL(String HeaderURL) {
            this.HeaderURL = HeaderURL;
        }

        public String getBirthday() {
            return Birthday;
        }

        public void setBirthday(String Birthday) {
            this.Birthday = Birthday;
        }

        public int getHeight() {
            return Height;
        }

        public void setHeight(int Height) {
            this.Height = Height;
        }

        public String getNickName() {
            return NickName;
        }

        public void setNickName(String NickName) {
            this.NickName = NickName;
        }

        public String getMobile() {
            return Mobile;
        }

        public void setMobile(String Mobile) {
            this.Mobile = Mobile;
        }

        public String getWeight() {
            return Weight;
        }

        public void setWeight(String weight) {
            Weight = weight;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }


    }
}
