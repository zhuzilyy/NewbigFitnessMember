package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Register.FitnessDemand;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MemberMyInfoBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.UserregisterAppUserBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.LoginBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class FitnessDemandActivityPresenter extends RxPresenter<FitnessDemandActivityContract.View> implements FitnessDemandActivityContract.Presenter {


    private Api api;


    @Inject
    public FitnessDemandActivityPresenter(Api api) {
        this.api = api;
    }
    @Override
    public void updateAppUserInfo(String APPUserId, String DeviceCode, String Sex, String NickName, String Birthday, String Height, String Weight, String FitnessRequest,  String DeviceType) {
        Subscription subscription = api.updateAppUserInfo(APPUserId  ,DeviceCode  ,Sex  ,NickName  ,Birthday  ,Height  ,Weight  ,FitnessRequest  ,DeviceType)
                .compose(RxUtil.<MemberMyInfoBean>rxSchedulerHelper())
                .subscribe(new Action1<MemberMyInfoBean>() {
                    @Override
                    public void call(MemberMyInfoBean normalResponse) {
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