package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.WeekViewForWeek;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.QueryScheduleDayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface WeekViewForWeekActivityContract {

    interface View extends BaseView {    void outLogin();

        /**
         *成功
         */
        void Success(CustomerInfoBean customerInfoBean);

        void EditSuccess(CodeBean codeBean);
        void loadData(List<QueryScheduleDayBean.RowsBean> list);


    }

    interface Presenter extends BasePresenter<View> {

        void QueryScheduleDay(String APPUserId  ,String ClubId  ,String Token  ,String AppointmentStartDate  ,String AppointmentEndDate,String isNow);
        /**
         * 获科客户信息
         */
        void getCustomerInfoById(int UserId, String token, int ClubId, String UserName, String CustomerId);
//
        /**
         * 获科客户信息
         */
        void EditCustomer(

                int UserId,
                String token,
                int ClubId,
                String UserName,
                String CustomerName,
                String IntentId,
                String IntroduceMemberId,
                String LabelId,
                String OwnManagerId,
                String Remark,
                String Sex,
                String SourceId,
                String Tel,
                String Presalemembercardtypeid,
                String Presalemoney,
                String CustomerId
        );






    }
}
