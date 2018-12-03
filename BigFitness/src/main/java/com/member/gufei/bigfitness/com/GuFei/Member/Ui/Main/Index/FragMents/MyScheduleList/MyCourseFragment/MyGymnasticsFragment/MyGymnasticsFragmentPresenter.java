package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyCourseFragment.MyGymnasticsFragment;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.FreeLessonAppointmentListBean;
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

public class MyGymnasticsFragmentPresenter extends RxPresenter<MyGymnasticsFragmentContract.View> implements MyGymnasticsFragmentContract.Presenter {


    private Api api;


    @Inject
    public MyGymnasticsFragmentPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void FreeLessonAppointmentList(String APPUserId, String ClubId, String Token, int currentPage, String MemberId) {
        Subscription subscription = api.FreeLessonAppointmentList(APPUserId  ,ClubId  ,Token  ,currentPage  ,MemberId)
                .compose(RxUtil.<FreeLessonAppointmentListBean>rxSchedulerHelper())
                .subscribe(new Action1<FreeLessonAppointmentListBean>() {
                    @Override
                    public void call(FreeLessonAppointmentListBean normalResponse) {
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
    public void cancelMemberFreeLessonAppointment(String APPUserId, String ClubId, String Token, String MemberId, String AppointmentId, String Cause) {
        Subscription subscription = api.cancelMemberFreeLessonAppointment(APPUserId  ,ClubId  ,Token  ,MemberId  ,AppointmentId  ,Cause)
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