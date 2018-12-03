package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyGroupClass.Details;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyGroupLessonDetailBean;
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

public class DetailsActivityPresenter extends RxPresenter<DetailsActivityContract.View> implements DetailsActivityContract.Presenter {


    private Api api;


    @Inject
    public DetailsActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getMyGroupLessonDetail(String ClubId, String MemberId, int Id, String token) {
        Subscription subscription = api.getMyGroupLessonDetail(ClubId  ,MemberId  ,Id  ,token)
                .compose(RxUtil.<MyGroupLessonDetailBean>rxSchedulerHelper())
                .subscribe(new Action1<MyGroupLessonDetailBean>() {
                    @Override
                    public void call(MyGroupLessonDetailBean normalResponse) {
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