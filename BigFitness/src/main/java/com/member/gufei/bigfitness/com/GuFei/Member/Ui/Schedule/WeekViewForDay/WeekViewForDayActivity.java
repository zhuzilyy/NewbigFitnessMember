package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.WeekViewForDay;

import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guojunustb.library.MemberDayWeekHeaderView;
import com.guojunustb.library.MemberWeekDayView;
import com.guojunustb.library.WeekViewEvent;
import com.member.gufei.bigfitness.Presenter.SpinnerPopContract;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.AddReservationClass.AddReservationDetails.AddReservationDetailsActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.AddReservationClass.SelectCocat.SelectCocatForScheduleActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.TeacherScheduleDayBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.RESULT_ID;
import static com.member.gufei.bigfitness.Constants.RESULT_STRING;
import static com.member.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.member.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.TimeUtil.getNowDate;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

/*
* 修改昵称
*
*
* */
public class WeekViewForDayActivity extends BaseActivity<WeekViewForDayActivityPresenter> implements SpinnerPopContract, WeekViewForDayActivityContract.View {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.text_date)
    TextView textDate;
    @BindView(R.id.weekheaderview)
    MemberDayWeekHeaderView mWeekHeaderView;
    @BindView(R.id.weekdayview)
    MemberWeekDayView mWeekView;

    List<WeekViewEvent> mNewEvent = new ArrayList<WeekViewEvent>();
    SimpleDateFormat format;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    List<TeacherScheduleDayBean.RowsBean> list = new ArrayList<TeacherScheduleDayBean.RowsBean>();
    @BindView(R.id.btn_select_coach)
    RelativeLayout btnSelectCoach;
    @BindView(R.id.text_name_coach)
    TextView textNameCoach;

    private String SelectDate = "";
    private String TeahcerId = "233";
    private String TeahcerName = "";
    private String LessonId;
    private String LessonName;
    private String TeacherName;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {

        return R.layout.member_activity_reservation_weekview_day;

    }

    @Override
    protected void initView() {

        format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date today = new Date();
        textDate.setText(getNowDate());
        SelectDate = getNowDate();

        Intent intent = getIntent();

        LessonId = intent.getStringExtra(PUT_STR + "LessonId");
        LessonName = intent.getStringExtra(PUT_STR + "LessonName");
        TeacherName = intent.getStringExtra(PUT_STR + "TeacherName");
        TeahcerId = intent.getStringExtra(PUT_STR + "TeahcerId");
        textNameCoach.setText("教练 " + TeacherName + " 日程");

        //init WeekView
        mWeekView.setMonthChangeListener(new MemberWeekDayView.MonthChangeListener() {


            @Override
            public List<WeekViewEvent> onMonthChange(int newYear, int newMonth) {


                return mNewEvent;
            }
        });
        mWeekView.setEventLongPressListener(new MemberWeekDayView.EventLongPressListener() {
            @Override
            public void onEventLongPress(WeekViewEvent event, RectF eventRect) {

            }
        });
        mWeekView.setOnEventClickListener(new MemberWeekDayView.EventClickListener() {
            @Override
            public void onEventClick(WeekViewEvent event, RectF eventRect) {
//                ToastUtil.s(mContext,list.get((int)event.getId()).getData().size() +
//
            }
        });
        mWeekView.setScrollListener(new MemberWeekDayView.ScrollListener() {


            @Override
            public void onFirstVisibleDayChanged(Calendar newFirstVisibleDay, Calendar oldFirstVisibleDay) {
                String date = null;
                if (oldFirstVisibleDay != null && newFirstVisibleDay != null) {


                    if (newFirstVisibleDay.getTime() != oldFirstVisibleDay.getTime()) {

                        date = format.format(newFirstVisibleDay.getTime());

                    }
                } else {

//                    date = format.format(newFirstVisibleDay.getTime());

                }


            }

            @Override
            public void onSelectedDaeChange(Calendar selectedDate) {

                mWeekHeaderView.setSelectedDay(selectedDate);
//                title.setText(selectedDate.get(Calendar.YEAR) + "年" + (selectedDate.get(Calendar.MONTH) + 1) + "月");

                SelectDate = format.format(selectedDate.getTime());
                textDate.setText(SelectDate);
                refresh();
            }
        });
        mWeekHeaderView.setDateSelectedChangeListener(new MemberDayWeekHeaderView.DateSelectedChangeListener() {
            @Override
            public void onDateSelectedChange(Calendar oldSelectedDay, Calendar newSelectedDay) {
                mWeekView.goToDate(newSelectedDay);


            }
        });
        mWeekHeaderView.setScrollListener(new MemberDayWeekHeaderView.ScrollListener() {
            @Override
            public void onFirstVisibleDayChanged(Calendar newFirstVisibleDay, Calendar oldFirstVisibleDay) {

//                String date = format.format(newFirstVisibleDay.getTime());
//                mPresenter.getSchedule(String.valueOf(UserId), token, String.valueOf(ClubId), String.valueOf(IsDepartManager), date, "d");
                mWeekView.goToDate(mWeekHeaderView.getSelectedDay());


//                if (newFirstVisibleDay!=null && oldFirstVisibleDay!=null){
//                    if (oldDayNum==0){
//                        oldDate=oldFirstVisibleDay.getTime();
//                    };
//                    oldDayNum++;

//                String str = "";


////                if (str.indexOf("周前") != -1) {
//                if (oldDayNum == 7) {
//                    oldDayNum = 0;
////                    oldDate=newFirstVisibleDay.getTime();

//                }


            }

//        }
        });
        mWeekView.setEmptyViewClickListener(new MemberWeekDayView.EmptyViewClickListener() {
            @Override
            public void onEmptyViewClicked(Calendar Date, int time) {
                s(mContext, format.format(Date.getTime()) + " " + time + ":00");
                Intent intent = new Intent(mContext, AddReservationDetailsActivity.class);

                intent.putExtra(PUT_STR + "id", "0");
                intent.putExtra(PUT_STR + "LessonId", LessonId);
                intent.putExtra(PUT_STR + "TeacherName", TeacherName);
                intent.putExtra(PUT_STR + "TeahcerId", TeahcerId);
                intent.putExtra(PUT_STR + "LessonName", LessonName);
                intent.putExtra(PUT_STR + "Status", "0");
                intent.putExtra(PUT_STR + "date", format.format(Date.getTime()));
                intent.putExtra(PUT_STR + "time", time);
//                intent.putExtra(PUT_STR + "type", ID_ACTIVITY_APPOINTMEN);

                startActivity(intent);


            }
        });

    }

    @Override
    protected void initData() {
        refresh();
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

    private void refresh() {
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");

        mPresenter.getTeacherScheduleDay(String.valueOf(UserId),
                ClubId, token, SelectDate, SelectDate, TeahcerId
        );

    }


    @Override
    public void dismiss() {
        backgroundAlpha(1f);
    }


    @Override
    public void succeed(TeacherScheduleDayBean teacherScheduleDayBean) {
        mNewEvent.clear();
        this.list = teacherScheduleDayBean.getRows();
        int i = 0;
        String title;
        for (TeacherScheduleDayBean.RowsBean resultBean : list) {
            Calendar startTime = Calendar.getInstance();
            Calendar endTime = Calendar.getInstance();
            try {
                Date sd = dateFormat.parse(resultBean.getStartTime());
                Date ed = dateFormat.parse(resultBean.getEndTime());
                int Color = R.color.green;
                startTime.setTime(sd);
                endTime.setTime(ed);

//                if (resultBean.getData().size() > 1) {
//                    title = resultBean.getData().size() + "个预约";
//                    Color = R.color.commit_btn;
//                    for (int j = 0; j < resultBean.getData().size(); j++) {
//                        if (resultBean.getData().get(0).getAppointmentResultId().equals("")) {
//                            Color = R.color.event_green;
//                            break;
//                        }
//                    }
//                } else {
//                    title = "预约";
//                    if (!resultBean.getData().get(0).getAppointmentResultId().equals("")){
//                        Color= R.color.commit_btn;
//                    }
//                }
                WeekViewEvent event = new WeekViewEvent(i, "课 " + resultBean.getStartTime() + "-" + resultBean.getEndTime(), startTime, endTime);
                event.setColor(getResources().getColor(Color));

                mNewEvent.add(event);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            i++;
        }


        mWeekView.notifyDatasetChanged();
    }

    @OnClick({R.id.btn_back, R.id.btn_select_coach})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_select_coach:

//                Intent intent = new Intent(mContext, SelectCocatForScheduleActivity.class);
//                intent.putExtra(PUT_STR + "LessonId", LessonId);
//                intent.putExtra(PUT_STR + "TeacherName", TeacherName);
//                intent.putExtra(PUT_STR + "LessonName", LessonName);
//                intent.putExtra(RESULT_ID, "8888");
//                startActivityForResult(intent, 8888);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (null != data) {
            Bundle bundle = data.getExtras();
            if (bundle == null) {
                return;
            }
            if (bundle.getInt(RESULT_TYPE) == RESULT_SUCCESS) {
                if (requestCode == 8888) {
                    //昵称
                    TeahcerName = bundle.getString(RESULT_STRING);
                    TeahcerId = bundle.getString(RESULT_ID);
                    textNameCoach.setText("教练 "+TeahcerName+" 日程");
                    refresh();


                }

            }


        }

    }

}
