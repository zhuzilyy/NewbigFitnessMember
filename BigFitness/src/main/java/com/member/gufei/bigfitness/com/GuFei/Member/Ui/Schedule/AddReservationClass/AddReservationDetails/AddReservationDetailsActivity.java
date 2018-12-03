package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.AddReservationClass.AddReservationDetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.member.gufei.bigfitness.Presenter.SpinnerPopContract;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.main.MainActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.MEMBERIDKEY;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.SELECTSEXKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

/*
* 修改昵称
*
*
* */
public class AddReservationDetailsActivity extends BaseActivity<AddReservationDetailsActivityPresenter> implements SpinnerPopContract, AddReservationDetailsActivityContract.View {


    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.text_name_lesson)
    TextView textNameLesson;
    @BindView(R.id.text_name_coach)
    TextView textNameCoach;
    @BindView(R.id.img_lesson_cocat)
    ImageView imgLessonCocat;
    @BindView(R.id.text_time_begin)
    TextView textTimeBegin;
    @BindView(R.id.img_begin_right)
    ImageView imgBeginRight;
    @BindView(R.id.btn_time_begin)
    RelativeLayout btnTimeBegin;
    @BindView(R.id.text_time_end)
    TextView textTimeEnd;
    @BindView(R.id.btn_time_end)
    RelativeLayout btnTimeEnd;
    @BindView(R.id.text_remind_right)
    TextView textRemindRight;
    @BindView(R.id.text_date_remind)
    TextView textDateRemind;
    @BindView(R.id.text_time_remind)
    TextView textTimeRemind;
//    @BindView(R.id.img_remind_right)
//    ImageView imgRemindRight;
    @BindView(R.id.btn_remind)
    RelativeLayout btnRemind;
    @BindView(R.id.edit_interval)
    EditText editInterval;
    @BindView(R.id.text_unit_right)
    TextView textUnitRight;
    @BindView(R.id.text_note)
    EditText textNote;
    @BindView(R.id.btn_submit)
    ImageView btnSubmit;
    private String LessonId;
    private String TeacherName;
    private String LessonName;
    private String mTimeBegin;
    private String mTimeEnd;
    private String mDateTimeEnd;
    private String mTimeRemind;
    private String mDateTimeRemind;
    private String TeahcerId;
    private String mDate;
    private int mTime;
    private String MemberId;


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {

        return R.layout.member_activity_reservation_details_add;

    }

    @Override
    protected void initView() {

//        toolbar.setNavigationIcon(R.mipmap.left);
//
//        setToolBar(toolbar, "");

        mainTitle.setText("添加预约");
//        btnClassPrivate.setSelected(true);

//        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
//
//        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
//
//        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
//
//        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
//
        Intent intent = getIntent();
//

        LessonId = intent.getStringExtra(PUT_STR + "LessonId");
        TeacherName = intent.getStringExtra(PUT_STR + "TeacherName");
        LessonName = intent.getStringExtra(PUT_STR + "LessonName");
        TeahcerId = intent.getStringExtra(PUT_STR + "TeahcerId");
        mDate = intent.getStringExtra(PUT_STR + "date");
        mTime = intent.getIntExtra(PUT_STR + "time", 0);
        mTimeBegin = mDate + "  " + mTime + ":00";
        mTimeEnd = (mTime+1) + ":00";
        mDateTimeEnd = mDate + " " +mTimeEnd;
        mTimeRemind = (mTime-1) + ":00";
        mDateTimeRemind = mDate + " " + mTimeRemind;
        textNameLesson.setText(LessonName);
        textNameCoach.setText(TeacherName);
        textTimeBegin.setText(mTimeBegin);
        textTimeEnd.setText(mTimeEnd);
        textDateRemind.setText(mDate);
        textTimeRemind.setText(mTimeRemind);
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
    public void succeed(CodeBean codeBean) {
        s(mContext, codeBean.getMsg());
        Intent intent = new Intent(mContext, MainActivity.class);
        intent.putExtra(PUT_STR + "AddAppointment", "2");
        startActivity(intent);
        finish();
    }


    @OnClick({R.id.btn_back, R.id.btn_time_begin, R.id.btn_time_end, R.id.btn_remind, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_time_begin:
                TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        mTimeBegin = mDate + " " +getHourMin(date);
                        textTimeBegin.setText(mTimeBegin);
                        date.setHours(date.getHours()+1);
                        mTimeEnd = getHourMin(date);
                        mDateTimeEnd = mDate + " " +mTimeEnd;
                        textTimeEnd.setText(mTimeEnd);
                        date.setHours(date.getHours()-2);
                        mTimeRemind = getHourMin(date);
                        mDateTimeRemind = mDate + " " + mTimeRemind;
                        textTimeRemind.setText(mTimeRemind);

                    }
                })
                        .setType(TimePickerView.Type.HOURS_MINS)// 默认全部显示
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
            case R.id.btn_time_end:
                break;
            case R.id.btn_remind:
                break;
            case R.id.btn_submit:
                if (textTimeBegin.getText().equals("请选择")) {
                    s(mContext, "请选择预约时间");
                    break;
                }
                if (textTimeRemind.getText().equals("请选择")) {
                    s(mContext, "请选择提醒时间");
                    break;
                }

                int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

                MemberId = (String) SpUtil.get(mContext, MEMBERIDKEY, "");
                String token = (String) SpUtil.get(mContext, TOKENKEY, "");
                String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");


                mPresenter.AddMemberLessonAppointment(String.valueOf(UserId),
                        ClubId,
                        MemberId,
                        LessonId,
                        TeahcerId,
                        textNote.getText().toString(),
                        token,
                        mTimeBegin,
                        mDateTimeEnd,
                        mDateTimeRemind,
                        editInterval.getText().toString(),
                        "0",
                        "1",
                        "0");
                break;
        }
    }
}
