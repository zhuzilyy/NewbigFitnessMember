package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C5;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubLessonTeacherListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubTeacherListBean;
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

public class IndexFragMentC5Presenter extends RxPresenter<IndexFragMentC5Contract.View> implements IndexFragMentC5Contract.Presenter {


    private Api api;


    @Inject
    public IndexFragMentC5Presenter(Api api) {
        this.api = api;
    }

    @Override
    public void getClubTeacherList(String APPUserId, String token, String ClubId, int currentPage) {
        Subscription subscription = api.getClubTeacherList(APPUserId  ,token  ,ClubId  ,currentPage)
                .compose(RxUtil.<ClubTeacherListBean>rxSchedulerHelper())
                .subscribe(new Action1<ClubTeacherListBean>() {
                    @Override
                    public void call(ClubTeacherListBean normalResponse) {

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