package com.member.gufei.bigfitness.util;

import android.os.CountDownTimer;
import android.view.View;

import com.member.gufei.bigfitness.util.DownTimerUtil.DownTimerInterface;

/**
 * Created by GuFei on 2018/4/15.
 */

public class MyCountDownTimer extends CountDownTimer {

   private DownTimerInterface downTimerInterface;



    public MyCountDownTimer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }


    public void  setDownTimerInterface(DownTimerInterface downTimerInterface){
        this.downTimerInterface=downTimerInterface;
    }
    @Override
    public void onTick(long millisUntilFinished) {
        long time = millisUntilFinished / 1000;
        if (time <= 59) {
//            floatTips.setText();
            downTimerInterface.setText(String.format("00:00:%02d", time));
            downTimerInterface.setSecText(String.format("00:%02d", time));
            downTimerInterface.setThirdText(String.format("%02d", time));
        } else if(time > 3600){
            downTimerInterface.setText(String.format("%02d:%02d:%02d",time / 3600, (time % 3600) / 60, time % 60));

        }else {
            downTimerInterface.setText(String.format("00:%02d:%02d", time / 60, time % 60));
        }
    }

    @Override
    public void onFinish() {

        downTimerInterface.setText("00:00:00");
        cancelTimer();
    }


    public void start(View view) {
        startTimer();
    }

    public void cancel(View view) {
        downTimerInterface.setText("00:00");
        cancelTimer();
    }



//    /**
//     * 开始倒计时
//     */
//    public void InitTimer() {
//        if (this == null) {
//            super(TIME, INTERVAL);
//        }
////        this.start();
//    }


    /**
     * 开始倒计时
     */
    public void startTimer() {
//        if (this == null) {
//            timer = new MainActivity.MyCountDownTimer(TIME, INTERVAL);
//        }
        this.start();
    }


    /**
     * 取消倒计时
     */
    public void cancelTimer() {
        if (this != null) {
            this.cancel();
//            this = null;
        }
    }
}