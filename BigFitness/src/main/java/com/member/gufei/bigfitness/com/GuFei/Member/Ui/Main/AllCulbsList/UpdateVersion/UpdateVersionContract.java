package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.UpdateVersion;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;

public interface UpdateVersionContract {
    interface View extends BaseView {
        void succeed(UpdateBean updateBean);
    }
    interface Presenter extends BasePresenter<UpdateVersionContract.View> {
        void updateApp();
    }
}

