package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.WeekDay;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guojunustb.library.WeekDView;
import com.guojunustb.library.WeekViewEvent;
import com.member.gufei.bigfitness.Presenter.SpinnerPopContract;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.local.Schedule;
import com.member.gufei.bigfitness.util.SpUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WeekDayActivity extends BaseActivity<WeekDayActivityPresenter> implements SpinnerPopContract, WeekDayActivityContract.View {
    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.btn_today)
    TextView btnToday;
    @BindView(R.id.main_head_layout)
    RelativeLayout mainHeadLayout;
    @BindView(R.id.weekdaydview)
    WeekDView weekdaydview;
    List<WeekViewEvent> mNewEvent = new ArrayList<WeekViewEvent>();

    @Override
    public void dismiss() {

    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.week_day_activity;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
//init WeekView
        weekdaydview.setMonthChangeListener(new WeekDView.MonthChangeListener() {
            @Override
            public List<WeekViewEvent> onMonthChange(int newYear, int newMonth) {

                return mNewEvent;
            }
        });
        weekdaydview.setEventLongPressListener(new WeekDView.EventLongPressListener() {
            @Override
            public void onEventLongPress(WeekViewEvent event, RectF eventRect) {

            }
        });
        weekdaydview.setEmptyViewClickListener(new WeekDView.EmptyViewClickListener() {
            @Override
            public void onEmptyViewClicked(Calendar time) {


            }
        });
        weekdaydview.setOnEventClickListener(new WeekDView.EventClickListener() {
            @Override
            public void onEventClick(WeekViewEvent event, RectF eventRect) {
//                String PersonType = (String) SpUtil.get(mContext, PERSONTYPEKEY, "");
//                Calendar calendar = weekdaydview.getTimeFromPoint(eventRect.centerX(), eventRect.centerY());
//                title.setText(calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月" + (calendar.get(Calendar.DATE)) + "日");

            }
        });


        weekdaydview.setScrollListener(new WeekDView.ScrollListener() {
            @Override
            public void onFirstVisibleDayChanged(Calendar newFirstVisibleDay, Calendar oldFirstVisibleDay) {


                if (oldFirstVisibleDay != null && newFirstVisibleDay != null) {

//                    Log.d("--------新时间",format.format(newFirstVisibleDay.getTime()));
//                    Log.d("--------- --------","");
//                    Log.d("--------旧时间",format.format(oldFirstVisibleDay.getTime()));
//
//                    if (!format.format(selectedoldDate.getTime()).equals(format.format(oldFirstVisibleDay.getTime()))){
//                        title.setText(newFirstVisibleDay.get(Calendar.YEAR) + "年" + (newFirstVisibleDay.get(Calendar.MONTH) + 1) + "月  " + (newFirstVisibleDay.get(Calendar.WEEK_OF_YEAR)) + "周");
//                        Calendar tmp=newFirstVisibleDay;
//                        tmp.add(Calendar.DAY_OF_YEAR,2);
//                        String time = format.format(tmp.getTime());
//                        RefreshData(time);
//
//                    }
//                    selectedoldDate = oldFirstVisibleDay;

////
//                }


                }


            }

            @Override
            public void onSelectedDaeChange(Calendar selectedDate) {
////                mWeekHeaderView.setSelectedDay(selectedDate);
//                //滚动改变头部部分
//                Log.e("------~~~^~~~~~------>>", selectedDate.getTime() + "");
//
//                if (selectedoldDate.before(selectedDate)) {
//
//
//                    Log.e("小于结束时间", selectedDate.getTime() + "");
//
//                } else {
//                    Log.e("大于结束时间", selectedDate.getTime() + "");
//
//                }


            }
        });
    }

    @Override
    public void outLogin() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void Loading() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
