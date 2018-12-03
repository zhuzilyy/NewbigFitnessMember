package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */

public class PersonListBean {


    /**
     * message :
     * result : [{"personId":27,"Tel":"18698841230","personName":"小公举"},{"personId":72,"Tel":"15998887633","personName":"小白3"},{"personId":76,"Tel":"15657894567","personName":"家家"},{"personId":110,"Tel":"13698565253","personName":"导入过期会员测试"}]
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
         * personId : 27
         * Tel : 18698841230
         * personName : 小公举
         */

        private int personId;
        private String Tel;
        private String personName;

        public int getPersonId() {
            return personId;
        }

        public void setPersonId(int personId) {
            this.personId = personId;
        }

        public String getTel() {
            return Tel;
        }

        public void setTel(String Tel) {
            this.Tel = Tel;
        }

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }
    }
}
