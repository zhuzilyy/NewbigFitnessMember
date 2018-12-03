package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubListForMemberBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubListForMemberNoBuyBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface AllCulbsListContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(ClubListForMemberBean clubListForMemberBean);
//        void succeedNoBuy(ClubListForMemberNoBuyBean clubListForMemberNoBuy);
        void unsucceed();

    }

    interface Presenter extends BasePresenter<View> {
        void getClubListForMember(String APPUserId  ,String token  ,String currentPage  ,String UserPosition);
//        void getClubListForMemberNoBuy(String APPUserId  ,String ClubId  ,String token  ,String lat  ,String lng);
    }
}
