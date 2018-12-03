package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.EditFitness;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.local.LoginBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface EditFitnessActivityContract {

    interface View extends BaseView {    void outLogin();


    }

    interface Presenter extends BasePresenter<View> {
    }
}
