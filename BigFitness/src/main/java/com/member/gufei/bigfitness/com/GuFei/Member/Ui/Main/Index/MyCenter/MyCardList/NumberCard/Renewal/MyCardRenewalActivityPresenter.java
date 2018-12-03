package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.NumberCard.Renewal;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubMemberCardTypeDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MembershipRenewalBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class MyCardRenewalActivityPresenter extends RxPresenter<MyCardRenewalActivityContract.View> implements MyCardRenewalActivityContract.Presenter {


    private Api api;


    @Inject
    public MyCardRenewalActivityPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void getMemberCardAddFeePriceList(String APPUserId, String token, String ClubId, String MemberCardTypeId) {
        Subscription subscription = api.getMemberCardAddFeePriceList(APPUserId  ,token  ,ClubId  ,MemberCardTypeId)
                .compose(RxUtil.<MembershipRenewalBean>rxSchedulerHelper())
                .subscribe(new Action1<MembershipRenewalBean>() {
                    @Override
                    public void call(MembershipRenewalBean normalResponse) {
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