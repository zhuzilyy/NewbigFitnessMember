package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/9/25.
 */

public class MonthTeacherRankingBean {

    /**
     * message :
     * result : [{"HeaderURL":"","SaleTeacherId":214,"UserName":"米豪杰","SaleMoney":5400,"Sex":1},{"HeaderURL":"","SaleTeacherId":261,"UserName":"姚佳","SaleMoney":3600,"Sex":0},{"HeaderURL":"","SaleTeacherId":457,"UserName":"吴浩诚","SaleMoney":3000,"Sex":1},{"HeaderURL":"","SaleTeacherId":233,"UserName":"王十","SaleMoney":2400,"Sex":1},{"HeaderURL":"","SaleTeacherId":204,"UserName":"刘东东","SaleMoney":1000,"Sex":1},{"HeaderURL":"","SaleTeacherId":469,"UserName":"卢霖","SaleMoney":600,"Sex":1}]
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
         * HeaderURL :
         * SaleTeacherId : 214
         * UserName : 米豪杰
         * SaleMoney : 5400
         * Sex : 1
         */

        private String HeaderURL;
        private int SaleTeacherId;
        private String UserName;
        private int SaleMoney;
        private int Sex;

        public String getHeaderURL() {
            return HeaderURL;
        }

        public void setHeaderURL(String HeaderURL) {
            this.HeaderURL = HeaderURL;
        }

        public int getSaleTeacherId() {
            return SaleTeacherId;
        }

        public void setSaleTeacherId(int SaleTeacherId) {
            this.SaleTeacherId = SaleTeacherId;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public int getSaleMoney() {
            return SaleMoney;
        }

        public void setSaleMoney(int SaleMoney) {
            this.SaleMoney = SaleMoney;
        }

        public int getSex() {
            return Sex;
        }

        public void setSex(int Sex) {
            this.Sex = Sex;
        }
    }
}
