package com.member.gufei.bigfitness;

public class
ResBean {
    /**
     * Ret : 0
     * Msg :
     * rows : {"LessonTime":"18:00~19:00","FreeLessonId":1175,"LessonTimelong":60,"ImageURL":"111.jpg,222.jpg","MaxPersonCount":50,"AvgStarLevel":0,"TotalEvalCount":0,"FLessonName":"高温瑜伽","FLessonId":171,"NowPersonCount":0,"Introduce":"","AppointmentId":0,"IsAppointment":0,"TeacherName":"张学友"}
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
         * LessonTime : 18:00~19:00
         * FreeLessonId : 1175
         * LessonTimelong : 60
         * ImageURL : 111.jpg,222.jpg
         * MaxPersonCount : 50
         * AvgStarLevel : 0
         * TotalEvalCount : 0
         * FLessonName : 高温瑜伽
         * FLessonId : 171
         * NowPersonCount : 0
         * Introduce :
         * AppointmentId : 0
         * IsAppointment : 0
         * TeacherName : 张学友
         */

        private String LessonTime;
        private int FreeLessonId;
        private int LessonTimelong;
        private String ImageURL;
        private int MaxPersonCount;
        private int AvgStarLevel;
        private int TotalEvalCount;
        private String FLessonName;
        private int FLessonId;
        private int NowPersonCount;
        private String Introduce;
        private int AppointmentId;
        private int IsAppointment;
        private String TeacherName;

        public String getLessonTime() {
            return LessonTime;
        }

        public void setLessonTime(String LessonTime) {
            this.LessonTime = LessonTime;
        }

        public int getFreeLessonId() {
            return FreeLessonId;
        }

        public void setFreeLessonId(int FreeLessonId) {
            this.FreeLessonId = FreeLessonId;
        }

        public int getLessonTimelong() {
            return LessonTimelong;
        }

        public void setLessonTimelong(int LessonTimelong) {
            this.LessonTimelong = LessonTimelong;
        }

        public String getImageURL() {
            return ImageURL;
        }

        public void setImageURL(String ImageURL) {
            this.ImageURL = ImageURL;
        }

        public int getMaxPersonCount() {
            return MaxPersonCount;
        }

        public void setMaxPersonCount(int MaxPersonCount) {
            this.MaxPersonCount = MaxPersonCount;
        }

        public int getAvgStarLevel() {
            return AvgStarLevel;
        }

        public void setAvgStarLevel(int AvgStarLevel) {
            this.AvgStarLevel = AvgStarLevel;
        }

        public int getTotalEvalCount() {
            return TotalEvalCount;
        }

        public void setTotalEvalCount(int TotalEvalCount) {
            this.TotalEvalCount = TotalEvalCount;
        }

        public String getFLessonName() {
            return FLessonName;
        }

        public void setFLessonName(String FLessonName) {
            this.FLessonName = FLessonName;
        }

        public int getFLessonId() {
            return FLessonId;
        }

        public void setFLessonId(int FLessonId) {
            this.FLessonId = FLessonId;
        }

        public int getNowPersonCount() {
            return NowPersonCount;
        }

        public void setNowPersonCount(int NowPersonCount) {
            this.NowPersonCount = NowPersonCount;
        }

        public String getIntroduce() {
            return Introduce;
        }

        public void setIntroduce(String Introduce) {
            this.Introduce = Introduce;
        }

        public int getAppointmentId() {
            return AppointmentId;
        }

        public void setAppointmentId(int AppointmentId) {
            this.AppointmentId = AppointmentId;
        }

        public int getIsAppointment() {
            return IsAppointment;
        }

        public void setIsAppointment(int IsAppointment) {
            this.IsAppointment = IsAppointment;
        }

        public String getTeacherName() {
            return TeacherName;
        }

        public void setTeacherName(String TeacherName) {
            this.TeacherName = TeacherName;
        }
    }
}
