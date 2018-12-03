package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyReservationDetails;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyLessonAppDetailBean;
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

public class MyReservationDetailsActivityPresenter extends RxPresenter<MyReservationDetailsActivityContract.View> implements MyReservationDetailsActivityContract.Presenter {


    private Api api;


    @Inject
    public MyReservationDetailsActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getMyLessonAppDetail(String APPUserId, String ClubId, String Token, String MemberId, String AppointmentId) {
        Subscription subscription = api.getMyLessonAppDetail(APPUserId  ,ClubId  ,Token  ,MemberId  ,AppointmentId)
                .compose(RxUtil.<MyLessonAppDetailBean>rxSchedulerHelper())
                .subscribe(new Action1<MyLessonAppDetailBean>() {
                    @Override
                    public void call(MyLessonAppDetailBean normalResponse) {
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

    @Override
    public void confirmLessonAppointment(String APPUserId, String ClubId, String Token, String MemberId, String AppointmentId) {
        Subscription subscription = api.confirmLessonAppointment(APPUserId  ,ClubId  ,Token  ,MemberId  ,AppointmentId)
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeedConfirm(normalResponse);
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

    @Override
    public void cancelMemberLessonAppointment(String APPUserId, String ClubId, String Token, String MemberId, String AppointmentId, String AppointmentStatus) {

        Subscription subscription = api.cancelMemberLessonAppointment(APPUserId  ,ClubId  ,Token  ,MemberId  ,AppointmentId  ,AppointmentStatus)
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeedConfirm(normalResponse);
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