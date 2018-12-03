package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.ChildIndex.C3;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListNotActiveBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface IndexFragMentCC3Contract {

    interface View extends BaseView {
        void outLogin();
        void succeed(AppGetMyMemberCardListNotActiveBean appGetMyMemberCardListNotActiveBean);


    }

    interface Presenter extends BasePresenter<View> {


        void appGetMyMemberCardListNotActive(String APPUserId, String ClubId, String Token, int currentPage);

    }
}
