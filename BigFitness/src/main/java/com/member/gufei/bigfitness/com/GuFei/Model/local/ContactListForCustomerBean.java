package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/6/6
 */

public class ContactListForCustomerBean {


    /**
     * message :
     * result : [{"AppointmentTypeName":"推荐次卡","CreateTime1":"05月27","CreateTime2":"09:55","CreateUserId":1,"sId":58,"AppointmentId":"58","CustomerName":"jhhgh","HeaderURL":"uploadFiles/uploadImgs/20170526/ec7262bb857945f1946cd909073c2ba8.png","AppointmentTypeId":"2","imageList":[{"createtime":"2017-04-07 14:24:22","clubid":1,"createuserid":1,"imageurl":"uploadFiles/uploadImgs/20170407/9e24356c2df0462eb70d9206003ce5c7.jpg","imageid":12,"contactid":58},{"createtime":"2017-04-07 14:24:22","clubid":1,"createuserid":1,"imageurl":"uploadFiles/uploadImgs/20170407/942c52bfd9784cd19be6a89566fc70d4.jpg","imageid":13,"contactid":58}],"OrderCreateTime":"2017-05-27 09:55:45","CustomerId":49,"sType":"2","userName":"admi","ContactContent":"预约开始时间: 2017/05/18 17:25\n预约结束时间: 2017/05/18 19:35\n预约结果: 成功办理次卡\n备 注: 萨达萨达萨达萨达","AppointmentResultId":"3"},{"AppointmentTypeName":"推荐次卡","CreateTime1":"05月27","CreateTime2":"09:49","CreateUserId":1,"sId":57,"AppointmentId":"57","CustomerName":"jhhgh","HeaderURL":"uploadFiles/uploadImgs/20170526/ec7262bb857945f1946cd909073c2ba8.png","AppointmentTypeId":"2","imageList":[{"createtime":"2017-04-07 14:20:53","clubid":1,"createuserid":1,"imageurl":"uploadFiles/uploadImgs/20170407/4de0f1e4707f4038b3ab88622a988b69.jpg","imageid":10,"contactid":57},{"createtime":"2017-04-07 14:20:55","clubid":1,"createuserid":1,"imageurl":"uploadFiles/uploadImgs/20170407/ce11897a3f2c4949ae311acffa2cd994.jpg","imageid":11,"contactid":57}],"OrderCreateTime":"2017-05-27 09:49:31","CustomerId":49,"sType":"2","userName":"admi","ContactContent":"预约开始时间: 2017/05/16 07:05\n预约结束时间: 2017/05/16 10:50\n预约结果: 未办次卡\n备 注: 预约测试啊","AppointmentResultId":"4"}]
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
         * CreateTime1 : 05月27
         * CreateTime2 : 09:55
         * CreateUserId : 1
         * sId : 58
         * AppointmentId : 58
         * CustomerName : jhhgh
         * HeaderURL : uploadFiles/uploadImgs/20170526/ec7262bb857945f1946cd909073c2ba8.png
         * AppointmentTypeId : 2
         * imageList : [{"createtime":"2017-04-07 14:24:22","clubid":1,"createuserid":1,"imageurl":"uploadFiles/uploadImgs/20170407/9e24356c2df0462eb70d9206003ce5c7.jpg","imageid":12,"contactid":58},{"createtime":"2017-04-07 14:24:22","clubid":1,"createuserid":1,"imageurl":"uploadFiles/uploadImgs/20170407/942c52bfd9784cd19be6a89566fc70d4.jpg","imageid":13,"contactid":58}]
         * OrderCreateTime : 2017-05-27 09:55:45
         * CustomerId : 49
         * sType : 2
         * userName : admi
         * ContactContent : 预约开始时间: 2017/05/18 17:25
         预约结束时间: 2017/05/18 19:35
         预约结果: 成功办理次卡
         备 注: 萨达萨达萨达萨达
         * AppointmentResultId : 3
         */

        private String AppointmentTypeName;
        private String CreateTime1;
        private String CreateTime2;
        private int CreateUserId;
        private int sId;
        private String AppointmentId;
        private String CustomerName;
        private String HeaderURL;
        private String AppointmentTypeId;
        private String OrderCreateTime;
        private int CustomerId;
        private String sType;
        private String userName;
        private String ContactContent;
        private String AppointmentResultId;
        private List<ImageListBean> imageList;

        public String getAppointmentTypeName() {
            return AppointmentTypeName;
        }

        public void setAppointmentTypeName(String AppointmentTypeName) {
            this.AppointmentTypeName = AppointmentTypeName;
        }

        public String getCreateTime1() {
            return CreateTime1;
        }

        public void setCreateTime1(String CreateTime1) {
            this.CreateTime1 = CreateTime1;
        }

        public String getCreateTime2() {
            return CreateTime2;
        }

        public void setCreateTime2(String CreateTime2) {
            this.CreateTime2 = CreateTime2;
        }

        public int getCreateUserId() {
            return CreateUserId;
        }

        public void setCreateUserId(int CreateUserId) {
            this.CreateUserId = CreateUserId;
        }

        public int getSId() {
            return sId;
        }

        public void setSId(int sId) {
            this.sId = sId;
        }

        public String getAppointmentId() {
            return AppointmentId;
        }

        public void setAppointmentId(String AppointmentId) {
            this.AppointmentId = AppointmentId;
        }

        public String getCustomerName() {
            return CustomerName;
        }

        public void setCustomerName(String CustomerName) {
            this.CustomerName = CustomerName;
        }

        public String getHeaderURL() {
            return HeaderURL;
        }

        public void setHeaderURL(String HeaderURL) {
            this.HeaderURL = HeaderURL;
        }

        public String getAppointmentTypeId() {
            return AppointmentTypeId;
        }

        public void setAppointmentTypeId(String AppointmentTypeId) {
            this.AppointmentTypeId = AppointmentTypeId;
        }

        public String getOrderCreateTime() {
            return OrderCreateTime;
        }

        public void setOrderCreateTime(String OrderCreateTime) {
            this.OrderCreateTime = OrderCreateTime;
        }

        public int getCustomerId() {
            return CustomerId;
        }

        public void setCustomerId(int CustomerId) {
            this.CustomerId = CustomerId;
        }

        public String getSType() {
            return sType;
        }

        public void setSType(String sType) {
            this.sType = sType;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getContactContent() {
            return ContactContent;
        }

        public void setContactContent(String ContactContent) {
            this.ContactContent = ContactContent;
        }

        public String getAppointmentResultId() {
            return AppointmentResultId;
        }

        public void setAppointmentResultId(String AppointmentResultId) {
            this.AppointmentResultId = AppointmentResultId;
        }

        public List<ImageListBean> getImageList() {
            return imageList;
        }

        public void setImageList(List<ImageListBean> imageList) {
            this.imageList = imageList;
        }

        public static class ImageListBean {
            /**
             * createtime : 2017-04-07 14:24:22
             * clubid : 1
             * createuserid : 1
             * imageurl : uploadFiles/uploadImgs/20170407/9e24356c2df0462eb70d9206003ce5c7.jpg
             * imageid : 12
             * contactid : 58
             */

            private String createtime;
            private int clubid;
            private int createuserid;
            private String imageurl;
            private int imageid;
            private int contactid;

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public int getClubid() {
                return clubid;
            }

            public void setClubid(int clubid) {
                this.clubid = clubid;
            }

            public int getCreateuserid() {
                return createuserid;
            }

            public void setCreateuserid(int createuserid) {
                this.createuserid = createuserid;
            }

            public String getImageurl() {
                return imageurl;
            }

            public void setImageurl(String imageurl) {
                this.imageurl = imageurl;
            }

            public int getImageid() {
                return imageid;
            }

            public void setImageid(int imageid) {
                this.imageid = imageid;
            }

            public int getContactid() {
                return contactid;
            }

            public void setContactid(int contactid) {
                this.contactid = contactid;
            }
        }
    }
}
