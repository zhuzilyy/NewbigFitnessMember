package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by GuFei on 2018/3/27.
 * #获取私教课续费-APP支付订单信息

 */

public class AppAddFeeMemberLessonPayBean {


    /**
     * Msg : {"parameterMap":{"appid":"wxaf0ab09f52188483","noncestr":"cYSAbk6LGTgPn7BwofG9rnqNMKgr3662","package":"Sign=WXPay","partnerid":"1500099612","prepayid":"wx211033024538421af28a471a3165974959","sign":"82FFCECE9339E7EC37BADE4DBF91C387","timestamp":1529548374633}}
     * Ret : 0
     */

    private MsgBean Msg;
    private int Ret;

    public MsgBean getMsg() {
        return Msg;
    }

    public void setMsg(MsgBean Msg) {
        this.Msg = Msg;
    }

    public int getRet() {
        return Ret;
    }

    public void setRet(int Ret) {
        this.Ret = Ret;
    }

    public static class MsgBean {
        /**
         * parameterMap : {"appid":"wxaf0ab09f52188483","noncestr":"cYSAbk6LGTgPn7BwofG9rnqNMKgr3662","package":"Sign=WXPay","partnerid":"1500099612","prepayid":"wx211033024538421af28a471a3165974959","sign":"82FFCECE9339E7EC37BADE4DBF91C387","timestamp":1529548374633}
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
             * noncestr : cYSAbk6LGTgPn7BwofG9rnqNMKgr3662
             * package : Sign=WXPay
             * partnerid : 1500099612
             * prepayid : wx211033024538421af28a471a3165974959
             * sign : 82FFCECE9339E7EC37BADE4DBF91C387
             * timestamp : 1529548374633
             */

            private String appid;
            private String noncestr;
            @SerializedName("package")
            private String packageX;
            private String partnerid;
            private String prepayid;
            private String sign;
            private long timestamp;

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

            public long getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(long timestamp) {
                this.timestamp = timestamp;
            }
        }
    }
}
