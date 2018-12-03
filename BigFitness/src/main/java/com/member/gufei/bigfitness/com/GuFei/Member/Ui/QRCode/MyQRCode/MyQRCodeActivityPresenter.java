package com.member.gufei.bigfitness.com.GuFei.Member.Ui.QRCode.MyQRCode;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyTwoDimensionCodeBean;
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

public class MyQRCodeActivityPresenter extends RxPresenter<MyQRCodeActivityContract.View> implements MyQRCodeActivityContract.Presenter {


    private Api api;


    @Inject
    public MyQRCodeActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getMyTwoDimensionCode(String APPUserId, String token) {
        Subscription subscription = api.getMyTwoDimensionCode(APPUserId  ,token)
                .compose(RxUtil.<MyTwoDimensionCodeBean>rxSchedulerHelper())
                .subscribe(new Action1<MyTwoDimensionCodeBean>() {
                    @Override
                    public void call(MyTwoDimensionCodeBean normalResponse) {
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