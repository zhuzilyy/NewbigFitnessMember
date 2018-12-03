package com.member.gufei.bigfitness.com.GuFei.Model.Post;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */

public class ActionBean implements Serializable {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean  implements Serializable{
        /**
         * PositionId : 1
         * ActionId : 1
         * GroupCount : 1
         * Amount : 2
         * PositionName : 胸部
         * ActionName : 扩胸
         */

        private String PositionId;
        private String ActionId;
        private String GroupCount;
        private String Amount;
        private String PositionName;
        private String ActionName;
        private boolean Selected;
        public boolean isSelected() {
            return Selected;
        }

        public void setSelected(boolean selected) {
            Selected = selected;
        }



        public String getPositionId() {
            return PositionId;
        }

        public void setPositionId(String PositionId) {
            this.PositionId = PositionId;
        }

        public String getActionId() {
            return ActionId;
        }

        public void setActionId(String ActionId) {
            this.ActionId = ActionId;
        }

        public String getGroupCount() {
            return GroupCount;
        }

        public void setGroupCount(String GroupCount) {
            this.GroupCount = GroupCount;
        }

        public String getAmount() {
            return Amount;
        }

        public void setAmount(String Amount) {
            this.Amount = Amount;
        }

        public String getPositionName() {
            return PositionName;
        }

        public void setPositionName(String PositionName) {
            this.PositionName = PositionName;
        }

        public String getActionName() {
            return ActionName;
        }

        public void setActionName(String ActionName) {
            this.ActionName = ActionName;
        }
    }
}
