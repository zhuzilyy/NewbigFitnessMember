package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyCourseFragment.MyPrivateFragment;

import android.Manifest;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseFragment;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyReservationDetails.MyReservationDetailsActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyLessonAppListBean;
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
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.TYPEAPPOINTMENT;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.TimeUtil.compareNowDateTime;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 * <p>
 * 预约列表-私教课
 */

@RuntimePermissions
public class MyPrivateFragment extends BaseFragment<MyPrivateFragmentPresenter> implements MyPrivateFragmentContract.View {


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

    private CommonAdapter<MyLessonAppListBean.RowsBean> commonAdapter;
    private List<MyLessonAppListBean.RowsBean> datas = new ArrayList<MyLessonAppListBean.RowsBean>();
    MenuDrawer mDrawer;
    private boolean isLoadingMore;
    private int Page = 1;
    private boolean mLoading = false;
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

//        datas = new ArrayList<>();
        commonAdapter = new CommonAdapter<MyLessonAppListBean.RowsBean>(R.layout.cardview_member_schedule_my_school, mContext, datas) {
            @Override
            protected void convert(final ViewHolder holder, final MyLessonAppListBean.RowsBean dataBean, int position) {

                    holder.setText(R.id.text_status, "预约状态: " + (dataBean.getAppointmentOwner() == 0 ? "会员" : "教练") + TYPEAPPOINTMENT[dataBean.getAppointmentStatus()]
                    );
                    holder.setText(R.id.text_name_lesson, "课程名称: " + dataBean.getLessonName());
                    holder.setText(R.id.text_name_coach, "上课教练: " + dataBean.getTeacherName());
                    holder.setText(R.id.text_time, "预约时间: " + dataBean.getStartTime() + "-" + dataBean.getEndTime());
                    ImageView imgLeft = (ImageView) holder.getView(R.id.img_left);
                    TextView btnSubmit = (TextView) holder.getView(R.id.btn_submit);
                    TextView btnCancel = (TextView) holder.getView(R.id.btn_cancel);
                    switch (dataBean.getAppointmentCata()) {
                        case 0:
                            imgLeft.setVisibility(View.VISIBLE);
                            imgLeft.setImageResource(R.mipmap.img_left_yue);
                            break;
                        case 1:
                            imgLeft.setVisibility(View.VISIBLE);
                            imgLeft.setImageResource(R.mipmap.img_left_supply);

                            if (compareNowDateTime(dataBean.getStartTime())) {
                                // TODO: 2018/6/15   显示为课的图片 需要确认何时显示
                                imgLeft.setImageResource(R.mipmap.img_left_lesson);
                            }
                            break;

                    }
//                    switch (dataBean.getClassStatus()) {
//                        case 0:
//                            btnCancel.setVisibility(View.GONE);
//                            break;
//                        case 1:
//                            btnCancel.setVisibility(View.VISIBLE);
//                            break;
//
//                    }
                if (dataBean.getIsExpire() == 0){
                    if ( dataBean.getAppointmentStatus() == 0){
                        btnCancel.setVisibility(View.VISIBLE);
                    }else {
                        btnCancel.setVisibility(View.INVISIBLE);
                    }
                    switch (dataBean.getAppointmentStatus()) {
                        case 0:
                            if (dataBean.getAppointmentOwner() == 0) {
                                holder.getView(R.id.btn_submit).setVisibility(View.VISIBLE);
                            }else {
                                holder.getView(R.id.btn_submit).setVisibility(View.INVISIBLE);
                            }
                            break;
                        default:
                            holder.getView(R.id.btn_submit).setVisibility(View.INVISIBLE);
                            break;

                    }
                }else {
                        btnSubmit.setVisibility(View.INVISIBLE);
                        btnCancel.setVisibility(View.INVISIBLE);
                }

                    int imgCourse = 0;

                    String Typestatus = "";
                    if (dataBean.getAppointmentStatus() == 1) {
                        if (dataBean.getAppointmentOwner() == 0) {
                            imgCourse = R.mipmap.img_ptoc_selected;
                        } else {
                            imgCourse = R.mipmap.img_ctop_selected;
                        }
                    } else {

                        if (dataBean.getAppointmentOwner() == 0) {
                            imgCourse = R.mipmap.img_ptoc;

                        } else {
                            imgCourse = R.mipmap.img_ctop;
                        }

                    }


                    holder.setImage(R.id.img_course).setImageResource(imgCourse);

                    final int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
                    final String token = (String) SpUtil.get(mContext, TOKENKEY, "");
                    final String Clubid = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
                    final String MemberId = (String) SpUtil.get(mContext, MEMBERIDKEY, "");
                    holder.getView(R.id.btn_item).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(mContext, MyReservationDetailsActivity.class);
                            intent.putExtra(PUT_STR + "AppointmentId", String.valueOf(dataBean.getAppointmentId()));
                            startActivity(intent);

                        }
                    });

                    holder.getView(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            mPresenter.confirmLessonAppointment(
                                    String.valueOf(UserId), Clubid, token, MemberId, String.valueOf(dataBean.getAppointmentId())
                            );

                        }
                    });


                    holder.getView(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mPresenter.cancelMemberLessonAppointment(
                                    String.valueOf(UserId), Clubid, token, MemberId, String.valueOf(dataBean.getAppointmentId()), "2");

                        }
                    });

//                    holder.itemView.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//
//
//                        }
//                    });



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
                    if (Page >= TotalPage){
                        isLoadingMore = false;
                    }
                    if (isLoadingMore && totalItemCount - 1 <= lastVisubleItem && dy > 0 ) {
                        isLoadingMore = false;
                        loading();
                    }
                }
            });

        }
//        refresh();
    }

    private void loading() {
            Page++;
//        mLoading = true;
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
        // TODO: 2018/4/3  Clubid   坐标等是假定数据
        mPresenter.getMyLessonAppList(String.valueOf(UserId),
                Clubid, token, Page
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


    @NeedsPermission(Manifest.permission.CAMERA)
    void Scan() {

        Intent intent = new Intent(mContext, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);

    }

    @Override
    public void succeedConfirm(CodeBean codeBean) {
        s(mContext, codeBean.getMsg());
        refresh();
    }

    @Override
    public void succeed(MyLessonAppListBean myLessonAppListBean) {
        swipeRefreshLayout.setRefreshing(false);
        datas = myLessonAppListBean.getRows();
        TotalPage = myLessonAppListBean.getTotalPage();

        if (datas.size() == 0){
            textNoMore.setVisibility(View.VISIBLE);
        }else {
        if (Page == 1) {

            commonAdapter.replaceData(datas);
        } else {

            commonAdapter.insertData(datas);
        }
        isLoadingMore = true;
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

