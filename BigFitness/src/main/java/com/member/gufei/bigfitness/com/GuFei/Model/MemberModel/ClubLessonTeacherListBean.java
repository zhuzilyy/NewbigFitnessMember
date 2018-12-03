package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/4/11.
 */

public class ClubLessonTeacherListBean {


    /**
     * Ret : 0
     * rows : [{"Speciality":"","EvaluateStar":2,"Sex":1,"HeaderURL":"","TeacherId":137,"TeacherName":"测试137","Age":38},{"Speciality":"","EvaluateStar":0,"Sex":1,"HeaderURL":"","TeacherId":214,"TeacherName":"米豪杰","Age":1},{"Speciality":"","EvaluateStar":0,"Sex":1,"HeaderURL":"","TeacherId":500,"TeacherName":"田玉银","Age":1},{"Speciality":"","EvaluateStar":0,"Sex":1,"HeaderURL":"","TeacherId":233,"TeacherName":"王十","Age":1},{"Speciality":"","EvaluateStar":0,"Sex":0,"HeaderURL":"","TeacherId":261,"TeacherName":"姚佳","Age":1},{"Speciality":"","EvaluateStar":0,"Sex":1,"HeaderURL":"","TeacherId":457,"TeacherName":"吴浩诚","Age":17},{"Speciality":"","EvaluateStar":0,"Sex":1,"HeaderURL":"","TeacherId":469,"TeacherName":"卢霖","Age":22},{"Speciality":"","EvaluateStar":0,"Sex":1,"HeaderURL":"","TeacherId":204,"TeacherName":"刘东东","Age":1},{"Speciality":"","EvaluateStar":0,"Sex":1,"HeaderURL":"","TeacherId":456,"TeacherName":"谭士强","Age":23},{"Speciality":"","EvaluateStar":3.3,"Sex":1,"HeaderURL":"","TeacherId":138,"TeacherName":"测试138","Age":26}]
     */

    private int Ret;
    private List<RowsBean> rows;

    public int getRet() {
        return Ret;
    }

    public void setRet(int Ret) {
        this.Ret = Ret;
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
         * EvaluateStar : 2
         * Sex : 1
         * HeaderURL :
         * TeacherId : 137
         * TeacherName : 测试137
         * Age : 38
         */

        private String Speciality;
        private float EvaluateStar;
        private int Sex;
        private String HeaderURL;
        private int TeacherId;
        private String TeacherName;
        private int Age;
        private boolean Selected;

        public String getSpeciality() {
            return Speciality;
        }

        public void setSpeciality(String Speciality) {
            this.Speciality = Speciality;
        }

        public float getEvaluateStar() {
            return EvaluateStar;
        }

        public void setEvaluateStar(float EvaluateStar) {
            this.EvaluateStar = EvaluateStar;
        }

        public int getSex() {
            return Sex;
        }

        public void setSex(int Sex) {
            this.Sex = Sex;
        }

        public boolean isSelected() {
            return Selected;
        }

        public void setSelected(boolean selected) {
            Selected = selected;
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
