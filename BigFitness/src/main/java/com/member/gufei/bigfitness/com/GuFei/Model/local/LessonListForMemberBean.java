package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/6/18.
 */

public class LessonListForMemberBean {


    /**
     * message :
     * result : [{"Status":"有效","LessonName":"减脂","LessonType":"普通私教课","Id":31042,"RemainCount":"30/30节"}]
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
         * Status : 有效
         * LessonName : 减脂
         * LessonType : 普通私教课
         * Id : 31042
         * RemainCount : 30/30节
         */

        private String Status;
        private String LessonName;
        private String LessonType;
        private int Id;
        private String RemainCount;

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getLessonName() {
            return LessonName;
        }

        public void setLessonName(String LessonName) {
            this.LessonName = LessonName;
        }

        public String getLessonType() {
            return LessonType;
        }

        public void setLessonType(String LessonType) {
            this.LessonType = LessonType;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getRemainCount() {
            return RemainCount;
        }

        public void setRemainCount(String RemainCount) {
            this.RemainCount = RemainCount;
        }
    }
}
