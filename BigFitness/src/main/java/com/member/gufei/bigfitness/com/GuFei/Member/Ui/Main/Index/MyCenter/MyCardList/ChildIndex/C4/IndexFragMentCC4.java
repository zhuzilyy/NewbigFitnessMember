package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.ChildIndex.C4;

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
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.Active.DetailsActive.MyCardDetailsActiveActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.Active.DetailsActive.NumberCard.MyCardNumberCardActiveActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.Active.DetailsExpiration.MyCardDetailsExpirationActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.Active.DetailsFrozen.MyCardDetailsFrozenActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.Active.DetailsFrozening.MyCardDetailsFrozeningActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.NoActive.DetailsNotActive.MyCardDetailsNotActiveActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.NoActive.DetailsRefunded.MyCardDetailsDetailsRefundedActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.NoActive.DetailsRefunding.MyCardDetailsRefundingActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListRefundedBean;
import com.member.gufei.bigfitness.util.SpUtil;
import com.uuzuche.lib_zxing.activity.CaptureActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

import static com.member.gufei.bigfitness.Constants.MYCARDTYPE;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.LoadImage.loadBgImg;

/**
 * Created by GuFei_lyf on 2017/3/22
 * <p>
 * 我的会员卡 已退款
 */

@RuntimePermissions
public class IndexFragMentCC4 extends BaseFragment<IndexFragMentCC4Presenter> implements IndexFragMentCC4Contract.View {


    //    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    //    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.tv_noMore)
    TextView tvNoMore;
    Unbinder unbinder;


    private CommonAdapter<AppGetMyMemberCardListRefundedBean.RowsBean.NotActivedListBean> commonAdapter;
    private List<AppGetMyMemberCardListRefundedBean.RowsBean.NotActivedListBean> datas = new ArrayList<AppGetMyMemberCardListRefundedBean.RowsBean.NotActivedListBean>();
    private boolean isLoadingMore = true;//加载标志位
    private int Page = 1;
    private boolean mFirstShow = true;
    private boolean mLodEnd = false;


    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);


    }


    @Override
    protected void initInject() {

        getFragmentComponent().inject(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.member_fragment_index_c3;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (!mFirstShow && mLodEnd) {
//                initList();
//                refresh();
            }

            //相当于Fragment的onResume

        } else {
            //相当于Fragment的onPause

        }
    }


    @Override
    protected void initData() {
        initList();
        datas = new ArrayList<>();
        refresh();

    }

    public void initList() {
        recyclerView = (RecyclerView) mView.findViewById(R.id.recyclerviewid);
        swipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.swiperefreshlayoutid);
        commonAdapter = new CommonAdapter<AppGetMyMemberCardListRefundedBean.RowsBean.NotActivedListBean>(R.layout.cardview_member_my_card, mContext, datas) {
            @Override
            protected void convert(final ViewHolder holder, final AppGetMyMemberCardListRefundedBean.RowsBean.NotActivedListBean dataBean, int position) {
                holder.setText(R.id.text_title, dataBean.getMemberCardTypeName());
//                if (!dataBean.getImageURL().equals("")) {
                loadBgImg(mContext, dataBean.getImageURL(), R.mipmap.img_bg_list, (ImageView) holder.getView(R.id.img_bg));
//                    holder.getView(R.id.img_bg).setVisibility(View.VISIBLE);
//                } else {
//                    holder.getView(R.id.img_bg).setVisibility(View.GONE);
//                }
                holder.setText(R.id.text_type, MYCARDTYPE[dataBean.getSTATUS()]);

                holder.getView(R.id.btn1).setVisibility(dataBean.getIsAllowUp() == 1 ? View.VISIBLE : View.GONE);
                holder.getView(R.id.btn2).setVisibility(dataBean.getIsAllowLock() == 1 ? View.VISIBLE : View.GONE);
                holder.getView(R.id.btn3).setVisibility(dataBean.getIsAllowAddFeem() == 1 ? View.VISIBLE : View.GONE);
                holder.getView(R.id.btn4).setVisibility(dataBean.getIsEvaluate() == 1 ? View.VISIBLE : View.GONE);


                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = null;

                        switch (dataBean.getSTATUS()) {

                            case 0:
                                //未开卡
                                intent = new Intent(context, MyCardDetailsNotActiveActivity.class);
                                break;
                            case 1:
                                //已开卡
                                if (dataBean.getConsumeType() == 0) {
                                    intent = new Intent(context, MyCardNumberCardActiveActivity.class);
                                } else if (dataBean.getConsumeType() == 1) {
                                    intent = new Intent(context, MyCardDetailsActiveActivity.class);
                                }

                                break;
                            case 2:
                                //已冻结
                                intent = new Intent(context, MyCardDetailsFrozenActivity.class);
                                break;
                            case 3:
                                //已到期
                                intent = new Intent(context, MyCardDetailsExpirationActivity.class);


                                break;
                            case 4:
                                //作废
                                intent = new Intent(context, MyCardDetailsExpirationActivity.class);
                                break;
                            case 5:
                                //冻结申请
                                intent = new Intent(context, MyCardDetailsFrozeningActivity.class);

                                break;
                            case 6:
                                //未激活
                                intent = new Intent(context, MyCardDetailsNotActiveActivity.class);
                                break;
                            case 7:
                                //退款申请中
                                intent = new Intent(context, MyCardDetailsRefundingActivity.class);
                                break;
                            case 8:
                                //已退款
                                intent = new Intent(context, MyCardDetailsDetailsRefundedActivity.class);
                                break;
                        }
//
                        intent.putExtra(PUT_STR + "Id", dataBean.getOrderId());
                        intent.putExtra(PUT_STR + "ConsumeType", String.valueOf(dataBean.getConsumeType()));
                        intent.putExtra(PUT_STR + "MemberCardId", String.valueOf(dataBean.getMemberCardId()));
                        intent.putExtra(PUT_STR + "Status", String.valueOf(dataBean.getSTATUS()));
                        startActivity(intent);

                    }
                });


            }
        };

        commonAdapter.setShowFooter(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
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
                    if (isLoadingMore && totalItemCount - 1 <= lastVisubleItem && dy > 0) {
                        isLoadingMore = false;
                        loading();
                    }
                }
            });

        }


    }


    private void loading() {
        Page++;
        mLodEnd = false;
        getList();
    }

    private void refresh() {
        Page = 1;
        mLodEnd = false;
        getList();
    }

    private void getList() {
//        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        mPresenter.appGetMyMemberCardListRefunded(String.valueOf(UserId),
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


    @NeedsPermission(Manifest.permission.CAMERA)
    void Scan() {

        Intent intent = new Intent(mContext, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);

    }

    protected void onVisible() {
        getList();
    }

    @Override
    public void succeed(AppGetMyMemberCardListRefundedBean appGetMyMemberCardListRefundedBean) {

        swipeRefreshLayout.setRefreshing(false);
        if (appGetMyMemberCardListRefundedBean.getRows().getNotActivedList().size() != 0) {
            datas = appGetMyMemberCardListRefundedBean.getRows().getNotActivedList();
            tvNoMore.setVisibility(View.GONE);
            if (Page == 1) {
                commonAdapter.replaceData(datas);
                commonAdapter.notifyDataSetChanged();
            } else {
                commonAdapter.insertData(datas);
                commonAdapter.notifyDataSetChanged();
            }
            isLoadingMore = true;
            mFirstShow = false;
            mLodEnd = true;
        }else {
            tvNoMore.setVisibility(View.VISIBLE);
            tvNoMore.setText("当前暂无已退款信息");
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

