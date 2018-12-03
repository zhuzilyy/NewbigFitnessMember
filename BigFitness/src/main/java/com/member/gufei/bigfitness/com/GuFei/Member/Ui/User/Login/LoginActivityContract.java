package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.FitnessRequestBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.LandAppUserBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.LoginBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface LoginActivityContract {

    interface View extends BaseView {
        void outLogin();

        /**
         * 登录成功
         */
        void succeed(LandAppUserBean landAppUserBean);

        /**
         * 获取健身需求
         */
        void FitnessRequestsucceed(FitnessRequestBean fitnessRequestBean);

        /**
         * 保存帐号密码
         */
        void remember(String account, String password, String deviceCoded, LandAppUserBean landAppUserBean, boolean flag);


        /**
         * 移除保存
         */
        void remove();

    }

    interface Presenter extends BasePresenter<View> {

        void landAppUser(String userName, String password, final String DeviceCode, boolean remember, String DeviceType);
        void getFitnessRequest(String token);

    }
}
