package com.member.gufei.bigfitness.com.GuFei.Model.local;

/**
 * @author GuFei
 * @version 2016 10 21 14:16
 */
public class DailySpecials {

    private int id;
    private String name;
    private int sales;
    private String imageUrl;
    private double price;
    private double vouchers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVouchers() {
        return vouchers;
    }

    public void setVouchers(double vouchers) {
        this.vouchers = vouchers;
    }
}