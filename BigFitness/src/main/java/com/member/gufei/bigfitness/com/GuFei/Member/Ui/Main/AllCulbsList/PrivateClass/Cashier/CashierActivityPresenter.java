package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.Cashier;

import android.widget.Toast;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.AddFeeMemberLessonPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.AppBuyLessonPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.AppBuyMemberLessonPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.NewAppBuyMemberCardPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.PayForAliPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.RenewMemberCardPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.UpMemberCardPayBean;
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

public class CashierActivityPresenter extends RxPresenter<CashierActivityContract.View> implements CashierActivityContract.Presenter {


    private Api api;


    @Inject
    public CashierActivityPresenter(Api api) {
        this.api = api;
    }


    //购买会员卡
    @Override
    public void appBuyMemberCardPay(String APPUserId, String Token, String ClubId, String MemberCardTypeId, String Amount, String Price, String TotalMoney, String PayMode) {
        Subscription subscription;

        subscription = api.newAppBuyMemberCardPayBean(APPUserId, Token, ClubId, MemberCardTypeId, Amount, Price, TotalMoney, PayMode)
                .compose(RxUtil.<NewAppBuyMemberCardPayBean>rxSchedulerHelper())
                .subscribe(new Action1<NewAppBuyMemberCardPayBean>() {
                    @Override
                    public void call(NewAppBuyMemberCardPayBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeedCard(normalResponse);
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

    //购买私教课
    @Override
    public void appBuyMemberLessonPay(String APPUserId, String Token, String ClubId, String LessonId, String TeacherId, String Amount, Double Price, Double TotalMoney, String PayMode) {
        Subscription subscription;

            subscription = api.appBuyMemberLessonPay(APPUserId, Token, ClubId, LessonId, TeacherId, Amount, Price, TotalMoney, PayMode)
                    .compose(RxUtil.<AppBuyMemberLessonPayBean>rxSchedulerHelper())
                    .subscribe(new Action1<AppBuyMemberLessonPayBean>() {
                        @Override
                        public void call(AppBuyMemberLessonPayBean normalResponse) {
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

    //会员卡续费
    @Override
    public void appRenewMemberCardPay(String APPUserId, String Token, String ClubId, String MemberCardId, String Amount, String Price, String TotalMoney, String PayMode) {
        Subscription subscription;

        subscription = api.getRenewMemberCardPay(APPUserId, Token, ClubId, MemberCardId, Amount, Price, TotalMoney, PayMode)
                .compose(RxUtil.<RenewMemberCardPayBean>rxSchedulerHelper())
                .subscribe(new Action1<RenewMemberCardPayBean>() {
                    @Override
                    public void call(RenewMemberCardPayBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeedRenew(normalResponse);
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

    //私教课续费
    @Override
    public void appRenewMemberLessonPay(String APPUserId, String Token, String ClubId, String Id, String Amount, String Price, String TotalMoney, String PayMode) {
        Subscription subscription;

        subscription = api.getAddFeeMemberLessonPay(APPUserId, Token, ClubId, Id, Amount, Price, TotalMoney, PayMode)
                .compose(RxUtil.<AddFeeMemberLessonPayBean>rxSchedulerHelper())
                .subscribe(new Action1<AddFeeMemberLessonPayBean>() {
                    @Override
                    public void call(AddFeeMemberLessonPayBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeedRenewLesson(normalResponse);
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

    //会员卡升级
    @Override
    public void appUpMemberCardPay(String APPUserId, String Token, String ClubId, String MemberCardId, String NewMemberCardTypeId, String TotalMoney, String PayMode) {
        Subscription subscription;

        subscription = api.getAppUpMemberCardPay(APPUserId, Token, ClubId, MemberCardId, NewMemberCardTypeId,TotalMoney, PayMode)
                .compose(RxUtil.<UpMemberCardPayBean>rxSchedulerHelper())
                .subscribe(new Action1<UpMemberCardPayBean>() {
                    @Override
                    public void call(UpMemberCardPayBean normalResponse) {
                        if (normalResponse.getRet() == 0) {
                            mView.succeedUpCard(normalResponse);
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