package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C2;

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
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.DetailsActivated.MyPrivateDetailsActivatedActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.MyPrivateRenewal.MyPrivateRenewalActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListActivedBean;
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
 * 我的私教课  已激活
 */

@RuntimePermissions
public class IndexFragMentCP2 extends BaseFragment<IndexFragMentCP2Presenter> implements IndexFragMentCP2Contract.View {


    //    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    //    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.text_noMore)
    TextView textNoMore;
    Unbinder unbinder;


    private CommonAdapter<AppGetMyMemberLessonListActivedBean.RowsBean.MyLessonListBean> commonAdapter;
    private List<AppGetMyMemberLessonListActivedBean.RowsBean.MyLessonListBean> datas = new ArrayList<AppGetMyMemberLessonListActivedBean.RowsBean.MyLessonListBean>();
    String[] mTypeList = {"有效", "已到期", "已转让", "作废", "是啥", "这啥", "弄啥"};
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
                initList();
                refresh();
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
        commonAdapter = new CommonAdapter<AppGetMyMemberLessonListActivedBean.RowsBean.MyLessonListBean>(R.layout.cardview_member_my_card, mContext, datas) {
            @Override
            protected void convert(final ViewHolder holder, final AppGetMyMemberLessonListActivedBean.RowsBean.MyLessonListBean dataBean, int position) {

                holder.setText(R.id.text_title, dataBean.getLessonName());
                if (!dataBean.getImageURL().equals("")) {
                    loadBgImg(mContext, dataBean.getImageURL(), R.mipmap.img_bg_list, (ImageView) holder.getView(R.id.img_bg));
                }
                final TextView btn1 = (TextView) holder.getView(R.id.btn1);
                final TextView btn2 = (TextView) holder.getView(R.id.btn2);
                final TextView btn3 = (TextView) holder.getView(R.id.btn3);
                final TextView btn4 = (TextView) holder.getView(R.id.btn4);
                final TextView btn5 = (TextView) holder.getView(R.id.btn5);
                holder.setText(R.id.text_type, "已激活");
                switch (dataBean.getStatus()) {
                    case 0:
                        btn1.setText("续费");
                        btn2.setVisibility(View.GONE);
                        btn3.setVisibility(View.GONE);
                        btn4.setVisibility(View.GONE);
                        btn5.setVisibility(View.GONE);
                        btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(mContext, MyPrivateRenewalActivity.class);
                                intent.putExtra(PUT_STR + "MemberLessonTypeId", dataBean.getId());
                                intent.putExtra(PUT_STR + "LessonName", dataBean.getLessonName());
                                intent.putExtra(PUT_STR + "AddFeeMinAmount", dataBean.getOnlineAddFeeMinAmount());
                                intent.putExtra(PUT_STR + "LessonId", dataBean.getLessonId());
                                startActivity(intent);
                            }
                        });
                        break;
                    case 1:
                        btn1.setText("删除");
                        btn2.setVisibility(View.GONE);
                        btn3.setVisibility(View.GONE);
                        btn4.setVisibility(View.GONE);
                        btn5.setVisibility(View.GONE);
                        break;
                    case 2:
                        btn1.setVisibility(View.GONE);
                        btn2.setVisibility(View.GONE);
                        btn3.setVisibility(View.GONE);
                        btn4.setVisibility(View.GONE);
                        btn5.setVisibility(View.GONE);
                        break;
                    case 3:
                        btn1.setVisibility(View.GONE);
                        btn2.setVisibility(View.GONE);
                        btn3.setVisibility(View.GONE);
                        btn4.setVisibility(View.GONE);
                        btn5.setVisibility(View.GONE);
                        break;
                    case 4:
                        btn1.setText("退款");
                        btn2.setVisibility(View.GONE);
                        btn3.setVisibility(View.GONE);
                        btn4.setVisibility(View.GONE);
                        btn5.setVisibility(View.GONE);
                        break;
                    case 5:
                        btn1.setVisibility(View.GONE);
                        btn2.setVisibility(View.GONE);
                        btn3.setVisibility(View.GONE);
                        btn4.setVisibility(View.GONE);
                        btn5.setVisibility(View.GONE);
                        break;
                    case 6:
                        btn1.setVisibility(View.GONE);
                        btn2.setVisibility(View.GONE);
                        btn3.setVisibility(View.GONE);
                        btn4.setVisibility(View.GONE);
                        btn5.setVisibility(View.GONE);
                        break;
                }
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, MyPrivateDetailsActivatedActivity.class);
                        intent.putExtra(PUT_STR + "id", dataBean.getId());
                        intent.putExtra(PUT_STR + "Status", String.valueOf(dataBean.getStatus()));
                        intent.putExtra(PUT_STR + "OrderId", String.valueOf(dataBean.getOrderId()));
                        intent.putExtra(PUT_STR + "LessonId", dataBean.getLessonId());
                        intent.putExtra(PUT_STR + "AddFeeMinAmount", dataBean.getOnlineAddFeeMinAmount());
                        intent.putExtra(PUT_STR + "type", 0);
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
        mPresenter.appGetMyMemberLessonListActived(String.valueOf(UserId),
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
    public void succeed(AppGetMyMemberLessonListActivedBean appGetMyMemberLessonListActivedBean) {

        swipeRefreshLayout.setRefreshing(false);
        if (appGetMyMemberLessonListActivedBean.getRows().getMyLessonList().size() != 0) {
            datas = appGetMyMemberLessonListActivedBean.getRows().getMyLessonList();
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
            textNoMore.setText("当前暂无已激活私教课信息");
        }
    }


    @NeedsPermission(Manifest.permission.CAMERA)
    void Scan() {

        Intent intent = new Intent(mContext, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);

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

