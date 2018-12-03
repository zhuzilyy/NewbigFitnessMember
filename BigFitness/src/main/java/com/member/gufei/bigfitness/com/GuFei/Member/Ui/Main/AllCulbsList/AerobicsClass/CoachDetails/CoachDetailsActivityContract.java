package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.AerobicsClass.CoachDetails;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubTeacherDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface CoachDetailsActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(ClubTeacherDetailBean clubTeacherDetailBean);

    }

    interface Presenter extends BasePresenter<View> {

        void getClubTeacherDetail(String APPUserId, String token, String ClubId, String TeacherId);
    }
}
