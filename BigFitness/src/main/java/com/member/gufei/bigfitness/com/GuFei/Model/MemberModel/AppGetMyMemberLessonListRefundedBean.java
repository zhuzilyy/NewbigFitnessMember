package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/3/27.
 * #获取我的私教课列表——已退款
 */

public class AppGetMyMemberLessonListRefundedBean {


    /**
     * Ret : 0
     * rows : {"TotalPage":1,"MyLessonList":[{"APPUserId":36,"ImageURL":"","OrderId":"20180208135026091","LessonName":"180私教"},{"APPUserId":36,"ImageURL":"","OrderId":"20180208035526091","LessonName":"运动健身"}]}
     */

    private int Ret;
    private RowsBean rows;

    public int getRet() {
        return Ret;
    }

    public void setRet(int Ret) {
        this.Ret = Ret;
    }

    public RowsBean getRows() {
        return rows;
    }

    public void setRows(RowsBean rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * TotalPage : 1
         * MyLessonList : [{"APPUserId":36,"ImageURL":"","OrderId":"20180208135026091","LessonName":"180私教"},{"APPUserId":36,"ImageURL":"","OrderId":"20180208035526091","LessonName":"运动健身"}]
         */

        private int TotalPage;
        private List<MyLessonListBean> MyLessonList;

        public int getTotalPage() {
            return TotalPage;
        }

        public void setTotalPage(int TotalPage) {
            this.TotalPage = TotalPage;
        }

        public List<MyLessonListBean> getMyLessonList() {
            return MyLessonList;
        }

        public void setMyLessonList(List<MyLessonListBean> MyLessonList) {
            this.MyLessonList = MyLessonList;
        }

        public static class MyLessonListBean {
            /**
             * APPUserId : 36
             * ImageURL :
             * OrderId : 20180208135026091
             * LessonName : 180私教
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
}
