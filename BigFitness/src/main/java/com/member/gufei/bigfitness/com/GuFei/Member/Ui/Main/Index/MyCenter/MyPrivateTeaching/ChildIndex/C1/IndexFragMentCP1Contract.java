package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C1;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface IndexFragMentCP1Contract {

    interface View extends BaseView {
        void outLogin();
        void succeed(AppGetMyMemberLessonListBean appGetMyMemberLessonListBean);
        void succeedRefund(CodeBean codeBean);

    }

    interface Presenter extends BasePresenter<View> {


        void appGetMyMemberLessonList(String APPUserId  ,String ClubId  ,String token  );

        //退款申请
        void getAppMyMemberLessonApplyRefund(String APPUserId  ,String ClubId  ,String token , String OrderId);
    }
}
