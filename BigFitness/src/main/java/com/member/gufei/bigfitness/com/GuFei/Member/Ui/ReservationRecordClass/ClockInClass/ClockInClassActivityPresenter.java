package com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.ClockInClass;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CreateLessonQRBean;
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

public class ClockInClassActivityPresenter extends RxPresenter<ClockInClassActivityContract.View> implements ClockInClassActivityContract.Presenter {


    private Api api;


    @Inject
    public ClockInClassActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void CreateLessonQR(String APPUserId, String ClubId, String Token, String AppointmentId) {
        Subscription subscription = api.CreateLessonQR(APPUserId  ,ClubId  ,Token  ,AppointmentId)
                .compose(RxUtil.<CreateLessonQRBean>rxSchedulerHelper())
                .subscribe(new Action1<CreateLessonQRBean>() {
                    @Override
                    public void call(CreateLessonQRBean normalResponse) {
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