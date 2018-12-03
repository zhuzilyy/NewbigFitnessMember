package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.MyPrivateRenewal;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.LessonAddFeePriceBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MyPrivateRenewalActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(LessonAddFeePriceBean lessonAddFeePriceBean);

    }

    interface Presenter extends BasePresenter<View> {

        void getMemberLessonAddFeePriceList(String APPUserId, String Token  , String ClubId  ,String LessonId);
    }

}
