package com.member.gufei.bigfitness.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.member.gufei.bigfitness.App;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 简单的 BaseActivity
 *
 * @author GuFei
 * @version 2016 10 10 8:52
 */
public abstract class SimpleBaseActivity extends AppCompatActivity {

    protected Activity mContext;
    protected String TAG;
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*getWindow().requestFeature(Window.FEATURE_NO_TITLE); // 无标题

        // ...为沉浸式标题
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }*/

        setContentView(getLayout());





        mUnBinder = ButterKnife.bind(this);
        mContext = this;
        TAG = this.getClass().getSimpleName();
        App.getInstance().addActivity(this);

        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //MobclickAgent.onResume(this); // 友盟
    }

    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                if (fm != null && fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                } else {
                    finish();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        //MobclickAgent.onPause(this); // 友盟
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
        App.getInstance().removeActivity(this);
    }

    protected abstract int getLayout();
    protected abstract void initData();



}