package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C5;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListRefundedBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.NotActiveMemberLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class IndexFragMentCP5Presenter extends RxPresenter<IndexFragMentCP5Contract.View> implements IndexFragMentCP5Contract.Presenter {


    private Api api;


    @Inject
    public IndexFragMentCP5Presenter(Api api) {
        this.api = api;
    }

    @Override
    public void getNotActiveMemberLessonList(String APPUserId, String ClubId, String token, int PageIndex) {

        Subscription subscription = api.getNotActiveMemberLessonList(APPUserId  ,ClubId  ,token  ,PageIndex)
                .compose(RxUtil.<NotActiveMemberLessonListBean>rxSchedulerHelper())
                .subscribe(new Action1<NotActiveMemberLessonListBean>() {
                    @Override
                    public void call(NotActiveMemberLessonListBean normalResponse) {

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