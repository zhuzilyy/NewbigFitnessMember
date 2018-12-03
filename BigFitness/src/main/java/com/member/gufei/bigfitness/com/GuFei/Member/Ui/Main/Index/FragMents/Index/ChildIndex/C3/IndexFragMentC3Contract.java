package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C3;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubSaleNotOpenOrBuyGroupLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface IndexFragMentC3Contract {

    interface View extends BaseView {
        void outLogin();
        void succeed(ClubSaleNotOpenOrBuyGroupLessonListBean clubSaleNotOpenOrBuyGroupLessonListBean);


    }

    interface Presenter extends BasePresenter<View> {

        void getClubSaleNotOpenOrBuyGroupLessonList(String APPUserId  ,String token  ,String ClubId  ,int currentPage);

    }
}
