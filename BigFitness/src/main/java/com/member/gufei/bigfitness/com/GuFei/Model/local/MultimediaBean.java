package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/4/13
 */

public class MultimediaBean {


    /**
     * message : 0
     * result : [{"ResId":49,"ResURL":"http://192.168.51.165:8080/MaxFit/uploadFiles/uploadImgs/20170602/4b1e904b966948e29a95becc5d47a96e.png","ResType":1},{"ResId":50,"ResURL":"http://192.168.51.165:8080/MaxFit/uploadFiles/uploadImgs/20170602/a01b52c8d0534d429863ac60f88ecc31.png","ResType":1},{"ResId":51,"ResURL":"http://192.168.51.165:8080/MaxFit/uploadFiles/uploadImgs/20170602/8681d0853db242d0ac288fc040c2ebdd.png","ResType":1},{"ResId":52,"ResURL":"http://192.168.51.165:8080/MaxFit/uploadFiles/uploadImgs/20170602/cc8cf2705a884eaf932d720fecb8f462.png","ResType":1}]
     * code : 0
     */

    private String  message;
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
         * ResId : 49
         * ResURL : http://192.168.51.165:8080/MaxFit/uploadFiles/uploadImgs/20170602/4b1e904b966948e29a95becc5d47a96e.png
         * ResType : 1
         */

        private int ResId;
        private String ResURL;
        private int ResType;

        public int getResId() {
            return ResId;
        }

        public void setResId(int ResId) {
            this.ResId = ResId;
        }

        public String getResURL() {
            return ResURL;
        }

        public void setResURL(String ResURL) {
            this.ResURL = ResURL;
        }

        public int getResType() {
            return ResType;
        }

        public void setResType(int ResType) {
            this.ResType = ResType;
        }
    }
}
