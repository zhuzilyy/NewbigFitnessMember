package com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.ReservationRecordList;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.QueryScheduleDayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface ReservationRecordListActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(QueryScheduleDayBean queryScheduleDayBean);

    }

    interface Presenter extends BasePresenter<View> {

        void QueryScheduleDay(String APPUserId  ,String ClubId  ,String Token  ,String AppointmentStartDate  ,String AppointmentEndDate ,String isNow);
    }

}
