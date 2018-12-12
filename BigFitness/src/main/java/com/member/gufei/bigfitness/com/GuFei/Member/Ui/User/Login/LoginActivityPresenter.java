package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login;

import android.util.Log;

import com.google.gson.Gson;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.FitnessRequestBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.LandAppUserBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.LoginBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.ProgressBar.LoadingDialog;
import com.member.gufei.bigfitness.util.RxUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class LoginActivityPresenter extends RxPresenter<LoginActivityContract.View> implements LoginActivityContract.Presenter {


    private Api api;


    @Inject
    public LoginActivityPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void landAppUser(final String userName, final String password, final String DeviceCode, final boolean remember, String DeviceType) {
        mView.Loading();
//        RequestParams params = new RequestParams("http://jy00712345.55555.io:8081/appUser/landAppUser?AccountName=zws&Pwd=123456&DeviceCode=75ea31597974e1736bf09f09df6aa1e2");
//        params.addQueryStringParameter("AccountName",userName);
//        params.addQueryStringParameter("Pwd",password);
//        params.addQueryStringParameter("DeviceCode",DeviceCode);
//        x.http().get(params, new Callback.CommonCallback<String>() {
//                    @Override
//                    public void onSuccess(String result) {
//
//                        LandAppUserBean normalResponse = new Gson().fromJson(result, LandAppUserBean.class);
//                        //解析result
//                        if (normalResponse.getRet() == 0) {
//                            // TODO: 2018/4/17   当无健身需求的时候 接口的错误码为-1
//                            mView.succeed(normalResponse);
//
//                            if (remember) {
//
//                                mView.remember(userName, password, DeviceCode, normalResponse, true);
//
//                            } else {
//
//                                mView.remove();
//                                mView.remember(userName, password, DeviceCode, normalResponse, false);
//                            }
//
//                        } else {
//
//                            mView.showError(normalResponse.getMsg());
//                        }
//                    }
//
//                    //请求异常后的回调方法
//                    @Override
//                    public void onError(Throwable ex, boolean isOnCallback) {
//                        Log.e("Throwable",ex.toString());
//                    }
//
//                    //主动调用取消请求的回调方法
//                    @Override
//                    public void onCancelled(CancelledException cex) {
//                        Log.e("Throwable",cex.toString());
//                    }
//
//                    @Override
//                    public void onFinished() {
//                        mView.showError("服务器请求失败");
//                    }
//                }
//            );
            Subscription subscription = api.landAppUser(userName, password, DeviceCode, DeviceType)

                .compose(RxUtil.<LandAppUserBean>rxSchedulerHelper())

                .subscribe(new Action1<LandAppUserBean>() {
                    @Override
                    public void call(LandAppUserBean normalResponse) {

                        if (normalResponse.getRet() == 0) {
                            // TODO: 2018/4/17   当无健身需求的时候 接口的错误码为-1
                            mView.succeed(normalResponse);
                            if (remember) {
                                mView.remember(userName, password, DeviceCode, normalResponse, true);
                            } else {
                                mView.remove();
                                mView.remember(userName, password, DeviceCode, normalResponse, false);
                            }
                        } else {
                            mView.showError(normalResponse.getMsg());
                        }
                    }
                }
                , new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError("服务器请求失败");
                    }
                }
                );
        addSubscription(subscription);
    }

    @Override
    public void getFitnessRequest(String token) {
        Subscription subscription = api.getFitnessRequest(token)
                .compose(RxUtil.<FitnessRequestBean>rxSchedulerHelper())
                .subscribe(new Action1<FitnessRequestBean>() {
                    @Override
                    public void call(FitnessRequestBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.FitnessRequestsucceed(normalResponse);
                        } else {
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e("Throwable",throwable.toString());
                        mView.showError("服务器请求失败");
                    }
                });
        addSubscription(subscription);
    }
}