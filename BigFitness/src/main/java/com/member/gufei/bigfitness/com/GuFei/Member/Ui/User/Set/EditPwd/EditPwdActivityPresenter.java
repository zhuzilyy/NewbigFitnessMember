package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.EditPwd;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.PwdCheckBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class EditPwdActivityPresenter extends RxPresenter<EditPwdActivityContract.View> implements EditPwdActivityContract.Presenter {


    private Api api;


    @Inject
    public EditPwdActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void PwdCheck(String APPUserId, String Pwd, String token) {
        Subscription subscription = api.PwdCheck(APPUserId  ,Pwd, token)
                .compose(RxUtil.<PwdCheckBean>rxSchedulerHelper())
                .subscribe(new Action1<PwdCheckBean>() {
                    @Override
                    public void call(PwdCheckBean normalResponse) {
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