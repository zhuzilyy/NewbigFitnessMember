package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/6/24.
 */

public class AppointmentByIdForMemberBean {


    /**
     * message :
     * result : {"contactList":[],"trainPlanList":[{"GroupCount":1,"PositionName":"腹部","Amount":3,"ActionName":"仰卧起坐","Weight":null,"PositionId":2,"ActionId":3}],"appointInfo":{"AppointmentTypeName":"上课预约","sTime":"10:06","LessonId":7,"CreateUserId":10,"IsSignIn":0,"eTime":"12:06","AppointmentResultName":"","AppointmentId":77,"TipStartTime":"2017-07-19","ttime":"09:06","createName":"王大军","bgTime":"2017-07-19","MemberId":116,"AppointmentTypeId":11,"TipInterval":"10","LessonName":"减肥","CreateTime":"2017-07-18","Content":"","editType":1,"MemberName":"消费记录测试","AppointmentResultId":""}}
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
         * contactList : []
         * trainPlanList : [{"GroupCount":1,"PositionName":"腹部","Amount":3,"ActionName":"仰卧起坐","Weight":null,"PositionId":2,"ActionId":3}]
         * appointInfo : {"AppointmentTypeName":"上课预约","sTime":"10:06","LessonId":7,"CreateUserId":10,"IsSignIn":0,"eTime":"12:06","AppointmentResultName":"","AppointmentId":77,"TipStartTime":"2017-07-19","ttime":"09:06","createName":"王大军","bgTime":"2017-07-19","MemberId":116,"AppointmentTypeId":11,"TipInterval":"10","LessonName":"减肥","CreateTime":"2017-07-18","Content":"","editType":1,"MemberName":"消费记录测试","AppointmentResultId":""}
         */

        private AppointInfoBean appointInfo;
        private List<ContactListBean> contactList;
        private List<TrainPlanListBean> trainPlanList;

        public List<ContactListBean> getContactList() {
            return contactList;
        }

        public void setContactList(List<ContactListBean> contactList) {
            this.contactList = contactList;
        }


        public AppointInfoBean getAppointInfo() {
            return appointInfo;
        }

        public void setAppointInfo(AppointInfoBean appointInfo) {
            this.appointInfo = appointInfo;
        }


        public List<TrainPlanListBean> getTrainPlanList() {
            return trainPlanList;
        }

        public void setTrainPlanList(List<TrainPlanListBean> trainPlanList) {
            this.trainPlanList = trainPlanList;
        }

        public static class AppointInfoBean {
            /**
             * AppointmentTypeName : 上课预约
             * sTime : 10:06
             * LessonId : 7
             * CreateUserId : 10
             * IsSignIn : 0
             * eTime : 12:06
             * AppointmentResultName :
             * AppointmentId : 77
             * TipStartTime : 2017-07-19
             * ttime : 09:06
             * createName : 王大军
             * bgTime : 2017-07-19
             * MemberId : 116
             * AppointmentTypeId : 11
             * TipInterval : 10
             * LessonName : 减肥
             * CreateTime : 2017-07-18
             * Content :
             * editType : 1
             * MemberName : 消费记录测试
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
            private String LessonName;
            private String CreateTime;
            private String Content;
            private int editType;
            private String MemberName;
            private String AppointmentResultId;

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

            public String getLessonName() {
                return LessonName;
            }

            public void setLessonName(String LessonName) {
                this.LessonName = LessonName;
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
            private List<ImageListBean> imageList;

            private String HeaderURL;
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

        public static class TrainPlanListBean {
            /**
             * GroupCount : 1
             * PositionName : 腹部
             * Amount : 3
             * ActionName : 仰卧起坐
             * Weight : null
             * PositionId : 2
             * ActionId : 3
             */

            private int GroupCount;
            private String PositionName;
            private int Amount;
            private String ActionName;
            private Object Weight;
            private int PositionId;
            private int ActionId;

            public int getGroupCount() {
                return GroupCount;
            }

            public void setGroupCount(int GroupCount) {
                this.GroupCount = GroupCount;
            }

            public String getPositionName() {
                return PositionName;
            }

            public void setPositionName(String PositionName) {
                this.PositionName = PositionName;
            }

            public int getAmount() {
                return Amount;
            }

            public void setAmount(int Amount) {
                this.Amount = Amount;
            }

            public String getActionName() {
                return ActionName;
            }

            public void setActionName(String ActionName) {
                this.ActionName = ActionName;
            }

            public Object getWeight() {
                return Weight;
            }

            public void setWeight(Object Weight) {
                this.Weight = Weight;
            }

            public int getPositionId() {
                return PositionId;
            }

            public void setPositionId(int PositionId) {
                this.PositionId = PositionId;
            }

            public int getActionId() {
                return ActionId;
            }

            public void setActionId(int ActionId) {
                this.ActionId = ActionId;
            }
        }


    }
}
