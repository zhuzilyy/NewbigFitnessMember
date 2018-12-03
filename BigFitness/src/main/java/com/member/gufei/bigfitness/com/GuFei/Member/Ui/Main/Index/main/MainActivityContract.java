package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.main;

import com.member.gufei.bigfitness.base.BasePresenter;
import com.member.gufei.bigfitness.base.BaseView;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface MainActivityContract {

    interface View extends BaseView {

        void   succeed(MainMsgBean testBean);

        void outLogin();
    }

    interface Presenter extends BasePresenter<View> {

        void updata(int userid, String token, int clubid, String IsDepartManager, String DepartId);
          void getCustomerSource(int userid, String token, int clubid);
          void getCustomerIntroducer(int userid, String token, int clubid, String Name);

    }
}
