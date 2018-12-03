package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.FrozenCard;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
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

public class FrozenCardActivityPresenter extends RxPresenter<FrozenCardActivityContract.View> implements FrozenCardActivityContract.Presenter {


    private Api api;


    @Inject
    public FrozenCardActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void appMemberCardLockApply(String APPUserId, String ClubId, String Token, String MemberCardId, String StartDate, String EndDate) {
        Subscription subscription = api.appMemberCardLockApply(APPUserId  ,ClubId  ,Token  ,MemberCardId  ,StartDate  ,EndDate)
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {

                        if (normalResponse.getRet() == 0 ) {

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