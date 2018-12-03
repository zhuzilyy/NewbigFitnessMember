package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyGroupClass;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyGroupLessonBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MyGroupClassActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(MyGroupLessonBean myGroupLessonBean);

    }

    interface Presenter extends BasePresenter<View> {
        void getMyGroupLesson(String ClubId  ,String MemberId  ,String token  ,int PageIndex);
    }

}
