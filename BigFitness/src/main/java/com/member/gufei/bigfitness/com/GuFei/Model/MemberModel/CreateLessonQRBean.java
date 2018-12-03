package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

/**
 * Created by GuFei on 2018/6/13.
 */

public class CreateLessonQRBean {


    /**
     * Ret : 0
     * Msg : 操作成功!
     * rows : {"AppointmentId":435,"APPUserId":15,"LessonId":30,"TwoDimensionCode":"7a7ef23c9d99483b94c40853809f8d79","TwoDimensionCodeCreateTime":"2018-06-13 14:04:46","TwoDimensionCodeExpireTime":"2018-06-13 14:05:46"}
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
         * AppointmentId : 435
         * APPUserId : 15
         * LessonId : 30
         * TwoDimensionCode : 7a7ef23c9d99483b94c40853809f8d79
         * TwoDimensionCodeCreateTime : 2018-06-13 14:04:46
         * TwoDimensionCodeExpireTime : 2018-06-13 14:05:46
         */

        private int AppointmentId;
        private int APPUserId;
        private int LessonId;
        private String TwoDimensionCode;
        private String TwoDimensionCodeCreateTime;
        private String TwoDimensionCodeExpireTime;

        public int getAppointmentId() {
            return AppointmentId;
        }

        public void setAppointmentId(int AppointmentId) {
            this.AppointmentId = AppointmentId;
        }

        public int getAPPUserId() {
            return APPUserId;
        }

        public void setAPPUserId(int APPUserId) {
            this.APPUserId = APPUserId;
        }

        public int getLessonId() {
            return LessonId;
        }

        public void setLessonId(int LessonId) {
            this.LessonId = LessonId;
        }

        public String getTwoDimensionCode() {
            return TwoDimensionCode;
        }

        public void setTwoDimensionCode(String TwoDimensionCode) {
            this.TwoDimensionCode = TwoDimensionCode;
        }

        public String getTwoDimensionCodeCreateTime() {
            return TwoDimensionCodeCreateTime;
        }

        public void setTwoDimensionCodeCreateTime(String TwoDimensionCodeCreateTime) {
            this.TwoDimensionCodeCreateTime = TwoDimensionCodeCreateTime;
        }

        public String getTwoDimensionCodeExpireTime() {
            return TwoDimensionCodeExpireTime;
        }

        public void setTwoDimensionCodeExpireTime(String TwoDimensionCodeExpireTime) {
            this.TwoDimensionCodeExpireTime = TwoDimensionCodeExpireTime;
        }
    }
}
