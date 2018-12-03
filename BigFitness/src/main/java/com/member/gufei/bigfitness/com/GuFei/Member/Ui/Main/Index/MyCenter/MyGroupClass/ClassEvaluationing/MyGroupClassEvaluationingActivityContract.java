package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyGroupClass.ClassEvaluationing;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;

import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MyGroupClassEvaluationingActivityContract {

    interface View extends BaseView {    void outLogin();

        /**
         *成功
         */
        void Success(CodeBean codeBean);




    }

    interface Presenter extends BasePresenter<View> {

//        void FreeLessonEvaluate(String APPUserId  ,String ClubId  ,String Token  ,String FreeLessonId,String EvaluateStar  ,String EvaluateContent  ,String ImageURL ,String IsAnonymous);
        void GroupLessonEvaluate(String MemberId, String ClubId, String Token, String GroupLessonId, String EvaluateStar, String EvaluateContent, String ImageURL, String IsAnonymous);


    }
}
