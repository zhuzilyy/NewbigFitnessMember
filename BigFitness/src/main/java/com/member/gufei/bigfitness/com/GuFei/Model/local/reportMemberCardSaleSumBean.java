package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/9/20.
 */

public class reportMemberCardSaleSumBean {


    /**
     * message :
     * result : [{"timeCardSaleNum":0,"RBuyMoney":840114,"numCardSaleNum":0}]
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
         * RBuyMoney : 840114
         * numCardSaleNum : 0
         */

        private int timeCardSaleNum;
        private int RBuyMoney;
        private int numCardSaleNum;

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
    }
}
