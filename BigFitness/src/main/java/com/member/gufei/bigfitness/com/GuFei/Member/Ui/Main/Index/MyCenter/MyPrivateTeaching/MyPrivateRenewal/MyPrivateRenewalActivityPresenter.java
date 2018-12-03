package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.MyPrivateRenewal;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.LessonAddFeePriceBean;
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

public class MyPrivateRenewalActivityPresenter extends RxPresenter<MyPrivateRenewalActivityContract.View> implements MyPrivateRenewalActivityContract.Presenter {


    private Api api;


    @Inject
    public MyPrivateRenewalActivityPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void getMemberLessonAddFeePriceList(String APPUserId, String Token, String ClubId, String LessonId) {
        Subscription subscription = api.getMemberLessonAddFeePriceList(APPUserId,Token, ClubId,  LessonId)
                .compose(RxUtil.<LessonAddFeePriceBean>rxSchedulerHelper())
                .subscribe(new Action1<LessonAddFeePriceBean>() {
                    @Override
                    public void call(LessonAddFeePriceBean normalResponse) {

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