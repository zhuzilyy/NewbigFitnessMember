package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.CulbsEvaluateList;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubLessonEvaluateStarTotalBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubTeacherEvaluateListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface CulbsEvaluateListActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(ClubLessonEvaluateStarTotalBean clubLessonEvaluateStarTotalBean);

    }

    interface Presenter extends BasePresenter<View> {
        void getClubTeacherEvaluateList(String APPUserId, String token, String ClubId, int PageIndex, String TeacherId, int Star);

        void getClubevaluateByClubId(String APPUserId, String Token, String ClubId, int IsOnlyShowContent, int Star, int PageIndex);
    }
}
