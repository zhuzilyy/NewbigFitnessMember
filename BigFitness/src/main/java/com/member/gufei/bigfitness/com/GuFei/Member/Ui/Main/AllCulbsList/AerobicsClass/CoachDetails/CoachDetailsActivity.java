package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.AerobicsClass.CoachDetails;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.AdaptionLinearLayoutManager;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.AerobicsClass.CoachEvaluate.CoachEvaluateActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.PrivateClassDetails.PrivateClassDetailsActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Pay.PayActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubTeacherDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubTeacherListBean;
import com.member.gufei.bigfitness.util.CustomView.MyJZVideoPlayerStandard;
import com.member.gufei.bigfitness.util.MyRatingBar;
import com.member.gufei.bigfitness.util.NgCommon.MyAdapter;
import com.member.gufei.bigfitness.util.SpUtil;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

import static android.widget.LinearLayout.VERTICAL;
import static com.member.gufei.bigfitness.Constants.ID_PRIVATE_CLASS;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.GlideImageLoader.displayImage;
import static com.member.gufei.bigfitness.util.LoadImage.loadBgImg;
import static com.member.gufei.bigfitness.util.MediaMetadata.loadVideoScreenshot;


public class CoachDetailsActivity extends BaseActivity<CoachDetailsActivityPresenter> implements CoachDetailsActivityContract.View {

    List<String> urlList = new ArrayList<>();
    List<String> imgesUrl = new ArrayList<>();
    List<ImageView> imgesViewLst = new ArrayList<ImageView>();
    @BindView(R.id.img_bananr)
    MZBannerView Banner;
    @BindView(R.id.img_right)
    ImageView imgRight;
    @BindView(R.id.text_name_coach)
    TextView textNameCoach;
    @BindView(R.id.text_name_sex_age)
    TextView textNameSexAge;
    @BindView(R.id.text_height_coach)
    TextView textHeightCoach;
    @BindView(R.id.text_weight_coach)
    TextView textWeightCoach;
    @BindView(R.id.text_content)
    TextView textContent;
    @BindView(R.id.text_content_certificate)
    TextView textContentCertificate;
    @BindView(R.id.text_content_introduce)
    TextView textContentIntroduce;
    @BindView(R.id.text_classname)
    TextView textClassname;
    @BindView(R.id.img_number_star)
    MyRatingBar imgNumberStar;
    @BindView(R.id.text_number_evaluate)
    TextView textNumberEvaluate;
    @BindView(R.id.text_class_content)
    TextView textClassContent;

    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.btn_evaluate)
    RelativeLayout btnEvaluate;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;


    private CommonAdapter<ClubTeacherDetailBean.RowsBean.LessonListBean> commonAdapter;
    private List<ClubTeacherDetailBean.RowsBean.LessonListBean> datas = new ArrayList<ClubTeacherDetailBean.RowsBean.LessonListBean>();

    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    private List<String> list;
    private RelativeLayout layoutVideo;
    private int TeacherId = 0;
    private List<ClubTeacherDetailBean.RowsBean.ResListBean> ResList;
    private int mMinNum;
    private MyAdapters myAdapter;

//    private ImageView imgVideo;

//    private ImageView btnPlay;

//    private GestureDetector mGesture;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_details_coach;
    }

    @Override
    protected void initView() {

        String toeken = (String) SpUtil.get(mContext, TOKENKEY, "");
        Intent intent = getIntent();
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String Clubid = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        TeacherId = intent.getIntExtra(PUT_STR + "TeacherId", 0);
        mPresenter.getClubTeacherDetail(String.valueOf(UserId), toeken, Clubid, String.valueOf(TeacherId));
        list = new ArrayList<String>();

        commonAdapter = new CommonAdapter<ClubTeacherDetailBean.RowsBean.LessonListBean>(R.layout.cardview_member_details_coach, mContext, datas) {
            @Override
            protected void convert(final ViewHolder holder, final ClubTeacherDetailBean.RowsBean.LessonListBean listBean, int position) {
//
                holder.setText(R.id.text_class_3, listBean.getLessonName());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(context,PrivateClassDetailsActivity.class);
                        intent.putExtra(PUT_STR + "LessonId", listBean.getLessonId());
                        intent.putExtra(PUT_STR + "LessonName", listBean.getLessonName());
                        intent.putExtra(PUT_STR + "TeacherName", textNameCoach.getText().toString());
                        intent.putExtra(PUT_STR + "TeacherId", TeacherId);

                        startActivity(intent);
                    }
                });


            }
        };

        commonAdapter.setShowFooter(false);
        //        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        //解决列表左右位移的问题
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(commonAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

    }

        @SuppressLint({"ResourceAsColor", "ResourceType"})
    public void setBanner() {


        // 设置数据
        Banner.setPages(list, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
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

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    @Override
    protected void initData() {

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
    public void succeed(ClubTeacherDetailBean clubTeacherDetailBean) {

        textNameCoach.setText(clubTeacherDetailBean.getRows().getTeacherName());
        textNameSexAge.setText("/" + (clubTeacherDetailBean.getRows().getSex() == 1 ? "男" : "女") + " " + clubTeacherDetailBean.getRows().getAge() + "岁");
        textHeightCoach.setText(clubTeacherDetailBean.getRows().getHeight() + "");
        textWeightCoach.setText(clubTeacherDetailBean.getRows().getWeight() + "");
        textContent.setText(clubTeacherDetailBean.getRows().getSpeciality());
        textContentCertificate.setText(clubTeacherDetailBean.getRows().getCertificate());
        textContentIntroduce.setText(clubTeacherDetailBean.getRows().getIntroduce());
        textNumberEvaluate.setText(clubTeacherDetailBean.getRows().getTotalEvalCount() + "人");
//        textClass1.setText(clubTeacherDetailBean.getRows().getTeacherName());
//        textClass2.setText(clubTeacherDetailBean.getRows().getTeacherName());
//        textClass3.setText(clubTeacherDetailBean.getRows().getTeacherName());
//        textClass4.setText(clubTeacherDetailBean.getRows().getTeacherName());
        imgNumberStar.setStar((float) clubTeacherDetailBean.getRows().getAvgStarLevel());

        ResList=clubTeacherDetailBean.getRows().getResList();

        for (int i=0;i< clubTeacherDetailBean.getRows().getResList().size();i++){
            list.add(clubTeacherDetailBean.getRows().getResList().get(i).getResURL());
        }

        datas = clubTeacherDetailBean.getRows().getLessonList();

//            commonAdapter.replaceData(datas);
//        final AdaptionLinearLayoutManager layoutManager = new AdaptionLinearLayoutManager(mContext, VERTICAL, true, datas.size()) {
//            @Override
//            public boolean canScrollVertically() {
//                //{｝内部分可以开启滑动
//                return false;
//            }
//        };
//        staggeredGridLayoutManager.setAutoMeasureEnabled(false);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);
//        commonAdapter.setShowFooter(false);
        Message message = new Message();
        message.what = 1;

        myHandler.sendMessage(message);
        setBanner();
    }

    Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
//                    myAdapter=new MyAdapters(CoachDetailsActivity.this,datas);


                    commonAdapter.replaceData(datas);
                    Log.e("dayin","dayin");
                    break;
            }
            super.handleMessage(msg);
        }
    };


    @OnClick({R.id.btn_back, R.id.btn_evaluate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                JZVideoPlayerStandard.releaseAllVideos();
                finish();
                break;
            case R.id.btn_evaluate:


                Intent intent = new Intent(mContext, CoachEvaluateActivity.class);
//
//
////
                intent.putExtra(PUT_STR + "TeacherId", TeacherId);
//                        intent.putExtra(PUT_STR + "ConsumeType", dataBean.getConsumeType());
//                        intent.putExtra(PUT_STR + "MemberCardId", dataBean.getMemberCardId());
//                        intent.putExtra(PUT_STR + "Status", dataBean.getStatus());
                startActivity(intent);

                break;
        }
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

        @Override
        public void onBind(Context context, final int i, Object o) {

            if (ResList.get(i).getResType()==0) {
                layoutVideo.setVisibility(View.VISIBLE);
                mVideoView = new MyJZVideoPlayerStandard(context);
                //动态添加视频窗口到bananr
                ViewGroup.LayoutParams params = layoutVideo.getLayoutParams();
                mVideoView.setLayoutParams(params);
                mVideoView.setUp(list.get(i)
                        , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "");
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
    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            Banner.start();


//            Toast.makeText( LocalVideoActivity.this, "播放完成了", Toast.LENGTH_SHORT).show();
        }

    }
}
class MyAdapters extends RecyclerView.Adapter<MyViewHolder>{


    private List<ClubTeacherDetailBean.RowsBean.LessonListBean> list;
    private Context context;
    public MyAdapters(Context context,List list) {
        this.context=context;
        this.list=list;
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

