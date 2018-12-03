package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCourseList;

import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.member.gufei.bigfitness.Presenter.MainAdapter;
import com.member.gufei.bigfitness.Presenter.MemberMainFragmentAdapter;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C1.IndexFragMentC1;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C2.IndexFragMentC2;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C3.IndexFragMentC3;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C4.IndexFragMentC4;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C5.IndexFragMentC5;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyCourseFragment.GymnasticsRecordFragment.GymnasticsRecordFragment;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyCourseFragment.PrivateRecordFragment.PrivateRecordFragment;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.Schedule;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

public class MyCourseListActivity extends BaseActivity<MyCourseListActivityPresenter> implements MyCourseListActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.vp_main)
    ViewPager mViewPager;
    @BindView(R.id.tab_main)
    TabLayout mTabLayout;


    private List<Fragment> fragments = new ArrayList<>();
    private String[] tabTitles;// 标题数组
    private MainAdapter adapter;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_my_course_list;
    }

    @Override
    protected void initView() {


        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("上课记录");
        btnComplete.setVisibility(View.INVISIBLE);
        mTabLayout.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(mTabLayout, 30, 30);
            }
        });


        //获取标签数据
        tabTitles = getResources().getStringArray(R.array.my_course_tab);
        // 添加 Fragment
        fragments.add(new PrivateRecordFragment());
        fragments.add(new GymnasticsRecordFragment());

        //创建一个viewpager的adapter
        MemberMainFragmentAdapter adapter = new MemberMainFragmentAdapter(getSupportFragmentManager(), Arrays.asList(tabTitles), fragments);
        this.mViewPager.setAdapter(adapter);
        //将TabLayout和ViewPager关联起来
        this.mTabLayout.setupWithViewPager(this.mViewPager);
//
////
    }
    @Override
    protected void initData() {

    }


    @Override
    public void showEmpty() {

    }

    @Override
    public void Loading() {

    }

    @Override
    public void outLogin() {

    }

    @Override
    public void succeed(PublicSeaBean publicSeaBean) {

    }

    @Override
    public void succeedEdit(CodeBean codeBean) {

    }

    @Override
    public void succeedoperate() {

    }

    @Override
    public void membersucceed(PublicSeaMemberBean publicSeaBean) {

    }



}


