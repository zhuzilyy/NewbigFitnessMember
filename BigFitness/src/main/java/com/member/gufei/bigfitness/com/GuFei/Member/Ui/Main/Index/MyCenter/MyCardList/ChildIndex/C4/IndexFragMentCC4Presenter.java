package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.ChildIndex.C4;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListRefundedBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListRefundedBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class IndexFragMentCC4Presenter extends RxPresenter<IndexFragMentCC4Contract.View> implements IndexFragMentCC4Contract.Presenter {


    private Api api;


    @Inject
    public IndexFragMentCC4Presenter(Api api) {
        this.api = api;
    }


    @Override
    public void appGetMyMemberCardListRefunded(String APPUserId, String ClubId, String Token, int currentPage) {
        Subscription subscription = api.appGetMyMemberCardListRefunded(APPUserId  ,ClubId  ,Token  ,currentPage)
                .compose(RxUtil.<AppGetMyMemberCardListRefundedBean>rxSchedulerHelper())
                .subscribe(new Action1<AppGetMyMemberCardListRefundedBean>() {
                    @Override
                    public void call(AppGetMyMemberCardListRefundedBean normalResponse) {

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
}