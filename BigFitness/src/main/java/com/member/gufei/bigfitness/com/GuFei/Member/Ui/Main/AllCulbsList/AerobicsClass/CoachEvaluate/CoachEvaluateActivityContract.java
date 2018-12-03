package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.AerobicsClass.CoachEvaluate;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.CulbsEvaluateList.CulbsEvaluateListActivityContract;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubTeacherEvaluateListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface CoachEvaluateActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(ClubTeacherEvaluateListBean clubTeacherEvaluateListBean);

    }

    interface Presenter extends BasePresenter<CoachEvaluateActivityContract.View> {
        void getClubTeacherEvaluateList(String APPUserId  ,String token  ,String ClubId  ,int PageIndex  ,String TeacherId  ,int Star);
    }

}
