package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCourseList.RemedialApplication;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClassLessonRecordListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by LiuShengYuan on 2018/10/12
 */

public class RemedialApplicationActivityPresenter extends RxPresenter<RemedialApplicationActivityContract.View> implements RemedialApplicationActivityContract.Presenter {
    private Api api;


    @Inject
    public RemedialApplicationActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getAddLessonMakeUp(String APPUserId, String ClubId, String token, String LessonId, String AppointmentId, String Cause) {
        Subscription subscription = api.getAddLessonMakeUpApply(APPUserId  ,ClubId  ,token  ,LessonId  ,AppointmentId  ,Cause)
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {
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
