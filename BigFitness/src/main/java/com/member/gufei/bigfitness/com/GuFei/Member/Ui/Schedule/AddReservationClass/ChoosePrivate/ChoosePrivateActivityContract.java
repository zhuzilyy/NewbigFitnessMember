package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.AddReservationClass.ChoosePrivate;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListActivedBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface ChoosePrivateActivityContract {

    interface View extends BaseView {    void outLogin();

        /**
         *成功
         */
        void succeed(AppGetMyMemberLessonListActivedBean appGetMyMemberLessonListActivedBean);




    }

    interface Presenter extends BasePresenter<View> {


        void appGetMyMemberLessonListActived(String APPUserId  ,String ClubId  ,String token  ,int PageIndex);




    }
}
