package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

/**
 * Created by GuFei on 2018/6/14.
 */

public class MyTwoDimensionCodeBean {

    /**
     * Ret : 0
     * Msg :
     * rows : {"Sex":0,"TwoDimensionCode":"2018013100590017192129.jpg","HeaderURL":"uploadFiles/uploadImgs/pig.png","NickName":"隔壁老得瑟","Age":0}
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
         * Sex : 0
         * TwoDimensionCode : 2018013100590017192129.jpg
         * HeaderURL : uploadFiles/uploadImgs/pig.png
         * NickName : 隔壁老得瑟
         * Age : 0
         */

        private int Sex;
        private String TwoDimensionCode;
        private String HeaderURL;
        private String NickName;
        private int Age;

        public int getSex() {
            return Sex;
        }

        public void setSex(int Sex) {
            this.Sex = Sex;
        }

        public String getTwoDimensionCode() {
            return TwoDimensionCode;
        }

        public void setTwoDimensionCode(String TwoDimensionCode) {
            this.TwoDimensionCode = TwoDimensionCode;
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

        public int getAge() {
            return Age;
        }

        public void setAge(int Age) {
            this.Age = Age;
        }
    }
}
