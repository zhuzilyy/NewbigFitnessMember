package com.member.gufei.bigfitness.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.ReservationRecordList.ReservationRecordListActivity;
import com.member.gufei.bigfitness.util.DownTimerUtil.DownTimerEndInterface;
import com.member.gufei.bigfitness.util.DownTimerUtil.DownTimerInterface;

import static cn.jzvd.JZMediaManager.TAG;
import static com.member.gufei.bigfitness.Constants.INTERVAL;
import static com.member.gufei.bigfitness.Constants.TIME;

/**
 * Created by ykj on 15-12-25.
 */
public class FloatTips {

    private DownTimerEndInterface mDownTimerInterface;
    public static final int TOP = 101;
    public static final int CENTER = 102;
    public static final int BOTTOM = 103;

    public static final int LENGTH_ALWAYS = 0;
    public static final int LENGTH_SHORT = 2;
    public static final int LENGTH_LONG = 4;

    public MyCountDownTimer myCountDownTimer;
    Context mContext;
    WindowManager.LayoutParams params;
    WindowManager mWM;
    View mView;
    TextView mTv;
    Handler mHandler;
    int mDuration = LENGTH_SHORT;

    public FloatTips(Context context) {
        this.mContext = context;
        mHandler = new Handler();
        params = new WindowManager.LayoutParams();
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;

        params.format = PixelFormat.TRANSLUCENT;
        params.alpha = 80;
        params.windowAnimations = R.style.center_anim_view;
        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
        params.setTitle("FloatTips");
        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        mWM = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        LayoutInflater inflate = (LayoutInflater)
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflate.inflate(R.layout.float_tips_layout, null);
        mTv = (TextView) mView.findViewById(R.id.message);
        mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext,ReservationRecordListActivity.class);
                mContext.startActivity(intent);
            }
        });

    }

    public void setGravity(int gravity) {
        switch (gravity) {
            case TOP:
                params.gravity = Gravity.FILL_HORIZONTAL | Gravity.TOP;
                params.width = WindowManager.LayoutParams.WRAP_CONTENT;
                params.windowAnimations = R.style.top_anim_view;
                break;
            case CENTER:
                params.gravity = Gravity.CENTER;
                params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                params.width = WindowManager.LayoutParams.WRAP_CONTENT;
                params.windowAnimations = R.style.center_anim_view;
                break;
            case BOTTOM:
                params.gravity = Gravity.BOTTOM | Gravity.RIGHT;

                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                params.windowAnimations = R.style.bottom_anim_view;
                break;
        }
    }

    private Runnable hideRunnable = new Runnable() {
        @Override
        public void run() {

            mDownTimerInterface.endTime();
            hide();
        }
    };

    public void  setDownTimerEndInterface(DownTimerEndInterface downTimerEndInterface){
        this.mDownTimerInterface=downTimerEndInterface;
    }
    /*
     * 将时分秒转为秒数
     * */
    public long formatTurnSecond(String time) {
        String s = time;
        int index1 = s.indexOf(":");
        int index2 = s.indexOf(":", index1 + 1);
        int hh = Integer.parseInt(s.substring(0, index1));
        int mi = Integer.parseInt(s.substring(index1 + 1, index2));
        int ss = Integer.parseInt(s.substring(index2 + 1));

        Log.e(TAG, "formatTurnSecond: 时间== " + hh * 60 * 60 + mi * 60 + ss);
        return hh * 60 * 60 + mi * 60 + ss;
    }
    CountDownTimer con;
    public  void timeDiff(long countDownSecs){
        con=new CountDownTimer(countDownSecs*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
//                mTv.setText(countTime(millisUntilFinished)));
            }
            @Override
            public void onFinish() {

            }
        };
        con.start();
    }
    public  String countTime(long leftMilliseSecond){
        long day=leftMilliseSecond/1000/60/60/24;
        long hour=leftMilliseSecond/(60 * 60 * 1000)- day * 24;
        long min=leftMilliseSecond/(60 * 1000)-hour*60- day * 24*60;
        long second=leftMilliseSecond/1000-hour*60*60- day * 24*60*60-min*60;
        String ss="";
        return ss=hour+":"+min+":"+ss;
    }
    public void show(String time) {
        if (mView.getParent() != null) {
            mWM.removeView(mView);
        }
        mWM.addView(mView, params);
//        timeDiff(time);
//        myCountDownTimer = new MyCountDownTimer(formatTurnSecond(time), INTERVAL);
//        myCountDownTimer.setDownTimerInterface(new DownTimerInterface() {
//            @Override
//            public void setText(String time) {
//                {
//                    mTv.setText(time);
//                }
//            }
//
//            @Override
//            public void setSecText(String time) {
//
//            }
//        });
//        myCountDownTimer.startTimer();
//        //判断duration，如果大于#LENGTH_ALWAYS 则设置消失时间
//        if (formatTurnSecond(time) > LENGTH_ALWAYS) {
//            mHandler.removeCallbacks(hideRunnable);
//            mHandler.postDelayed(hideRunnable, formatTurnSecond(time) );
//        }
    }

    public void hide() {
        if (mView != null) {
            if (mView.getParent() != null) {
                mWM.removeView(mView);
            }
            if (myCountDownTimer != null) {
                myCountDownTimer.onFinish();
            }
        }
    }


    public void setText(String text) {
        mTv.setText(text);
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public int getDuration() {
        return mDuration;
    }

    static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
