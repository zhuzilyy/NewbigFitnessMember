package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/4/12.
 */

public class ItemPlanBean {


    private List<PlanListBean> PlanList;

    public List<PlanListBean> getPlanList() {
        return PlanList;
    }

    public void setPlanList(List<PlanListBean> PlanList) {
        this.PlanList = PlanList;
    }

    public static class PlanListBean {
        /**
         * PositionName : 1
         * ActionName : 1
         */

        private String PositionName;
        private String ActionName;

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
