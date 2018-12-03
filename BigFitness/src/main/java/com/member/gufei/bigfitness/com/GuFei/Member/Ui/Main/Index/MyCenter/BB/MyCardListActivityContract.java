package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.BB;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MyCardListActivityContract {

    interface View extends BaseView {
        void outLogin();
        void succeed(AppGetMyMemberCardListBean appGetMyMemberCardListBean);


    }

    interface Presenter extends BasePresenter<MyCardListActivityContract.View> {
        void appGetMyMemberCardList(String APPUserId, String ClubId, String Token, int currentPage);

    }

}
