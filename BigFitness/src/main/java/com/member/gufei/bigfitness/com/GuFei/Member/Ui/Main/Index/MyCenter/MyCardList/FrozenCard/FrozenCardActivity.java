package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.FrozenCard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.util.SpUtil;


import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.TimeUtil.compareNowTime;
import static com.member.gufei.bigfitness.util.TimeUtil.compareTwoTime;
import static com.member.gufei.bigfitness.util.TimeUtil.getTimeDifference;
import static com.member.gufei.bigfitness.util.TimeUtil.string2Milliseconds;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

public class FrozenCardActivity extends BaseActivity<FrozenCardActivityPresenter> implements FrozenCardActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @BindView(R.id.text_type_card)
    TextView textTypeCard;
    @BindView(R.id.text_time_expire)
    TextView textTimeExpire;
    @BindView(R.id.text_number_remain)
    TextView textNumberRemain;
    @BindView(R.id.text_time_begin)
    TextView textTimeBegin;
    @BindView(R.id.img_begin_right)
    ImageView imgBeginRight;
    @BindView(R.id.text_time_end)
    TextView textTimeEnd;
    @BindView(R.id.img_end_right)
    ImageView imgEndRight;
    @BindView(R.id.text_number_remaining)
    TextView textNumberRemaining;
    @BindView(R.id.btn_confirm)
    TextView btnConfirm;

    private int UserId;
    private String token;
    private String ClubId;
    private String Id;
    private String MemberCardId;
    private String MemberCardType;
    private String TimeExpire;
    private int RemainLockedCount;
    private String MemberCardTypeName;
    private TimePickerView pvCustomTime;

    private Date TimeBegin;
    private Date TimeEnd;


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_frozen_my_card;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("冻结申请");
        btnComplete.setVisibility(View.GONE);


        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");


        Intent intent = getIntent();
        Id = intent.getStringExtra(PUT_STR + "Id");
        MemberCardId = intent.getStringExtra(PUT_STR + "MemberCardId");
        MemberCardType = intent.getStringExtra(PUT_STR + "MemberCardType");
        MemberCardTypeName = intent.getStringExtra(PUT_STR + "MemberCardTypeName");
        TimeExpire = intent.getStringExtra(PUT_STR + "ExpireTime");
        RemainLockedCount = intent.getIntExtra(PUT_STR + "RemainLockedCount", 0);

        textTypeCard.setText(MemberCardTypeName);
        textTimeExpire.setText(TimeExpire);
        textNumberRemain.setText(RemainLockedCount + "次");


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

    }

    @Override
    public void succeed(CodeBean codeBean) {
        Toast.makeText(this, "申请成功", Toast.LENGTH_SHORT);
        finish();
    }

    @Override
    public void showError(String Msg) {

        s(mContext, Msg);

    }


    @OnClick({R.id.text_time_begin, R.id.text_time_end, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_time_begin:
//                initCustomTimePicker(textTimeBegin, "开始时间");
//                pvCustomTime.show();
                TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        textTimeBegin.setText(getTime(date));
                    }
                })
                        .setType(TimePickerView.Type.YEAR_MONTH_DAY)// 默认全部显示
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
//                .setContentSize(18)//滚轮文字大小
//                .setTitleSize(20)//标题文字大小
//                //.setTitleText("Title")//标题文字
//                .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
//                .isCyclic(true)//是否循环滚动
//                //.setTitleColor(Color.BLACK)//标题文字颜色
//                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
//                .setCancelColor(Color.BLUE)//取消按钮文字颜色
//                //.setTitleBgColor(0xFF666666)//标题背景颜色 Night mode
//                .setBgColor(0xFF333333)//滚轮背景颜色 Night mode
////                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
////                .setRangDate(startDate,endDate)//起始终止年月日设定
//                .setLabel("年","月","日")//默认设置为年月日时分秒
                        .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                        //.isDialog(true)//是否显示为对话框样式
                        .build();

                pvTime.show();
                break;
            case R.id.text_time_end:
//                initCustomTimePicker(textTimeEnd, "结束时间");
//                pvCustomTime.show();
                TimePickerView pvTime1 = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        textTimeEnd.setText(getTime(date));
                        textNumberRemaining.setText(getTimeDifference(textTimeBegin.getText().toString(), textTimeEnd.getText().toString(), 1));
                    }
                })
                        .setType(TimePickerView.Type.YEAR_MONTH_DAY)// 默认全部显示
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
//                .setContentSize(18)//滚轮文字大小
//                .setTitleSize(20)//标题文字大小
//                //.setTitleText("Title")//标题文字
//                .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
//                .isCyclic(true)//是否循环滚动
//                //.setTitleColor(Color.BLACK)//标题文字颜色
//                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
//                .setCancelColor(Color.BLUE)//取消按钮文字颜色
//                //.setTitleBgColor(0xFF666666)//标题背景颜色 Night mode
//                .setBgColor(0xFF333333)//滚轮背景颜色 Night mode
////                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
////                .setRangDate(startDate,endDate)//起始终止年月日设定
//                .setLabel("年","月","日")//默认设置为年月日时分秒
                        .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                        //.isDialog(true)//是否显示为对话框样式
                        .build();

                pvTime1.show();
                break;
            case R.id.btn_confirm:
                if (textTimeBegin.getText().toString().equals("") || textTimeEnd.getText().toString().equals("")) {
                    s(mContext, "请选择冻结时间");

                } else {
                    mPresenter.appMemberCardLockApply(String.valueOf(UserId),
                            ClubId,
                            token,
                            MemberCardId,
                            textTimeBegin.getText().toString(),
                            textTimeEnd.getText().toString());
                }

                break;
        }
    }


}


