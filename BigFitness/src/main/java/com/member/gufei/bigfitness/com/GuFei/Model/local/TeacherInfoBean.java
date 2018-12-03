package com.member.gufei.bigfitness.com.GuFei.Model.local;

/**
 * Created by GuFei_lyf on 2017/6/2
 */

public class TeacherInfoBean {


    /**
     * message :
     * result : {"StudentCount":null,"TeacherId":null,"Height":null,"Speciality":null,"StarCount":0,"LessonCount":null,"Weight":null,"Introduce":null,"LessonName":null,"Level":null,"WorkAge":null,"Certificate":null,"HelpCount":null}
     * code : 0
     */

    private String message;
    private ResultBean result;
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean {
        /**
         * StudentCount : null
         * TeacherId : null
         * Height : null
         * Speciality : null
         * StarCount : 0
         * LessonCount : null
         * Weight : null
         * Introduce : null
         * LessonName : null
         * Level : null
         * WorkAge : null
         * Certificate : null
         * HelpCount : null
         */

        private Object StudentCount;
        private Object TeacherId;
        private Object Height;
        private Object Speciality;
        private int StarCount;
        private Object LessonCount;
        private Object Weight;
        private Object Introduce;
        private Object LessonName;
        private Object Level;
        private Object WorkAge;
        private Object Certificate;
        private Object HelpCount;

        public Object getStudentCount() {
            return StudentCount;
        }

        public void setStudentCount(Object StudentCount) {
            this.StudentCount = StudentCount;
        }

        public Object getTeacherId() {
            return TeacherId;
        }

        public void setTeacherId(Object TeacherId) {
            this.TeacherId = TeacherId;
        }

        public Object getHeight() {
            return Height;
        }

        public void setHeight(Object Height) {
            this.Height = Height;
        }

        public Object getSpeciality() {
            return Speciality;
        }

        public void setSpeciality(Object Speciality) {
            this.Speciality = Speciality;
        }

        public int getStarCount() {
            return StarCount;
        }

        public void setStarCount(int StarCount) {
            this.StarCount = StarCount;
        }

        public Object getLessonCount() {
            return LessonCount;
        }

        public void setLessonCount(Object LessonCount) {
            this.LessonCount = LessonCount;
        }

        public Object getWeight() {
            return Weight;
        }

        public void setWeight(Object Weight) {
            this.Weight = Weight;
        }

        public Object getIntroduce() {
            return Introduce;
        }

        public void setIntroduce(Object Introduce) {
            this.Introduce = Introduce;
        }

        public Object getLessonName() {
            return LessonName;
        }

        public void setLessonName(Object LessonName) {
            this.LessonName = LessonName;
        }

        public Object getLevel() {
            return Level;
        }

        public void setLevel(Object Level) {
            this.Level = Level;
        }

        public Object getWorkAge() {
            return WorkAge;
        }

        public void setWorkAge(Object WorkAge) {
            this.WorkAge = WorkAge;
        }

        public Object getCertificate() {
            return Certificate;
        }

        public void setCertificate(Object Certificate) {
            this.Certificate = Certificate;
        }

        public Object getHelpCount() {
            return HelpCount;
        }

        public void setHelpCount(Object HelpCount) {
            this.HelpCount = HelpCount;
        }
    }
}
