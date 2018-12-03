package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/3/27.
 * #获取我的私教课列表——未激活
 */

public class AppGetMyMemberLessonListNotActiveBean {

    /**
     * Ret : 0
     * rows : {"TotalPage":1,"MyLessonList":[{"Status":4,"LessonId":30,"OnlineAddFeeMinAmount":15,"ImageURL":"","Id":0,"OrderId":"0420180913132731043","LessonName":"减脂课"}]}
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
         * MyLessonList : [{"Status":4,"LessonId":30,"OnlineAddFeeMinAmount":15,"ImageURL":"","Id":0,"OrderId":"0420180913132731043","LessonName":"减脂课"}]
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
             * Status : 4
             * LessonId : 30
             * OnlineAddFeeMinAmount : 15
             * ImageURL :
             * Id : 0
             * OrderId : 0420180913132731043
             * LessonName : 减脂课
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

            public void setLessonId(int LessonId) {
                this.LessonId = LessonId;
            }

            public int getOnlineAddFeeMinAmount() {
                return OnlineAddFeeMinAmount;
            }

            public void setOnlineAddFeeMinAmount(int OnlineAddFeeMinAmount) {
                this.OnlineAddFeeMinAmount = OnlineAddFeeMinAmount;
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
