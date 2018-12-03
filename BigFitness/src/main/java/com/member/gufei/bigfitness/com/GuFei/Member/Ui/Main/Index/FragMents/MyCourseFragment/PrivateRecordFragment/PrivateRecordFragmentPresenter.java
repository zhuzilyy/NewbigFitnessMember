package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyCourseFragment.PrivateRecordFragment;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClassLessonListBean;
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

public class PrivateRecordFragmentPresenter extends RxPresenter<PrivateRecordFragmentContract.View> implements PrivateRecordFragmentContract.Presenter {


    private Api api;


    @Inject
    public PrivateRecordFragmentPresenter(Api api) {
        this.api = api;
    }




    @Override
    public void getClassLessonList(String APPUserId, String ClubId, String token, int PageIndex, int MemberId) {
        Subscription subscription = api.getClassLessonList(APPUserId  ,ClubId  ,token  ,PageIndex  ,MemberId)
                .compose(RxUtil.<ClassLessonListBean>rxSchedulerHelper())
                .subscribe(new Action1<ClassLessonListBean>() {
                    @Override
                    public void call(ClassLessonListBean normalResponse) {
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