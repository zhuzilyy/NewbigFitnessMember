package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C1;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubInfoByIdBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubSaleLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.DistanceClassTimeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.QueryScheduleDayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface IndexFragMentC1Contract {

    interface View extends BaseView {
        void outLogin();

        void succeed(ClubInfoByIdBean clubInfoByIdBean);

        void succeedquan(QueryScheduleDayBean queryScheduleDayBean);

        void succeedClassUp(DistanceClassTimeBean distanceClassTimeBean);

        void succeedClassDown(DistanceClassTimeBean distanceClassTimeBean);


    }

    interface Presenter extends BasePresenter<View> {
        void clubInfoById(String ClubId  ,String APPUserId  ,String token);

        //悬浮按钮
        void quanquan(String APPUserId, String ClubId, String Token, String AppointmentStartDate, String AppointmentEndDate, String quanquan);

        //距离上课时间倒计时
        void getClassTime(String APPUserId  ,String Token  ,String ClubId  ,String LessonId  ,String AppointmentId);
    }
}
