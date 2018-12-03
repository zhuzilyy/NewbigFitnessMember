package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.PrivateClassDetails;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubLessonDetailBean;
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

public class PrivateClassDetailsActivityPresenter extends RxPresenter<PrivateClassDetailsActivityContract.View> implements PrivateClassDetailsActivityContract.Presenter {


    private Api api;


    @Inject
    public PrivateClassDetailsActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getClubLessonDetail(String APPUserId, String token, String ClubId, String LessonId) {
        Subscription subscription = api.getClubLessonDetail(APPUserId  ,token  ,ClubId  ,LessonId)
                .compose(RxUtil.<ClubLessonDetailBean>rxSchedulerHelper())
                .subscribe(new Action1<ClubLessonDetailBean>() {
                    @Override
                    public void call(ClubLessonDetailBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeed(normalResponse);
                        } else {
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
//                        mView.showError("服务器请求失败");
                    }
                });
        addSubscription(subscription);
    }
}