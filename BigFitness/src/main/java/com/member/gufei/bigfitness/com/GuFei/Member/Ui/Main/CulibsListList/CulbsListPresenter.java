package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.CulibsListList;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;

import javax.inject.Inject;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class CulbsListPresenter extends RxPresenter<CulbsListContract.View> implements CulbsListContract.Presenter {


    private Api api;


    @Inject
    public CulbsListPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void updateMemberLessonTeacher(int UserId, String UserName, String token, int ClubId, String CustomerId, String TeacherId) {
//        Subscription subscription = api.updateMemberLessonTeacher(UserId, UserName, token, ClubId, CustomerId, TeacherId)
//
//                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
//
//                .subscribe(new Action1<CodeBean>() {
//                    @Override
//                    public void call(CodeBean normalResponse) {
//
//                        if (normalResponse.getCode() == 0) {
//
//                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//
////                        System.out.print(normalResponse.getUrl());
//
//                            Toast.makeText(App.context, "变更跟进教练成功!", Toast.LENGTH_SHORT).show();
//                           mView.succeedEdit(normalResponse);
//
//                        }
//                        if (normalResponse.getCode() == 250) {
//
//                            mView.outLogin();
//
//                        }
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
    public void updateMemberOwnTeacherBatch(int UserId, String UserName, String token, int ClubId, String CustomerId, String TeacherId) {
//        Subscription subscription = api.updateMemberOwnTeacherBatch(UserId, UserName, token, ClubId, CustomerId, TeacherId)
//
//                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
//
//                .subscribe(new Action1<CodeBean>() {
//                    @Override
//                    public void call(CodeBean normalResponse) {
//
//                        if (normalResponse.getCode() == 0) {
//
//                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//
////                        System.out.print(normalResponse.getUrl());
//
//                            Toast.makeText(App.context, "变更跟进教练成功!", Toast.LENGTH_SHORT).show();
//                           mView.succeedEdit(normalResponse);
//
//                        }
//                        if (normalResponse.getCode() == 250) {
//
//                            mView.outLogin();
//
//                        }
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
    public void appUpdateOwnManagerId(int UserId, String UserName, String token, int ClubId, String CustomerId, String NewOwnmanagerId) {
//        Subscription subscription = api.appUpdateOwnManagerId(UserId, UserName, token, ClubId, CustomerId, NewOwnmanagerId)
//
//                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
//
//                .subscribe(new Action1<CodeBean>() {
//                    @Override
//                    public void call(CodeBean normalResponse) {
//
//                        if (normalResponse.getCode() == 0) {
//
//                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//
////                        System.out.print(normalResponse.getUrl());
//
//                            Toast.makeText(App.context, "变更会籍成功!", Toast.LENGTH_SHORT).show();
//                            mView.succeedEdit(normalResponse);
//
//                        }
//                        if (normalResponse.getCode() == 250) {
//
//                            mView.outLogin();
//
//                        }
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
    public void appUpdateCustomerPublicSeaType(int UserId, String UserName, String token, int ClubId, String CustomerId, String NewPublicSeaId) {
//        Subscription subscription = api.appUpdateCustomerPublicSeaType(
//                UserId, UserName, token, ClubId, CustomerId, NewPublicSeaId)
//
//                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
//
//                .subscribe(new Action1<CodeBean>() {
//                    @Override
//                    public void call(CodeBean normalResponse) {
//
//                        if (normalResponse.getCode() == 0) {
//
//                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//                            Toast.makeText(App.context, "变更公海成功!", Toast.LENGTH_SHORT).show();
////                        System.out.print(normalResponse.getUrl());
//
//
//                            mView.succeedEdit(normalResponse);
//
//                        }
//                        if (normalResponse.getCode() == 250) {
//
//                            mView.outLogin();
//
//                        }
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
    public void appGainCustomer(int UserId, String UserName, String token, int ClubId, String CustomerId) {
//        Subscription subscription = api.appGainCustomer(
//                UserId, UserName, token, ClubId, CustomerId)
//
//                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
//
//                .subscribe(new Action1<CodeBean>() {
//                    @Override
//                    public void call(CodeBean normalResponse) {
//
//                        if (normalResponse.getCode() == 0) {
//
//                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//                            Toast.makeText(App.context, "捞取成功!", Toast.LENGTH_SHORT).show();
////                        System.out.print(normalResponse.getUrl());
//
//
//                            mView.succeedEdit(normalResponse);
//
//                        }
//                        if (normalResponse.getCode() == 250) {
//
//                            mView.outLogin();
//
//                        }
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
    public void appPublicSeaCustomerList(String UserName, int UserId, String token, int ClubId, int CurrentPage, String StartDate, String EndDate, String PublicSeaId, String sort, String order) {
//        Subscription subscription = api.appPublicSeaCustomerList(UserId, token, ClubId, CurrentPage, StartDate, EndDate, PublicSeaId, sort, order)
//
//                .compose(RxUtil.<PublicSeaBean>rxSchedulerHelper())
//
//                .subscribe(new Action1<PublicSeaBean>() {
//                    @Override
//                    public void call(PublicSeaBean normalResponse) {
//
//                        if (normalResponse.getCode() == 0) {
//
//                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//
////                        System.out.print(normalResponse.getUrl());
//
//
//                            mView.succeed(normalResponse);
//
//                        }
//                        if (normalResponse.getCode() == 250) {
//
//                            mView.outLogin();
//
//                        }
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
    public void appPublicSeaMemberList(String UserName, int UserId, String token, int ClubId, int CurrentPage, String StartDate, String EndDate, String PublicSeaId, String sort, String order) {
//        Subscription subscription = api.appPublicSeaMemberList(UserId, token, ClubId, CurrentPage, StartDate, EndDate, PublicSeaId, sort, order)
//
//
//
//                .compose(RxUtil.<PublicSeaMemberBean>rxSchedulerHelper())
//
//                .subscribe(new Action1<PublicSeaMemberBean>() {
//                    @Override
//                    public void call(PublicSeaMemberBean normalResponse) {
//
//                        if (normalResponse.getCode() == 0) {
//
//                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//
////                        System.out.print(normalResponse.getUrl());
//
//
//                            mView.membersucceed(normalResponse);
//
//                        }
//                        if (normalResponse.getCode() == 250) {
//
//                            mView.outLogin();
//
//                        }
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
}