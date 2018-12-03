package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.ResetPwd.FindPwd;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppUserResetPwdCheckBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.VerifyCodeBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class FindPwdActivityPresenter extends RxPresenter<FindPwdActivityContract.View> implements FindPwdActivityContract.Presenter {


    private Api api;


    @Inject
    public FindPwdActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void appUserResetPwdCheck(String Mobile, String VerifyCode, String token) {
        Subscription subscription = api.appUserResetPwdCheck(Mobile  ,VerifyCode  ,token)
                .compose(RxUtil.<AppUserResetPwdCheckBean>rxSchedulerHelper())
                .subscribe(new Action1<AppUserResetPwdCheckBean>() {
                    @Override
                    public void call(AppUserResetPwdCheckBean normalResponse) {
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

    @Override
    public void getVerifyCode(String Mobile) {
//        mView.showError("成功发送验证码!");
        Subscription subscription = api.getVerifyCode(Mobile)
                .compose(RxUtil.<VerifyCodeBean>rxSchedulerHelper())
                .subscribe(new Action1<VerifyCodeBean>() {
                    @Override
                    public void call(VerifyCodeBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeedVerifyCode(normalResponse);
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