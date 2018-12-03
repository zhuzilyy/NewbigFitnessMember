package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/6/8.
 */

public class ClubMemberCardTypeDetailBean {


    /**
     * data : {"Introduce":null,"ConsumeType":0,"Price":0,"Amount":0,"MemberCardTypeName":"通卡-次卡2","ImageURL":"","OnlineBuyMinAmount":null}
     * priceList : [{"EndAmount":100,"Price":40,"StartAmount":1},{"EndAmount":1000,"Price":38,"StartAmount":101}]
     */

    private DataBean data;
    private List<PriceListBean> priceList;
    /**
     * Ret : 0
     * Msg :
     * rows : {"LockCount":1,"Introduce":"","ConsumeType":1,"Price":0.01,"IsClubsCard":0,"Amount":1,"MemberCardTypeName":"测试卡","ImageURL":""}
     */

    private int Ret;
    private String Msg;
    private RowsBean rows;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public List<PriceListBean> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<PriceListBean> priceList) {
        this.priceList = priceList;
    }

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

    public static class DataBean {
        /**
         * Introduce : null
         * ConsumeType : 0
         * Price : 0
         * Amount : 0
         * MemberCardTypeName : 通卡-次卡2
         * ImageURL :
         * OnlineBuyMinAmount : null
         */

        private String Introduce;
        private int ConsumeType;
        private Double Price;
        private int Amount;
        private String MemberCardTypeName;
        private String ImageURL;
        private int OnlineBuyMinAmount;

        public String getIntroduce() {
            return Introduce;
        }

        public void setIntroduce(String Introduce) {
            this.Introduce = Introduce;
        }

        public int getConsumeType() {
            return ConsumeType;
        }

        public void setConsumeType(int ConsumeType) {
            this.ConsumeType = ConsumeType;
        }

        public Double getPrice() {
            return Price;
        }

        public void setPrice(Double price) {
            Price = price;
        }

        public int getAmount() {
            return Amount;
        }

        public void setAmount(int Amount) {
            this.Amount = Amount;
        }

        public String getMemberCardTypeName() {
            return MemberCardTypeName;
        }

        public void setMemberCardTypeName(String MemberCardTypeName) {
            this.MemberCardTypeName = MemberCardTypeName;
        }

        public String getImageURL() {
            return ImageURL;
        }

        public void setImageURL(String ImageURL) {
            this.ImageURL = ImageURL;
        }

        public int getOnlineBuyMinAmount() {
            return OnlineBuyMinAmount;
        }

        public void setOnlineBuyMinAmount(int OnlineBuyMinAmount) {
            this.OnlineBuyMinAmount = OnlineBuyMinAmount;
        }
    }

    public static class PriceListBean {
        /**
         * EndAmount : 100
         * Price : 40
         * StartAmount : 1
         */

        private int EndAmount;
        private Double Price;
        private int StartAmount;

        public Double getPrice() {
            return Price;
        }

        public void setPrice(Double price) {
            Price = price;
        }

        public int getEndAmount() {
            return EndAmount;
        }

        public void setEndAmount(int EndAmount) {
            this.EndAmount = EndAmount;
        }

        public int getStartAmount() {
            return StartAmount;
        }

        public void setStartAmount(int StartAmount) {
            this.StartAmount = StartAmount;
        }
    }

    public static class RowsBean {
        /**
         * LockCount : 1
         * Introduce :
         * ConsumeType : 1
         * Price : 0.01
         * IsClubsCard : 0
         * Amount : 1
         * MemberCardTypeName : 测试卡
         * ImageURL :
         */

        private int LockCount;
        private String Introduce;
        private int ConsumeType;
        private double Price;
        private int IsClubsCard;
        private int Amount;
        private String MemberCardTypeName;
        private String ImageURL;

        public int getLockCount() {
            return LockCount;
        }

        public void setLockCount(int LockCount) {
            this.LockCount = LockCount;
        }

        public String getIntroduce() {
            return Introduce;
        }

        public void setIntroduce(String Introduce) {
            this.Introduce = Introduce;
        }

        public int getConsumeType() {
            return ConsumeType;
        }

        public void setConsumeType(int ConsumeType) {
            this.ConsumeType = ConsumeType;
        }

        public double getPrice() {
            return Price;
        }

        public void setPrice(double Price) {
            this.Price = Price;
        }

        public int getIsClubsCard() {
            return IsClubsCard;
        }

        public void setIsClubsCard(int IsClubsCard) {
            this.IsClubsCard = IsClubsCard;
        }

        public int getAmount() {
            return Amount;
        }

        public void setAmount(int Amount) {
            this.Amount = Amount;
        }

        public String getMemberCardTypeName() {
            return MemberCardTypeName;
        }

        public void setMemberCardTypeName(String MemberCardTypeName) {
            this.MemberCardTypeName = MemberCardTypeName;
        }

        public String getImageURL() {
            return ImageURL;
        }

        public void setImageURL(String ImageURL) {
            this.ImageURL = ImageURL;
        }
    }
}
