package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyReservationDetails;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyLessonAppDetailBean;

import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MyReservationDetailsActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(MyLessonAppDetailBean myLessonAppDetailBean);

        void succeedConfirm(CodeBean codeBean);

    }

    interface Presenter extends BasePresenter<View> {
        void getMyLessonAppDetail(String APPUserId  ,String ClubId  ,String Token  ,String MemberId  ,String AppointmentId);

        void confirmLessonAppointment(String APPUserId  ,String ClubId  ,String Token  ,String MemberId  ,String AppointmentId);
        void cancelMemberLessonAppointment(String APPUserId  ,String ClubId  ,String Token  ,String MemberId  ,String AppointmentId  ,String AppointmentStatus);
    }

}
