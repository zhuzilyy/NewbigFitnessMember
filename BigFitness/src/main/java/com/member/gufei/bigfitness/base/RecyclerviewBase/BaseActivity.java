package com.member.gufei.bigfitness.base.RecyclerviewBase;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by tre on 16/9/16.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_NO_TITLE); // 无标题

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
        }

        ActivityCollector.addActivity(this); // 保存可用 Activity 集合 , 实现任意位置退出程序

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ActivityCollector.removeActivity(this); // 移除 Activity
    }

    /**
     * 创建菜单
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(1001, 100, 1, "菜单1");
        menu.add(1001, 101, 2, "菜单2");
        menu.add(1001, 102, 3, "菜单3");
        return true;
    }

    /**
     * 菜单点击事件
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 100:
                Toast.makeText(BaseActivity.this, "点击菜单一", Toast.LENGTH_SHORT).show();
                break;
            case 101:
                Toast.makeText(BaseActivity.this, "点击菜单二", Toast.LENGTH_SHORT).show();
                break;
            case 102:
                Toast.makeText(BaseActivity.this, "点击菜单三", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }



}
