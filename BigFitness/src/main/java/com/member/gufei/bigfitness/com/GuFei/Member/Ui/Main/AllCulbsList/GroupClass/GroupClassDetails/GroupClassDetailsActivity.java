package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.GroupClass.GroupClassDetails;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.AdaptionLinearLayoutManager;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.GroupClass.EvaluateListForGroupLesson.EvaluateListForGroupLessonActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.Cashier.CashierActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.EvaluateListForLesson.EvaluateListForLessonActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Pay.PayActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubGroupLessonDetailBean;
import com.member.gufei.bigfitness.util.CustomView.MyJZVideoPlayerStandard;
import com.member.gufei.bigfitness.util.MyRatingBar;
import com.member.gufei.bigfitness.util.SpUtil;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jzvd.JZVideoPlayerStandard;

import static android.widget.LinearLayout.VERTICAL;
import static com.member.gufei.bigfitness.Constants.ID_GROUPLESSON;
import static com.member.gufei.bigfitness.Constants.ID_PRIVATE_CLASS;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.RESULT_ID;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.TYPEGTOUPLESSON;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.GlideImageLoader.displayImage;
import static com.member.gufei.bigfitness.util.MediaMetadata.loadVideoScreenshot;

public class GroupClassDetailsActivity extends BaseActivity<GroupClassDetailsActivityPresenter> implements GroupClassDetailsActivityContract.View {


    @BindView(R.id.img_bananr)
    MZBannerView Banner;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.text_name_lesson)
    TextView textNameLesson;
    @BindView(R.id.text_time_begin)
    TextView textTimeBegin;
    @BindView(R.id.text_time_end)
    TextView textTimeEnd;
    @BindView(R.id.text_money_total)
    TextView textMoneyTotal;
    @BindView(R.id.text_number_lesson)
    TextView textNumberLesson;
    @BindView(R.id.text_number_buyed)
    TextView textNumberBuyed;
    @BindView(R.id.text_number_total)
    TextView textNumberTotal;
    @BindView(R.id.text_name_coach)
    TextView textNameCoach;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.text_coach_lesson)
    TextView textCoachLesson;
    @BindView(R.id.text_content_remark)
    TextView textContentRemark;
    @BindView(R.id.text_classname)
    TextView textClassname;
    @BindView(R.id.text_number)
    TextView textNumber;
    @BindView(R.id.btn_evaluate)
    RelativeLayout btnEvaluate;
    @BindView(R.id.btn_buy_lesson)
    TextView btnBuyLesson;
    @BindView(R.id.text_type_lesson)
    TextView textTypeLesson;
    @BindView(R.id.img_number_star)
    MyRatingBar imgNumberStar;

    private List<String> list;


    private CommonAdapter<ClubGroupLessonDetailBean.RowsBean.GroupLessonClassTimeBean> commonAdapter;
    private List<ClubGroupLessonDetailBean.RowsBean.GroupLessonClassTimeBean> datas = new ArrayList<ClubGroupLessonDetailBean.RowsBean.GroupLessonClassTimeBean>();

    private final BannerViewHolder bannerViewHolder = new BannerViewHolder();
    private int UserId;
    private String token;
    private int GroupClassId;
    private String Clubid;
    private int LessonId;
    private String GLessonName;
    private String StartTime;
    private String EndTime;
    private int MoneyTotal;
    private int IsFull;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_details_groupclass;
    }

    @Override
    protected void initView() {


        datas = new ArrayList<>();
        commonAdapter = new CommonAdapter<ClubGroupLessonDetailBean.RowsBean.GroupLessonClassTimeBean>(R.layout.member_item_unit_group_lesson, mContext, datas) {
            @Override
            protected void convert(ViewHolder holder, final ClubGroupLessonDetailBean.RowsBean.GroupLessonClassTimeBean msgBean, int position) {
                holder.setText(R.id.text_content, msgBean.getLessonDate() + "  " + msgBean.getClassTime());

            }
        };
        recyclerView.setAdapter(commonAdapter);


    }

    @Override
    protected void onDestroy() {
        if (bannerViewHolder.mVideoView != null) {
            bannerViewHolder.mVideoView.release();
        }
        super.onDestroy();

    }

    @Override
    protected void onPause() {
        if (bannerViewHolder.mVideoView != null) {
            bannerViewHolder.mVideoView.release();
        }
        super.onPause();

    }

    @Override
    protected void initData() {

        InitData();
    }


    public void InitData() {

        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        Intent intent = getIntent();
        GroupClassId = intent.getIntExtra(PUT_STR + "GroupClassId", 0);
        IsFull = intent.getIntExtra(PUT_STR + "isfull", 0);
        Clubid = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        mPresenter.getClubGroupLessonDetail(String.valueOf(UserId),
                token, Clubid, String.valueOf(GroupClassId));

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

    /**
     * @param clubGroupLessonDetailBean
     */
    @Override
    public void succeed(ClubGroupLessonDetailBean clubGroupLessonDetailBean) {

        list = new ArrayList<String>();
        GLessonName=clubGroupLessonDetailBean.getRows().getGLessonName();
        textNameLesson.setText(GLessonName + "(" + clubGroupLessonDetailBean.getRows().getPersonCount() + "人班)");
        textTimeBegin.setText(clubGroupLessonDetailBean.getRows().getStartTime());
        textTimeEnd.setText(clubGroupLessonDetailBean.getRows().getEndTime());
        MoneyTotal=clubGroupLessonDetailBean.getRows().getSaleMoney();
        StartTime=clubGroupLessonDetailBean.getRows().getStartTime();
        EndTime=clubGroupLessonDetailBean.getRows().getEndTime();
        textMoneyTotal.setText("￥" + clubGroupLessonDetailBean.getRows().getSaleMoney());
        textCoachLesson.setText(clubGroupLessonDetailBean.getRows().getAmount() + "");
        textNumberBuyed.setText(clubGroupLessonDetailBean.getRows().getPcount() + "");
        textNumberTotal.setText(clubGroupLessonDetailBean.getRows().getPersonCount() + "");
        textNameCoach.setText(clubGroupLessonDetailBean.getRows().getTeacherList());
        textTypeLesson.setText(TYPEGTOUPLESSON[clubGroupLessonDetailBean.getRows().getStatus()]);
        imgNumberStar.setStar((float) clubGroupLessonDetailBean.getRows().getAvgEvaluateStar());
        LessonId=clubGroupLessonDetailBean.getRows().getGroupLessonId();
        if (clubGroupLessonDetailBean.getRows().getStatus()==0 &&
            clubGroupLessonDetailBean.getRows().getIsBuy() !=1 &&
                                                      IsFull == 0
                ){
            btnBuyLesson.setBackgroundResource(R.mipmap.img_gradient_rect_bg);
            btnBuyLesson.setEnabled(true);
        }else{
//#2A314B
            btnBuyLesson.setBackgroundColor(getResources().getColor(R.color.member_view_bg_color));
            btnBuyLesson.setEnabled(false);
        }

// TODO: 2018/4/14  课程介绍内容未完成 
//        textContentRemark.setText(clubGroupLessonDetailBean.getRows().get());

        textNumber.setText(clubGroupLessonDetailBean.getRows().getEvaluateCount() + "人");
//        if (clubGroupLessonDetailBean.getRows().getIsBuy() == 1) {
//            btnBuyLesson.setEnabled(true);
//            btnBuyLesson.setBackgroundResource(R.mipmap.img_gradient_rect_bg);
//        } else {
//            btnBuyLesson.setEnabled(false);
//        }


        String mImgList = clubGroupLessonDetailBean.getRows().getImageList();
        if (!mImgList.equals("")) {
            String[] temp = null;
            if (mImgList.indexOf(",") != -1) {
                temp = mImgList.split(",");
            } else {
                temp[0] = mImgList;
            }
            for (int i = 0; i < temp.length; i++) {
                list.add(temp[i]);
            }

        } else {

            list = new ArrayList<String>();
            list.add("http://p2.so.qhmsg.com/sdr/1620_1080_/t010735afa0402748f2.jpg");
            list.add("http://mirror.aarnet.edu.au/pub/TED-talks/911Mothers_2010W-480p.mp4");
            list.add("http://p2.so.qhmsg.com/sdr/1620_1080_/t010735afa0402748f2.jpg");
            list.add("http://p2.so.qhmsg.com/sdr/1620_1080_/t010735afa0402748f2.jpg");
            list.add("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
        }


        setBanner();

        try {
            datas = clubGroupLessonDetailBean.getRows().getGroupLessonClassTime();
            commonAdapter.replaceData(datas);
            final AdaptionLinearLayoutManager layoutManager = new AdaptionLinearLayoutManager(mContext, VERTICAL, true, datas.size()) {
                @Override
                public boolean canScrollVertically() {
                    //{｝内部分可以开启滑动
                    return false;
                }
            };
            layoutManager.setAutoMeasureEnabled(false);
            recyclerView.setLayoutManager(layoutManager);
            commonAdapter.setShowFooter(false);


        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    @SuppressLint({"ResourceAsColor", "ResourceType"})
    public void setBanner() {

//        final BannerViewHolder bannerViewHolder= new BannerViewHolder();
        // 设置数据
        Banner.setPages(list, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return bannerViewHolder;
            }

        });


        Banner.addPageChangeLisnter(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                mVideoView.pause();
                Banner.start();

            }

            /**
             * @param state
             */
            @Override
            public void onPageScrollStateChanged(int state) {
                if(bannerViewHolder.mVideoView != null) {
                    bannerViewHolder.mVideoView.release();
                }
//                if (!mVideoView.equals(null)) {
//                    mVideoView.startButton.performClick();
//                }

            }
        });


    }


    public class BannerViewHolder implements MZViewHolder {
        public ImageView mImageView;
        public MyJZVideoPlayerStandard mVideoView;
        public RelativeLayout layoutVideo;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.member_banner_video_item, null);
            layoutVideo = (RelativeLayout) view.findViewById(R.id.layout_video);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);

            return view;
        }

        /**
         * @param context
         * @param i
         * @param o
         */
        @Override
        public void onBind(Context context, final int i, Object o) {

            if (list.get(i).indexOf(".mp4") != -1) {
                layoutVideo.setVisibility(View.VISIBLE);
                mVideoView = new MyJZVideoPlayerStandard(context);
                //动态添加视频窗口到bananr
                ViewGroup.LayoutParams params = layoutVideo.getLayoutParams();
                mVideoView.setLayoutParams(params);
                mVideoView.setUp(list.get(i)
                        , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "会所视频");
                loadVideoScreenshot(mContext, list.get(i), mVideoView.thumbImageView, 1);
//                Glide.with(mContext).load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png").into(mVideoView.thumbImageView);
//                JZVideoPlayer.setJzUserAction(new MyUserActionStandard());
                layoutVideo.addView(mVideoView);
                Banner.pause();

            } else {
                layoutVideo.setVisibility(View.INVISIBLE);
                // 数据绑定
                displayImage(context, list.get(i), R.mipmap.img_bg_bananr, mImageView);
            }
        }


    }

    @OnClick({R.id.btn_back, R.id.btn_evaluate, R.id.btn_buy_lesson})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:

                finish();
                break;
            case R.id.btn_evaluate:
                Intent EvaluateListForLesson = new Intent(mContext, EvaluateListForGroupLessonActivity.class);
                EvaluateListForLesson.putExtra(PUT_STR + "LessonId", LessonId);
                startActivity(EvaluateListForLesson);

                break;
            case R.id.btn_buy_lesson:
                Intent Cashier = new Intent(mContext, CashierActivity.class);
                Cashier.putExtra(PUT_STR + "LessonId", LessonId);
                Cashier.putExtra(PUT_STR + "TypeId", ID_GROUPLESSON);
                Cashier.putExtra(PUT_STR + "titleInfoBuy", "购买团体课");
                Cashier.putExtra(PUT_STR + "textInfoBuy", GLessonName);
                Cashier.putExtra(PUT_STR + "TitleForFirst", "开课时间");
                Cashier.putExtra(PUT_STR + "TextForFirst", StartTime);
                Cashier.putExtra(PUT_STR + "IdForSecond", "");
                Cashier.putExtra(PUT_STR + "TitleForSecond", "结束时间");
                Cashier.putExtra(PUT_STR + "TextForSecond", EndTime);
                Cashier.putExtra(PUT_STR + "textMoneyTotal", String.valueOf(MoneyTotal));
                Cashier.putExtra(RESULT_ID, "9999");
                startActivityForResult(Cashier, 9999);
                break;
        }

    }
}


