package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.AddReservationClass.AddReservation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guojunustb.library.MemberWeekHeaderView;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.ReservationClass.ReservationClassDetails.ReservationClassDetailsActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubFLessonListBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.LoadImage.loadBgImg;
import static com.member.gufei.bigfitness.util.TimeUtil.getDayTime;
import static com.member.gufei.bigfitness.util.TimeUtil.getNowDate;

public class AddReservationActivity extends BaseActivity<AddReservationActivityPresenter> implements AddReservationActivityContract.View {
    @BindView(R.id.left_back)
    ImageView leftBack;
    @BindView(R.id.btn_left)
    ImageView btnLeft;
    @BindView(R.id.weekdaydview)
    MemberWeekHeaderView weekdaydview;
    @BindView(R.id.btn_right)
    ImageView btnRight;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerviewid;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swiperefreshlayoutid;

    private CommonAdapter<ClubFLessonListBean.RowsBean> commonAdapter;
    private List<ClubFLessonListBean.RowsBean> datas = new ArrayList<ClubFLessonListBean.RowsBean>();
    private boolean isLoadingMore = true;//加载标志位
    private int Page = 1;
    private boolean mFirstShow = true;
    private boolean mLoading = false;
    private boolean mLodEnd = false;
    private String dateStr;

    @Override
    public void onResume() {
        super.onResume();
        refresh();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_reservation_add;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        weekdaydview.setDateSelectedChangeListener(new MemberWeekHeaderView.DateSelectedChangeListener() {
            @Override
            public void onDateSelectedChange(Calendar oldSelectedDay, Calendar newSelectedDay) {
                dateStr = getDayTime(newSelectedDay.getTime());
                refresh();
//                s(mContext, dateStr);
            }
        });


        datas = new ArrayList<>();
        dateStr = getNowDate();
        refresh();
    }

    @Override
    public void outLogin() {
        Intent intent = new Intent(mContext, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void succeed(ClubFLessonListBean clubFLessonListBean) {
        initList();
        swiperefreshlayoutid.setRefreshing(false);
        if (clubFLessonListBean.getRows().size() != 0) {
            datas = clubFLessonListBean.getRows();
            if (Page == 1) {
                commonAdapter.replaceData(datas);
            } else {
                commonAdapter.insertData(datas);
            }

            isLoadingMore = true;
            mFirstShow = false;
            mLodEnd = true;
        }

    }


    @Override
    public void showEmpty() {

    }

    @Override
    public void Loading() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.left_back, R.id.btn_left, R.id.btn_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_back:
                finish();
                break;
            case R.id.btn_left:
                weekdaydview.goToLastWeek();
                break;
            case R.id.btn_right:
                weekdaydview.goToNextWeek();
                break;
        }
    }

    private void refresh() {
        Page = 1;
        getList();
    }
    private void loading() {
        Page++;
        getList();
    }

    private void getList() {
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");

        String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        mPresenter.getClubFLessonList(String.valueOf(UserId),
                token, ClubId, dateStr, "00:00:00", Page
        );
    }
    private void initList() {
        commonAdapter = new CommonAdapter<ClubFLessonListBean.RowsBean>(R.layout.cardview_member_index_fragmentc4, mContext, datas) {
            /**
             * @param holder   holder对象
             * @param dataBean
             * @param position 位置
             */

            @Override
            protected void convert(final ViewHolder holder, final ClubFLessonListBean.RowsBean dataBean, int position) {

                holder.setText(R.id.text_title, dataBean.getFLessonName());
                holder.setText(R.id.text_content, dataBean.getTeacherName() + " " + dataBean.getStartTime() + "-" + dataBean.getEndTime());
                TextView textNumber = (TextView) holder.getView(R.id.text_number);
                textNumber.setText(dataBean.getNowPersonCount() + "");
                holder.setText(R.id.text_number_total, "/" + dataBean.getMaxPersonCount());
                loadBgImg(mContext, dataBean.getImageURL(), R.mipmap.img_bg_list, (ImageView) holder.getView(R.id.img_bg));

                holder.getView(R.id.img_type).setVisibility(View.VISIBLE);
                if (dataBean.getIsAppointment() == 1) {
                    holder.setImage(R.id.img_type).setImageResource(R.mipmap.img_appointed);
                } else {
                    if (dataBean.getIsAllowAppointment() == 1) {
                        holder.setImage(R.id.img_type).setImageResource(R.mipmap.is_full);
                        textNumber.setTextColor(Color.parseColor("#63cd2b"));
                    } else {
                        holder.getView(R.id.img_type).setVisibility(View.INVISIBLE);
                    }


                }


                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ReservationClassDetailsActivity.class);
////
////
//////
                        intent.putExtra("FLessonId", dataBean.getFLessonId()+"");
                        intent.putExtra("StartTime", dataBean.getStartTime());
                        intent.putExtra("LessonDate", dataBean.getLessonDate());
//                        intent.putExtra(PUT_STR + "ConsumeType", dataBean.getConsumeType());
//                        intent.putExtra(PUT_STR + "MemberCardId", dataBean.getMemberCardId());
////                        intent.putExtra(PUT_STR + "Status", dataBean.getStatus());
                        startActivity(intent);
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
                    if (isLoadingMore && totalItemCount-1 <= lastVisubleItem && dy > 0) {
                        isLoadingMore = false;
                        loading();
                    }
                }
            });

        }
    }
}
