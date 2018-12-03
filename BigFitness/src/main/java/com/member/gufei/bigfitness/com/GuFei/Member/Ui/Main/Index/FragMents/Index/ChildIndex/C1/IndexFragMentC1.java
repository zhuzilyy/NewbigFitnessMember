package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C1;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseFragment;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.CulbsEvaluateList.CulbsEvaluateListActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.ImgListForCulbs.ImgListForCulbsActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.WebView.MyWebViewActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubInfoByIdBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.DistanceClassTimeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.QueryScheduleDayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.member.gufei.bigfitness.util.MoveView.MoveTextView;
import com.member.gufei.bigfitness.util.MyRatingBar;
import com.member.gufei.bigfitness.util.SpUtil;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

import static com.member.gufei.bigfitness.Constants.INTERVAL;
import static com.member.gufei.bigfitness.Constants.ISLOCKKEY;
import static com.member.gufei.bigfitness.Constants.MEMBERIDKEY;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TIME1;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.GlideImageLoader.displayImage;
import static com.member.gufei.bigfitness.util.TimeUtil.getNowDate;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 * <p>
 * 实际业务人员主页
 */

@RuntimePermissions
public class IndexFragMentC1 extends BaseFragment<IndexFragMentC1Presenter> implements IndexFragMentC1Contract.View {


    @BindView(R.id.banner_normal)
    MZBannerView Banner;

    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.text_address_club)
    TextView textAddressClub;
    @BindView(R.id.text_time_business)
    TextView textTimeBusiness;
    @BindView(R.id.text_tel)
    TextView textTel;
    @BindView(R.id.text_more)
    TextView textMore;
    @BindView(R.id.btn_imgforclub)
    RelativeLayout btnImgforclub;
    @BindView(R.id.satr)
    ImageView satr;
    @BindView(R.id.number_text)
    TextView numberText;
    @BindView(R.id.img_number_star)
    MyRatingBar imgNumberStar;
    @BindView(R.id.btn_evaluate)
    RelativeLayout btnEvaluate;
    //    @BindView(R.id.tv_count_down)
//    TextView tvCountDown;
    Unbinder unbinder;
    @BindView(R.id.tv_move_view)
    MoveTextView tvMoveView;
    @BindView(R.id.tv_noMore)
    TextView tvNoMore;

    private Context context;
    private View viewContent;
    private int mType = 0;
    private String mTitle;
    private List<String> list;
    private boolean mFirstShow = true;
    private List<MainMsgBean.ResultBean> datas = new ArrayList<MainMsgBean.ResultBean>();
    private View contentView;
    private PopupWindow popupWindow;
    private int mLastX;
    private int mLastY;
    private int mDownX;
    private int mDownY;
    private final int ADAPTER_VALUE = 25;
    private FloatingActionButton actionButton;
    int UserId;
    String token;
    String Clubid;
    int LessonId;
    int AppointmentId;
    private int recLen;
    public MyCountDownTimer myCountDownTimer;
    String isDestory = "0";
    private int id;

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);


    }


    @Override
    public void onResume() {
        isDestory = "0";
        super.onResume();
        //refresh();
        Banner.start();


    }


    @Override
    public void onPause() {
        super.onPause();
        Banner.pause();
//        if (recLen > 0){
//            myCountDownTimer.cancelTimer();
//        }

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
      /*  if (isVisibleToUser) {
            if (!mFirstShow) {
                refresh();
                Banner.start();
            }

            //相当于Fragment的onResume

        } else {
            //相当于Fragment的onPause
//            Banner.pause();
        }*/
    }


    @Override
    protected void initInject() {

        getFragmentComponent().inject(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.member_fragment_index_c1;
    }


    private void refresh() {
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        Clubid = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        mPresenter.clubInfoById(Clubid, String.valueOf(UserId), token);
        //悬浮按钮
        mPresenter.quanquan(String.valueOf(UserId),
                Clubid,
                token,
                getNowDate(),
                getNowDate(),
                "1");

    }


    @Override
    protected void initData() {
        refresh();

        imgNumberStar.setClickable(false);

//        setTimeShow(1, "asd", "abc");
//        DragViewUtil.drag(tvCountDown);
        tvMoveView.setMovementMethod(ScrollingMovementMethod.getInstance());
        tvMoveView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // 通知ScrollView控件不要干扰
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    // 通知ScrollView控件不要干扰
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }

        });

    }

    @OnClick({R.id.btn_imgforclub, R.id.btn_evaluate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_imgforclub:
                Intent mImgListIntent = new Intent(mContext, ImgListForCulbsActivity.class);
                startActivity(mImgListIntent);
                if (recLen > 0) {
                    myCountDownTimer.cancel();
                }
                break;
            case R.id.btn_evaluate:

                Intent intent = new Intent(mContext, CulbsEvaluateListActivity.class);
                startActivity(intent);
                if (recLen > 0) {
                    myCountDownTimer.cancel();
                }
                break;
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
        isDestory = "1";
        super.onDestroyView();
        unbinder.unbind();
        if (myCountDownTimer != null) {
            myCountDownTimer.cancel();
            myCountDownTimer = null;
        }


//        if (recLen > 0){
//            myCountDownTimer.cancelTimer();
//        }
    }

    public class BannerViewHolder implements MZViewHolder {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.member_banner_item, null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int i, Object o) {
            // 数据绑定
            displayImage(context, list.get(i), R.mipmap.img_bg_bananr, mImageView);
        }

//        R.mipmap.img_bg_bananr
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
    public void succeed(final ClubInfoByIdBean clubInfoByIdBean) {
        mFirstShow = false;
        String ss = new Gson().toJson(clubInfoByIdBean);
        Log.e("营业时间", ss);


        textTitle.setText(clubInfoByIdBean.getRows().getClubName());

        textAddressClub.setText(clubInfoByIdBean.getRows().getAddress());
        textTimeBusiness.setText("营业时间:" + clubInfoByIdBean.getRows().getBusinessStartHours() + "-" + clubInfoByIdBean.getRows().getBusinessEndHours());
        textTel.setText(clubInfoByIdBean.getRows().getTel());
        textMore.setText(clubInfoByIdBean.getRows().getIntroduce());
        numberText.setText(clubInfoByIdBean.getRows().getEvaluateSum() + "人");
        imgNumberStar.setStar((float) clubInfoByIdBean.getRows().getEvaluateStar());
//保存所选会所的memberId
        SpUtil.put(mContext, MEMBERIDKEY, String.valueOf(clubInfoByIdBean.getRows().getMemberId()));
        SpUtil.put(mContext, ISLOCKKEY, String.valueOf(clubInfoByIdBean.getRows().getIsLock()));
        list = new ArrayList<String>();

        if (clubInfoByIdBean.getRows().getImages().size() != 0) {
            tvNoMore.setVisibility(View.GONE);
            for (int i = 0; i < clubInfoByIdBean.getRows().getImages().size(); i++) {

                list.add(clubInfoByIdBean.getRows().getImages().get(i).getImageURL());

            }
        }else {
            tvNoMore.setVisibility(View.VISIBLE);
        }

        // 设置数据
        Banner.setPages(list, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
//        imgNumberStar.setImageResource(R.mipmap.class.getDeclaredField("star_" + String.valueOf((int) clubInfoByIdBean.getRows().getEvaluateStar())).getInt(null));

        Banner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int i) {
//                s(mContext, i + "----------------" + i);
                id = clubInfoByIdBean.getRows().getImages().get(i).getId();
                Intent intent = new Intent(mContext, MyWebViewActivity.class);
                intent.putExtra(PUT_STR + "id", String.valueOf(id));
                startActivity(intent);
            }
        });
    }

    @Override
    public void succeedquan(QueryScheduleDayBean queryScheduleDayBean) {
        LessonId = queryScheduleDayBean.getRows().get(0).getLessonId();
        AppointmentId = queryScheduleDayBean.getRows().get(0).getAppointmentId();
        if (!queryScheduleDayBean.getRows().equals("")) {
            mPresenter.getClassTime(String.valueOf(UserId),
                    token,
                    Clubid,
                    String.valueOf(LessonId),
                    String.valueOf(AppointmentId)
            );
            tvMoveView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void succeedClassUp(DistanceClassTimeBean distanceClassTimeBean) {
        recLen = distanceClassTimeBean.getRows().getDistanceClassStartTime();

        myCountDownTimer = new MyCountDownTimer(recLen * TIME1, INTERVAL);
        myCountDownTimer.start();
//        myCountDownTimer.setDownTimerInterface(new DownTimerInterface() {
//
//            @Override
//            public void setText(String time) {
//
//                tvMoveView.setText(time);
//
//            }
//
//            @Override
//            public void setSecText(String time) {
//
//            }
//
//            @Override
//            public void setThirdText(String time) {
//
//            }
//        });
//
//            myCountDownTimer.startTimer();

    }


    @Override
    public void succeedClassDown(DistanceClassTimeBean distanceClassTimeBean) {

    }


    private boolean rangeInDefined(int down, int small, int large) {
        if (small < down && down < large) {
            return true;
        }
        return false;
    }


    public void oncancel(View view) {
        myCountDownTimer.cancel();
    }

    public void restart(View view) {
        myCountDownTimer.start();
    }


    /**
     * 自定义倒计时类
     */
    class MyCountDownTimer extends CountDownTimer {

        /**
         * @param millisInFuture    表示以毫秒为单位 倒计时的总数
         *                          <p/>
         *                          例如 millisInFuture=1000 表示1秒
         * @param countDownInterval 表示 间隔 多少微秒 调用一次 onTick 方法
         *                          <p/>
         *                          例如: countDownInterval =1000 ;
         *                          表示每1000毫秒调用一次onTick()
         */

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long time = millisUntilFinished / 1000;
            if (isDestory.equals("0")) {

                if (time <= 59) {
//            floatTips.setText();
                    tvMoveView.setText(String.format("00:00:%02d", time));
//                downTimerInterface.setSecText(String.format("00:%02d", time));
//                downTimerInterface.setThirdText(String.format("%02d", time));
                } else if (time > 3600) {
                    tvMoveView.setText(String.format("%02d:%02d:%02d", time / 3600, (time % 3600) / 60, time % 60));

                } else {
                    tvMoveView.setText(String.format("00:%02d:%02d", time / 60, time % 60));
                }
            }


        }

        @Override
        public void onFinish() {
            tvMoveView.setText("done");
        }
    }


}

