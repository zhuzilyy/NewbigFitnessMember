package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.member.gufei.bigfitness.Presenter.MainAdapter;
import com.member.gufei.bigfitness.Presenter.MemberMainFragmentAdapter;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyCourseFragment.GymnasticsRecordFragment.GymnasticsRecordFragment;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyCourseFragment.PrivateRecordFragment.PrivateRecordFragment;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyScheduleListActivity extends BaseActivity<MyScheduleListActivityPresenter> implements MyScheduleListActivityContract.View {


    @BindView(R.id.vp_main)
    ViewPager mViewPager;
    @BindView(R.id.tab_main)
    TabLayout mTabLayout;
    @BindView(R.id.btn_left)
    ImageView btnLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_right)
    ImageView btnRight;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swiperefreshlayoutid;


    private CommonAdapter<PublicSeaBean.ResultBean> commonAdapter;
    private List<PublicSeaBean.ResultBean> datas = new ArrayList<PublicSeaBean.ResultBean>();
    private List<Fragment> fragments = new ArrayList<>();
    private String[] tabTitles;// 标题数组
    private MainAdapter adapter;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_my_schedule_list;
    }

    @Override
    protected void initView() {

        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("预约");
        btnLeft.setImageResource(R.mipmap.img_calendar);

        btnRight.setImageResource(R.mipmap.img_plus);
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


        datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            PublicSeaBean.ResultBean bean = new PublicSeaBean.ResultBean();

            datas.add(bean);

        }
        commonAdapter = new CommonAdapter<PublicSeaBean.ResultBean>(R.layout.cardview_member_schedule_my_school, mContext, datas) {
            @Override
            protected void convert(ViewHolder holder, final PublicSeaBean.ResultBean dataBean, int position) {
                holder.getView(R.id.layout_bottom).setVisibility(View.GONE);


                if (position  % 2 == 1) {
                    holder.getView(R.id.layout_bottom).setVisibility(View.VISIBLE
                    );

                }

            }
        };

        commonAdapter.setShowFooter(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(commonAdapter);
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_left, R.id.btn_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_left:
                break;
            case R.id.btn_right:
                break;
        }
    }
}


