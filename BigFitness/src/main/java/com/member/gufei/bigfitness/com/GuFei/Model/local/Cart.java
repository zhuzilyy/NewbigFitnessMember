package com.member.gufei.bigfitness.com.GuFei.Model.local;

/**
 * @author GuFei
 * @version 2016 11 16 11:19
 */
public class Cart {

    private int id;
    private String name; // 商品名称
    private String logo; //
    private int count; // 购买数量
    private String spec; // 规格
    private double price; // 单价
    private Integer vouchers; // 积分
    private Integer purchaseCount; // 已购买数量

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getVouchers() {
        return vouchers;
    }

    public void setVouchers(Integer vouchers) {
        this.vouchers = vouchers;
    }

    public Integer getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(Integer purchaseCount) {
        this.purchaseCount = purchaseCount;
    }
}