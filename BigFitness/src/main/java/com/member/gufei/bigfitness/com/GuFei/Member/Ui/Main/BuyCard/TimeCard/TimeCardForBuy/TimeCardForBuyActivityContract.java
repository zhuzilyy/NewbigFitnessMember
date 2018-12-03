package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.BuyCard.TimeCard.TimeCardForBuy;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubMemberCardTypeDetailBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface TimeCardForBuyActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(ClubMemberCardTypeDetailBean clubMemberCardTypeDetailBean);

    }

    interface Presenter extends BasePresenter<View> {
        void getClubMemberCardTypeDetail(String APPUserId  ,String token  ,String ClubId  ,String MemberCardTypeId);

    }

}
