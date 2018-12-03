package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Register;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.RegisterAppUserBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.VerificationAccountNameBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.VerifyCodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.LoginBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface RegisterActivityContract {

    interface View extends BaseView {    void outLogin();

        /**
         *登录成功
         */
        void   succeed(VerifyCodeBean verifyCodeBean);

        void RegisterSucceed(RegisterAppUserBean normalResponse);

        void AccountNameSucceed(VerificationAccountNameBean verificationAccountNameBean);

//        /**
//         * 保存帐号密码
//         */
//        void remember(String account, String password, String deviceCoded, LoginBean loginBean, boolean flag);
//
//
//        /**
//         * 移除保存
//         */
//        void remove();

    }

    interface Presenter extends BasePresenter<View> {

//        void login(String userName,String passWord);
void registerAppUser(String AccountName  ,String Mobile  ,String Pwd  ,String VerifyCode);
        void getVerifyCode(String Mobile);
        void checkTAppuserByAccountName(String AccountName, String token);
    }
}
