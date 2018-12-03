package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyCourseFragment.GymnasticsRecordFragment;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.FreeLessonClassRecordBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface GymnasticsRecordFragmentContract {

    interface View extends BaseView {
        void outLogin();
        void succeed(FreeLessonClassRecordBean freeLessonClassRecordBean);


    }

    interface Presenter extends BasePresenter<View> {


        void getFreeLessonClassRecord(String APPUserId  ,String ClubId  ,String token  ,int PageIndex  ,String MemberId);

    }
}
