package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.DetailsRefunded;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonDetailBean;
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

public class MyPrivateDetailsRefundedActivityPresenter extends RxPresenter<MyPrivateDetailsRefundedActivityContract.View> implements MyPrivateDetailsRefundedActivityContract.Presenter {


    private Api api;


    @Inject
    public MyPrivateDetailsRefundedActivityPresenter(Api api) {
        this.api = api;
    }
    @Override
    public void appGetMyMemberLessonDetail(String APPUserId, String ClubId, String Id, String Status, String token) {
        Subscription subscription = api.appGetMyMemberLessonDetail(APPUserId  ,ClubId,Status ,Id,token)
                .compose(RxUtil.<AppGetMyMemberLessonDetailBean>rxSchedulerHelper())
                .subscribe(new Action1<AppGetMyMemberLessonDetailBean>() {
                    @Override
                    public void call(AppGetMyMemberLessonDetailBean normalResponse) {

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