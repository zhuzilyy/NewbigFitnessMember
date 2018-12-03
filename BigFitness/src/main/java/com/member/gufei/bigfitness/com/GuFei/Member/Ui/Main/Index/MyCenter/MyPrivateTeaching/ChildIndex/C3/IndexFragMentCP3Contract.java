package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C3;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListNotActiveBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface IndexFragMentCP3Contract {

    interface View extends BaseView {
        void outLogin();
        void succeed(AppGetMyMemberLessonListNotActiveBean appGetMyMemberLessonListNotActiveBean);


    }

    interface Presenter extends BasePresenter<View> {



        void appGetMyMemberLessonListNotActive(String APPUserId, String ClubId, String token, int PageIndex);

    }
}
