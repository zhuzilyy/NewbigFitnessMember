package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class IndexFragMentPresenter extends RxPresenter<IndexFragMentContract.View> implements IndexFragMentContract.Presenter {


    private Api api;


    @Inject
    public IndexFragMentPresenter(Api api) {
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
}