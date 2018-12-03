package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/6/10.
 */

public class ConsumptionRecordBean {

    /**
     * Ret : 0
     * Msg :
     * TotalPage : 1
     * ConsumptionMoney : 111100
     * rows : [{"Status":1,"ConsumptionType":"会员卡购买","CreateTime":"2018/03/30 11:15","ClassName":"单年卡","TotalMoney":1000,"OrderId":"4","IsRefund":0},{"Status":1,"ConsumptionType":"会员卡购买","CreateTime":"2018/03/30 11:15","ClassName":"单年卡","TotalMoney":2000,"OrderId":"2","IsRefund":1},{"Status":1,"ConsumptionType":"会员卡购买","CreateTime":"2018/03/30 11:14","ClassName":"10天","TotalMoney":100,"OrderId":"1","IsRefund":0},{"Status":5,"ConsumptionType":"私教课购买","CreateTime":"2018/02/08 17:05","ClassName":"220私教","TotalMoney":100000,"OrderId":"20181212121212121","IsRefund":0},{"Status":5,"ConsumptionType":"私教课购买","CreateTime":"2018/02/05 15:05","ClassName":"180私教","TotalMoney":3000,"OrderId":"20180208135026091","IsRefund":1},{"Status":5,"ConsumptionType":"私教课购买","CreateTime":"2018/02/04 15:05","ClassName":"运动健身","TotalMoney":5000,"OrderId":"20180208035526091","IsRefund":0},{"Status":5,"ConsumptionType":"私教课购买","CreateTime":"2018/02/03 15:05","ClassName":"减脂","TotalMoney":3000,"OrderId":"20180208135526099","IsRefund":1},{"Status":5,"ConsumptionType":"私教课购买","CreateTime":"2018/02/02 15:05","ClassName":"260私教","TotalMoney":2000,"OrderId":"20180208235526091","IsRefund":0},{"Status":5,"ConsumptionType":"私教课购买","CreateTime":"2018/02/01 15:05","ClassName":"200私教","TotalMoney":1000,"OrderId":"20180208135526991","IsRefund":0},{"Status":5,"ConsumptionType":"私教课购买","CreateTime":"2018/01/31 15:05","ClassName":"240私教","TotalMoney":2000,"OrderId":"20180208130026091","IsRefund":0}]
     */

    private int Ret;
    private String Msg;
    private int TotalPage;
    private int ConsumptionMoney;
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

    public int getTotalPage() {
        return TotalPage;
    }

    public void setTotalPage(int TotalPage) {
        this.TotalPage = TotalPage;
    }

    public int getConsumptionMoney() {
        return ConsumptionMoney;
    }

    public void setConsumptionMoney(int ConsumptionMoney) {
        this.ConsumptionMoney = ConsumptionMoney;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * Status : 1
         * ConsumptionType : 会员卡购买
         * CreateTime : 2018/03/30 11:15
         * ClassName : 单年卡
         * TotalMoney : 1000
         * OrderId : 4
         * IsRefund : 0
         */

        private int Status;
        private String ConsumptionType;
        private String CreateTime;

        public Double getTotalMoney() {
            return TotalMoney;
        }

        public void setTotalMoney(Double totalMoney) {
            TotalMoney = totalMoney;
        }

        private String ClassName;
        private Double TotalMoney;
        private String OrderId;
        private int IsRefund;

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getConsumptionType() {
            return ConsumptionType;
        }

        public void setConsumptionType(String ConsumptionType) {
            this.ConsumptionType = ConsumptionType;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getClassName() {
            return ClassName;
        }

        public void setClassName(String ClassName) {
            this.ClassName = ClassName;
        }


        public String getOrderId() {
            return OrderId;
        }

        public void setOrderId(String OrderId) {
            this.OrderId = OrderId;
        }

        public int getIsRefund() {
            return IsRefund;
        }

        public void setIsRefund(int IsRefund) {
            this.IsRefund = IsRefund;
        }
    }
}
