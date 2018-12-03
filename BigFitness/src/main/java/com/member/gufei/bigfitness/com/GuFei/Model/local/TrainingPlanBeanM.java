package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/5/3
 */

public class TrainingPlanBeanM {


    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {


        /**
         * name : 胸部
         * content : 0哑铃仰卧飞鸟(4组*10)0
         */

        private String PositionId;

        public String getPositionName() {
            return PositionName;
        }

        public void setPositionName(String positionName) {
            PositionName = positionName;
        }

        private String PositionName;


        private String ActionId;

        private String name;

        private String content;

        private String ActionName;

        private String GroupCount;

        private String Amount;



        public String getActionName() {
            return ActionName;
        }

        public void setActionName(String actionName) {
            ActionName = actionName;
        }

        public String getGroupCount() {
            return GroupCount;
        }

        public void setGroupCount(String groupCount) {
            GroupCount = groupCount;
        }

        public String getAmount() {
            return Amount;
        }

        public void setAmount(String amount) {
            Amount = amount;
        }







        public String getPositionId() {
            return PositionId;
        }

        public void setPositionId(String PositionId) {
            this. PositionId = PositionId;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getActionId() {
            return ActionId;
        }

        public void setActionId(String ActionId) {
            this.ActionId = ActionId;
        }
    }
}
