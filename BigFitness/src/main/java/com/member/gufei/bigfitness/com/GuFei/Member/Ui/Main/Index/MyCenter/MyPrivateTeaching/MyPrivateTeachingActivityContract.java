package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MyPrivateTeachingActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(AppGetMyMemberLessonListBean appGetMyMemberLessonListBean);

    }

    interface Presenter extends BasePresenter<View> {

        void appGetMyMemberLessonList(String APPUserId  ,String ClubId  ,String token);

    }

}
