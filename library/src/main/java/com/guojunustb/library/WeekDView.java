package com.guojunustb.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.OverScroller;
import android.widget.Scroller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * Created by Raquib-ul-Alam Kanak on 7/21/2014.
 * Website: http://alamkanak.github.io/
 */
public class WeekDView extends View {
    private final static String TAG = "WeekNoHeaderDView";
    @Deprecated
    public static final int LENGTH_SHORT = 1;
    @Deprecated
    public static final int LENGTH_LONG = 2;
    private final Context mContext;
    private Calendar mToday;

    private Paint mTimeTextPaint;
    private Paint mCurrentTimeTextPaint;
    private float moveLength;

    private float mTimeTextWidth;
    private float mTimeTextHeight;
    private Paint mHeaderTextPaint;
    private float mHeaderTextHeight;
    private GestureDetectorCompat mGestureDetector;
    private OverScroller mScroller;
    private PointF mCurrentOrigin = new PointF(0f, 0f);
    private Direction mCurrentScrollDirection = Direction.NONE;
    private Paint mHeaderBackgroundPaint;
    private float mWidthPerDay;
    private Paint mDayBackgroundPaint;
    private Paint mHourSeparatorPaint;
    private float mHeaderMarginBottom;
    private Paint mTodayBackgroundPaint;
    private Paint mTodayHeaderTextPaint;
    private Paint mEventBackgroundPaint;
    private float mHeaderColumnWidth;
    private float mHeaderHeight;
    private List<EventRect> mEventRects;
    private TextPaint mEventTextPaint;
    private Paint mHeaderColumnBackgroundPaint;
    private Scroller mStickyScroller;
    private int mFetchedMonths[] = new int[3];
    private boolean mRefreshEvents = false;
    private float mDistanceY = 0;
    private float mDistanceX = 0;
    private Direction mCurrentFlingDirection = Direction.NONE;

    // 属性及其默认值
    private int mHourHeight = 50;
    private int mColumnGap = 10;//
    private int mFirstDayOfWeek = Calendar.SUNDAY;
    private int mTextSize = 12;
    private int mHeaderColumnPadding = 10;
    private int mHeaderColumnTextColor = Color.WHITE;
    private int mNumberOfVisibleDays = 7;
    private int mHeaderRowPadding = 10;
    private int mHeaderRowBackgroundColor = Color.BLUE;
    //    private int mDayBackgroundColor = Color.rgb(245, 245, 245);
    private int mDayBackgroundColor = Color.WHITE;
    private int mHourSeparatorColor = Color.parseColor("#2A314B");
    //    private int mTodayBackgroundColor = Color.rgb(239, 247, 254);
    private int mTodayBackgroundColor = Color.RED;


    private int mCurrentTimeTextColor = Color.parseColor("#2A314B");
    private int mHourSeparatorHeight = 1;//小时上下空白高度
    //    private int mTodayHeaderTextColor = Color.rgb(39, 137, 228);
    private int mTodayHeaderTextColor = Color.WHITE;
    private int mEventTextSize = 12;//事件字体大小
    private int mEventTextColor = Color.BLACK;
    private int mEventPadding = 8;
    private int mHeaderColumnBackgroundColor = Color.parseColor("#2A314B");
    //    private int mHeaderColumnBackgroundColor = Color.RED;
    private int mDefaultEventColor;
    private boolean mIsFirstDraw = true;
    private boolean mAreDimensionsInvalid = true;
    private boolean mAreDimensionsInvalidX = false;
    private boolean mAreDimensionsInvalidF = true;

    @Deprecated
    private int mDayNameLength = LENGTH_LONG;
    private int mOverlappingEventGap = 0;
    private int mEventMarginVertical = 0;
    private float mXScrollingSpeed = 3f;
    private Calendar mFirstVisibleDay;
    private Calendar mLastVisibleDay;
    private Calendar mScrollToDay = null;
    private double mScrollToHour = -1;


    // 监听器
    private EventClickListener mEventClickListener;
    private EventLongPressListener mEventLongPressListener;
    private MonthChangeListener mMonthChangeListener;
    private EmptyViewClickListener mEmptyViewClickListener;
    private EmptyViewLongPressListener mEmptyViewLongPressListener;
    private DateTimeInterpreter mDateTimeInterpreter;
    private ScrollListener mScrollListener;
    private Calendar mSelectedDate;
    private Calendar mLastSelectedDate;

    private boolean onDownTouch = false;


    private final GestureDetector.SimpleOnGestureListener mGestureListener = new GestureDetector.SimpleOnGestureListener() {

        @Override
        public boolean onDown(MotionEvent e) {
            mScroller.forceFinished(true);
            mStickyScroller.forceFinished(true);
            mLastSelectedDate = mSelectedDate;
            moveLength = 0;
//            oldX = 0;
            mAreDimensionsInvalidF = true;
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {


            if (mCurrentScrollDirection == WeekDView.Direction.NONE) {
                if (Math.abs(distanceX) > Math.abs(distanceY)) {
                    mCurrentScrollDirection = WeekDView.Direction.HORIZONTAL;
                    mCurrentFlingDirection = WeekDView.Direction.HORIZONTAL;


                } else {
                    mCurrentFlingDirection = WeekDView.Direction.VERTICAL;
                    mCurrentScrollDirection = WeekDView.Direction.VERTICAL;
                }
            }
            moveLength += distanceX;

            float x = e1.getX() - e2.getX();

            Log.e("原点1:", mScroller.getCurrY() + "-----------" + e1.getY() + "");
            mDistanceX = distanceX;
            mDistanceY = distanceY;
            if (mCurrentScrollDirection != WeekDView.Direction.VERTICAL) {
                if (Math.abs(x) > 300 && mAreDimensionsInvalidF && Math.abs(moveLength) > 80) {
//                    oldX = mScroller.getCurrX() - e1.getX();
                    mAreDimensionsInvalidX = true;
                    mAreDimensionsInvalidF = false;
                    invalidate();
//                Log.e("原点:", oldX + "");
                    return false;
                }
            }
            else if(mCurrentScrollDirection == WeekDView.Direction.VERTICAL &&    mCurrentScrollDirection != WeekDView.Direction.HORIZONTAL){

                mAreDimensionsInvalidF=true;
                invalidate();

            }

            return true;
        }


        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            mScroller.forceFinished(true);
            mStickyScroller.forceFinished(true);


            if (mCurrentFlingDirection == WeekDView.Direction.HORIZONTAL) {


            } else if (mCurrentFlingDirection == WeekDView.Direction.VERTICAL) {
//                mScroller.fling(0, (int) mCurrentOrigin.y, 0, (int) (velocityY * mXScrollingSpeed), 0, 0, (int) -(mHourHeight * 24 + mHeaderTextHeight + mHeaderRowPadding * 2 - getHeight()), 0);
                mScroller.fling(0, (int) mCurrentOrigin.y, 0,(int) (velocityY * mXScrollingSpeed), 0, 0, (int) -(mHourHeight * 24 + mHeaderTextHeight + mHeaderRowPadding * 2 - getHeight()), 0);
            }

//            ViewCompat.postInvalidateOnAnimation(WeekNoHeaderView.this);
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            // If the tap was on an event then trigger the callback.
            if (mEventRects != null && mEventClickListener != null) {
                List<EventRect> reversedEventRects = mEventRects;
                Collections.reverse(reversedEventRects);
                for (EventRect event : reversedEventRects) {
                    if (event.rectF != null && e.getX() > event.rectF.left && e.getX() < event.rectF.right && e.getY() > event.rectF.top && e.getY() < event.rectF.bottom) {
                        mEventClickListener.onEventClick(event.originalEvent, event.rectF);
                        playSoundEffect(SoundEffectConstants.CLICK);
                        return super.onSingleTapConfirmed(e);
                    }
                }
            }

            // If the tap was on in an empty space, then trigger the callback.
            if (mEmptyViewClickListener != null && e.getX() > mHeaderColumnWidth && e.getY() > (mHeaderTextHeight + mHeaderRowPadding * 2 + mHeaderMarginBottom)) {
                Calendar selectedTime = getTimeFromPoint(e.getX(), e.getY());
                if (selectedTime != null) {
                    playSoundEffect(SoundEffectConstants.CLICK);
                    mEmptyViewClickListener.onEmptyViewClicked(selectedTime);
                }
            }

            return super.onSingleTapConfirmed(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);

            if (mEventLongPressListener != null && mEventRects != null) {
                List<EventRect> reversedEventRects = mEventRects;
                Collections.reverse(reversedEventRects);
                for (EventRect event : reversedEventRects) {
                    if (event.rectF != null && e.getX() > event.rectF.left && e.getX() < event.rectF.right && e.getY() > event.rectF.top && e.getY() < event.rectF.bottom) {
                        mEventLongPressListener.onEventLongPress(event.originalEvent, event.rectF);
                        performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
                        return;
                    }
                }
            }

            // If the tap was on in an empty space, then trigger the callback.
            if (mEmptyViewLongPressListener != null && e.getX() > mHeaderColumnWidth && e.getY() > (mHeaderTextHeight + mHeaderRowPadding * 2 + mHeaderMarginBottom)) {
                Calendar selectedTime = getTimeFromPoint(e.getX(), e.getY());
                if (selectedTime != null) {
                    performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
                    mEmptyViewLongPressListener.onEmptyViewLongPress(selectedTime);
                }
            }
        }
    };

    private enum Direction {
        NONE, HORIZONTAL, VERTICAL
    }

    public WeekDView(Context context) {
        this(context, null);
    }

    public WeekDView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WeekDView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        // Hold references.
        mContext = context;

        // Get the attribute values (if any).
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.WeekView, 0, 0);
        try {
            mFirstDayOfWeek = a.getInteger(R.styleable.WeekView_firstDayOfWeek, mFirstDayOfWeek);
            mHourHeight = a.getDimensionPixelSize(R.styleable.WeekView_hourHeight, mHourHeight);
            mTextSize = a.getDimensionPixelSize(R.styleable.WeekView_textSize, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, mTextSize, context.getResources().getDisplayMetrics()));
            mHeaderColumnPadding = a.getDimensionPixelSize(R.styleable.WeekView_headerColumnPadding, mHeaderColumnPadding);
            mColumnGap = a.getDimensionPixelSize(R.styleable.WeekView_columnGap, mColumnGap);
            mHeaderColumnTextColor = a.getColor(R.styleable.WeekView_headerColumnTextColor, mHeaderColumnTextColor);
            mNumberOfVisibleDays = a.getInteger(R.styleable.WeekView_noOfVisibleDays, mNumberOfVisibleDays);
            mHeaderRowPadding = a.getDimensionPixelSize(R.styleable.WeekView_headerRowPadding, mHeaderRowPadding);
            mHeaderRowBackgroundColor = a.getColor(R.styleable.WeekView_headerRowBackgroundColor, mHeaderRowBackgroundColor);
            mDayBackgroundColor = a.getColor(R.styleable.WeekView_dayBackgroundColor, mDayBackgroundColor);
            mHourSeparatorColor = a.getColor(R.styleable.WeekView_hourSeparatorColor, mHourSeparatorColor);
            mTodayBackgroundColor = a.getColor(R.styleable.WeekView_todayBackgroundColor, mTodayBackgroundColor);
            mHourSeparatorHeight = a.getDimensionPixelSize(R.styleable.WeekView_hourSeparatorHeight, mHourSeparatorHeight);
            mTodayHeaderTextColor = a.getColor(R.styleable.WeekView_todayHeaderTextColor, mTodayHeaderTextColor);
            mEventTextSize = a.getDimensionPixelSize(R.styleable.WeekView_eventTextSize, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, mEventTextSize, context.getResources().getDisplayMetrics()));
            mEventTextColor = a.getColor(R.styleable.WeekView_eventTextColor, mEventTextColor);
            mEventPadding = a.getDimensionPixelSize(R.styleable.WeekView_hourSeparatorHeight, mEventPadding);
            mHeaderColumnBackgroundColor = a.getColor(R.styleable.WeekView_headerBackground, mHeaderColumnBackgroundColor);
            mDayNameLength = a.getInteger(R.styleable.WeekView_dayNameLength, mDayNameLength);
            mOverlappingEventGap = a.getDimensionPixelSize(R.styleable.WeekView_overlappingEventGap, mOverlappingEventGap);
            mEventMarginVertical = a.getDimensionPixelSize(R.styleable.WeekView_eventMarginVertical, mEventMarginVertical);
            mXScrollingSpeed = a.getFloat(R.styleable.WeekView_xScrollingSpeed, mXScrollingSpeed);
        } finally {
            a.recycle();
        }

        init();
    }

    private void init() {
        // Get the date today.
        mToday = Calendar.getInstance();
        mToday.set(Calendar.HOUR_OF_DAY, 0);
        mToday.set(Calendar.MINUTE, 0);
        mToday.set(Calendar.SECOND, 0);

        mSelectedDate = (Calendar) mToday.clone();
        mLastSelectedDate = (Calendar) mToday.clone();

        //滚动的初始化。
        mGestureDetector = new GestureDetectorCompat(mContext, mGestureListener);
        mScroller = new OverScroller(mContext);

        mStickyScroller = new Scroller(mContext);

        // 测量时间列的设置。
        mTimeTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTimeTextPaint.setTextAlign(Paint.Align.RIGHT);
        mTimeTextPaint.setTextSize(mTextSize);
        mTimeTextPaint.setColor(mHeaderColumnTextColor);
        Rect rect = new Rect();
        mTimeTextPaint.getTextBounds("00:00", 0, "00:00".length(), rect);
        mTimeTextWidth = mTimeTextPaint.measureText("00:00");
        mTimeTextHeight = rect.height();
        mHeaderMarginBottom = mTimeTextHeight / 2;

        mCurrentTimeTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCurrentTimeTextPaint.setTextAlign(Paint.Align.RIGHT);
        mCurrentTimeTextPaint.setTextSize(mTextSize);
        mCurrentTimeTextPaint.setColor(mCurrentTimeTextColor);

        mCurrentTimeTextPaint.getTextBounds("00:00", 0, "00:00".length(), rect);


        // 标题行的设置。
        mHeaderTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mHeaderTextPaint.setColor(mHeaderColumnTextColor);
        mHeaderTextPaint.setTextAlign(Paint.Align.CENTER);
        mHeaderTextPaint.setTextSize(mTextSize);
        mHeaderTextPaint.getTextBounds("00:00", 0, "00:00".length(), rect);
        mHeaderTextHeight = rect.height();
        mHeaderTextPaint.setTypeface(Typeface.DEFAULT_BOLD);

        // Prepare header background paint.
        mHeaderBackgroundPaint = new Paint();
        mHeaderBackgroundPaint.setColor(mHeaderColumnBackgroundColor);

        // Prepare day background color paint.
        mDayBackgroundPaint = new Paint();
        mDayBackgroundPaint.setColor(mDayBackgroundColor);

        // 准备时间间隔画笔
        mHourSeparatorPaint = new Paint();
        mHourSeparatorPaint.setStyle(Paint.Style.STROKE);
        mHourSeparatorPaint.setStrokeWidth(1);
//        mHourSeparatorPaint.setStrokeWidth(mHourSeparatorHeight-5);
        mHourSeparatorPaint.setColor(mHourSeparatorColor);

        // 准备今天的背景色
        mTodayBackgroundPaint = new Paint();
        mTodayBackgroundPaint.setColor(mTodayBackgroundColor);

        // 准备今天的标题文字颜色。
        mTodayHeaderTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTodayHeaderTextPaint.setTextAlign(Paint.Align.CENTER);
        mTodayHeaderTextPaint.setTextSize(mTextSize);
        mTodayHeaderTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        mTodayHeaderTextPaint.setColor(mTodayHeaderTextColor);

        // Prepare event background color.
        mEventBackgroundPaint = new Paint();
//        mEventBackgroundPaint.setColor(Color.rgb(174, 208, 238));
        mEventBackgroundPaint.setColor(Color.rgb(245, 245, 245));

        // Prepare header column background color.
        mHeaderColumnBackgroundPaint = new Paint();
        mHeaderColumnBackgroundPaint.setColor(mHeaderColumnBackgroundColor);
        // TODO: 2018/4/20 暂做修改
        mHeaderColumnBackgroundPaint.setColor(Color.GREEN);

        // Prepare event text size and color.
        mEventTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.LINEAR_TEXT_FLAG);
        mEventTextPaint.setStyle(Paint.Style.FILL);
        mEventTextPaint.setColor(mEventTextColor);
        mEventTextPaint.setTextSize(mEventTextSize);
//        mStartDate = (Calendar) mToday.clone();

        // Set default event color.
        mDefaultEventColor = Color.parseColor("#F5F5F5");

        mHeaderHeight=mHeaderTextHeight + mHeaderRowPadding + 40;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(0, mHeaderHeight+mHeaderTextHeight+80, mTimeTextWidth + mHeaderColumnPadding * 2, mHeaderHeight+mHeaderTextHeight+80, mHeaderBackgroundPaint);
        Paint tmpP = new Paint();
        float y =mHeaderTextHeight+30;
        tmpP.setColor(Color.WHITE);
        canvas.drawLine(0, y, getWidth(), y, tmpP);// 画线


        // 画出分割线等
        drawHeaderRowAndEvents(canvas);

        // 绘制时间列和所有的轴/分隔符。
        drawTimeColumnAndAxes(canvas);

        // 隐藏任何位于标题行底部边缘的内容。
//        canvas.drawRect(mHeaderColumnWidth, 80, getWidth(), mHeaderMarginBottom + mTimeTextHeight / 2 - mHourSeparatorHeight / 2, mHeaderColumnBackgroundPaint);
//        onDownTouch = false;
        mAreDimensionsInvalidF = false;



    }

    private void drawTimeColumnAndAxes(Canvas canvas) {


//        // 不要让视图高于/低于滚动的限制。设置滚动条的最大值和最小值。
        if (mCurrentScrollDirection == Direction.VERTICAL) {


            if (mCurrentOrigin.y - mDistanceY > mHeaderHeight+mHeaderTextHeight+80)
                mCurrentOrigin.y = mHeaderHeight+mHeaderTextHeight+80;
            else if (mCurrentOrigin.y - mDistanceY < -(mHourHeight * 24 + 0 - getHeight()+mHeaderHeight+mHeaderTextHeight+80))
                mCurrentOrigin.y = -(mHourHeight * 24 + 0 - getHeight()+mHeaderHeight+mHeaderTextHeight+80 + 0)-mHeaderHeight;
            else if(mCurrentOrigin.y>getHeight()+mHeaderHeight+mHeaderTextHeight+80){
                mCurrentOrigin.y =(mHourHeight * 24 +mHourHeight);
            }

            else mCurrentOrigin.y -= mDistanceY;
        }

        // 绘制标题栏的背景颜色。
        canvas.drawRect(0, 0, mHeaderColumnWidth, getHeight(), mHeaderColumnBackgroundPaint);

        for (int i = 0; i < 24; i++) {
            float top =  mCurrentOrigin.y + mHourHeight * i + mHeaderMarginBottom;

            // 如果它的y位置不在可见区域之外，则绘制文本。文本的枢轴点是右下角的点。
            String time = getDateTimeInterpreter().interpretTime(i);
            if (time == null)
                throw new IllegalStateException("A DateTimeInterpreter must not return null time");
            if (top < getHeight())
                Log.e("<-----------------", mCurrentOrigin.y+"");
                canvas.drawText(time, mTimeTextWidth + mHeaderColumnPadding, top + mTimeTextHeight +0, mTimeTextPaint);
        }
        boolean sameDay = isSameDay(mSelectedDate, mToday);
        if (sameDay) {
            SimpleDateFormat weekdayNameFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
            String time = weekdayNameFormat.format(System.currentTimeMillis());
            Calendar now = Calendar.getInstance();
            now.setTimeInMillis(System.currentTimeMillis());
            float top = (mHourHeight * 24 / 1440) * (60 * now.get(Calendar.HOUR_OF_DAY) + now.get(Calendar.MINUTE)) + mTimeTextHeight + mCurrentOrigin.y+mHeaderHeight+mHeaderTextHeight+80;
            canvas.drawText(time, mTimeTextWidth + mHeaderColumnPadding, top+155, mCurrentTimeTextPaint);
        }
    }

    private void drawHeaderRowAndEvents(Canvas canvas) {

        // 计算每天可用的宽度。
        mHeaderColumnWidth = mTimeTextWidth + mHeaderColumnPadding * 2;
        mWidthPerDay = getWidth() - mHeaderColumnWidth - mColumnGap * (mNumberOfVisibleDays - 1);
        mWidthPerDay = mWidthPerDay / mNumberOfVisibleDays;
        if (mAreDimensionsInvalid) {
            mAreDimensionsInvalid = false;
            if (mScrollToDay != null)
                goToDate(mScrollToDay);

            mAreDimensionsInvalid = false;
            if (mScrollToHour >= 0)
                goToHour(mScrollToHour);

            mScrollToDay = null;
            mScrollToHour = -1;
            mAreDimensionsInvalid = false;
        }
        if (mIsFirstDraw) {
            mIsFirstDraw = false;

            // I如果第一次画的是星期视图，那么考虑一周的第一天。
            if (mNumberOfVisibleDays >= 7 && mToday.get(Calendar.DAY_OF_WEEK) != mFirstDayOfWeek) {
                int difference = (7 + (mToday.get(Calendar.DAY_OF_WEEK) - mFirstDayOfWeek)) % 7;
                mCurrentOrigin.x += (mWidthPerDay + mColumnGap) * difference;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            goToHour(calendar.get(Calendar.HOUR_OF_DAY));
        }

        // 考虑滚动抵消。
        if (mCurrentScrollDirection == Direction.HORIZONTAL) {


//                 mAreDimensionsInvalid=false;
            if (mAreDimensionsInvalidX) {
                mAreDimensionsInvalidX = false;

                if (mDistanceX > 0) {

//                        mCurrentOrigin.x = mCurrentOrigin.x - (mWidthPerDay + mColumnGap) * 7;

                    mCurrentOrigin.x -= (mWidthPerDay + mColumnGap) * 7;

                } else {
                    mCurrentOrigin.x += (mWidthPerDay + mColumnGap) * 7;

//                        mCurrentOrigin.x = mCurrentOrigin.x + (mWidthPerDay + mColumnGap) * 7;

                }
                mAreDimensionsInvalidF = true;
            }

        }
        int leftDaysWithGaps = (int) -(Math.ceil(mCurrentOrigin.x / (mWidthPerDay + mColumnGap)));
        float startFromPixel = mCurrentOrigin.x + (mWidthPerDay + mColumnGap) * leftDaysWithGaps +
                mHeaderColumnWidth;
        float startPixel = startFromPixel;

        // 准备每天迭代。
        Calendar day = (Calendar) mToday.clone();
        day.add(Calendar.HOUR, 6);

        //准备每个小时的时间来画出时间线。
        int lineCount = (int) ((getHeight()- mHeaderRowPadding * 2 -
                mHeaderMarginBottom) / mHourHeight) + 1;
        lineCount = (lineCount) * (mNumberOfVisibleDays + 1);
        float[] hourLines = new float[lineCount * 4];

        // Clear the cache for event rectangles.
        if (mEventRects != null) {
            for (EventRect eventRect : mEventRects) {
                eventRect.rectF = null;
            }
        }

        // 遍历每一天。
        Calendar oldFirstVisibleDay = mFirstVisibleDay;
        mFirstVisibleDay = (Calendar) mToday.clone();
        mFirstVisibleDay.add(Calendar.DATE, leftDaysWithGaps);

        Log.d(TAG, "onFirstVisibleDayChanged" + mFirstVisibleDay.get(Calendar.DAY_OF_MONTH));
        if (null != oldFirstVisibleDay)
            Log.d(TAG, "oldFirstVisibleDay" + oldFirstVisibleDay.get(Calendar.DAY_OF_MONTH));
        if (!mFirstVisibleDay.equals(oldFirstVisibleDay) && mScrollListener != null) {
            mScrollListener.onFirstVisibleDayChanged(mFirstVisibleDay, oldFirstVisibleDay);
        }
        for (int dayNumber = leftDaysWithGaps + 1;
             dayNumber <= leftDaysWithGaps + mNumberOfVisibleDays + 1;
             dayNumber++) {

            // 确认是否当前日是否为今天~
            day = (Calendar) mToday.clone();
            mLastVisibleDay = (Calendar) day.clone();
            day.add(Calendar.DATE, dayNumber - 1);
            mLastVisibleDay.add(Calendar.DATE, dayNumber - 2);
            boolean sameDay = isSameDay(day, mToday);

            //如果需要的话，可以多做一些活动。我们想提前3个月储存这些活动。得到
            //事件仅当它是循环的第一次迭代时。
            if (mEventRects == null || mRefreshEvents || (dayNumber == leftDaysWithGaps + 1 && mFetchedMonths[1] != day.get(Calendar.MONTH) + 1 && day.get(Calendar.DAY_OF_MONTH) == 15)) {
                getMoreEvents(day);
                mRefreshEvents = false;
            }
            if (sameDay) {
                SimpleDateFormat weekdayNameFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
                String time = weekdayNameFormat.format(System.currentTimeMillis());
                Calendar now = Calendar.getInstance();
                now.setTimeInMillis(System.currentTimeMillis());
                float top = (mHourHeight * 24 / 1440) * (60 * now.get(Calendar.HOUR_OF_DAY) + now.get(Calendar.MINUTE)) + mTimeTextHeight + mCurrentOrigin.y ;
                Log.d(TAG, "drawTimeColumnAndAxes ===" + time);
                canvas.drawText(time, mTimeTextWidth + mHeaderColumnPadding, top, mCurrentTimeTextPaint);
                canvas.drawLine(startPixel, top, startPixel + mWidthPerDay, top, mCurrentTimeTextPaint);
            }


            // 为每一天画背景色。
            float start = (startPixel < mHeaderColumnWidth ? mHeaderColumnWidth : startPixel);
            if (mWidthPerDay + startPixel - start > 1)
                canvas.drawRect(start, mTimeTextHeight / 2 + mHeaderMarginBottom, startPixel + mWidthPerDay, getHeight(), sameDay ? mTodayBackgroundPaint : mDayBackgroundPaint);
            // 为时间绘制分隔线
            int i = 0;
            for (int hourNumber = 0; hourNumber < 24; hourNumber++) {
                float top = mCurrentOrigin.y + mHourHeight * hourNumber + mTimeTextHeight / 2 + mHeaderMarginBottom;
                if (top > 0 + mTimeTextHeight / 2 + mHeaderMarginBottom  &&
                        top < getHeight() && startPixel + mWidthPerDay - start > 0) {
                    hourLines[i * 4] = start;
                    hourLines[i * 4 + 1] = top;
                    hourLines[i * 4 + 2] = startPixel + mWidthPerDay;
                    hourLines[i * 4 + 3] = top;
                    i++;
                }
            }

            // 时间分割线
            canvas.drawLines(hourLines, mHourSeparatorPaint);

            // 绘制事件
            drawEvents(day, startPixel, canvas);

            // In the next iteration, start from the next day.
            startPixel += mWidthPerDay + mColumnGap;
        }

        // Draw the header background.
        canvas.drawRect(0, 0, getWidth(), mHeaderHeight+mHeaderTextHeight+80, mHeaderBackgroundPaint);

        // Draw the header row texts.
        startPixel = startFromPixel;
        for (int dayNumber = leftDaysWithGaps + 1; dayNumber <= leftDaysWithGaps + mNumberOfVisibleDays + 1; dayNumber++) {
            // Check if the day is today.
            day = (Calendar) mToday.clone();
            day.add(Calendar.DATE, dayNumber - 1);
            boolean sameDay = isSameDay(day, mToday);

            // 绘制日期
            String dayLabel = getDateTimeInterpreter().interpretDate(day);
            if (dayLabel == null)
                throw new IllegalStateException("A DateTimeInterpreter must not return null date");
            canvas.drawText(StringData(day), startPixel + mWidthPerDay / 2,mHeaderTextHeight+10, sameDay ? mTodayHeaderTextPaint : mHeaderTextPaint);

            canvas.drawText(dayLabel, startPixel + mWidthPerDay / 2, mHeaderTextHeight + mHeaderRowPadding +80, sameDay ? mTodayHeaderTextPaint : mHeaderTextPaint);
            float y =mHeaderTextHeight+30;

            Paint tmpP = new Paint();
            tmpP.setColor(Color.WHITE);
            canvas.drawLine(0, y, getWidth(), y, tmpP);// 画线
            startPixel += mWidthPerDay + mColumnGap;
        }

    }

    /**
     * 获取用户点击的时间和日期
     *
     * @param x The x position of the touch event.
     * @param y The y position of the touch event.
     * @return The time and date at the clicked position.
     */
    private Calendar getTimeFromPoint(float x, float y) {
        int leftDaysWithGaps = (int) -(Math.ceil(mCurrentOrigin.x / (mWidthPerDay + mColumnGap)));
        float startPixel = mCurrentOrigin.x + (mWidthPerDay + mColumnGap) * leftDaysWithGaps +
                mHeaderColumnWidth;
        for (int dayNumber = leftDaysWithGaps + 1;
             dayNumber <= leftDaysWithGaps + mNumberOfVisibleDays + 1;
             dayNumber++) {
            float start = (startPixel < mHeaderColumnWidth ? mHeaderColumnWidth : startPixel);
            if (mWidthPerDay + startPixel - start > 0
                    && x > start && x < startPixel + mWidthPerDay) {
                Calendar day = (Calendar) mToday.clone();
                day.add(Calendar.DATE, dayNumber - 1);
                float pixelsFromZero = y - mCurrentOrigin.y - mHeaderTextHeight
                        - mHeaderRowPadding * 2 - mTimeTextHeight / 2 - mHeaderMarginBottom;
                int hour = (int) (pixelsFromZero / mHourHeight);
                int minute = (int) (60 * (pixelsFromZero - hour * mHourHeight) / mHourHeight);
                day.add(Calendar.HOUR, hour);
                day.set(Calendar.MINUTE, minute);
                return day;
            }
            startPixel += mWidthPerDay + mColumnGap;
        }
        return null;
    }

    /**
     * 画出某一天的所有事件
     *
     * @param date           The day.
     * @param startFromPixel The left position of the day area. The events will never go any left from this value.
     * @param canvas         The canvas to draw upon.
     */
    private void drawEvents(Calendar date, float startFromPixel, Canvas canvas) {
        if (mEventRects != null && mEventRects.size() > 0) {
            for (int i = 0; i < mEventRects.size(); i++) {
                if (isSameDay(mEventRects.get(i).event.getStartTime(), date)) {

                    // Calculate top.
                    float top = mHourHeight * 24 * mEventRects.get(i).top / 1440 + mCurrentOrigin.y + 0 + mHeaderMarginBottom + mTimeTextHeight / 2 + mEventMarginVertical;
                    float originalTop = top;
                    if (top < 0 + mHeaderMarginBottom + mTimeTextHeight / 2)
                        top = 0 + mHeaderMarginBottom + mTimeTextHeight / 2;

                    // Calculate bottom.
                    float bottom = mEventRects.get(i).bottom;
                    bottom = mHourHeight * 24 * bottom / 1440 + mCurrentOrigin.y + 0 + mHeaderMarginBottom + mTimeTextHeight / 2 - mEventMarginVertical;

                    // Calculate left and right.
                    float left = startFromPixel + mEventRects.get(i).left * mWidthPerDay;
                    if (left < startFromPixel)
                        left += mOverlappingEventGap;
                    float originalLeft = left;
                    float right = left + mEventRects.get(i).width * mWidthPerDay;
                    if (right < startFromPixel + mWidthPerDay)
                        right -= mOverlappingEventGap;
                    if (left < mHeaderColumnWidth) left = mHeaderColumnWidth;

                    // Draw the event and the event name on top of it.
                    RectF eventRectF = new RectF(left, top, right, bottom);
                    if (bottom > 0 + mHeaderMarginBottom + mTimeTextHeight / 2 && left < right &&
                            eventRectF.right > mHeaderColumnWidth &&
                            eventRectF.left < getWidth() &&
                            eventRectF.bottom > 0 + mTimeTextHeight / 2 + mHeaderMarginBottom &&
                            eventRectF.top < getHeight() &&
                            left < right
                            ) {
                        mEventRects.get(i).rectF = eventRectF;
                        mEventBackgroundPaint.setColor(mEventRects.get(i).event.getColor() == 0 ? mDefaultEventColor : mEventRects.get(i).event.getColor());
                        canvas.drawRect(mEventRects.get(i).rectF, mEventBackgroundPaint);
                        drawText(mEventRects.get(i).event.getName(), mEventRects.get(i).rectF, canvas, originalTop, originalLeft);
                    } else
                        mEventRects.get(i).rectF = null;
                }
            }
        }
    }


    /**
     * 在事件矩形顶部绘制事件的名称。
     *
     * @param text         The text to draw.
     * @param rect         The rectangle on which the text is to be drawn.
     * @param canvas       The canvas to draw upon.
     * @param originalTop  The original top position of the rectangle. The rectangle may have some of its portion outside of the visible area.
     * @param originalLeft The original left position of the rectangle. The rectangle may have some of its portion outside of the visible area.
     */
    private void drawText(String text, RectF rect, Canvas canvas, float originalTop, float originalLeft) {
        if (rect.right - rect.left - mEventPadding * 2 < 0) return;

        // Get text dimensions
        StaticLayout textLayout = new StaticLayout(text, mEventTextPaint, (int) (rect.right - originalLeft - mEventPadding * 2), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);

        // Crop height
        int availableHeight = (int) (rect.bottom - originalTop - mEventPadding * 2);
        int lineHeight = textLayout.getHeight() / textLayout.getLineCount();
        if (lineHeight < availableHeight && textLayout.getHeight() > rect.height() - mEventPadding * 2) {
            int lineCount = textLayout.getLineCount();
            int availableLineCount = (int) Math.floor(lineCount * availableHeight / textLayout.getHeight());
            float widthAvailable = (rect.right - originalLeft - mEventPadding * 2) * availableLineCount;
            textLayout = new StaticLayout(TextUtils.ellipsize(text, mEventTextPaint, widthAvailable, TextUtils.TruncateAt.END), mEventTextPaint, (int) (rect.right - originalLeft - mEventPadding * 2), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        } else if (lineHeight >= availableHeight) {
            int width = (int) (rect.right - originalLeft - mEventPadding * 2);
            textLayout = new StaticLayout(TextUtils.ellipsize(text, mEventTextPaint, width, TextUtils.TruncateAt.END), mEventTextPaint, width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, false);
        }

        // Draw text
        canvas.save();
        canvas.translate(originalLeft + mEventPadding, originalTop + mEventPadding);
        textLayout.draw(canvas);
        canvas.restore();
    }


    /**
     * 一个类来保存对事件及其可视化表示的引用。一个EventRect
     * 实际上是在给定事件的日历上绘制的矩形。可能会有更多的
     * 单个事件的矩形(扩展超过一天的事件)。在那
     * 事件rect的两个实例将用于单个事件。给定的事件将是
     * 存储在“originalEvent”。但是对应矩形的事件
     * 实例将存储在“事件”中。
     */
    private class EventRect {
        public WeekViewEvent event;
        public WeekViewEvent originalEvent;
        public RectF rectF;
        public float left;
        public float width;
        public float top;
        public float bottom;

        /**
         * Create a new instance of event rect. An EventRect is actually the rectangle that is drawn
         * on the calendar for a given event. There may be more than one rectangle for a single
         * event (an event that expands more than one day). In that case two instances of the
         * EventRect will be used for a single event. The given event will be stored in
         * "originalEvent". But the event that corresponds to rectangle the rectangle instance will
         * be stored in "event".
         *
         * @param event         Represents the event which this instance of rectangle represents.
         * @param originalEvent The original event that was passed by the user.
         * @param rectF         The rectangle.
         */
        public EventRect(WeekViewEvent event, WeekViewEvent originalEvent, RectF rectF) {
            this.event = event;
            this.rectF = rectF;
            this.originalEvent = originalEvent;
        }
    }


    /**
     * 如有需要，将有更多一个月的活动。这个方法在用户的时候被调用
     * 滚动一周视图。每周查看三个月的事件:可见的月份，
     * 前一个月，下个月。
     *
     * @param day The day where the user is currently is.
     */
    private void getMoreEvents(Calendar day) {

        // Delete all events if its not current month +- 1.
        deleteFarMonths(day);

        // Get more events if the month is changed.
        if (mEventRects == null)
            mEventRects = new ArrayList<EventRect>();
        if (mMonthChangeListener == null && !isInEditMode())
            throw new IllegalStateException("You must provide a MonthChangeListener");

        // If a refresh was requested then reset some variables.
        if (mRefreshEvents) {
            mEventRects.clear();
            mFetchedMonths = new int[3];
        }

        // Get events of previous month.
        /*int previousMonth = (day.get(Calendar.MONTH) == 0 ? 12 : day.get(Calendar.MONTH));
        int nextMonth = (day.get(Calendar.MONTH) + 2 == 13 ? 1 : day.get(Calendar.MONTH) + 2);*/
        int[] lastFetchedMonth = mFetchedMonths.clone();
        /*if (mFetchedMonths[0] < 1 || mFetchedMonths[0] != previousMonth || mRefreshEvents) {
            if (!containsValue(lastFetchedMonth, previousMonth) && !isInEditMode()) {
                List<WeekViewEvent> events = mMonthChangeListener.onMonthChange((previousMonth == 12) ? day.get(Calendar.YEAR) - 1 : day.get(Calendar.YEAR), previousMonth);
                sortEvents(events);
                for (WeekViewEvent event : events) {
                    cacheEvent(event);
                }
            }
            mFetchedMonths[0] = previousMonth;
        }*/

        // Get events of this month.
        if (mFetchedMonths[1] < 1 || mFetchedMonths[1] != day.get(Calendar.MONTH) + 1 || mRefreshEvents) {
            if (!containsValue(lastFetchedMonth, day.get(Calendar.MONTH) + 1) && !isInEditMode()) {
                List<WeekViewEvent> events = mMonthChangeListener.onMonthChange(day.get(Calendar.YEAR), day.get(Calendar.MONTH) + 1);
                sortEvents(events);
                for (WeekViewEvent event : events) {
                    cacheEvent(event);
                }
            }
            mFetchedMonths[1] = day.get(Calendar.MONTH) + 1;
        }

        // Get events of next month.
        /*if (mFetchedMonths[2] < 1 || mFetchedMonths[2] != nextMonth || mRefreshEvents) {
            if (!containsValue(lastFetchedMonth, nextMonth) && !isInEditMode()) {
                List<WeekViewEvent> events = mMonthChangeListener.onMonthChange(nextMonth == 1 ? day.get(Calendar.YEAR) + 1 : day.get(Calendar.YEAR), nextMonth);
                sortEvents(events);
                for (WeekViewEvent event : events) {
                    cacheEvent(event);
                }
            }
            mFetchedMonths[2] = nextMonth;
        }*/

        // Prepare to calculate positions of each events.
        ArrayList<EventRect> tempEvents = new ArrayList<EventRect>(mEventRects);
        mEventRects = new ArrayList<EventRect>();
        Calendar dayCounter = (Calendar) day.clone();
        dayCounter.add(Calendar.MONTH, -1);
        dayCounter.set(Calendar.DAY_OF_MONTH, 1);
        Calendar maxDay = (Calendar) day.clone();
        maxDay.add(Calendar.MONTH, 1);
        maxDay.set(Calendar.DAY_OF_MONTH, maxDay.getActualMaximum(Calendar.DAY_OF_MONTH));

        // Iterate through each day to calculate the position of the events.
        while (dayCounter.getTimeInMillis() <= maxDay.getTimeInMillis()) {
            ArrayList<EventRect> eventRects = new ArrayList<EventRect>();
            for (EventRect eventRect : tempEvents) {
                if (isSameDay(eventRect.event.getStartTime(), dayCounter))
                    eventRects.add(eventRect);
            }

            computePositionOfEvents(eventRects);
            dayCounter.add(Calendar.DATE, 1);
        }
    }

    /**
     * 缓存该事件以实现平滑滚动功能。
     *
     * @param event The event to cache.
     */
    private void cacheEvent(WeekViewEvent event) {
        if (!isSameDay(event.getStartTime(), event.getEndTime())) {
            Calendar endTime = (Calendar) event.getStartTime().clone();
            endTime.set(Calendar.HOUR_OF_DAY, 23);
            endTime.set(Calendar.MINUTE, 59);
            Calendar startTime = (Calendar) event.getEndTime().clone();
            startTime.set(Calendar.HOUR_OF_DAY, 0);
            startTime.set(Calendar.MINUTE, 0);
            WeekViewEvent event1 = new WeekViewEvent(event.getId(), event.getName(), event.getStartTime(), endTime);
            event1.setColor(event.getColor());
            WeekViewEvent event2 = new WeekViewEvent(event.getId(), event.getName(), startTime, event.getEndTime());
            event2.setColor(event.getColor());
            mEventRects.add(new EventRect(event1, event, null));
            mEventRects.add(new EventRect(event2, event, null));
        } else
            mEventRects.add(new EventRect(event, event, null));
    }

    /**
     * 按升序排序事件。
     *
     * @param events The events to be sorted.
     */
    private void sortEvents(List<WeekViewEvent> events) {
        Collections.sort(events, new Comparator<WeekViewEvent>() {
            @Override
            public int compare(WeekViewEvent event1, WeekViewEvent event2) {
                long start1 = event1.getStartTime().getTimeInMillis();
                long start2 = event2.getStartTime().getTimeInMillis();
                int comparator = start1 > start2 ? 1 : (start1 < start2 ? -1 : 0);
                if (comparator == 0) {
                    long end1 = event1.getEndTime().getTimeInMillis();
                    long end2 = event2.getEndTime().getTimeInMillis();
                    comparator = end1 > end2 ? 1 : (end1 < end2 ? -1 : 0);
                }
                return comparator;
            }
        });
    }

    /**
     * 计算每个事件的左右位置。如果发生了特殊情况
     * 是重叠的。
     *
     * @param eventRects The events along with their wrapper class.
     */
    private void computePositionOfEvents(List<EventRect> eventRects) {
        // Make "collision groups" for all events that collide with others.
        List<List<EventRect>> collisionGroups = new ArrayList<List<EventRect>>();
        for (EventRect eventRect : eventRects) {
            boolean isPlaced = false;
            outerLoop:
            for (List<EventRect> collisionGroup : collisionGroups) {
                for (EventRect groupEvent : collisionGroup) {
                    if (isEventsCollide(groupEvent.event, eventRect.event)) {
                        collisionGroup.add(eventRect);
                        isPlaced = true;
                        break outerLoop;
                    }
                }
            }
            if (!isPlaced) {
                List<EventRect> newGroup = new ArrayList<EventRect>();
                newGroup.add(eventRect);
                collisionGroups.add(newGroup);
            }
        }

        for (List<EventRect> collisionGroup : collisionGroups) {
            expandEventsToMaxWidth(collisionGroup);
        }
    }

    /**
     * 将所有事件扩展到最大可能的宽度。这些事件将试图占据最大的地位
     * 水平可用空间。
     *
     * @param collisionGroup The group of events which overlap with each other.
     */
    private void expandEventsToMaxWidth(List<EventRect> collisionGroup) {
        // Expand the events to maximum possible width.
        List<List<EventRect>> columns = new ArrayList<List<EventRect>>();
        columns.add(new ArrayList<EventRect>());
        for (EventRect eventRect : collisionGroup) {
            boolean isPlaced = false;
            for (List<EventRect> column : columns) {
                if (column.size() == 0) {
                    column.add(eventRect);
                    isPlaced = true;
                } else if (!isEventsCollide(eventRect.event, column.get(column.size() - 1).event)) {
                    column.add(eventRect);
                    isPlaced = true;
                    break;
                }
            }
            if (!isPlaced) {
                List<EventRect> newColumn = new ArrayList<EventRect>();
                newColumn.add(eventRect);
                columns.add(newColumn);
            }
        }


        // 计算所有事件的左右位置。
        // 通过查找所有列来获得maxRowCount。
        int maxRowCount = 0;
        for (List<EventRect> column : columns) {
            maxRowCount = Math.max(maxRowCount, column.size());
        }
        for (int i = 0; i < maxRowCount; i++) {
            // Set the left and right values of the event.
            float j = 0;
            for (List<EventRect> column : columns) {
                if (column.size() >= i + 1) {
                    EventRect eventRect = column.get(i);
                    eventRect.width = 1f / columns.size();
                    eventRect.left = j / columns.size();
                    eventRect.top = eventRect.event.getStartTime().get(Calendar.HOUR_OF_DAY) * 60 + eventRect.event.getStartTime().get(Calendar.MINUTE);
                    eventRect.bottom = eventRect.event.getEndTime().get(Calendar.HOUR_OF_DAY) * 60 + eventRect.event.getEndTime().get(Calendar.MINUTE);
                    mEventRects.add(eventRect);
                }
                j++;
            }
        }
    }


    /**
     * 检查两个事件是否重叠。
     *
     * @param event1 The first event.
     * @param event2 The second event.
     * @return true if the events overlap.
     */
    private boolean isEventsCollide(WeekViewEvent event1, WeekViewEvent event2) {
        long start1 = event1.getStartTime().getTimeInMillis();
        long end1 = event1.getEndTime().getTimeInMillis();
        long start2 = event2.getStartTime().getTimeInMillis();
        long end2 = event2.getEndTime().getTimeInMillis();
        return !((start1 >= end2) || (end1 <= start2));
    }


    /**
     * 检查time1是否发生在(或同时)time2之后。
     *
     * @param time1 The time to check.
     * @param time2 The time to check against.
     * @return true if time1 and time2 are equal or if time1 is after time2. Otherwise false.
     */
    private boolean isTimeAfterOrEquals(Calendar time1, Calendar time2) {
        return !(time1 == null || time2 == null) && time1.getTimeInMillis() >= time2.getTimeInMillis();
    }

    /**
     * 删除离当前月份太远的几个月的事件。
     *
     * @param currentDay The current day.
     */
    private void deleteFarMonths(Calendar currentDay) {

        if (mEventRects == null) return;

        Calendar nextMonth = (Calendar) currentDay.clone();
        nextMonth.add(Calendar.MONTH, 1);
        nextMonth.set(Calendar.DAY_OF_MONTH, nextMonth.getActualMaximum(Calendar.DAY_OF_MONTH));
        nextMonth.set(Calendar.HOUR_OF_DAY, 12);
        nextMonth.set(Calendar.MINUTE, 59);
        nextMonth.set(Calendar.SECOND, 59);

        Calendar prevMonth = (Calendar) currentDay.clone();
        prevMonth.add(Calendar.MONTH, -1);
        prevMonth.set(Calendar.DAY_OF_MONTH, 1);
        prevMonth.set(Calendar.HOUR_OF_DAY, 0);
        prevMonth.set(Calendar.MINUTE, 0);
        prevMonth.set(Calendar.SECOND, 0);

        List<EventRect> newEvents = new ArrayList<EventRect>();
        for (EventRect eventRect : mEventRects) {
            boolean isFarMonth = eventRect.event.getStartTime().getTimeInMillis() > nextMonth.getTimeInMillis() || eventRect.event.getEndTime().getTimeInMillis() < prevMonth.getTimeInMillis();
            if (!isFarMonth) newEvents.add(eventRect);
        }
        mEventRects.clear();
        mEventRects.addAll(newEvents);
    }

    @Override
    public void invalidate() {
        super.invalidate();
        mAreDimensionsInvalid = true;
    }

    /////////////////////////////////////////////////////////////////
    //
    //      Functions related to setting and getting the properties.
    //
    /////////////////////////////////////////////////////////////////

    public void setOnEventClickListener(EventClickListener listener) {
        this.mEventClickListener = listener;
    }

    public EventClickListener getEventClickListener() {
        return mEventClickListener;
    }

    public MonthChangeListener getMonthChangeListener() {
        return mMonthChangeListener;
    }

    public void setMonthChangeListener(MonthChangeListener monthChangeListener) {
        this.mMonthChangeListener = monthChangeListener;
    }

    public EventLongPressListener getEventLongPressListener() {
        return mEventLongPressListener;
    }

    public void setEventLongPressListener(EventLongPressListener eventLongPressListener) {
        this.mEventLongPressListener = eventLongPressListener;
    }

    public void setEmptyViewClickListener(EmptyViewClickListener emptyViewClickListener) {
        this.mEmptyViewClickListener = emptyViewClickListener;
    }

    public EmptyViewClickListener getEmptyViewClickListener() {
        return mEmptyViewClickListener;
    }

    public void setEmptyViewLongPressListener(EmptyViewLongPressListener emptyViewLongPressListener) {
        this.mEmptyViewLongPressListener = emptyViewLongPressListener;
    }

    public EmptyViewLongPressListener getEmptyViewLongPressListener() {
        return mEmptyViewLongPressListener;
    }

    public void setScrollListener(ScrollListener scrolledListener) {
        this.mScrollListener = scrolledListener;
    }

    public ScrollListener getScrollListener() {
        return mScrollListener;
    }

    /**
     * 获取提供文本的解释器，以显示在标题列和标题行。
     *
     * @return The date, time interpreter.
     */
    public DateTimeInterpreter getDateTimeInterpreter() {
        if (mDateTimeInterpreter == null) {
            mDateTimeInterpreter = new DateTimeInterpreter() {
                @Override
                public String interpretDate(Calendar date) {
                    SimpleDateFormat sdf;
                    sdf = mDayNameLength == LENGTH_SHORT ? new SimpleDateFormat("EEE") : new SimpleDateFormat("EEE");
                    try {
                        String dayName = sdf.format(date.getTime()).toUpperCase();
//                        return String.format("%s %d/%02d", dayName, date.get(Calendar.MONTH) + 1, date.get(Calendar.DAY_OF_MONTH));
                        return String.format("%02d", date.get(Calendar.DAY_OF_MONTH));
                    } catch (Exception e) {
                        e.printStackTrace();
                        return "";
                    }
                }

                @Override
                public String interpretTime(int hour) {
                    String amPm;
                    if (hour >= 0 && hour < 12) amPm = "AM";
                    else amPm = "PM";
                    if (hour == 0) hour = 12;
                    if (hour > 12) hour -= 12;
                    return String.format("%02d %s", hour, amPm);
                }

                @Override
                public String interpretWeek(int date) {
                    return null;
                }
            };
        }
        return mDateTimeInterpreter;
    }

    /**
     * Set the interpreter which provides the text to show in the header column and the header row.
     *
     * @param dateTimeInterpreter The date, time interpreter.
     */
    public void setDateTimeInterpreter(DateTimeInterpreter dateTimeInterpreter) {
        this.mDateTimeInterpreter = dateTimeInterpreter;
    }


    /**
     * 一周内获得可见的天数。
     *
     * @return The number of visible days in a week.
     */
    public int getNumberOfVisibleDays() {
        return mNumberOfVisibleDays;
    }

    /**
     * Set the number of visible days in a week.
     *
     * @param numberOfVisibleDays The number of visible days in a week.
     */
    public void setNumberOfVisibleDays(int numberOfVisibleDays) {
        this.mNumberOfVisibleDays = numberOfVisibleDays;
        mCurrentOrigin.x = 0;
        mCurrentOrigin.y = 0;
        invalidate();
    }

    public int getHourHeight() {
        return mHourHeight;
    }

    public void setHourHeight(int hourHeight) {
        mHourHeight = hourHeight;
        invalidate();
    }

    public int getColumnGap() {
        return mColumnGap;
    }

    public void setColumnGap(int columnGap) {
        mColumnGap = columnGap;
        invalidate();
    }

    public int getFirstDayOfWeek() {
        return mFirstDayOfWeek;
    }

    /**
     * 设定一周的第一天。一周的第一天只在一周的时候使用
     * 在用户开始水平滚动后，它没有任何效果。
     * <p>
     * <b>Note:</b> This method will only work if the week view is set to display more than 6 days at
     * once.
     * </p>
     *
     * @param firstDayOfWeek The supported values are {@link Calendar#SUNDAY},
     *                       {@link Calendar#MONDAY}, {@link Calendar#TUESDAY},
     *                       {@link Calendar#WEDNESDAY}, {@link Calendar#THURSDAY},
     *                       {@link Calendar#FRIDAY}.
     */
    public void setFirstDayOfWeek(int firstDayOfWeek) {
        mFirstDayOfWeek = firstDayOfWeek;
        invalidate();
    }

    public int getTextSize() {
        return mTextSize;
    }

    public void setTextSize(int textSize) {
        mTextSize = textSize;
        mTodayHeaderTextPaint.setTextSize(mTextSize);
        mHeaderTextPaint.setTextSize(mTextSize);
        mTimeTextPaint.setTextSize(mTextSize);
        invalidate();
    }

    public int getHeaderColumnPadding() {
        return mHeaderColumnPadding;
    }

    public void setHeaderColumnPadding(int headerColumnPadding) {
        mHeaderColumnPadding = headerColumnPadding;
        invalidate();
    }

    public int getHeaderColumnTextColor() {
        return mHeaderColumnTextColor;
    }

    public void setHeaderColumnTextColor(int headerColumnTextColor) {
        mHeaderColumnTextColor = headerColumnTextColor;
        invalidate();
    }

    public int getHeaderRowPadding() {
        return mHeaderRowPadding;
    }

    public void setHeaderRowPadding(int headerRowPadding) {
        mHeaderRowPadding = headerRowPadding;
        invalidate();
    }

    public int getHeaderRowBackgroundColor() {
        return mHeaderRowBackgroundColor;
    }

    public void setHeaderRowBackgroundColor(int headerRowBackgroundColor) {
        mHeaderRowBackgroundColor = headerRowBackgroundColor;
        invalidate();
    }

    public int getDayBackgroundColor() {
        return mDayBackgroundColor;
    }

    public void setDayBackgroundColor(int dayBackgroundColor) {
        mDayBackgroundColor = dayBackgroundColor;
        invalidate();
    }

    public int getHourSeparatorColor() {
        return mHourSeparatorColor;
    }

    public void setHourSeparatorColor(int hourSeparatorColor) {
        mHourSeparatorColor = hourSeparatorColor;
        invalidate();
    }

    public int getTodayBackgroundColor() {
        return mTodayBackgroundColor;
    }

    public void setTodayBackgroundColor(int todayBackgroundColor) {
        mTodayBackgroundColor = todayBackgroundColor;
        invalidate();
    }

    public int getHourSeparatorHeight() {
        return mHourSeparatorHeight;
    }

    public void setHourSeparatorHeight(int hourSeparatorHeight) {
        mHourSeparatorHeight = hourSeparatorHeight;
        invalidate();
    }

    public int getTodayHeaderTextColor() {
        return mTodayHeaderTextColor;
    }

    public void setTodayHeaderTextColor(int todayHeaderTextColor) {
        mTodayHeaderTextColor = todayHeaderTextColor;
        invalidate();
    }

    public int getEventTextSize() {
        return mEventTextSize;
    }

    public void setEventTextSize(int eventTextSize) {
        mEventTextSize = eventTextSize;
        mEventTextPaint.setTextSize(mEventTextSize);
        invalidate();
    }

    public int getEventTextColor() {
        return mEventTextColor;
    }

    public void setEventTextColor(int eventTextColor) {
        mEventTextColor = eventTextColor;
        invalidate();
    }

    public int getEventPadding() {
        return mEventPadding;
    }

    public void setEventPadding(int eventPadding) {
        mEventPadding = eventPadding;
        invalidate();
    }

    public int getHeaderColumnBackgroundColor() {
        return mHeaderColumnBackgroundColor;
    }

    public void setHeaderColumnBackgroundColor(int headerColumnBackgroundColor) {
        mHeaderColumnBackgroundColor = headerColumnBackgroundColor;
        invalidate();
    }

    public int getDefaultEventColor() {
        return mDefaultEventColor;
    }

    public void setDefaultEventColor(int defaultEventColor) {
        mDefaultEventColor = defaultEventColor;
        invalidate();
    }

    /**
     * <b>Note:</b> Use {@link #setDateTimeInterpreter(DateTimeInterpreter)} and
     * {@link #getDateTimeInterpreter()} instead.
     *
     * @return Either long or short day name is being used.
     */
    @Deprecated
    public int getDayNameLength() {
        return mDayNameLength;
    }

    /**
     * 设置在标题行中显示的日名称的长度。短日期名称的例子是
     * ‘星期一’和长长的名字的例子是‘星期一’。
     * <p>
     * <b>Note:</b> Use {@link #setDateTimeInterpreter(DateTimeInterpreter)} instead.
     * </p>
     *
     * @param length Supported values are {@link WeekDView#LENGTH_SHORT} and
     *               {@link WeekDView#LENGTH_LONG}.
     */
    @Deprecated
    public void setDayNameLength(int length) {
        if (length != LENGTH_LONG && length != LENGTH_SHORT) {
            throw new IllegalArgumentException("length parameter must be either LENGTH_LONG or LENGTH_SHORT");
        }
        this.mDayNameLength = length;
    }

    public int getOverlappingEventGap() {
        return mOverlappingEventGap;
    }

    /**
     * 设置重叠事件之间的间隙。
     *
     * @param overlappingEventGap The gap between overlapping events.
     */
    public void setOverlappingEventGap(int overlappingEventGap) {
        this.mOverlappingEventGap = overlappingEventGap;
        invalidate();
    }

    public int getEventMarginVertical() {
        return mEventMarginVertical;
    }

    /**
     * 设置事件的顶部和底部边缘。事件将从顶部释放这个边缘
     * 和底部边缘。这个边距对于连续的事件是有用的。
     *
     * @param eventMarginVertical The top and bottom margin.
     */
    public void setEventMarginVertical(int eventMarginVertical) {
        this.mEventMarginVertical = eventMarginVertical;
        invalidate();
    }

    /**
     * Returns the first visible day in the week view.
     *
     * @return The first visible day in the week view.
     */
    public Calendar getFirstVisibleDay() {
        return mFirstVisibleDay;
    }

    /**
     * Returns the last visible day in the week view.
     *
     * @return The last visible day in the week view.
     */
    public Calendar getLastVisibleDay() {
        return mLastVisibleDay;
    }

    /**
     * 滚动水平方向速度的系数。
     *
     * @return The speed factor in horizontal direction.
     */
    public float getXScrollingSpeed() {
        return mXScrollingSpeed;
    }

    /**
     * 设置水平滚动的速度。
     *
     * @param xScrollingSpeed The new horizontal scrolling speed.
     */
    public void setXScrollingSpeed(float xScrollingSpeed) {
        this.mXScrollingSpeed = xScrollingSpeed;
    }
    /////////////////////////////////////////////////////////////////
    //
    //     有关滚动功能。
    //
    /////////////////////////////////////////////////////////////////

    /**
     * 触摸事件
     */

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {

            if (mCurrentScrollDirection == Direction.HORIZONTAL) {
                float leftDays = Math.round(mCurrentOrigin.x / (mWidthPerDay + mColumnGap));

//                if (mFling){
//                    leftDays-=7;
//                }else{
//
//                    leftDays+=7;
//
//                }
//                float leftDays = Math.round(mCurrentOrigin.x /(mWidthPerDay + mColumnGap))+9;

                Log.e("----------^^^^", leftDays + "");
                int nearestOrigin = (int) (mCurrentOrigin.x - leftDays * (mWidthPerDay + mColumnGap));
//                int nearestOrigin = (int) (mCurrentOrigin.x -  leftDays * (mWidthPerDay + mColumnGap));
                mStickyScroller.startScroll((int) mCurrentOrigin.x, 0, -nearestOrigin, 0);
                ViewCompat.postInvalidateOnAnimation(WeekDView.this);
            }
            int leftDays = Math.round(mStickyScroller.getFinalX() / (mWidthPerDay + mColumnGap));
            mSelectedDate = (Calendar) mToday.clone();
            mSelectedDate.add(Calendar.DATE, -leftDays);
            if (mSelectedDate.get(Calendar.DAY_OF_YEAR) != mLastSelectedDate.get(Calendar.DAY_OF_YEAR)) {
                mScrollListener.onSelectedDaeChange(mSelectedDate);
            }
            mCurrentScrollDirection = Direction.NONE;
        }
        return mGestureDetector.onTouchEvent(event);
    }


    /**
     * 计算滚动
     */
    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
//
//            if (Math.abs(mScroller.getFinalX() - mScroller.getCurrX()) < mWidthPerDay + mColumnGap && Math.abs(mScroller.getFinalX() - mScroller.getStartX()) != 0) {
            if (Math.abs(mScroller.getFinalX() - mScroller.getStartX()) != 0) {
                mScroller.forceFinished(true);
                float leftDays = Math.round(mCurrentOrigin.x / (mWidthPerDay + mColumnGap));
//                if (mScroller.getFinalX() < mScroller.getCurrX()){
//                 Log.e("++~~~~~~~~------>>", leftDays+ "");
//                    leftDays-=7;
//                }
//                else {
////
//                    Log.e("--~~~~~~~~------>>", leftDays+ "");
//                    leftDays+=7;
//                }

                int nearestOrigin = (int) (mCurrentOrigin.x - leftDays * (mWidthPerDay + mColumnGap));

                mStickyScroller.startScroll((int) mCurrentOrigin.x, 0, -nearestOrigin, 0);
                ViewCompat.postInvalidateOnAnimation(WeekDView.this);
            } else {


                if (mCurrentFlingDirection == Direction.VERTICAL)
                    mCurrentOrigin.y = mScroller.getCurrY();
                else mCurrentOrigin.x = mScroller.getCurrX();
                ViewCompat.postInvalidateOnAnimation(this);//刷新界面


            }
        }
//        if (mStickyScroller.computeScrollOffset()) {
//            mCurrentOrigin.x = mStickyScroller.getCurrX();
//            ViewCompat.postInvalidateOnAnimation(this);
//        }
    }


    /////////////////////////////////////////////////////////////////
    //
    //     公共方法。
    //
    /////////////////////////////////////////////////////////////////

    /**
     * 显示今天在视图
     */
    public void goToToday() {
        Calendar today = Calendar.getInstance();
        goToDate(today);
    }

    /**
     * 显示特定的日期
     *
     * @param date The date to show.
     */
    public void goToDate(Calendar date) {
        mScroller.forceFinished(true);
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);

        if (mAreDimensionsInvalid) {
            mScrollToDay = date;
            return;
        }

        mRefreshEvents = true;

        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);

        long dateInMillis = date.getTimeInMillis() + date.getTimeZone().getOffset(date.getTimeInMillis());
        long todayInMillis = today.getTimeInMillis() + today.getTimeZone().getOffset(today.getTimeInMillis());
        int dateDifference = (int) ((dateInMillis - todayInMillis) / (1000 * 60 * 60 * 24));

        mCurrentOrigin.x = -dateDifference * (mWidthPerDay + mColumnGap);
        // mStickyScroller.startScroll((int) mCurrentOrigin.x, 0, (int) (-dateDifference*(mWidthPerDay + mColumnGap)-mCurrentOrigin.x), 0);
        invalidate();
    }

    /**
     * 刷新视图并再次加载事件。
     */
    public void notifyDatasetChanged() {
        mRefreshEvents = true;
        invalidate();
    }

    /**
     * 垂直滚动到一个特定的时间，周视图。
     *
     * @param hour The hour to scroll to in 24-hour format. Supported values are 0-24.
     */
    public void goToHour(double hour) {
        int verticalOffset = (int) (mHourHeight * hour);
        if (hour < 0)
            verticalOffset = 0;
        else if (hour > 24)
            verticalOffset = mHourHeight * 24;

        if (mAreDimensionsInvalid) {
            mScrollToHour = hour;
            return;
        } else if (verticalOffset > mHourHeight * 24 - getHeight() + 0 + mHeaderMarginBottom)
            verticalOffset = (int) (mHourHeight * 24 - getHeight() + 0 + mHeaderMarginBottom);

        mCurrentOrigin.y = -verticalOffset;
        invalidate();
    }

    /**
     * 显示第一个小时
     *
     * @return The first hour that is visible.
     */
    public double getFirstVisibleHour() {
        return -mCurrentOrigin.y / mHourHeight;
    }


    /////////////////////////////////////////////////////////////////
    //
    //      接口
    //
    /////////////////////////////////////////////////////////////////

    public interface EventClickListener {
        public void onEventClick(WeekViewEvent event, RectF eventRect);
    }

    public interface MonthChangeListener {
        public List<WeekViewEvent> onMonthChange(int newYear, int newMonth);
    }

    public interface EventLongPressListener {
        public void onEventLongPress(WeekViewEvent event, RectF eventRect);
    }

    public interface EmptyViewClickListener {
        public void onEmptyViewClicked(Calendar time);
    }

    public interface EmptyViewLongPressListener {
        public void onEmptyViewLongPress(Calendar time);
    }

    public interface ScrollListener {
        /**
         * 当第一个显示的日期发生改变
         * <p/>
         * (this will also be called during the first draw of the weekview)
         *
         * @param newFirstVisibleDay The new first visible day
         * @param oldFirstVisibleDay The old first visible day (is null on the first call).
         */
        public void onFirstVisibleDayChanged(Calendar newFirstVisibleDay, Calendar oldFirstVisibleDay);

        public void onSelectedDaeChange(Calendar selectedDate);
    }


    /////////////////////////////////////////////////////////////////
    //
    //     帮助
    //
    /////////////////////////////////////////////////////////////////

    /**
     * 检查整数数组是否包含一个特定值。
     *
     * @param list  The haystack.
     * @param value The needle.
     * @return True if the array contains the value. Otherwise returns false.
     */
    private boolean containsValue(int[] list, int value) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == value)
                return true;
        }
        return false;
    }

    /**
     * 检查两个时间是否在同一天。
     *
     * @param dayOne The first day.
     * @param dayTwo The second day.
     * @return Whether the times are on the same day.
     */
    private boolean isSameDay(Calendar dayOne, Calendar dayTwo) {
        return dayOne.get(Calendar.YEAR) == dayTwo.get(Calendar.YEAR) && dayOne.get(Calendar.DAY_OF_YEAR) == dayTwo.get(Calendar.DAY_OF_YEAR);
    }


    /**
     * @param date
     * @return
     */
    public static String StringData(Calendar date) {


        String mYear;
        String mMonth;
        String mDay;
        String mWay;
//        final Calendar c = Calendar.getInstance();
//        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        mYear = String.valueOf(date.get(Calendar.YEAR)); // 获取当前年份
        mMonth = String.valueOf(date.get(Calendar.MONTH) + 1);// 获取当前月份
        mDay = String.valueOf(date.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
        mWay = String.valueOf(date.get(Calendar.DAY_OF_WEEK));
        if ("1".equals(mWay)) {
            mWay = "日";
        } else if ("2".equals(mWay)) {
            mWay = "一";
        } else if ("3".equals(mWay)) {
            mWay = "二";
        } else if ("4".equals(mWay)) {
            mWay = "三";
        } else if ("5".equals(mWay)) {
            mWay = "四";
        } else if ("6".equals(mWay)) {
            mWay = "五";
        } else if ("7".equals(mWay)) {
            mWay = "六";
        }
        return mWay;
    }


}