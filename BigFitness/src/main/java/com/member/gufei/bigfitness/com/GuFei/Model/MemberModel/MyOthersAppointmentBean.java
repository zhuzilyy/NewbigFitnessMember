package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by LiuShengYuan on 2018/9/25.
 */

public class MyOthersAppointmentBean {

    /**
     * Ret : 0
     * Msg :
     * rows : [{"AppointmentResultName":"","AppointmentTypeName":"体测预约","UserName":"郭小晏","EndTime":"12:00","AppointmentId":217,"StartTime":"2018/09/25 11:00","PersonType":0,"OfficeName":"教练经理"}]
     */

    private int Ret;
    private String Msg;
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

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * AppointmentResultName :
         * AppointmentTypeName : 体测预约
         * UserName : 郭小晏
         * EndTime : 12:00
         * AppointmentId : 217
         * StartTime : 2018/09/25 11:00
         * PersonType : 0
         * OfficeName : 教练经理
         * IsExpire : 0
         */

        private String AppointmentResultName;
        private String AppointmentTypeName;
        private String UserName;
        private String EndTime;
        private int AppointmentId;
        private String StartTime;
        private int PersonType;
        private String OfficeName;
        private int IsExpire;

        public String getAppointmentResultName() {
            return AppointmentResultName;
        }

        public void setAppointmentResultName(String AppointmentResultName) {
            this.AppointmentResultName = AppointmentResultName;
        }

        public String getAppointmentTypeName() {
            return AppointmentTypeName;
        }

        public void setAppointmentTypeName(String AppointmentTypeName) {
            this.AppointmentTypeName = AppointmentTypeName;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public int getAppointmentId() {
            return AppointmentId;
        }

        public void setAppointmentId(int AppointmentId) {
            this.AppointmentId = AppointmentId;
        }

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(String StartTime) {
            this.StartTime = StartTime;
        }

        public int getPersonType() {
            return PersonType;
        }

        public void setPersonType(int PersonType) {
            this.PersonType = PersonType;
        }

        public String getOfficeName() {
            return OfficeName;
        }

        public void setOfficeName(String OfficeName) {
            this.OfficeName = OfficeName;
        }

        public int getIsExpire() {
            return IsExpire;
        }

        public void setIsExpire(int isExpire) {
            IsExpire = isExpire;
        }
    }
}
