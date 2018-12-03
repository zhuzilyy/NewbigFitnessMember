package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.SelectCocat;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubLessonTeacherListBean;
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

public class SelectCocatActivityPresenter extends RxPresenter<SelectCocatActivityContract.View> implements SelectCocatActivityContract.Presenter {


    private Api api;


    @Inject
    public SelectCocatActivityPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void getClubLessonTeacherList(String APPUserId, String token, String ClubId, String LessonId, int currentPage) {
        Subscription subscription = api.getClubLessonTeacherList(APPUserId  ,token , ClubId,LessonId,currentPage)
                .compose(RxUtil.<ClubLessonTeacherListBean>rxSchedulerHelper())
                .subscribe(new Action1<ClubLessonTeacherListBean>() {
                    @Override
                    public void call(ClubLessonTeacherListBean normalResponse) {


                        if (normalResponse.getRet() == 0 || normalResponse.getRet() == 2) {

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