package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyCourseFragment.MyOthersFragment;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyCourseFragment.MyGymnasticsFragment.MyGymnasticsFragmentContract;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyLessonAppListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyOthersAppointmentBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by LiuShengYuan 2018/9/20
 */

public class MyOthersFragmentPresenter extends RxPresenter<MyOthersFragmentContract.View> implements MyOthersFragmentContract.Presenter{
    private Api api;


    @Inject
    public MyOthersFragmentPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getMyOthersAppointmentList(String APPUserId, String ClubId, String Token, int PageIndex, int PageSize) {
        Subscription subscription = api.getMyOthersAppointmentList(APPUserId  ,ClubId  ,Token, PageIndex, PageSize)
                .compose(RxUtil.<MyOthersAppointmentBean>rxSchedulerHelper())
                .subscribe(new Action1<MyOthersAppointmentBean>() {
                    @Override
                    public void call(MyOthersAppointmentBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeed(normalResponse);
                        } else if (normalResponse.getRet()==1){
                            mView.outLogin();
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

    //确认预约
    @Override
    public void getMyOthersSubmit(String APPUserId, String ClubId, String Token, String MemberId, String AppointmentId) {
        Subscription subscription = api.getMyOthersAppointmentSubmit(APPUserId  ,ClubId  ,Token, MemberId, AppointmentId)
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeedSubmit(normalResponse);
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

    //取消预约
    @Override
    public void getMyOthersCancel(String APPUserId, String ClubId, String Token, String MemberId, String AppointmentId) {

        Subscription subscription = api.getMyOthersAppointmentCancel(APPUserId  ,ClubId  ,Token, MemberId, AppointmentId)
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeedCancel(normalResponse);
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
