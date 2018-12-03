package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.BuyCard.TimeCard.RenewalOrder;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;

import javax.inject.Inject;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class TimeCardRenewalOrderForBuyCardActivityPresenter extends RxPresenter<TimeCardRenewalOrderForBuyCardActivityContract.View> implements TimeCardRenewalOrderForBuyCardActivityContract.Presenter {


    private Api api;


    @Inject
    public TimeCardRenewalOrderForBuyCardActivityPresenter(Api api) {
        this.api = api;
    }


}