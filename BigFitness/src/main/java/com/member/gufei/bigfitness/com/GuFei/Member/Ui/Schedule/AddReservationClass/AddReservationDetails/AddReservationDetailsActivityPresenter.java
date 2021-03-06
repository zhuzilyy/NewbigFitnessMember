package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.AddReservationClass.AddReservationDetails;

import com.member.gufei.bigfitness.base.RxPresenter;

import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class AddReservationDetailsActivityPresenter extends RxPresenter<AddReservationDetailsActivityContract.View> implements AddReservationDetailsActivityContract.Presenter {


    private Api api;


    @Inject
    public AddReservationDetailsActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void AddMemberLessonAppointment(String APPUserId, String ClubId, String MemberId, String LessonId,  String AppointmentTeacherId, String Content, String token, String StartTime, String EndTime, String TipStartTime, String TipInterval, String AppointmentCata, String AppointmentOwner, String AppointmentStatus) {
        Subscription subscription = api.AddMemberLessonAppointment(APPUserId  ,ClubId  ,MemberId  ,LessonId    ,AppointmentTeacherId  ,Content  ,token  ,StartTime  ,EndTime  ,TipStartTime  ,TipInterval  ,AppointmentCata  ,AppointmentOwner  ,AppointmentStatus)
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeed(normalResponse);
                        } else if (normalResponse.getRet() == 3){
                            mView.showError("私教课剩余次数不足！");
                        }else if (normalResponse.getRet() == -1){
                            mView.showError("系统异常！");
                        }else {
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