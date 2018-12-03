package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyGroupClass.Details;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyGroupLessonDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface DetailsActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(MyGroupLessonDetailBean myGroupLessonDetailBean);

    }

    interface Presenter extends BasePresenter<View> {
        void getMyGroupLessonDetail(String ClubId  ,String MemberId  ,int Id  ,String token);

    }

}
