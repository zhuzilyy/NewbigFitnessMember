package com.member.gufei.bigfitness.com.GuFei.Member.Ui.InformationClass.Notice;

import android.widget.Toast;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.NoticeListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class NoticeListActivityPresenter extends RxPresenter<NoticeListActivityContract.View> implements NoticeListActivityContract.Presenter {


    private Api api;


    @Inject
    public NoticeListActivityPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void getNoticeList(String APPUserId, String token, String PageIndex, String PageSize, String MsgTypeId) {
        Subscription subscription = api.getNoticeList(APPUserId  ,token  ,PageIndex  ,PageSize, MsgTypeId)
                .compose(RxUtil.<NoticeListBean>rxSchedulerHelper())
                .subscribe(new Action1<NoticeListBean>() {
                    @Override
                    public void call(NoticeListBean normalResponse) {


                        if (normalResponse.getRet() == 0 ) {

                            mView.succeed(normalResponse);
                        } else {
                            mView.unsucceed();
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

    //阅读消息，标记为已读
    @Override
    public void getReadMessage(String APPUserId, String token, String RowId, String IsAPPPush) {
        Subscription subscription = api.getIsRead(APPUserId  ,token  ,RowId, IsAPPPush)
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {


                        if (normalResponse.getRet() == 0 ) {

                            mView.succeedRead(normalResponse);
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

    //删除通知
    @Override
    public void getDeleteMessage(String APPUserId, String token, String RowId, String IsAPPPush) {
        Subscription subscription = api.getDelete(APPUserId  ,token  ,RowId, IsAPPPush )
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {


                        if (normalResponse.getRet() == 0 ) {

                            mView.succeedDelete(normalResponse);
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

    //全部标记为已读
    @Override
    public void getAllRead(String APPUserId, String token, String MsgTypeId) {

        Subscription subscription = api.getAllRead(APPUserId  ,token  ,MsgTypeId )
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {


                        if (normalResponse.getRet() == 0 ) {

                            mView.succeedAllRead(normalResponse);
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

    //删除全部已读
    @Override
    public void getAllDelete(String APPUserId, String token, String MsgTypeId) {
        Subscription subscription = api.getAllDelete(APPUserId  ,token  ,MsgTypeId )
                .compose(RxUtil.<CodeBean>rxSchedulerHelper())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean normalResponse) {


                        if (normalResponse.getRet() == 0 ) {

                            mView.succeedAllDelete(normalResponse);
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