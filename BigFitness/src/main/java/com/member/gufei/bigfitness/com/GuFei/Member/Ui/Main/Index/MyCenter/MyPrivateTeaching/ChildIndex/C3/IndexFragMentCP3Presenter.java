package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C3;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListNotActiveBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class IndexFragMentCP3Presenter extends RxPresenter<IndexFragMentCP3Contract.View> implements IndexFragMentCP3Contract.Presenter {


    private Api api;


    @Inject
    public IndexFragMentCP3Presenter(Api api) {
        this.api = api;
    }

    @Override
    public void appGetMyMemberLessonListNotActive(String APPUserId, String ClubId, String token, int PageIndex) {

        Subscription subscription = api.appGetMyMemberLessonListNotActive(APPUserId  ,ClubId  ,token  ,PageIndex)
                .compose(RxUtil.<AppGetMyMemberLessonListNotActiveBean>rxSchedulerHelper())
                .subscribe(new Action1<AppGetMyMemberLessonListNotActiveBean>() {
                    @Override
                    public void call(AppGetMyMemberLessonListNotActiveBean normalResponse) {

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