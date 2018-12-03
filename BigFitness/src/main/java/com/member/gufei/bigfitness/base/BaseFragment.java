package com.member.gufei.bigfitness.base;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.member.gufei.bigfitness.App;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.com.GuFei.Component.DaggerFragmentComponent;
import com.member.gufei.bigfitness.com.GuFei.Component.FragmentComponent;
import com.member.gufei.bigfitness.com.GuFei.Moudel.FragmentModule;
import com.member.gufei.bigfitness.util.DownTimerUtil.DownTimerEndInterface;
import com.member.gufei.bigfitness.util.FloatTips;

import com.member.gufei.bigfitness.util.PermissionHelper;
import com.member.gufei.bigfitness.util.SpUtil;
import com.member.gufei.bigfitness.util.ToastUtil;

import java.lang.reflect.Field;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.member.gufei.bigfitness.App.SCREEN_WIDTH;
import static com.member.gufei.bigfitness.Constants.ACCOUNTKEY;

import static com.member.gufei.bigfitness.Constants.DEVICECODEKEY;

import static com.member.gufei.bigfitness.Constants.PASSWRODKEY;

import static com.member.gufei.bigfitness.Constants.SEXKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;



/**
 * @author GuFei
 * @version 2016 10 04 9:36
 *          Fragment基类
 *          与Activity的基础功能相同  用于Fragment
 */
public abstract class BaseFragment<T extends BasePresenter> extends android.support.v4.app.Fragment implements BaseView {

    @Inject
    protected T mPresenter;
    protected View mView;
    protected Activity mActivity;
    protected Context mContext;
    private Unbinder mUnBinder;
    protected int REQUEST_CODE;  //扫描回调接收标识
    //    protected static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;  //系统权限标识
    protected PermissionHelper mHelper = new PermissionHelper(this);//系统权限申请类
    protected View contentView;
    protected PopupWindow popupWindow;
    protected FloatTips floatTips;
    private boolean show = false;
    public static int OVERLAY_PERMISSION_REQ_CODE = 1234;
    private String mMin;
    private String NameLesson;
    private String NameTeacher;


    /**
     * Fragment当前状态是否可见
     */
    protected boolean isVisible = false;
    /**
     * Fragment的view是否已创建
     */
    protected boolean mIsViewCreated = false;
    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
    }

    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), null);
        initInject();

        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);
        mUnBinder = ButterKnife.bind(this, view);
        floatTips = new FloatTips(App.context);
        floatTips.setDownTimerEndInterface(new DownTimerEndInterface() {
            @Override
            public void endTime() {
                LessonPopup(mView, NameLesson, NameTeacher);
            }
        });

        if (savedInstanceState == null) {
            initData();
        }
        mIsViewCreated = true;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (isAdded() && !isHidden()) {//用isVisible此时为false，因为mView.getWindowToken为null
            onVisible();
            isVisible = true;
        }
    }
    protected void onVisible() {

    }

    /**
     * fragment不可见的时候操作,onPause的时候,以及不可见的时候调用
     */
    protected void onHidden() {

    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!mIsViewCreated)//view没有创建的时候不进行操作
            return;

        if (getUserVisibleHint()) {
            if (!isVisible) {//确保在一个可见周期中只调用一次onVisible()
                isVisible = true;
                onVisible();
            }
        } else {
            if (isVisible) {
                isVisible = false;
                onHidden();
            }
        }
    }
    @Override
    public void onPause() {

        if (isVisible()||isVisible) {
            onHidden();
            isVisible = false;
        }
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnBinder.unbind();
        mIsViewCreated = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
    }

    protected abstract void initInject();

    protected abstract int getLayoutId();

    protected abstract void initData();

    @Override
    public void showError(String msg) {
        ToastUtil.s(mContext, msg);
    }

    public void remove() {

//        SpUtil.remove(mContext, ACCOUNTKEY);
//        SpUtil.remove(mContext, PASSWRODKEY);
//        SpUtil.remove(mContext, DEVICECODEKEY);
//        SpUtil.remove(mContext, USERIDKEY);
//        SpUtil.remove(mContext, USERNAMEKEY);
//        SpUtil.remove(mContext, SEXKEY);
//        SpUtil.remove(mContext, CLUBIDKEY);
//        SpUtil.remove(mContext, TOKENKEY);
//        SpUtil.remove(mContext, PERSONTYPEKEY);
//        SpUtil.remove(mContext, ISDERPARTMANAGERKEY);
//        SpUtil.remove(mContext, DEPARTIDKEY);

    }

    public static void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

    public void LessonPopup(View v, String nameLesson, String nameTeacher) {
        if (contentView != null) contentView = null;
        if (popupWindow != null) popupWindow = null;
        // 一个自定义的布局，作为显示的内容

        contentView = LayoutInflater.from(mContext).inflate(R.layout.member_pop_view_time_lesson, null);
        popupWindow = new PopupWindow(contentView, SCREEN_WIDTH - 200, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
//                backgroundAlpha(1f);
            }
        });


        final TextView NameLesson = (TextView) contentView.findViewById(R.id.text_name_lesson);
        final TextView NameCoach = (TextView) contentView.findViewById(R.id.text_name_coach);
        final TextView btnClose = (TextView) contentView.findViewById(R.id.btn_close);
        NameLesson.setText("课程名称:" + nameLesson);
        NameCoach.setText("教练名称:" + nameTeacher);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
                return false;

                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        if (isAdded()) {
            popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));
        }
        // 设置好参数之后再show
        //获取点击View的坐标

        int[] point = {0, 0};

        v.getLocationOnScreen(point);

//        popupWindow.showAtLocation(v, Gravity.CENTER, 0, point[1] + v.getHeight());
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);


//        popupWindow.setAnimationStyle(R.style.take_photo_anim);
    }

    public void setTimeShow(String min, String NameLesson, String NameTeacher) {
        this.NameLesson = NameLesson;
        this.NameTeacher = NameTeacher;
        if (show) {
            floatTips.hide();
            show = false;
        } else {
            this.mMin = min;
            requestDrawOverLays();
            show = true;
        }
    }

    public void requestDrawOverLays() {

        if (Build.VERSION.SDK_INT >= 23) {
            if (!Settings.canDrawOverlays(App.context)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + mContext.getPackageName()));
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
                show = false;
                return;
            } else {
                floatTips.setGravity(FloatTips.BOTTOM);
                floatTips.show(mMin);
            }
        } else {
            floatTips.setGravity(FloatTips.BOTTOM);
            floatTips.show(mMin);
        }


    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (!Settings.canDrawOverlays(mContext)) {
                Toast.makeText(mContext, "请赋予提示框显示权限!否则无法提示上课时间!", Toast.LENGTH_SHORT).show();
            } else {
                requestDrawOverLays();
            }
        }
    }
    @Override
    public void onHiddenChanged(boolean hidden) {//默认fragment创建的时候是可见的，但是不会调用该方法！切换可见状态的时候会调用，但是调用onResume，onPause的时候却不会调用
        super.onHiddenChanged(hidden);

        if (!hidden) {
            onVisible();
            isVisible = true;
        } else {
            onHidden();
            isVisible = false;
        }
    }

}