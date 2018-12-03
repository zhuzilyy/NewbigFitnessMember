package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/6/2
 */

public class StarEvaluateBean {


    /**
     * result : [{"HeaderURL":"a.jpg","CreateTime":"2017/03/08 16:57","EvaluateStar":5,"MemberName":"哈哈","EvaluateContent":"非常好"},{"HeaderURL":"a.jpg","CreateTime":"2017/03/22 15:09","EvaluateStar":5,"MemberName":"哈哈","EvaluateContent":"a"},{"HeaderURL":"a.jpg","CreateTime":"2017/03/22 15:09","EvaluateStar":5,"MemberName":"哈哈","EvaluateContent":"b"},{"HeaderURL":"a.jpg","CreateTime":"2017/03/22 15:35","EvaluateStar":5,"MemberName":"哈哈","EvaluateContent":"c"},{"HeaderURL":"a.jpg","CreateTime":"2017/03/22 15:35","EvaluateStar":5,"MemberName":"哈哈","EvaluateContent":"d"},{"HeaderURL":"a.jpg","CreateTime":"2017/03/22 15:36","EvaluateStar":5,"MemberName":"哈哈","EvaluateContent":"e"},{"HeaderURL":"a.jpg","CreateTime":"2017/03/22 15:36","EvaluateStar":5,"MemberName":"哈哈","EvaluateContent":"f"}]
     * starCount : {"FourStarCount":4,"ThreeStarCount":3,"TwoStarCount":2,"OneStarCount":1,"FiveStarCount":5}
     * messgaee :
     * code : 0
     */

    private StarCountBean starCount;
    private String messgaee;
    private int code;
    private List<ResultBean> result;

    public StarCountBean getStarCount() {
        return starCount;
    }

    public void setStarCount(StarCountBean starCount) {
        this.starCount = starCount;
    }

    public String getMessgaee() {
        return messgaee;
    }

    public void setMessgaee(String messgaee) {
        this.messgaee = messgaee;
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

    public static class StarCountBean {
        /**
         * FourStarCount : 4
         * ThreeStarCount : 3
         * TwoStarCount : 2
         * OneStarCount : 1
         * FiveStarCount : 5
         */

        private int FourStarCount;
        private int ThreeStarCount;
        private int TwoStarCount;
        private int OneStarCount;
        private int FiveStarCount;

        public int getFourStarCount() {
            return FourStarCount;
        }

        public void setFourStarCount(int FourStarCount) {
            this.FourStarCount = FourStarCount;
        }

        public int getThreeStarCount() {
            return ThreeStarCount;
        }

        public void setThreeStarCount(int ThreeStarCount) {
            this.ThreeStarCount = ThreeStarCount;
        }

        public int getTwoStarCount() {
            return TwoStarCount;
        }

        public void setTwoStarCount(int TwoStarCount) {
            this.TwoStarCount = TwoStarCount;
        }

        public int getOneStarCount() {
            return OneStarCount;
        }

        public void setOneStarCount(int OneStarCount) {
            this.OneStarCount = OneStarCount;
        }

        public int getFiveStarCount() {
            return FiveStarCount;
        }

        public void setFiveStarCount(int FiveStarCount) {
            this.FiveStarCount = FiveStarCount;
        }
    }

    public static class ResultBean {
        /**
         * HeaderURL : a.jpg
         * CreateTime : 2017/03/08 16:57
         * EvaluateStar : 5
         * MemberName : 哈哈
         * EvaluateContent : 非常好
         */

        private String HeaderURL;
        private String CreateTime;
        private int EvaluateStar;
        private String MemberName;
        private String EvaluateContent;

        public String getHeaderURL() {
            return HeaderURL;
        }

        public void setHeaderURL(String HeaderURL) {
            this.HeaderURL = HeaderURL;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getEvaluateStar() {
            return EvaluateStar;
        }

        public void setEvaluateStar(int EvaluateStar) {
            this.EvaluateStar = EvaluateStar;
        }

        public String getMemberName() {
            return MemberName;
        }

        public void setMemberName(String MemberName) {
            this.MemberName = MemberName;
        }

        public String getEvaluateContent() {
            return EvaluateContent;
        }

        public void setEvaluateContent(String EvaluateContent) {
            this.EvaluateContent = EvaluateContent;
        }
    }
}
