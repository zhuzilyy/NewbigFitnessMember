package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */

public class TrainPositionDropListBean {


    /**
     * message :
     * result : [{"id":1,"name":"胸部","isMy":"0"},{"id":2,"name":"腹部","isMy":"1"}]
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
         * id : 1
         * name : 胸部
         * isMy : 0
         */

        private int id;
        private String name;
        private String isMy;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIsMy() {
            return isMy;
        }

        public void setIsMy(String isMy) {
            this.isMy = isMy;
        }
    }
}
