package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.ResetPwd;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface ResetPwdActivityContract {

    interface View extends BaseView {


        void outLogin();

        /**
         *成功
         */
        void succeed(CodeBean codeBean);





    }

    interface Presenter extends BasePresenter<View> {
        void appUserResetPwd(String AccountName  ,String Pwd  ,String APPUserId  ,String token);

    }
}
