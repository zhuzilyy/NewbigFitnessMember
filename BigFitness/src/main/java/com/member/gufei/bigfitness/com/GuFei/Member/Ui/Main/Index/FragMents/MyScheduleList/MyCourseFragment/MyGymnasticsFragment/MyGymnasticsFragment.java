package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyCourseFragment.MyGymnasticsFragment;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseFragment;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.FreeLessonAppointmentListBean;
import com.member.gufei.bigfitness.util.SpUtil;
import com.uuzuche.lib_zxing.activity.CaptureActivity;

import net.simonvt.menudrawer.MenuDrawer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

import static com.member.gufei.bigfitness.Constants.MEMBERIDKEY;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.TYPEAPPOINTMENT;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 * <p>
 * 预约列表-操课
 */

@RuntimePermissions
public class MyGymnasticsFragment extends BaseFragment<MyGymnasticsFragmentPresenter> implements MyGymnasticsFragmentContract.View {


    @BindView(R.id.text_noMore)
    TextView textNoMore;
    Unbinder unbinder;
    private Context context;
    private View viewContent;
    private int mType = 0;
    private String mTitle;

    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;

    private CommonAdapter<FreeLessonAppointmentListBean.RowsBean> commonAdapter;
    private List<FreeLessonAppointmentListBean.RowsBean> datas = new ArrayList<FreeLessonAppointmentListBean.RowsBean>();
    MenuDrawer mDrawer;
    private boolean isLoadingMore;
    private int Page;
    private int TotalPage;


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
        return R.layout.member_fragment_index_c2;
    }


    @Override
    protected void initData() {

//        TextView textView = (TextView) viewContent.findViewById(R.id.tv_content);
//        textView.setText(this.mTitle);

        datas = new ArrayList<>();

        commonAdapter = new CommonAdapter<FreeLessonAppointmentListBean.RowsBean>(R.layout.cardview_member_schedule_my_gymnastics, mContext, datas) {
            @Override
            protected void convert(final ViewHolder holder, final FreeLessonAppointmentListBean.RowsBean dataBean, int position) {
                holder.setText(R.id.text_status, "预约状态: " + TYPEAPPOINTMENT[dataBean.getStatus()]);
                holder.setText(R.id.text_name_lesson, "课程名称: " + dataBean.getFLessonName());
                holder.setText(R.id.text_name_coach, "上课教练: " + dataBean.getTeacherName());
                holder.setText(R.id.text_time, "预约时间: " + dataBean.getAppointmentTime().toString());
                holder.setText(R.id.tv_num, String.valueOf(dataBean.getNumber()));
                Log.i("xjz",dataBean.getNumber()+"=======getNumber=====");
                if (dataBean.getIsSignIn() == 0){
                    holder.getView(R.id.btn4).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            final int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
                            final String token = (String) SpUtil.get(mContext, TOKENKEY, "");
                            final String Clubid = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
                            String MemberId = (String) SpUtil.get(mContext, MEMBERIDKEY, "");
                            mPresenter.cancelMemberFreeLessonAppointment(
                                    String.valueOf(UserId), Clubid, token, MemberId, String.valueOf(dataBean.getAppointmentId()), "嘚瑟");
                        }
                    });
                }else {
                    holder.getView(R.id.btn4).setVisibility(View.GONE);
                }

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                });
            }
        };


        commonAdapter.setShowFooter(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(commonAdapter);

        //设置进度条的颜色
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);
        //设置进度条的大小样式
        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //停止刷新
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
                refresh();
            }
        });

        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            //获取列表华东监听器 用于获取当前所在条数
            final LinearLayoutManager RecycViewlayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            //添加滚动条见监听器
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    //总记录条数
                    //　int totalItemCount = linearLayoutManager.getItemCount();
                    int totalItemCount = recyclerView != null ? recyclerView.getAdapter().getItemCount() : 0;
                    //最后条数的位置
                    int lastVisubleItem = RecycViewlayoutManager.findLastVisibleItemPosition();
                    if (Page >= TotalPage){
                        isLoadingMore = false;
                    }
                    if (isLoadingMore && totalItemCount - 5 <= lastVisubleItem && dy > 0) {
                        isLoadingMore = false;
                        loading();
                    }
                }
            });

        }

        refresh();
    }

    @Override
    public void succeedConfirm(CodeBean codeBean) {
        s(mContext, codeBean.getMsg());
        refresh();
    }


    private void loading() {
        Page++;

        getList();
    }

    private void refresh() {
        Page = 1;
        getList();
    }

    private void getList() {

        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        String Clubid = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");


        final String MemberId = (String) SpUtil.get(mContext, MEMBERIDKEY, "");

        mPresenter.FreeLessonAppointmentList(String.valueOf(UserId),
                Clubid, token, Page, MemberId
        );

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
        s(getActivity(), "您的帐号在其他设备登录");
        Intent intent = new Intent(mContext, LoginActivity.class);
        startActivity(intent);
    }


    @Override
    public void Loading() {

    }


    @NeedsPermission(Manifest.permission.CAMERA)
    void Scan() {

        Intent intent = new Intent(mContext, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);

    }


    @Override
    public void succeed(FreeLessonAppointmentListBean freeLessonAppointmentListBean) {
        swipeRefreshLayout.setRefreshing(false);
        datas = freeLessonAppointmentListBean.getRows();
        TotalPage = freeLessonAppointmentListBean.getTotalPage();
        isLoadingMore = true;
        if (datas.size() == 0){
            textNoMore.setVisibility(View.VISIBLE);
        }else {
            textNoMore.setVisibility(View.GONE);
            if (Page == 1) {

                commonAdapter.replaceData(datas);
            } else {

                commonAdapter.insertData(datas);
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

