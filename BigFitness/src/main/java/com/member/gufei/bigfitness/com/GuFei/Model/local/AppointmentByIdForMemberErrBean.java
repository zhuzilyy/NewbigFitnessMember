package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/6/24.
 */

public class AppointmentByIdForMemberErrBean {


    /**
     * message :
     * result : {"contactList":"","trainPlanList":[],"appointInfo":{"AppointmentTypeName":"上课预约","sTime":"13:00","LessonId":17,"CreateUserId":36,"IsSignIn":0,"eTime":"13:05","AppointmentResultName":"","AppointmentId":103,"TipStartTime":"","ttime":"","createName":"梁红","bgTime":"2017-06-22","MemberId":1685,"AppointmentTypeId":11,"TipInterval":"5","CreateTime":"2017-06-22","Content":"","editType":1,"MemberName":"动画片2","AppointmentResultId":""}}
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
         * contactList :
         * trainPlanList : []
         * appointInfo : {"AppointmentTypeName":"上课预约","sTime":"13:00","LessonId":17,"CreateUserId":36,"IsSignIn":0,"eTime":"13:05","AppointmentResultName":"","AppointmentId":103,"TipStartTime":"","ttime":"","createName":"梁红","bgTime":"2017-06-22","MemberId":1685,"AppointmentTypeId":11,"TipInterval":"5","CreateTime":"2017-06-22","Content":"","editType":1,"MemberName":"动画片2","AppointmentResultId":""}
         */

        private String contactList;
        private AppointInfoBean appointInfo;
        private List<?> trainPlanList;

        public String getContactList() {
            return contactList;
        }

        public void setContactList(String contactList) {
            this.contactList = contactList;
        }

        public AppointInfoBean getAppointInfo() {
            return appointInfo;
        }

        public void setAppointInfo(AppointInfoBean appointInfo) {
            this.appointInfo = appointInfo;
        }

        public List<?> getTrainPlanList() {
            return trainPlanList;
        }

        public void setTrainPlanList(List<?> trainPlanList) {
            this.trainPlanList = trainPlanList;
        }

        public static class AppointInfoBean {
            /**
             * AppointmentTypeName : 上课预约
             * sTime : 13:00
             * LessonId : 17
             * CreateUserId : 36
             * IsSignIn : 0
             * eTime : 13:05
             * AppointmentResultName :
             * AppointmentId : 103
             * TipStartTime :
             * ttime :
             * createName : 梁红
             * bgTime : 2017-06-22
             * MemberId : 1685
             * AppointmentTypeId : 11
             * TipInterval : 5
             * CreateTime : 2017-06-22
             * Content :
             * editType : 1
             * MemberName : 动画片2
             * AppointmentResultId :
             */

            private String AppointmentTypeName;
            private String sTime;
            private int LessonId;
            private int CreateUserId;
            private int IsSignIn;
            private String eTime;
            private String AppointmentResultName;
            private int AppointmentId;
            private String TipStartTime;
            private String ttime;
            private String createName;
            private String bgTime;
            private int MemberId;
            private int AppointmentTypeId;
            private String TipInterval;
            private String CreateTime;
            private String Content;
            private int editType;
            private String MemberName;
            private String AppointmentResultId;

            public String getAppointmentTypeName() {
                return AppointmentTypeName;
            }

            public void setAppointmentTypeName(String AppointmentTypeName) {
                this.AppointmentTypeName = AppointmentTypeName;
            }

            public String getSTime() {
                return sTime;
            }

            public void setSTime(String sTime) {
                this.sTime = sTime;
            }

            public int getLessonId() {
                return LessonId;
            }

            public void setLessonId(int LessonId) {
                this.LessonId = LessonId;
            }

            public int getCreateUserId() {
                return CreateUserId;
            }

            public void setCreateUserId(int CreateUserId) {
                this.CreateUserId = CreateUserId;
            }

            public int getIsSignIn() {
                return IsSignIn;
            }

            public void setIsSignIn(int IsSignIn) {
                this.IsSignIn = IsSignIn;
            }

            public String getETime() {
                return eTime;
            }

            public void setETime(String eTime) {
                this.eTime = eTime;
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

            public String getTipStartTime() {
                return TipStartTime;
            }

            public void setTipStartTime(String TipStartTime) {
                this.TipStartTime = TipStartTime;
            }

            public String getTtime() {
                return ttime;
            }

            public void setTtime(String ttime) {
                this.ttime = ttime;
            }

            public String getCreateName() {
                return createName;
            }

            public void setCreateName(String createName) {
                this.createName = createName;
            }

            public String getBgTime() {
                return bgTime;
            }

            public void setBgTime(String bgTime) {
                this.bgTime = bgTime;
            }

            public int getMemberId() {
                return MemberId;
            }

            public void setMemberId(int MemberId) {
                this.MemberId = MemberId;
            }

            public int getAppointmentTypeId() {
                return AppointmentTypeId;
            }

            public void setAppointmentTypeId(int AppointmentTypeId) {
                this.AppointmentTypeId = AppointmentTypeId;
            }

            public String getTipInterval() {
                return TipInterval;
            }

            public void setTipInterval(String TipInterval) {
                this.TipInterval = TipInterval;
            }

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
            }

            public String getContent() {
                return Content;
            }

            public void setContent(String Content) {
                this.Content = Content;
            }

            public int getEditType() {
                return editType;
            }

            public void setEditType(int editType) {
                this.editType = editType;
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
}
