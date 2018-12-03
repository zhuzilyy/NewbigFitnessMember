package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/9/22.
 */

public class MemberNumReportBean {

    /**
     * message :
     * result : [{"MemberNum":13,"Detail":"全部会员总数","Type":"5","Title":"会员数"},{"MemberNum":9,"Detail":"会员卡未到期的会员","Type":"6","Title":"未到期会员"},{"MemberNum":4,"Detail":"会员卡到期的会员","Type":"7","Title":"到期会员"},{"MemberNum":1,"Detail":"剩余天数60天的会员","Type":"8","Title":"即将到期"},{"MemberNum":6,"Detail":"30天未签到的会员","Type":"9","Title":"最近未签到"},{"MemberNum":0,"Detail":"最近1周生日的会员","Type":"10","Title":"最近生日"}]
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
         * MemberNum : 13
         * Detail : 全部会员总数
         * Type : 5
         * Title : 会员数
         */

        private int MemberNum;
        private String Detail;
        private String Type;
        private String Title;

        public int getMemberNum() {
            return MemberNum;
        }

        public void setMemberNum(int MemberNum) {
            this.MemberNum = MemberNum;
        }

        public String getDetail() {
            return Detail;
        }

        public void setDetail(String Detail) {
            this.Detail = Detail;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }
    }
}
