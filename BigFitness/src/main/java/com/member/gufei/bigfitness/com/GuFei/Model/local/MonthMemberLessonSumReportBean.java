package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/9/22.
 */

public class MonthMemberLessonSumReportBean {


    /**
     * message :
     * result : [{"LeLessonSum":0,"day":"2017-08-01","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-02","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-03","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-04","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-05","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-06","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-07","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-08","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-09","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-10","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-11","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-12","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-13","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-14","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-15","LessonSum":0},{"LeLessonSum":95,"day":"2017-08-16","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-17","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-18","LessonSum":0},{"LeLessonSum":285,"day":"2017-08-19","LessonSum":0},{"LeLessonSum":228,"day":"2017-08-20","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-21","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-22","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-23","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-24","LessonSum":0},{"LeLessonSum":247,"day":"2017-08-25","LessonSum":0},{"LeLessonSum":513,"day":"2017-08-26","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-27","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-28","LessonSum":0},{"LeLessonSum":152,"day":"2017-08-29","LessonSum":0},{"LeLessonSum":0,"day":"2017-08-30","LessonSum":0},{"LeLessonSum":130,"day":"2017-08-31","LessonSum":0}]
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
         * LeLessonSum : 0
         * day : 2017-08-01
         * LessonSum : 0
         */

        private int LeLessonSum;
        private String day;
        private int LessonSum;

        public int getLeLessonSum() {
            return LeLessonSum;
        }

        public void setLeLessonSum(int LeLessonSum) {
            this.LeLessonSum = LeLessonSum;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public int getLessonSum() {
            return LessonSum;
        }

        public void setLessonSum(int LessonSum) {
            this.LessonSum = LessonSum;
        }
    }
}
