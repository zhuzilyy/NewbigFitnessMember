package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.CulbsEvaluateList;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubLessonEvaluateStarTotalBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubTeacherEvaluateListBean;
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

public class CulbsEvaluateListActivityPresenter extends RxPresenter<CulbsEvaluateListActivityContract.View> implements CulbsEvaluateListActivityContract.Presenter {


    private Api api;


    @Inject
    public CulbsEvaluateListActivityPresenter(Api api) {
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

//                            mView.succeed(normalResponse);
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

    @Override
    public void getClubevaluateByClubId(String APPUserId, String Token, String ClubId, int IsOnlyShowContent, int Star, int PageIndex) {

        Subscription subscription = api.getClubevaluateByClubId(APPUserId  ,Token  ,ClubId  ,IsOnlyShowContent  ,Star  ,PageIndex)
                .compose(RxUtil.<ClubLessonEvaluateStarTotalBean>rxSchedulerHelper())
                .subscribe(new Action1<ClubLessonEvaluateStarTotalBean>() {
                    @Override
                    public void call(ClubLessonEvaluateStarTotalBean normalResponse) {
                        if (normalResponse.getRet() == 0) {

                            mView.succeed(normalResponse);
                        } else {
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError("已经是最后一页了");
                    }
                });
        addSubscription(subscription);
    }
}