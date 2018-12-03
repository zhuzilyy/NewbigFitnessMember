package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C2;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubSaleLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface IndexFragMentC2Contract {

    interface View extends BaseView {
        void outLogin();
        void succeed(ClubSaleLessonListBean clubSaleLessonListBean);

    }

    interface Presenter extends BasePresenter<View> {

        void getClubSaleLessonList(String APPUserId  ,String token  ,String ClubId  ,int currentPage);

    }
}
