package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */

public class MonthSalesReportByLabelIdBean {


    /**
     * message :
     * result : [{"percent":"35.92","dicName":"轮排WI","saleNum":296033},{"percent":"16.71","dicName":"体验GP","saleNum":137697},{"percent":"14.08","dicName":"约访AP","saleNum":116041},{"percent":"13.61","dicName":"其他OT","saleNum":112157},{"percent":"7.69","dicName":"AP","saleNum":63410},{"percent":"6.04","dicName":"WI","saleNum":49742},{"percent":"4.14","dicName":"BR","saleNum":34156},{"percent":"1","dicName":"DI","saleNum":8264},{"percent":"0.31","dicName":"拉访DI","saleNum":2517},{"percent":"0.25","dicName":"GP","saleNum":2088},{"percent":"0.12","dicName":"转介BR","saleNum":1000},{"percent":"0.12","dicName":"其它","saleNum":988},{"percent":"0","dicName":"低","saleNum":0},{"percent":"0","dicName":"TI","saleNum":0}]
     * code : 0
     */

    private String message;
    private int code;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public static class ResultBean {
        /**
         * percent : 35.92
         * dicName : 轮排WI
         * saleNum : 296033
         */

        private String percent;
        private String dicName;
        private int saleNum;

        public String getPercent() {
            return percent;
        }

        public void setPercent(String percent) {
            this.percent = percent;
        }

        public String getDicName() {
            return dicName;
        }

        public void setDicName(String dicName) {
            this.dicName = dicName;
        }

        public int getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(int saleNum) {
            this.saleNum = saleNum;
        }
    }
}
