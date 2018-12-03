package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyGroupClass.ClassEvaluationing;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class MyGroupClassEvaluationingActivityPresenter extends RxPresenter<MyGroupClassEvaluationingActivityContract.View> implements MyGroupClassEvaluationingActivityContract.Presenter {


    private Api api;


    @Inject
    public MyGroupClassEvaluationingActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void GroupLessonEvaluate(String MemberId, String ClubId, String Token, String GroupLessonId, String EvaluateStar, String EvaluateContent, String ImageURL, String IsAnonymous) {
        Subscription subscription = api.GroupLessonEvaluate(MemberId  ,ClubId  ,Token,GroupLessonId,EvaluateStar  ,EvaluateContent  ,ImageURL,IsAnonymous)
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.Success(normalResponse);
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