package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */

public class LessonTeacherListForMemberBean {


    /**
     * message : 0
     * result : [{"TeacherName":10,"TeacherId":"王大军"}]
     * code : 0
     */

    private int message;
    private int code;
    private List<ResultBean> result;

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
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
         * TeacherName : 10
         * TeacherId : 王大军
         */

        private int TeacherName;
        private String TeacherId;

        public int getTeacherName() {
            return TeacherName;
        }

        public void setTeacherName(int TeacherName) {
            this.TeacherName = TeacherName;
        }

        public String getTeacherId() {
            return TeacherId;
        }

        public void setTeacherId(String TeacherId) {
            this.TeacherId = TeacherId;
        }
    }
}
