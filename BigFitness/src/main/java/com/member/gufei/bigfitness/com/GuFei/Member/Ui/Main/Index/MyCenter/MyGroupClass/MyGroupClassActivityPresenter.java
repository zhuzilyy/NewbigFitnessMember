package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyGroupClass;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyGroupLessonBean;
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

public class MyGroupClassActivityPresenter extends RxPresenter<MyGroupClassActivityContract.View> implements MyGroupClassActivityContract.Presenter {


    private Api api;


    @Inject
    public MyGroupClassActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getMyGroupLesson(String ClubId, String MemberId, String token, int PageIndex) {
        Subscription subscription = api.getMyGroupLesson(ClubId  ,MemberId  ,token  ,PageIndex)
                .compose(RxUtil.<MyGroupLessonBean>rxSchedulerHelper())
                .subscribe(new Action1<MyGroupLessonBean>() {
                    @Override
                    public void call(MyGroupLessonBean normalResponse) {
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
