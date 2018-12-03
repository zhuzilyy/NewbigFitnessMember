package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.BuyCard.NumberCard.NumberCardForBuy;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubMemberCardTypeDetailBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class NumberCardForBuyActivityPresenter extends RxPresenter<NumberCardForBuyActivityContract.View> implements NumberCardForBuyActivityContract.Presenter {


    private Api api;


    @Inject
    public NumberCardForBuyActivityPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void getClubMemberCardTypeDetail(String APPUserId, String token, String ClubId, String MemberCardTypeId) {
        Subscription subscription = api.getClubMemberCardTypeDetail(APPUserId  ,token  ,ClubId  ,MemberCardTypeId)
                .compose(RxUtil.<ClubMemberCardTypeDetailBean>rxSchedulerHelper())
                .subscribe(new Action1<ClubMemberCardTypeDetailBean>() {
                    @Override
                    public void call(ClubMemberCardTypeDetailBean normalResponse) {
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