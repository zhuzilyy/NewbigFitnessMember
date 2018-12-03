package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/6/7
 */

public class AppointmentByIdBean {


    /**
     * message :
     * result : {"contactList":[{"contactUserName":"王敬白","AppointmentTypeName":"办卡预约","AppointCreateTime":"2017-06-20","AppointStartTime":"2017-06-21\n\t\t10:28:00","AppointmentResultName":"","AppointmentId":"57","CustomerName":"李莹test","appointUserName":"王敬白","AppointmentTypeId":"8","imageList":[{"createtime":"2017-06-20 19:04:49","clubid":1,"createuserid":13,"imageurl":"uploadFiles/uploadImgs/20170620/2fe87d149a3d42809bd429f1c75f145e.jpg","imageid":65,"contactid":80}],"CreateTime":"2017-06-20 19:04","ContactId":80,"AppointEndTime":"2017-06-21 11:28:00","ContactContent":"这回呢","Content":"哈哈","AppointmentResultId":""},{"contactUserName":"王敬白","AppointmentTypeName":"办卡预约","AppointCreateTime":"2017-06-20","AppointStartTime":"2017-06-21\n\t\t10:28:00","AppointmentResultName":"","AppointmentId":"57","CustomerName":"李莹test","appointUserName":"王敬白","AppointmentTypeId":"8","imageList":[{"createtime":"2017-06-20 19:03:02","clubid":1,"createuserid":13,"imageurl":"uploadFiles/uploadImgs/20170620/222de229394147eabd1df15a3128ad0a.jpg","imageid":60,"contactid":79},{"createtime":"2017-06-20 19:03:02","clubid":1,"createuserid":13,"imageurl":"uploadFiles/uploadImgs/20170620/6b6fa10be45d4ea4aef06e9f5015bd25.jpg","imageid":61,"contactid":79},{"createtime":"2017-06-20 19:03:03","clubid":1,"createuserid":13,"imageurl":"uploadFiles/uploadImgs/20170620/1d42cd6c3ed545de9bccd450c4ec16be.jpg","imageid":62,"contactid":79},{"createtime":"2017-06-20 19:03:03","clubid":1,"createuserid":13,"imageurl":"uploadFiles/uploadImgs/20170620/6b16770d90f24f77bb8af1cb93d6cbde.jpg","imageid":63,"contactid":79},{"createtime":"2017-06-20 19:03:03","clubid":1,"createuserid":13,"imageurl":"uploadFiles/uploadImgs/20170620/a4bbbab80bdf427ebec7a6a9094bc046.jpg","imageid":64,"contactid":79}],"CreateTime":"2017-06-20 19:03","ContactId":79,"AppointEndTime":"2017-06-21 11:28:00","ContactContent":"多","Content":"哈哈","AppointmentResultId":""},{"contactUserName":"王敬白","AppointmentTypeName":"办卡预约","AppointCreateTime":"2017-06-20","AppointStartTime":"2017-06-21\n\t\t10:28:00","AppointmentResultName":"","AppointmentId":"57","CustomerName":"李莹test","appointUserName":"王敬白","AppointmentTypeId":"8","imageList":[{"createtime":"2017-06-20 19:02:37","clubid":1,"createuserid":13,"imageurl":"uploadFiles/uploadImgs/20170620/e3e61626ac844de6ba34a399ed907b29.jpg","imageid":59,"contactid":78}],"CreateTime":"2017-06-20 19:02","ContactId":78,"AppointEndTime":"2017-06-21 11:28:00","ContactContent":"单","Content":"哈哈","AppointmentResultId":""}],"appointInfo":{"AppointmentTypeName":"办卡预约","sTime":"10:28","CreateUserId":13,"eTime":"11:28","AppointmentResultName":"","AppointmentId":57,"TipStartTime":"2017-06-21","ttime":"08:28","createName":"王敬白","CustomerName":"李莹test","bgTime":"2017-06-21","AppointmentTypeId":8,"TipInterval":"5","CustomerId":136,"CreateTime":"2017-06-20","Content":"哈哈","editType":0,"AppointmentResultId":""}}
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
         * contactList : [{"contactUserName":"王敬白","AppointmentTypeName":"办卡预约","AppointCreateTime":"2017-06-20","AppointStartTime":"2017-06-21\n\t\t10:28:00","AppointmentResultName":"","AppointmentId":"57","CustomerName":"李莹test","appointUserName":"王敬白","AppointmentTypeId":"8","imageList":[{"createtime":"2017-06-20 19:04:49","clubid":1,"createuserid":13,"imageurl":"uploadFiles/uploadImgs/20170620/2fe87d149a3d42809bd429f1c75f145e.jpg","imageid":65,"contactid":80}],"CreateTime":"2017-06-20 19:04","ContactId":80,"AppointEndTime":"2017-06-21 11:28:00","ContactContent":"这回呢","Content":"哈哈","AppointmentResultId":""},{"contactUserName":"王敬白","AppointmentTypeName":"办卡预约","AppointCreateTime":"2017-06-20","AppointStartTime":"2017-06-21\n\t\t10:28:00","AppointmentResultName":"","AppointmentId":"57","CustomerName":"李莹test","appointUserName":"王敬白","AppointmentTypeId":"8","imageList":[{"createtime":"2017-06-20 19:03:02","clubid":1,"createuserid":13,"imageurl":"uploadFiles/uploadImgs/20170620/222de229394147eabd1df15a3128ad0a.jpg","imageid":60,"contactid":79},{"createtime":"2017-06-20 19:03:02","clubid":1,"createuserid":13,"imageurl":"uploadFiles/uploadImgs/20170620/6b6fa10be45d4ea4aef06e9f5015bd25.jpg","imageid":61,"contactid":79},{"createtime":"2017-06-20 19:03:03","clubid":1,"createuserid":13,"imageurl":"uploadFiles/uploadImgs/20170620/1d42cd6c3ed545de9bccd450c4ec16be.jpg","imageid":62,"contactid":79},{"createtime":"2017-06-20 19:03:03","clubid":1,"createuserid":13,"imageurl":"uploadFiles/uploadImgs/20170620/6b16770d90f24f77bb8af1cb93d6cbde.jpg","imageid":63,"contactid":79},{"createtime":"2017-06-20 19:03:03","clubid":1,"createuserid":13,"imageurl":"uploadFiles/uploadImgs/20170620/a4bbbab80bdf427ebec7a6a9094bc046.jpg","imageid":64,"contactid":79}],"CreateTime":"2017-06-20 19:03","ContactId":79,"AppointEndTime":"2017-06-21 11:28:00","ContactContent":"多","Content":"哈哈","AppointmentResultId":""},{"contactUserName":"王敬白","AppointmentTypeName":"办卡预约","AppointCreateTime":"2017-06-20","AppointStartTime":"2017-06-21\n\t\t10:28:00","AppointmentResultName":"","AppointmentId":"57","CustomerName":"李莹test","appointUserName":"王敬白","AppointmentTypeId":"8","imageList":[{"createtime":"2017-06-20 19:02:37","clubid":1,"createuserid":13,"imageurl":"uploadFiles/uploadImgs/20170620/e3e61626ac844de6ba34a399ed907b29.jpg","imageid":59,"contactid":78}],"CreateTime":"2017-06-20 19:02","ContactId":78,"AppointEndTime":"2017-06-21 11:28:00","ContactContent":"单","Content":"哈哈","AppointmentResultId":""}]
         * appointInfo : {"AppointmentTypeName":"办卡预约","sTime":"10:28","CreateUserId":13,"eTime":"11:28","AppointmentResultName":"","AppointmentId":57,"TipStartTime":"2017-06-21","ttime":"08:28","createName":"王敬白","CustomerName":"李莹test","bgTime":"2017-06-21","AppointmentTypeId":8,"TipInterval":"5","CustomerId":136,"CreateTime":"2017-06-20","Content":"哈哈","editType":0,"AppointmentResultId":""}
         */

        private AppointInfoBean appointInfo;
        private List<ContactListBean> contactList;

        public AppointInfoBean getAppointInfo() {
            return appointInfo;
        }

        public void setAppointInfo(AppointInfoBean appointInfo) {
            this.appointInfo = appointInfo;
        }

        public List<ContactListBean> getContactList() {
            return contactList;
        }

        public void setContactList(List<ContactListBean> contactList) {
            this.contactList = contactList;
        }

        public static class AppointInfoBean {
            /**
             * AppointmentTypeName : 办卡预约
             * sTime : 10:28
             * CreateUserId : 13
             * eTime : 11:28
             * AppointmentResultName :
             * AppointmentId : 57
             * TipStartTime : 2017-06-21
             * ttime : 08:28
             * createName : 王敬白
             * CustomerName : 李莹test
             * bgTime : 2017-06-21
             * AppointmentTypeId : 8
             * TipInterval : 5
             * CustomerId : 136
             * CreateTime : 2017-06-20
             * Content : 哈哈
             * editType : 0
             * AppointmentResultId :
             */

            private String AppointmentTypeName;
            private String sTime;
            private int CreateUserId;
            private String eTime;
            private String AppointmentResultName;
            private int AppointmentId;
            private String TipStartTime;
            private String ttime;
            private String createName;
            private String CustomerName;
            private String bgTime;
            private int AppointmentTypeId;
            private String TipInterval;

            private int CustomerId;
            private String CreateTime;
            private String Content;
            private int editType;
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

            public int getCreateUserId() {
                return CreateUserId;
            }

            public void setCreateUserId(int CreateUserId) {
                this.CreateUserId = CreateUserId;
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

            public String getCustomerName() {
                return CustomerName;
            }

            public void setCustomerName(String CustomerName) {
                this.CustomerName = CustomerName;
            }

            public String getBgTime() {
                return bgTime;
            }

            public void setBgTime(String bgTime) {
                this.bgTime = bgTime;
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

            public String getAppointmentResultId() {
                return AppointmentResultId;
            }

            public void setAppointmentResultId(String AppointmentResultId) {
                this.AppointmentResultId = AppointmentResultId;
            }

            public String getsTime() {
                return sTime;
            }

            public void setsTime(String sTime) {
                this.sTime = sTime;
            }

            public String geteTime() {
                return eTime;
            }

            public void seteTime(String eTime) {
                this.eTime = eTime;
            }


        }

        public static class ContactListBean {
            /**
             * contactUserName : 王敬白
             * AppointmentTypeName : 办卡预约
             * AppointCreateTime : 2017-06-20
             * AppointStartTime : 2017-06-21
             10:28:00
             * AppointmentResultName :
             * AppointmentId : 57
             * CustomerName : 李莹test
             * appointUserName : 王敬白
             * AppointmentTypeId : 8
             * imageList : [{"createtime":"2017-06-20 19:04:49","clubid":1,"createuserid":13,"imageurl":"uploadFiles/uploadImgs/20170620/2fe87d149a3d42809bd429f1c75f145e.jpg","imageid":65,"contactid":80}]
             * CreateTime : 2017-06-20 19:04
             * ContactId : 80
             * AppointEndTime : 2017-06-21 11:28:00
             * ContactContent : 这回呢
             * Content : 哈哈
             * AppointmentResultId :
             */

            private String contactUserName;
            private String AppointmentTypeName;
            private String AppointCreateTime;
            private String AppointStartTime;
            private String AppointmentResultName;
            private String AppointmentId;
            private String CustomerName;
            private String appointUserName;
            private String AppointmentTypeId;
            private String CreateTime;
            private int ContactId;
            private String AppointEndTime;
            private String ContactContent;
            private String Content;
            private String AppointmentResultId;
            private String HeaderURL;

            private List<ImageListBean> imageList;

            public String getHeaderURL() {
                return HeaderURL;
            }

            public void setHeaderURL(String headerURL) {
                HeaderURL = headerURL;
            }

            public String getContactUserName() {
                return contactUserName;
            }

            public void setContactUserName(String contactUserName) {
                this.contactUserName = contactUserName;
            }

            public String getAppointmentTypeName() {
                return AppointmentTypeName;
            }

            public void setAppointmentTypeName(String AppointmentTypeName) {
                this.AppointmentTypeName = AppointmentTypeName;
            }

            public String getAppointCreateTime() {
                return AppointCreateTime;
            }

            public void setAppointCreateTime(String AppointCreateTime) {
                this.AppointCreateTime = AppointCreateTime;
            }

            public String getAppointStartTime() {
                return AppointStartTime;
            }

            public void setAppointStartTime(String AppointStartTime) {
                this.AppointStartTime = AppointStartTime;
            }

            public String getAppointmentResultName() {
                return AppointmentResultName;
            }

            public void setAppointmentResultName(String AppointmentResultName) {
                this.AppointmentResultName = AppointmentResultName;
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

            public String getAppointUserName() {
                return appointUserName;
            }

            public void setAppointUserName(String appointUserName) {
                this.appointUserName = appointUserName;
            }

            public String getAppointmentTypeId() {
                return AppointmentTypeId;
            }

            public void setAppointmentTypeId(String AppointmentTypeId) {
                this.AppointmentTypeId = AppointmentTypeId;
            }

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
            }

            public int getContactId() {
                return ContactId;
            }

            public void setContactId(int ContactId) {
                this.ContactId = ContactId;
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

            public List<ImageListBean> getImageList() {
                return imageList;
            }

            public void setImageList(List<ImageListBean> imageList) {
                this.imageList = imageList;
            }

            public static class ImageListBean {
                /**
                 * createtime : 2017-06-20 19:04:49
                 * clubid : 1
                 * createuserid : 13
                 * imageurl : uploadFiles/uploadImgs/20170620/2fe87d149a3d42809bd429f1c75f145e.jpg
                 * imageid : 65
                 * contactid : 80
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
}
