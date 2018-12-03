package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.CardEvaluationing;

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

public class CardEvaluationingActivityPresenter extends RxPresenter<CardEvaluationingActivityContract.View> implements CardEvaluationingActivityContract.Presenter {


    private Api api;


    @Inject
    public CardEvaluationingActivityPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void ClubEvaluate(String APPUserId, String ClubId, String Token, String EvaluateStar, String EvaluateContent, String ImageURL, String IsAnonymous) {
        Subscription subscription = api.ClubEvaluate(APPUserId  ,ClubId  ,Token  ,EvaluateStar  ,EvaluateContent  ,ImageURL  ,IsAnonymous)
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