package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/7/2.
 */

public class AppointmentListByMonthBean {

    /**
     * message :
     * result : [{"StartTime":"2017/06/01"},{"StartTime":"2017/06/02"},{"StartTime":"2017/06/03"},{"StartTime":"2017/06/04"},{"StartTime":"2017/06/05"},{"StartTime":"2017/06/06"},{"StartTime":"2017/06/07"},{"StartTime":"2017/06/08"},{"StartTime":"2017/06/09"},{"StartTime":"2017/06/10"},{"StartTime":"2017/06/11"},{"StartTime":"2017/06/12"},{"StartTime":"2017/06/15"},{"StartTime":"2017/06/16"},{"StartTime":"2017/06/17"}]
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
         * StartTime : 2017/06/01
         */

        private String StartTime;

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(String StartTime) {
            this.StartTime = StartTime;
        }
    }
}
