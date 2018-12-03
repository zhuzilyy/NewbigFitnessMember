package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/6/25.
 */

public class HistoryPlanListBean {


    /**
     * message :
     * result : [{"PlanInfoList":[{"GroupCount":1,"PositionName":"胸部","Amount":1,"ActionName":"扩胸","PositionId":1,"ActionId":1}],"CreateTime":"2017/06/22 09:42:49","AppointmentId":69},{"PlanInfoList":[{"GroupCount":1,"PositionName":"腹部","Amount":3,"ActionName":"仰卧起坐","PositionId":2,"ActionId":3},{"GroupCount":4,"PositionName":"腹部","Amount":6,"ActionName":"平板支撑","PositionId":2,"ActionId":4}],"CreateTime":"2017/06/22 10:03:15","AppointmentId":70}]
     * code : 0
     */

    private String message;
    private int code;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * PlanInfoList : [{"GroupCount":1,"PositionName":"胸部","Amount":1,"ActionName":"扩胸","PositionId":1,"ActionId":1}]
         * CreateTime : 2017/06/22 09:42:49
         * AppointmentId : 69
         */

        private String CreateTime;
        private int AppointmentId;
        private List<PlanInfoListBean> PlanInfoList;

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getAppointmentId() {
            return AppointmentId;
        }

        public void setAppointmentId(int AppointmentId) {
            this.AppointmentId = AppointmentId;
        }

        public List<PlanInfoListBean> getPlanInfoList() {
            return PlanInfoList;
        }

        public void setPlanInfoList(List<PlanInfoListBean> PlanInfoList) {
            this.PlanInfoList = PlanInfoList;
        }

        public static class PlanInfoListBean {
            /**
             * GroupCount : 1
             * PositionName : 胸部
             * Amount : 1
             * ActionName : 扩胸
             * PositionId : 1
             * ActionId : 1
             */

            private int GroupCount;
            private String PositionName;
            private int Amount;
            private String ActionName;
            private int PositionId;
            private int ActionId;

            public int getGroupCount() {
                return GroupCount;
            }

            public void setGroupCount(int GroupCount) {
                this.GroupCount = GroupCount;
            }

            public String getPositionName() {
                return PositionName;
            }

            public void setPositionName(String PositionName) {
                this.PositionName = PositionName;
            }

            public int getAmount() {
                return Amount;
            }

            public void setAmount(int Amount) {
                this.Amount = Amount;
            }

            public String getActionName() {
                return ActionName;
            }

            public void setActionName(String ActionName) {
                this.ActionName = ActionName;
            }

            public int getPositionId() {
                return PositionId;
            }

            public void setPositionId(int PositionId) {
                this.PositionId = PositionId;
            }

            public int getActionId() {
                return ActionId;
            }

            public void setActionId(int ActionId) {
                this.ActionId = ActionId;
            }
        }
    }
}
