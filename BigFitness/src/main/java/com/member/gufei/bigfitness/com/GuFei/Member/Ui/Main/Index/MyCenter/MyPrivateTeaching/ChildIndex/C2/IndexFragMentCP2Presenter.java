package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C2;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListActivedBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class IndexFragMentCP2Presenter extends RxPresenter<IndexFragMentCP2Contract.View> implements IndexFragMentCP2Contract.Presenter {


    private Api api;


    @Inject
    public IndexFragMentCP2Presenter(Api api) {
        this.api = api;
    }

    @Override
    public void appGetMyMemberLessonListActived(String APPUserId, String ClubId, String token, int PageIndex) {
        Subscription subscription = api.appGetMyMemberLessonListActived(APPUserId  ,ClubId  ,token  ,PageIndex)
                .compose(RxUtil.<AppGetMyMemberLessonListActivedBean>rxSchedulerHelper())
                .subscribe(new Action1<AppGetMyMemberLessonListActivedBean>() {
                    @Override
                    public void call(AppGetMyMemberLessonListActivedBean normalResponse) {

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