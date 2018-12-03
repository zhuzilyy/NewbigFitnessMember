package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.WeekViewForDay;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.QueryScheduleDayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.TeacherScheduleDayBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class WeekViewForDayActivityPresenter extends RxPresenter<WeekViewForDayActivityContract.View> implements WeekViewForDayActivityContract.Presenter {


    private Api api;


    @Inject
    public WeekViewForDayActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getTeacherScheduleDay(String APPUserId, String ClubId, String token, String AppointmentStartDate, String AppointmentEndDate, String AppointmentTeacherId) {
        Subscription subscription = api.getTeacherScheduleDay(APPUserId  ,ClubId  ,token  ,AppointmentStartDate  ,AppointmentEndDate  ,AppointmentTeacherId)
                .compose(RxUtil.<TeacherScheduleDayBean>rxSchedulerHelper())
                .subscribe(new Action1<TeacherScheduleDayBean>() {
                    @Override
                    public void call(TeacherScheduleDayBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeed(normalResponse);
                        } else {
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError("服务器请求失败");
                    }
                });
        addSubscription(subscription);
    }
}