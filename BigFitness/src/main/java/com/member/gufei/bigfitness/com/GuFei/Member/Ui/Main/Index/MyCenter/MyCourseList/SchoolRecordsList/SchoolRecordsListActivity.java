package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCourseList.SchoolRecordsList;
/*
*
* 私教课
* */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyCourseFragment.ClassEvaluationing.GyClassEvaluationingActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCourseList.RemedialApplication.RemedialApplicationActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.ClassEvaluationing.ClassEvaluationingActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClassLessonRecordListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.Schedule;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.member.gufei.bigfitness.Constants.MEMBERIDKEY;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.RESULT_ID;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.TYPELESSONRECORD;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;

public class SchoolRecordsListActivity extends BaseActivity<SchoolRecordsListActivityPresenter> implements SchoolRecordsListActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    private CommonAdapter<ClassLessonRecordListBean.RowsBean> commonAdapter;
    private List<ClassLessonRecordListBean.RowsBean> datas = new ArrayList<ClassLessonRecordListBean.RowsBean>();
    private String LessonId;
    private String LessonName;
    private boolean isLoadingMore;
    private int Page = 1;
    private boolean mLoading = false;
    private String ComeLogId;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_records_list;
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    @Override
    protected void initView() {


        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        Intent intent = getIntent();

        LessonId = intent.getStringExtra(PUT_STR + "LessonId");
        LessonName = intent.getStringExtra(PUT_STR + "LessonName");
        ComeLogId = intent.getStringExtra(PUT_STR + "ComeLogId");
        tvTitle.setText(LessonName);
        btnComplete.setVisibility(View.INVISIBLE);

        commonAdapter = new CommonAdapter<ClassLessonRecordListBean.RowsBean>(R.layout.cardview_member_record_school, mContext, datas) {
            @Override
            protected void convert(final ViewHolder holder, final ClassLessonRecordListBean.RowsBean dataBean, int position) {

//                holder.setText(R.id.text_state, "预约状态:" + TYPELESSONRECORD[dataBean.getApplyStatus()+1]);
//                holder.setText(R.id.text_state_lesson, "状态显示为分散!无优先级");
                holder.setText(R.id.text_name_lesson,"课程名称："+dataBean.getLessonName());
                holder.setText(R.id.text_name_coach,"上课教练："+dataBean.getTeacherName());
                holder.setText(R.id.text_time,"上课时间："+dataBean.getClassTime());
                 final TextView evaluate = (TextView) holder.getView(R.id.btn_evaluate);
//                final TextView state = (TextView) holder.getView(R.id.text_state_info);
                if (dataBean.getIsSignIn() == 1){
                    if (dataBean.getIsAllowMakeUp() == 1 && dataBean.getIsMakeUp() == 1){
                        holder.setText(R.id.text_state, "预约状态：已补课");
                    }else {
                        holder.setText(R.id.text_state, "预约状态：已上课");
                    }
                    if (dataBean.getIsEvaluated() == 0){
                        evaluate.setVisibility(View.VISIBLE);
                    }else if (dataBean.getIsEvaluated() == 1){
                        evaluate.setVisibility(View.VISIBLE);
                        evaluate.setText("修改评价");
                    }else {

                    }
                }else {
                    if (dataBean.getIsAllowMakeUp() == 1){
                        holder.setText(R.id.text_state, "预约状态：未到场");
                        if (dataBean.getIsMakeUp() == 1){
                            holder.setText(R.id.text_state, "预约状态：已补课");
                        }else {
                            if (dataBean.getApplyStatus() == -1){
                                evaluate.setVisibility(View.VISIBLE);
                                evaluate.setText("补课申请");
                            }else if (dataBean.getApplyStatus() == 0){
                                evaluate.setVisibility(View.VISIBLE);
                                evaluate.setText("补课申请中");
                            }else {
                                evaluate.setVisibility(View.VISIBLE);
                                evaluate.setText("补课申请成功");
                            }
                        }
                    }else {
                        holder.setText(R.id.text_state, "预约状态：未到场");
                    }
                }
                //补课申请
                evaluate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (evaluate.getText().toString().equals("补课申请")){
                            Intent intent = new Intent(mContext, RemedialApplicationActivity.class);
                            intent.putExtra(PUT_STR + "AppointmentId",String.valueOf(dataBean.getAppointmentId()));
                            intent.putExtra(PUT_STR + "LessonId",String.valueOf(dataBean.getLessonId()));
                            startActivity(intent);
                        }else {
                            Intent mDetailsActivity = new Intent(mContext, ClassEvaluationingActivity.class);
                            mDetailsActivity.putExtra(PUT_STR + "AppointmentId",String.valueOf(dataBean.getAppointmentId()));
                            mDetailsActivity.putExtra(PUT_STR + "ComeLogId", String.valueOf(dataBean.getComeLogId()));
                            if (evaluate.getText().toString().equals("评价")){
                                mDetailsActivity.putExtra(PUT_STR + "eCode", "0");
                            }else {
                                mDetailsActivity.putExtra(PUT_STR + "eCode", "1");
                            }
                            mDetailsActivity.putExtra(RESULT_ID, "9999");
                            startActivityForResult(mDetailsActivity, 9999);
                        }
                    }
                });

//                        if (dataBean.getIsEvaluated()==0 || dataBean.getIsEvaluated()==1 ){
//                            holder.getView(R.id.btn_evaluate).setVisibility(View.VISIBLE);
//                            holder.getView(R.id.btn_evaluate).setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    Intent mDetailsActivity = new Intent(mContext, ClassEvaluationingActivity.class);
//                                    mDetailsActivity.putExtra(PUT_STR + "AppointmentId",String.valueOf(dataBean.getAppointmentId()));
//                                    mDetailsActivity.putExtra(PUT_STR + "ComeLogId", String.valueOf(dataBean.getComeLogId()));
//                                    if (evaluate.getText().toString().equals("评价")){
//                                        mDetailsActivity.putExtra(PUT_STR + "eCode", "0");
//                                    }else {
//                                        mDetailsActivity.putExtra(PUT_STR + "eCode", "1");
//                                    }
//                                    mDetailsActivity.putExtra(RESULT_ID, "9999");
//                                    startActivityForResult(mDetailsActivity, 9999);
//                                }
//                            });
//                        }else{
//                            holder.getView(R.id.btn_evaluate).setVisibility(View.GONE);
//                        }
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
                    if (isLoadingMore && totalItemCount - 5 <= lastVisubleItem && dy > 0) {
                        isLoadingMore = false;
                        loading();
                    }
                }
            });

        }


    }

    @Override
    protected void initData() {
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
//        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        String MemberId = (String) SpUtil.get(mContext, MEMBERIDKEY, "");
        mPresenter.getLessonClassRecord(String.valueOf(UserId),
                ClubId, token, Page, Integer.parseInt(MemberId),LessonId,ComeLogId
        );
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
    public void succeed(ClassLessonRecordListBean classLessonRecordListBean) {

        swipeRefreshLayout.setRefreshing(false);
        if (classLessonRecordListBean.getRows().size() != 0) {
            datas = classLessonRecordListBean.getRows();
            if (Page == 1) {
                commonAdapter.replaceData(datas);
            } else {
                commonAdapter.insertData(datas);
            }

            isLoadingMore = true;

        }


    }
}


