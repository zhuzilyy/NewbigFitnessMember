package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.member.gufei.bigfitness.Presenter.MemberMainFragmentAdapter;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseFragment;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C1.IndexFragMentC1;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C2.IndexFragMentC2;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C3.IndexFragMentC3;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C4.IndexFragMentC4;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C5.IndexFragMentC5;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;
import com.member.gufei.bigfitness.util.MyCountDownTimer;
import com.member.gufei.bigfitness.util.MyViewPager.MyViewPager;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by GuFei_lyf on 2017/3/22
 * <p>
 * 实际会所主页
 */

@RuntimePermissions
public class IndexFragMent extends BaseFragment<IndexFragMentPresenter> implements IndexFragMentContract.View {


    @BindView(R.id.vp_main)
    MyViewPager mViewPager;
    @BindView(R.id.tab_main)
    TabLayout mTabLayout;

    private boolean mFirstShow = true;
    private List<Fragment> fragments ;
    public MyCountDownTimer myCountDownTimer;


    private static final int REQUEST_CODE = 1;
    private Context context;

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
    }

    @Override
    public void onResume() {
        super.onResume();
//        InitView();
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (!mFirstShow ) {
//                InitView();
            }

            //相当于Fragment的onResume

        } else {
            //相当于Fragment的onPause

        }
    }


    @Override
    protected void initInject() {

        getFragmentComponent().inject(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.member_fragment_index;
    }


    private void refresh() {

    }


    @Override
    protected void initData() {
        InitView();
    }

    public void InitView() {
//     if (!fragments.equals(null)) { fragments.clear();}
        fragments = new ArrayList<>();
        mTabLayout.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(mTabLayout, 10, 10);
            }
        });
        fragments.add(new IndexFragMentC1());
        fragments.add(new IndexFragMentC2());
        fragments.add(new IndexFragMentC3());
        fragments.add(new IndexFragMentC4());
        fragments.add(new IndexFragMentC5());
        //获取标签数据
        String[] titles = getResources().getStringArray(R.array.home_tab);
        //创建一个viewpager的adapter
        MemberMainFragmentAdapter adapter = new MemberMainFragmentAdapter(getChildFragmentManager(), Arrays.asList(titles), fragments);
        this.mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(5);
        //将TabLayout和ViewPager关联起来
        this.mTabLayout.setupWithViewPager(this.mViewPager);
        mFirstShow = false;
    }


    @Override
    public void showError(String msg) {

//        noticeSystemBtn.setVisibility(View.GONE);
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void outLogin() {
        Intent intent = new Intent(mContext, LoginActivity.class);
        startActivity(intent);
    }


    @Override
    public void Loading() {

    }


    @NeedsPermission(Manifest.permission.CAMERA)
    void Scan() {


    }


    @Override
    public void succeed(MainMsgBean mainMsgBean) {


    }

    @Override
    public void MainPagesucceed(SineForMainPageBean sineForMainPageBean) {


    }


}

