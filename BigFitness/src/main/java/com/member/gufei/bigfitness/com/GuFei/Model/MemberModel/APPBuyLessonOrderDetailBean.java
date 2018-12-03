package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;
/**
 * Created by LiuShengYuan on 2018/9/13.
 * 我的私教课购买订单详情
 */

public class APPBuyLessonOrderDetailBean {

    /**
     * Ret : 0
     * Msg :
     * rows : {"Status":"4","Amount":1,"CreateTime":"2018-09-13","TotalMoney":1,"OrderId":"0420180913132731043","LessonName":"减脂课","PayMode":1,"TeacherName":"郭小晏","RealRefundTime":""}
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
         * Status : 4
         * Amount : 1
         * CreateTime : 2018-09-13
         * TotalMoney : 1
         * OrderId : 0420180913132731043
         * LessonName : 减脂课
         * PayMode : 1
         * TeacherName : 郭小晏
         * RealRefundTime :
         */

        private String Status;
        private int Amount;
        private String CreateTime;
        private int TotalMoney;
        private String OrderId;
        private String LessonName;
        private int PayMode;
        private String TeacherName;
        private String RealRefundTime;

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public int getAmount() {
            return Amount;
        }

        public void setAmount(int Amount) {
            this.Amount = Amount;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getTotalMoney() {
            return TotalMoney;
        }

        public void setTotalMoney(int TotalMoney) {
            this.TotalMoney = TotalMoney;
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

        public int getPayMode() {
            return PayMode;
        }

        public void setPayMode(int PayMode) {
            this.PayMode = PayMode;
        }

        public String getTeacherName() {
            return TeacherName;
        }

        public void setTeacherName(String TeacherName) {
            this.TeacherName = TeacherName;
        }

        public String getRealRefundTime() {
            return RealRefundTime;
        }

        public void setRealRefundTime(String RealRefundTime) {
            this.RealRefundTime = RealRefundTime;
        }
    }
}
