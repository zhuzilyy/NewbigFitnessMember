package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.WeekViewForDay;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.QueryScheduleDayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.TeacherScheduleDayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface WeekViewForDayActivityContract {

    interface View extends BaseView {    void outLogin();

        /**
         *成功
         */
        void succeed(TeacherScheduleDayBean teacherScheduleDayBean);





    }

    interface Presenter extends BasePresenter<View> {


        void getTeacherScheduleDay(String APPUserId  ,String ClubId  ,String token  ,String AppointmentStartDate  ,String AppointmentEndDate  ,String AppointmentTeacherId);




    }
}
