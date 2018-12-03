package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCourseList.SchoolRecordsList;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClassLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClassLessonRecordListBean;
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

public class SchoolRecordsListActivityPresenter extends RxPresenter<SchoolRecordsListActivityContract.View> implements SchoolRecordsListActivityContract.Presenter {


    private Api api;


    @Inject
    public SchoolRecordsListActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getLessonClassRecord(String APPUserId, String ClubId, String token, int PageIndex, int MemberId, String LessonId, String ComeLogId) {
        Subscription subscription = api.getLessonClassRecord(APPUserId  ,ClubId  ,token  ,PageIndex  ,MemberId,LessonId, ComeLogId)
                .compose(RxUtil.<ClassLessonRecordListBean>rxSchedulerHelper())
                .subscribe(new Action1<ClassLessonRecordListBean>() {
                    @Override
                    public void call(ClassLessonRecordListBean normalResponse) {
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