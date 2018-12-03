package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/4/11.
 */

public class ClubTeacherDetailBean {

    /**
     * Ret : 0
     * Msg : 操作成功!
     * rows : {"Speciality":"","resList":[{"ResURL":"111","ResType":1}],"Sex":1,"LessonList":[{"LessonId":25,"LessonName":"240私教"}],"AvgStarLevel":2.2,"Weight":125.5,"TotalEvalCount":3,"HeaderURL":"","Height":173.5,"TeacherId":137,"TeacherName":"测试137","Age":38,"Certificate":""}
     */

    private int Ret;
    private String Msg;
    private RowsBean rows;

    public int getRet() {
        return Ret;
    }

    public void setRet(int Ret) {
        this.Ret = Ret;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public RowsBean getRows() {
        return rows;
    }

    public void setRows(RowsBean rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * Speciality :
         * resList : [{"ResURL":"111","ResType":1}]
         * Sex : 1
         * LessonList : [{"LessonId":25,"LessonName":"240私教"}]
         * AvgStarLevel : 2.2
         * Weight : 125.5
         * Introduce :""
         * TotalEvalCount : 3.0
         * HeaderURL :
         * Height : 173.5
         * TeacherId : 137
         * TeacherName : 测试137
         * Age : 38
         * Certificate :
         */

        private String Speciality;
        private int Sex;
        private double AvgStarLevel;
        private int Weight;
        private int TotalEvalCount;
        private String HeaderURL;
        private String Introduce;
        private int Height;
        private int TeacherId;
        private String TeacherName;
        private int Age;
        private String Certificate;
        private List<ResListBean> resList;
        private List<LessonListBean> LessonList;

        public String getSpeciality() {
            return Speciality;
        }

        public void setSpeciality(String Speciality) {
            this.Speciality = Speciality;
        }

        public String getIntroduce() {
            return Introduce;
        }

        public void setIntroduce(String introduce) {
            Introduce = introduce;
        }

        public int getSex() {
            return Sex;
        }

        public void setSex(int Sex) {
            this.Sex = Sex;
        }

        public double getAvgStarLevel() {
            return AvgStarLevel;
        }

        public void setAvgStarLevel(double AvgStarLevel) {
            this.AvgStarLevel = AvgStarLevel;
        }

        public double getWeight() {
            return Weight;
        }

        public void setWeight(int Weight) {
            this.Weight = Weight;
        }

        public double getTotalEvalCount() {
            return TotalEvalCount;
        }

        public void setTotalEvalCount(int TotalEvalCount) {
            this.TotalEvalCount = TotalEvalCount;
        }

        public String getHeaderURL() {
            return HeaderURL;
        }

        public void setHeaderURL(String HeaderURL) {
            this.HeaderURL = HeaderURL;
        }

        public int getHeight() {
            return Height;
        }

        public void setHeight(int Height) {
            this.Height = Height;
        }

        public int getTeacherId() {
            return TeacherId;
        }

        public void setTeacherId(int TeacherId) {
            this.TeacherId = TeacherId;
        }

        public String getTeacherName() {
            return TeacherName;
        }

        public void setTeacherName(String TeacherName) {
            this.TeacherName = TeacherName;
        }

        public int getAge() {
            return Age;
        }

        public void setAge(int Age) {
            this.Age = Age;
        }

        public String getCertificate() {
            return Certificate;
        }

        public void setCertificate(String Certificate) {
            this.Certificate = Certificate;
        }

        public List<ResListBean> getResList() {
            return resList;
        }

        public void setResList(List<ResListBean> resList) {
            this.resList = resList;
        }

        public List<LessonListBean> getLessonList() {
            return LessonList;
        }

        public void setLessonList(List<LessonListBean> LessonList) {
            this.LessonList = LessonList;
        }

        public static class ResListBean {
            /**
             * ResURL : 111
             * ResType : 1
             */

            private String ResURL;
            private int ResType;

            public String getResURL() {
                return ResURL;
            }

            public void setResURL(String ResURL) {
                this.ResURL = ResURL;
            }

            public int getResType() {
                return ResType;
            }

            public void setResType(int ResType) {
                this.ResType = ResType;
            }
        }

        public static class LessonListBean {
            /**
             * LessonId : 25
             * LessonName : 240私教
             */

            private int LessonId;
            private String LessonName;

            public int getLessonId() {
                return LessonId;
            }

            public void setLessonId(int LessonId) {
                this.LessonId = LessonId;
            }

            public String getLessonName() {
                return LessonName;
            }

            public void setLessonName(String LessonName) {
                this.LessonName = LessonName;
            }
        }
    }
}
