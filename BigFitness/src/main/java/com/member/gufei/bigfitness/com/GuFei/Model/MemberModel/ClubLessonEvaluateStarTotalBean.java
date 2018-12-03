package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/6/5.
 */

public class ClubLessonEvaluateStarTotalBean {

    /**
     * Ret : 0
     * Msg :
     * StarTotal : {"oneStartCount":1,"twoStartCount":1,"fourStartCount":1,"fiveStartCount":0,"threeStartCount":1,"AvgStarLevel":2.5,"TotalEvalCount":4}
     * TotalPage : 1
     * rows : [{"EvaluateStar":1,"CreateTime":"2018-03-01","EvaluateContent":"11","HeaderURL":"c.jpg","NickName":"小孙","ImageURLList":"1.jpg,3.jpg"},{"EvaluateStar":2,"CreateTime":"2018-03-01","EvaluateContent":"11","HeaderURL":"d.jpg","NickName":"小孙1","ImageURLList":"2.jpg,5.jpg"},{"EvaluateStar":3,"CreateTime":"2018-03-01","EvaluateContent":"22","HeaderURL":"1111.jpg","NickName":"测试1","ImageURLList":"1.jpg"},{"EvaluateStar":4,"CreateTime":"2018-03-01","EvaluateContent":"","HeaderURL":"2222.jpg","NickName":"测试2","ImageURLList":""}]
     */

    private int Ret;
    private String Msg;
    private StarTotalBean StarTotal;
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

    public StarTotalBean getStarTotal() {
        return StarTotal;
    }

    public void setStarTotal(StarTotalBean StarTotal) {
        this.StarTotal = StarTotal;
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

    public static class StarTotalBean {
        /**
         * oneStartCount : 1
         * twoStartCount : 1
         * fourStartCount : 1
         * fiveStartCount : 0
         * threeStartCount : 1
         * AvgStarLevel : 2.5
         * TotalEvalCount : 4
         */

        private int oneStartCount;
        private int twoStartCount;
        private int fourStartCount;
        private int fiveStartCount;
        private int threeStartCount;
        private double AvgStarLevel;
        private int TotalEvalCount;

        public int getOneStartCount() {
            return oneStartCount;
        }

        public void setOneStartCount(int oneStartCount) {
            this.oneStartCount = oneStartCount;
        }

        public int getTwoStartCount() {
            return twoStartCount;
        }

        public void setTwoStartCount(int twoStartCount) {
            this.twoStartCount = twoStartCount;
        }

        public int getFourStartCount() {
            return fourStartCount;
        }

        public void setFourStartCount(int fourStartCount) {
            this.fourStartCount = fourStartCount;
        }

        public int getFiveStartCount() {
            return fiveStartCount;
        }

        public void setFiveStartCount(int fiveStartCount) {
            this.fiveStartCount = fiveStartCount;
        }

        public int getThreeStartCount() {
            return threeStartCount;
        }

        public void setThreeStartCount(int threeStartCount) {
            this.threeStartCount = threeStartCount;
        }

        public double getAvgStarLevel() {
            return AvgStarLevel;
        }

        public void setAvgStarLevel(double AvgStarLevel) {
            this.AvgStarLevel = AvgStarLevel;
        }

        public int getTotalEvalCount() {
            return TotalEvalCount;
        }

        public void setTotalEvalCount(int TotalEvalCount) {
            this.TotalEvalCount = TotalEvalCount;
        }
    }

    public static class RowsBean {
        /**
         * EvaluateStar : 1
         * CreateTime : 2018-03-01
         * EvaluateContent : 11
         * HeaderURL : c.jpg
         * NickName : 小孙
         * ImageURLList : 1.jpg,3.jpg
         */

        private int EvaluateStar;
        private String CreateTime;
        private String EvaluateContent;
        private String HeaderURL;
        private String NickName;
        private String ImageURLList;

        public int getEvaluateStar() {
            return EvaluateStar;
        }

        public void setEvaluateStar(int EvaluateStar) {
            this.EvaluateStar = EvaluateStar;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getEvaluateContent() {
            return EvaluateContent;
        }

        public void setEvaluateContent(String EvaluateContent) {
            this.EvaluateContent = EvaluateContent;
        }

        public String getHeaderURL() {
            return HeaderURL;
        }

        public void setHeaderURL(String HeaderURL) {
            this.HeaderURL = HeaderURL;
        }

        public String getNickName() {
            return NickName;
        }

        public void setNickName(String NickName) {
            this.NickName = NickName;
        }

        public String getImageURLList() {
            return ImageURLList;
        }

        public void setImageURLList(String ImageURLList) {
            this.ImageURLList = ImageURLList;
        }
    }
}
