package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.ReservationClass.ReservationClassDetails;

import com.member.gufei.bigfitness.ResBean;
import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClassAppointmentBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface ReservationClassDetailsActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(ResBean publicSeaBean);
//        void succeedEdit(ResBean codeBean);
//        void succeedoperate();
//
//        void membersucceed(ResBean publicSeaBean);
        void classsucceed(ClassAppointmentBean classAppointmentBean);
    }

    interface Presenter extends BasePresenter<View> {


        void getClubFreeLessonInfo(String ClubId, String Token, String APPUserId, String FLessonId, String StartTime, String LessonDate);

        //操课预约按钮
        void getClassAppointment(String APPUserId, String Token, String ClubId, String FLessonId, String MemberId, String LessonDate);
    }


}
