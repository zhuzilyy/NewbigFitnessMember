package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Register.FitnessDemand;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MemberMyInfoBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.UserregisterAppUserBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.LoginBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface FitnessDemandActivityContract {

    interface View extends BaseView {    void outLogin();

        /**
         *登录成功
         */
        void   succeed(MemberMyInfoBean memberMyInfoBean);



    }

    interface Presenter extends BasePresenter<View> {


        void updateAppUserInfo(String APPUserId  ,
                               String DeviceCode  ,
                               String Sex  ,
                               String NickName  ,
                               String Birthday  ,
                               String Height  ,
                               String Weight  ,
                               String FitnessRequest  ,
                               String DeviceType);




    }

}
