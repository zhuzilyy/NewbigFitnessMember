package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.member.gufei.bigfitness.Presenter.MainAdapter;
import com.member.gufei.bigfitness.Presenter.MemberMainFragmentAdapter;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseFragment;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyCourseFragment.MyGymnasticsFragment.MyGymnasticsFragment;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyCourseFragment.MyOthersFragment.MyOthersFragment;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyCourseFragment.MyPrivateFragment.MyPrivateFragment;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.AddReservationClass.AddReservation.AddReservationActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.AddReservationClass.ChoosePrivate.ChoosePrivateActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.WeekDay.WeekDayActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.WeekViewForWeek.WeekViewForWeekActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MemberIdBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

import static com.member.gufei.bigfitness.Constants.ISLOCKKEY;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;

/**
 * Created by GuFei_lyf on 2017/3/22
 * <p>
 * 预约列表
 */

@RuntimePermissions
public class MyScheduleFragMent extends BaseFragment<MyScheduleFragMentPresenter> implements MyScheduleFragMentContract.View {


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


//    @BindView(R.id.recyclerviewid)
//    RecyclerView recyclerView;
//    @BindView(R.id.swiperefreshlayoutid)
//    SwipeRefreshLayout swiperefreshlayoutid;


//    private CommonAdapter<PublicSeaBean.ResultBean> commonAdapter;
//    private List<PublicSeaBean.ResultBean> datas = new ArrayList<PublicSeaBean.ResultBean>();
    private List<Fragment> fragments ;
    private List<String> tab11;// 标题数组
//    private MainAdapter adapter;

    private static final int REQUEST_CODE = 1;
    private Context context;
    String IsLock;
    int UserId;
    String token;
    String Clubid;

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
    }

    @Override
    public void onResume() {
        super.onResume();
        refresh();
    }


    @Override
    protected void initInject() {

        getFragmentComponent().inject(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.member_activity_my_schedule_list;
    }


    private void refresh() {

    }


    @Override
    protected void initData() {
//        mTabLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                setIndicator(mTabLayout, 14, 14);
//            }
//        });


//        toolbar.setNavigationIcon(R.mipmap.left);
//        setToolBar(toolbar, "");
        tvTitle.setText("预约");
        btnLeft.setImageResource(R.mipmap.img_calendar);

        btnRight.setImageResource(R.mipmap.img_plus);
        mTabLayout.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(mTabLayout, 30, 30);
            }
        });
        IsLock = (String) SpUtil.get(mContext, ISLOCKKEY, "");

        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        Clubid = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        //获取标签数据
//        tabTitles = getResources().getStringArray(R.array.my_course_tab);
        // 添加 Fragment
        tab11=new ArrayList<>();
        fragments = new ArrayList<>();
        tab11.add("私教课@dream@0");
        tab11.add("操课@dream@1");
        tab11.add("其他@dream@2");

        fragments.add(new MyPrivateFragment());
        fragments.add(new MyGymnasticsFragment());
        fragments.add(new MyOthersFragment());

        //创建一个viewpager的adapter
        MemberMainFragmentAdapter adapter = new MemberMainFragmentAdapter(getChildFragmentManager(), tab11, fragments);
        this.mViewPager.setAdapter(adapter);
        //将TabLayout和ViewPager关联起来
        this.mTabLayout.setupWithViewPager(this.mViewPager);


//        datas = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            PublicSeaBean.ResultBean bean = new PublicSeaBean.ResultBean();
//
//            datas.add(bean);
//
//        }
//        commonAdapter = new CommonAdapter<PublicSeaBean.ResultBean>(R.layout.cardview_member_schedule_my_school, mContext, datas) {
//            @Override
//            protected void convert(ViewHolder holder, final PublicSeaBean.ResultBean dataBean, int position) {
//                holder.getView(R.id.layout_bottom).setVisibility(View.GONE);
//
//
//                if (position  % 2 == 1) {
//                    holder.getView(R.id.layout_bottom).setVisibility(View.VISIBLE
//                    );
//
//                }
//
//            }
//        };
//
//        commonAdapter.setShowFooter(false);
//        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//        recyclerView.setAdapter(commonAdapter);
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

    @Override
    public void succeedMemberId(MemberIdBean memberIdBean) {
        if (memberIdBean.getRows().getMemberId() != 0 && memberIdBean.getRows().getIsLock() == 0 ){
            if (mViewPager.getCurrentItem()==0){
                Intent intent0 = new Intent(mContext, ChoosePrivateActivity.class);
                startActivity(intent0);
            }else{
                Intent intent1 = new Intent(mContext, AddReservationActivity.class);
                startActivity(intent1);
            }
        }else if (memberIdBean.getRows().getMemberId() != 0 && memberIdBean.getRows().getIsLock() == 1){
            Toast.makeText(mContext,"全部会员卡被冻结!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(mContext,"无可用会员卡!", Toast.LENGTH_SHORT).show();
        }
    }


    @OnClick({R.id.btn_left, R.id.btn_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_left:

                Intent intent = new Intent(mContext, WeekViewForWeekActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_right:
                mPresenter.getMemberIdIsLockId(String.valueOf(UserId),
                        Clubid,
                        token);
                break;
        }
    }
}

