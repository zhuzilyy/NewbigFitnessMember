package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;
/**
 * Created by LiuShengYuan on 2018/9/6.
 */

public class MembershipRenewalBean {

    /**
     * Ret : 0
     * Msg :
     * TotalPage : 1
     * rows : [{"EndAmount":10,"Price":0.01,"StartAmount":1},{"EndAmount":0,"Price":0.01,"StartAmount":10}]
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
         * EndAmount : 10
         * Price : 0.01
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
