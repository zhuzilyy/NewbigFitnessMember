package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.AddReservationClass.ChoosePrivate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.member.gufei.bigfitness.Presenter.SpinnerPopContract;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.SelectCocat.SelectCocatActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.DetailsActivated.MyPrivateDetailsActivatedActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListActivedBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.ID_ACTIVITY_APPOINTMEN;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

/*
 * 修改昵称
 *
 *
 * */
public class ChoosePrivateActivity extends BaseActivity<ChoosePrivateActivityPresenter> implements SpinnerPopContract, ChoosePrivateActivityContract.View {


    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.btn_back)
    ImageView btnBack;

//    @BindView(R.id.btn_class_aerobics)
//    Button btnClassAerobics;


    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.tv_noMore)
    TextView tvNoMore;


    private CommonAdapter<AppGetMyMemberLessonListActivedBean.RowsBean.MyLessonListBean> commonAdapter;
    private List<AppGetMyMemberLessonListActivedBean.RowsBean.MyLessonListBean> datas = new ArrayList<AppGetMyMemberLessonListActivedBean.RowsBean.MyLessonListBean>();
    public boolean isLoadingMore;
    private int Page = 0;
    private int isSelected = 0;
    private int TotalPage;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {

        return R.layout.member_activity_choose_private;

    }

    @Override
    protected void initView() {

//        toolbar.setNavigationIcon(R.mipmap.left);
//
//        setToolBar(toolbar, "");

        mainTitle.setText("选择私教课");
//        btnClassPrivate.setSelected(true);
        datas = new ArrayList<>();

        commonAdapter = new CommonAdapter<AppGetMyMemberLessonListActivedBean.RowsBean.MyLessonListBean>(R.layout.cardview_member_choose_private, mContext, datas) {
            @Override
            protected void convert(final ViewHolder holder, final AppGetMyMemberLessonListActivedBean.RowsBean.MyLessonListBean dataBean, final int position) {

                holder.setText(R.id.text_name_class, dataBean.getLessonName() + " " + dataBean.getBalance());
                holder.setText(R.id.text_number_class, "/" + dataBean.getTotalBuyCount());
//                    if (!dataBean.getImageURL().equals("")) {
//                        loadBgImg(mContext, dataBean.getImageURL(),R.mipmap.img_bg_list,  (ImageView) holder.getView(R.id.img_bg));
//                    }
//                    holder.setText(R.id.text_type,"已激活");
//                if (isSelected == dataBean.getId()) {
////                    holder.setImage(R.id.CheckBox_img).setVisibility(View.VISIBLE);
//                    holder.setImage(R.id.CheckBox_selset).setImageResource(R.drawable.check_box_ture);
//                } else {
//
//                    holder.setImage(R.id.CheckBox_selset).setImageResource(R.mipmap.nothing);
//                }

//                holder.getView(R.id.CheckBox_selset).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
////                        dataBean.setSelected(!dataBean.isSelected());
//                        isSelected = dataBean.getId();
//                       commonAdapter.notifyDataSetChanged();
//                    }
//                });


                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        dataBean.setSelected(!dataBean.isSelected());
                        isSelected = dataBean.getId();
                        commonAdapter.notifyDataSetChanged();
                        Intent coach = new Intent(context, SelectCocatActivity.class);
                        coach.putExtra(PUT_STR + "LessonId", dataBean.getLessonId());
                        coach.putExtra(PUT_STR + "LessonName", dataBean.getLessonName());
                        coach.putExtra(PUT_STR + "code", "1");
                        startActivity(coach);

                    }
                });

                holder.getView(R.id.btn_info).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(context, MyPrivateDetailsActivatedActivity.class);
                        intent.putExtra(PUT_STR + "id", String.valueOf(dataBean.getId()));

                        intent.putExtra(PUT_STR + "Status", String.valueOf(dataBean.getStatus()));
                        intent.putExtra(PUT_STR + "type", ID_ACTIVITY_APPOINTMEN);
                        startActivity(intent);


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
                    if (Page >= TotalPage){
                        isLoadingMore = false;
                    }
                    if (isLoadingMore && totalItemCount - 1 <= lastVisubleItem && dy > 0) {
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
        mPresenter.appGetMyMemberLessonListActived(String.valueOf(UserId),
                ClubId, token, Page
        );
    }

    @Override
    public void showError(String msg) {

//        noticeSystemBtn.setVisibility(View.GONE);
    }


    @Override
    public void succeed(AppGetMyMemberLessonListActivedBean appGetMyMemberLessonListActivedBean) {
        swipeRefreshLayout.setRefreshing(false);
        if (appGetMyMemberLessonListActivedBean.getRows().getMyLessonList().size() != 0) {
            datas = appGetMyMemberLessonListActivedBean.getRows().getMyLessonList();
            if (datas.size() == 0){
                tvNoMore.setVisibility(View.VISIBLE);
            }else {
                if (Page == 1) {
                    commonAdapter.replaceData(datas);
                } else {
                    commonAdapter.insertData(datas);
                }
                isLoadingMore = true;
            }

        }
        isLoadingMore = true;
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void Loading() {

    }

    @Override
    public void outLogin() {

        s(this, "您的帐号在其他设备登录");
        Intent intent = new Intent(mContext, LoginActivity.class);
        remove();

        startActivity(intent);

    }


    @Override
    public void dismiss() {
        backgroundAlpha(1f);
    }


    @OnClick({R.id.btn_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
