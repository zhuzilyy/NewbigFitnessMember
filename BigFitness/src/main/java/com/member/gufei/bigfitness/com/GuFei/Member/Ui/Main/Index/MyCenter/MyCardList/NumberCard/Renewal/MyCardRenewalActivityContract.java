package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.NumberCard.Renewal;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MembershipRenewalBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MyCardRenewalActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(MembershipRenewalBean membershipRenewalBean);

    }

    interface Presenter extends BasePresenter<View> {

        void getMemberCardAddFeePriceList (String APPUserId, String token, String ClubId, String MemberCardTypeId);

    }

}
