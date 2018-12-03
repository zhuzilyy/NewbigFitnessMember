package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.EditPwd;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.PwdCheckBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface EditPwdActivityContract {

    interface View extends BaseView {    void outLogin();

        /**
         *成功
         */
        void Success(CustomerInfoBean customerInfoBean);


        void succeed(PwdCheckBean normalResponse);
    }

    interface Presenter extends BasePresenter<View> {

        void PwdCheck(String APPUserId  ,String Pwd, String token);



    }
}
