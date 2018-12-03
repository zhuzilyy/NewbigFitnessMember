package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/7/2.
 */

public class AppointmentListByDateBean {


    /**
     * message :
     * reslut : [{"content":"tre","title":"会员：动画片2 上课预约","EndTime":"2017/06/25 03:00:00","StartTime":"2017/06/25 02:59:00","AppointmentId":107,"appType":"2","AppointmentResultId":"","MemberId":1685}]
     * code : 0
     */

    private String message;
    private int code;
    private List<ReslutBean> reslut;

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

    public List<ReslutBean> getReslut() {
        return reslut;
    }

    public void setReslut(List<ReslutBean> reslut) {
        this.reslut = reslut;
    }

    public static class ReslutBean {
        /**
         * content : tre
         * title : 会员：动画片2 上课预约
         * EndTime : 2017/06/25 03:00:00
         * StartTime : 2017/06/25 02:59:00
         * AppointmentId : 107
         * appType : 2
         * AppointmentResultId :
         * MemberId : 1685
         */

        private String content;
        private String title;
        private String EndTime;
        private String StartTime;
        private int AppointmentId;
        private String appType;
        private String AppointmentResultId;


        private int MemberId;
        private int MemberType;

        public int getMemberType() {
            return MemberType;
        }

        public void setMemberType(int memberType) {
            MemberType = memberType;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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

        public int getAppointmentId() {
            return AppointmentId;
        }

        public void setAppointmentId(int AppointmentId) {
            this.AppointmentId = AppointmentId;
        }

        public String getAppType() {
            return appType;
        }

        public void setAppType(String appType) {
            this.appType = appType;
        }

        public String getAppointmentResultId() {
            return AppointmentResultId;
        }

        public void setAppointmentResultId(String AppointmentResultId) {
            this.AppointmentResultId = AppointmentResultId;
        }

        public int getMemberId() {
            return MemberId;
        }

        public void setMemberId(int MemberId) {
            this.MemberId = MemberId;
        }
    }
}
