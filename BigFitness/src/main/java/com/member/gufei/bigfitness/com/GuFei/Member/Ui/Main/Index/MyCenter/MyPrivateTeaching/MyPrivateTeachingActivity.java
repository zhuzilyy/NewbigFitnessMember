package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.member.gufei.bigfitness.Presenter.MemberMainFragmentAdapter;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C1.IndexFragMentC1;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C2.IndexFragMentC2;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C3.IndexFragMentC3;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C4.IndexFragMentC4;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C5.IndexFragMentC5;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C1.IndexFragMentCP1;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C2.IndexFragMentCP2;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C3.IndexFragMentCP3;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C4.IndexFragMentCP4;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C5.IndexFragMentCP5;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyPrivateTeachingActivity extends BaseActivity<MyPrivateTeachingActivityPresenter> implements MyPrivateTeachingActivityContract.View {


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


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_my_card_list;
    }

    @Override
    protected void initView() {


        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("我的私教课");
        btnComplete.setVisibility(View.INVISIBLE);

        mTabLayout.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(mTabLayout, 14, 14);
            }
        });


        fragments.add(new IndexFragMentCP1());
        fragments.add(new IndexFragMentCP2());
        fragments.add(new IndexFragMentCP3());
        fragments.add(new IndexFragMentCP4());
//        fragments.add(new IndexFragMentCP5());


        //获取标签数据
        String[] titles = getResources().getStringArray(R.array.private_class_tab);
        //创建一个viewpager的adapter
        MemberMainFragmentAdapter adapter = new MemberMainFragmentAdapter(getSupportFragmentManager(), Arrays.asList(titles), fragments);
        this.mViewPager.setAdapter(adapter);
        //将TabLayout和ViewPager关联起来
        this.mTabLayout.setupWithViewPager(this.mViewPager);
    }


    @Override
    protected void initData() {
//        refresh();
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
    public void succeed(AppGetMyMemberLessonListBean appGetMyMemberLessonListBean) {
//        swipeRefreshLayout.setRefreshing(false);
//        if (appGetMyMemberLessonListBean.getRows().getMyLessonList().size() != 0) {
//            datas = appGetMyMemberLessonListBean.getRows().getMyLessonList();
//            commonAdapter.replaceData(datas);
//            isLoadingMore = true;
//        }
    }


}


