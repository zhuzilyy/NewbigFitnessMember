package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/6/8.
 */

public class ClubTeacherListBean {

    /**
     * Ret : 0
     * Msg : 操作成功!
     * TotalPage : 6
     * rows : [{"Speciality":"","EvaluateStar":3.3,"Sex":1,"HeaderURL":"","TeacherId":138,"TeacherName":"测试138","Age":26},{"Speciality":"","EvaluateStar":0,"Sex":1,"HeaderURL":"","TeacherId":139,"TeacherName":"测试139","Age":34},{"Speciality":"","EvaluateStar":0,"Sex":1,"HeaderURL":"","TeacherId":140,"TeacherName":"测试140","Age":40},{"Speciality":"","EvaluateStar":0,"Sex":0,"HeaderURL":"","TeacherId":141,"TeacherName":"测试141","Age":25},{"Speciality":"","EvaluateStar":0,"Sex":0,"HeaderURL":"","TeacherId":142,"TeacherName":"测试142","Age":37},{"Speciality":"","EvaluateStar":0,"Sex":1,"HeaderURL":"","TeacherId":143,"TeacherName":"测试143","Age":23},{"Speciality":"","EvaluateStar":0,"Sex":0,"HeaderURL":"","TeacherId":144,"TeacherName":"测试144","Age":30},{"Speciality":"","EvaluateStar":0,"Sex":0,"HeaderURL":"","TeacherId":145,"TeacherName":"测试145","Age":33},{"Speciality":"","EvaluateStar":0,"Sex":0,"HeaderURL":"","TeacherId":146,"TeacherName":"测试146","Age":28}]
     */

    private int Ret;
    private String Msg;
    private int TotalPage;
    private List<RowsBean> rows;

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

    public int getTotalPage() {
        return TotalPage;
    }

    public void setTotalPage(int TotalPage) {
        this.TotalPage = TotalPage;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * Speciality :
         * EvaluateStar : 3.3
         * Sex : 1
         * HeaderURL :
         * TeacherId : 138
         * TeacherName : 测试138
         * Age : 26
         */

        private String Speciality;
        private double EvaluateStar;
        private int Sex;
        private String HeaderURL;
        private int TeacherId;
        private String TeacherName;
        private int Age;

        public String getSpeciality() {
            return Speciality;
        }

        public void setSpeciality(String Speciality) {
            this.Speciality = Speciality;
        }

        public double getEvaluateStar() {
            return EvaluateStar;
        }

        public void setEvaluateStar(double EvaluateStar) {
            this.EvaluateStar = EvaluateStar;
        }

        public int getSex() {
            return Sex;
        }

        public void setSex(int Sex) {
            this.Sex = Sex;
        }

        public String getHeaderURL() {
            return HeaderURL;
        }

        public void setHeaderURL(String HeaderURL) {
            this.HeaderURL = HeaderURL;
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
    }
}
