package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/9/27.
 */

public class reportForDayBean {


    /**
     * message :
     * lessonResult : [{"LeLessonSum":4076,"LessonSum":0}]
     * humanResult : [{"newCustomerNum":"0","newMemberNum":0}]
     * saleResult : [{"timeCardSaleNum":0,"RBuyMoney":0,"numCardSaleNum":0}]
     * code : 0
     * countResult : [{"MComeCount":0,"cComeCount":"0"}]
     */

    private String message;
    private int code;
    private List<LessonResultBean> lessonResult;
    private List<HumanResultBean> humanResult;
    private List<SaleResultBean> saleResult;
    private List<CountResultBean> countResult;

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

    public List<LessonResultBean> getLessonResult() {
        return lessonResult;
    }

    public void setLessonResult(List<LessonResultBean> lessonResult) {
        this.lessonResult = lessonResult;
    }

    public List<HumanResultBean> getHumanResult() {
        return humanResult;
    }

    public void setHumanResult(List<HumanResultBean> humanResult) {
        this.humanResult = humanResult;
    }

    public List<SaleResultBean> getSaleResult() {
        return saleResult;
    }

    public void setSaleResult(List<SaleResultBean> saleResult) {
        this.saleResult = saleResult;
    }

    public List<CountResultBean> getCountResult() {
        return countResult;
    }

    public void setCountResult(List<CountResultBean> countResult) {
        this.countResult = countResult;
    }

    public static class LessonResultBean {
        /**
         * LeLessonSum : 4076
         * LessonSum : 0
         */

        private int LeLessonSum;
        private int LessonSum;

        public int getLeLessonSum() {
            return LeLessonSum;
        }

        public void setLeLessonSum(int LeLessonSum) {
            this.LeLessonSum = LeLessonSum;
        }

        public int getLessonSum() {
            return LessonSum;
        }

        public void setLessonSum(int LessonSum) {
            this.LessonSum = LessonSum;
        }
    }

    public static class HumanResultBean {
        /**
         * newCustomerNum : 0
         * newMemberNum : 0
         */

        private String newCustomerNum;
        private int newMemberNum;

        public String getNewCustomerNum() {
            return newCustomerNum;
        }

        public void setNewCustomerNum(String newCustomerNum) {
            this.newCustomerNum = newCustomerNum;
        }

        public int getNewMemberNum() {
            return newMemberNum;
        }

        public void setNewMemberNum(int newMemberNum) {
            this.newMemberNum = newMemberNum;
        }
    }

    public static class SaleResultBean {
        /**
         * timeCardSaleNum : 0
         * RBuyMoney : 0
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

    public static class CountResultBean {
        /**
         * MComeCount : 0
         * cComeCount : 0
         */

        private int MComeCount;
        private String cComeCount;

        public int getMComeCount() {
            return MComeCount;
        }

        public void setMComeCount(int MComeCount) {
            this.MComeCount = MComeCount;
        }

        public String getCComeCount() {
            return cComeCount;
        }

        public void setCComeCount(String cComeCount) {
            this.cComeCount = cComeCount;
        }
    }
}
