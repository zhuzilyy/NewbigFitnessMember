package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.PayRecordList;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ConsumptionRecordBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface PayRecordListActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(ConsumptionRecordBean consumptionRecordBean);

    }

    interface Presenter extends BasePresenter<View> {
        void getConsumptionRecord(String APPUserId, String ClubId, String token, int PageIndex);
    }

}
