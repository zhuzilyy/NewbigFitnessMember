package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C1;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubInfoByIdBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubSaleLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.DistanceClassTimeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.QueryScheduleDayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class IndexFragMentC1Presenter extends RxPresenter<IndexFragMentC1Contract.View> implements IndexFragMentC1Contract.Presenter {


    private Api api;


    @Inject
    public IndexFragMentC1Presenter(Api api) {
        this.api = api;
    }


    @Override
    public void clubInfoById(String ClubId, String APPUserId, String token) {
        Subscription subscription = api.clubInfoById(ClubId  ,APPUserId  ,token)
                .compose(RxUtil.<ClubInfoByIdBean>rxSchedulerHelper())
                .subscribe(new Action1<ClubInfoByIdBean>() {
                    @Override
                    public void call(ClubInfoByIdBean normalResponse) {
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

    //悬浮按钮
    @Override
    public void quanquan(String APPUserId, String ClubId, String Token, String AppointmentStartDate, String AppointmentEndDate, String quanquan) {
        Subscription subscription = api.getQuanQuan(APPUserId  ,ClubId  ,Token ,AppointmentStartDate ,AppointmentEndDate ,quanquan)
                .compose(RxUtil.<QueryScheduleDayBean>rxSchedulerHelper())
                .subscribe(new Action1<QueryScheduleDayBean>() {
                    @Override
                    public void call(QueryScheduleDayBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeedquan(normalResponse);
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

    //请求倒计时
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
}