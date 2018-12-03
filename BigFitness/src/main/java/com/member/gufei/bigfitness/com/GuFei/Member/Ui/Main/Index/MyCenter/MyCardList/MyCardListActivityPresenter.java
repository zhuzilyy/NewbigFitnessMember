package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.CardIndex.CardIndexFragMentContract;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListBean;
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

public class MyCardListActivityPresenter extends RxPresenter<MyCardListActivityContract.View> implements MyCardListActivityContract.Presenter {


    private Api api;


    @Inject
    public MyCardListActivityPresenter(Api api) {
        this.api = api;
    }



    @Override
    public void appGetMyMemberCardList(String APPUserId, String ClubId, String Token, int currentPage) {
        Subscription subscription = api.appGetMyMemberCardList(APPUserId  ,ClubId  ,Token  ,currentPage)
                .compose(RxUtil.<AppGetMyMemberCardListBean>rxSchedulerHelper())
                .subscribe(new Action1<AppGetMyMemberCardListBean>() {
                    @Override
                    public void call(AppGetMyMemberCardListBean normalResponse) {

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