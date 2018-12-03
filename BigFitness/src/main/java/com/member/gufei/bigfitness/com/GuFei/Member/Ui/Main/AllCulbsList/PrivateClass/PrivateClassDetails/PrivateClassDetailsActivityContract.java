package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.PrivateClassDetails;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubLessonDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface PrivateClassDetailsActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(ClubLessonDetailBean clubLessonDetailBean);

    }

    interface Presenter extends BasePresenter<View> {

        void getClubLessonDetail(String APPUserId  ,String token  ,String ClubId  ,String LessonId);

    }

}
