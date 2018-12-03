package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/6/19
 */

public class AppointmentListForMemberIdBean {

    /**
     * message :
     * result : [{"createtime":"2017-05-31 10:12:04","appointmenttypename":"续费预约","appointmenttypeid":13,"clubid":1,"createuserid":9,"type":1},{"createtime":"2017-06-08 23:19:54","appointmenttypename":"普通预约","appointmenttypeid":15,"clubid":1,"createuserid":9,"type":1}]
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
         * createtime : 2017-05-31 10:12:04
         * appointmenttypename : 续费预约
         * appointmenttypeid : 13
         * clubid : 1
         * createuserid : 9
         * type : 1
         */

        private String createtime;
        private String appointmenttypename;
        private int appointmenttypeid;
        private int clubid;
        private int createuserid;
        private int type;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getAppointmenttypename() {
            return appointmenttypename;
        }

        public void setAppointmenttypename(String appointmenttypename) {
            this.appointmenttypename = appointmenttypename;
        }

        public int getAppointmenttypeid() {
            return appointmenttypeid;
        }

        public void setAppointmenttypeid(int appointmenttypeid) {
            this.appointmenttypeid = appointmenttypeid;
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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
