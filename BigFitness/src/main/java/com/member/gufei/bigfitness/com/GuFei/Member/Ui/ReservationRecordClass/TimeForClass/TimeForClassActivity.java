package com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.TimeForClass;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.AdaptionLinearLayoutManager;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.ClockInClass.ClockInClassActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClassCountdownInfoBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.DistanceClassTimeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ItemPlanBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyLessonAppDetailBean;
import com.member.gufei.bigfitness.util.DownTimerUtil.DownTimerInterface;
import com.member.gufei.bigfitness.util.MyCountDownTimer;
import com.member.gufei.bigfitness.util.SpUtil;
import com.member.gufei.bigfitness.util.TimeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.widget.LinearLayout.VERTICAL;
import static com.member.gufei.bigfitness.Constants.INTERVAL;
import static com.member.gufei.bigfitness.Constants.MEMBERIDKEY;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TIME1;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.TimeUtil.DEFAULT_SIMPLE_DATE_FORMAT;
import static com.member.gufei.bigfitness.util.TimeUtil.string2Milliseconds;

public class TimeForClassActivity extends BaseActivity<TimeForClassActivityPresenter> implements TimeForClassActivityContract.View {


    @BindView(R.id.text_count_down)
    TextView textCountDown;
    @BindView(R.id.text_name_lesson)
    TextView textNameLesson;
    @BindView(R.id.text_name_coach)
    TextView textNameCoach;
    @BindView(R.id.text_time)
    TextView textTime;
    @BindView(R.id.iv_time_back)
    ImageView ivTimeBack;
    @BindView(R.id.tv_time_clock)
    TextView tvTimeClock;
    int UserId;
    int IsSignIn;
    Long subTime;
    String token;
    String ClubId;
    String AppointmentId;
    String LessonId;
    String LessonName;
    String TeacherName;
    String TextTime;
    String StartTime;
    String MemberId;
    @BindView(R.id.tv_time_name)
    TextView tvTimeName;
    private int i = 0;
    private Timer timer = null;
    private int recLen;
    //    private TimerTask task = null;
    public MyCountDownTimer myCountDownTimer;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    private List<String> list;
    private CommonAdapter<ItemPlanBean.PlanListBean> commonAdapter;
    private List<ItemPlanBean.PlanListBean> datas = new ArrayList<ItemPlanBean.PlanListBean>();
    //计时器
    private Handler mhandle = new Handler();
    private boolean isPause = false;//是否暂停
    private long currentSecond = 0;//当前毫秒数
    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_timeforclass;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();

        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        MemberId = (String) SpUtil.get(mContext, MEMBERIDKEY, "");
        IsSignIn = intent.getIntExtra(PUT_STR + "IsSignIn", 0);
        AppointmentId = intent.getStringExtra(PUT_STR + "AppointmentId");
        LessonName = intent.getStringExtra(PUT_STR + "LessonName");
        LessonId = intent.getStringExtra(PUT_STR + "LessonId");
        TeacherName = intent.getStringExtra(PUT_STR + "TeacherName");
        TextTime = intent.getStringExtra(PUT_STR + "TextTime");
        StartTime = intent.getStringExtra(PUT_STR + "StartTime");

        textNameLesson.setText(LessonName);
        textNameCoach.setText(TeacherName);
        textTime.setText(TextTime);
        datas = new ArrayList<>();
        commonAdapter = new CommonAdapter<ItemPlanBean.PlanListBean>(R.layout.member_item_plan, mContext, datas) {
            @Override
            protected void convert(ViewHolder holder, final ItemPlanBean.PlanListBean msgBean, int position) {
                holder.setText(R.id.text_postion, msgBean.getPositionName());
                holder.setText(R.id.text_action, msgBean.getActionName());
            }
        };
        recyclerView.setAdapter(commonAdapter);

    }

    @Override
    protected void initData() {
//        Intent intent = getIntent();
//        String AppointmentId = intent.getStringExtra(PUT_STR + "AppointmentId");
//
//        final int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
//        final String token = (String) SpUtil.get(mContext, TOKENKEY, "");
//        final String Clubid = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
//        final String MemberId = (String) SpUtil.get(mContext, MEMBERIDKEY, "");
        mPresenter.getMyLessonAppDetail(
                String.valueOf(UserId), ClubId, token, MemberId, AppointmentId);
        if (IsSignIn == 0){

            mPresenter.getClassTime(String.valueOf(UserId),
                    token,
                    ClubId,
                    LessonId,
                    AppointmentId);
        }else {
            mPresenter.getClassBeginTime(String.valueOf(UserId),
                    token,
                    ClubId,
                    AppointmentId);
        }


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
    public void succeed(MyLessonAppDetailBean myLessonAppDetailBean) {
        textNameLesson.setText(myLessonAppDetailBean.getRows().getLessonName());
        textNameCoach.setText(myLessonAppDetailBean.getRows().getTeacherName());
        textTime.setText(myLessonAppDetailBean.getRows().getStartTime() + "-" + myLessonAppDetailBean.getRows().getEndTime());
        datas = new ArrayList<ItemPlanBean.PlanListBean>();

        for (int i = 0; i < myLessonAppDetailBean.getRows().getPosition().size(); i++) {


            for (int j = myLessonAppDetailBean.getRows().getPosition().get(i).getActionName().size() - 1; j >= 0; j--) {
                ItemPlanBean.PlanListBean bean = new ItemPlanBean.PlanListBean();
                if (j == 0) {
                    bean.setPositionName(myLessonAppDetailBean.getRows().getPosition().get(i).getPositionName());
                } else {
                    bean.setPositionName("");
                }
                bean.setActionName(myLessonAppDetailBean.getRows().getPosition().get(i).getActionName().get(j));
                datas.add(bean);
            }


        }


        commonAdapter.replaceData(datas);
        final AdaptionLinearLayoutManager layoutManager = new AdaptionLinearLayoutManager(mContext, VERTICAL, true, datas.size()) {
            @Override
            public boolean canScrollVertically() {
                //{｝内部分可以开启滑动
                return false;
            }
        };
        layoutManager.setAutoMeasureEnabled(false);
        recyclerView.setLayoutManager(layoutManager);
        commonAdapter.setShowFooter(false);
//        if (compareNowTime(StartTime.replaceAll(" +", ""))) {
//
//            String mMin = getTimeDifference(StartTime, getNowTime(), 2);
//            if (Integer.valueOf(mMin) > 0) {
//                myCountDownTimer = new MyCountDownTimer(Integer.valueOf(mMin) * TIME, INTERVAL);
//                myCountDownTimer.setDownTimerInterface(new DownTimerInterface() {
//                    @Override
//                    public void setText(String time) {
//                        textCountDown.setText(time);
//                    }
//
//                    @Override
//                    public void setSecText(String time) {
//
//                    }
//                });
//                myCountDownTimer.startTimer();
//
//            }
//
//        }

    }

    @Override
    public void succeedClassUp(DistanceClassTimeBean distanceClassTimeBean) {
        recLen = distanceClassTimeBean.getRows().getDistanceClassStartTime();
        if (recLen > 0) {
            myCountDownTimer = new MyCountDownTimer(recLen * TIME1, INTERVAL);
            myCountDownTimer.setDownTimerInterface(new DownTimerInterface() {
                @Override
                public void setText(String time) {
                    textCountDown.setText(time);
                }

                @Override
                public void setSecText(String time) {

                }

                @Override
                public void setThirdText(String time) {

                }
            });
            myCountDownTimer.startTimer();
        } else {
            tvTimeName.setText("已过期");
            textCountDown.setText("");
            tvTimeClock.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void succeedClassDown(DistanceClassTimeBean distanceClassTimeBean) {
//        recLen = distanceClassTimeBean.getRows().getDistanceClassStartTime();



    }

    @Override
    public void succeedClassBegin(ClassCountdownInfoBean classCountdownInfoBean) {
        tvTimeName.setText("您已上课");
        tvTimeClock.setVisibility(View.INVISIBLE);
        Long nowTime = TimeUtil.getCurTimeMills();
        String SignInTime = classCountdownInfoBean.getRows().getSignInTime();
        Long endTime = string2Milliseconds(SignInTime, DEFAULT_SIMPLE_DATE_FORMAT);
//        String time = TimeUtil.getTimeDifference(nowTime, SignInTime, 2);
        subTime = (nowTime - endTime);
        currentSecond = subTime;
        timeRunable.run();

    }

    private Runnable timeRunable = new Runnable() {
        @Override
        public void run() {

            currentSecond =currentSecond + 1000;
            textCountDown.setText(TimeUtil.getFormatHMS(currentSecond));
            if (!isPause) {
                //递归调用本runable对象，实现每隔一秒一次执行任务
                mhandle.postDelayed(this, 1000);
            }
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_time_back, R.id.tv_time_clock})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_time_back:
                if (recLen > 0) {
                    myCountDownTimer.cancelTimer();
                }
                mhandle.removeCallbacks(timeRunable);
                finish();
                break;
            case R.id.tv_time_clock:
                Intent intent = new Intent(mContext, ClockInClassActivity.class);
                intent.putExtra(PUT_STR + "AppointmentId", AppointmentId);
                intent.putExtra(PUT_STR + "LessonName", LessonName);
                intent.putExtra(PUT_STR + "TeacherName", TeacherName);
                intent.putExtra(PUT_STR + "TextTime", TextTime);
                intent.putExtra(PUT_STR + "StartTime", StartTime);
                startActivity(intent);
                if (recLen > 0) {
                    myCountDownTimer.cancelTimer();
                }
                break;
        }
    }
}


