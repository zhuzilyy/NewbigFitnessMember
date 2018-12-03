package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */

public class AppointmentListByDateForOrderBean {

    /**
     * message :
     * result : [{"content":"","title":"会员：小公举 上课预约","EndTime":"2017/06/08 16:00:00","StartTime":"2017/06/08 16:40:00","AppointmentId":45,"appType":"2","AppointmentResultId":"","MemberId":27},{"content":"","title":"客户：萧峰 普通预约","EndTime":"2017/06/08 18:00:00","StartTime":"2017/06/08 17:00:00","AppointmentId":49,"appType":"3","AppointmentResultId":"","MemberId":131},{"content":"","title":"会员：乔巴 体测预约","EndTime":"2017/06/08 18:00:00","StartTime":"2017/06/08 17:00:00","AppointmentId":49,"appType":"1","AppointmentResultId":"21","MemberId":19},{"content":"","title":"会员：测试啊！ 上课预约","EndTime":"2017/06/08 20:00:00","StartTime":"2017/06/08 20:43:00","AppointmentId":47,"appType":"2","AppointmentResultId":"","MemberId":86},{"content":"","title":"会员：scott 上课预约","EndTime":"2017/06/08 23:00:00","StartTime":"2017/06/08 23:30:00","AppointmentId":48,"appType":"2","AppointmentResultId":"","MemberId":18},{"content":"会籍预约会员续费预约！！！！！第二次！！发射！！！！修改","title":"会员：乔巴 续费预约","EndTime":"2017/06/09 02:00:00","StartTime":"2017/06/09 01:05:00","AppointmentId":51,"appType":"1","AppointmentResultId":"","MemberId":19},{"content":"","title":"会员：小公举 上课预约","EndTime":"2017/06/09 04:00:00","StartTime":"2017/06/09 04:27:00","AppointmentId":55,"appType":"2","AppointmentResultId":"19","MemberId":27},{"content":"","title":"会员：小公举 上课预约","EndTime":"2017/06/09 04:00:00","StartTime":"2017/06/09 04:27:00","AppointmentId":54,"appType":"2","AppointmentResultId":"","MemberId":27},{"content":"会籍预约会员测试","title":"会员：scott 普通预约","EndTime":"2017/06/09 12:00:00","StartTime":"2017/06/09 12:00:00","AppointmentId":50,"appType":"1","AppointmentResultId":"","MemberId":18},{"content":"123","title":"客户：小白24 普通预约","EndTime":"2017/06/09 14:00:00","StartTime":"2017/06/09 13:00:00","AppointmentId":51,"appType":"3","AppointmentResultId":"","MemberId":122}]
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
         * content :
         * title : 会员：小公举 上课预约
         * EndTime : 2017/06/08 16:00:00
         * StartTime : 2017/06/08 16:40:00
         * AppointmentId : 45
         * appType : 2
         * AppointmentResultId :
         * MemberId : 27
         * HeaderURL:""
         * AppointmentResultName:""
         */

        private String content;
        private String title;
        private String EndTime;
        private String StartTime;
        private int AppointmentId;
        private String appType;
        private String AppointmentResultId;
        private String HeaderURL;
        private int MemberType;

        public int getMemberType() {
            return MemberType;
        }

        public void setMemberType(int memberType) {
            MemberType = memberType;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String createTime) {
            CreateTime = createTime;
        }

        private String CreateTime;
        private String AppointmentResultName;

        public String getCreateUserId() {
            return CreateUserId;
        }

        public void setCreateUserId(String createUserId) {
            CreateUserId = createUserId;
        }

        private String CreateUserId;

        public String getAppointmentResultName() {
            return AppointmentResultName;
        }

        public void setAppointmentResultName(String appointmentResultName) {
            AppointmentResultName = appointmentResultName;
        }

        private int MemberId;

        public String getHeaderURL() {
            return HeaderURL;
        }

        public void setHeaderURL(String headerURL) {
            HeaderURL = headerURL;
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
