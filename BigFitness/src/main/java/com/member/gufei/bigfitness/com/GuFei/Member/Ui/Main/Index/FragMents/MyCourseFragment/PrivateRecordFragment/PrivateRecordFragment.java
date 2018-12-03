package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyCourseFragment.PrivateRecordFragment;

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
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCourseList.SchoolRecordsList.SchoolRecordsListActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClassLessonListBean;
import com.member.gufei.bigfitness.util.SpUtil;
import com.uuzuche.lib_zxing.activity.CaptureActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

import static com.member.gufei.bigfitness.Constants.MEMBERIDKEY;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.RESULT_ID;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.LoadImage.loadBgImg;

/**
 * Created by GuFei_lyf on 2017/3/22
 * <p>
 * 我的上课列表-私教课
 */

@RuntimePermissions
public class PrivateRecordFragment extends BaseFragment<PrivateRecordFragmentPresenter> implements PrivateRecordFragmentContract.View {


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


    private CommonAdapter<ClassLessonListBean.RowsBean> commonAdapter;
    private List<ClassLessonListBean.RowsBean> datas = new ArrayList<ClassLessonListBean.RowsBean>();
    private int Page;
    private boolean isLoadingMore = true;//加载标志位


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

        datas = new ArrayList<>();

        commonAdapter = new CommonAdapter<ClassLessonListBean.RowsBean>(R.layout.cardview_member_index_fragment_private, mContext, datas) {
            @Override
            protected void convert(ViewHolder holder, final ClassLessonListBean.RowsBean dataBean, int position) {

                holder.setText(R.id.text_title, dataBean.getLessonName());
                loadBgImg(mContext, dataBean.getImageURL(), R.mipmap.img_bg_list, (ImageView) holder.getView(R.id.img_bg));

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Intent mDetailsActivity = new Intent(mContext, SchoolRecordsListActivity.class);
                        mDetailsActivity.putExtra(PUT_STR + "LessonId", String.valueOf(dataBean.getLessonId()));
                        mDetailsActivity.putExtra(PUT_STR + "LessonName", dataBean.getLessonName());
                        mDetailsActivity.putExtra(PUT_STR + "ComeLogId", dataBean.getComeLogId());
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
        String MemberId = (String) SpUtil.get(mContext, MEMBERIDKEY, "");

        mPresenter.getClassLessonList(String.valueOf(UserId),
                ClubId, token, Page, Integer.parseInt(MemberId)
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
    public void succeed(ClassLessonListBean classLessonListBean) {
        swipeRefreshLayout.setRefreshing(false);
        datas = classLessonListBean.getRows();
        isLoadingMore = true;
        if (classLessonListBean.getRows().size() == 0) {
            textNoMore.setVisibility(View.VISIBLE);
            textNoMore.setText("当前暂无上课记录");
        }else {
            if (Page == 1) {

                commonAdapter.replaceData(datas);
            } else {

                commonAdapter.insertData(datas);
            }
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

