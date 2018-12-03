package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.GroupClass.EvaluateListForGroupLesson;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubGroupLessonEvaluateListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubLessonEvaluateStarTotalBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class EvaluateListForGroupLessonActivityPresenter extends RxPresenter<EvaluateListForGroupLessonActivityContract.View> implements EvaluateListForGroupLessonActivityContract.Presenter {


    private Api api;


    @Inject
    public EvaluateListForGroupLessonActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getClubGroupLessonEvaluateList(String APPUserId, String Token, String ClubId, String GroupLessonId, int IsOnlyShowContent, int Star, int PageIndex) {
        Subscription subscription = api.getClubGroupLessonEvaluateList(APPUserId  ,Token  ,ClubId  ,GroupLessonId  ,IsOnlyShowContent  ,Star  ,PageIndex)
                .compose(RxUtil.<ClubGroupLessonEvaluateListBean>rxSchedulerHelper())
                .subscribe(new Action1<ClubGroupLessonEvaluateListBean>() {
                    @Override
                    public void call(ClubGroupLessonEvaluateListBean normalResponse) {
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