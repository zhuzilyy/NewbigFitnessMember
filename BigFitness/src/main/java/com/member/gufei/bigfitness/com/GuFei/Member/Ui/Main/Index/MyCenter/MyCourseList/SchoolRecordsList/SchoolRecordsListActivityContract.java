package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCourseList.SchoolRecordsList;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClassLessonRecordListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface SchoolRecordsListActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(ClassLessonRecordListBean classLessonRecordListBean);

    }

    interface Presenter extends BasePresenter<View> {

        void getLessonClassRecord(String APPUserId  ,String ClubId  ,String token  ,int PageIndex  ,int MemberId,String LessonId, String ComeLogId);
    }
}
