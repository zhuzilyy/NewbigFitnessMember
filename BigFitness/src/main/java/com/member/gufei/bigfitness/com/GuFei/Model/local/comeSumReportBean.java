package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */

public class comeSumReportBean {


    /**
     * message :
     * result : [{"MComeCount":0,"cComeCount":"0"}]
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
         * MComeCount : 0
         * cComeCount : 0
         */

        private int MComeCount;
        private String cComeCount;

        public int getMComeCount() {
            return MComeCount;
        }

        public void setMComeCount(int MComeCount) {
            this.MComeCount = MComeCount;
        }

        public String getCComeCount() {
            return cComeCount;
        }

        public void setCComeCount(String cComeCount) {
            this.cComeCount = cComeCount;
        }
    }
}
