package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyCourseFragment.MyGymnasticsFragment;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.FreeLessonAppointmentListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MyGymnasticsFragmentContract {

    interface View extends BaseView {
        void outLogin();
        void succeed(FreeLessonAppointmentListBean freeLessonAppointmentListBean);


        void succeedConfirm(CodeBean normalResponse);
    }

    interface Presenter extends BasePresenter<View> {
        void FreeLessonAppointmentList(String APPUserId  ,String ClubId  ,String Token  ,int currentPage  ,String MemberId);
        void cancelMemberFreeLessonAppointment(String APPUserId  ,String ClubId  ,String Token  ,String MemberId  ,String AppointmentId  ,String Cause);
    }
}
