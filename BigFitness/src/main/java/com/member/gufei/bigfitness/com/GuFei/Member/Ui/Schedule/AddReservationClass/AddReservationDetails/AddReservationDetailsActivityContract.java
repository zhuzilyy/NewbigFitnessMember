package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.AddReservationClass.AddReservationDetails;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;

import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface AddReservationDetailsActivityContract {

    interface View extends BaseView {    void outLogin();

        /**
         *成功
         */
        void succeed(CodeBean codeBean);




    }

    interface Presenter extends BasePresenter<View> {


        void AddMemberLessonAppointment(String APPUserId  ,
                                        String ClubId  ,
                                        String MemberId  ,
                                        String LessonId  ,
                                        String AppointmentTeacherId  ,
                                        String Content  ,
                                        String token  ,
                                        String StartTime  ,
                                        String EndTime  ,
                                        String TipStartTime  ,
                                        String TipInterval  ,
                                        String AppointmentCata  ,
                                        String AppointmentOwner  ,
                                        String AppointmentStatus
                                      );


    }
}
