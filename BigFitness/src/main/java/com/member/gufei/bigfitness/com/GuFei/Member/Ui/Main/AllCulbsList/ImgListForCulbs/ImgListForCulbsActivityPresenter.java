package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.ImgListForCulbs;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubImagesBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubListForMemberBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubListForMemberNoBuyBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class ImgListForCulbsActivityPresenter extends RxPresenter<ImgListForCulbsActivityContract.View> implements ImgListForCulbsActivityContract.Presenter {


    private Api api;


    @Inject
    public ImgListForCulbsActivityPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void getClubImages(String APPUserId, String ClubId, String token) {
        Subscription subscription = api.getClubImages(APPUserId  ,ClubId  ,token)
                .compose(RxUtil.<ClubImagesBean>rxSchedulerHelper())
                .subscribe(new Action1<ClubImagesBean>() {
                    @Override
                    public void call(ClubImagesBean normalResponse) {
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