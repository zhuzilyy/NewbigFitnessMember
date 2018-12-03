package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/6/17
 */

public class CompleteLessonListBean {


    /**
     * message :
     * result : [{"TeacherName":"王大军","LessonTime":"2017/05/31 11:00","LessonName":"增肌","LessonType":"私教课","AppointmentId":10},{"TeacherName":"王晓峰","LessonTime":"2017/05/31 12:00","LessonName":"增肌","LessonType":"私教课","AppointmentId":11},{"TeacherName":"王晓峰","LessonTime":"2017/05/31 11:00","LessonName":"减肥","LessonType":"私教课","AppointmentId":12},{"TeacherName":"王晓峰","LessonTime":"2017/05/31 01:00","LessonName":"增肌","LessonType":"私教课","AppointmentId":13},{"TeacherName":"王大军","LessonTime":"2017/05/31 14:10","LessonName":"减肥","LessonType":"私教课","AppointmentId":14},{"TeacherName":"邓玲","LessonTime":"2017/06/01 13:01","LessonName":"增肌","LessonType":"私教课","AppointmentId":15},{"TeacherName":"王大军","LessonTime":"2017/05/31 15:00","LessonName":"减肥","LessonType":"私教课","AppointmentId":16},{"TeacherName":"王大军","LessonTime":"2017/05/31 15:20","LessonName":"增肌","LessonType":"私教课","AppointmentId":17},{"TeacherName":"王大军","LessonTime":"2017/05/31 15:00","LessonName":"减肥","LessonType":"私教课","AppointmentId":18},{"TeacherName":"邓玲","LessonTime":"2017/05/31 04:00","LessonName":"增肌","LessonType":"私教课","AppointmentId":19}]
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
         * TeacherName : 王大军
         * LessonTime : 2017/05/31 11:00
         * LessonName : 增肌
         * LessonType : 私教课
         * AppointmentId : 10
         */

        private String TeacherName;
        private String LessonTime;
        private String LessonName;
        private String LessonType;
        private int AppointmentId;

        public String getTeacherName() {
            return TeacherName;
        }

        public void setTeacherName(String TeacherName) {
            this.TeacherName = TeacherName;
        }

        public String getLessonTime() {
            return LessonTime;
        }

        public void setLessonTime(String LessonTime) {
            this.LessonTime = LessonTime;
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

        public int getAppointmentId() {
            return AppointmentId;
        }

        public void setAppointmentId(int AppointmentId) {
            this.AppointmentId = AppointmentId;
        }
    }
}
