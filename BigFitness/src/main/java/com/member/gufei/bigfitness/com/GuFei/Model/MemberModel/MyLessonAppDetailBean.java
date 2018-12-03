package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/6/15.
 */

public class MyLessonAppDetailBean {


    /**
     * Ret : 0
     * Msg :
     * rows : {"EndTime":"21:00","Position":[{"ActionName":["斜板卷腹(4组*10)"],"PositionName":"胸部"},{"ActionName":[],"PositionName":"腹部"}],"AppointmentOwner":0,"StartTime":"2018/06/18 20:00","AppointmentCata":1,"remark":"","AppointmentStatus":1,"LessonName":"减脂","TeacherName":"王晓峰"}
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
         * ClassStatus
         * EndTime : 21:00
         * Position : [{"ActionName":["斜板卷腹(4组*10)"],"PositionName":"胸部"},{"ActionName":[],"PositionName":"腹部"}]
         * AppointmentOwner : 0
         * StartTime : 2018/06/18 20:00
         * AppointmentCata : 1
         * remark :
         * AppointmentStatus : 1
         * LessonName : 减脂
         * TeacherName : 王晓峰
         *IsExpire :0
         */

        private int ClassStatus;
        private String EndTime;
        private int AppointmentOwner;
        private String StartTime;
        private int AppointmentCata;
        private String remark;
        private int AppointmentStatus;
        private String LessonName;
        private String TeacherName;
        private int IsExpire;
        private List<PositionBean> Position;

        public int getClassStatus() {
            return ClassStatus;
        }

        public void setClassStatus(int classStatus) {
            ClassStatus = classStatus;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public int getAppointmentOwner() {
            return AppointmentOwner;
        }

        public void setAppointmentOwner(int AppointmentOwner) {
            this.AppointmentOwner = AppointmentOwner;
        }

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(String StartTime) {
            this.StartTime = StartTime;
        }

        public int getAppointmentCata() {
            return AppointmentCata;
        }

        public void setAppointmentCata(int AppointmentCata) {
            this.AppointmentCata = AppointmentCata;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getAppointmentStatus() {
            return AppointmentStatus;
        }

        public void setAppointmentStatus(int AppointmentStatus) {
            this.AppointmentStatus = AppointmentStatus;
        }

        public String getLessonName() {
            return LessonName;
        }

        public void setLessonName(String LessonName) {
            this.LessonName = LessonName;
        }

        public String getTeacherName() {
            return TeacherName;
        }

        public void setTeacherName(String TeacherName) {
            this.TeacherName = TeacherName;
        }

        public List<PositionBean> getPosition() {
            return Position;
        }

        public void setPosition(List<PositionBean> Position) {
            this.Position = Position;
        }

        public int getIsExpire() {
            return IsExpire;
        }

        public void setIsExpire(int isExpire) {
            IsExpire = isExpire;
        }

        public static class PositionBean {
            /**
             * ActionName : ["斜板卷腹(4组*10)"]
             * PositionName : 胸部
             */

            private String PositionName;
            private List<String> ActionName;

            public String getPositionName() {
                return PositionName;
            }

            public void setPositionName(String PositionName) {
                this.PositionName = PositionName;
            }

            public List<String> getActionName() {
                return ActionName;
            }

            public void setActionName(List<String> ActionName) {
                this.ActionName = ActionName;
            }
        }
    }
}
