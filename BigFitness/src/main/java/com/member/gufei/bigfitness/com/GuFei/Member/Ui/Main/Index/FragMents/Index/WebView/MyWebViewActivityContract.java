package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.WebView;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.EventDetailBean;


public interface MyWebViewActivityContract {

    interface View extends BaseView {
        void outLogin();
        void succeed(EventDetailBean eventDetailBean);
    }

    interface Presenter extends BasePresenter<View> {
        void getEventDetail(String Id  ,String token);
    }
}
