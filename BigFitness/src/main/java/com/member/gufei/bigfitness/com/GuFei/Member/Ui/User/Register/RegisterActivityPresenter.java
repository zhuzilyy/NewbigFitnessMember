package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Register;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.RegisterAppUserBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.VerificationAccountNameBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.VerifyCodeBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class RegisterActivityPresenter extends RxPresenter<RegisterActivityContract.View> implements RegisterActivityContract.Presenter {


    private Api api;


    @Inject
    public RegisterActivityPresenter(Api api) {
        this.api = api;
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

    @Override
    public void registerAppUser(String AccountName, String Mobile, String Pwd, String VerifyCode) {
        Subscription subscription = api.registerAppUser(AccountName  ,Mobile  ,Pwd  ,VerifyCode)
                .compose(RxUtil.<RegisterAppUserBean>rxSchedulerHelper())
                .subscribe(new Action1<RegisterAppUserBean>() {
                    @Override
                    public void call(RegisterAppUserBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.RegisterSucceed(normalResponse);
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

    @Override
    public void checkTAppuserByAccountName(String AccountName, String token) {

        Subscription subscription = api.checkTAppuserByAccountName(AccountName, token)
                .compose(RxUtil.<VerificationAccountNameBean>rxSchedulerHelper())
                .subscribe(new Action1<VerificationAccountNameBean>() {
                    @Override
                    public void call(VerificationAccountNameBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.AccountNameSucceed(normalResponse);
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