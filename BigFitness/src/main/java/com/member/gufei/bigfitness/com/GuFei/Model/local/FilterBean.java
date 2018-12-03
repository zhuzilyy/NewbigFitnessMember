package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/6/5
 */

public class FilterBean {


    private List<FilterListBean> FilterList;

    public List<FilterListBean> getFilterList() {
        return FilterList;
    }

    public void setFilterList(List<FilterListBean> FilterList) {
        this.FilterList = FilterList;
    }

    public static class FilterListBean {
        /**
         * Name : admi
         * ID : 1
         * Tel : 133333333
         */

        private String Name;
        private int ID;
        private String Tel;
        private String IsShow ;

        public String getIsShow() {
            return IsShow;
        }

        public void setIsShow(String isShow) {
            IsShow = isShow;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getTel() {
            return Tel;
        }

        public void setTel(String Tel) {
            this.Tel = Tel;
        }
    }
}
