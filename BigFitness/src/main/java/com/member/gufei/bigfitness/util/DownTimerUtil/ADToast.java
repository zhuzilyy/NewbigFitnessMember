package com.member.gufei.bigfitness.util.DownTimerUtil;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;

/**
 * Created by ykj on 15-12-25.
 */
public class ADToast implements View.OnTouchListener {

    Context mContext;
    WindowManager.LayoutParams params;
    WindowManager mWM;
    View mView;

    public static final int TOP = 101;
    public static final int CENTER = 102;
    public static final int BOTTOM = 103;

    public static final int LENGTH_ALWAYS = 0;
    public static final int LENGTH_SHORT = 2;
    public static final int LENGTH_LONG = 4;

    private float mTouchStartX;
    private float mTouchStartY;
    private float x;
    private float y;
    int mDuration = 0;
    Handler mHandler;

    public ADToast(Context context){
        this.mContext = context;
        mHandler = new Handler();
        params = new WindowManager.LayoutParams();
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.format = PixelFormat.TRANSLUCENT;
        params.windowAnimations = R.style.anim_view;
        params.type = WindowManager.LayoutParams.TYPE_APPLICATION_ATTACHED_DIALOG ;
        params.gravity = Gravity.LEFT | Gravity.TOP;
        params.setTitle("Toast");
        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        mWM = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        LayoutInflater inflate = (LayoutInflater)
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflate.inflate(R.layout.float_tips_layout, null);
        mView.setOnTouchListener(this);
    }
    public void setDuration(int duration) {
        mDuration = duration;
    }

    public int getDuration() {
        return mDuration;
    }
    public void setGravity(int gravity){
        switch (gravity){
            case TOP:
                params.gravity = Gravity.FILL_HORIZONTAL | Gravity.TOP;
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                params.windowAnimations = R.style.top_anim_view;
                break;
            case CENTER:
                params.gravity = Gravity.CENTER;
                params.width = WindowManager.LayoutParams.WRAP_CONTENT;
                params.windowAnimations = R.style.center_anim_view;
                break;
            case BOTTOM:
                params.gravity = Gravity.FILL_HORIZONTAL | Gravity.BOTTOM;
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                params.windowAnimations = R.style.bottom_anim_view;
                break;
        }
    }

    public void show(){
        TextView tv = (TextView)mView.findViewById(R.id.message);
        tv.setText("黑科技");
        if (mView.getParent() != null) {
            mWM.removeView(mView);
        }
        mWM.addView(mView, params);

                //判断duration，如果大于#LENGTH_ALWAYS 则设置消失时间
        if (mDuration > LENGTH_ALWAYS) {
            mHandler.removeCallbacks(hideRunnable);
            mHandler.postDelayed(hideRunnable, mDuration * 1000);
        }
    }
    private Runnable hideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    public void hide(){
        if(mView!=null){
            mWM.removeView(mView);
        }
    }

    public void setText(String text){
        TextView tv = (TextView)mView.findViewById(R.id.message);
        tv.setText(text);
    }

    private void updateViewPosition(){
        //更新浮动窗口位置参数
        params.x=(int) (x-mTouchStartX);
        params.y=(int) (y-mTouchStartY);
        mWM.updateViewLayout(mView, params);  //刷新显示
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //获取相对屏幕的坐标，即以屏幕左上角为原点
        x = event.getRawX();
        y = event.getRawY();
        Log.i("currP", "currX"+x+"====currY"+y);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:    //捕获手指触摸按下动作
                //获取相对View的坐标，即以此View左上角为原点
                mTouchStartX =  event.getX();
                mTouchStartY =  event.getY();
                Log.i("startP","startX"+mTouchStartX+"====startY"+mTouchStartY);
                break;
            case MotionEvent.ACTION_MOVE:   //捕获手指触摸移动动作
                updateViewPosition();
                break;
            case MotionEvent.ACTION_UP:    //捕获手指触摸离开动作
                updateViewPosition();
                break;
        }
        return true;
    }
}
