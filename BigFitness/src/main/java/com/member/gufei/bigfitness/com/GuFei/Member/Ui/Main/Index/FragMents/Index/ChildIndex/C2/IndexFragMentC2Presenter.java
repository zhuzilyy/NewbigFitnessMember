package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C2;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubSaleLessonListBean;
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

public class IndexFragMentC2Presenter extends RxPresenter<IndexFragMentC2Contract.View> implements IndexFragMentC2Contract.Presenter {


    private Api api;


    @Inject
    public IndexFragMentC2Presenter(Api api) {
        this.api = api;
    }

    @Override
    public void getClubSaleLessonList(String APPUserId, String token, String ClubId, int currentPage) {

        Subscription subscription = api.getClubSaleLessonList(APPUserId, token, ClubId, currentPage)
                .compose(RxUtil.<ClubSaleLessonListBean>rxSchedulerHelper())
                .subscribe(new Action1<ClubSaleLessonListBean>() {
                    @Override
                    public void call(ClubSaleLessonListBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeed(normalResponse);
                        } else if(normalResponse.getRet() == 1){
                            mView.outLogin();
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