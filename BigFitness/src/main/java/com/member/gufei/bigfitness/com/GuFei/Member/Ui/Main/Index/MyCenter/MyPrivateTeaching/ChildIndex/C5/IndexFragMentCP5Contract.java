package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C5;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListRefundedBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.NotActiveMemberLessonListBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface IndexFragMentCP5Contract {

    interface View extends BaseView {
        void outLogin();
        void succeed(NotActiveMemberLessonListBean notActiveMemberLessonListBean);


    }

    interface Presenter extends BasePresenter<View> {

        void getNotActiveMemberLessonList(String APPUserId  ,String ClubId  ,String token  ,int PageIndex);

    }
}
