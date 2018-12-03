package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/3/27.
 * #获取私教课续费价格列表
 */

public class MemberLessonAddFeePriceListBean {


    /**
     * Ret : 0
     * rows : [{"EndAmount":20,"Price":10,"StartAmount":5},{"EndAmount":50,"Price":9.5,"StartAmount":21},{"EndAmount":100,"Price":8.5,"StartAmount":51},{"EndAmount":0,"Price":8,"StartAmount":101}]
     */

    private int Ret;
    private List<RowsBean> rows;

    public int getRet() {
        return Ret;
    }

    public void setRet(int Ret) {
        this.Ret = Ret;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * EndAmount : 20
         * Price : 10
         * StartAmount : 5
         */

        private int EndAmount;
        private int Price;
        private int StartAmount;

        public int getEndAmount() {
            return EndAmount;
        }

        public void setEndAmount(int EndAmount) {
            this.EndAmount = EndAmount;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
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
