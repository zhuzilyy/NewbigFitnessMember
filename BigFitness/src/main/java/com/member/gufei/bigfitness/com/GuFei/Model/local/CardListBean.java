package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Description
 *
 * @author Song.gl
 * @version 2017 06 21 22:50
 */
public class CardListBean {

    /**
     * message :
     * result : [{"ConsumeType":"时卡","MemberCardId":229,"ExpireTime":"2018/05/21","STATUS":"已开卡","CardBalance":"334天","MemberCardTypeName":"单年卡"}]
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
         * ConsumeType : 时卡
         * MemberCardId : 229
         * ExpireTime : 2018/05/21
         * STATUS : 已开卡
         * CardBalance : 334天
         * MemberCardTypeName : 单年卡
         */

        private String ConsumeType;
        private int MemberCardId;
        private String ExpireTime;
        private String STATUS;
        private String CardBalance;
        private String MemberCardTypeName;

        public String getConsumeType() {
            return ConsumeType;
        }

        public void setConsumeType(String ConsumeType) {
            this.ConsumeType = ConsumeType;
        }

        public int getMemberCardId() {
            return MemberCardId;
        }

        public void setMemberCardId(int MemberCardId) {
            this.MemberCardId = MemberCardId;
        }

        public String getExpireTime() {
            return ExpireTime;
        }

        public void setExpireTime(String ExpireTime) {
            this.ExpireTime = ExpireTime;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        public String getCardBalance() {
            return CardBalance;
        }

        public void setCardBalance(String CardBalance) {
            this.CardBalance = CardBalance;
        }

        public String getMemberCardTypeName() {
            return MemberCardTypeName;
        }

        public void setMemberCardTypeName(String MemberCardTypeName) {
            this.MemberCardTypeName = MemberCardTypeName;
        }
    }
}
