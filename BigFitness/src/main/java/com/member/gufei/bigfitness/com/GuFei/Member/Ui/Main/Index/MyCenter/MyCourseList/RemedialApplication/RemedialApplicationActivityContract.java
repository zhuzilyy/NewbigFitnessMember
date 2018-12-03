package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCourseList.RemedialApplication;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;


/**
 * Created by LiuShengYuan on 2018/10/12
 */
public interface RemedialApplicationActivityContract {
    interface View extends BaseView {
        void outLogin();

        void succeed(CodeBean codeBean);

    }

    interface Presenter extends BasePresenter<View> {

        void getAddLessonMakeUp(String APPUserId  ,String ClubId  ,String token  ,String LessonId  ,String AppointmentId, String Cause);
    }
}
