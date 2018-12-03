package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.AddReservationClass.AddReservation;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubFLessonListBean;

public interface AddReservationActivityContract {

    interface View extends BaseView{

        void outLogin();

        void succeed(ClubFLessonListBean clubFLessonListBean);
    }

    interface Presenter extends BasePresenter<View>{

        void getClubFLessonList(String APPUserId  ,String Token  ,String ClubId  ,String LessonDate  ,String StartTime  ,int PageIndex);
    }
}
