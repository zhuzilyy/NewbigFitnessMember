package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C4;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubFLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface IndexFragMentC4Contract {

    interface View extends BaseView {
        void outLogin();
        void succeed(ClubFLessonListBean clubFLessonListBean);


    }

    interface Presenter extends BasePresenter<View> {

        void getClubFLessonList(String APPUserId  ,String Token  ,String ClubId  ,String LessonDate  ,String StartTime  ,int PageIndex);

    }
}
