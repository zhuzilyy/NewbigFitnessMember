package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.ChildIndex.C2;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListActivedBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListActivedBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class IndexFragMentCC2Presenter extends RxPresenter<IndexFragMentCC2Contract.View> implements IndexFragMentCC2Contract.Presenter {


    private Api api;


    @Inject
    public IndexFragMentCC2Presenter(Api api) {
        this.api = api;
    }

    @Override
    public void appGetMyMemberCardListActived(String APPUserId, String ClubId, String Token, int currentPage) {
        Subscription subscription = api.appGetMyMemberCardListActived(APPUserId, ClubId, Token, currentPage)
                .compose(RxUtil.<AppGetMyMemberCardListActivedBean>rxSchedulerHelper())
                .subscribe(new Action1<AppGetMyMemberCardListActivedBean>() {
                    @Override
                    public void call(AppGetMyMemberCardListActivedBean normalResponse) {

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