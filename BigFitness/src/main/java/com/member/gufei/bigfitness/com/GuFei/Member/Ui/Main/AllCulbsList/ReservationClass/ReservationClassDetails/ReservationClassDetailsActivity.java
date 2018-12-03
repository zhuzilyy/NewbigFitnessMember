package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.ReservationClass.ReservationClassDetails;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.ResBean;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClassAppointmentBean;
import com.member.gufei.bigfitness.util.CustomView.MyJZVideoPlayerStandard;
import com.member.gufei.bigfitness.util.MyRatingBar;
import com.member.gufei.bigfitness.util.SpUtil;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jzvd.JZVideoPlayerStandard;

import static com.member.gufei.bigfitness.Constants.MEMBERIDKEY;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.GlideImageLoader.displayImage;
import static com.member.gufei.bigfitness.util.MediaMetadata.loadVideoScreenshot;

public class ReservationClassDetailsActivity extends BaseActivity<ReservationClassDetailsActivityPresenter> implements ReservationClassDetailsActivityContract.View {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.tv_lessontimelong)
    TextView tv_lessontimelong;
    @BindView(R.id.tv_NowPersonCount)
    TextView tv_NowPersonCount;
    @BindView(R.id.tv_MaxPersonCount)
    TextView tv_MaxPersonCount;
    @BindView(R.id.tv_TeacherName)
    TextView tv_TeacherName;
    @BindView(R.id.tv_LessonTime)
    TextView tv_LessonTime;
    @BindView(R.id.tv_Introduce)
    TextView tv_Introduce;
    @BindView(R.id.img_number_star)
    MyRatingBar imgNumberStar;
    @BindView(R.id.tv_TotalEvalCount)
    TextView tv_TotalEvalCount;
    @BindView(R.id.lesson_name)
    TextView tv_lessonName;
    @BindView(R.id.img_bananr)
    MZBannerView Banner;
    @BindView(R.id.text_type)
    TextView textType;
    String FlessonName;//课程名
    int TimLong;//时长
    int PersonCount;//预约人数
    int MaxPersonCount; //总人数
    String TeacherName;//上课教练
    String LessonTime;//上课时间
    String Introduce;//课程介绍
    int AvgStarLevel;//课程评价
    String ImageUrl;//图片
    int TextNumber;//人数
    @BindView(R.id.button_appointment)
    TextView buttonAppointment;
    private int IsAllowAppointment;
    private String MemberId;
    private int UserId;
    private String token;
    private String ClubId;
    private String FLessonId;
    private String StartTime;
    private String LessonDate;


    private List<String> list;
    private final BannerViewHolder bannerViewHolder = new BannerViewHolder();

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_details_reservationclass;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onPause() {
        if (bannerViewHolder.mVideoView != null) {
            bannerViewHolder.mVideoView.release();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        if (bannerViewHolder.mVideoView != null) {
            bannerViewHolder.mVideoView.release();
        }
        super.onDestroy();
    }

    @Override
    protected void initData() {
//        http();
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        MemberId = (String) SpUtil.get(mContext, MEMBERIDKEY, "") ;
        ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        FLessonId = getIntent().getStringExtra("FLessonId");
        Log.e("onSuccess", FLessonId);
        StartTime = getIntent().getStringExtra("StartTime");
        LessonDate = getIntent().getStringExtra("LessonDate");
        IsAllowAppointment = getIntent().getIntExtra("IsAllowAppointment", 0);
        mPresenter.getClubFreeLessonInfo(ClubId, token, String.valueOf(UserId), FLessonId, StartTime, LessonDate);
        if (IsAllowAppointment == 2) {
            textType.setText("过期");
            textType.setTextColor(Color.parseColor("#3CAF40"));
        }
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
    public void succeed(ResBean publicSeaBean) {

        list = new ArrayList<String>();
        FlessonName = publicSeaBean.getRows().getFLessonName();
        tv_lessonName.setText(FlessonName);
        TimLong = publicSeaBean.getRows().getLessonTimelong();
        tv_lessontimelong.setText(String.valueOf(TimLong));
        PersonCount = publicSeaBean.getRows().getNowPersonCount();
        tv_NowPersonCount.setText(String.valueOf(PersonCount));
        MaxPersonCount = publicSeaBean.getRows().getMaxPersonCount();
        tv_MaxPersonCount.setText(String.valueOf(MaxPersonCount));
        TeacherName = publicSeaBean.getRows().getTeacherName();
        tv_TeacherName.setText(TeacherName);
        LessonTime = publicSeaBean.getRows().getLessonTime();
        tv_LessonTime.setText(LessonTime);
        Introduce = publicSeaBean.getRows().getIntroduce();
        tv_Introduce.setText(Introduce);
        AvgStarLevel = publicSeaBean.getRows().getAvgStarLevel();
        imgNumberStar.setStar((float) AvgStarLevel);
        TextNumber = publicSeaBean.getRows().getTotalEvalCount();
        tv_TotalEvalCount.setText(String.valueOf(TextNumber) + "人");
        ImageUrl = publicSeaBean.getRows().getImageURL();

        if (publicSeaBean.getRows().getIsAppointment() == 0 && IsAllowAppointment == 0 && !MemberId.equals("0")) {
            buttonAppointment.setBackgroundResource(R.mipmap.img_gradient_rect_bg);
            buttonAppointment.setEnabled(true);
        }else {
            buttonAppointment.setBackgroundColor(getResources().getColor(R.color.member_view_bg_color));
            buttonAppointment.setEnabled(false);
        }
        if (!ImageUrl.equals("")) {
            String[] temp = null;
            if (ImageUrl.indexOf(",") != -1) {
                temp = ImageUrl.split(",");
            } else {
//                temp[0] = ImageUrl.toString();
                temp = new String[]{ImageUrl.toString()};
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

    }

    @Override
    public void classsucceed(ClassAppointmentBean classAppointmentBean) {
        Toast.makeText(mContext, "预约成功!", Toast.LENGTH_SHORT).show();
        initData();
    }

    @SuppressLint({"ResourceAsColor", "ResourceType"})
    private void setBanner() {
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
                if (bannerViewHolder.mVideoView != null) {
                    bannerViewHolder.mVideoView.release();
                }
//                if (!mVideoView.equals(null)) {
//                    mVideoView.startButton.performClick();
//                }

            }
        });
    }


//    @Override
//    public void succeedEdit(ResBean codeBean) {
//
//    }
//
//    @Override
//    public void succeedoperate() {
//
//    }
//
//    @Override
//    public void membersucceed(ResBean publicSeaBean) {
//
//    }

//    private void http() {
//        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
//        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
//
//        String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
//        String FLessonId = getIntent().getStringExtra("FLessonId");
//        String StartTime = getIntent().getStringExtra("StartTime");
//        String LessonDate = getIntent().getStringExtra("LessonDate");
//        Log.e("onSuccess", StartTime);
//        RequestParams params = new RequestParams(BASEURL + "/appMember/memberLesson/getClubFreeLessonInfo");
//        params.addQueryStringParameter("Token", token);
//        params.addQueryStringParameter("APPUserId", UserId + "");
//        params.addQueryStringParameter("FLessonId", FLessonId);
//        params.addQueryStringParameter("LessonDate", LessonDate);
//
//        params.addQueryStringParameter("ClubId", ClubId);
//        params.addBodyParameter("StartTime", "%3A");
//        x.http().get(params, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//                //解析result
//                Log.e("onSuccess", result);
//            }
//
//            //请求异常后的回调方法
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//            }
//
//            //主动调用取消请求的回调方法
//            @Override
//            public void onCancelled(CancelledException cex) {
//            }
//
//            @Override
//            public void onFinished() {
//            }
//
//
//        });
//    }

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

    @OnClick({R.id.back, R.id.button_appointment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                JZVideoPlayerStandard.releaseAllVideos();
                finish();
                break;
            case R.id.button_appointment:
                getlist();

        }
    }

    private void getlist() {
        mPresenter.getClassAppointment(String.valueOf(UserId),
                token,
                ClubId,
                FLessonId,
                MemberId,
                LessonDate);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}


