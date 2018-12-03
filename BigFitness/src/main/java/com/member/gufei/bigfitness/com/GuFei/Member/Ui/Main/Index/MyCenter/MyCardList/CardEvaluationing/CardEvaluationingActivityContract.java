package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.CardEvaluationing;

import android.graphics.Color;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;

import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface CardEvaluationingActivityContract {

    interface View extends BaseView {    void outLogin();

        /**
         *成功
         */
        void Success(CodeBean codeBean);




    }

    interface Presenter extends BasePresenter<View> {


        void ClubEvaluate(String APPUserId  ,String ClubId  ,String Token  ,String EvaluateStar  ,String EvaluateContent  ,String ImageURL  ,String IsAnonymous);



    }
}
