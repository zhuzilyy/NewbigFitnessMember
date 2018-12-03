package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.SelectCocat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.WeekViewForDay.WeekViewForDayActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubLessonTeacherListBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.RESULT_ID;
import static com.member.gufei.bigfitness.Constants.RESULT_STRING;
import static com.member.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.member.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.LoadImage.loadBgImg;

public class SelectCocatActivity extends BaseActivity<SelectCocatActivityPresenter> implements SelectCocatActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayoutid)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.tv_noMore)
    TextView tvNoMore;
    private CommonAdapter<ClubLessonTeacherListBean.RowsBean> commonAdapter;
    private List<ClubLessonTeacherListBean.RowsBean> datas = new ArrayList<ClubLessonTeacherListBean.RowsBean>();
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
//    private List<ClubListForMemberNoBuyBean.RowsBean> Otherdatas = new ArrayList<ClubListForMemberNoBuyBean.RowsBean>();

    private boolean isLoadingMore = true;//加载标志位
    private int Page = 1;
    private boolean mLoading = false;
    private String mListType = "我的会所";

    private int UserId;
    private String token;
    private int LessonId;
    private String Clubid;
    private String mNameCocat;
    private String mIdCocat;
    private String code;
    private String LessonName;


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_select_cocat;
    }

    @Override
    protected void initView() {


        toolbar.setNavigationIcon(R.mipmap.left);

        setToolBar(toolbar, "");
        tvTitle.setText("选择教练");


        initList();
        btnComplete.setVisibility(View.GONE);
//        mPresenter.getClubLessonDetail(String.valueOf(UserId),
//                token, Clubid, String.valueOf(LessonId));

    }

//    public void GoMainActivity(String culibId){
//
//        SpUtil.put(mContext, SELECTEDCULBIDKEY, culibId);
//        Intent intent = new Intent(SelectCocatActivity.this, MainActivity.class);
//        startActivity(intent);
//
//    }

    @Override
    protected void initData() {
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        Intent intent = getIntent();
        LessonId = intent.getIntExtra(PUT_STR + "LessonId", 0);
        LessonName = intent.getStringExtra(PUT_STR + "LessonName");
        code = intent.getStringExtra(PUT_STR + "code");
        Clubid = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        datas = new ArrayList<>();
        refresh();
    }

    public void initList() {


        commonAdapter = new CommonAdapter<ClubLessonTeacherListBean.RowsBean>(R.layout.cardview_member_select_cocat, mContext, datas) {
            @Override
            protected void convert(final ViewHolder holder, final ClubLessonTeacherListBean.RowsBean dataBean, int position) {

                holder.setText(R.id.text_title, dataBean.getTeacherName() + "/" + (dataBean.getSex() == 1 ? "男" : "女") + dataBean.getAge() + "岁");
                holder.setText(R.id.text_content, dataBean.getSpeciality());
                loadBgImg(mContext, dataBean.getHeaderURL(), R.mipmap.card_img_null, (ImageView) holder.getView(R.id.img));


                try {

                    if (dataBean.isSelected()) {

                        holder.setImage(R.id.img_check).setImageResource(R.mipmap.img_check_true);
                    } else {
                        holder.setImage(R.id.img_check).setImageResource(R.mipmap.img_check_no);
                    }

//
                    holder.setImage(R.id.img_star).setImageResource(R.mipmap.class.getDeclaredField("star_" + String.valueOf((int) dataBean.getEvaluateStar())).getInt(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        dataBean.setSelected(!dataBean.isSelected());
//                        Intent intent = new Intent(context, CoachDetailsActivity.class);
//                        intent.putExtra(PUT_STR + "TeacherId", dataBean.getTeacherId());
//                        startActivity(intent);

                        dataBean.setSelected(!dataBean.isSelected());
//                        commonAdapter.notifyDataSetChanged()
                        String nameList = "";
                        String idList = "";

                        for (int i = 0; i < datas.size(); i++) {
                            String f = ",";
                            if (datas.get(i).isSelected()) {
                                if (nameList.equals("")) {
                                    f = "";
                                }
                                nameList += (f + datas.get(i).getTeacherName());
                                idList += (f + datas.get(i).getTeacherId());
                            }

                        }
                        if (code.equals("1")) {
                            Intent schedule = new Intent(context, WeekViewForDayActivity.class);
                            schedule.putExtra(PUT_STR + "LessonId", String.valueOf(LessonId));
                            schedule.putExtra(PUT_STR + "TeacherName", nameList);
                            schedule.putExtra(PUT_STR + "TeahcerId", String.valueOf(idList));
                            schedule.putExtra(PUT_STR + "LessonName", LessonName);
                            startActivity(schedule);
                        } else {
                            Intent resultIntent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putInt(RESULT_TYPE, RESULT_SUCCESS);
                            bundle.putString(RESULT_STRING, nameList);

                            bundle.putString(RESULT_ID, idList);

                            resultIntent.putExtras(bundle);

                            setResult(RESULT_OK, resultIntent);


                            finish();
                        }

                    }
                });

//                holder.getView(R.id.img_check).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dataBean.setSelected(!dataBean.isSelected());
//                        commonAdapter.notifyDataSetChanged();
//                    }
//                });


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

                    if (isLoadingMore && totalItemCount - 1 <= lastVisubleItem && dy > 0) {

                        loading();

                    }
                }
            });

        }

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

        mPresenter.getClubLessonTeacherList(String.valueOf(UserId),
                token, Clubid, String.valueOf(LessonId), Page
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
    public void succeed(ClubLessonTeacherListBean clubLessonTeacherListBean) {

        swipeRefreshLayout.setRefreshing(false);
        if (clubLessonTeacherListBean.getRows().size() != 0) {
            datas = clubLessonTeacherListBean.getRows();
                tvNoMore.setVisibility(View.GONE);
                if (Page == 1) {
                    commonAdapter.replaceData(datas);
                } else {
                    commonAdapter.insertData(datas);
                }

                isLoadingMore = true;


//            mFirstShow = false;
        }else {
            tvNoMore.setVisibility(View.VISIBLE);
        }
    }


    @OnClick({R.id.btn_complete})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btn_complete:
                Intent resultIntent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt(RESULT_TYPE, RESULT_SUCCESS);

                String nameList = "";
                String idList = "";

                for (int i = 0; i < datas.size(); i++) {
                    String f = ",";
                    if (datas.get(i).isSelected()) {
                        if (nameList.equals("")) {
                            f = "";
                        }
                        nameList += (f + datas.get(i).getTeacherName());
                        idList += (f + datas.get(i).getTeacherId());
                    }

                }
                bundle.putString(RESULT_STRING, nameList);

                bundle.putString(RESULT_ID, idList);

                resultIntent.putExtras(bundle);

                this.setResult(RESULT_OK, resultIntent);


                finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
