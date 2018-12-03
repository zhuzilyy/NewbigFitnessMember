package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/9/22.
 */

public class MonthAddSumReportBean {


    /**
     * message :
     * result : [{"mComeCount":129,"cComeCount":0,"day":"2017-08-01"},{"mComeCount":48,"cComeCount":0,"day":"2017-08-02"},{"mComeCount":63,"cComeCount":0,"day":"2017-08-03"},{"mComeCount":109,"cComeCount":0,"day":"2017-08-04"},{"mComeCount":76,"cComeCount":0,"day":"2017-08-05"},{"mComeCount":75,"cComeCount":0,"day":"2017-08-06"},{"mComeCount":128,"cComeCount":0,"day":"2017-08-07"},{"mComeCount":105,"cComeCount":0,"day":"2017-08-08"},{"mComeCount":73,"cComeCount":0,"day":"2017-08-09"},{"mComeCount":110,"cComeCount":0,"day":"2017-08-10"},{"mComeCount":100,"cComeCount":0,"day":"2017-08-11"},{"mComeCount":109,"cComeCount":0,"day":"2017-08-12"},{"mComeCount":151,"cComeCount":0,"day":"2017-08-13"},{"mComeCount":201,"cComeCount":0,"day":"2017-08-14"},{"mComeCount":244,"cComeCount":0,"day":"2017-08-15"},{"mComeCount":220,"cComeCount":0,"day":"2017-08-16"},{"mComeCount":175,"cComeCount":0,"day":"2017-08-17"},{"mComeCount":167,"cComeCount":0,"day":"2017-08-18"},{"mComeCount":219,"cComeCount":0,"day":"2017-08-19"},{"mComeCount":286,"cComeCount":0,"day":"2017-08-20"},{"mComeCount":293,"cComeCount":0,"day":"2017-08-21"},{"mComeCount":285,"cComeCount":0,"day":"2017-08-22"},{"mComeCount":284,"cComeCount":0,"day":"2017-08-23"},{"mComeCount":265,"cComeCount":0,"day":"2017-08-24"},{"mComeCount":235,"cComeCount":0,"day":"2017-08-25"},{"mComeCount":274,"cComeCount":0,"day":"2017-08-26"},{"mComeCount":233,"cComeCount":0,"day":"2017-08-27"},{"mComeCount":441,"cComeCount":0,"day":"2017-08-28"},{"mComeCount":556,"cComeCount":0,"day":"2017-08-29"},{"mComeCount":536,"cComeCount":0,"day":"2017-08-30"},{"mComeCount":523,"cComeCount":0,"day":"2017-08-31"}]
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
         * mComeCount : 129
         * cComeCount : 0
         * day : 2017-08-01
         */

        private int mComeCount;
        private int cComeCount;
        private String day;

        public int getMComeCount() {
            return mComeCount;
        }

        public void setMComeCount(int mComeCount) {
            this.mComeCount = mComeCount;
        }

        public int getCComeCount() {
            return cComeCount;
        }

        public void setCComeCount(int cComeCount) {
            this.cComeCount = cComeCount;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }
    }
}
