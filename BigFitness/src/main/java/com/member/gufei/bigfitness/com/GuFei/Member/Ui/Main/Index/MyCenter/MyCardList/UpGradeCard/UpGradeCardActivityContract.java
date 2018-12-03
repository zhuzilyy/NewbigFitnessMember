package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.UpGradeCard;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MemberCardOnlineUpInfoBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.UpGradeCardListBean;


/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface UpGradeCardActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeedUp(UpGradeCardListBean upGradeCardListBean);
        void succeedUpInfo(MemberCardOnlineUpInfoBean memberCardOnlineUpInfoBean);

    }

    interface Presenter extends BasePresenter<View> {

        //获取会员卡升级列表
        void appMemberUpGradeCardList(String ClubId, String Token, String MemberCardTypeId);
        //我的会员卡升级信息
        void appMemberCardOnlineUpInfo(String MemberCardTypeId,String NewMemberCardTypeId, String ExpireTime, String Token);
    }

}
