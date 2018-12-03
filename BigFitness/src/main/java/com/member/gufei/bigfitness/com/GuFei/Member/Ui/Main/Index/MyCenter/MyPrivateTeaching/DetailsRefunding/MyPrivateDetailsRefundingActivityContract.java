package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.DetailsRefunding;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.APPBuyLessonOrderDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MyPrivateDetailsRefundingActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(APPBuyLessonOrderDetailBean appBuyLessonOrderDetailBean);
    }

    interface Presenter extends BasePresenter<View> {

        void getMyAPPBuyLessonOrderDetailNo(String APPUserId  ,String ClubId  ,String OrderId  ,String Status, String token);
    }

}
