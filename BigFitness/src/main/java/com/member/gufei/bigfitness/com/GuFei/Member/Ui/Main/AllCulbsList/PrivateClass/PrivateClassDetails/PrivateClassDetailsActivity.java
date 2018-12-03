package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.PrivateClassDetails;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.AdaptionLinearLayoutManager;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.PrivateClass.EvaluateListForLesson.EvaluateListForLessonActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Pay.PayActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubLessonDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ItemPayBean;
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

import static android.widget.LinearLayout.VERTICAL;
import static com.member.gufei.bigfitness.Constants.ID_PRIVATE_CLASS;
import static com.member.gufei.bigfitness.Constants.MEMBERIDKEY;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.GlideImageLoader.displayImage;

/*
 * 私教课详情
 * */
public class PrivateClassDetailsActivity extends BaseActivity<PrivateClassDetailsActivityPresenter> implements PrivateClassDetailsActivityContract.View {


    @BindView(R.id.img_bananr)
    MZBannerView Banner;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.text_name_lesson)
    TextView textNameLesson;
    @BindView(R.id.text_name_coach)
    TextView textNameCoach;
    @BindView(R.id.text_min_amount)
    TextView textMinAmount;
    @BindView(R.id.text_coach_lesson)
    TextView textCoachLesson;
    @BindView(R.id.text_classname)
    TextView textClassname;
    @BindView(R.id.img_number_star)
    MyRatingBar imgNumberStar;
    @BindView(R.id.text_number_evaluate)
    TextView textNumberEvaluate;
    @BindView(R.id.btn_evaluate)
    RelativeLayout btnEvaluate;
    @BindView(R.id.btn_pay)
    TextView btnPay;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    @BindView(R.id.img_right)
    ImageView imgRight;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    @BindView(R.id.text_content)
    TextView textContent;
    @BindView(R.id.text_money)
    TextView textMoney;
    @BindView(R.id.item0)
    LinearLayout item0;

    private List<String> list;
    private CommonAdapter<ItemPayBean.PriceListBean> commonAdapter;
    private List<ItemPayBean.PriceListBean> datas = new ArrayList<ItemPayBean.PriceListBean>();
    private List<ItemPayBean.PriceListBean> Paydatas = new ArrayList<ItemPayBean.PriceListBean>();
    private final BannerViewHolder bannerViewHolder = new BannerViewHolder();
    private int UserId;
    private String token;
    private int LessonId;
    private String Clubid;
    private int mMinNum;
    private String InfoBuy;
    private String TeacherName;
    private int TeacherId = 0;
    private int IsBuy;
    private String MemberId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    public interface Pause {
        void setPause();

    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_details_privateclass;
    }

    @Override
    protected void initView() {
        datas = new ArrayList<>();
        commonAdapter = new CommonAdapter<ItemPayBean.PriceListBean>(R.layout.member_item_unit_pay, mContext, datas) {
            @Override
            protected void convert(ViewHolder holder, final ItemPayBean.PriceListBean msgBean, int position) {
                holder.setText(R.id.text_content, msgBean.getMinAmount() + "-" + msgBean.getMaxAmount() + "节");
                holder.setText(R.id.text_money, msgBean.getPrice() + "元");
            }
        };
        recyclerView.setAdapter(commonAdapter);
        Banner.setIndicatorVisible(false);


    }

    @Override
    protected void onDestroy() {
//        bannerViewHolder.mVideoView.release();
        super.onDestroy();


    }

    @Override
    protected void onPause() {

//        bannerViewHolder.mVideoView.release();
        super.onPause();

    }

    @Override
    protected void initData() {

        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        MemberId = (String) SpUtil.get(mContext, MEMBERIDKEY, "");
        Intent intent = getIntent();
        LessonId = intent.getIntExtra(PUT_STR + "LessonId", 0);
        TeacherName = intent.getStringExtra(PUT_STR + "TeacherName");
        TeacherId = intent.getIntExtra(PUT_STR + "TeacherId", 0);
        Clubid = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        mPresenter.getClubLessonDetail(String.valueOf(UserId),
                token, Clubid, String.valueOf(LessonId));


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
    public void succeed(ClubLessonDetailBean clubLessonDetailBean) {

        list = new ArrayList<String>();
        imgNumberStar.setStar((float) clubLessonDetailBean.getRows().getAvgStarLevel());
        IsBuy = clubLessonDetailBean.getRows().getIsBuy();
        InfoBuy = clubLessonDetailBean.getRows().getLessonName();
        textNameLesson.setText(InfoBuy);

        //1为不能购买，0为可购买
        if (IsBuy == 0) {
            btnPay.setBackgroundResource(R.mipmap.img_gradient_rect_bg);
            btnPay.setEnabled(true);
        } else {
            btnPay.setBackgroundColor(getResources().getColor(R.color.member_view_bg_color));
            btnPay.setText("已购买课程");
            btnPay.setEnabled(false);
        }

        textNameCoach.setText(clubLessonDetailBean.getRows().getTeacherList());
        textMinAmount.setText(clubLessonDetailBean.getRows().getOnlineBuyMinAmount() + "节");
        mMinNum = clubLessonDetailBean.getRows().getOnlineBuyMinAmount();
        textCoachLesson.setText(clubLessonDetailBean.getRows().getIntroduce());
        textNumberEvaluate.setText(clubLessonDetailBean.getRows().getTotalEvalCount() + "人");
        String mImgList = clubLessonDetailBean.getRows().getImageList();
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
//            list.add("http://p2.so.qhmsg.com/sdr/1620_1080_/t010735afa0402748f2.jpg");
//            list.add("http://mirror.aarnet.edu.au/pub/TED-talks/911Mothers_2010W-480p.mp4");
//            list.add("http://p2.so.qhmsg.com/sdr/1620_1080_/t010735afa0402748f2.jpg");
//            list.add("http://p2.so.qhmsg.com/sdr/1620_1080_/t010735afa0402748f2.jpg");
//            list.add("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
        }

        setBanner();

        if (clubLessonDetailBean.getRows().getPriceList().size() > 1) {

            textContent.setText(clubLessonDetailBean.getRows().getPriceList().get(0).getMinAmount()
                    + "-" + clubLessonDetailBean.getRows().getPriceList().get(0).getMaxAmount() + "节");
            textMoney.setText(clubLessonDetailBean.getRows().getPriceList().get(0).getPrice() + "元");
            ItemPayBean.PriceListBean PayBean = new ItemPayBean.PriceListBean();
            PayBean.setMaxAmount(clubLessonDetailBean.getRows().getPriceList().get(0).getMaxAmount());
            PayBean.setMinAmount(clubLessonDetailBean.getRows().getPriceList().get(0).getMinAmount());
            PayBean.setPrice(clubLessonDetailBean.getRows().getPriceList().get(0).getPrice());
            Paydatas.add(PayBean);

            try {
                for (int i = clubLessonDetailBean.getRows().getPriceList().size() - 1; i > 0; i--) {
                    ItemPayBean.PriceListBean bean = new ItemPayBean.PriceListBean();
                    bean.setMaxAmount(clubLessonDetailBean.getRows().getPriceList().get(i).getMaxAmount());
                    bean.setMinAmount(clubLessonDetailBean.getRows().getPriceList().get(i).getMinAmount());
                    bean.setPrice(clubLessonDetailBean.getRows().getPriceList().get(i).getPrice());
                    datas.add(bean);
                    Paydatas.add(bean);
                }

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
        } else if (clubLessonDetailBean.getRows().getPriceList().size() == 1) {
            textContent.setText(clubLessonDetailBean.getRows().getPriceList().get(0).getMinAmount()
                    + "-" + clubLessonDetailBean.getRows().getPriceList().get(0).getMaxAmount() + "节");
            textMoney.setText(clubLessonDetailBean.getRows().getPriceList().get(0).getPrice() + "元");
            ItemPayBean.PriceListBean PayBean = new ItemPayBean.PriceListBean();
            PayBean.setMaxAmount(clubLessonDetailBean.getRows().getPriceList().get(0).getMaxAmount());
            PayBean.setMinAmount(clubLessonDetailBean.getRows().getPriceList().get(0).getMinAmount());
            PayBean.setPrice(clubLessonDetailBean.getRows().getPriceList().get(0).getPrice());
            Paydatas.add(PayBean);

        } else {

            textContent.setText("0节");
            textMoney.setText("0元");
            ItemPayBean.PriceListBean PayBean = new ItemPayBean.PriceListBean();
            PayBean.setMaxAmount(1);
            PayBean.setMinAmount(0);
            PayBean.setPrice(0);
            Paydatas.add(PayBean);

        }

    }

    @SuppressLint({"ResourceAsColor", "ResourceType"})
    public void setBanner() {


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

            @Override
            public void onPageScrollStateChanged(int state) {
//                bannerViewHolder.mVideoView.release();

            }
        });


    }

    @OnClick({R.id.btn_back, R.id.btn_evaluate, R.id.btn_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
//                bannerViewHolder.mVideoView.release();
                finish();
                break;
            case R.id.btn_evaluate:
                Intent EvaluateListForLesson = new Intent(mContext, EvaluateListForLessonActivity.class);
                EvaluateListForLesson.putExtra(PUT_STR + "LessonId", LessonId);
                startActivity(EvaluateListForLesson);
                break;

            case R.id.btn_pay:
                if (MemberId.equals("0")){
                    Toast.makeText(mContext, "某些俱乐部没有会员卡不允许上课，详情请于俱乐部联系", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(mContext, PayActivity.class);
                    intent.putExtra(PUT_STR + "LessonId", LessonId);
                    intent.putExtra(PUT_STR + "TypeId", ID_PRIVATE_CLASS);
                    intent.putExtra(PUT_STR + "TeacherName", TeacherName);
                    intent.putExtra(PUT_STR + "TeacherId", TeacherId);
                    intent.putExtra(PUT_STR + "minNum", mMinNum);
                    intent.putExtra(PUT_STR + "PriceList", new Gson().toJson(Paydatas));
                    intent.putExtra(PUT_STR + "titleInfoBuy", "购买私教课");
                    intent.putExtra(PUT_STR + "textInfoBuy", InfoBuy);
                    intent.putExtra(PUT_STR + "TitleForFirst", "私教课教练");
                    intent.putExtra(PUT_STR + "TitleForSecond", "购买节数");
                    startActivity(intent);
                }
                break;
        }
    }


    public class BannerViewHolder implements MZViewHolder {
        public ImageView mImageView;
        public RelativeLayout layoutVideo;
//        public MyJZVideoPlayerStandard mVideoView;

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
//                mVideoView = new MyJZVideoPlayerStandard(context);
                //动态添加视频窗口到bananr
                ViewGroup.LayoutParams params = layoutVideo.getLayoutParams();
//                mVideoView.setLayoutParams(params);
//                mVideoView.setUp(list.get(i)
//                        , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "会所视频");
//                loadVideoScreenshot(mContext, list.get(i), mVideoView.thumbImageView, 1);
//                Glide.with(mContext).load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png").into(mVideoView.thumbImageView);
//                JZVideoPlayer.setJzUserAction(new MyUserActionStandard());
//                layoutVideo.addView(mVideoView);
                Banner.pause();

            } else {
                layoutVideo.setVisibility(View.INVISIBLE);
                // 数据绑定
                displayImage(context, list.get(i), R.mipmap.img_bg_bananr, mImageView);
            }
        }


    }

}


