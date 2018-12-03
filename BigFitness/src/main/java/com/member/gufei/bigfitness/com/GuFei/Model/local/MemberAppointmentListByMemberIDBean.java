package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */

public class MemberAppointmentListByMemberIDBean {


    /**
     * message :
     * result : [{"AppointmentTypeName":"续费预约","CreateUserId":13,"AppointmentResultName":"","AppointStartTime":"2017-07-30 15:30","sId":93,"AppointmentId":"93","MemberId":129,"HeaderURL":"uploadFiles/uploadImgs/20170704/f28197ffb1194604854f0684f3bb76e4.png","AppointmentTypeId":"13","imageList":[{"createtime":"2017-07-04 14:41:35","clubid":1,"createuserid":13,"imageurl":"uploadFiles/uploadImgs/20170704/7f398d194b7d46c08c7fbc074f278ff3.jpg","imageid":40,"contactid":93}],"OrderCreateTime":"2017-07-30 15:30:21","CustomerId":169,"sType":"2","CreateTime":"2017-07-30 15:30","userName":"王敬白","AppointEndTime":"2017-07-30 15:59","ContactContent":"预约开始时间: 2017/07/30 15:30\n预约结束时间: 2017/07/30 15:59\n预约结果: \n备 注: ","MemberName":"德芙","AppType":"4","AppointmentResultId":""},{"AppointmentTypeName":"","CreateUserId":13,"AppointmentResultName":"","AppointStartTime":"2017-07-29 17:36","sId":98,"AppointmentId":"98","MemberId":129,"HeaderURL":"uploadFiles/uploadImgs/20170704/f28197ffb1194604854f0684f3bb76e4.png","AppointmentTypeId":"1","imageList":[{"createtime":"2017-07-04 16:30:08","clubid":1,"createuserid":10,"imageurl":"uploadFiles/uploadImgs/20170704/5ef47115c18f4c1baa99d2a763223c0d.jpg","imageid":45,"contactid":98}],"OrderCreateTime":"2017-07-29 17:37:11","CustomerId":169,"sType":"2","CreateTime":"2017-07-29 17:37","userName":"王敬白","AppointEndTime":"2017-07-29 17:55","ContactContent":"","MemberName":"德芙","AppType":"1","AppointmentResultId":""},{"AppointmentTypeName":"","CreateUserId":13,"AppointmentResultName":"","AppointStartTime":"","sId":129,"AppointmentId":"0","MemberId":129,"HeaderURL":"uploadFiles/uploadImgs/20170704/f28197ffb1194604854f0684f3bb76e4.png","AppointmentTypeId":"","imageList":[],"OrderCreateTime":"2017-07-29 11:27:31","CustomerId":169,"sType":"1","CreateTime":"2017-07-29 11:27","userName":"王敬白","AppointEndTime":"","ContactContent":"她","MemberName":"德芙","AppType":"3","AppointmentResultId":""},{"AppointmentTypeName":"","CreateUserId":13,"AppointmentResultName":"","AppointStartTime":"","sId":134,"AppointmentId":"0","MemberId":129,"HeaderURL":"uploadFiles/uploadImgs/20170704/f28197ffb1194604854f0684f3bb76e4.png","AppointmentTypeId":"","imageList":[],"OrderCreateTime":"2017-07-29 11:27:22","CustomerId":169,"sType":"1","CreateTime":"2017-07-29 11:27","userName":"王敬白","AppointEndTime":"","ContactContent":"yguhijok","MemberName":"德芙","AppType":"","AppointmentResultId":""},{"AppointmentTypeName":"续费预约","CreateUserId":13,"AppointmentResultName":"","AppointStartTime":"2017-07-29 16:26","sId":82,"AppointmentId":"82","MemberId":129,"HeaderURL":"uploadFiles/uploadImgs/20170704/f28197ffb1194604854f0684f3bb76e4.png","AppointmentTypeId":"13","imageList":[{"createtime":"2017-06-09 02:40:17","clubid":1,"createuserid":13,"imageurl":"uploadFiles/uploadImgs/20170609/f0345a0013984fa18497f07b935e9680.jpg","imageid":27,"contactid":82}],"OrderCreateTime":"2017-07-29 11:26:59","CustomerId":169,"sType":"2","CreateTime":"2017-07-29 11:26","userName":"王敬白","AppointEndTime":"2017-07-29 16:28","ContactContent":"预约开始时间: 2017/07/29 16:26\n预约结束时间: 2017/07/29 16:28\n预约结果: \n备 注: ","MemberName":"德芙","AppType":"4","AppointmentResultId":""},{"AppointmentTypeName":"","CreateUserId":13,"AppointmentResultName":"","AppointStartTime":"","sId":113,"AppointmentId":"0","MemberId":129,"HeaderURL":"uploadFiles/uploadImgs/20170704/f28197ffb1194604854f0684f3bb76e4.png","AppointmentTypeId":"","imageList":[],"OrderCreateTime":"2017-07-24 10:33:14","CustomerId":169,"sType":"1","CreateTime":"2017-07-24 10:33","userName":"王敬白","AppointEndTime":"","ContactContent":"哦哦哦","MemberName":"德芙","AppType":"3","AppointmentResultId":""}]
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
         * CreateUserId : 13
         * AppointmentResultName :
         * AppointStartTime : 2017-07-30 15:30
         * sId : 93
         * AppointmentId : 93
         * MemberId : 129
         * HeaderURL : uploadFiles/uploadImgs/20170704/f28197ffb1194604854f0684f3bb76e4.png
         * AppointmentTypeId : 13
         * imageList : [{"createtime":"2017-07-04 14:41:35","clubid":1,"createuserid":13,"imageurl":"uploadFiles/uploadImgs/20170704/7f398d194b7d46c08c7fbc074f278ff3.jpg","imageid":40,"contactid":93}]
         * OrderCreateTime : 2017-07-30 15:30:21
         * CustomerId : 169
         * sType : 2
         * CreateTime : 2017-07-30 15:30
         * userName : 王敬白
         * AppointEndTime : 2017-07-30 15:59
         * ContactContent : 预约开始时间: 2017/07/30 15:30
         预约结束时间: 2017/07/30 15:59
         预约结果:
         备 注:
         * MemberName : 德芙
         * AppType : 4
         * AppointmentResultId :
         */

        private String AppointmentTypeName;
        private int CreateUserId;
        private String AppointmentResultName;
        private String AppointStartTime;
        private int sId;
        private String AppointmentId;
        private int MemberId;
        private String HeaderURL;
        private String AppointmentTypeId;
        private String OrderCreateTime;
        private int CustomerId;
        private String sType;
        private String CreateTime;
        private String userName;
        private String AppointEndTime;
        private String ContactContent;
        private String MemberName;
        private String AppType;
        private String AppointmentResultId;
        private List<ImageListBean> imageList;

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

        public String getAppointStartTime() {
            return AppointStartTime;
        }

        public void setAppointStartTime(String AppointStartTime) {
            this.AppointStartTime = AppointStartTime;
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

        public int getMemberId() {
            return MemberId;
        }

        public void setMemberId(int MemberId) {
            this.MemberId = MemberId;
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

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getAppointEndTime() {
            return AppointEndTime;
        }

        public void setAppointEndTime(String AppointEndTime) {
            this.AppointEndTime = AppointEndTime;
        }

        public String getContactContent() {
            return ContactContent;
        }

        public void setContactContent(String ContactContent) {
            this.ContactContent = ContactContent;
        }

        public String getMemberName() {
            return MemberName;
        }

        public void setMemberName(String MemberName) {
            this.MemberName = MemberName;
        }

        public String getAppType() {
            return AppType;
        }

        public void setAppType(String AppType) {
            this.AppType = AppType;
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
             * createtime : 2017-07-04 14:41:35
             * clubid : 1
             * createuserid : 13
             * imageurl : uploadFiles/uploadImgs/20170704/7f398d194b7d46c08c7fbc074f278ff3.jpg
             * imageid : 40
             * contactid : 93
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
