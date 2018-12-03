package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyCourseFragment.MyPrivateFragment;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyLessonAppListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MyPrivateFragmentContract {

    interface View extends BaseView {
        void outLogin();
        void succeed(MyLessonAppListBean myLessonAppListBean);
        void succeedConfirm(CodeBean codeBean);


    }

    interface Presenter extends BasePresenter<View> {
        void getMyLessonAppList(String APPUserId  ,String ClubId  ,String Token  ,int currentPage);
        void confirmLessonAppointment(String APPUserId  ,String ClubId  ,String Token  ,String MemberId  ,String AppointmentId);
        void cancelMemberLessonAppointment(String APPUserId  ,String ClubId  ,String Token  ,String MemberId  ,String AppointmentId  ,String AppointmentStatus);
    }
}
