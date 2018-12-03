package com.member.gufei.bigfitness.com.GuFei.Model;

import java.util.List;

/**
 * Created by Administrator on 2017/6/18.
 * 训练计划 部位
 */

public class PlanArrBean {


    private List<ArrBean> arr;

    public List<ArrBean> getArr() {
        return arr;
    }

    public void setArr(List<ArrBean> arr) {
        this.arr = arr;
    }

    public static class ArrBean {
        /**
         * id : 1
         * name : 胸部
         * list : [{"GroupCount":1,"Amount":2,"ActionName":"扩胸","ActionId":1}]
         */

        private int id;
        private String name;
        private List<ListBean> list;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * GroupCount : 1
             * Amount : 2
             * ActionName : 扩胸
             * ActionId : 1
             */

            private int GroupCount;
            private int Amount;
            private String ActionName;
            private int ActionId;

            public int getGroupCount() {
                return GroupCount;
            }

            public void setGroupCount(int GroupCount) {
                this.GroupCount = GroupCount;
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

            public int getActionId() {
                return ActionId;
            }

            public void setActionId(int ActionId) {
                this.ActionId = ActionId;
            }
        }
    }
}
