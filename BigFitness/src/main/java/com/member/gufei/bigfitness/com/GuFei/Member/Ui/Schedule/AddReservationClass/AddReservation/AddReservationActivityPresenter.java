package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.AddReservationClass.AddReservation;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubFLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

public class AddReservationActivityPresenter extends RxPresenter<AddReservationActivityContract.View> implements AddReservationActivityContract.Presenter {

    private Api api;

    @Inject
    public AddReservationActivityPresenter(Api api){

        this.api = api;

    }

    @Override
    public void getClubFLessonList(String APPUserId, String Token, String ClubId, String LessonDate, String StartTime, int PageIndex) {
        Subscription subscription = api.getClubFLessonList(APPUserId  ,Token  ,ClubId  ,LessonDate  ,StartTime  ,PageIndex)
                .compose(RxUtil.<ClubFLessonListBean>rxSchedulerHelper())
                .subscribe(new Action1<ClubFLessonListBean>() {
                    @Override
                    public void call(ClubFLessonListBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeed(normalResponse);
                        } else {
                            mView.showError(normalResponse.getMsg());
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
