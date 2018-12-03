package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/6/8
 */

public class PublicSeaBean {


    /**
     * message :
     * result : [{"PublicSeaName":"员工可见","InPublicSeaTime":"2017/06/06 16:52","CustomerId":110,"CustomerName":"15645645","MemberId":null},{"PublicSeaName":"员工可见","InPublicSeaTime":"2017/06/06 16:52","CustomerId":116,"CustomerName":"小鲜肉","MemberId":null},{"PublicSeaName":"员工可见","InPublicSeaTime":"2017/06/06 16:43","CustomerId":118,"CustomerName":"     ","MemberId":null},{"PublicSeaName":"员工可见","InPublicSeaTime":"2017/06/06 16:43","CustomerId":119,"CustomerName":" ","MemberId":null}]
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
         * PublicSeaName : 员工可见
         * InPublicSeaTime : 2017/06/06 16:52
         * CustomerId : 110
         * CustomerName : 15645645
         * MemberId : "'
         */

        private String PublicSeaName;
        private String InPublicSeaTime;
        private int CustomerId;
        private String CustomerName;
        private int MemberType;

        private String Sex;
        private String MemberId;

        public String getSex() {
            return Sex;
        }

        public void setSex(String Sex) {
            this.Sex = Sex;
        }

        public int getMemberType() {
            return MemberType;
        }

        public void setMemberType(int memberType) {
            MemberType = memberType;
        }

        public String getPublicSeaName() {
            return PublicSeaName;
        }

        public void setPublicSeaName(String PublicSeaName) {
            this.PublicSeaName = PublicSeaName;
        }

        public String getInPublicSeaTime() {
            return InPublicSeaTime;
        }

        public void setInPublicSeaTime(String InPublicSeaTime) {
            this.InPublicSeaTime = InPublicSeaTime;
        }

        public int getCustomerId() {
            return CustomerId;
        }

        public void setCustomerId(int CustomerId) {
            this.CustomerId = CustomerId;
        }

        public String getCustomerName() {
            return CustomerName;
        }

        public void setCustomerName(String CustomerName) {
            this.CustomerName = CustomerName;
        }

        public String getMemberId() {
            return MemberId;
        }

        public void setMemberId(String MemberId) {
            this.MemberId = MemberId;
        }
    }
}
