package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.ReservationClass.ReservationClassDetails;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.ResBean;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClassAppointmentBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.LandAppUserBean;
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

public class ReservationClassDetailsActivityPresenter extends RxPresenter<ReservationClassDetailsActivityContract.View> implements ReservationClassDetailsActivityContract.Presenter {


    private Api api;


    @Inject
    public ReservationClassDetailsActivityPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void getClubFreeLessonInfo(String ClubId, String Token, String APPUserId, String FLessonId, String StartTime,String LessonDate) {

        Subscription subscription = api.getClubFreeLessonInfo(ClubId, Token, APPUserId,FLessonId,StartTime,LessonDate)

                .compose(RxUtil.<ResBean>rxSchedulerHelper())
                .subscribe(new Action1<ResBean>() {
                    @Override
                    public void call(ResBean resBean) {
                        if (resBean.getRet() == 0) {
                            mView.succeed(resBean);
                        } else {
                            mView.showError(resBean.getMsg());
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

    //操课预约
    @Override
    public void getClassAppointment(String APPUserId, String Token, String ClubId, String FLessonId, String MemberId, String LessonDate) {

        Subscription subscription = api.classAppointment(APPUserId, Token, ClubId, FLessonId, MemberId, LessonDate)

                .compose(RxUtil.<ClassAppointmentBean>rxSchedulerHelper())
                .subscribe(new Action1<ClassAppointmentBean>() {
                    @Override
                    public void call(ClassAppointmentBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.classsucceed(normalResponse);
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