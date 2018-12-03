package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C2;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListActivedBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface IndexFragMentCP2Contract {

    interface View extends BaseView {
        void outLogin();
        void succeed(AppGetMyMemberLessonListActivedBean appGetMyMemberLessonListActivedBean);


    }

    interface Presenter extends BasePresenter<View> {



        void appGetMyMemberLessonListActived(String APPUserId  ,String ClubId  ,String token  ,int PageIndex);

    }
}
