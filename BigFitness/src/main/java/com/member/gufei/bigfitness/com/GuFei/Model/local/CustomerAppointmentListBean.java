package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/6/7
 */

public class CustomerAppointmentListBean {


    /**
     * message :
     * result : [{"AppointmentTypeName":"推荐次卡","CreateUserId":1,"AppointmentResultName":"","AppointmentId":61,"CustomerName":"李笨笨","createName":"admi","AppointmentTypeId":2,"CustomerId":52,"CreateTime":"2017/06/05 19:36","EndTime":"2017/06/06 21:36","StartTime":"2017/06/06 19:36","Content":"预约开始时间： 2017/06/06 19:36\n预约结束时间: 2017/06/06 21:36\n备    注: 无备注","AppointmentResultId":""}]
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
         * AppointmentTypeName : 推荐次卡
         * CreateUserId : 1
         * AppointmentResultName :
         * AppointmentId : 61
         * CustomerName : 李笨笨
         * createName : admi
         * AppointmentTypeId : 2
         * CustomerId : 52
         * CreateTime : 2017/06/05 19:36
         * EndTime : 2017/06/06 21:36
         * StartTime : 2017/06/06 19:36
         * Content : 预约开始时间： 2017/06/06 19:36
         预约结束时间: 2017/06/06 21:36
         备    注: 无备注
         * AppointmentResultId :
         */

        private String AppointmentTypeName;
        private int CreateUserId;
        private String AppointmentResultName;
        private int AppointmentId;
        private String CustomerName;
        private String createName;
        private int AppointmentTypeId;
        private int CustomerId;
        private String CreateTime;
        private String EndTime;
        private String StartTime;
        private String Content;
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

        public String getCustomerName() {
            return CustomerName;
        }

        public void setCustomerName(String CustomerName) {
            this.CustomerName = CustomerName;
        }

        public String getCreateName() {
            return createName;
        }

        public void setCreateName(String createName) {
            this.createName = createName;
        }

        public int getAppointmentTypeId() {
            return AppointmentTypeId;
        }

        public void setAppointmentTypeId(int AppointmentTypeId) {
            this.AppointmentTypeId = AppointmentTypeId;
        }

        public int getCustomerId() {
            return CustomerId;
        }

        public void setCustomerId(int CustomerId) {
            this.CustomerId = CustomerId;
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

        public String getAppointmentResultId() {
            return AppointmentResultId;
        }

        public void setAppointmentResultId(String AppointmentResultId) {
            this.AppointmentResultId = AppointmentResultId;
        }
    }
}
