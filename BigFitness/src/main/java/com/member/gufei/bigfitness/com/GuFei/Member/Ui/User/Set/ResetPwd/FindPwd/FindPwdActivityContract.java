package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.ResetPwd.FindPwd;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppUserResetPwdCheckBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.VerifyCodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface FindPwdActivityContract {

    interface View extends BaseView {    void outLogin();

        /**
         *成功
         */
        void succeed(AppUserResetPwdCheckBean appUserResetPwdCheckBean);
        void succeedVerifyCode(VerifyCodeBean verifyCodeBean);





    }

    interface Presenter extends BasePresenter<View> {


        void appUserResetPwdCheck(String Mobile  ,String VerifyCode  ,String token);

        void getVerifyCode(String Mobile);


    }
}
