package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/4/17.
 */

public class MemberMyInfoBean {


    /**
     * Ret : 0
     * Msg :
     * rows : {"APPUserId":"36","Sex":"1","HeaderURL":"222111.jpg","DeviceCode":"391b0adaf364652ff213d06800f324ac","Birthday":"1996-06-06","Height":"170","FitnessRequest":["448","449","450"],"NickName":"隔壁老王","Mobile":"15142200021","Weight":"180","token":"eyJBbGciOiJNRDUifQ==.eyJVc2VySWQiOm51bGwsIkNyZWF0ZVRpbWUiOiIyMDE4LTA0LTE3IDA0OjEyOjI1IiwiRGV2aWNlQ29kZSI6IjM5MWIwYWRhZjM2NDY1MmZmMjEzZDA2ODAwZjMyNGFjIn0=.78a2863e4015c1203107bfaad4958ec9","FitnessRequestName":["减脂","增肌","塑形"]}
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
         * APPUserId : 36
         * Sex : 1
         * HeaderURL : 222111.jpg
         * DeviceCode : 391b0adaf364652ff213d06800f324ac
         * Birthday : 1996-06-06
         * Height : 170
         * FitnessRequest : ["448","449","450"]
         * NickName : 隔壁老王
         * Mobile : 15142200021
         * Weight : 180
         * token : eyJBbGciOiJNRDUifQ==.eyJVc2VySWQiOm51bGwsIkNyZWF0ZVRpbWUiOiIyMDE4LTA0LTE3IDA0OjEyOjI1IiwiRGV2aWNlQ29kZSI6IjM5MWIwYWRhZjM2NDY1MmZmMjEzZDA2ODAwZjMyNGFjIn0=.78a2863e4015c1203107bfaad4958ec9
         * FitnessRequestName : ["减脂","增肌","塑形"]
         */

        private String APPUserId;
        private String Sex;
        private String HeaderURL;
        private String DeviceCode;
        private String Birthday;
        private String Height;
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



        public String getAPPUserId() {
            return APPUserId;
        }

        public void setAPPUserId(String APPUserId) {
            this.APPUserId = APPUserId;
        }

        public String getSex() {
            return Sex;
        }

        public void setSex(String Sex) {
            this.Sex = Sex;
        }

        public String getHeaderURL() {
            return HeaderURL;
        }

        public void setHeaderURL(String HeaderURL) {
            this.HeaderURL = HeaderURL;
        }

        public String getDeviceCode() {
            return DeviceCode;
        }

        public void setDeviceCode(String DeviceCode) {
            this.DeviceCode = DeviceCode;
        }

        public String getBirthday() {
            return Birthday;
        }

        public void setBirthday(String Birthday) {
            this.Birthday = Birthday;
        }

        public String getHeight() {
            return Height;
        }

        public void setHeight(String Height) {
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

        public void setWeight(String Weight) {
            this.Weight = Weight;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }


    }
}
