package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.WebView;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubInfoByIdBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.EventDetailBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


public class MyWebViewActivityPresenter extends RxPresenter<MyWebViewActivityContract.View> implements MyWebViewActivityContract.Presenter{

    private Api api;


    @Inject
    public MyWebViewActivityPresenter(Api api) {
        this.api = api;
    }
    @Override
    public void getEventDetail(String Id, String token) {
        Subscription subscription = api.getEventDetail(Id  ,token)
                .compose(RxUtil.<EventDetailBean>rxSchedulerHelper())
                .subscribe(new Action1<EventDetailBean>() {
                    @Override
                    public void call(EventDetailBean normalResponse) {
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
