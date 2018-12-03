package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.NoActive.DetailsRefunding;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyAPPBuyCardOrderDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MyCardDetailsRefundingActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(AppGetMyAPPBuyCardOrderDetailBean appGetMyAPPBuyCardOrderDetailBean);
        void Refundsucceed(CodeBean codeBean);
    }

    interface Presenter extends BasePresenter<View> {
        void appGetMyAPPBuyCardOrderDetail(String APPUserId, String ClubId, String Token, String OrderId, String Status);
        void appMyMemberCardApplyRefund(String APPUserId, String ClubId, String Token, String OrderId);

    }

}
