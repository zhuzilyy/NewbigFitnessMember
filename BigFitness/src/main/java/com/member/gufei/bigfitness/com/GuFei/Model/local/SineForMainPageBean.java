package com.member.gufei.bigfitness.com.GuFei.Model.local;

/**
 * Created by Administrator on 2017/7/15.
 */

public class SineForMainPageBean {


    /**
     * message :
     * result : {"changeResult":{"CreateTime":"2017/07/29 14:58","Title":"客户: 可和","resCount":4600965,"countNum":2},"appointmentResult":{"CreateTime":"2017/07/30 14:54","Title":"客户: 苦苦","resCount":"4600974","countNum":1},"result":{"CreateTime":"2017/07/24 17:48","Title":"1233321","resCount":22,"countNum":1},"signResult":{"CreateTime":"","Title":"","resCount":0,"countNum":0},"birthdayResult":{"CreateTime":"2017/07/28 16:51","Title":"会员:小白1","resCount":4600948,"countNum":1},"expireResult":{"CreateTime":"","Title":"","resCount":0,"countNum":0}}
     * code : 0
     */

    private String message;
    private ResultBeanX result;
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBeanX getResult() {
        return result;
    }

    public void setResult(ResultBeanX result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBeanX {
        /**
         * changeResult : {"CreateTime":"2017/07/29 14:58","Title":"客户: 可和","resCount":4600965,"countNum":2}
         * appointmentResult : {"CreateTime":"2017/07/30 14:54","Title":"客户: 苦苦","resCount":"4600974","countNum":1}
         * result : {"CreateTime":"2017/07/24 17:48","Title":"1233321","resCount":22,"countNum":1}
         * signResult : {"CreateTime":"","Title":"","resCount":0,"countNum":0}
         * birthdayResult : {"CreateTime":"2017/07/28 16:51","Title":"会员:小白1","resCount":4600948,"countNum":1}
         * expireResult : {"CreateTime":"","Title":"","resCount":0,"countNum":0}
         */

        private ChangeResultBean changeResult;
        private AppointmentResultBean appointmentResult;
        private ResultBean result;
        private SignResultBean signResult;
        private BirthdayResultBean birthdayResult;
        private ExpireResultBean expireResult;

        public ChangeResultBean getChangeResult() {
            return changeResult;
        }

        public void setChangeResult(ChangeResultBean changeResult) {
            this.changeResult = changeResult;
        }

        public AppointmentResultBean getAppointmentResult() {
            return appointmentResult;
        }

        public void setAppointmentResult(AppointmentResultBean appointmentResult) {
            this.appointmentResult = appointmentResult;
        }

        public ResultBean getResult() {
            return result;
        }

        public void setResult(ResultBean result) {
            this.result = result;
        }

        public SignResultBean getSignResult() {
            return signResult;
        }

        public void setSignResult(SignResultBean signResult) {
            this.signResult = signResult;
        }

        public BirthdayResultBean getBirthdayResult() {
            return birthdayResult;
        }

        public void setBirthdayResult(BirthdayResultBean birthdayResult) {
            this.birthdayResult = birthdayResult;
        }

        public ExpireResultBean getExpireResult() {
            return expireResult;
        }

        public void setExpireResult(ExpireResultBean expireResult) {
            this.expireResult = expireResult;
        }

        public static class ChangeResultBean {
            /**
             * CreateTime : 2017/07/29 14:58
             * Title : 客户: 可和
             * resCount : 4600965
             * countNum : 2
             */

            private String CreateTime;
            private String Title;
            private int resCount;
            private int countNum;

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public int getResCount() {
                return resCount;
            }

            public void setResCount(int resCount) {
                this.resCount = resCount;
            }

            public int getCountNum() {
                return countNum;
            }

            public void setCountNum(int countNum) {
                this.countNum = countNum;
            }
        }

        public static class AppointmentResultBean {
            /**
             * CreateTime : 2017/07/30 14:54
             * Title : 客户: 苦苦
             * resCount : 4600974
             * countNum : 1
             */

            private String CreateTime;
            private String Title;
            private String resCount;
            private int countNum;

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public String getResCount() {
                return resCount;
            }

            public void setResCount(String resCount) {
                this.resCount = resCount;
            }

            public int getCountNum() {
                return countNum;
            }

            public void setCountNum(int countNum) {
                this.countNum = countNum;
            }
        }

        public static class ResultBean {
            /**
             * CreateTime : 2017/07/24 17:48
             * Title : 1233321
             * resCount : 22
             * countNum : 1
             */

            private String CreateTime;
            private String Title;
            private int resCount;
            private int countNum;

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public int getResCount() {
                return resCount;
            }

            public void setResCount(int resCount) {
                this.resCount = resCount;
            }

            public int getCountNum() {
                return countNum;
            }

            public void setCountNum(int countNum) {
                this.countNum = countNum;
            }
        }

        public static class SignResultBean {
            /**
             * CreateTime :
             * Title :
             * resCount : 0
             * countNum : 0
             */

            private String CreateTime;
            private String Title;
            private int resCount;
            private int countNum;

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public int getResCount() {
                return resCount;
            }

            public void setResCount(int resCount) {
                this.resCount = resCount;
            }

            public int getCountNum() {
                return countNum;
            }

            public void setCountNum(int countNum) {
                this.countNum = countNum;
            }
        }

        public static class BirthdayResultBean {
            /**
             * CreateTime : 2017/07/28 16:51
             * Title : 会员:小白1
             * resCount : 4600948
             * countNum : 1
             */

            private String CreateTime;
            private String Title;
            private int resCount;
            private int countNum;

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public int getResCount() {
                return resCount;
            }

            public void setResCount(int resCount) {
                this.resCount = resCount;
            }

            public int getCountNum() {
                return countNum;
            }

            public void setCountNum(int countNum) {
                this.countNum = countNum;
            }
        }

        public static class ExpireResultBean {
            /**
             * CreateTime :
             * Title :
             * resCount : 0
             * countNum : 0
             */

            private String CreateTime;
            private String Title;
            private int resCount;
            private int countNum;

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public int getResCount() {
                return resCount;
            }

            public void setResCount(int resCount) {
                this.resCount = resCount;
            }

            public int getCountNum() {
                return countNum;
            }

            public void setCountNum(int countNum) {
                this.countNum = countNum;
            }
        }
    }
}
