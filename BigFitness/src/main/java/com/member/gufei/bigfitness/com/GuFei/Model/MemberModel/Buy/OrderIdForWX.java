package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy;

import com.google.gson.annotations.SerializedName;

/**
 * Created by GuFei on 2018/6/27.
 */

public class OrderIdForWX {

    /**
     * parameterMap : {"appid":"wxaf0ab09f52188483","noncestr":"aYbkmAyz5e6pJtsRtKmL73NhziJNwvkq","package":"Sign=WXPay","partnerid":"1500099612","prepayid":"wx2110330210155657cd0a4cae3703709557","sign":"B3C94E753B5F6DFEEA7239EF8BE53515","timestamp":1529548374305}
     */

    private ParameterMapBean parameterMap;

    public ParameterMapBean getParameterMap() {
        return parameterMap;
    }

    public void setParameterMap(ParameterMapBean parameterMap) {
        this.parameterMap = parameterMap;
    }

    public static class ParameterMapBean {
        /**
         * appid : wxaf0ab09f52188483
         * noncestr : aYbkmAyz5e6pJtsRtKmL73NhziJNwvkq
         * package : Sign=WXPay
         * partnerid : 1500099612
         * prepayid : wx2110330210155657cd0a4cae3703709557
         * sign : B3C94E753B5F6DFEEA7239EF8BE53515
         * timestamp : 1529548374305
         */

        private String appid;
        private String partnerid;
        private String prepayid;
        @SerializedName("package")
        private String packageX;
        private String noncestr;
        private String timestamp;
        private String sign;


        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }
    }
}
