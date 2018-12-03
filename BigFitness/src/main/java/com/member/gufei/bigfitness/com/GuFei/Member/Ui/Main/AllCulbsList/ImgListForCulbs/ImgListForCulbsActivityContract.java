package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.ImgListForCulbs;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubImagesBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubListForMemberBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubListForMemberNoBuyBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface ImgListForCulbsActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(ClubImagesBean clubImagesBean);


    }

    interface Presenter extends BasePresenter<View> {
        void getClubImages(String APPUserId  ,String ClubId  ,String token);

    }
}
