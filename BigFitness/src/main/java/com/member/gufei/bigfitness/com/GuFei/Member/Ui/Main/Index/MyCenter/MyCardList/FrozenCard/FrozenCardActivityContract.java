package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.FrozenCard;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;

import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;


/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface FrozenCardActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(CodeBean codeBean);
        void showError(String Msg);

    }

    interface Presenter extends BasePresenter<View> {

        void appMemberCardLockApply(String APPUserId  ,String ClubId  ,String Token  ,String MemberCardId  ,String StartDate  ,String EndDate);
    }

}
