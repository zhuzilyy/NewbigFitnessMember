package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C4;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListRefundedBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class IndexFragMentCP4Presenter extends RxPresenter<IndexFragMentCP4Contract.View> implements IndexFragMentCP4Contract.Presenter {


    private Api api;


    @Inject
    public IndexFragMentCP4Presenter(Api api) {
        this.api = api;
    }

    @Override
    public void appGetMyMemberLessonListRefunded(String APPUserId, String ClubId, String token, int PageIndex) {

        Subscription subscription = api.appGetMyMemberLessonListRefunded(APPUserId  ,ClubId  ,token  ,PageIndex)
                .compose(RxUtil.<AppGetMyMemberLessonListRefundedBean>rxSchedulerHelper())
                .subscribe(new Action1<AppGetMyMemberLessonListRefundedBean>() {
                    @Override
                    public void call(AppGetMyMemberLessonListRefundedBean normalResponse) {
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