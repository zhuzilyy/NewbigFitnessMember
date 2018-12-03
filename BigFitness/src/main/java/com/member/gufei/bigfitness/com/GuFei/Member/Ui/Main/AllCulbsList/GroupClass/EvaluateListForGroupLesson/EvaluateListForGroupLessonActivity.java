package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.GroupClass.EvaluateListForGroupLesson;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubGroupLessonEvaluateListBean;

import com.member.gufei.bigfitness.util.MyRatingBar;
import com.member.gufei.bigfitness.util.ProgressBar.ProgressBar;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.LoadImage.loadBgImg;
import static com.member.gufei.bigfitness.util.LoadImage.loadImgForRadius;

public class EvaluateListForGroupLessonActivity extends BaseActivity<EvaluateListForGroupLessonActivityPresenter> implements EvaluateListForGroupLessonActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.ProgressBar_5)
    LinearLayout progressBar5;
    @BindView(R.id.btn_complete)
    Button btnComplete;


    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.img_number_star)
    MyRatingBar imgNumberStar;
    @BindView(R.id.text_number_total)
    TextView textNumberTotal;
    @BindView(R.id.text_name_5)
    TextView textName5;
    @BindView(R.id.text_number_5)
    TextView textNumber5;
    @BindView(R.id.text_name_4)
    TextView textName4;
    @BindView(R.id.ProgressBar_4)
    LinearLayout ProgressBar4;
    @BindView(R.id.text_number_4)
    TextView textNumber4;
    @BindView(R.id.text_name_3)
    TextView textName3;
    @BindView(R.id.ProgressBar_3)
    LinearLayout ProgressBar3;
    @BindView(R.id.text_number_3)
    TextView textNumber3;
    @BindView(R.id.text_name_2)
    TextView textName2;
    @BindView(R.id.ProgressBar_2)
    LinearLayout ProgressBar2;
    @BindView(R.id.text_number_2)
    TextView textNumber2;
    @BindView(R.id.text_name_1)
    TextView textName1;
    @BindView(R.id.ProgressBar_1)
    LinearLayout ProgressBar1;
    @BindView(R.id.text_number_1)
    TextView textNumber1;
    @BindView(R.id.btn_all_evaluate)
    TextView btnAllEvaluate;
    @BindView(R.id.layout_top)
    LinearLayout layoutTop;
    @BindView(R.id.rb_show)
    RadioButton rbShow;
    @BindView(R.id.text_num_evaluate)
    TextView textNumEvaluate;


    private CommonAdapter<ClubGroupLessonEvaluateListBean.RowsBean> commonAdapter;
    private List<ClubGroupLessonEvaluateListBean.RowsBean> datas = new ArrayList<ClubGroupLessonEvaluateListBean.RowsBean>();
    private boolean isLoadingMore = true;//加载标志位
    private int Page = 1;
    private boolean mLoading = false;
    private int mStar = 0;

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

        toolbar.setNavigationIcon(R.mipmap.back);
        setToolBar(toolbar, "");
        tvTitle.setText("" +
                "会所评价");

        btnComplete.setVisibility(View.INVISIBLE);
        rbShow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                refresh();
            }
        });

        datas = new ArrayList<>();

        commonAdapter = new CommonAdapter<ClubGroupLessonEvaluateListBean.RowsBean>(R.layout.cardview_member_ecaluate, mContext, datas) {
            /**
             * @param holder   holder对象
             * @param dataBean
             * @param position 位置
             */
            @Override
            protected void convert(ViewHolder holder, final ClubGroupLessonEvaluateListBean.RowsBean dataBean, int position) {
                MyRatingBar myRatingBar = (MyRatingBar) holder.getView(R.id.img_number_star);
                myRatingBar.setStar(dataBean.getEvaluateStar());

                holder.getView(R.id.img_1).setVisibility(View.GONE);
                holder.getView(R.id.img_2).setVisibility(View.GONE);
                holder.getView(R.id.img_3).setVisibility(View.GONE);

                loadImgForRadius(mContext, dataBean.getHeaderURL(), R.mipmap.head_img, (ImageView) holder.getView(R.id.img_head));

                holder.setText(R.id.text_name_leave, dataBean.getNickName());
                holder.setText(R.id.text_time_leave, "于" + dataBean.getCreateTime());
                holder.setText(R.id.text_content_leave, dataBean.getEvaluateContent());

                if (!dataBean.getImageURLList().equals("")) {
                    String[] temp = null;
                    if (dataBean.getImageURLList().indexOf(",") != -1) {
                        temp = dataBean.getImageURLList().split(",");
                    } else {
                        temp = new String[]{dataBean.getImageURLList().toString()};
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

    /**
     *
     */

    private void getList() {
        if (mStar != 0) {
            btnAllEvaluate.setText("显示所有评价");

            btnAllEvaluate.setTextColor(Color.parseColor("#63cd2b"));
        }
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        String Clubid = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");

        Intent intent = getIntent();
        String LessonId = String.valueOf(intent.getIntExtra(PUT_STR + "LessonId", 0));
        mPresenter.getClubGroupLessonEvaluateList(String.valueOf(UserId),
                token, Clubid,LessonId, rbShow.isChecked() ? 1 : 0, mStar, Page);

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
    public void succeed(ClubGroupLessonEvaluateListBean clubGroupLessonEvaluateListBean) {
        ProgressBar childBar1 = new ProgressBar(mContext,
                GetcClculate(clubGroupLessonEvaluateListBean.getStarTotal().getOneStartCount(), clubGroupLessonEvaluateListBean.getStarTotal().getTotalEvalCount()));
        ProgressBar1.addView(childBar1);

        ProgressBar childBar2 = new ProgressBar(mContext,
                GetcClculate(clubGroupLessonEvaluateListBean.getStarTotal().getTwoStartCount(), clubGroupLessonEvaluateListBean.getStarTotal().getTotalEvalCount()));
        ProgressBar2.addView(childBar2);

        ProgressBar childBar3 = new ProgressBar(mContext,
                GetcClculate(clubGroupLessonEvaluateListBean.getStarTotal().getThreeStartCount(), clubGroupLessonEvaluateListBean.getStarTotal().getTotalEvalCount()));
        ProgressBar3.addView(childBar3);

        ProgressBar childBar4 = new ProgressBar(mContext,
                GetcClculate(clubGroupLessonEvaluateListBean.getStarTotal().getFourStartCount(), clubGroupLessonEvaluateListBean.getStarTotal().getTotalEvalCount()));
        ProgressBar4.addView(childBar4);

        ProgressBar childBar5 = new ProgressBar(mContext,
                GetcClculate(clubGroupLessonEvaluateListBean.getStarTotal().getFiveStartCount(), clubGroupLessonEvaluateListBean.getStarTotal().getTotalEvalCount()));
        progressBar5.addView(childBar5);


        textNumber5.setText(clubGroupLessonEvaluateListBean.getStarTotal().getFiveStartCount() + "");
        textNumber4.setText(clubGroupLessonEvaluateListBean.getStarTotal().getFourStartCount() + "");
        textNumber3.setText(clubGroupLessonEvaluateListBean.getStarTotal().getThreeStartCount() + "");
        textNumber2.setText(clubGroupLessonEvaluateListBean.getStarTotal().getTwoStartCount() + "");
        textNumber1.setText(clubGroupLessonEvaluateListBean.getStarTotal().getOneStartCount() + "");
        String NumEvaText = "";
        switch (mStar) {
            case 1:
                NumEvaText = "(" + mStar + "星),共" + clubGroupLessonEvaluateListBean.getStarTotal().getOneStartCount() + "条";
                break;
            case 2:
                NumEvaText = "(" + mStar + "星),共" + clubGroupLessonEvaluateListBean.getStarTotal().getTwoStartCount() + "条";
                break;
            case 3:
                NumEvaText = "(" + mStar + "星),共" + clubGroupLessonEvaluateListBean.getStarTotal().getThreeStartCount() + "条";
                break;
            case 4:
                NumEvaText = "(" + mStar + "星),共" + clubGroupLessonEvaluateListBean.getStarTotal().getFourStartCount() + "条";
                break;
            case 5:
                NumEvaText = "(" + mStar + "星),共" + clubGroupLessonEvaluateListBean.getStarTotal().getFiveStartCount() + "条";
                break;
        }
        textNumEvaluate.setText(NumEvaText);
        textNumberTotal.setText(clubGroupLessonEvaluateListBean.getStarTotal().getTotalEvalCount() + "人");


        imgNumberStar.setStar((float) clubGroupLessonEvaluateListBean.getStarTotal().getAvgStarLevel());

        swipeRefreshLayout.setRefreshing(false);
        if (clubGroupLessonEvaluateListBean.getRows().size() != 0) {
            datas = clubGroupLessonEvaluateListBean.getRows();
            if (Page == 1) {
                commonAdapter.replaceData(datas);
            } else {
                commonAdapter.insertData(datas);
            }
            isLoadingMore = true;

        }
        if (mStar > 0) {

        }
    }

    public float GetcClculate(float i, float j) {
        return i / j;
    }


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
                if (btnAllEvaluate.getText().equals("显示所有评价")) {
                    btnAllEvaluate.setText("所有评价");

                    btnAllEvaluate.setTextColor(Color.parseColor("#FFFFFF"));
                    mStar = 0;
                }

                break;
        }

        refresh();
    }


}
