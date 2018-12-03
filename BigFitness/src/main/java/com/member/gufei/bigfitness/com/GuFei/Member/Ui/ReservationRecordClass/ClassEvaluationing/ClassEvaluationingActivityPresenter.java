package com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.ClassEvaluationing;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClassLessonRecordListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.GetLessonEvaluateBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class ClassEvaluationingActivityPresenter extends RxPresenter<ClassEvaluationingActivityContract.View> implements ClassEvaluationingActivityContract.Presenter {


    private Api api;


    @Inject
    public ClassEvaluationingActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getLessonEvaluate(String APPUserId, String ClubId, String token, String MemberId, String ComeLogId, String AppointmentId,
                                  String EvaluateStar, String EvaluateContent, String TeacherEvaluateStar, String ServiceEvaluateStar,
                                  String TeacherEvaluateContent, String ImageURL, String TeacherImageURL, String IsAnonymous) {
        Subscription subscription = api.getLessonEvaluate(APPUserId  ,ClubId  ,token  ,MemberId  ,ComeLogId, AppointmentId, EvaluateStar,
                EvaluateContent, TeacherEvaluateStar, ServiceEvaluateStar, TeacherEvaluateContent, ImageURL, TeacherImageURL, IsAnonymous)
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {
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
    public void getEvaluate(String APPUserId, String ClubId, String token, String MemberId, String AppointmentId, String ComeLogId) {
        Subscription subscription = api.getEvaluate(APPUserId  ,ClubId  ,token  ,MemberId  ,AppointmentId, ComeLogId)
                .compose(RxUtil.<GetLessonEvaluateBean>rxSchedulerHelper())
                .subscribe(new Action1<GetLessonEvaluateBean>() {
                    @Override
                    public void call(GetLessonEvaluateBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.Evaluatesucceed(normalResponse);
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