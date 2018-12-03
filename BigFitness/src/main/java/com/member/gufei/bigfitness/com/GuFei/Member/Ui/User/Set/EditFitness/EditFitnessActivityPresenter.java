package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.EditFitness;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;

import javax.inject.Inject;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class EditFitnessActivityPresenter extends RxPresenter<EditFitnessActivityContract.View> implements EditFitnessActivityContract.Presenter {


    private Api api;


    @Inject
    public EditFitnessActivityPresenter(Api api) {
        this.api = api;
    }

}