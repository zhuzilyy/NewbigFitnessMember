package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.UpGradeCard;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MemberCardOnlineUpInfoBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.UpGradeCardListBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class UpGradeCardActivityPresenter extends RxPresenter<UpGradeCardActivityContract.View> implements UpGradeCardActivityContract.Presenter {


    private Api api;


    @Inject
    public UpGradeCardActivityPresenter(Api api) {
        this.api = api;
    }

    //获取会员卡升级列表
    @Override
    public void appMemberUpGradeCardList(String ClubId, String Token, String MemberCardTypeId) {
        Subscription subscription = api.appMemberUpGradeCardList(ClubId  ,Token  , MemberCardTypeId)
                .compose(RxUtil.<UpGradeCardListBean>rxSchedulerHelper())
                .subscribe(new Action1<UpGradeCardListBean>() {
                    @Override
                    public void call(UpGradeCardListBean normalResponse) {

                        if (normalResponse.getRet() == 0 ) {

                            mView.succeedUp(normalResponse);
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

    //我的会员卡升级信息
    @Override
    public void appMemberCardOnlineUpInfo(String MemberCardTypeId, String NewMemberCardTypeId, String ExpireTime, String Token) {
        Subscription subscription = api.getMemberCardOnlineUpInfo(MemberCardTypeId  ,NewMemberCardTypeId  , ExpireTime, Token)
                .compose(RxUtil.<MemberCardOnlineUpInfoBean>rxSchedulerHelper())
                .subscribe(new Action1<MemberCardOnlineUpInfoBean>() {
                    @Override
                    public void call(MemberCardOnlineUpInfoBean normalResponse) {

                        if (normalResponse.getRet() == 0 ) {

                            mView.succeedUpInfo(normalResponse);
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