package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/3/27.
 *
 * #获取会所在售未开课或已购买的小团体课列表
 */

public class ClubSaleNotOpenOrBuyGroupLessonListBean {


    /**
     * Ret : 0
     * TotalPage : 1
     * rows : [{"Status":0,"GLessonName":"实验课1","isbuy":0,"GroupLessonId":25,"SaleMoney":1500,"PersonCount":2,"Amount":4,"isfull":0,"ImageURL":"","ClubId":1,"ClassPersonCount":10},{"Status":0,"GLessonName":"实验团课","isbuy":1,"GroupLessonId":24,"SaleMoney":500,"PersonCount":2,"Amount":4,"isfull":0,"ImageURL":"","ClubId":1,"ClassPersonCount":5},{"Status":0,"GLessonName":"小团体课","isbuy":1,"GroupLessonId":22,"SaleMoney":3000,"PersonCount":5,"Amount":4,"isfull":0,"ImageURL":"","ClubId":1,"ClassPersonCount":6},{"Status":0,"GLessonName":"团课","isbuy":1,"GroupLessonId":23,"SaleMoney":1000,"PersonCount":2,"Amount":2,"isfull":0,"ImageURL":"","ClubId":1,"ClassPersonCount":5},{"Status":0,"GLessonName":"实验课2","isbuy":0,"GroupLessonId":26,"SaleMoney":1500,"PersonCount":2,"Amount":3,"isfull":0,"ImageURL":"","ClubId":1,"ClassPersonCount":10}]
     */

    private int Ret;
    private int TotalPage;
    private List<RowsBean> rows;

    public int getRet() {
        return Ret;
    }

    public void setRet(int Ret) {
        this.Ret = Ret;
    }

    public int getTotalPage() {
        return TotalPage;
    }

    public void setTotalPage(int TotalPage) {
        this.TotalPage = TotalPage;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * Status : 0
         * GLessonName : 实验课1
         * isbuy : 0
         * GroupLessonId : 25
         * SaleMoney : 1500
         * PersonCount : 2
         * Amount : 4
         * isfull : 0
         * ImageURL :
         * ClubId : 1
         * ClassPersonCount : 10
         */

        private int Status;
        private String GLessonName;
        private int isbuy;
        private int GroupLessonId;
        private int SaleMoney;
        private int PersonCount;
        private int Amount;
        private int isfull;
        private String ImageURL;
        private int ClubId;
        private int ClassPersonCount;

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getGLessonName() {
            return GLessonName;
        }

        public void setGLessonName(String GLessonName) {
            this.GLessonName = GLessonName;
        }

        public int getIsbuy() {
            return isbuy;
        }

        public void setIsbuy(int isbuy) {
            this.isbuy = isbuy;
        }

        public int getGroupLessonId() {
            return GroupLessonId;
        }

        public void setGroupLessonId(int GroupLessonId) {
            this.GroupLessonId = GroupLessonId;
        }

        public int getSaleMoney() {
            return SaleMoney;
        }

        public void setSaleMoney(int SaleMoney) {
            this.SaleMoney = SaleMoney;
        }

        public int getPersonCount() {
            return PersonCount;
        }

        public void setPersonCount(int PersonCount) {
            this.PersonCount = PersonCount;
        }

        public int getAmount() {
            return Amount;
        }

        public void setAmount(int Amount) {
            this.Amount = Amount;
        }

        public int getIsfull() {
            return isfull;
        }

        public void setIsfull(int isfull) {
            this.isfull = isfull;
        }

        public String getImageURL() {
            return ImageURL;
        }

        public void setImageURL(String ImageURL) {
            this.ImageURL = ImageURL;
        }

        public int getClubId() {
            return ClubId;
        }

        public void setClubId(int ClubId) {
            this.ClubId = ClubId;
        }

        public int getClassPersonCount() {
            return ClassPersonCount;
        }

        public void setClassPersonCount(int ClassPersonCount) {
            this.ClassPersonCount = ClassPersonCount;
        }
    }
}
