package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.ChildIndex.C2;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseFragment;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.CardEvaluationing.CardEvaluationingActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.Active.DetailsActive.MyCardDetailsActiveActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.Active.DetailsActive.NumberCard.MyCardNumberCardActiveActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.Active.DetailsExpiration.MyCardDetailsExpirationActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.Active.DetailsFrozen.MyCardDetailsFrozenActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.Active.DetailsFrozening.MyCardDetailsFrozeningActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.NoActive.DetailsNotActive.MyCardDetailsNotActiveActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.NoActive.DetailsRefunded.MyCardDetailsDetailsRefundedActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.Details.NoActive.DetailsRefunding.MyCardDetailsRefundingActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.FrozenCard.FrozenCardActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.NumberCard.Renewal.MyCardRenewalActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.UpGradeCard.UpGradeCardActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListActivedBean;
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
import static com.member.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 * <p>
 * 我的会员卡 已认证
 */

@RuntimePermissions
public class IndexFragMentCC2 extends BaseFragment<IndexFragMentCC2Presenter> implements IndexFragMentCC2Contract.View {


    //    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    //    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.text_noMore)
    TextView textNoMore;
    Unbinder unbinder;


    private CommonAdapter<AppGetMyMemberCardListActivedBean.RowsBean.ActivedListBean> commonAdapter;
    private List<AppGetMyMemberCardListActivedBean.RowsBean.ActivedListBean> datas = new ArrayList<AppGetMyMemberCardListActivedBean.RowsBean.ActivedListBean>();

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
        return R.layout.member_fragment_index_c2;
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

    protected void onHidden() {
        Log.e("fragment", "f2");
        getList();
    }

    public void initList() {
        recyclerView = (RecyclerView) mView.findViewById(R.id.recyclerviewid);
        swipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.swiperefreshlayoutid);
        commonAdapter = new CommonAdapter<AppGetMyMemberCardListActivedBean.RowsBean.ActivedListBean>(R.layout.cardview_member_my_card, mContext, datas) {
            @Override
            protected void convert(final ViewHolder holder, final AppGetMyMemberCardListActivedBean.RowsBean.ActivedListBean dataBean, int position) {

                holder.setText(R.id.text_title, dataBean.getMemberCardTypeName());
//                if (!dataBean.getImageURL().equals("")) {
                loadBgImg(mContext, dataBean.getImageURL(), R.mipmap.img_bg_list, (ImageView) holder.getView(R.id.img_bg));
//                }
                holder.setText(R.id.text_type, MYCARDTYPE[dataBean.getStatus()]);
                TextView btn1 = (TextView) holder.getView(R.id.btn1);
                TextView btn2 = (TextView) holder.getView(R.id.btn2);
                TextView btn3 = (TextView) holder.getView(R.id.btn3);
                TextView btn4 = (TextView) holder.getView(R.id.btn4);
                TextView btn5 = (TextView) holder.getView(R.id.btn5);
                btn1.setVisibility(dataBean.getIsAllowUp() == 1 ? View.VISIBLE : View.GONE);
                btn2.setVisibility(dataBean.getIsAllowLock() == 1 ? View.VISIBLE : View.GONE);
                btn3.setVisibility(dataBean.getIsAllowAddFee() == 1 ? View.VISIBLE : View.GONE);
                btn4.setVisibility(dataBean.getIsEvaluate() == 1 ? View.VISIBLE : View.GONE);

                if (dataBean.getConsumeType() == 0) {
                    btn1.setVisibility(View.GONE);
                    btn2.setVisibility(View.GONE);
                    btn3.setVisibility(View.GONE);
                    btn4.setVisibility(View.GONE);
                    btn5.setVisibility(View.GONE);
                }
                if (dataBean.getStatus() == 3) {
                    btn1.setVisibility(View.GONE);
                    btn2.setVisibility(View.GONE);
                    btn3.setVisibility(View.VISIBLE);
                    btn4.setVisibility(View.GONE);
                    btn5.setVisibility(View.GONE);
                }

                //升级
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Intent intent = new Intent(mContext, UpGradeCardActivity.class);
                        intent.putExtra(PUT_STR + "MemberCardId", String.valueOf(dataBean.getMemberCardId()));
                        intent.putExtra(PUT_STR + "ConsumeType", String.valueOf(dataBean.getConsumeType()));
                        intent.putExtra(PUT_STR + "MemberCardTypeName", dataBean.getMemberCardTypeName());
                        intent.putExtra(PUT_STR + "MemberCardTypeId", String.valueOf(dataBean.getMemberCardTypeId()));
                        intent.putExtra(PUT_STR + "ExpireTime", dataBean.getExpireTime());
                        intent.putExtra(PUT_STR + "Id", dataBean.getOrderId());
                        intent.putExtra(PUT_STR + "Status", String.valueOf(dataBean.getStatus()));

//                        ItmeIntent.putExtra(PUT_STR + "TimeExpire",textTimeEnd.getText());
                        // TODO: 2018/6/13  直跳升级卡页面 没有到期时间字段

                        startActivity(intent);
                    }
                });

                //冻结
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Intent intent = new Intent(mContext, FrozenCardActivity.class);

//                        intent.putExtra(PUT_STR + "NumberRemaining",textNumberRemaining.getText());
                        // TODO: 2018/6/13  直跳冻结卡页面 没有剩余次数

                        intent.putExtra(PUT_STR + "MemberCardId", String.valueOf(dataBean.getMemberCardId()));
                        intent.putExtra(PUT_STR + "MemberCardType", String.valueOf(dataBean.getConsumeType()));
                        intent.putExtra(PUT_STR + "MemberCardTypeName", dataBean.getMemberCardTypeName());
                        intent.putExtra(PUT_STR + "ExpireTime", dataBean.getExpireTime());
                        intent.putExtra(PUT_STR + "RemainLockedCount", dataBean.getRemainLockedCount());
                        intent.putExtra(PUT_STR + "Id", dataBean.getOrderId());
                        intent.putExtra(PUT_STR + "Status", String.valueOf(dataBean.getStatus()));

//                        intent.putExtra(PUT_STR + "TimeExpire",textTimeEnd.getText());
                        // TODO: 2018/6/13  直跳升级卡页面 没有到期时间字段

                        startActivity(intent);
                    }
                });

                //续费
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(mContext, MyCardRenewalActivity.class);

//                        intent.putExtra(PUT_STR + "NumberRemaining",textNumberRemaining.getText());
                        // TODO: 2018/6/13  续费 因为缺少区间 未完成

                        intent.putExtra(PUT_STR + "MemberCardId", String.valueOf(dataBean.getMemberCardId()));
                        intent.putExtra(PUT_STR + "MemberCardType", String.valueOf(dataBean.getMemberCardTypeId()));
                        intent.putExtra(PUT_STR + "ConsumeType", dataBean.getConsumeType());
                        intent.putExtra(PUT_STR + "MemberCardTypeName", dataBean.getMemberCardTypeName());
                        intent.putExtra(PUT_STR + "Id", dataBean.getOrderId());
                        intent.putExtra(PUT_STR + "ExpireTime", dataBean.getExpireTime());
                        intent.putExtra(PUT_STR + "RemainUseCount", dataBean.getRemainUseCount());
                        intent.putExtra(PUT_STR + "Status", String.valueOf(dataBean.getStatus()));
                        intent.putExtra(PUT_STR + "Minimum", dataBean.getOnlineAddFeeMinAmount());

//                        intent.putExtra(PUT_STR + "TimeExpire",textTimeEnd.getText());

                        startActivity(intent);
                    }
                });

                //评价
                btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, CardEvaluationingActivity.class);
                        intent.putExtra(PUT_STR + "MemberCardId", String.valueOf(dataBean.getMemberCardId()));
                        intent.putExtra(PUT_STR + "MemberCardType", String.valueOf(dataBean.getConsumeType()));
                        intent.putExtra(PUT_STR + "Id", dataBean.getOrderId());
                        intent.putExtra(PUT_STR + "Status", String.valueOf(dataBean.getStatus()));
                        startActivity(intent);

                    }
                });
//                btn5.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        ApplyRefundPopup(v,dataBean.getOrderId());
//
//                    }
//                });
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = null;

                        switch (dataBean.getStatus()) {

                            case 0:
                                //未开卡
                                intent = new Intent(context, MyCardDetailsNotActiveActivity.class);
                                break;
                            case 1:
                                //已开卡，0为次卡，1为时卡
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
                        intent.putExtra(PUT_STR + "MemberCardTypeId", String.valueOf(dataBean.getMemberCardTypeId()));
                        intent.putExtra(PUT_STR + "RemainUseCount", dataBean.getRemainUseCount());
                        intent.putExtra(PUT_STR + "Status", String.valueOf(dataBean.getStatus()));
                        intent.putExtra(PUT_STR + "Id", dataBean.getOrderId());
                        intent.putExtra(PUT_STR + "Minimum", dataBean.getOnlineAddFeeMinAmount());

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
        mPresenter.appGetMyMemberCardListActived(String.valueOf(UserId),
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
        s(getActivity(), "您的帐号在其他设备登录");
        Intent intent = new Intent(mContext, LoginActivity.class);
        startActivity(intent);
    }


    @Override
    public void Loading() {

    }

//    private Handler handler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what){   // 判断消息类型
//                // 根据消息类型对消息进行处理
//                // 可以接收 msg.arg1 , msg.arg2 , msg.obj
//                case 0:
//                    swipeRefreshLayout.setRefreshing(false);
//                    if (appGetMyMemberCardListBean1.getRows().getCardList().size() != 0) {
//                        datas = appGetMyMemberCardListBean1.getRows().getCardList();
//                        if (Page == 1) {
//                            commonAdapter.replaceData(datas);
//                            commonAdapter.notifyDataSetChanged();
//                        } else {
//                            commonAdapter.insertData(datas);
//                            commonAdapter.notifyDataSetChanged();
//                        }
//                        isLoadingMore = true;
//                        mFirstShow = false;
//                        mLodEnd = true;
//
//                    }
//                    break;
//            }
//        }
//    };
//    private AppGetMyMemberCardListBean appGetMyMemberCardListBean1=new AppGetMyMemberCardListBean();

    @NeedsPermission(Manifest.permission.CAMERA)
    void Scan() {

        Intent intent = new Intent(mContext, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);

    }


    @Override
    public void succeed(AppGetMyMemberCardListActivedBean appGetMyMemberCardListActivedBean) {

        swipeRefreshLayout.setRefreshing(false);
        if (appGetMyMemberCardListActivedBean.getRows().getActivedList().size() != 0) {
            datas = appGetMyMemberCardListActivedBean.getRows().getActivedList();
            textNoMore.setVisibility(View.GONE);
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
            textNoMore.setText("当前暂无已认证会员卡信息");
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

