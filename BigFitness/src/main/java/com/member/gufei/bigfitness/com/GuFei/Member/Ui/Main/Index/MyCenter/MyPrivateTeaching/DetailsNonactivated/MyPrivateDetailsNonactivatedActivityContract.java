package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.DetailsNonactivated;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.APPBuyLessonOrderDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListNotActiveBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MyPrivateDetailsNonactivatedActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(APPBuyLessonOrderDetailBean appBuyLessonOrderDetailBean);

        void succeedRefund(CodeBean codeBean);

    }

    interface Presenter extends BasePresenter<View> {
        void getMyAPPBuyLessonOrderDetailNo(String APPUserId  ,String ClubId  ,String OrderId  ,String Status, String token);

        //退款申请
        void getAppMyMemberLessonApplyRefund(String APPUserId  ,String ClubId  ,String token , String OrderId);
    }

}
