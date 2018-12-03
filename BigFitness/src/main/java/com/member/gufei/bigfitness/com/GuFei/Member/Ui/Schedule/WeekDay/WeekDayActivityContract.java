package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.WeekDay;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;

public interface WeekDayActivityContract {
    interface View extends BaseView {
        void outLogin();
    }

    interface Presenter extends BasePresenter<View> {

    }
}
