package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.GroupClass.GroupClassDetails;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubGroupLessonDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface GroupClassDetailsActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(ClubGroupLessonDetailBean clubGroupLessonDetailBean);

    }

    interface Presenter extends BasePresenter<View> {
        void getClubGroupLessonDetail(String APPUserId, String token, String ClubId, String GroupLessonId);
    }
}
