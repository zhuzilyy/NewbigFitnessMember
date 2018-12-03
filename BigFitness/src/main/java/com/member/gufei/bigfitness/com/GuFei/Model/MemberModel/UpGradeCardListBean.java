package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;
/**
 * Created by LiuShengYuan on 2018/9/10.
 *

 */

public class UpGradeCardListBean {

    /**
     * Ret : 0
     * Msg :
     * rows : [{"MemberCardTypeId":139,"MemberCardTypeName":"单年卡"},{"MemberCardTypeId":276,"MemberCardTypeName":"十年卡"}]
     */

    private int Ret;
    private String Msg;
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

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * MemberCardTypeId : 139
         * MemberCardTypeName : 单年卡
         */

        private int MemberCardTypeId;
        private String MemberCardTypeName;

        public int getMemberCardTypeId() {
            return MemberCardTypeId;
        }

        public void setMemberCardTypeId(int MemberCardTypeId) {
            this.MemberCardTypeId = MemberCardTypeId;
        }

        public String getMemberCardTypeName() {
            return MemberCardTypeName;
        }

        public void setMemberCardTypeName(String MemberCardTypeName) {
            this.MemberCardTypeName = MemberCardTypeName;
        }
    }
}
