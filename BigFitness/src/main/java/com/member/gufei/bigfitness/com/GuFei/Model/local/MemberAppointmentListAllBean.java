package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */

public class MemberAppointmentListAllBean {

    /**
     * message :
     * result : [{"AppointmentTypeName":"操课预约","CreateUserId":3,"AppointmentResultName":"","AppointmentId":25,"createName":"test2","MemberId":61,"AppointmentTypeId":null,"CreateTime":"2017-06-06","EndTime":"2017-06-07 18:00","StartTime":"2017-06-07 15:15","Content":"","ClassName":"c","appType":"3","MemberName":"客户采集测试18","AppointmentResultId":""}]
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
         * AppointmentTypeName : 操课预约
         * CreateUserId : 3
         * AppointmentResultName :
         * AppointmentId : 25
         * createName : test2
         * MemberId : 61
         * AppointmentTypeId : null
         * CreateTime : 2017-06-06
         * EndTime : 2017-06-07 18:00
         * StartTime : 2017-06-07 15:15
         * Content :
         * ClassName : c
         * appType : 3
         * MemberName : 客户采集测试18
         * AppointmentResultId :
         */

        private String AppointmentTypeName;
        private int CreateUserId;
        private String AppointmentResultName;
        private int AppointmentId;
        private String createName;
        private int MemberId;
        private Object AppointmentTypeId;
        private String CreateTime;
        private String EndTime;
        private String StartTime;
        private String Content;
        private String ClassName;
        private String appType;
        private String MemberName;
        private String AppointmentResultId;

        public String getAppointmentTypeName() {
            return AppointmentTypeName;
        }

        public void setAppointmentTypeName(String AppointmentTypeName) {
            this.AppointmentTypeName = AppointmentTypeName;
        }

        public int getCreateUserId() {
            return CreateUserId;
        }

        public void setCreateUserId(int CreateUserId) {
            this.CreateUserId = CreateUserId;
        }

        public String getAppointmentResultName() {
            return AppointmentResultName;
        }

        public void setAppointmentResultName(String AppointmentResultName) {
            this.AppointmentResultName = AppointmentResultName;
        }

        public int getAppointmentId() {
            return AppointmentId;
        }

        public void setAppointmentId(int AppointmentId) {
            this.AppointmentId = AppointmentId;
        }

        public String getCreateName() {
            return createName;
        }

        public void setCreateName(String createName) {
            this.createName = createName;
        }

        public int getMemberId() {
            return MemberId;
        }

        public void setMemberId(int MemberId) {
            this.MemberId = MemberId;
        }

        public Object getAppointmentTypeId() {
            return AppointmentTypeId;
        }

        public void setAppointmentTypeId(Object AppointmentTypeId) {
            this.AppointmentTypeId = AppointmentTypeId;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(String StartTime) {
            this.StartTime = StartTime;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
        }

        public String getClassName() {
            return ClassName;
        }

        public void setClassName(String ClassName) {
            this.ClassName = ClassName;
        }

        public String getAppType() {
            return appType;
        }

        public void setAppType(String appType) {
            this.appType = appType;
        }

        public String getMemberName() {
            return MemberName;
        }

        public void setMemberName(String MemberName) {
            this.MemberName = MemberName;
        }

        public String getAppointmentResultId() {
            return AppointmentResultId;
        }

        public void setAppointmentResultId(String AppointmentResultId) {
            this.AppointmentResultId = AppointmentResultId;
        }
    }
}
