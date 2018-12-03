package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;
/**
 * Created by LiuShengYuan on 2018/9/11.
 *

 */

public class MemberCardOnlineUpInfoBean {

    /**
     * Ret : 0
     * Msg :
     * rows : {"DifferenceDay":355,"DifferencePrice":999.9,"NewExpireTime":"2019-08-31"}
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
         * DifferenceDay : 355
         * DifferencePrice : 999.9
         * NewExpireTime : 2019-08-31
         */

        private int DifferenceDay;
        private double DifferencePrice;
        private String NewExpireTime;

        public int getDifferenceDay() {
            return DifferenceDay;
        }

        public void setDifferenceDay(int DifferenceDay) {
            this.DifferenceDay = DifferenceDay;
        }

        public double getDifferencePrice() {
            return DifferencePrice;
        }

        public void setDifferencePrice(double DifferencePrice) {
            this.DifferencePrice = DifferencePrice;
        }

        public String getNewExpireTime() {
            return NewExpireTime;
        }

        public void setNewExpireTime(String NewExpireTime) {
            this.NewExpireTime = NewExpireTime;
        }
    }
}
