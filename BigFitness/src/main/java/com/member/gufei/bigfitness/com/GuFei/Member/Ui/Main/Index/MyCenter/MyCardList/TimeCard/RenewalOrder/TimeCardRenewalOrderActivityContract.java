package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.TimeCard.RenewalOrder;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface TimeCardRenewalOrderActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(PublicSeaBean publicSeaBean);
        void succeedEdit(CodeBean codeBean);
        void succeedoperate();

        void membersucceed(PublicSeaMemberBean publicSeaBean);
    }

    interface Presenter extends BasePresenter<View> {

//        void getCustomerList(
//
//                String UserName,
//                int UserId,
//                int DepartId,
//                String token,
//                int ClubId,
//                int IsDepartManager,
//                int CurrentPage,
//                int type,
//                String SearchKey,
//                String Sex,
//                String IntentId,
//                String SourceId,
//                String StartCreateTime,
//                String EndCreateTime,
//                String CreateUserId,
//                String IntroduceMemberId,
//                String LabelId,
//                String OwnManagerId,
//                String StartLastContactTime,
//                String EndLastContactTime,
//                String sort,
//                String order);


        void appPublicSeaCustomerList(
                String UserName,
                int UserId,
                String token,
                int ClubId,
                int CurrentPage,
                String StartDate,
                String EndDate,
                String PublicSeaId,
                String sort,
                String order);

        void appPublicSeaMemberList(String UserName,
                                    int UserId,
                                    String token,
                                    int ClubId,
                                    int CurrentPage,
                                    String StartDate,
                                    String EndDate,
                                    String PublicSeaId,
                                    String sort,
                                    String order);


        void appGainCustomer(
                int UserId, String UserName, String token, int ClubId, String CustomerId);
        void appUpdateCustomerPublicSeaType(
                int UserId, String UserName, String token, int ClubId, String CustomerId, String NewPublicSeaId);

        void appUpdateOwnManagerId(

                int UserId,
                String UserName,
                String token,
                int ClubId,
                String CustomerId,
                String NewOwnmanagerId);
        void updateMemberLessonTeacher(

                int UserId,
                String UserName,
                String token,
                int ClubId,
                String CustomerId,
                String TeacherId);



    void updateMemberOwnTeacherBatch(

            int UserId,
            String UserName,
            String token,
            int ClubId,
            String CustomerId,
            String TeacherId);

    }

}
