package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyCourseFragment.MyOthersFragment;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyCourseFragment.MyGymnasticsFragment.MyGymnasticsFragmentContract;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyOthersAppointmentBean;

/**
 * Created by LiuShengYuan 2018/9/20
 */

public interface MyOthersFragmentContract {
    interface View extends BaseView{
        void outLogin();

        void succeed(MyOthersAppointmentBean myOthersAppointmentBean);

        void succeedSubmit(CodeBean codeBean);

        void succeedCancel(CodeBean codeBean);
    }

    interface Presenter extends BasePresenter<View>{

        void getMyOthersAppointmentList(String APPUserId  ,String ClubId  ,String Token  ,int PageIndex, int PageSize);
        //确认预约
        void getMyOthersSubmit(String APPUserId  ,String ClubId  ,String Token  ,String MemberId  ,String AppointmentId);
        //取消预约
        void getMyOthersCancel(String APPUserId  ,String ClubId  ,String Token  ,String MemberId  ,String AppointmentId);
    }
}
