package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/4/12.
 */

public class ClubLessonDetailBean {
    /**
     * Ret : 0
     * Msg :
     * rows : {"Introduce":"这个课能上天这个课能上天这个课能上天","teacherList":"郭富城,黎明","OnlineBuyMinAmount":1,"LessonName":"减脂课","imageList":"uploadFiles/uploadImgs/20180809/aaf4257466ac464685a32e582823d94e.jpg,uploadFiles/uploadImgs/20180809/c763e4ea2ef94b6fbe8852218b0bf836.jpg,uploadFiles/uploadImgs/20180809/95ffa2594ed746fbb12e014ce5be9adc.jpg","AvgStarLevel":4.5,"TotalEvalCount":8,"priceList":[{"Price":0.1,"MinAmount":1,"MaxAmount":50},{"Price":0.2,"MinAmount":51,"MaxAmount":100},{"Price":0.3,"MinAmount":101,"MaxAmount":1000}]}
     */

    private int Ret;
    private String Msg;
    private RowsBean rows;

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

    public RowsBean getRows() {
        return rows;
    }

    public void setRows(RowsBean rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * Introduce : 这个课能上天这个课能上天这个课能上天
         * teacherList : 郭富城,黎明
         * OnlineBuyMinAmount : 1
         * LessonName : 减脂课
         * imageList : uploadFiles/uploadImgs/20180809/aaf4257466ac464685a32e582823d94e.jpg,uploadFiles/uploadImgs/20180809/c763e4ea2ef94b6fbe8852218b0bf836.jpg,uploadFiles/uploadImgs/20180809/95ffa2594ed746fbb12e014ce5be9adc.jpg
         * AvgStarLevel : 4.5
         * TotalEvalCount : 8
         * priceList : [{"Price":0.1,"MinAmount":1,"MaxAmount":50},{"Price":0.2,"MinAmount":51,"MaxAmount":100},{"Price":0.3,"MinAmount":101,"MaxAmount":1000}]
         */

        private String Introduce;
        private String teacherList;
        private int OnlineBuyMinAmount;
        private String LessonName;
        private String imageList;
        private double AvgStarLevel;
        private int TotalEvalCount;
        private int IsBuy;
        private List<PriceListBean> priceList;

        public String getIntroduce() {
            return Introduce;
        }

        public void setIntroduce(String Introduce) {
            this.Introduce = Introduce;
        }

        public String getTeacherList() {
            return teacherList;
        }

        public void setTeacherList(String teacherList) {
            this.teacherList = teacherList;
        }

        public int getOnlineBuyMinAmount() {
            return OnlineBuyMinAmount;
        }

        public void setOnlineBuyMinAmount(int OnlineBuyMinAmount) {
            this.OnlineBuyMinAmount = OnlineBuyMinAmount;
        }

        public int getIsBuy() {
            return IsBuy;
        }

        public void setIsBuy(int isBuy) {
            IsBuy = isBuy;
        }

        public String getLessonName() {
            return LessonName;
        }

        public void setLessonName(String LessonName) {
            this.LessonName = LessonName;
        }

        public String getImageList() {
            return imageList;
        }

        public void setImageList(String imageList) {
            this.imageList = imageList;
        }

        public double getAvgStarLevel() {
            return AvgStarLevel;
        }

        public void setAvgStarLevel(double AvgStarLevel) {
            this.AvgStarLevel = AvgStarLevel;
        }

        public int getTotalEvalCount() {
            return TotalEvalCount;
        }

        public void setTotalEvalCount(int TotalEvalCount) {
            this.TotalEvalCount = TotalEvalCount;
        }

        public List<PriceListBean> getPriceList() {
            return priceList;
        }

        public void setPriceList(List<PriceListBean> priceList) {
            this.priceList = priceList;
        }

        public static class PriceListBean {
            /**
             * Price : 0.1
             * MinAmount : 1
             * MaxAmount : 50
             */

            private double Price;
            private int MinAmount;
            private int MaxAmount;

            public double getPrice() {
                return Price;
            }

            public void setPrice(double Price) {
                this.Price = Price;
            }

            public int getMinAmount() {
                return MinAmount;
            }

            public void setMinAmount(int MinAmount) {
                this.MinAmount = MinAmount;
            }

            public int getMaxAmount() {
                return MaxAmount;
            }

            public void setMaxAmount(int MaxAmount) {
                this.MaxAmount = MaxAmount;
            }
        }
    }


//    /**
//     * Ret : 0
//     * Msg :
//     * rows : {"Introduce":"","teacherList":"刘东东,卢霖,吴浩诚,姚佳,王十,田玉银,米豪杰,谭士强","OnlineBuyMinAmount":0,"LessonName":"260私教","imageList":"","AvgStarLevel":3.7,"TotalEvalCount":3,"priceList":[{"Price":260,"MinAmount":1,"MaxAmount":30000}]}
//     */
//
//    private int Ret;
//    private String Msg;
//    private RowsBean rows;
//
//    public int getRet() {
//        return Ret;
//    }
//
//    public void setRet(int Ret) {
//        this.Ret = Ret;
//    }
//
//    public String getMsg() {
//        return Msg;
//    }
//
//    public void setMsg(String Msg) {
//        this.Msg = Msg;
//    }
//
//    public RowsBean getRows() {
//        return rows;
//    }
//
//    public void setRows(RowsBean rows) {
//        this.rows = rows;
//    }
//
//    public static class RowsBean {
//        /**
//         * Introduce :
//         * teacherList : 刘东东,卢霖,吴浩诚,姚佳,王十,田玉银,米豪杰,谭士强
//         * OnlineBuyMinAmount : 0
//         * LessonName : 260私教
//         * imageList :
//         * AvgStarLevel : 3.7
//         * TotalEvalCount : 3
//         * priceList : [{"Price":260,"MinAmount":1,"MaxAmount":30000}]
//         */
//
//        private String Introduce;
//        private String teacherList;
//        private int OnlineBuyMinAmount;
//        private String LessonName;
//        private String imageList;
//        private double AvgStarLevel;
//        private int TotalEvalCount;
//        private List<PriceListBean> priceList;
//
//        public String getIntroduce() {
//            return Introduce;
//        }
//
//        public void setIntroduce(String Introduce) {
//            this.Introduce = Introduce;
//        }
//
//        public String getTeacherList() {
//            return teacherList;
//        }
//
//        public void setTeacherList(String teacherList) {
//            this.teacherList = teacherList;
//        }
//
//        public int getOnlineBuyMinAmount() {
//            return OnlineBuyMinAmount;
//        }
//
//        public void setOnlineBuyMinAmount(int OnlineBuyMinAmount) {
//            this.OnlineBuyMinAmount = OnlineBuyMinAmount;
//        }
//
//        public String getLessonName() {
//            return LessonName;
//        }
//
//        public void setLessonName(String LessonName) {
//            this.LessonName = LessonName;
//        }
//
//        public String getImageList() {
//            return imageList;
//        }
//
//        public void setImageList(String imageList) {
//            this.imageList = imageList;
//        }
//
//        public double getAvgStarLevel() {
//            return AvgStarLevel;
//        }
//
//        public void setAvgStarLevel(double AvgStarLevel) {
//            this.AvgStarLevel = AvgStarLevel;
//        }
//
//        public int getTotalEvalCount() {
//            return TotalEvalCount;
//        }
//
//        public void setTotalEvalCount(int TotalEvalCount) {
//            this.TotalEvalCount = TotalEvalCount;
//        }
//
//        public List<PriceListBean> getPriceList() {
//            return priceList;
//        }
//
//        public void setPriceList(List<PriceListBean> priceList) {
//            this.priceList = priceList;
//        }
//
//        public static class PriceListBean {
//            /**
//             * Price : 260
//             * MinAmount : 1
//             * MaxAmount : 30000
//             */
//
//            private int Price;
//            private int MinAmount;
//            private int MaxAmount;
//
//            public int getPrice() {
//                return Price;
//            }
//
//            public void setPrice(int Price) {
//                this.Price = Price;
//            }
//
//            public int getMinAmount() {
//                return MinAmount;
//            }
//
//            public void setMinAmount(int MinAmount) {
//                this.MinAmount = MinAmount;
//            }
//
//            public int getMaxAmount() {
//                return MaxAmount;
//            }
//
//            public void setMaxAmount(int MaxAmount) {
//                this.MaxAmount = MaxAmount;
//            }
//        }
//    }
}
