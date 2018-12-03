package com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.ReservationRecordList;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.QueryScheduleDayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class ReservationRecordListActivityPresenter extends RxPresenter<ReservationRecordListActivityContract.View> implements ReservationRecordListActivityContract.Presenter {


    private Api api;


    @Inject
    public ReservationRecordListActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void QueryScheduleDay(String APPUserId, String ClubId, String Token, String AppointmentStartDate, String AppointmentEndDate, String isNow) {
        Subscription subscription = api.QueryScheduleDay(APPUserId  ,ClubId  ,Token  ,AppointmentStartDate  ,AppointmentEndDate,isNow)
                .compose(RxUtil.<QueryScheduleDayBean>rxSchedulerHelper())
                .subscribe(new Action1<QueryScheduleDayBean>() {
                    @Override
                    public void call(QueryScheduleDayBean normalResponse) {
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