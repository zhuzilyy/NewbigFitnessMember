package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.CardIndex;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubOnlineSaleMemberCardListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class CardIndexFragMentPresenter extends RxPresenter<CardIndexFragMentContract.View> implements CardIndexFragMentContract.Presenter {


    private Api api;


    @Inject
    public CardIndexFragMentPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getClubOnlineSaleMemberCardList(String APPUserId, String ClubId, String Token, int currentPage) {
        Subscription subscription = api.getClubOnlineSaleMemberCardList(APPUserId  ,ClubId  ,Token  ,currentPage)
                .compose(RxUtil.<ClubOnlineSaleMemberCardListBean>rxSchedulerHelper())
                .subscribe(new Action1<ClubOnlineSaleMemberCardListBean>() {
                    @Override
                    public void call(ClubOnlineSaleMemberCardListBean normalResponse) {

                        if (normalResponse.getRet() == 0 || normalResponse.getRet() == 2) {

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