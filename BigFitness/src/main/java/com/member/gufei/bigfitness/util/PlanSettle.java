package com.member.gufei.bigfitness.util;

import com.member.gufei.bigfitness.com.GuFei.Model.PlanArrBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.LessonInfoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GuFei on 2017/6/18.
 * 训练部位数据处理类
 *
 */

public class PlanSettle {

    /**
     * 解决本地训练部位与服务器格式不统一
     ** @param lessonInfoBean 服务器训练部位信息;
     * @return list  本地数据格式
     */
    public static PlanArrBean PlanSettle2Bean(LessonInfoBean lessonInfoBean) {


        PlanArrBean planArrBean = new PlanArrBean();


        List<PlanArrBean.ArrBean> Alist = new ArrayList<PlanArrBean.ArrBean>();


        PlanArrBean.ArrBean arrBean = new PlanArrBean.ArrBean();


        List<Integer> PositionIdList = new ArrayList<>();
        List<String> ActionIdList = new ArrayList<>();
        for (int i = 0; i < lessonInfoBean.getResult().getTrainPlanList().size(); i++) {
            if (!PositionIdList.contains(lessonInfoBean.getResult().getTrainPlanList().get(i).getPositionId())) {
                PositionIdList.add(lessonInfoBean.getResult().getTrainPlanList().get(i).getPositionId());
            }
        }

        for (int j = 0; j < PositionIdList.size(); j++) {

            arrBean.setId(lessonInfoBean.getResult().getTrainPlanList().get(j).getPositionId());

            arrBean.setName(lessonInfoBean.getResult().getTrainPlanList().get(j).getPositionName());

            List<PlanArrBean.ArrBean.ListBean> list = new ArrayList<PlanArrBean.ArrBean.ListBean>();

            for (int i = 0; i < lessonInfoBean.getResult().getTrainPlanList().size(); i++) {
                PlanArrBean.ArrBean.ListBean listbaean = new PlanArrBean.ArrBean.ListBean();
                 if (lessonInfoBean.getResult().getTrainPlanList().get(i).getPositionId() == PositionIdList.get(j)) {
                    listbaean.setActionId(lessonInfoBean.getResult().getTrainPlanList().get(i).getActionId());
                    listbaean.setActionName(lessonInfoBean.getResult().getTrainPlanList().get(i).getActionName());
                    listbaean.setAmount(lessonInfoBean.getResult().getTrainPlanList().get(i).getAmount());
                    listbaean.setGroupCount(lessonInfoBean.getResult().getTrainPlanList().get(i).getGroupCount());
                    list.add(listbaean);
                }
                arrBean.setList(list);


            }
            Alist.add(arrBean);



        }
        planArrBean.setArr(Alist);

        return planArrBean;
    }
}
