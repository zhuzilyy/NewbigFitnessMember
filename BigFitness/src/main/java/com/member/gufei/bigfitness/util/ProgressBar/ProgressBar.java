package com.member.gufei.bigfitness.util.ProgressBar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.member.gufei.bigfitness.R;

/**
 * Created by GuFei on 2018/3/14.
 */

public class ProgressBar extends View {

    private Paint mPaint;
    private float mWidthPercentage;
    private float mRadius = 0;
    public ProgressBar(Context context, float mWidthPercentage) {
        super(context, null);
       this. mWidthPercentage = mWidthPercentage;

        init();

    }

//    public ProgressBar(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs, 0);
//    }
//
//    public ProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//
//
//    }


    private void init() {
        mPaint = new Paint();
        mPaint.setColor(getResources().getColor(R.color.green_btn))
        ;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        RectF rect = new RectF(0, 0, width * mWidthPercentage, height);
        canvas.drawRect(rect, mPaint);

    }
}
