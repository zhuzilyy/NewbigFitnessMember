package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.ChildIndex.C1;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface IndexFragMentCC1Contract {

    interface View extends BaseView {
        void outLogin();
        void succeed(AppGetMyMemberCardListBean appGetMyMemberCardListBean);
        void Refundsucceed(CodeBean codeBean);
        void Delsucceed(CodeBean codeBean);
        void SendMsgsucceed(CodeBean codeBean);

    }

    interface Presenter extends BasePresenter<View> {


        void appGetMyMemberCardList(String APPUserId, String ClubId, String Token, int currentPage);
        //退款
        void appMyMemberCardApplyRefund(String APPUserId  ,String ClubId  ,String Token  ,String OrderId);
        //删除
        void appDelMyMemberCardByOrderId(String APPUserId  ,String ClubId  ,String Token  ,String OrderId);
        //催办
        void appMemberCardLockSendMsg(String APPUserId  ,String ClubId  ,String Token  ,String MemberCardId);
    }
}
