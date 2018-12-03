package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.BuyCard.TimeCard.RenewalOrder;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface TimeCardRenewalOrderForBuyCardActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(PublicSeaBean publicSeaBean);

    }
    interface Presenter extends BasePresenter<View> {

    }
}
