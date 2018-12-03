package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/3/27.
 * #获取我的私教课列表——未认证
 */

public class NotActiveMemberLessonListBean {

    /**
     * Ret : 0
     * Msg :
     * rows : [{"APPUserId":36,"ImageURL":"","OrderId":"20180208130026091","LessonName":"240私教"}]
     */

    private int Ret;
    private String Msg;
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

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * APPUserId : 36
         * ImageURL :
         * OrderId : 20180208130026091
         * LessonName : 240私教
         */

        private int APPUserId;
        private String ImageURL;
        private String OrderId;
        private String LessonName;

        public int getAPPUserId() {
            return APPUserId;
        }

        public void setAPPUserId(int APPUserId) {
            this.APPUserId = APPUserId;
        }

        public String getImageURL() {
            return ImageURL;
        }

        public void setImageURL(String ImageURL) {
            this.ImageURL = ImageURL;
        }

        public String getOrderId() {
            return OrderId;
        }

        public void setOrderId(String OrderId) {
            this.OrderId = OrderId;
        }

        public String getLessonName() {
            return LessonName;
        }

        public void setLessonName(String LessonName) {
            this.LessonName = LessonName;
        }
    }
}
