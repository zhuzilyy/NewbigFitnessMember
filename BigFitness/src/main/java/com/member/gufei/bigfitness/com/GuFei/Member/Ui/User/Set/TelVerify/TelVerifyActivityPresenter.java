package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.TelVerify;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.VerifyCodeBean;

import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class TelVerifyActivityPresenter extends RxPresenter<TelVerifyActivityContract.View> implements TelVerifyActivityContract.Presenter {


    private Api api;


    @Inject
    public TelVerifyActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getVerifyCode(String Mobile) {
        mView.showError("成功发送验证码!");
        Subscription subscription = api.getVerifyCode(Mobile)
                .compose(RxUtil.<VerifyCodeBean>rxSchedulerHelper())
                .subscribe(new Action1<VerifyCodeBean>() {
                    @Override
                    public void call(VerifyCodeBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.Success(normalResponse);
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
    public void updateAPPUserMobile(String APPUserId, String Mobile, String VerifyCode) {
        Subscription subscription = api.updateAPPUserMobile(APPUserId  ,Mobile  ,VerifyCode)
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeedEdit(normalResponse);
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