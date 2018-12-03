package com.member.gufei.bigfitness.com.GuFei.Member.Ui.welcome;

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

public class WelcomeActivityPresenter extends RxPresenter<WelcomeActivityContract.View> implements WelcomeActivityContract.Presenter {


    private Api api;


    @Inject
    public WelcomeActivityPresenter(Api api) {
        this.api = api;
    }
    @Override
    public void login(final String userName, final String passWord,final  String DeviceCode, final boolean remember) {

    }
}