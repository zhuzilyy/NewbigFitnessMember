package com.member.gufei.bigfitness;

/**
 * Created by GuFei on 2018/6/22.
 */

public class set {
    // TODO: 2018/6/22  暂时保存请求

    //升级会员卡订单
    //void appUpMemberCardPay(String APPUserId  ,String ClubId  ,String MemberCardId  ,String NewMemberCardTypeId  ,String Amount  ,String Price  ,String TotalMoney  ,String PayMode);

/*    Subscription subscription = api.appUpMemberCardPay(APPUserId  ,ClubId  ,MemberCardId  ,NewMemberCardTypeId  ,Amount  ,Price  ,TotalMoney  ,PayMode)
            .compose(RxUtil.<appUpMemberCardPayBean>rxSchedulerHelper())
            .subscribe(new Action1<appUpMemberCardPayBean>() {
                @Override
                public void call(appUpMemberCardPayBean normalResponse) {
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
    addSubscription(subscription);*/







//购买会员卡订单
//



// 购买私教课订单
//    void appBuyLessonPay(String APPUserId  ,String ClubId  ,String LessonId  ,String TeacherId  ,String Amount  ,String Price  ,String TotalMoney  ,String PayMode);
/*Subscription subscription = api.appBuyLessonPay(APPUserId  ,ClubId  ,LessonId  ,TeacherId  ,Amount  ,Price  ,TotalMoney  ,PayMode)
        .compose(RxUtil.<appBuyLessonPayBean>rxSchedulerHelper())
        .subscribe(new Action1<appBuyLessonPayBean>() {
            @Override
            public void call(appBuyLessonPayBean normalResponse) {
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
    addSubscription(subscription);*/



//购买小团体订单
//void appAddFeeMemberLessonPay(String APPUserId  ,String ClubId  ,String Id  ,String Amount  ,String Price  ,String TotalMoney  ,String PayMode);
/*Subscription subscription = api.appAddFeeMemberLessonPay(APPUserId  ,ClubId  ,Id  ,Amount  ,Price  ,TotalMoney  ,PayMode)
        .compose(RxUtil.<appAddFeeMemberLessonPayBean>rxSchedulerHelper())
        .subscribe(new Action1<appAddFeeMemberLessonPayBean>() {
            @Override
            public void call(appAddFeeMemberLessonPayBean normalResponse) {
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
    addSubscription(subscription);*/

//购买操课订单
//void appBuyGroupLessonPay(String APPUserId  ,String ClubId  ,String GroupLessonId  ,String Amount  ,String Price  ,String TotalMoney  ,String PayMode);
/*Subscription subscription = api.appBuyGroupLessonPay(APPUserId  ,ClubId  ,GroupLessonId  ,Amount  ,Price  ,TotalMoney  ,PayMode)
        .compose(RxUtil.<appBuyGroupLessonPayBean>rxSchedulerHelper())
        .subscribe(new Action1<appBuyGroupLessonPayBean>() {
            @Override
            public void call(appBuyGroupLessonPayBean normalResponse) {
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
    addSubscription(subscription);*/


//接口名称	获取会员卡续费-APP支付订单信息
//void appAddFeeMemberCardPay(String APPUserId  ,String ClubId  ,String MemberCardId  ,String Amount  ,String Price  ,String TotalMoney  ,String PayMode);
//Subscription subscription = api.appAddFeeMemberCardPay(APPUserId  ,ClubId  ,MemberCardId  ,Amount  ,Price  ,TotalMoney  ,PayMode)
//        .compose(RxUtil.<appAddFeeMemberCardPayBean>rxSchedulerHelper())
//        .subscribe(new Action1<appAddFeeMemberCardPayBean>() {
//            @Override
//            public void call(appAddFeeMemberCardPayBean normalResponse) {
//                if (normalResponse.getRet() == 0) {
//                    mView.succeed(normalResponse);
//                } else {
//                }
//            }
//        }, new Action1<Throwable>() {
//            @Override
//            public void call(Throwable throwable) {
//                mView.showError("服务器请求失败");
//            }
//        });
//    addSubscription(subscription);


    // TODO: 2018/6/22  支付宝部分













}
