package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Register.Sex;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;


import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.IndexFragMent;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Register.RegisterActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Register.UserInfo.UserInfoActivity;
import com.member.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.App.SCREEN_WIDTH;
import static com.member.gufei.bigfitness.Constants.PASSWRODKEY;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTSEXKEY;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 登录页面 实现
 */


public class SexActivity extends BaseActivity<SexActivityPresenter> implements SexActivityContract.View {


    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_man)
    ImageView btnMan;
    @BindView(R.id.btn_woman)
    ImageView btnWoman;
    @BindView(R.id.btn_next)
    ImageView btnNext;

    int SexId = 3;
    private String popCode;//0-登录页跳转，1-注册页跳转


    @Override
    protected void initInject() {

        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_sex;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("您的性别？");
//        String name = (String) SpUtil.get(mContext, ACCOUNTKEY, "");
//        String pwd = (String) SpUtil.get(mContext, PASSWRODKEY, "");
//        String login = (String) SpUtil.get(mContext, LOGINKEY, "");
//        clientId = (String) SpUtil.get(mContext, CLIENTID, "");

//
//        if (!StringUtil.isSpace(name) && !StringUtil.isSpace(pwd)) {
////            username.setText(name);
////            password.setText(pwd);
////            remberCheckBox.setChecked(true);
////            if (login.equals("1")) {
////                mPresenter.login(name, pwd, clientId, remberCheckBox.isChecked());//设备码未填写 为假数据
////                SpUtil.put(mContext, LOGINKEY, "0");
////            }
//        }
//
////        Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
////        startActivity(intent);
////        finish();
//
////        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
////        startActivity(intent);
////        finish();
//

    }


    private void setPopWindow() {
        if (contentView != null) contentView = null;
        if (popupWindow != null) popupWindow = null;
        // 一个自定义的布局，作为显示的内容

        contentView = LayoutInflater.from(mContext).inflate(R.layout.member_pop_view_finish, null);
        popupWindow = new PopupWindow(contentView, SCREEN_WIDTH - 200, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        TextView textView = (TextView) contentView.findViewById(R.id.text_result);
        if (popCode.equals("0")){
            textView.setText("请完善信息！");
        }
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));
        popupWindow.update();
        popupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        popupWindow.setTouchable(true); // 设置popupwindow可点击
        popupWindow.setOutsideTouchable(true); // 设置popupwindow外部可点击
        popupWindow.setFocusable(true); // 获取焦点
//        ColorDrawable dw = new ColorDrawable(0x00);
//        popupMenu.setBackgroundDrawable(dw);

//        createPupupWindow();
//        showPopupMenu();

        popupWindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    popupWindow.dismiss();
                    return true;
                }
//                timer.start();
                return false;
            }
        });
        int[] point = {0, 0};

        btnMan.getLocationOnScreen(point);
        popupWindow.showAtLocation(btnMan, Gravity.CENTER, 0, 150);
        timer.start();

    }

    CountDownTimer timer = new CountDownTimer(3000, 10) {

        @Override
        public void onTick(long millisUntilFinished) {
        }

        @Override
        public void onFinish() {
            popupWindow.dismiss();

        }
    };

//    public PopupWindow createPupupWindow() {
//        return popupWindow;
//    }
//
//
//    public void showPopupMenu() {
//        if (popupWindow != null && popupWindow.isShowing()) {
//            popupWindow.dismiss();
//        } else {
//            popupWindow.showAsDropDown(tvTitle);
//            timer.start();
//        }
//
//    }


    @Override
    protected void initData() {

//        JPushInterface.init(getApplicationContext());
//        SpUtil.put(mContext, PASSWRODKEY, password);
        Intent intent = getIntent();
        popCode = intent.getStringExtra(PUT_STR + "popCode");
    }


    @Override
    public void showError(String msg) {

        s(this, msg);

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void outLogin() {

//        Intent intent = new Intent(mContext, LoginActivity.class);
//        startActivity(intent);

    }


    @Override
    public void Loading() {

    }


//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if(hasFocus){
//            setPopWindow();
//        }
//    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setPopWindow();//弹出popupWindow
            }
        },20);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        //每次重新到前台就主动更新intent并保存，之后就能获取到最新的intent

        super.onNewIntent(intent);
        setIntent(intent);
    }

    @OnClick({R.id.btn_man, R.id.btn_woman, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_man:
                SexId = 1;
                btnMan.setImageResource(R.mipmap.img_men_selected);
                btnWoman.setImageResource(R.mipmap.img_women_select);
                btnNext.setImageResource(R.mipmap.img_btn_next_selected);
                break;
            case R.id.btn_woman:
                SexId = 0;
                btnMan.setImageResource(R.mipmap.img_men_select);
                btnWoman.setImageResource(R.mipmap.img_women_selected);
                btnNext.setImageResource(R.mipmap.img_btn_next_selected);
                break;
            case R.id.btn_next:
                if (SexId != 3) {
                    SpUtil.put(mContext, SELECTSEXKEY, String.valueOf(SexId));
                    Intent intent = new Intent(SexActivity.this, UserInfoActivity.class);
                    startActivity(intent);

                }
                break;

        }

    }
}

