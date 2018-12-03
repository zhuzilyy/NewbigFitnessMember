package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/6/5.
 */

public class ClubInfoByIdBean {


    /**
     * Ret : 0
     * Msg :
     * rows : {"ClubName":"MAX沈北店","MemberId":32311,"Address":"1","Introduce":"3","EvaluateStar":1.5455,"Images":[{"ImageURL":"3.jpg","Id":3},{"ImageURL":"2.jpg","Id":2},{"ImageURL":"1.jpg","Id":1}],"Tel":"2","ClubId":1,"EvaluateSum":11,"BusinessStartHours":"09:00","BusinessEndHours":"22:00"}
     */

    private int Ret;
    private String Msg;
    private RowsBean rows;

    public int getRet() {
        return Ret;
    }

    public void setRet(int Ret) {
        this.Ret = Ret;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public RowsBean getRows() {
        return rows;
    }

    public void setRows(RowsBean rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * ClubName : MAX沈北店
         * MemberId : 32311
         * Address : 1
         * Introduce : 3
         * EvaluateStar : 1.5455
         * Images : [{"ImageURL":"3.jpg","Id":3},{"ImageURL":"2.jpg","Id":2},{"ImageURL":"1.jpg","Id":1}]
         * Tel : 2
         * ClubId : 1
         * EvaluateSum : 11
         * BusinessStartHours : 09:00
         * BusinessEndHours : 22:00
         * IsLock : 0
         */

        private String ClubName;
        private int MemberId;
        private String Address;
        private String Introduce;
        private double EvaluateStar;
        private String Tel;
        private int ClubId;
        private int EvaluateSum;
        private String BusinessStartHours;
        private String BusinessEndHours;
        private int IsLock;
        private List<ImagesBean> Images;

        public String getClubName() {
            return ClubName;
        }

        public void setClubName(String ClubName) {
            this.ClubName = ClubName;
        }

        public int getMemberId() {
            return MemberId;
        }

        public void setMemberId(int MemberId) {
            this.MemberId = MemberId;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getIntroduce() {
            return Introduce;
        }

        public void setIntroduce(String Introduce) {
            this.Introduce = Introduce;
        }

        public double getEvaluateStar() {
            return EvaluateStar;
        }

        public void setEvaluateStar(double EvaluateStar) {
            this.EvaluateStar = EvaluateStar;
        }

        public String getTel() {
            return Tel;
        }

        public void setTel(String Tel) {
            this.Tel = Tel;
        }

        public int getClubId() {
            return ClubId;
        }

        public void setClubId(int ClubId) {
            this.ClubId = ClubId;
        }

        public int getEvaluateSum() {
            return EvaluateSum;
        }

        public void setEvaluateSum(int EvaluateSum) {
            this.EvaluateSum = EvaluateSum;
        }

        public String getBusinessStartHours() {
            return BusinessStartHours;
        }

        public void setBusinessStartHours(String BusinessStartHours) {
            this.BusinessStartHours = BusinessStartHours;
        }

        public String getBusinessEndHours() {
            return BusinessEndHours;
        }

        public void setBusinessEndHours(String BusinessEndHours) {
            this.BusinessEndHours = BusinessEndHours;
        }

        public List<ImagesBean> getImages() {
            return Images;
        }

        public void setImages(List<ImagesBean> Images) {
            this.Images = Images;
        }

        public int getIsLock() {
            return IsLock;
        }

        public void setIsLock(int isLock) {
            IsLock = isLock;
        }

        public static class ImagesBean {
            /**
             * ImageURL : 3.jpg
             * Id : 3
             */

            private String ImageURL;
            private int Id;

            public String getImageURL() {
                return ImageURL;
            }

            public void setImageURL(String ImageURL) {
                this.ImageURL = ImageURL;
            }

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
            }
        }
    }
}
