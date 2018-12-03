package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy;

import java.util.List;

/**
 * Created by LiuShengYuan on 2018/8/23.
 */

public class NoticeListBean {

    /**
     * Ret : 0
     * Msg :
     * UnreadCount : {"LessonMsgCount":3,"PushMsgCount":0,"SystemMsgCount":1}
     * rows : [{"RowId":4,"Content":"内容","CreateTime":"2018-06-28 17:44","Title":"主题","IsRead":1}]
     */

    private int Ret;
    private String Msg;
    private UnreadCountBean UnreadCount;
    private List<RowsBean> rows;

    public int getRet() {
        return Ret;
    }

    public void setRet(int Ret) {
        this.Ret = Ret;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public UnreadCountBean getUnreadCount() {
        return UnreadCount;
    }

    public void setUnreadCount(UnreadCountBean UnreadCount) {
        this.UnreadCount = UnreadCount;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class UnreadCountBean {
        /**
         * LessonMsgCount : 3
         * PushMsgCount : 0
         * SystemMsgCount : 1
         */

        private int LessonMsgCount;
        private int PushMsgCount;
        private int SystemMsgCount;

        public int getLessonMsgCount() {
            return LessonMsgCount;
        }

        public void setLessonMsgCount(int LessonMsgCount) {
            this.LessonMsgCount = LessonMsgCount;
        }

        public int getPushMsgCount() {
            return PushMsgCount;
        }

        public void setPushMsgCount(int PushMsgCount) {
            this.PushMsgCount = PushMsgCount;
        }

        public int getSystemMsgCount() {
            return SystemMsgCount;
        }

        public void setSystemMsgCount(int SystemMsgCount) {
            this.SystemMsgCount = SystemMsgCount;
        }
    }

    public static class RowsBean {
        /**
         * RowId : 4
         * Content : 内容
         * CreateTime : 2018-06-28 17:44
         * Title : 主题
         * IsRead : 1
         */

        private int IsAPPPush;
        private int RowId;
        private String Content;
        private String CreateTime;
        private String Title;
        private int IsRead;

        public int getIsAPPPush() {
            return IsAPPPush;
        }

        public void setIsAPPPush(int isAPPPush) {
            IsAPPPush = isAPPPush;
        }

        public int getRowId() {
            return RowId;
        }

        public void setRowId(int RowId) {
            this.RowId = RowId;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public int getIsRead() {
            return IsRead;
        }

        public void setIsRead(int IsRead) {
            this.IsRead = IsRead;
        }
    }
}
