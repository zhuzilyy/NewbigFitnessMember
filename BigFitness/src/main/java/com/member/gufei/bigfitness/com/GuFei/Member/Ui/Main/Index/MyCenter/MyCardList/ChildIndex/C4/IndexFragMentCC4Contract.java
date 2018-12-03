package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.ChildIndex.C4;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListRefundedBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListRefundedBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface IndexFragMentCC4Contract {

    interface View extends BaseView {
        void outLogin();
        void succeed(AppGetMyMemberCardListRefundedBean appGetMyMemberCardListRefundedBean);


    }

    interface Presenter extends BasePresenter<View> {

        void appGetMyMemberCardListRefunded(String APPUserId  ,String ClubId  ,String Token  ,int currentPage);

    }
}
