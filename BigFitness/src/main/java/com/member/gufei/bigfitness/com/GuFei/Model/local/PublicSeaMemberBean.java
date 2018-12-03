package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/6/8
 */

public class PublicSeaMemberBean {


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

        private String HeaderURL;
        private String AbandonTime;
        private String Tel;
        private String MemberName;

        private String Sex;
        private String MemberId;

        public String getSex() {
            return Sex;
        }

        public void setSex(String Sex) {
            this.Sex = Sex;
        }


        public String getHeaderURL() {
            return HeaderURL;
        }

        public void setHeaderURL(String headerURL) {
            HeaderURL = headerURL;
        }

        public String getAbandonTime() {
            return AbandonTime;
        }

        public void setAbandonTime(String abandonTime) {
            AbandonTime = abandonTime;
        }

        public String getTel() {
            return Tel;
        }

        public void setTel(String tel) {
            Tel = tel;
        }

        public String getMemberName() {
            return MemberName;
        }

        public void setMemberName(String memberName) {
            MemberName = memberName;
        }

        public String getMemberId() {
            return MemberId;
        }

        public void setMemberId(String MemberId) {
            this.MemberId = MemberId;
        }
    }
}
