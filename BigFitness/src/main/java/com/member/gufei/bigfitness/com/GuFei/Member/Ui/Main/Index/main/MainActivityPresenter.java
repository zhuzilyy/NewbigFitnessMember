package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.main;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.base.RxPresenter;
import com.member.gufei.bigfitness.com.GuFei.Model.local.AppPreloadDicBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerIntroducerBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerSourceBean;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.util.RxUtil;
import com.member.gufei.bigfitness.util.SpUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

import static com.member.gufei.bigfitness.Constants.ALLMEMBERCARDTYPEKEY;
import static com.member.gufei.bigfitness.Constants.CARDTYPEKEY;
import static com.member.gufei.bigfitness.Constants.CONTACTTEACHERLISTKEY;
import static com.member.gufei.bigfitness.Constants.CREATEUSERLISTKEY;
import static com.member.gufei.bigfitness.Constants.CUSTOMERAPPOINTMENTTYPEKEY;
import static com.member.gufei.bigfitness.Constants.CUSTOMERINTENTKEY;
import static com.member.gufei.bigfitness.Constants.CUSTOMERINTRODUCERKEY;
import static com.member.gufei.bigfitness.Constants.CUSTOMERSOURCEKEY;
import static com.member.gufei.bigfitness.Constants.CUSTOMERTAGKEY;
import static com.member.gufei.bigfitness.Constants.IDENTIFICATIONKEY;
import static com.member.gufei.bigfitness.Constants.LESSONTEACHERLISTKEY;
import static com.member.gufei.bigfitness.Constants.MANGERLISTKEY;
import static com.member.gufei.bigfitness.Constants.MEMBERAPPOINTMENTTYPEKEY;
import static com.member.gufei.bigfitness.Constants.MEMBERINTENTKEY;
import static com.member.gufei.bigfitness.Constants.POSTEACHERLISTKEY;
import static com.member.gufei.bigfitness.Constants.PUBLICSEATYPEKEY;
import static com.member.gufei.bigfitness.Constants.SALEMEMBERCARDTYPEKEY;
import static com.member.gufei.bigfitness.Constants.SALETEACHERLISTKEY;
import static com.member.gufei.bigfitness.Constants.WARDROBETYPEKEY;
import static com.member.gufei.bigfitness.util.ListUtil.toJson;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class MainActivityPresenter extends RxPresenter<MainActivityContract.View> implements MainActivityContract.Presenter {


    private Api api;


    @Inject
    public MainActivityPresenter(Api api) {
        this.api = api;
    }


    @Override
    public void updata(int userid, String token, int clubid,String IsDepartManager  ,String DepartId  ) {
//        Subscription subscription = api.getappPreloadDic( userid,  token,  clubid,IsDepartManager,DepartId)
//
//                .compose(RxUtil.<AppPreloadDicBean>rxSchedulerHelper())
//
//                .subscribe(new Action1<AppPreloadDicBean>() {
//                    @Override
//                    public void call(AppPreloadDicBean normalResponse) {
//
//                        if (normalResponse.getCode()==0) {
//
//                            SpUtil.put(App.context, CUSTOMERTAGKEY, toJson(normalResponse.getResult().getCustomerTag()));
//
//                            SpUtil.put(App.context, CUSTOMERINTENTKEY, toJson(normalResponse.getResult().getCustomerIntent()));
//
//                            SpUtil.put(App.context, CARDTYPEKEY, toJson(normalResponse.getResult().getCardType()));
//
//                            SpUtil.put(App.context, WARDROBETYPEKEY, toJson(normalResponse.getResult().getWardrobeType()));
//
//                            SpUtil.put(App.context, MEMBERINTENTKEY, toJson(normalResponse.getResult().getMemberIntent()));
//
//                            SpUtil.put(App.context, IDENTIFICATIONKEY, toJson(normalResponse.getResult().getMemberIntent()));
//
//                            SpUtil.put(App.context, MANGERLISTKEY, toJson(normalResponse.getResult().getMangerList()));
//
//                            SpUtil.put(App.context, POSTEACHERLISTKEY, toJson(normalResponse.getResult().getPOSTeacherList()));
//
//                            SpUtil.put(App.context, CONTACTTEACHERLISTKEY, toJson(normalResponse.getResult().getContactTeacherList()));
//
//                            SpUtil.put(App.context, LESSONTEACHERLISTKEY, toJson(normalResponse.getResult().getLessonTeacherList()));
//
//                            SpUtil.put(App.context, SALETEACHERLISTKEY, toJson(normalResponse.getResult().getSaleTeacherList()));
//
//                            SpUtil.put(App.context, PUBLICSEATYPEKEY, toJson(normalResponse.getResult().getPublicSeaType()));
//
//                            SpUtil.put(App.context, CREATEUSERLISTKEY, toJson(normalResponse.getResult().getCreateUserList()));
//
//                            SpUtil.put(App.context, ALLMEMBERCARDTYPEKEY, toJson(normalResponse.getResult().getAllMemberCardType()));
//
//                            SpUtil.put(App.context, SALEMEMBERCARDTYPEKEY, toJson(normalResponse.getResult().getSaleMemberCardType()));
//
//                            SpUtil.put(App.context, CUSTOMERAPPOINTMENTTYPEKEY, toJson(normalResponse.getResult().getCustomerAppointmentType()));
//
//                            SpUtil.put(App.context, MEMBERAPPOINTMENTTYPEKEY, toJson(normalResponse.getResult().getMemberAppointmentType()));
//
//
//
//                            System.out.print("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//                        }          if (normalResponse.getCode()==250){
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
//              mView.showError("服务器请求失败");
//
//
//                    }
//                });
//        addSubscription(subscription);
    }

    @Override
    public void getCustomerSource(int userid, String token, int clubid) {
//        Subscription subscription = api.getCustomerSource( userid,  token,  clubid,"")
//
//                .compose(RxUtil.<CustomerSourceBean>rxSchedulerHelper())
//
//                .subscribe(new Action1<CustomerSourceBean>() {
//                    @Override
//                    public void call(CustomerSourceBean normalResponse) {
//
//                        if (normalResponse.getCode()==0) {
//
//                            SpUtil.put(App.context, CUSTOMERSOURCEKEY, toJson(normalResponse.getResult()));
//
//                        }          if (normalResponse.getCode()==250){
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
    /**
     * //介绍人信息
     */

    @Override
    public void getCustomerIntroducer(int userid, String token, int clubid,String Name) {

//        Subscription subscription = api.getCustomerIntroducer( userid,  token,  clubid,Name)
//
//                .compose(RxUtil.<CustomerIntroducerBean>rxSchedulerHelper())
//
//                .subscribe(new Action1<CustomerIntroducerBean>() {
//                    @Override
//                    public void call(CustomerIntroducerBean normalResponse) {
//
//                        if (normalResponse.getCode()==0) {
//
//                            SpUtil.put(App.context, CUSTOMERINTRODUCERKEY, toJson(normalResponse.getResult()));
//
//                        }           if (normalResponse.getCode()==250){
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
//              mView.showError("服务器请求失败");
//
//
//                    }
//                });
//        addSubscription(subscription);
    }
}