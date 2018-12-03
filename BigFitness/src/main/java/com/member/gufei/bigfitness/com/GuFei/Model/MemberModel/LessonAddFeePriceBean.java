package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;
/**
 * Created by LiuShengYuan on 2018/9/10.
 *

 */

public class LessonAddFeePriceBean {

    /**
     * Ret : 0
     * Msg :
     * rows : [{"EndAmount":10,"Price":0.1,"StartAmount":1},{"EndAmount":20,"Price":0.1,"StartAmount":11},{"EndAmount":0,"Price":0.1,"StartAmount":20}]
     */

    private int Ret;
    private String Msg;
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

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * EndAmount : 10
         * Price : 0.1
         * StartAmount : 1
         */

        private int EndAmount;
        private double Price;
        private int StartAmount;

        public int getEndAmount() {
            return EndAmount;
        }

        public void setEndAmount(int EndAmount) {
            this.EndAmount = EndAmount;
        }

        public double getPrice() {
            return Price;
        }

        public void setPrice(double Price) {
            this.Price = Price;
        }

        public int getStartAmount() {
            return StartAmount;
        }

        public void setStartAmount(int StartAmount) {
            this.StartAmount = StartAmount;
        }
    }
}
