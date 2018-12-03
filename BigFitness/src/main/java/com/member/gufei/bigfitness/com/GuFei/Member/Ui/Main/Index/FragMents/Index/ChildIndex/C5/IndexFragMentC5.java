package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseFragment;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.AerobicsClass.CoachDetails.CoachDetailsActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubTeacherDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubTeacherListBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

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


public class IndexFragMentC5 extends BaseFragment<IndexFragMentC5Presenter> implements IndexFragMentC5Contract.View {


    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.text_noMore)
    TextView textNoMore;
    Unbinder unbinder;

    private CommonAdapter<ClubTeacherListBean.RowsBean> commonAdapter;
    private List<ClubTeacherListBean.RowsBean> datas = new ArrayList<ClubTeacherListBean.RowsBean>();

    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private boolean isLoadingMore = true;//加载标志位
    private int Page = 1;
    private boolean mFirstShow = true;
    private boolean mLoading = false;
    private boolean mLodEnd = false;
    private int teacherId;
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
        //refresh();


    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
       /* if (isVisibleToUser) {
            if (!mFirstShow) {
                refresh();
            }

            //相当于Fragment的onResume

        } else {
            //相当于Fragment的onPause

        }*/
    }


    @Override
    protected void initInject() {

        getFragmentComponent().inject(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.member_fragment_index_c5;
    }


    @Override
    protected void initData() {
        datas = new ArrayList<>();
        refresh();


    }

    public void initList() {


        commonAdapter = new CommonAdapter<ClubTeacherListBean.RowsBean>(R.layout.cardview_member_index_fragmentc5, mContext, datas) {
            @Override
            protected void convert(final ViewHolder holder, final ClubTeacherListBean.RowsBean dataBean, int position) {

                holder.setText(R.id.text_title, dataBean.getTeacherName() + "/" + (dataBean.getSex() == 1 ? "男" : "女") + dataBean.getAge() + "岁");
                holder.setText(R.id.text_content, dataBean.getSpeciality());
                teacherId = dataBean.getTeacherId();
                loadBgImg(mContext, dataBean.getHeaderURL(), R.mipmap.card_img_null, (ImageView) holder.getView(R.id.img));


                try {
//                    Log.e("--------------------->","star_" + String.valueOf((int) dataBean.getEvaluateStar()));
                    holder.setImage(R.id.img_star).setImageResource(R.mipmap.class.getDeclaredField("star_" + String.valueOf((int) dataBean.getEvaluateStar())).getInt(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, CoachDetailsActivity.class);
//
//
////
                        intent.putExtra(PUT_STR + "TeacherId", dataBean.getTeacherId());
//                        intent.putExtra(PUT_STR + "ConsumeType", dataBean.getConsumeType());
//                        intent.putExtra(PUT_STR + "MemberCardId", dataBean.getMemberCardId());
//                        intent.putExtra(PUT_STR + "Status", dataBean.getStatus());
                        startActivity(intent);

                    }
                });


            }
        };

        commonAdapter.setShowFooter(false);
        //        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(commonAdapter);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        //解决列表左右位移的问题
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
//        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
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


        if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {


            //获取列表华东监听器 用于获取当前所在条数
            final StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();

//        添加滚动条见监听器
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                    super.onScrolled(recyclerView, dx, dy);

                    //总记录条数
                    //　int totalItemCount = linearLayoutManager.getItemCount();
                    int totalItemCount = recyclerView != null ? recyclerView.getAdapter().getItemCount() : 0;

                    //最后条数的位置
//                    int lastVisubleItem = linearLayoutManager.findLastVisibleItemPosition();

                    int[] lastItems = staggeredGridLayoutManager.findLastVisibleItemPositions(null);

                    int lastVisubleItem = Math.max(lastItems[0], lastItems[1]);


                    System.out.println("----------~~>" + dy + "");
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
        mPresenter.getClubTeacherList(String.valueOf(UserId),
                token, ClubId, Page
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
    public void succeed(ClubTeacherListBean clubTeacherListBean) {
        initList();
        swipeRefreshLayout.setRefreshing(false);
        TotalPage = clubTeacherListBean.getTotalPage();
        if (clubTeacherListBean.getRows().size() != 0) {
            textNoMore.setVisibility(View.GONE);
            datas = clubTeacherListBean.getRows();
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

class MyAdapters extends RecyclerView.Adapter<MyViewHolder> {


    private List<ClubTeacherDetailBean.RowsBean.LessonListBean> list;
    private Context context;

    public MyAdapters(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.cardview_member_details_coach, viewGroup, false);


        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.mText.setText(list.get(i).getLessonName());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView mText;

    MyViewHolder(View itemView) {
        super(itemView);
        mText = itemView.findViewById(R.id.text_class_3);
    }
}
