package com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.ClassEvaluationing;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.GetLessonEvaluateBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface ClassEvaluationingActivityContract {

    interface View extends BaseView {
        void outLogin();

      void succeed(CodeBean codeBean);
      //获取评价内容
        void Evaluatesucceed(GetLessonEvaluateBean getLessonEvaluateBean);

    }

    interface Presenter extends BasePresenter<View> {

        void getLessonEvaluate(String APPUserId, String ClubId, String token, String MemberId, String ComeLogId,
                               String AppointmentId, String EvaluateStar, String EvaluateContent, String TeacherEvaluateStar,
                               String ServiceEvaluateStar, String TeacherEvaluateContent, String ImageURL,
                               String TeacherImageURL,  String IsAnonymous);

        //获取评价内容
        void getEvaluate(String APPUserId, String ClubId, String token, String MemberId, String AppointmentId,String ComeLogId);
    }
}
