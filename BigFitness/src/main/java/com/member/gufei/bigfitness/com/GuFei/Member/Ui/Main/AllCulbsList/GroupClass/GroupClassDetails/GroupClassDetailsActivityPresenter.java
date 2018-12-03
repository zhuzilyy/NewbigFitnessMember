package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.GroupClass.GroupClassDetails;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubGroupLessonDetailBean;
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

public class GroupClassDetailsActivityPresenter extends RxPresenter<GroupClassDetailsActivityContract.View> implements GroupClassDetailsActivityContract.Presenter {


    private Api api;


    @Inject
    public GroupClassDetailsActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getClubGroupLessonDetail(String APPUserId, String token, String ClubId, String GroupLessonId) {
        Subscription subscription = api.getClubGroupLessonDetail(APPUserId, token, ClubId, GroupLessonId)
                .compose(RxUtil.<ClubGroupLessonDetailBean>rxSchedulerHelper())
                .subscribe(new Action1<ClubGroupLessonDetailBean>() {
                    @Override
                    public void call(ClubGroupLessonDetailBean normalResponse) {
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