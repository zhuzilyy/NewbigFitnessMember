package com.member.gufei.bigfitness.com.GuFei.Member.Ui.InformationClass.Notice;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.NoticeListBean;

import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface NoticeListActivityContract {

    interface View extends BaseView {
        void outLogin();

        void succeed(NoticeListBean noticeListBean);

        void succeedRead(CodeBean codeBean);

        void succeedDelete(CodeBean codeBean);

        void succeedAllRead(CodeBean codeBean);

        void succeedAllDelete(CodeBean codeBean);

        void unsucceed();
    }

    interface Presenter extends BasePresenter<View>{
        void getNoticeList(String APPUserId, String token, String PageIndex, String PageSize, String MsgTypeId);

        //阅读消息，标记为已读
        void getReadMessage(String APPUserId, String token, String RowId, String IsAPPPush);
        //删除通知
        void getDeleteMessage(String APPUserId, String token, String RowId, String IsAPPPush);
        //全部标记为已读
        void getAllRead(String APPUserId, String token, String MsgTypeId);
        //删除全部已读
        void getAllDelete(String APPUserId, String token, String MsgTypeId);
    }
}
