package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.WeekDay;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;

import javax.inject.Inject;


public class WeekDayActivityPresenter extends RxPresenter<WeekDayActivityContract.View> implements WeekDayActivityContract.Presenter {
    private Api api;


    @Inject
    public WeekDayActivityPresenter(Api api) {
        this.api = api;
    }
}
