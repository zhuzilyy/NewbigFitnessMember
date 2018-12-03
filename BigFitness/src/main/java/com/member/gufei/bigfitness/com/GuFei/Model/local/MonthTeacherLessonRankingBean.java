package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/9/25.
 */

public class MonthTeacherLessonRankingBean {


    /**
     * message :
     * result : [{"HeaderURL":"","LessonTeacherId":261,"UserName":"姚佳","LessonSum":1,"Sex":0}]
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
         * HeaderURL :
         * LessonTeacherId : 261
         * UserName : 姚佳
         * LessonSum : 1
         * Sex : 0
         */

        private String HeaderURL;
        private int LessonTeacherId;
        private String UserName;
        private int LessonSum;
        private int Sex;

        public String getHeaderURL() {
            return HeaderURL;
        }

        public void setHeaderURL(String HeaderURL) {
            this.HeaderURL = HeaderURL;
        }

        public int getLessonTeacherId() {
            return LessonTeacherId;
        }

        public void setLessonTeacherId(int LessonTeacherId) {
            this.LessonTeacherId = LessonTeacherId;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public int getLessonSum() {
            return LessonSum;
        }

        public void setLessonSum(int LessonSum) {
            this.LessonSum = LessonSum;
        }

        public int getSex() {
            return Sex;
        }

        public void setSex(int Sex) {
            this.Sex = Sex;
        }
    }
}
