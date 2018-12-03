package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.Cashier;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
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

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface CashierActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(AppBuyMemberLessonPayBean appBuyMemberLessonPayBean);
        void succeedCard(NewAppBuyMemberCardPayBean newAppBuyMemberCardPayBean);
        void succeedRenew(RenewMemberCardPayBean renewMemberCardPayBean);
        void succeedRenewLesson(AddFeeMemberLessonPayBean addFeeMemberLessonPayBean);
        void succeedUpCard(UpMemberCardPayBean upMemberCardPayBean);
    }

    interface Presenter extends BasePresenter<View> {
//        //会员卡买卡
//        void appBuyMemberCardPay(String APPUserId, String ClubId, String MemberCardTypeId, String Amount, String Price, String TotalMoney, String PayMode);

        //会员卡买卡
        void appBuyMemberCardPay(String APPUserId, String Token, String ClubId, String MemberCardTypeId,
                                 String Amount, String Price, String TotalMoney, String PayMode);
        //私教课付款
        void appBuyMemberLessonPay(String APPUserId, String Token, String ClubId, String LessonId, String TeacherId,
                                   String Amount, Double Price, Double TotalMoney, String PayMode);
        //会员卡续费
        void appRenewMemberCardPay(String APPUserId, String Token, String ClubId, String MemberCardId, String Amount,
                                   String Price, String TotalMoney, String PayMode);
        //私教课续费
        void appRenewMemberLessonPay(String APPUserId, String Token, String ClubId, String Id, String Amount,
                                   String Price, String TotalMoney, String PayMode);
        //会员卡升级
        void appUpMemberCardPay(String APPUserId, String Token, String ClubId, String MemberCardId, String NewMemberCardTypeId,
                                      String TotalMoney, String PayMode);
    }

}
