package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/9/20.
 */

public class tDailyMemberLessonSumReportBean {

    /**
     * message :
     * result : [{"LeLessonSum":1679,"LessonSum":0}]
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
         * LeLessonSum : 1679
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
}
