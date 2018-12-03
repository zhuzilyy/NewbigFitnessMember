package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.CardIndex;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubOnlineSaleMemberCardListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface CardIndexFragMentContract {

    interface View extends BaseView {
        void outLogin();
        void succeed(ClubOnlineSaleMemberCardListBean clubOnlineSaleMemberCardListBean);


    }

    interface Presenter extends BasePresenter<View> {
        void getClubOnlineSaleMemberCardList(String APPUserId  ,String ClubId  ,String Token  ,int currentPage);

    }
}
