package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.AerobicsClass.CoachDetails;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubTeacherDetailBean;
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

public class CoachDetailsActivityPresenter extends RxPresenter<CoachDetailsActivityContract.View> implements CoachDetailsActivityContract.Presenter {


    private Api api;


    @Inject
    public CoachDetailsActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getClubTeacherDetail(String APPUserId, String token, String ClubId, String TeacherId) {
        Subscription subscription = api.getClubTeacherDetail(APPUserId  ,token  ,ClubId  ,TeacherId)
                .compose(RxUtil.<ClubTeacherDetailBean>rxSchedulerHelper())
                .subscribe(new Action1<ClubTeacherDetailBean>() {
                    @Override
                    public void call(ClubTeacherDetailBean normalResponse) {

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