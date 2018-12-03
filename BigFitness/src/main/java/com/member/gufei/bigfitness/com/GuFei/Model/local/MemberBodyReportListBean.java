package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/6/16
 */

public class MemberBodyReportListBean {


    /**
     * message :
     * result : [{"createtime":"2017-06-14 17:31:25","memberid":18,"bodyreportid":2,"reporttime":"2017-06-14 17:31:25","clubid":1,"createuserid":10,"reporturl":"uploadFiles/uploadImgs/20170614/54be9103b31d44fb8456530552cf1970.jpg"}]
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
         * createtime : 2017-06-14 17:31:25
         * memberid : 18
         * bodyreportid : 2
         * reporttime : 2017-06-14 17:31:25
         * clubid : 1
         * createuserid : 10
         * reporturl : uploadFiles/uploadImgs/20170614/54be9103b31d44fb8456530552cf1970.jpg
         */

        private String createtime;
        private int memberid;
        private int bodyreportid;
        private String reporttime;
        private int clubid;
        private int createuserid;
        private String reporturl;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getMemberid() {
            return memberid;
        }

        public void setMemberid(int memberid) {
            this.memberid = memberid;
        }

        public int getBodyreportid() {
            return bodyreportid;
        }

        public void setBodyreportid(int bodyreportid) {
            this.bodyreportid = bodyreportid;
        }

        public String getReporttime() {
            return reporttime;
        }

        public void setReporttime(String reporttime) {
            this.reporttime = reporttime;
        }

        public int getClubid() {
            return clubid;
        }

        public void setClubid(int clubid) {
            this.clubid = clubid;
        }

        public int getCreateuserid() {
            return createuserid;
        }

        public void setCreateuserid(int createuserid) {
            this.createuserid = createuserid;
        }

        public String getReporturl() {
            return reporturl;
        }

        public void setReporturl(String reporturl) {
            this.reporturl = reporturl;
        }
    }
}
