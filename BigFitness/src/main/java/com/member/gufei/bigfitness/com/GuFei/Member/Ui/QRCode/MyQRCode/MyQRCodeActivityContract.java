package com.member.gufei.bigfitness.com.GuFei.Member.Ui.QRCode.MyQRCode;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyTwoDimensionCodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MyQRCodeActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(MyTwoDimensionCodeBean myTwoDimensionCodeBean);

    }
    interface Presenter extends BasePresenter<View> {
        void getMyTwoDimensionCode(String APPUserId  ,String token);

    }
}
