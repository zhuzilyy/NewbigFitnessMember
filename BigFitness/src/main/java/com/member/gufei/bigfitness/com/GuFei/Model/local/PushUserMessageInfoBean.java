package com.member.gufei.bigfitness.com.GuFei.Model.local;

/**
 * Created by Administrator on 2017/7/15.
 */

public class PushUserMessageInfoBean {


    /**
     * message :
     * result : {"MessageId":9,"CreateTime":"2017/07/14 17:06","IsRead":0,"UserName":"Aaron","Content":"测试发布消息消息消息测试发布消息消息消息测试发布消息消息消息测试发布消息消息消息测试发布消息消息消息测试发布消息消息消息测试发布消息消息消息测试发布消息消息消息","Title":"测试发布消息消息消息"}
     * code : 0
     */

    private String message;
    private ResultBean result;
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean {
        /**
         * MessageId : 9
         * CreateTime : 2017/07/14 17:06
         * IsRead : 0
         * UserName : Aaron
         * Content : 测试发布消息消息消息测试发布消息消息消息测试发布消息消息消息测试发布消息消息消息测试发布消息消息消息测试发布消息消息消息测试发布消息消息消息测试发布消息消息消息
         * Title : 测试发布消息消息消息
         */

        private int MessageId;
        private String CreateTime;
        private int IsRead;
        private String UserName;
        private String Content;
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

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }
    }
}
