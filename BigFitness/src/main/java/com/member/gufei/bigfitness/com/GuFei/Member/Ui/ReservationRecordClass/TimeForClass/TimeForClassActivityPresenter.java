package com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.TimeForClass;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClassCountdownInfoBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.DistanceClassTimeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyLessonAppDetailBean;
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

public class TimeForClassActivityPresenter extends RxPresenter<TimeForClassActivityContract.View> implements TimeForClassActivityContract.Presenter {


    private Api api;


    @Inject
    public TimeForClassActivityPresenter(Api api) {
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

    //距离上课时间倒计时
    @Override
    public void getClassTime(String APPUserId, String Token, String ClubId, String LessonId, String AppointmentId) {
        Subscription subscription = api.getAttendClassTime(APPUserId  ,Token ,ClubId  ,LessonId  ,AppointmentId)
                .compose(RxUtil.<DistanceClassTimeBean>rxSchedulerHelper())
                .subscribe(new Action1<DistanceClassTimeBean>() {
                    @Override
                    public void call(DistanceClassTimeBean normalResponse) {
                        if (normalResponse.getRet() == 2) {
                            mView.succeedClassUp(normalResponse);
                        } else if (normalResponse.getRet() == 0){
                            mView.succeedClassDown(normalResponse);
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

    //课程正计时
    @Override
    public void getClassBeginTime(String APPUserId, String Token, String ClubId, String AppointmentId) {
        Subscription subscription = api.getClassCountdownInfo(APPUserId  ,Token ,ClubId  ,AppointmentId)
                .compose(RxUtil.<ClassCountdownInfoBean>rxSchedulerHelper())
                .subscribe(new Action1<ClassCountdownInfoBean>() {
                    @Override
                    public void call(ClassCountdownInfoBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeedClassBegin(normalResponse);
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