package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.AerobicsClass.CoachEvaluate;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubTeacherEvaluateListBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class CoachEvaluateActivityPresenter extends RxPresenter<CoachEvaluateActivityContract.View> implements CoachEvaluateActivityContract.Presenter {


    private Api api;


    @Inject
    public CoachEvaluateActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getClubTeacherEvaluateList(String APPUserId, String token, String ClubId, int PageIndex, String TeacherId, int Star) {
        Subscription subscription = api.getClubTeacherEvaluateList(APPUserId  ,token  ,ClubId  ,PageIndex  ,TeacherId  ,Star)
                .compose(RxUtil.<ClubTeacherEvaluateListBean>rxSchedulerHelper())
                .subscribe(new Action1<ClubTeacherEvaluateListBean>() {
                    @Override
                    public void call(ClubTeacherEvaluateListBean normalResponse) {
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