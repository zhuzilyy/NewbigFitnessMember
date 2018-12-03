package com.member.gufei.bigfitness.util.MyImageView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by GuFei_lyf on 2017/4/14
 *
 * 重新绘制imageView 为1:1
 */

public class MyImageView extends android.support.v7.widget.AppCompatImageView {

    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //传入参数widthMeasureSpec、heightMeasureSpec
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
