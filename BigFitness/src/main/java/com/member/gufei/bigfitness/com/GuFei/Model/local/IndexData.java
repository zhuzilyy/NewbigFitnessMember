package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * @author GuFei
 * @version 2016 10 21 14:17
 */
public class IndexData {

    private String imageUrl;
    private List<DailySpecials> list;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<DailySpecials> getList() {
        return list;
    }

    public void setList(List<DailySpecials> list) {
        this.list = list;
    }
}