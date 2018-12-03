package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.AddReservationClass.Add;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.member.gufei.bigfitness.Presenter.SpinnerPopContract;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;

import butterknife.BindView;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.util.ToastUtil.s;

/*
* 修改昵称
*
*
* */
public class AddActivity extends BaseActivity<AddActivityPresenter> implements SpinnerPopContract, AddActivityContract.View {


    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.btn_back)
    ImageView btnBack;


    @Override
    protected void initInject() {
        //getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {

        return R.layout.member_activity_reservation_weekview_week;

    }

    @Override
    protected void initView() {

//        toolbar.setNavigationIcon(R.mipmap.left);
//
//        setToolBar(toolbar, "");

        mainTitle.setText("个人资料");


//        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
//
//        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
//
//        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
//
//        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
//
//        Intent intent = getIntent();
//
//        String CustomerId = intent.getStringExtra(PUT_STR + "CustomerId");
//
//        mPresenter.getCustomerInfoById(UserId, token, ClubId, UserName, CustomerId);
//

    }

    @Override
    protected void initData() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void Loading() {

    }

    @Override
    public void outLogin() {

        s(this, "您的帐号在其他设备登录");
        Intent intent = new Intent(mContext, LoginActivity.class);
        remove();

        startActivity(intent);

    }





    @Override
    public void dismiss() {
        backgroundAlpha(1f);
    }


    @Override
    public void Success(CustomerInfoBean customerInfoBean) {


    }

    @Override
    public void EditSuccess(CodeBean codeBean) {

        s(this, "修改成功");

        finish();


    }




}
