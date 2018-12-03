package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/6/6
 */

public class AppointmentBean {


    /**
     * message :
     * result : {"contactList":[{"contactUserName":"admi","AppointmentTypeName":"推荐次卡","AppointCreateTime":"2017-06-05","AppointStartTime":"2017-06-06\n\t\t19:36:00","AppointmentResultName":"","AppointmentId":"61","CustomerName":"李笨笨","appointUserName":"admi","AppointmentTypeId":"2","imageList":[{"createtime":"2017-06-06 11:16:03","clubid":0,"createuserid":0,"imageurl":"uploadFiles/uploadImgs/20170606/71283f062cf54f9e97b38433439d9064.jpg","imageid":242,"contactid":266}],"CreateTime":"2017-06-06","ContactId":266,"AppointEndTime":"2017-06-06 21:36:00","ContactContent":"跟进信息","Content":"无备注","AppointmentResultId":""},{"contactUserName":"admi","AppointmentTypeName":"推荐次卡","AppointCreateTime":"2017-06-05","AppointStartTime":"2017-06-06\n\t\t19:36:00","AppointmentResultName":"","AppointmentId":"61","CustomerName":"李笨笨","appointUserName":"admi","AppointmentTypeId":"2","imageList":[{"createtime":"2017-06-05 20:26:09","clubid":0,"createuserid":0,"imageurl":"uploadFiles/uploadImgs/20170605/ebef8ac7aa7c471993fa1aa988ff1719.jpg","imageid":241,"contactid":265}],"CreateTime":"2017-06-05","ContactId":265,"AppointEndTime":"2017-06-06 21:36:00","ContactContent":"好天咯考虑也就天啦噜我哭透胶","Content":"无备注","AppointmentResultId":""}],"appointInfo":{"AppointmentTypeName":"推荐次卡","sTime":"19:36","CreateUserId":1,"eTime":"21:36","AppointmentResultName":"","AppointmentId":61,"TipStartTime":"2017-06-05","ttime":"23:36","createName":"admi","CustomerName":"李笨笨","bgTime":"2017-06-06","AppointmentTypeId":2,"TipInterval":"30","CustomerId":52,"CreateTime":"2017-06-05","Content":"无备注","AppointmentResultId":""}}
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
         * contactList : [{"contactUserName":"admi","AppointmentTypeName":"推荐次卡","AppointCreateTime":"2017-06-05","AppointStartTime":"2017-06-06\n\t\t19:36:00","AppointmentResultName":"","AppointmentId":"61","CustomerName":"李笨笨","appointUserName":"admi","AppointmentTypeId":"2","imageList":[{"createtime":"2017-06-06 11:16:03","clubid":0,"createuserid":0,"imageurl":"uploadFiles/uploadImgs/20170606/71283f062cf54f9e97b38433439d9064.jpg","imageid":242,"contactid":266}],"CreateTime":"2017-06-06","ContactId":266,"AppointEndTime":"2017-06-06 21:36:00","ContactContent":"跟进信息","Content":"无备注","AppointmentResultId":""},{"contactUserName":"admi","AppointmentTypeName":"推荐次卡","AppointCreateTime":"2017-06-05","AppointStartTime":"2017-06-06\n\t\t19:36:00","AppointmentResultName":"","AppointmentId":"61","CustomerName":"李笨笨","appointUserName":"admi","AppointmentTypeId":"2","imageList":[{"createtime":"2017-06-05 20:26:09","clubid":0,"createuserid":0,"imageurl":"uploadFiles/uploadImgs/20170605/ebef8ac7aa7c471993fa1aa988ff1719.jpg","imageid":241,"contactid":265}],"CreateTime":"2017-06-05","ContactId":265,"AppointEndTime":"2017-06-06 21:36:00","ContactContent":"好天咯考虑也就天啦噜我哭透胶","Content":"无备注","AppointmentResultId":""}]
         * appointInfo : {"AppointmentTypeName":"推荐次卡","sTime":"19:36","CreateUserId":1,"eTime":"21:36","AppointmentResultName":"","AppointmentId":61,"TipStartTime":"2017-06-05","ttime":"23:36","createName":"admi","CustomerName":"李笨笨","bgTime":"2017-06-06","AppointmentTypeId":2,"TipInterval":"30","CustomerId":52,"CreateTime":"2017-06-05","Content":"无备注","AppointmentResultId":""}
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
             * AppointmentTypeName : 推荐次卡
             * sTime : 19:36
             * CreateUserId : 1
             * eTime : 21:36
             * AppointmentResultName :
             * AppointmentId : 61
             * TipStartTime : 2017-06-05
             * ttime : 23:36
             * createName : admi
             * CustomerName : 李笨笨
             * bgTime : 2017-06-06
             * AppointmentTypeId : 2
             * TipInterval : 30
             * CustomerId : 52
             * CreateTime : 2017-06-05
             * Content : 无备注
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

            public String getAppointmentResultId() {
                return AppointmentResultId;
            }

            public void setAppointmentResultId(String AppointmentResultId) {
                this.AppointmentResultId = AppointmentResultId;
            }
        }

        public static class ContactListBean {
            /**
             * contactUserName : admi
             * AppointmentTypeName : 推荐次卡
             * AppointCreateTime : 2017-06-05
             * AppointStartTime : 2017-06-06
             19:36:00
             * AppointmentResultName :
             * AppointmentId : 61
             * CustomerName : 李笨笨
             * appointUserName : admi
             * AppointmentTypeId : 2
             * imageList : [{"createtime":"2017-06-06 11:16:03","clubid":0,"createuserid":0,"imageurl":"uploadFiles/uploadImgs/20170606/71283f062cf54f9e97b38433439d9064.jpg","imageid":242,"contactid":266}]
             * CreateTime : 2017-06-06
             * ContactId : 266
             * AppointEndTime : 2017-06-06 21:36:00
             * ContactContent : 跟进信息
             * Content : 无备注
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
            private List<ImageListBean> imageList;

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
                 * createtime : 2017-06-06 11:16:03
                 * clubid : 0
                 * createuserid : 0
                 * imageurl : uploadFiles/uploadImgs/20170606/71283f062cf54f9e97b38433439d9064.jpg
                 * imageid : 242
                 * contactid : 266
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
