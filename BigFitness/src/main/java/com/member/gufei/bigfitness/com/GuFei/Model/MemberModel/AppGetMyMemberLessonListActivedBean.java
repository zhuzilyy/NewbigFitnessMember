package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/3/27.
 * #获取我的私教课列表——已激活
 */

public class AppGetMyMemberLessonListActivedBean {


    /**
     * Ret : 0
     * rows : {"TotalPage":1,"MyLessonList":[{"Status":0,"TotalBuyCount":20,"LessonTeacherId":847,"MemberId":44708,"LessonId":47,"OnlineAddFeeMinAmount":1,"ImageURL":"uploadFiles/uploadImgs/20180910/b836b02732764e1bb0a938c4969efd8b.jpg","Id":2568,"OrderId":"","LessonName":"腹肌有氧","Balance":20,"TeacherName":"施瓦辛格"},{"Status":0,"TotalBuyCount":2,"LessonTeacherId":496,"MemberId":44708,"LessonId":30,"OnlineAddFeeMinAmount":15,"ImageURL":"","Id":2524,"OrderId":"","LessonName":"减脂课","Balance":1,"TeacherName":"郭小晏"}]}
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
         * MyLessonList : [{"Status":0,"TotalBuyCount":20,"LessonTeacherId":847,"MemberId":44708,"LessonId":47,"OnlineAddFeeMinAmount":1,"ImageURL":"uploadFiles/uploadImgs/20180910/b836b02732764e1bb0a938c4969efd8b.jpg","Id":2568,"OrderId":"","LessonName":"腹肌有氧","Balance":20,"TeacherName":"施瓦辛格"},{"Status":0,"TotalBuyCount":2,"LessonTeacherId":496,"MemberId":44708,"LessonId":30,"OnlineAddFeeMinAmount":15,"ImageURL":"","Id":2524,"OrderId":"","LessonName":"减脂课","Balance":1,"TeacherName":"郭小晏"}]
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
             * TotalBuyCount : 20
             * LessonTeacherId : 847
             * MemberId : 44708
             * LessonId : 47
             * OnlineAddFeeMinAmount : 1
             * ImageURL : uploadFiles/uploadImgs/20180910/b836b02732764e1bb0a938c4969efd8b.jpg
             * Id : 2568
             * OrderId :
             * LessonName : 腹肌有氧
             * Balance : 20
             * TeacherName : 施瓦辛格
             */

            private int Status;
            private int TotalBuyCount;
            private int LessonTeacherId;
            private int MemberId;
            private int LessonId;
            private int OnlineAddFeeMinAmount;
            private String ImageURL;
            private int Id;
            private String OrderId;
            private String LessonName;
            private int Balance;
            private String TeacherName;

            public int getStatus() {
                return Status;
            }

            public void setStatus(int Status) {
                this.Status = Status;
            }

            public int getTotalBuyCount() {
                return TotalBuyCount;
            }

            public void setTotalBuyCount(int TotalBuyCount) {
                this.TotalBuyCount = TotalBuyCount;
            }

            public int getLessonTeacherId() {
                return LessonTeacherId;
            }

            public void setLessonTeacherId(int LessonTeacherId) {
                this.LessonTeacherId = LessonTeacherId;
            }

            public int getMemberId() {
                return MemberId;
            }

            public void setMemberId(int MemberId) {
                this.MemberId = MemberId;
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

            public int getBalance() {
                return Balance;
            }

            public void setBalance(int Balance) {
                this.Balance = Balance;
            }

            public String getTeacherName() {
                return TeacherName;
            }

            public void setTeacherName(String TeacherName) {
                this.TeacherName = TeacherName;
            }
        }
    }
}
