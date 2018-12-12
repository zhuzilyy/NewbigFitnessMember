package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList;

import android.util.Log;
import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubListForMemberBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubListForMemberNoBuyBean;
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

public class AllCulbsListPresenter extends RxPresenter<AllCulbsListContract.View> implements AllCulbsListContract.Presenter {


    private Api api;


    @Inject
    public AllCulbsListPresenter(Api api) {
        this.api = api;
    }



    @Override
    public void getClubListForMember(String APPUserId, String token, String currentPage, String UserPosition) {
        Subscription subscription = api.getClubListForMember(APPUserId  ,token  ,currentPage  ,UserPosition)
                .compose(RxUtil.<ClubListForMemberBean>rxSchedulerHelper())
                .subscribe(new Action1<ClubListForMemberBean>() {
                    @Override
                    public void call(ClubListForMemberBean normalResponse) {
                        int ret = normalResponse.getRet();
                        if (normalResponse.getRet() == 0 || normalResponse.getRet() == 2 || normalResponse.getRet() == 1 || normalResponse.getRet() == 3) {
                            mView.succeed(normalResponse);
                        } else {
                            mView.unsucceed();
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        String message = throwable.getMessage();
                        mView.outLogin();
                    }
                });
        addSubscription(subscription);
    }

//    @Override
//    public void getClubListForMemberNoBuy(String APPUserId, String ClubId, String token, String lat, String lng) {
//
//        Subscription subscription = api.getClubListForMemberNoBuy(APPUserId  ,ClubId  ,token  ,lat  ,lng)
//                .compose(RxUtil.<ClubListForMemberNoBuyBean>rxSchedulerHelper())
//                .subscribe(new Action1<ClubListForMemberNoBuyBean>() {
//                    @Override
//                    public void call(ClubListForMemberNoBuyBean normalResponse) {
//
//                        if (normalResponse.getRet() == 0 || normalResponse.getRet() == 2 || normalResponse.getRet() == 1) {
//
//                            mView.succeedNoBuy(normalResponse);
//                        } else {
//                        }
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        mView.showError("服务器请求失败");
//                    }
//                });
//        addSubscription(subscription);
//
//    }
}