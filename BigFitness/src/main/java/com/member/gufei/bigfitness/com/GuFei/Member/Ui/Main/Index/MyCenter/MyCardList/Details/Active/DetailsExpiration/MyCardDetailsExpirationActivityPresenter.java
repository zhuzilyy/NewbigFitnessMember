package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.Active.DetailsExpiration;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class MyCardDetailsExpirationActivityPresenter extends RxPresenter<MyCardDetailsExpirationActivityContract.View> implements MyCardDetailsExpirationActivityContract.Presenter {


    private Api api;


    @Inject
    public MyCardDetailsExpirationActivityPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void appGetMyMemberCardDetail(String APPUserId, String ClubId, String Token, String Status, String MemberCardId, String ConsumeType) {

        Subscription subscription = api.appGetMyMemberCardDetail(APPUserId  ,ClubId  ,Token  ,Status  ,MemberCardId  ,ConsumeType)
                .compose(RxUtil.<AppGetMyMemberCardDetailBean>rxSchedulerHelper())
                .subscribe(new Action1<AppGetMyMemberCardDetailBean>() {
                    @Override
                    public void call(AppGetMyMemberCardDetailBean normalResponse) {

                        if (normalResponse.getRet() == 0 || normalResponse.getRet() == 2) {

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
    public void appMyMemberCardApplyRefund(String APPUserId, String ClubId, String Token, String OrderId) {


        Subscription subscription = api.appMyMemberCardApplyRefund(APPUserId  ,ClubId  ,Token  ,OrderId)
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getRet() == 0 || normalResponse.getRet() == 2) {

                            mView.Refundsucceed(normalResponse);
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