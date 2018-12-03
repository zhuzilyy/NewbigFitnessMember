package com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.TimeForClass;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyReservationDetails.MyReservationDetailsActivityContract;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClassCountdownInfoBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.DistanceClassTimeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyLessonAppDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface TimeForClassActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(MyLessonAppDetailBean myLessonAppDetailBean);

        void succeedClassUp(DistanceClassTimeBean distanceClassTimeBean);

        void succeedClassDown(DistanceClassTimeBean distanceClassTimeBean);

        void succeedClassBegin(ClassCountdownInfoBean classCountdownInfoBean);

    }

    interface Presenter extends BasePresenter<TimeForClassActivityContract.View> {
        void getMyLessonAppDetail(String APPUserId  ,String ClubId  ,String Token  ,String MemberId  ,String AppointmentId);
        //距离上课时间倒计时
        void getClassTime(String APPUserId  ,String Token  ,String ClubId  ,String LessonId  ,String AppointmentId);
        //上课正计时
        void getClassBeginTime(String APPUserId  ,String Token  ,String ClubId  ,String AppointmentId);
    }

}
