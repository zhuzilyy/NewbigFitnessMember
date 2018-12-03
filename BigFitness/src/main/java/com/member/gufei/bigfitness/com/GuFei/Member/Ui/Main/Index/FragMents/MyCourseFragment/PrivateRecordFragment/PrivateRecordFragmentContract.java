package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyCourseFragment.PrivateRecordFragment;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClassLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface PrivateRecordFragmentContract {

    interface View extends BaseView {
        void outLogin();
        void succeed(ClassLessonListBean classLessonListBean);


    }

    interface Presenter extends BasePresenter<View> {

        void getClassLessonList(String APPUserId  ,String ClubId  ,String token  ,int PageIndex  ,int MemberId);

    }
}
