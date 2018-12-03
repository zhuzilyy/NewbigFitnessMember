package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.RenewCard.Number;

import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;

import javax.inject.Inject;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class RenewNumberCardActivityPresenter extends RxPresenter<RenewNumberCardActivityContract.View> implements RenewNumberCardActivityContract.Presenter {


    private Api api;


    @Inject
    public RenewNumberCardActivityPresenter(Api api) {
        this.api = api;
    }


    //    @Override
//    public void getCustomerList(String UserName, int UserId, int DepartId  ,String token, int ClubId, int IsDepartManager, int CurrentPage, int type, String SearchKey, String Sex, String IntentId, String SourceId, String StartCreateTime, String EndCreateTime, String CreateUserId, String IntroduceMemberId, String LabelId, String OwnManagerId, String StartLastContactTime, String EndLastContactTime, String sort, String order) {
//
//
//
//        Subscription subscription = api.getCustomerList(UserName  ,UserId  ,DepartId,token  ,ClubId  ,IsDepartManager  ,CurrentPage  ,type  ,SearchKey  ,Sex  ,IntentId  ,SourceId  ,StartCreateTime  ,EndCreateTime  ,CreateUserId  ,IntroduceMemberId  ,LabelId  ,OwnManagerId  ,StartLastContactTime  ,EndLastContactTime  ,sort  ,order)
//
//                .compose(RxUtil.<CustomerListBean>rxSchedulerHelper())
//
//                .subscribe(new Action1<PublicSeaBean>() {
//                    @Override
//                    public void call(CustomerListBean normalResponse) {
//
//                        if (normalResponse.getCode()==0){
//
//                        System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//
////                        System.out.print(normalResponse.getUrl());
//
//
//                        mView.succeed(normalResponse);
//
//                        }        if (normalResponse.getCode()==250){
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
//
//
//    }
//    }
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
    public void appPublicSeaCustomerList(String UserName, int UserId, String token, int ClubId, int CurrentPage, String StartDate, String EndDate, String PublicSeaId, String sort, String order) {

    }

    @Override
    public void appPublicSeaMemberList(String UserName, int UserId, String token, int ClubId, int CurrentPage, String StartDate, String EndDate, String PublicSeaId, String sort, String order) {

    }

    @Override
    public void appGainCustomer(int UserId, String UserName, String token, int ClubId, String CustomerId) {

    }

    @Override
    public void appUpdateCustomerPublicSeaType(int UserId, String UserName, String token, int ClubId, String CustomerId, String NewPublicSeaId) {

    }

    @Override
    public void appUpdateOwnManagerId(int UserId, String UserName, String token, int ClubId, String CustomerId, String NewOwnmanagerId) {

    }

    @Override
    public void updateMemberOwnTeacherBatch(int UserId, String UserName, String token, int ClubId, String CustomerId, String TeacherId) {

    }
}