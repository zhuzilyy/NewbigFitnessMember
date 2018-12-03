package com.member.gufei.bigfitness.util.MyVideoView;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.VideoView;

import com.member.gufei.bigfitness.util.NgCommon.util.LogUtils;

/**
 * Created by GuFei on 2018/4/11.
 */

public class MyVideoView extends VideoView      {


   private VidioInterface vidioInterface=null;
   private GestureDetector mGesture;
    public MyVideoView(Context context) {
        super(context);

    }

    public MyVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyVideoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getDefaultSize(getWidth(), widthMeasureSpec);
        int height = getDefaultSize(getHeight(), heightMeasureSpec);
        setMeasuredDimension(width, height);
    }



    public void setVidioInterface(VidioInterface vidioInterface) {
        this.vidioInterface = vidioInterface;
    }


}
