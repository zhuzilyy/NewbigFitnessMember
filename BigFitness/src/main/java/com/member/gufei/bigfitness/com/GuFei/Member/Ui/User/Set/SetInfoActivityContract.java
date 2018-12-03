package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MemberMyInfoBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MemberSetUserInfoBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface SetInfoActivityContract {

    interface View extends BaseView {    void outLogin();

        /**
         *成功
         */
        void succeed(MemberSetUserInfoBean memberSetUserInfoBean);





    }

    interface Presenter extends BasePresenter<View> {


        void updateAppUserInfo(String APPUserId  ,
                               String HeaderURL  ,
                               String Sex  ,
                               String NickName  ,
                               String Birthday  ,
                               String Height  ,
                               String Weight  ,
                               String FitnessRequest  ,
                               String Token);




    }
}
