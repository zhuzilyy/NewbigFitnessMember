package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyCourseFragment.MyOthersFragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseFragment;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyLessonAppListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyOthersAppointmentBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.member.gufei.bigfitness.Constants.MEMBERIDKEY;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;


public class MyOthersFragment extends BaseFragment<MyOthersFragmentPresenter> implements MyOthersFragmentContract.View {

    @BindView(R.id.text_noMore)
    TextView textNoMore;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerviewid;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swiperefreshlayoutid;
    Unbinder unbinder;
    private int Page;
    private int PageSize = 10;
    int UserId;
    String token;
    String Clubid;
    private CommonAdapter<MyOthersAppointmentBean.RowsBean> commonAdapter;
    private List<MyOthersAppointmentBean.RowsBean> datas = new ArrayList<MyOthersAppointmentBean.RowsBean>();
    private MyOthersAppointmentBean.RowsBean rowsBean;
    private boolean isLoadingMore;
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
        commonAdapter = new CommonAdapter<MyOthersAppointmentBean.RowsBean>(R.layout.cardview_member_schedule_my_others, mContext, datas) {
            @Override
            protected void convert(ViewHolder holder, final MyOthersAppointmentBean.RowsBean dataBean, int position) {
                String appointmentResultName = dataBean.getAppointmentResultName();
                Log.i("tag","===="+appointmentResultName+"======"+position);
                holder.setText(R.id.text_type, "预约类型：" + dataBean.getAppointmentTypeName());
                holder.setText(R.id.text_result, "预约结果：" + dataBean.getAppointmentResultName());
                holder.setText(R.id.text_personnel, "预约人员：" + dataBean.getOfficeName() + " " + dataBean.getUserName());
                holder.setText(R.id.text_time, "预约时间：" + dataBean.getStartTime() + "-" + dataBean.getEndTime());
                TextView submit = (TextView) holder.getView(R.id.btn_submit);
                TextView cancel = (TextView) holder.getView(R.id.btn_cancel);
                RelativeLayout rl_bottom = (RelativeLayout) holder.getView(R.id.rl_bottom);
                if (!TextUtils.isEmpty(dataBean.getAppointmentResultName())){
                    submit.setVisibility(View.GONE);
                    cancel.setVisibility(View.GONE);
                    rl_bottom.setVisibility(View.GONE);
                }else{
                    submit.setVisibility(View.VISIBLE);
                    cancel.setVisibility(View.VISIBLE);
                    rl_bottom.setVisibility(View.VISIBLE);
                }
                final String MemberId = (String) SpUtil.get(mContext, MEMBERIDKEY, "");
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rowsBean = dataBean;
                        mPresenter.getMyOthersSubmit(String.valueOf(UserId),
                                Clubid,
                                token,
                                MemberId,
                                String.valueOf(dataBean.getAppointmentId()));

                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rowsBean = dataBean;
                        mPresenter.getMyOthersCancel(String.valueOf(UserId),
                                Clubid,
                                token,
                                MemberId,
                                String.valueOf(dataBean.getAppointmentId()));
                    }
                });
            }
        };
        commonAdapter.setShowFooter(false);
        recyclerviewid.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerviewid.setAdapter(commonAdapter);

        //设置进度条的颜色
        swiperefreshlayoutid.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);
        //设置进度条的大小样式
        swiperefreshlayoutid.setSize(SwipeRefreshLayout.DEFAULT);
        swiperefreshlayoutid.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });

        if (recyclerviewid.getLayoutManager() instanceof LinearLayoutManager) {
            //获取列表华东监听器 用于获取当前所在条数
            final LinearLayoutManager RecycViewlayoutManager = (LinearLayoutManager) recyclerviewid.getLayoutManager();
            //添加滚动条见监听器
            recyclerviewid.addOnScrollListener(new RecyclerView.OnScrollListener() {

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    //总记录条数
                    //　int totalItemCount = linearLayoutManager.getItemCount();
                    int totalItemCount = recyclerView != null ? recyclerView.getAdapter().getItemCount() : 0;
                    //最后条数的位置
                    int lastVisubleItem = RecycViewlayoutManager.findLastVisibleItemPosition();
                    if (isLoadingMore && totalItemCount - 1 <= lastVisubleItem && dy > 0) {
                        isLoadingMore = false;
                        loading();
                    }
                }
            });

        }
    }

    @Override
    public void outLogin() {
        Intent intent = new Intent(mContext, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void succeed(MyOthersAppointmentBean myOthersAppointmentBean) {
        swiperefreshlayoutid.setRefreshing(false);
        datas = myOthersAppointmentBean.getRows();
        isLoadingMore = true;
        if (datas.size() == 0 && Page==1){
            textNoMore.setVisibility(View.VISIBLE);
        }else {
            if (Page == 1) {
                commonAdapter.replaceData(datas);
            } else {
                commonAdapter.insertData(datas);
            }
        }

    }

    @Override
    public void succeedSubmit(CodeBean codeBean) {
        Toast.makeText(mContext, "确认预约成功！", Toast.LENGTH_SHORT).show();
        rowsBean.setAppointmentResultName("成功");
        commonAdapter.notifyDataSetChanged();
        //refresh();
    }

    @Override
    public void succeedCancel(CodeBean codeBean) {
        Toast.makeText(mContext, "取消预约成功！", Toast.LENGTH_SHORT).show();
        rowsBean.setAppointmentResultName("失败");
        commonAdapter.notifyDataSetChanged();
        //refresh();
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
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        Clubid = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        mPresenter.getMyOthersAppointmentList(String.valueOf(UserId),
                Clubid,
                token,
                Page,
                PageSize);

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void Loading() {

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
