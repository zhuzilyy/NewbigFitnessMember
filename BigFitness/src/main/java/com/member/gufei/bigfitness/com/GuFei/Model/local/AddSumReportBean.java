package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */

public class AddSumReportBean {


    /**
     * message :
     * result : [{"newCustomerNum":"0","newMemberNum":0}]
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
}
