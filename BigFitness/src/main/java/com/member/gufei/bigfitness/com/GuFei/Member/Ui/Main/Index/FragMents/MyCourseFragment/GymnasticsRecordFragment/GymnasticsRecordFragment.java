package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyCourseFragment.GymnasticsRecordFragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseFragment;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyCourseFragment.ClassEvaluationing.GyClassEvaluationingActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.FreeLessonClassRecordBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.member.gufei.bigfitness.Constants.MEMBERIDKEY;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.RESULT_ID;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;

/**
 * Created by GuFei_lyf on 2017/3/22
 * <p>
 * 上课记录-操课
 */


public class GymnasticsRecordFragment extends BaseFragment<GymnasticsRecordFragmentPresenter> implements GymnasticsRecordFragmentContract.View {


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


    private CommonAdapter<FreeLessonClassRecordBean.RowsBean> commonAdapter;
    private List<FreeLessonClassRecordBean.RowsBean> datas = new ArrayList<FreeLessonClassRecordBean.RowsBean>();
    private int Page;
    private boolean isLoadingMore = true;//加载标志位

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

        commonAdapter = new CommonAdapter<FreeLessonClassRecordBean.RowsBean>(R.layout.cardview_member_index_fragment_gymnastics, mContext, datas) {
            @Override
            protected void convert(final ViewHolder holder, final FreeLessonClassRecordBean.RowsBean dataBean, int position) {

                TextView btnEvaliate = (TextView) holder.getView(R.id.btn_evaluate);
                holder.setText(R.id.text_state_lesson, "课程状态:已结束");
                holder.setText(R.id.text_name_lesson, "课程名称:" + dataBean.getFLessonName());
                holder.setText(R.id.text_teacher_lesson, "上课教练:" + dataBean.getTeacherName());
                holder.setText(R.id.text_time_lesson, "上课时间:" + dataBean.getClassTime());
                if (dataBean.getIsEvaluated() == 1) {
                    btnEvaliate.setVisibility(View.GONE);
                }
                holder.getView(R.id.btn_evaluate).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (dataBean.getIsEvaluated() == 0) {

                            holder.getView(R.id.btn_evaluate).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent mDetailsActivity = new Intent(mContext, GyClassEvaluationingActivity.class);
                                    mDetailsActivity.putExtra(PUT_STR + "FreeLessonId", dataBean.getFreeLessonId());
                                    mDetailsActivity.putExtra(PUT_STR + "FreeLessonName", dataBean.getFLessonName());
                                    mDetailsActivity.putExtra(RESULT_ID, "9999");
                                    startActivityForResult(mDetailsActivity, 9999);
                                }
                            });
                        }

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
                    if (isLoadingMore && totalItemCount - 3 <= lastVisubleItem && dy > 0) {
                        isLoadingMore = false;
                        loading();
                    }
                }
            });

        }

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
//        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");

        final String MemberId = (String) SpUtil.get(mContext, MEMBERIDKEY, "");
        mPresenter.getFreeLessonClassRecord(String.valueOf(UserId),
                ClubId, token, Page, MemberId
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
        Intent intent = new Intent(mContext, LoginActivity.class);
        startActivity(intent);
    }


    @Override
    public void Loading() {

    }


    @Override
    public void succeed(FreeLessonClassRecordBean freeLessonClassRecordBean) {
//        if (freeLessonClassRecordBean.getConsumptionMoney() > 0)
//            textMoneyTotal.setText("消费总额:" + consumptionRecordBean.getConsumptionMoney() + "元");
        swipeRefreshLayout.setRefreshing(false);
        datas = freeLessonClassRecordBean.getRows();
        isLoadingMore = true;
        if (freeLessonClassRecordBean.getRows().size() == 0){
            textNoMore.setVisibility(View.VISIBLE);
            textNoMore.setText("当前暂无上课记录");
        }else {
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

