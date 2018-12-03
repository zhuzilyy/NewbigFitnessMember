package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.ResetPwd;

import com.member.gufei.bigfitness.base.RxPresenter;

import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class ResetPwdActivityPresenter extends RxPresenter<ResetPwdActivityContract.View> implements ResetPwdActivityContract.Presenter {


    private Api api;


    @Inject
    public ResetPwdActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void appUserResetPwd(String AccountName, String Pwd, String APPUserId, String token) {
        Subscription subscription = api.appUserResetPwd(AccountName, Pwd, APPUserId, token)
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getRet() == 0) {
                            mView.succeed(normalResponse);
                        } else {
                            mView.showError(normalResponse.getMsg());

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