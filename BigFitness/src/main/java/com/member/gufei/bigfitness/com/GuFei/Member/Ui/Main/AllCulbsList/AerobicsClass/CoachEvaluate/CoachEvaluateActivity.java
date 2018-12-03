package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.AerobicsClass.CoachEvaluate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubTeacherEvaluateListBean;
import com.member.gufei.bigfitness.util.MyRatingBar;
import com.member.gufei.bigfitness.util.ProgressBar.ProgressBar;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.LoadImage.loadBgImg;
import static com.member.gufei.bigfitness.util.LoadImage.loadImgForRadius;

/*
* 教练评价
*
* */
public class CoachEvaluateActivity extends BaseActivity<CoachEvaluateActivityPresenter> implements CoachEvaluateActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ProgressBar_1)
    LinearLayout progressBar1;
    @BindView(R.id.ProgressBar_2)
    LinearLayout progressBar2;
    @BindView(R.id.ProgressBar_3)
    LinearLayout progressBar3;
    @BindView(R.id.ProgressBar_4)
    LinearLayout progressBar4;
    @BindView(R.id.ProgressBar_5)
    LinearLayout progressBar5;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.text_name_5)
    TextView textName5;
    @BindView(R.id.text_number_5)
    TextView textNumber5;
    @BindView(R.id.text_name_4)
    TextView textName4;
    @BindView(R.id.text_number_4)
    TextView textNumber4;
    @BindView(R.id.text_name_3)
    TextView textName3;
    @BindView(R.id.text_number_3)
    TextView textNumber3;
    @BindView(R.id.text_name_2)
    TextView textName2;
    @BindView(R.id.text_number_2)
    TextView textNumber2;
    @BindView(R.id.text_name_1)
    TextView textName1;
    @BindView(R.id.text_number_1)
    TextView textNumber1;
    @BindView(R.id.btn_all_evaluate)
    TextView btnAllEvaluate;
    @BindView(R.id.layout_top)
    LinearLayout layoutTop;
    @BindView(R.id.img_number_star)
    MyRatingBar imgNumberStar;
    @BindView(R.id.text_number_total)
    TextView textNumberTotal;
    @BindView(R.id.text_num_evaluate)
    TextView textNumEvaluate;

    private CommonAdapter<ClubTeacherEvaluateListBean.RowsBean> commonAdapter;
    private List<ClubTeacherEvaluateListBean.RowsBean> datas = new ArrayList<ClubTeacherEvaluateListBean.RowsBean>();

    private boolean isLoadingMore = true;//加载标志位
    private int Page = 1;
    private boolean mLoading = false;
    private int mStar = 0;
    private int TotalPage;


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_cocah_evaluate_list;
    }

    @Override
    protected void initView() {

//        btnLeft.setImageResource(R.mipmap.more_img);
//
//        btnRight.setImageResource(R.mipmap.scan_img);


        toolbar.setNavigationIcon(R.mipmap.back);
        setToolBar(toolbar, "");
        tvTitle.setText("教练评价");

        btnComplete.setVisibility(View.INVISIBLE);

        datas = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            PublicSeaBean.ResultBean bean = new PublicSeaBean.ResultBean();
//
//            datas.add(bean);
//
//        }
        commonAdapter = new CommonAdapter<ClubTeacherEvaluateListBean.RowsBean>(R.layout.cardview_member_ecaluate, mContext, datas) {
            /**
             * @param holder   holder对象
             * @param dataBean
             * @param position 位置
             */
            @Override
            protected void convert(ViewHolder holder, final ClubTeacherEvaluateListBean.RowsBean dataBean, int position) {
                MyRatingBar myRatingBar = (MyRatingBar) holder.getView(R.id.img_number_star);
                myRatingBar.setStar(dataBean.getEvaluateStar());

                holder.getView(R.id.img_1).setVisibility(View.GONE);
                holder.getView(R.id.img_2).setVisibility(View.GONE);
                holder.getView(R.id.img_3).setVisibility(View.GONE);

                loadImgForRadius(mContext, dataBean.getHeaderURL(), R.mipmap.head_img, (ImageView)  holder.getView(R.id.img_head));

                holder.setText(R.id.text_name_leave, dataBean.getNickName());
                holder.setText(R.id.text_time_leave, "于" + dataBean.getCreateTime());
                holder.setText(R.id.text_content_leave, dataBean.getEvaluateContent());

                if (!dataBean.getImageURLList().equals("")) {
                    String[] temp = null;
                    if (dataBean.getImageURLList().indexOf(",") != -1) {
                        temp = dataBean.getImageURLList().split(",");
                    } else {
                        temp= new String[]{dataBean.getImageURLList().toString()};
                    }
                    for (int i = 0; i < temp.length; i++) {
                        try {
                            ImageView imageView = (ImageView) holder.getView((R.id.class.getDeclaredField("img_" + (i + 1)).getInt(null)));
                            loadBgImg(mContext, temp[i], R.mipmap.null_img, imageView);

                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        }
                    }

                }


            }
        };
        LinearLayoutManager LayoutManager = new LinearLayoutManager(mContext);
//        LayoutManager.setAutoMeasureEnabled(true);

        recyclerView.setLayoutManager(LayoutManager);
        recyclerView.setAdapter(commonAdapter);

//        commonAdapterMy.setShowFooter(false);
        commonAdapter.setShowFooter(false);


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
        mLoading = true;
        getList();
    }

    private void refresh() {
        Page = 1;
        getList();
    }

    private void getList() {
        if (mStar!=0){
            btnAllEvaluate.setText("显示所有评价");
            btnAllEvaluate.setTextColor(getResources().getColor(R.color.green_btn));

        }
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        Intent intent = getIntent();
        int TeacherId = intent.getIntExtra(PUT_STR + "TeacherId", 0);
        String Clubid = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        // TODO: 2018/4/3  Clubid   坐标等是假定数据
        mPresenter.getClubTeacherEvaluateList(String.valueOf(UserId),
                token, Clubid, Page, String.valueOf(TeacherId), mStar
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
    public void succeed(ClubTeacherEvaluateListBean clubTeacherEvaluateListBean) {
        TotalPage = clubTeacherEvaluateListBean.getTotalPage();
        ProgressBar childBar1 = new ProgressBar(mContext,
                GetcClculate(clubTeacherEvaluateListBean.getStarTotal().getOneStartCount(), clubTeacherEvaluateListBean.getStarTotal().getTotalEvalCount()));
        progressBar1.addView(childBar1);

        ProgressBar childBar2 = new ProgressBar(mContext,
                GetcClculate(clubTeacherEvaluateListBean.getStarTotal().getTwoStartCount(), clubTeacherEvaluateListBean.getStarTotal().getTotalEvalCount()));
        progressBar2.addView(childBar2);

        ProgressBar childBar3 = new ProgressBar(mContext,
                GetcClculate(clubTeacherEvaluateListBean.getStarTotal().getThreeStartCount(), clubTeacherEvaluateListBean.getStarTotal().getTotalEvalCount()));
        progressBar3.addView(childBar3);

        ProgressBar childBar4 = new ProgressBar(mContext,
                GetcClculate(clubTeacherEvaluateListBean.getStarTotal().getFourStartCount(), clubTeacherEvaluateListBean.getStarTotal().getTotalEvalCount()));
        progressBar4.addView(childBar4);

        ProgressBar childBar5 = new ProgressBar(mContext,
                GetcClculate(clubTeacherEvaluateListBean.getStarTotal().getFiveStartCount(), clubTeacherEvaluateListBean.getStarTotal().getTotalEvalCount()));
        progressBar5.addView(childBar5);


        textNumber5.setText(clubTeacherEvaluateListBean.getStarTotal().getFiveStartCount() + "");
        textNumber4.setText(clubTeacherEvaluateListBean.getStarTotal().getFourStartCount() + "");
        textNumber3.setText(clubTeacherEvaluateListBean.getStarTotal().getThreeStartCount() + "");
        textNumber2.setText(clubTeacherEvaluateListBean.getStarTotal().getTwoStartCount() + "");
        textNumber1.setText(clubTeacherEvaluateListBean.getStarTotal().getOneStartCount() + "");

        String NumEvaText = "";
        switch (mStar) {
            case 1:
                NumEvaText = "(" + mStar + "星),共" + clubTeacherEvaluateListBean.getStarTotal().getOneStartCount() + "条";
                break;
            case 2:
                NumEvaText = "(" + mStar + "星),共" + clubTeacherEvaluateListBean.getStarTotal().getTwoStartCount() + "条";
                break;
            case 3:
                NumEvaText = "(" + mStar + "星),共" + clubTeacherEvaluateListBean.getStarTotal().getThreeStartCount() + "条";
                break;
            case 4:
                NumEvaText = "(" + mStar + "星),共" + clubTeacherEvaluateListBean.getStarTotal().getFourStartCount() + "条";
                break;
            case 5:
                NumEvaText = "(" + mStar + "星),共" + clubTeacherEvaluateListBean.getStarTotal().getFiveStartCount() + "条";
                break;
        }
        textNumEvaluate.setText(NumEvaText);
        textNumberTotal.setText(clubTeacherEvaluateListBean.getStarTotal().getTotalEvalCount() + "人");

        imgNumberStar.setStar((float) clubTeacherEvaluateListBean.getStarTotal().getAvgStarLevel());


        swipeRefreshLayout.setRefreshing(false);
        if (clubTeacherEvaluateListBean.getRows().size() != 0) {
            datas = clubTeacherEvaluateListBean.getRows();
            if (Page == 1) {
                commonAdapter.replaceData(datas);
            } else {
                commonAdapter.insertData(datas);
            }
            isLoadingMore = true;

        }
    }


    public float GetcClculate(float i, float j) {
        return i / j;
    }


    @SuppressLint("ResourceAsColor")
    @OnClick({R.id.ProgressBar_5, R.id.ProgressBar_4, R.id.ProgressBar_3, R.id.ProgressBar_2, R.id.ProgressBar_1, R.id.btn_all_evaluate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ProgressBar_5:
                mStar = 5;
                break;
            case R.id.ProgressBar_4:
                mStar = 4;
                break;
            case R.id.ProgressBar_3:
                mStar = 3;
                break;
            case R.id.ProgressBar_2:
                mStar = 2;
                break;
            case R.id.ProgressBar_1:
                mStar = 1;
                break;
            case R.id.btn_all_evaluate:
                if (btnAllEvaluate.getText().equals("显示所有评价"))
                {
                    btnAllEvaluate.setText("所有评价");

                    btnAllEvaluate.setTextColor(getResources().getColor(R.color.white));
                    mStar = 0;
                }

                break;
        }

        refresh();
    }


}
