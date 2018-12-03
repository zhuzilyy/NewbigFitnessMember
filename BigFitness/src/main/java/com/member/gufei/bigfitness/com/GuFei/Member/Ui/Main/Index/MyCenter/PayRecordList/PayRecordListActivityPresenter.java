package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.PayRecordList;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ConsumptionRecordBean;
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

public class PayRecordListActivityPresenter extends RxPresenter<PayRecordListActivityContract.View> implements PayRecordListActivityContract.Presenter {


    private Api api;


    @Inject
    public PayRecordListActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getConsumptionRecord(String APPUserId, String ClubId, String token, int PageIndex) {
        Subscription subscription = api.getConsumptionRecord(APPUserId  ,ClubId  ,token  ,PageIndex)
                .compose(RxUtil.<ConsumptionRecordBean>rxSchedulerHelper())
                .subscribe(new Action1<ConsumptionRecordBean>() {
                    @Override
                    public void call(ConsumptionRecordBean normalResponse) {
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