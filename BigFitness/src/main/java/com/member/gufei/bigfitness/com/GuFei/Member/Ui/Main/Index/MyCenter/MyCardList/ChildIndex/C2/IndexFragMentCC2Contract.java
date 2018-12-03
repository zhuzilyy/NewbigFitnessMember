package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.ChildIndex.C2;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListActivedBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListActivedBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface IndexFragMentCC2Contract {

    interface View extends BaseView {
        void outLogin();
        void succeed(AppGetMyMemberCardListActivedBean appGetMyMemberCardListActivedBean);


    }

    interface Presenter extends BasePresenter<View> {



        void appGetMyMemberCardListActived(String APPUserId  ,String ClubId  ,String Token  ,int currentPage);

    }
}
