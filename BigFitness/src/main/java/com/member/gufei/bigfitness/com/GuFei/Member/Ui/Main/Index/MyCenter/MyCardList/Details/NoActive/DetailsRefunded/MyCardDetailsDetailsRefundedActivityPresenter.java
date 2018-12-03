package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.NoActive.DetailsRefunded;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyAPPBuyCardOrderDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class MyCardDetailsDetailsRefundedActivityPresenter extends RxPresenter<MyCardDetailsDetailsRefundedActivityContract.View> implements MyCardDetailsDetailsRefundedActivityContract.Presenter {


    private Api api;


    @Inject
    public MyCardDetailsDetailsRefundedActivityPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void appGetMyAPPBuyCardOrderDetail(String APPUserId, String ClubId, String Token, String OrderId, String Status) {
        Subscription subscription = api.appGetMyAPPBuyCardOrderDetail(APPUserId  ,ClubId  ,Token  ,OrderId  ,Status)
                .compose(RxUtil.<AppGetMyAPPBuyCardOrderDetailBean>rxSchedulerHelper())
                .subscribe(new Action1<AppGetMyAPPBuyCardOrderDetailBean>() {
                    @Override
                    public void call(AppGetMyAPPBuyCardOrderDetailBean normalResponse) {
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
    public void appDelMyMemberCardByOrderId(String APPUserId, String ClubId, String Token, String OrderId) {


        Subscription subscription = api.delMemberCardByOrderId(APPUserId  ,ClubId  ,Token  ,OrderId)
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getRet() == 0 ) {

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