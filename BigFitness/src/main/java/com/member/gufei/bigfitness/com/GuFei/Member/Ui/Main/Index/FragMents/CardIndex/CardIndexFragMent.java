package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.CardIndex;

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
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.BuyCard.NumberCard.NumberCardForBuy.NumberCardForBuyActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.BuyCard.TimeCard.TimeCardForBuy.TimeCardForBuyActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubOnlineSaleMemberCardListBean;
import com.member.gufei.bigfitness.util.SpUtil;
import com.uuzuche.lib_zxing.activity.CaptureActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.LoadImage.loadBgImg;

/**
 * Created by GuFei_lyf on 2017/3/22
 * <p>
 * 实际业务人员主页
 */

@RuntimePermissions
public class CardIndexFragMent extends BaseFragment<CardIndexFragMentPresenter> implements CardIndexFragMentContract.View {


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


    private CommonAdapter<ClubOnlineSaleMemberCardListBean.RowsBean> commonAdapter;
    private List<ClubOnlineSaleMemberCardListBean.RowsBean> datas = new ArrayList<ClubOnlineSaleMemberCardListBean.RowsBean>();

    String[] mTypeList = {"有效", "已到期", "已转让", "作废", "未激活", "退款申请", "已退款"};
    private boolean isLoadingMore = true;//加载标志位
    private int Page = 1;
    private boolean mFirstShow = true;
    private boolean mLodEnd = false;
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
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (!mFirstShow && mLodEnd) {
                refresh();
            }

            //相当于Fragment的onResume

        } else {
            //相当于Fragment的onPause

        }
    }


    @Override
    protected void initData() {

//        TextView textView = (TextView) viewContent.findViewById(R.id.tv_content);
//        textView.setText(this.mTitle);
//        initList();
        datas = new ArrayList<>();
        refresh();

    }

    public void initList() {

//        TextView textView = (TextView) viewContent.findViewById(R.id.tv_content);
//        textView.setText(this.mTitle);


//        for (int i = 0; i < 5; i++) {
//            Schedule.ResultBean.DataBean bean = new Schedule.ResultBean.DataBean();
//            datas.add(bean);
//        }
        commonAdapter = new CommonAdapter<ClubOnlineSaleMemberCardListBean.RowsBean>(R.layout.cardview_member_buy_card, mContext, datas) {
            @Override
            protected void convert(final ViewHolder holder, final ClubOnlineSaleMemberCardListBean.RowsBean dataBean, int position) {

                holder.setText(R.id.text_title, (dataBean.getConsumeType() == 1 ? "时卡: " : "次卡: ") + dataBean.getMemberCardTypeName());
//                if (!dataBean.getImageURL().equals("")) {

                loadBgImg(mContext, dataBean.getImageURL(), R.mipmap.img_bg_list, (ImageView) holder.getView(R.id.img_bg));
                holder.getView(R.id.img_bg).setVisibility(View.VISIBLE);
//                } else {
//                    holder.getView(R.id.img_bg).setVisibility(View.GONE);
//                }
                if (dataBean.getIsbuy() == 0) {
                    holder.getView(R.id.text_type).setVisibility(View.INVISIBLE);

                } else {
                    holder.getView(R.id.text_type).setVisibility(View.VISIBLE);

                }


                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = null;

                        switch (dataBean.getConsumeType()) {

                            case 0:
                                //次卡
                                intent = new Intent(context, NumberCardForBuyActivity.class);
                                break;
                            case 1:
                                //时卡
                                intent = new Intent(context, TimeCardForBuyActivity.class);
                                break;
                        }
//
                        intent.putExtra(PUT_STR + "ConsumeType", String.valueOf(dataBean.getConsumeType()));
                        intent.putExtra(PUT_STR + "MemberCardTypeId", String.valueOf(dataBean.getMembercardtypeid()));
//                        intent.putExtra(PUT_STR + "Status", dataBean.g());
                        startActivity(intent);

                    }
                });


            }

        };

        commonAdapter.setShowFooter(false);
        commonAdapter.setShowdiy(false);
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
                    if (Page >= TotalPage) {
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
        mPresenter.getClubOnlineSaleMemberCardList(String.valueOf(UserId),
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


    @Override
    public void succeed(ClubOnlineSaleMemberCardListBean clubOnlineSaleMemberCardListBean) {
        initList();
        swipeRefreshLayout.setRefreshing(false);
        TotalPage = clubOnlineSaleMemberCardListBean.getTotalPage();
        if (clubOnlineSaleMemberCardListBean.getRows().size() != 0) {
            textNoMore.setVisibility(View.GONE);
            datas = clubOnlineSaleMemberCardListBean.getRows();
            if (Page == 1) {
                commonAdapter.replaceData(datas);
            } else {
                commonAdapter.insertData(datas);
            }
            isLoadingMore = true;
            mFirstShow = false;
            mLodEnd = true;
        }else {
            textNoMore.setVisibility(View.VISIBLE);
            textNoMore.setText("暂无会员卡信息");
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

