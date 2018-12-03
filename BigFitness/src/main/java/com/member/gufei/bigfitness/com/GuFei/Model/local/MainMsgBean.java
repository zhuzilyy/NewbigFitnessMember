package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/4/26
 */

public class MainMsgBean {


    /**
     * message :
     * result : [{"AppointmentTypeName":"续费预约","HeaderURL":"","UID":26,"AppointUserName":"果冻","CreateTime":"05/31 15:08:09","Content":"预约开始时间: 2017/05/31\n\t\t17:00:00\n预约结束时间: 2017/05/31\n\t\t18:00:00\n预约结果: ","AppointmentId":11,"AppType":"1"},{"AppointmentTypeName":"体测预约","HeaderURL":"","UID":72,"AppointUserName":"小白3","CreateTime":"06/05 12:01:53","Content":"预约开始时间: 2017/06/06\n\t\t12:00:00\n预约结束时间: 2017/06/06\n\t\t14:00:00\n预约结果: ","AppointmentId":38,"AppType":"1"},{"AppointmentTypeName":"体测预约","HeaderURL":"","UID":20,"AppointUserName":"费欧娜","CreateTime":"06/05 13:52:06","Content":"预约开始时间: 2017/06/06\n\t\t12:00:00\n预约结束时间: 2017/06/06\n\t\t14:00:00\n预约结果: ","AppointmentId":39,"AppType":"1"},{"AppointmentTypeName":"体测预约","HeaderURL":"","UID":18,"AppointUserName":"scott","CreateTime":"06/05 13:57:43","Content":"预约开始时间: 2017/06/04\n\t\t12:00:00\n预约结束时间: 2017/06/04\n\t\t14:00:00\n预约结果: ","AppointmentId":40,"AppType":"1"},{"AppointmentTypeName":"体测预约","HeaderURL":"","UID":50,"AppointUserName":"西蓝花","CreateTime":"06/06 17:49:02","Content":"预约开始时间: 2017/06/06\n\t\t20:00:00\n预约结束时间: 2017/06/06\n\t\t21:00:00\n预约结果: ","AppointmentId":43,"AppType":"1"},{"AppointmentTypeName":"普通预约","HeaderURL":"","UID":100,"AppointUserName":"小白24","CreateTime":"06/09 01:29:50","Content":"预约开始时间: 2017/06/15\n\t\t12:00:00\n预约结束时间: 2017/06/15\n\t\t13:05:00\n预约结果: ","AppointmentId":55,"AppType":"1"},{"AppointmentTypeName":"普通预约","HeaderURL":"","UID":18,"AppointUserName":"scott","CreateTime":"06/10 16:49:46","Content":"预约开始时间: 2017/06/12\n\t\t14:00:00\n预约结束时间: 2017/06/12\n\t\t15:00:00\n预约结果: ","AppointmentId":58,"AppType":"1"},{"AppointmentTypeName":"普通预约","HeaderURL":"uploadFiles/uploadImgs/20170531/e8c13a29397e49b2b4cfb22087ae975f.png","UID":19,"AppointUserName":"乔巴","CreateTime":"07/04 15:10:59","Content":"预约开始时间: 2017/07/05\n\t\t03:00:00\n预约结束时间: 2017/07/05\n\t\t04:00:00\n预约结果: ","AppointmentId":75,"AppType":"1"},{"AppointmentTypeName":"普通预约","HeaderURL":"","UID":28,"AppointUserName":"小白","CreateTime":"05/31 10:41:30","Content":"预约开始时间: 2017/06/02 12:30:00\n预约结束时间:\n\t\t2017/06/02 12:55:00\n预约结果: ","AppointmentId":15,"AppType":"3"},{"AppointmentTypeName":"办卡预约","HeaderURL":"","UID":58,"AppointUserName":null,"CreateTime":"05/31 15:10:34","Content":"预约开始时间: 2017/05/31 18:00:00\n预约结束时间:\n\t\t2017/05/31 19:00:00\n预约结果: ","AppointmentId":24,"AppType":"3"},{"AppointmentTypeName":"办卡预约","HeaderURL":"","UID":46,"AppointUserName":"小E","CreateTime":"05/31 16:21:12","Content":"预约开始时间: 2017/05/31 17:00:00\n预约结束时间:\n\t\t2017/05/31 17:30:00\n预约结果: ","AppointmentId":26,"AppType":"3"},{"AppointmentTypeName":"普通预约","HeaderURL":"","UID":95,"AppointUserName":"小白1","CreateTime":"06/05 11:58:35","Content":"预约开始时间: 2017/06/06 12:00:00\n预约结束时间:\n\t\t2017/06/06 14:00:00\n预约结果: ","AppointmentId":41,"AppType":"3"},{"AppointmentTypeName":"普通预约","HeaderURL":"","UID":105,"AppointUserName":"小可爱","CreateTime":"06/05 15:41:27","Content":"预约开始时间: 2017/06/06 12:00:00\n预约结束时间:\n\t\t2017/06/06 14:00:00\n预约结果: ","AppointmentId":42,"AppType":"3"},{"AppointmentTypeName":"普通预约","HeaderURL":"","UID":131,"AppointUserName":"萧峰","CreateTime":"06/08 16:46:19","Content":"预约开始时间: 2017/06/08 15:00:00\n预约结束时间:\n\t\t2017/06/08 16:00:00\n预约结果: ","AppointmentId":47,"AppType":"3"},{"AppointmentTypeName":"普通预约","HeaderURL":"","UID":131,"AppointUserName":"萧峰","CreateTime":"06/08 17:36:05","Content":"预约开始时间: 2017/06/08 17:00:00\n预约结束时间:\n\t\t2017/06/08 18:00:00\n预约结果: ","AppointmentId":49,"AppType":"3"},{"AppointmentTypeName":"办卡预约","HeaderURL":"","UID":131,"AppointUserName":"萧峰","CreateTime":"06/08 20:02:21","Content":"预约开始时间: 2017/06/08 14:00:00\n预约结束时间:\n\t\t2017/06/08 15:00:00\n预约结果: ","AppointmentId":50,"AppType":"3"},{"AppointmentTypeName":"普通预约","HeaderURL":"","UID":122,"AppointUserName":"小白24","CreateTime":"06/08 23:11:26","Content":"预约开始时间: 2017/06/09 13:00:00\n预约结束时间:\n\t\t2017/06/09 14:00:00\n预约结果: ","AppointmentId":51,"AppType":"3"},{"AppointmentTypeName":"办卡预约","HeaderURL":"","UID":122,"AppointUserName":"小白24","CreateTime":"06/08 23:13:24","Content":"预约开始时间: 2017/06/09 14:00:00\n预约结束时间:\n\t\t2017/06/09 15:00:00\n预约结果: ","AppointmentId":52,"AppType":"3"},{"AppointmentTypeName":"办卡预约","HeaderURL":"","UID":136,"AppointUserName":"李莹test","CreateTime":"06/20 18:29:19","Content":"预约开始时间: 2017/06/21 10:28:00\n预约结束时间:\n\t\t2017/06/21 11:28:00\n预约结果: ","AppointmentId":56,"AppType":"3"},{"AppointmentTypeName":"办卡预约","HeaderURL":"","UID":137,"AppointUserName":"白白","CreateTime":"07/18 10:21:23","Content":"预约开始时间: 2017/07/18 13:21:00\n预约结束时间:\n\t\t2017/07/18 14:21:00\n预约结果: ","AppointmentId":62,"AppType":"3"}]
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
         * AppointmentTypeName : 续费预约
         * HeaderURL :
         * UID : 26
         * AppointUserName : 果冻
         * CreateTime : 05/31 15:08:09
         * Content : 预约开始时间: 2017/05/31
         17:00:00
         预约结束时间: 2017/05/31
         18:00:00
         预约结果:
         * AppointmentId : 11
         * AppType : 1
         */

        private String AppointmentTypeName;
        private String HeaderURL;
        private int UID;
        private String AppointUserName;
        private String CreateTime;
        private String Content;
        private int AppointmentId;
        private String AppType;

        public String getAppointmentTypeName() {
            return AppointmentTypeName;
        }

        public void setAppointmentTypeName(String AppointmentTypeName) {
            this.AppointmentTypeName = AppointmentTypeName;
        }

        public String getHeaderURL() {
            return HeaderURL;
        }

        public void setHeaderURL(String HeaderURL) {
            this.HeaderURL = HeaderURL;
        }

        public int getUID() {
            return UID;
        }

        public void setUID(int UID) {
            this.UID = UID;
        }

        public String getAppointUserName() {
            return AppointUserName;
        }

        public void setAppointUserName(String AppointUserName) {
            this.AppointUserName = AppointUserName;
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

        public int getAppointmentId() {
            return AppointmentId;
        }

        public void setAppointmentId(int AppointmentId) {
            this.AppointmentId = AppointmentId;
        }

        public String getAppType() {
            return AppType;
        }

        public void setAppType(String AppType) {
            this.AppType = AppType;
        }
    }
}
