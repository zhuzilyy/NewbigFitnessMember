package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/4/11.
 */

public class ClubSaleLessonListBean {


    /**
     * Ret : 0
     * Msg :
     * TotalPage : 4
     * rows : [{"ClubName":"MAX沈北店","IsBuy":0,"LessonId":22,"ImageURL":"","LessonName":"260私教","IsRecommend":1},{"ClubName":"MAX沈北店","IsBuy":1,"LessonId":24,"ImageURL":"","LessonName":"180私教","IsRecommend":1},{"ClubName":"MAX沈北店","IsBuy":0,"LessonId":32,"ImageURL":"","LessonName":"运动健身","IsRecommend":1},{"ClubName":"MAX沈北店","IsBuy":0,"LessonId":21,"ImageURL":"","LessonName":"200私教","IsRecommend":0},{"ClubName":"MAX沈北店","IsBuy":0,"LessonId":23,"ImageURL":"","LessonName":"150私教","IsRecommend":0},{"ClubName":"MAX沈北店","IsBuy":0,"LessonId":25,"ImageURL":"","LessonName":"240私教","IsRecommend":0},{"ClubName":"MAX沈北店","IsBuy":0,"LessonId":26,"ImageURL":"","LessonName":"220私教","IsRecommend":0},{"ClubName":"MAX沈北店","IsBuy":0,"LessonId":33,"ImageURL":null,"LessonName":"测试1","IsRecommend":0},{"ClubName":"MAX沈北店","IsBuy":0,"LessonId":34,"ImageURL":null,"LessonName":"测试2","IsRecommend":0},{"ClubName":"MAX沈北店","IsBuy":0,"LessonId":35,"ImageURL":null,"LessonName":"测试3","IsRecommend":0}]
     */

    private int Ret;
    private String Msg;
    private int TotalPage;
    private List<RowsBean> rows;

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
         * ClubName : MAX沈北店
         * IsBuy : 0
         * LessonId : 22
         * ImageURL :
         * LessonName : 260私教
         * IsRecommend : 1
         */

        private String ClubName;
        private int IsBuy;
        private int LessonId;
        private String ImageURL;
        private String LessonName;
        private int IsRecommend;

        public String getClubName() {
            return ClubName;
        }

        public void setClubName(String ClubName) {
            this.ClubName = ClubName;
        }

        public int getIsBuy() {
            return IsBuy;
        }

        public void setIsBuy(int IsBuy) {
            this.IsBuy = IsBuy;
        }

        public int getLessonId() {
            return LessonId;
        }

        public void setLessonId(int LessonId) {
            this.LessonId = LessonId;
        }

        public String getImageURL() {
            return ImageURL;
        }

        public void setImageURL(String ImageURL) {
            this.ImageURL = ImageURL;
        }

        public String getLessonName() {
            return LessonName;
        }

        public void setLessonName(String LessonName) {
            this.LessonName = LessonName;
        }

        public int getIsRecommend() {
            return IsRecommend;
        }

        public void setIsRecommend(int IsRecommend) {
            this.IsRecommend = IsRecommend;
        }
    }
}
