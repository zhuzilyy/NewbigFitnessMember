package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.Active.DetailsActive;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyAPPBuyCardOrderDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MyCardDetailsActiveActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(AppGetMyMemberCardDetailBean appGetMyMemberCardDetailBean);
        void Refundsucceed(CodeBean codeBean);
    }

    interface Presenter extends BasePresenter<View> {
        void appGetMyMemberCardDetail(String APPUserId  ,String ClubId  ,String Token  ,String Status  ,String MemberCardId  ,String ConsumeType);
        void appMyMemberCardApplyRefund(String APPUserId, String ClubId, String Token, String OrderId);

    }

}
