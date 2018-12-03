package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/6/8.
 */

public class ClubOnlineSaleMemberCardListBean {

    /**
     * Ret : 0
     * Msg :
     * TotalPage : 4
     * rows : [{"isbuy":0,"membercardtypeid":34,"ConsumeType":1,"MemberCardTypeName":"10天","ImageURL":""},{"isbuy":0,"membercardtypeid":35,"ConsumeType":1,"MemberCardTypeName":"16个月卡","ImageURL":""},{"isbuy":0,"membercardtypeid":36,"ConsumeType":1,"MemberCardTypeName":"18个月","ImageURL":""},{"isbuy":0,"membercardtypeid":37,"ConsumeType":1,"MemberCardTypeName":"20个月","ImageURL":""},{"isbuy":0,"membercardtypeid":38,"ConsumeType":1,"MemberCardTypeName":"50天卡","ImageURL":""},{"isbuy":0,"membercardtypeid":39,"ConsumeType":1,"MemberCardTypeName":"半年卡","ImageURL":""},{"isbuy":0,"membercardtypeid":40,"ConsumeType":1,"MemberCardTypeName":"半月卡","ImageURL":""},{"isbuy":0,"membercardtypeid":41,"ConsumeType":1,"MemberCardTypeName":"单年卡","ImageURL":""},{"isbuy":0,"membercardtypeid":42,"ConsumeType":1,"MemberCardTypeName":"单月卡","ImageURL":""},{"isbuy":0,"membercardtypeid":43,"ConsumeType":1,"MemberCardTypeName":"季卡","ImageURL":""}]
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
         * isbuy : 0
         * membercardtypeid : 34
         * ConsumeType : 1
         * MemberCardTypeName : 10天
         * ImageURL :
         */

        private int isbuy;
        private int membercardtypeid;
        private int ConsumeType;
        private String MemberCardTypeName;
        private String ImageURL;

        public int getIsbuy() {
            return isbuy;
        }

        public void setIsbuy(int isbuy) {
            this.isbuy = isbuy;
        }

        public int getMembercardtypeid() {
            return membercardtypeid;
        }

        public void setMembercardtypeid(int membercardtypeid) {
            this.membercardtypeid = membercardtypeid;
        }

        public int getConsumeType() {
            return ConsumeType;
        }

        public void setConsumeType(int ConsumeType) {
            this.ConsumeType = ConsumeType;
        }

        public String getMemberCardTypeName() {
            return MemberCardTypeName;
        }

        public void setMemberCardTypeName(String MemberCardTypeName) {
            this.MemberCardTypeName = MemberCardTypeName;
        }

        public String getImageURL() {
            return ImageURL;
        }

        public void setImageURL(String ImageURL) {
            this.ImageURL = ImageURL;
        }
    }
}
