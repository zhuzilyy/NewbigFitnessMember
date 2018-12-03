package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/6/16
 */

public class LessonListForDropBean {


    /**
     * message :
     * result : [{"saleteachernames":"孙健,王大军,王晓峰","createtime":"2017-05-31 10:13:04","lessonname":"增肌","isclose":0,"classteachernames":"孙健,王大军,王晓峰","lessonid":6,"clubid":1,"lessontype":0,"createuserid":9,"imageurl":""},{"saleteachernames":"王晓峰,王大军","createtime":"2017-05-31 10:14:13","lessonname":"减肥","isclose":0,"classteachernames":"王大军","lessonid":7,"clubid":1,"lessontype":0,"createuserid":9,"imageurl":"uploadFiles/uploadImgs/20170531/aa7755055e0b4a55876ee316d24d19f5.png"},{"saleteachernames":"王晓峰,王大军","createtime":"2017-06-02 08:55:37","lessonname":"测试变更教练","isclose":0,"classteachernames":"孙健,教练1,教练2,王晓峰","lessonid":10,"clubid":1,"lessontype":0,"createuserid":9,"imageurl":""},{"saleteachernames":"乔巴","createtime":"2017-06-07 15:01:19","lessonname":"DAJIA","isclose":0,"classteachernames":"王大军","lessonid":12,"clubid":1,"lessontype":0,"createuserid":9,"imageurl":""},{"saleteachernames":"孙健,教练1,教练2,梁红,王大军,王晓峰","createtime":"2017-06-14 15:31:14","lessonname":"测试","isclose":0,"classteachernames":"孙健,教练1,教练2,梁红,王大军,王晓峰","lessonid":11,"clubid":1,"lessontype":0,"createuserid":9,"imageurl":"uploadFiles/uploadImgs/20170605/a7015652b78e4094b1d34f3cc3bae593.png"}]
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
         * saleteachernames : 孙健,王大军,王晓峰
         * createtime : 2017-05-31 10:13:04
         * lessonname : 增肌
         * isclose : 0
         * classteachernames : 孙健,王大军,王晓峰
         * lessonid : 6
         * clubid : 1
         * lessontype : 0
         * createuserid : 9
         * imageurl :
         */

        private String saleteachernames;
        private String createtime;
        private String lessonname;
        private int isclose;
        private String classteachernames;
        private int lessonid;
        private int clubid;
        private int lessontype;
        private int createuserid;
        private String imageurl;

        public String getSaleteachernames() {
            return saleteachernames;
        }

        public void setSaleteachernames(String saleteachernames) {
            this.saleteachernames = saleteachernames;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getLessonname() {
            return lessonname;
        }

        public void setLessonname(String lessonname) {
            this.lessonname = lessonname;
        }

        public int getIsclose() {
            return isclose;
        }

        public void setIsclose(int isclose) {
            this.isclose = isclose;
        }

        public String getClassteachernames() {
            return classteachernames;
        }

        public void setClassteachernames(String classteachernames) {
            this.classteachernames = classteachernames;
        }

        public int getLessonid() {
            return lessonid;
        }

        public void setLessonid(int lessonid) {
            this.lessonid = lessonid;
        }

        public int getClubid() {
            return clubid;
        }

        public void setClubid(int clubid) {
            this.clubid = clubid;
        }

        public int getLessontype() {
            return lessontype;
        }

        public void setLessontype(int lessontype) {
            this.lessontype = lessontype;
        }

        public int getCreateuserid() {
            return createuserid;
        }

        public void setCreateuserid(int createuserid) {
            this.createuserid = createuserid;
        }

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }
    }
}
