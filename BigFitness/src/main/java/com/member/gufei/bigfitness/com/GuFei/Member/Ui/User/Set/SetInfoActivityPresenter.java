package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MemberMyInfoBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MemberSetUserInfoBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class SetInfoActivityPresenter extends RxPresenter<SetInfoActivityContract.View> implements SetInfoActivityContract.Presenter {


    private Api api;


    @Inject
    public SetInfoActivityPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void updateAppUserInfo(String APPUserId, String HeaderURL, String Sex, String NickName, String Birthday, String Height, String Weight, String FitnessRequest, String Token) {
        Subscription subscription = api.setAppUserInfo(APPUserId  ,HeaderURL  ,Sex  ,NickName  ,Birthday  ,Height  ,Weight  ,FitnessRequest  ,Token)
                .compose(RxUtil.<MemberSetUserInfoBean>rxSchedulerHelper())
                .subscribe(new Action1<MemberSetUserInfoBean>() {
                    @Override
                    public void call(MemberSetUserInfoBean normalResponse) {
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