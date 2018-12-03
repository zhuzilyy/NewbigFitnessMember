package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.BB;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.DetailsActivated.MyPrivateDetailsActivatedActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.DetailsNonactivated.MyPrivateDetailsNonactivatedActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.DetailsRefunded.MyPrivateDetailsRefundedActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.DetailsRefunding.MyPrivateDetailsRefundingActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.DetailsStale.MyPrivateDetailsStaleActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.LoadImage.loadBgImg;

public class MyCardListActivity extends BaseActivity<MyCardListActivityPresenter> implements MyCardListActivityContract.View {


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


    private CommonAdapter<AppGetMyMemberCardListBean.RowsBean.CardListBean> commonAdapter;
    private List<AppGetMyMemberCardListBean.RowsBean.CardListBean> datas = new ArrayList<AppGetMyMemberCardListBean.RowsBean.CardListBean>();

    String[] mTypeList = {"未开卡", "已开卡", "已冻结", "已到期", "作废", "冻结申请", "未激活", "退款申请中", "已退款"};
    private boolean isLoadingMore = true;//加载标志位
    private int Page = 1;
    private boolean mFirstShow = true;
    private boolean mLodEnd = false;


    @Override
    protected void initInject() {
//        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_my_card_list;
    }

    @Override
    protected void initView() {

        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("我的会员卡");
        btnComplete.setVisibility(View.INVISIBLE);


        datas = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Schedule.ResultBean.DataBean bean = new Schedule.ResultBean.DataBean();
//            datas.add(bean);
//        }
        commonAdapter = new CommonAdapter<AppGetMyMemberCardListBean.RowsBean.CardListBean>(R.layout.cardview_member_my_card, mContext, datas) {
            @Override
            protected void convert(final ViewHolder holder, final AppGetMyMemberCardListBean.RowsBean.CardListBean dataBean, int position) {

                holder.setText(R.id.text_title, dataBean.getMemberCardTypeName());
                if (!dataBean.getImageURL().equals("")) {

                    loadBgImg(mContext, dataBean.getImageURL(),R.mipmap.img_bg_list,  (ImageView) holder.getView(R.id.img_bg));
                    holder.getView(R.id.img_bg).setVisibility(View.VISIBLE);
                } else {
                    holder.getView(R.id.img_bg).setVisibility(View.GONE);
                }
                holder.setText(R.id.text_type, mTypeList[dataBean.getStatus()]);

                holder.getView(R.id.btn1).setVisibility(dataBean.getIsAllowUp()==1?View.VISIBLE:View.GONE);
                holder.getView(R.id.btn2).setVisibility(dataBean.getIsAllowLock()==1?View.VISIBLE:View.GONE);
                holder.getView(R.id.btn3).setVisibility(dataBean.getIsAllowAddFee()==1?View.VISIBLE:View.GONE);
                holder.getView(R.id.btn4).setVisibility(dataBean.getIsEvaluate()==1?View.VISIBLE:View.GONE);


                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = null;

                        switch (dataBean.getStatus()) {

                            case 0:
                                //未开卡
                                intent = new Intent(context, MyPrivateDetailsActivatedActivity.class);
                                break;
                            case 1:
                                //已开卡
                                intent = new Intent(context, MyPrivateDetailsStaleActivity.class);
                                break;
                            case 2:
                                //已冻结
                                break;
                            case 3:
                                //已到期
                                break;
                            case 4:
                                //作废
                                intent = new Intent(context, MyPrivateDetailsNonactivatedActivity.class);
                                break;
                            case 5:
                                //冻结申请
                                intent = new Intent(context, MyPrivateDetailsRefundingActivity.class);
                                break;
                            case 6:
                                //未激活
                                intent = new Intent(context, MyPrivateDetailsRefundedActivity.class);
                                break;
                            case 7:
                                //退款申请中
                                intent = new Intent(context, MyPrivateDetailsRefundedActivity.class);
                                break;
                            case 8:
                                //已退款
                                intent = new Intent(context, MyPrivateDetailsRefundedActivity.class);
                                break;
                        }
//
//                        intent.putExtra(PUT_STR + "id", dataBean.getId());
//                        intent.putExtra(PUT_STR + "Status", dataBean.getStatus());
//                        startActivity(intent);

                    }
                });


            }
        };

        commonAdapter.setShowFooter(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager( linearLayoutManager );

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
                      if (isLoadingMore && totalItemCount-1 <= lastVisubleItem && dy > 0) {
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
        mPresenter.appGetMyMemberCardList(String.valueOf(UserId),
                ClubId, token, Page
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
    public void succeed(AppGetMyMemberCardListBean appGetMyMemberCardListBean) {

        swipeRefreshLayout.setRefreshing(false);
        if (appGetMyMemberCardListBean.getRows().getCardList().size() != 0) {
            datas = appGetMyMemberCardListBean.getRows().getCardList();
            commonAdapter.replaceData(datas);
            isLoadingMore = true;

        }
    }


}


