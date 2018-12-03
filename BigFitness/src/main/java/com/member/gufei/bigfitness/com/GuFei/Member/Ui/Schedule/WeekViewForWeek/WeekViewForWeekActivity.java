package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.WeekViewForWeek;

import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.guojunustb.library.DateTimeInterpreter;
import com.guojunustb.library.WeekDViewCopy;
import com.guojunustb.library.WeekViewEvent;
import com.member.gufei.bigfitness.Presenter.SpinnerPopContract;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.QueryScheduleDayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
public class WeekViewForWeekActivity extends BaseActivity<WeekViewForWeekActivityPresenter> implements SpinnerPopContract, WeekViewForWeekActivityContract.View {


    List<WeekViewEvent> mNewEvent = new ArrayList<WeekViewEvent>();
    SimpleDateFormat format;
    long exitTime;
    Calendar selectedoldDate;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    int FirstShow = 0;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.tv_title)
    TextView title;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.weekdayview)
    WeekDViewCopy mWeekView;
    List<QueryScheduleDayBean.RowsBean> list = new ArrayList<>();
    Boolean todayBtn;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {

        return R.layout.fragment_week_copy;

    }

    @Override
    protected void initView() {
        todayBtn = false;
        selectedoldDate = new GregorianCalendar();
        format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        btnComplete.setText("今天");
        if (FirstShow == 0) {
            format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            Calendar c = Calendar.getInstance();
            c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
            title.setText(c.get(Calendar.YEAR) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + (c.get(Calendar.DATE)));
        }
        FirstShow++;
//init WeekView
        mWeekView.setMonthChangeListener(new WeekDViewCopy.MonthChangeListener() {
            @Override
            public List<WeekViewEvent> onMonthChange(int newYear, int newMonth) {

                return mNewEvent;
            }
        });
        mWeekView.setEventLongPressListener(new WeekDViewCopy.EventLongPressListener() {
            @Override
            public void onEventLongPress(WeekViewEvent event, RectF eventRect) {

            }
        });
        mWeekView.setEmptyViewClickListener(new WeekDViewCopy.EmptyViewClickListener() {
            @Override
            public void onEmptyViewClicked(Calendar time) {
                title.setText(time.get(Calendar.YEAR) + "/" + (time.get(Calendar.MONTH) + 1) + "/" + (time.get(Calendar.DATE)) + " " + (time.get(Calendar.HOUR_OF_DAY)) + ":" + (time.get(Calendar.MINUTE)));

            }
        });
        mWeekView.setOnEventClickListener(new WeekDViewCopy.EventClickListener() {
            @Override
            public void onEventClick(WeekViewEvent event, RectF eventRect) {
                Calendar calendar = mWeekView.getTimeFromPoint(eventRect.centerX(), eventRect.centerY());
                title.setText(calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + (calendar.get(Calendar.DATE)) + " " + (calendar.get(Calendar.HOUR_OF_DAY)) + ":" + (calendar.get(Calendar.MINUTE)));
//                if (list.get((int) event.getId()).getData().size() > 1) {
//                    Intent intent = new Intent(mContext, ListActivity.class);
//                    intent.putExtra("param", (Serializable) list.get((int) event.getId()).getData());
//                    startActivity(intent);
//                } else {
//
//                }
            }
        });


        mWeekView.setScrollListener(new WeekDViewCopy.ScrollListener() {
            @Override
            public void onFirstVisibleDayChanged(Calendar newFirstVisibleDay, Calendar oldFirstVisibleDay) {


                if (oldFirstVisibleDay != null && newFirstVisibleDay != null) {

                    Log.d("--------新时间", format.format(newFirstVisibleDay.getTime()));
                    Log.d("--------- --------", "");
                    Log.d("--------旧时间", format.format(oldFirstVisibleDay.getTime()));

                    if (!format.format(selectedoldDate.getTime()).equals(format.format(oldFirstVisibleDay.getTime()))) {
                        if (!todayBtn) {
                            title.setText(newFirstVisibleDay.get(Calendar.YEAR) + "/" + (newFirstVisibleDay.get(Calendar.MONTH) + 1) + "/" + +(newFirstVisibleDay.get
                                    (Calendar.DATE)));
                        }
                        Calendar tmp = newFirstVisibleDay;
                        tmp.add(Calendar.DAY_OF_YEAR, 2);
                        String time = format.format(tmp.getTime());
                        RefreshData();

                    }
                    selectedoldDate = oldFirstVisibleDay;

////
//                }


                }


            }

            @Override
            public void onSelectedDaeChange(Calendar selectedDate) {
//                mWeekHeaderView.setSelectedDay(selectedDate);
                //滚动改变头部部分
                Log.e("------~~~^~~~~~------>>", selectedDate.getTime() + "");

                if (selectedoldDate.before(selectedDate)) {


                    Log.e("小于结束时间", selectedDate.getTime() + "");

                } else {
                    Log.e("大于结束时间", selectedDate.getTime() + "");

                }
                todayBtn = false;

            }
        });
//        mWeekHeaderView.setDateSelectedChangeListener(new WeekHeaderDView.DateSelectedChangeListener() {
//            @Override
//            public void onDateSelectedChange(Calendar oldSelectedDay, Calendar newSelectedDay) {
////                     mWeekView.goToDate(newSelectedDay);
//
//            }
//        });
//        mWeekHeaderView.setScrollListener(new WeekHeaderDView.ScrollListener() {
//            @Override
//            public void onFirstVisibleDayChanged(Calendar newFirstVisibleDay, Calendar oldFirstVisibleDay) {
////                mWeekView.goToDate(mWeekHeaderView.getSelectedDay());
////                String date = format.format(newFirstVisibleDay.getTime());
////                mPresenter.getSchedule(String.valueOf(UserId), token, String.valueOf(ClubId), String.valueOf(IsDepartManager), date, "w");
//            }
//        });
        setupDateTimeInterpreter(false);


        String date = format.format(new Date());
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");

        mPresenter.QueryScheduleDay(String.valueOf(UserId), ClubId, token, getNowDate(), getNowDate(), "1"
        );

    }

    private void setupDateTimeInterpreter(final boolean shortDate) {

        final String[] weekLabels = {"日", "一", "二", "三", "四", "五", "六"};
        mWeekView.setDateTimeInterpreter(new DateTimeInterpreter() {
            @Override
            public String interpretDate(Calendar date) {
                SimpleDateFormat weekdayNameFormat = new SimpleDateFormat("EEE", Locale.getDefault());
                String weekday = weekdayNameFormat.format(date.getTime());
                SimpleDateFormat format = new SimpleDateFormat("d", Locale.getDefault());
                return format.format(date.getTime());
            }

            @Override
            public String interpretTime(int hour) {
                return String.format("%02d:00", hour);

            }

            @Override
            public String interpretWeek(int date) {
                if (date > 7 || date < 1) {
                    return null;
                }
                return weekLabels[date - 1];
            }
        });
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

    public void RefreshData() {
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");

        mPresenter.QueryScheduleDay(String.valueOf(UserId),
                ClubId, token, getNowDate(), getNowDate(), "1"
        );
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_complete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_complete:
                todayBtn = true;
                Calendar c = Calendar.getInstance();
                Calendar d = Calendar.getInstance();
                c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
                d.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
//                Date date = new Date(System.currentTimeMillis());
//                title.setText(dateFormat.format(date));

                c.add(Calendar.DATE, 1 - c.get(Calendar.DAY_OF_WEEK));
                mWeekView.goToDate(c);
                title.setText(d.get(Calendar.YEAR) + "/" + (d.get(Calendar.MONTH) + 1) + "/" + (d.get(Calendar.DATE)));

//                RefreshData();
                break;
        }
    }

    @Override
    public void loadData(List<QueryScheduleDayBean.RowsBean> list) {
        mNewEvent.clear();
        this.list = list;
        int i = 0;

        String title;
        for (QueryScheduleDayBean.RowsBean resultBean : list) {
            Calendar startTime = Calendar.getInstance();
            Calendar endTime = Calendar.getInstance();
            int Color = R.color.event_green;
            try {
                startTime.setTime(dateFormat.parse(resultBean.getAppointmentDate().replace("-", "/") + " " + resultBean.getStartTime() + ":00"));
                endTime.setTime(dateFormat.parse(resultBean.getAppointmentDate().replace("-", "/") + " " + resultBean.getEndTime() + ":00"));


                title = resultBean.getLessonName();
                Color = R.color.event_green;
//                    for (int j = 0; j < resultBean.getData().size(); j++) {
//                        if (resultBean.getData().get(0).getAppointmentResultId().equals("")) {
//                            Color = R.color.event_green;
//                            break;
//                        }
//                    }


                WeekViewEvent event = new WeekViewEvent(i, title, startTime, endTime);
                event.setColor(getResources().getColor(Color));


                mNewEvent.add(event);

//                mWeekHeaderView.setFocusSameDayBackgroundColor(R.color.red);
//                mWeekHeaderView.invalidate();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            i++;
        }


        mWeekView.notifyDatasetChanged();

    }
}
