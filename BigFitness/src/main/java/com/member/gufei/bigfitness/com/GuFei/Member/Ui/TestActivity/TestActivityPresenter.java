package com.member.gufei.bigfitness.com.GuFei.Member.Ui.TestActivity;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class TestActivityPresenter extends RxPresenter<TestActivityContract.View> implements TestActivityContract.Presenter {


    private Api api;


    @Inject
    public TestActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getCustomerInfoById(int UserId, String token, int ClubId, String UserName, String CustomerId) {



    }


    @Override
    public void EditCustomer(int UserId, String token, int ClubId, String UserName, String CustomerName, String IntentId, String IntroduceMemberId, String LabelId, String OwnManagerId, String Remark, String Sex, String SourceId, String Tel, String Presalemembercardtypeid, String Presalemoney,String CustomerId) {
//        Subscription subscription = api.EditCustomer(UserId, token, ClubId, UserName, CustomerName, IntentId, IntroduceMemberId, LabelId, OwnManagerId, Remark, Sex, SourceId, Tel, Presalemembercardtypeid, Presalemoney,CustomerId)
//                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
//                .subscribe(new Action1<CodeBean>() {
//                    @Override
//                    public void call(CodeBean normalResponse) {
//                        if (normalResponse.getCode() == 0) {
//
//                            mView.EditSuccess(normalResponse);
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
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        mView.showError("加载失败");
//                    }
//                });
//        addSubscription(subscription);
    }
}