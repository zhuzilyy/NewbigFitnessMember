package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/6/17
 */

public class LessonInfoBean {


    /**
     * message :
     * result : {"remainder":"25/27","trainPlanList":[{"GroupCount":1,"PositionName":"胸部","Amount":2,"ActionName":"扩胸","PositionId":1,"ActionId":1},{"GroupCount":3,"PositionName":"胸部","Amount":4,"ActionName":"扩胸","PositionId":1,"ActionId":1}]}
     * code : 0
     */

    private String message;
    private ResultBean result;
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean {
        /**
         * remainder : 25/27
         * trainPlanList : [{"GroupCount":1,"PositionName":"胸部","Amount":2,"ActionName":"扩胸","PositionId":1,"ActionId":1},{"GroupCount":3,"PositionName":"胸部","Amount":4,"ActionName":"扩胸","PositionId":1,"ActionId":1}]
         */

        private String remainder;
        private List<TrainPlanListBean> trainPlanList;

        public String getRemainder() {
            return remainder;
        }

        public void setRemainder(String remainder) {
            this.remainder = remainder;
        }

        public List<TrainPlanListBean> getTrainPlanList() {
            return trainPlanList;
        }

        public void setTrainPlanList(List<TrainPlanListBean> trainPlanList) {
            this.trainPlanList = trainPlanList;
        }

        public static class TrainPlanListBean {
            /**
             * GroupCount : 1
             * PositionName : 胸部
             * Amount : 2
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
