package com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.ReservationRecordList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.ClockInClass.ClockInClassActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.TimeForClass.TimeForClassActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.QueryScheduleDayBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.TimeUtil.getNowDate;

public class ReservationRecordListActivity extends BaseActivity<ReservationRecordListActivityPresenter> implements ReservationRecordListActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.tv_noMore)
    TextView tvNoMore;
//    @BindView(R.id.swiperefreshlayoutid)
//    SwipeRefreshLayout swipeRefreshLayout;

    private CommonAdapter<QueryScheduleDayBean.RowsBean> mSystemCommonAdapter;

    private List<QueryScheduleDayBean.RowsBean> datas = new ArrayList<QueryScheduleDayBean.RowsBean>();
    private String[] spinnerArr;
    private ArrayAdapter adapter = null;
    private int Page;
    private boolean isLoadingMore;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_reservation_record_list;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
//
        setToolBar(toolbar, "");

        tvTitle.setText("");
        tvTitle.setText(Html.fromHtml("<b>上课记录预约</b>(当天)"));

        btnComplete.setVisibility(View.GONE);

        datas = new ArrayList<>();

        mSystemCommonAdapter = new CommonAdapter<QueryScheduleDayBean.RowsBean>(R.layout.cardview_member_record_reservation, mContext, datas)

        {
            @Override
            protected void convert(ViewHolder holder,
                                   final QueryScheduleDayBean.RowsBean dataBean, int position) {
                final String LessonName = "课程名称:" + dataBean.getLessonName();
                final String TeacherName = "上课教练:" + dataBean.getTeacherName();
                final String TextTime = "预约时间:" + dataBean.getAppointmentDate() + " " + dataBean.getStartTime() + "-" + dataBean.getEndTime();

                holder.setText(R.id.text_name_lesson, LessonName);
                holder.setText(R.id.text_name_coach, TeacherName);
                holder.setText(R.id.text_time, TextTime);


                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(mContext, TimeForClassActivity.class);
                        intent.putExtra(PUT_STR + "AppointmentId", String.valueOf(dataBean.getAppointmentId()));
                        intent.putExtra(PUT_STR + "LessonName", LessonName);
                        intent.putExtra(PUT_STR + "TeacherName", TeacherName);
                        intent.putExtra(PUT_STR + "TextTime", TextTime);
                        intent.putExtra(PUT_STR + "IsSignIn", dataBean.getIsSignIn());
                        intent.putExtra(PUT_STR + "LessonId", String.valueOf(dataBean.getLessonId()));
                        intent.putExtra(PUT_STR + "StartTime", dataBean.getAppointmentDate() + " " + dataBean.getStartTime());
                        startActivity(intent);
//                        AlertDialog dialog = new AlertDialog.Builder(mContext)
////                                .setIcon(R.mipmap.icon)//设置标题的图片
//                                .setTitle("")//设置对话框的标题
//                                .setMessage("确定删除xx信息?")//设置对话框的内容
//                                //设置对话框的按钮
//                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        Toast.makeText(mContext, "点击了取消按钮", Toast.LENGTH_SHORT).show();
//                                        dialog.dismiss();
//                                    }
//                                })
//                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        Toast.makeText(mContext, "点击了确定的按钮", Toast.LENGTH_SHORT).show();
//                                        dialog.dismiss();
//                                    }
//                                }).create();
//                        dialog.show();

                    }
                });

            }
        }

        ;

        mSystemCommonAdapter.setShowFooter(false);

        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(mSystemCommonAdapter);


//
////
    }


    @Override
    protected void initData() {
        refresh();
    }


    private void refresh() {
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");

        mPresenter.QueryScheduleDay(String.valueOf(UserId),
                ClubId, token, getNowDate(), getNowDate(),""
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
    public void succeed(QueryScheduleDayBean queryScheduleDayBean) {

//        swipeRefreshLayout.setRefreshing(false);
        if (queryScheduleDayBean.getRows().size() != 0) {
            datas = queryScheduleDayBean.getRows();
            mSystemCommonAdapter.replaceData(datas);
        } else {
            tvNoMore.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}


