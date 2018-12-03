package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/6/18.
 */

public class MemberwardrobeListBean {


    /**
     * message :
     * result : [{"Status":"已使用","WardrobeId":75,"WardrobeNo":"VIP5","WardrobeBalance":"7月"}]
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
         * Status : 已使用
         * WardrobeId : 75
         * WardrobeNo : VIP5
         * WardrobeBalance : 7月
         */

        private String Status;
        private int WardrobeId;
        private String WardrobeNo;
        private String WardrobeBalance;

        public String getOther() {
            return other;
        }

        public void setOther(String other) {
            this.other = other;
        }

        private String other;

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public int getWardrobeId() {
            return WardrobeId;
        }

        public void setWardrobeId(int WardrobeId) {
            this.WardrobeId = WardrobeId;
        }

        public String getWardrobeNo() {
            return WardrobeNo;
        }

        public void setWardrobeNo(String WardrobeNo) {
            this.WardrobeNo = WardrobeNo;
        }

        public String getWardrobeBalance() {
            return WardrobeBalance;
        }

        public void setWardrobeBalance(String WardrobeBalance) {
            this.WardrobeBalance = WardrobeBalance;
        }
    }
}
