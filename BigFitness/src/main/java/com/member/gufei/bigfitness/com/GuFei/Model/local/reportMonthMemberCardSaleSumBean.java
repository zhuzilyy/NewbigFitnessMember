package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */

public class reportMonthMemberCardSaleSumBean {


    /**
     * message :
     * result : [{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-01"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-02"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-03"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-04"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-05"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-06"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-07"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-08"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-09"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-10"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-11"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-12"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-13"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-14"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-15"},{"timeCardSaleNum":0,"RBuyMoney":1000,"numCardSaleNum":0,"day":"2017-08-16"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-17"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-18"},{"timeCardSaleNum":0,"RBuyMoney":3000,"numCardSaleNum":0,"day":"2017-08-19"},{"timeCardSaleNum":0,"RBuyMoney":2400,"numCardSaleNum":0,"day":"2017-08-20"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-21"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-22"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-23"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-24"},{"timeCardSaleNum":0,"RBuyMoney":2600,"numCardSaleNum":0,"day":"2017-08-25"},{"timeCardSaleNum":0,"RBuyMoney":5400,"numCardSaleNum":0,"day":"2017-08-26"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-27"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-28"},{"timeCardSaleNum":0,"RBuyMoney":1600,"numCardSaleNum":0,"day":"2017-08-29"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-30"},{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0,"day":"2017-08-31"}]
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
         * timeCardSaleNum : 0
         * RBuyMoney : 0
         * numCardSaleNum : 0
         * day : 2017-08-01
         */

        private int timeCardSaleNum;
        private int RBuyMoney;
        private int numCardSaleNum;
        private String day;

        public int getTimeCardSaleNum() {
            return timeCardSaleNum;
        }

        public void setTimeCardSaleNum(int timeCardSaleNum) {
            this.timeCardSaleNum = timeCardSaleNum;
        }

        public int getRBuyMoney() {
            return RBuyMoney;
        }

        public void setRBuyMoney(int RBuyMoney) {
            this.RBuyMoney = RBuyMoney;
        }

        public int getNumCardSaleNum() {
            return numCardSaleNum;
        }

        public void setNumCardSaleNum(int numCardSaleNum) {
            this.numCardSaleNum = numCardSaleNum;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }
    }
}
