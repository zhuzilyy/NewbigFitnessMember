package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/3/27.
 *
 * #获取我的私教课列表

 */

public class AppGetMyMemberLessonListBean {


    /**
     * Ret : 0
     * rows : {"TotalPage":2,"MyLessonList":[{"Status":0,"ImageURL":"","Id":1610,"OrderId":"","LessonName":"220私教"},{"Status":0,"ImageURL":"","Id":1609,"OrderId":"","LessonName":"220私教"},{"Status":0,"ImageURL":"","Id":1608,"OrderId":"","LessonName":"220私教"},{"Status":0,"ImageURL":"","Id":1607,"OrderId":"","LessonName":"220私教"},{"Status":0,"ImageURL":"","Id":1606,"OrderId":"","LessonName":"220私教"},{"Status":0,"ImageURL":"","Id":1605,"OrderId":"","LessonName":"220私教"},{"Status":6,"ImageURL":"","Id":0,"OrderId":"20180208135026091","LessonName":"180私教"},{"Status":6,"ImageURL":"","Id":0,"OrderId":"20180208035526091","LessonName":"运动健身"},{"Status":4,"ImageURL":"","Id":0,"OrderId":"20180208130026091","LessonName":"240私教"},{"Status":0,"ImageURL":"","Id":1595,"OrderId":"","LessonName":"减脂"}]}
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
         * TotalPage : 2
         * MyLessonList : [{"Status":0,"ImageURL":"","Id":1610,"OrderId":"","LessonName":"220私教"},{"Status":0,"ImageURL":"","Id":1609,"OrderId":"","LessonName":"220私教"},{"Status":0,"ImageURL":"","Id":1608,"OrderId":"","LessonName":"220私教"},{"Status":0,"ImageURL":"","Id":1607,"OrderId":"","LessonName":"220私教"},{"Status":0,"ImageURL":"","Id":1606,"OrderId":"","LessonName":"220私教"},{"Status":0,"ImageURL":"","Id":1605,"OrderId":"","LessonName":"220私教"},{"Status":6,"ImageURL":"","Id":0,"OrderId":"20180208135026091","LessonName":"180私教"},{"Status":6,"ImageURL":"","Id":0,"OrderId":"20180208035526091","LessonName":"运动健身"},{"Status":4,"ImageURL":"","Id":0,"OrderId":"20180208130026091","LessonName":"240私教"},{"Status":0,"ImageURL":"","Id":1595,"OrderId":"","LessonName":"减脂"}]
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
             * Status : 0
             * LessonId: 30
             * OnlineAddFeeMinAmount: 15
             * ImageURL :
             * Id : 1610
             * OrderId :
             * LessonName : 220私教
             */

            private int Status;
            private int LessonId;
            private int OnlineAddFeeMinAmount;
            private String ImageURL;
            private int Id;
            private String OrderId;
            private String LessonName;

            public int getStatus() {
                return Status;
            }

            public void setStatus(int Status) {
                this.Status = Status;
            }

            public int getLessonId() {
                return LessonId;
            }

            public void setLessonId(int lessonId) {
                LessonId = lessonId;
            }

            public int getOnlineAddFeeMinAmount() {
                return OnlineAddFeeMinAmount;
            }

            public void setOnlineAddFeeMinAmount(int onlineAddFeeMinAmount) {
                OnlineAddFeeMinAmount = onlineAddFeeMinAmount;
            }

            public String getImageURL() {
                return ImageURL;
            }

            public void setImageURL(String ImageURL) {
                this.ImageURL = ImageURL;
            }

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
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
