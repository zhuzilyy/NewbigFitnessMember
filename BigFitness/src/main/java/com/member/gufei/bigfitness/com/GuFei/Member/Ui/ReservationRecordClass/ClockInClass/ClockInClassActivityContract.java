package com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.ClockInClass;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CreateLessonQRBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface ClockInClassActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(CreateLessonQRBean createLessonQRBean);

    }

    interface Presenter extends BasePresenter<View> {
        void CreateLessonQR(String APPUserId  ,String ClubId  ,String Token  ,String AppointmentId);
    }
}
