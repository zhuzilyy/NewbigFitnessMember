package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/4/11
 */

public class MessageslistBean {


    /**
     * message :
     * result : [{"MessageId":6,"CreateTime":"2017/07/07 16:50","IsRead":0,"UserName":"Aaron","Title":"test002"}]
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
         * MessageId : 6
         * CreateTime : 2017/07/07 16:50
         * IsRead : 0
         * UserName : Aaron
         * Title : test002
         */

        private int MessageId;
        private String CreateTime;
        private int IsRead;
        private String UserName;
        private String Title;

        public int getMessageId() {
            return MessageId;
        }

        public void setMessageId(int MessageId) {
            this.MessageId = MessageId;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getIsRead() {
            return IsRead;
        }

        public void setIsRead(int IsRead) {
            this.IsRead = IsRead;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }
    }
}
