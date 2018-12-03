package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C1;

import com.member.gufei.bigfitness.base.RxPresenter;
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

public class IndexFragMentCP1Presenter extends RxPresenter<IndexFragMentCP1Contract.View> implements IndexFragMentCP1Contract.Presenter {


    private Api api;


    @Inject
    public IndexFragMentCP1Presenter(Api api) {
        this.api = api;
    }

    @Override
    public void appGetMyMemberLessonList(String APPUserId, String ClubId, String token) {

        Subscription subscription = api.appGetMyMemberLessonList(APPUserId, ClubId, token)
                .compose(RxUtil.<AppGetMyMemberLessonListBean>rxSchedulerHelper())
                .subscribe(new Action1<AppGetMyMemberLessonListBean>() {
                    @Override
                    public void call(AppGetMyMemberLessonListBean normalResponse) {

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

    //退款申请
    @Override
    public void getAppMyMemberLessonApplyRefund(String APPUserId, String ClubId, String token, String OrderId) {
        Subscription subscription = api.appMyMemberLessonApplyRefund(APPUserId, ClubId, token, OrderId)
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getRet() == 0) {

                            mView.succeedRefund(normalResponse);
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