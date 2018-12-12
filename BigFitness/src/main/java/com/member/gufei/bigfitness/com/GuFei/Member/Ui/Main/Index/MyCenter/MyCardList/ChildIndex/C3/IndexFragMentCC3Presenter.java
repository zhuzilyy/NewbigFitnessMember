package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.ChildIndex.C3;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListNotActiveBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class IndexFragMentCC3Presenter extends RxPresenter<IndexFragMentCC3Contract.View> implements IndexFragMentCC3Contract.Presenter {


    private Api api;


    @Inject
    public IndexFragMentCC3Presenter(Api api) {
        this.api = api;
    }

    @Override
    public void appGetMyMemberCardListNotActive(String APPUserId, String ClubId, String Token, int currentPage) {
        Subscription subscription = api.appGetMyMemberCardListNotActive(APPUserId  ,ClubId  ,Token  ,currentPage)
                .compose(RxUtil.<AppGetMyMemberCardListNotActiveBean>rxSchedulerHelper())
                .subscribe(new Action1<AppGetMyMemberCardListNotActiveBean>() {
                    @Override
                    public void call(AppGetMyMemberCardListNotActiveBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeed(normalResponse);
                        } else if (normalResponse.getRet() == 1){
                            mView.outLogin();
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