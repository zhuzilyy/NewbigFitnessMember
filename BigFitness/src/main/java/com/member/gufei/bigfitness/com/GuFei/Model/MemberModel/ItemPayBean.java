package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/4/12.
 */

public class ItemPayBean {

    private List<PriceListBean> priceList;

    public List<PriceListBean> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<PriceListBean> priceList) {
        this.priceList = priceList;
    }

    public static class PriceListBean {
        /**
         * Price : 260
         * MinAmount : 1
         * MaxAmount : 30000
         */

        private double Price;
        private int MinAmount;
        private int MaxAmount;

        public double getPrice() {
            return Price;
        }

        public void setPrice(double Price) {
            this.Price = Price;
        }

        public int getMinAmount() {
            return MinAmount;
        }

        public void setMinAmount(int MinAmount) {
            this.MinAmount = MinAmount;
        }

        public int getMaxAmount() {
            return MaxAmount;
        }

        public void setMaxAmount(int MaxAmount) {
            this.MaxAmount = MaxAmount;
        }
    }
}
