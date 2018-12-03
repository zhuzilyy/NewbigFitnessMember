package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubInfoByIdBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MemberIdBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class MyScheduleFragMentPresenter extends RxPresenter<MyScheduleFragMentContract.View> implements MyScheduleFragMentContract.Presenter {


    private Api api;


    @Inject
    public MyScheduleFragMentPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void updata(int userid, String token, int clubid) {

//        Subscription subscription = api.getMainList(userid,token,clubid)
//
//                .compose(RxUtil.<MainMsgBean>rxSchedulerHelper())
//
//                .subscribe(new Action1<MainMsgBean>() {
//                    @Override
//                    public void call(MainMsgBean normalResponse) {
//
//
//                        if (normalResponse.getCode() == 0) {
//
//                            mView.succeed(normalResponse);
//
//
//                        } else if (normalResponse.getCode() == 250) {
//
//                            mView.outLogin();
//
//                        } else {
//
//                        }
//
//
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//
////                        mView.showError("服务器请求失败");+
//
//
//                    }
//                });
//        addSubscription(subscription);
    }

    @Override
    public void getSineForMainPage(int userid, String token, int clubid) {
//        Subscription subscription = api.getSineForMainPage(userid,token,clubid)
//
//                .compose(RxUtil.<SineForMainPageBean>rxSchedulerHelper())
//
//                .subscribe(new Action1<SineForMainPageBean>() {
//                    @Override
//                    public void call(SineForMainPageBean normalResponse) {
//                        if (normalResponse.getCode() == 0) {
//
//                            mView.MainPagesucceed(normalResponse);
//
//
//                        } else if (normalResponse.getCode() == 250) {
//
//                            mView.outLogin();
//
//                        } else {
//
//                            mView.showError(normalResponse.getMessage().toString());
//                        }
//
//
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//
//                    mView.showError("服务器请求失败");
//
//
//                    }
//                });
//        addSubscription(subscription);

    }

    @Override
    public void getMemberIdIsLockId(String APPUserId, String ClubId, String token) {
        Subscription subscription = api.getMemberIdIsLock(APPUserId  ,ClubId  ,token)
                .compose(RxUtil.<MemberIdBean>rxSchedulerHelper())
                .subscribe(new Action1<MemberIdBean>() {
                    @Override
                    public void call(MemberIdBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeedMemberId(normalResponse);
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