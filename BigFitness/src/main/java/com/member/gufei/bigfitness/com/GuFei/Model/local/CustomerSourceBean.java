package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/6/5
 */

public class CustomerSourceBean {

    /**
     * message : 0
     * result : [{"Name":"客户来源1","ID":5},{"Name":"客户来源2","ID":6}]
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
         * Name : 客户来源1
         * ID : 5
         */

        private String Name;
        private int ID;

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
    }
}
