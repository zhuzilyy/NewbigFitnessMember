package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MemberIdBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MyScheduleFragMentContract {

    interface View extends BaseView {
        void outLogin();
        void succeed(MainMsgBean testBean);
        void MainPagesucceed(SineForMainPageBean sineForMainPageBean);
        void succeedMemberId(MemberIdBean memberIdBean);

    }

    interface Presenter extends BasePresenter<View> {

        void updata(int userid, String token, int clubid);

        void getSineForMainPage(int userid, String token, int clubid);

        void getMemberIdIsLockId(String APPUserId, String ClubId, String token);

    }
}
