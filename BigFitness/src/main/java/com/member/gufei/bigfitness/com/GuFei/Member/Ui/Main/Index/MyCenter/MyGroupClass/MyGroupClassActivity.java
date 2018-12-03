package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyGroupClass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyGroupClass.Details.DetailsActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyGroupLessonBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.RESULT_ID;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.TYPEGTOUPLESSON;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;

public class MyGroupClassActivity extends BaseActivity<MyGroupClassActivityPresenter> implements MyGroupClassActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;

    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.text_noMore)
    TextView textNoMore;


    private CommonAdapter<MyGroupLessonBean.RowsBean> commonAdapter;
    private List<MyGroupLessonBean.RowsBean> datas = new ArrayList<MyGroupLessonBean.RowsBean>();
    private int Page;
    private boolean isLoadingMore;


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_records_list;
    }

    @Override
    protected void initView() {


        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("我的团体课");
        btnComplete.setVisibility(View.INVISIBLE);
        datas = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            MyGroupLessonBean.RowsBean bean = new MyGroupLessonBean.RowsBean();
//            datas.add(bean);
//        }
        commonAdapter = new CommonAdapter<MyGroupLessonBean.RowsBean>(R.layout.cardview_member_my_group_class, mContext, datas) {
            @Override
            protected void convert(ViewHolder holder, final MyGroupLessonBean.RowsBean dataBean, int position) {
                holder.setText(R.id.text_title, dataBean.getGLessonName());
                holder.setText(R.id.text_type, TYPEGTOUPLESSON[dataBean.getStatus()]);
                holder.setText(R.id.text_money, "¥" + dataBean.getSaleMoney());
                holder.setText(R.id.text_number, "/" + dataBean.getAmount() + "节");
                holder.setText(R.id.text_title, dataBean.getGLessonName());
//                loadBgImg(mContext, dataBean.getImageURL(), R.mipmap.img_bg_list, (ImageView) holder.getView(R.id.img_bg));
                LinearLayout layoutBottom = (LinearLayout) holder.getView(R.id.layout_bottom);

                if (dataBean.getIsEvaluate() == 0) {
                    layoutBottom.setVisibility(View.VISIBLE);
                } else {
                    layoutBottom.setVisibility(View.GONE);
                }


                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Intent mDetailsActivity = new Intent(mContext, DetailsActivity.class);
                        mDetailsActivity.putExtra(PUT_STR + "Id", dataBean.getId());
                        mDetailsActivity.putExtra(RESULT_ID, "9999");
                        startActivityForResult(mDetailsActivity, 9999);
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

        mPresenter.getMyGroupLesson(
                ClubId, String.valueOf(UserId), token, Page
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
    public void succeed(MyGroupLessonBean myGroupLessonBean) {
        swipeRefreshLayout.setRefreshing(false);
        datas = myGroupLessonBean.getRows();
        isLoadingMore = true;
        if (datas.size() == 0){
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}


