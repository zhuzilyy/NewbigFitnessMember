package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.TelVerify;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.VerifyCodeBean;

import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface TelVerifyActivityContract {

    interface View extends BaseView {    void outLogin();

        /**
         *成功
         */
        void Success(VerifyCodeBean verifyCodeBean);


        void succeedEdit(CodeBean codeBean);
    }

    interface Presenter extends BasePresenter<View> {

        void getVerifyCode(String Mobile);
        void updateAPPUserMobile(String APPUserId  ,String Mobile  ,String VerifyCode);

    }
}
