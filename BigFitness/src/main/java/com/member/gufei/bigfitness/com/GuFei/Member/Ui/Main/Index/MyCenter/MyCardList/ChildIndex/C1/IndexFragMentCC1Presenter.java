package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.ChildIndex.C1;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class IndexFragMentCC1Presenter extends RxPresenter<IndexFragMentCC1Contract.View> implements IndexFragMentCC1Contract.Presenter {


    private Api api;


    @Inject
    public IndexFragMentCC1Presenter(Api api) {
        this.api = api;
    }

    @Override
    public void appGetMyMemberCardList(String APPUserId, String ClubId, String Token, int currentPage) {
        Subscription subscription = api.appGetMyMemberCardList(APPUserId  ,ClubId  ,Token  ,currentPage)
                .compose(RxUtil.<AppGetMyMemberCardListBean>rxSchedulerHelper())
                .subscribe(new Action1<AppGetMyMemberCardListBean>() {
                    @Override
                    public void call(AppGetMyMemberCardListBean normalResponse) {

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

    //删除
    @Override
    public void appDelMyMemberCardByOrderId(String APPUserId, String ClubId, String Token, String OrderId) {
        Subscription subscription = api.delMemberCardByOrderId(APPUserId  ,ClubId  ,Token  ,OrderId)
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getRet() == 0 ) {

                            mView.Delsucceed(normalResponse);
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
    public void appMemberCardLockSendMsg(String APPUserId, String ClubId, String Token, String MemberCardId) {
        Subscription subscription = api.appMemberCardLockSendMsg(APPUserId  ,ClubId  ,Token  ,MemberCardId)
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.SendMsgsucceed(normalResponse);
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