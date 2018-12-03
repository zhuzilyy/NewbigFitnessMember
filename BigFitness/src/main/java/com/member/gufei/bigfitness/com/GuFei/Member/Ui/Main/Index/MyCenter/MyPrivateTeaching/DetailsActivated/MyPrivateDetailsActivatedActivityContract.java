package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.DetailsActivated;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MyPrivateDetailsActivatedActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(AppGetMyMemberLessonDetailBean appGetMyMemberLessonDetailBean);

    }
        interface Presenter extends BasePresenter<View> {


            void appGetMyMemberLessonDetail(String APPUserId  ,String ClubId  ,String Id  ,String Status, String token);
    }
}
