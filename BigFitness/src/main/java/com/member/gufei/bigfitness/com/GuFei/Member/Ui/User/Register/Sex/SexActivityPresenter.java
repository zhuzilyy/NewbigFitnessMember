package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Register.Sex;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.local.LoginBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class SexActivityPresenter extends RxPresenter<SexActivityContract.View> implements SexActivityContract.Presenter {


    private Api api;


    @Inject
    public SexActivityPresenter(Api api) {
        this.api = api;
    }


}