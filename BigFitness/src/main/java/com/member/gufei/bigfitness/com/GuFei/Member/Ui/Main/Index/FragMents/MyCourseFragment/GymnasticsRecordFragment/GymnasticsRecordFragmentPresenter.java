package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyCourseFragment.GymnasticsRecordFragment;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.FreeLessonClassRecordBean;
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

public class GymnasticsRecordFragmentPresenter extends RxPresenter<GymnasticsRecordFragmentContract.View> implements GymnasticsRecordFragmentContract.Presenter {


    private Api api;


    @Inject
    public GymnasticsRecordFragmentPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void getFreeLessonClassRecord(String APPUserId, String ClubId, String token, int PageIndex, String MemberId) {
        Subscription subscription = api.getFreeLessonClassRecord(APPUserId  ,ClubId  ,token  ,PageIndex  ,MemberId)
                .compose(RxUtil.<FreeLessonClassRecordBean>rxSchedulerHelper())
                .subscribe(new Action1<FreeLessonClassRecordBean>() {
                    @Override
                    public void call(FreeLessonClassRecordBean normalResponse) {
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