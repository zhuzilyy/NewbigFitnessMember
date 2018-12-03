package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.GroupClass.EvaluateListForGroupLesson;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubGroupLessonEvaluateListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubLessonEvaluateStarTotalBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface EvaluateListForGroupLessonActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(ClubGroupLessonEvaluateListBean clubGroupLessonEvaluateListBean);

    }

    interface Presenter extends BasePresenter<View> {
//        void getClubTeacherEvaluateList(String APPUserId, String token, String ClubId, int PageIndex, String TeacherId, int Star);

        void getClubGroupLessonEvaluateList(String APPUserId  ,String Token  ,String ClubId  ,String GroupLessonId  ,int IsOnlyShowContent  ,int Star  ,int PageIndex);
    }
}
