package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.SelectCocat;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubLessonTeacherListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubListForMemberBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubListForMemberNoBuyBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface SelectCocatActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(ClubLessonTeacherListBean clubLessonTeacherListBean);


    }

    interface Presenter extends BasePresenter<View> {
        void getClubLessonTeacherList(String APPUserId, String token,String ClubId,String LessonId, int currentPage);

    }
}
