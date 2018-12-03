package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C4;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListRefundedBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface IndexFragMentCP4Contract {

    interface View extends BaseView {
        void outLogin();
        void succeed(AppGetMyMemberLessonListRefundedBean appGetMyMemberLessonListRefundedBean);


    }

    interface Presenter extends BasePresenter<View> {

        void appGetMyMemberLessonListRefunded(String APPUserId  ,String ClubId  ,String token  ,int PageIndex);

    }
}
