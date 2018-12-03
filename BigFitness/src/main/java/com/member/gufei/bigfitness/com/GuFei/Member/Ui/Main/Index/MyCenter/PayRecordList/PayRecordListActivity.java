package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.PayRecordList;

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
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ConsumptionRecordBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;

public class PayRecordListActivity extends BaseActivity<PayRecordListActivityPresenter> implements PayRecordListActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.text_money_total)
    TextView textMoneyTotal;
    @BindView(R.id.tv_noMore)
    TextView tvNoMore;


    private CommonAdapter<ConsumptionRecordBean.RowsBean> commonAdapter;
    private List<ConsumptionRecordBean.RowsBean> datas = new ArrayList<ConsumptionRecordBean.RowsBean>();
    private int Page;
    private boolean isLoadingMore = true;//加载标志位

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_records_pay_list;
    }

    @Override
    protected void initView() {


        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("消费记录");
        btnComplete.setVisibility(View.INVISIBLE);
        datas = new ArrayList<>();

        commonAdapter = new CommonAdapter<ConsumptionRecordBean.RowsBean>(R.layout.cardview_member_record_pay, mContext, datas) {
            @Override
            protected void convert(ViewHolder holder, final ConsumptionRecordBean.RowsBean dataBean, int position) {


                holder.setText(R.id.text_type_pay, "消费类型:" + dataBean.getClassName());
                holder.setText(R.id.text_type_card, "会员卡类型:" + dataBean.getConsumptionType());
                holder.setText(R.id.text_money_pay, "消费金额:" + dataBean.getTotalMoney() + "元");
                holder.setText(R.id.text_id_order, "订单编号:" + dataBean.getOrderId());
                holder.setText(R.id.text_time_pay, "消费时间:" + dataBean.getCreateTime());


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

        mPresenter.getConsumptionRecord(String.valueOf(UserId),
                ClubId, token, Page
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
    public void succeed(ConsumptionRecordBean consumptionRecordBean) {
        if (consumptionRecordBean.getConsumptionMoney() > 0)
            textMoneyTotal.setText("消费总额:" + consumptionRecordBean.getConsumptionMoney() + "元");
        datas = consumptionRecordBean.getRows();
        if (datas.size() != 0){
            isLoadingMore = true;
            if (Page == 1) {

                commonAdapter.replaceData(datas);
            } else {

                commonAdapter.insertData(datas);
            }
        }else {
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


