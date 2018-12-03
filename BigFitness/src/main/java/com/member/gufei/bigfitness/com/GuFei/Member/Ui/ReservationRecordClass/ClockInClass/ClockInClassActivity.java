package com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.ClockInClass;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.member.gufei.bigfitness.Constants;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.TimeForClass.TimeForClassActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CreateLessonQRBean;
import com.member.gufei.bigfitness.util.MyImageView.MyImageView;
import com.member.gufei.bigfitness.util.SpUtil;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;

import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;

public class ClockInClassActivity extends BaseActivity<ClockInClassActivityPresenter> implements ClockInClassActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    int UserId;
    String token;
    String AppointmentId;
    String ClubId;
    @BindView(R.id.text_name_lesson)
    TextView textNameLesson;
    @BindView(R.id.text_name_coach)
    TextView textNameCoach;
    @BindView(R.id.text_time)
    TextView textTime;
    @BindView(R.id.toast_info)
    TextView toastInfo;
    @BindView(R.id.img_qrcode)
    MyImageView imgQrcode;
    private String LessonName;
    private String TeacherName;
    private String TextTime;
    private String StartTime;
    String TwoDimensionCode;
    String TwoDimensionCodeCreateTime;
    String TwoDimensionCodeExpireTime;
    private CountDownTimer countDownTimer;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_clockinclass;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
//
        setToolBar(toolbar, "");

        tvTitle.setText("上课打卡");

        btnComplete.setVisibility(View.GONE);


        Intent intent = getIntent();


        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        AppointmentId = intent.getStringExtra(PUT_STR + "AppointmentId");
        LessonName = intent.getStringExtra(PUT_STR + "LessonName");
        TeacherName = intent.getStringExtra(PUT_STR + "TeacherName");
        TextTime = intent.getStringExtra(PUT_STR + "TextTime");
        StartTime = intent.getStringExtra(PUT_STR + "StartTime");

        textNameLesson.setText(LessonName);
        textNameCoach.setText(TeacherName);
        textTime.setText(TextTime);

        countDownTimer = new CountDownTimer(600000, 60000) {
            @Override
            public void onTick(long millisUntilFinished) {
                initData();
            }
            // 定时器结束后,自动重启。
            @Override
            public void onFinish() {

                start();
            }
        }.start();

//        // 手动刷新后,下次10秒后才会自动刷新
//        if(isManuallyExecuted){
//            countDownTimer.cancel();
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    countDownTimer.start();
//                }
//            }, 10000);
//        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            countDownTimer.cancel();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initData() {
        mPresenter.CreateLessonQR(String.valueOf(UserId), ClubId, token, AppointmentId);
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
    public void succeed(CreateLessonQRBean createLessonQRBean) {

        TwoDimensionCode = String.valueOf(createLessonQRBean.getRows().getTwoDimensionCode());
        TwoDimensionCodeCreateTime = String.valueOf(createLessonQRBean.getRows().getTwoDimensionCodeCreateTime());
        TwoDimensionCodeExpireTime = String.valueOf(createLessonQRBean.getRows().getTwoDimensionCodeExpireTime());
        String newString = Constants.BASEURL+"/appMember/memberLesson/ScanLessonQR?" + "ClubId=" + ClubId + "&"
        + "AppointmentId=" + AppointmentId + "&"
                + "TwoDimensionCode=" + TwoDimensionCode + "&"
                + "TwoDimensionCodeCreateTime=" + TwoDimensionCodeCreateTime + "&"
                + "TwoDimensionCodeExpireTime=" + TwoDimensionCodeExpireTime;

            Bitmap mBitmap = CodeUtils.createImage(newString, imgQrcode.getWidth(), imgQrcode.getHeight(), null);
            imgQrcode.setImageBitmap(mBitmap);


//        toastInfo.setVisibility(View.GONE);
//        myCountDownTimer = new MyCountDownTimer(1 * TIME, INTERVAL);
//        myCountDownTimer.setDownTimerInterface(new DownTimerInterface() {
//            @Override
//            public void setText(String time) {
//                {
//                    if (time.equals("00:00")) {
////                     toastInfo.setVisibility(View.VISIBLE);
////                     s(mContext,"");
//                        mPresenter.CreateLessonQR(String.valueOf(UserId), ClubId, token, AppointmentId);
//                        myCountDownTimer.cancelTimer();
//                    }
//                }
//            }
//
//            @Override
//            public void setSecText(String time) {
//
//            }
//
//            @Override
//            public void setThirdText(String time) {
//
//            }
//        });
//
//
//        myCountDownTimer.startTimer();

    }

    public void GoCountdownAvtivity(){



        Intent intent=new Intent(mContext, TimeForClassActivity.class);
        intent.putExtra(PUT_STR + "AppointmentId",AppointmentId);
        intent.putExtra(PUT_STR + "LessonName", LessonName);
        intent.putExtra(PUT_STR + "TeacherName", TeacherName);
        intent.putExtra(PUT_STR + "TextTime", TextTime);
        intent.putExtra(PUT_STR + "StartTime", StartTime );
        startActivity(intent);

    }

}


