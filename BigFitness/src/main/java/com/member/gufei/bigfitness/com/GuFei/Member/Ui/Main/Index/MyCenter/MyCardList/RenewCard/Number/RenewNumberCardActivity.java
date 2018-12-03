package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.RenewCard.Number;

import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;

import butterknife.BindView;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.App.SCREEN_WIDTH;

public class RenewNumberCardActivity extends BaseActivity<RenewNumberCardActivityPresenter> implements RenewNumberCardActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
//    @BindView(R.id.btn_time_begin)
//    RelativeLayout btnTimeBegin;
    private View contentView;
    private PopupWindow popupWindow;

    @Override
    protected void initInject() {
//        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_upgrade_my_card;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
//
        setToolBar(toolbar, "");

        tvTitle.setText("会员卡续费");

        btnComplete.setVisibility(View.GONE);


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
    public void succeed(PublicSeaBean publicSeaBean) {

    }

    @Override
    public void succeedEdit(CodeBean codeBean) {

    }

    @Override
    public void succeedoperate() {

    }

    @Override
    public void membersucceed(PublicSeaMemberBean publicSeaBean) {

    }

    public void SelectPopup(View v, final int tag) {
        if (contentView != null) contentView = null;
        if (popupWindow != null) popupWindow = null;
        // 一个自定义的布局，作为显示的内容

//        switch (type) {
//            case ACTIVITY_ID_CUSTOMER:
//                mHight = App.SCREEN_HEIGHT / 10 * 9;
//                break;
//            case ACTIVITY_ID_NON_CUSTOMER:
        int mHight = App.SCREEN_HEIGHT / 10 * 9;
//                break;
//        }

        contentView = LayoutInflater.from(this).inflate(R.layout.member_pop_view_card, null);
        popupWindow = new PopupWindow(contentView,SCREEN_WIDTH-200 ,  ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });

//        final RelativeLayout btnPublicSea = (RelativeLayout) contentView.findViewById(R.id.btn_publicsea);
//        final TextView TimeEnd = (TextView) contentView.findViewById(R.id.second_time_end);
//        final TextView TimeBegin = (TextView) contentView.findViewById(R.id.second_time_begin);
//        final TextView textPublicSea = (TextView) contentView.findViewById(R.id.text_publicsea);
//
//
//        btnPublicSea.setVisibility(mtype != 0 ? View.GONE : View.VISIBLE);


        //        final TextView textLabel = (TextView) contentViekehu kehu kehu  w.findViewById(R.id.text_label);
//        final TextView btnreset = (TextView) contentView.findViewById(R.id.btn_reset);
//        final TextView btnconfirm = (TextView) contentView.findViewById(R.id.btn_confirm);

//        textPublicSea.setText(mPostCustomerListBean.getPublicSeaName());

//        final ImageView btnReferences = (ImageView) contentView.findViewById(R.id.btn_references);
//        final ImageView btnSource = (ImageView) contentView.findViewById(R.id.btn_source);
//        final ImageView btnIntention = (ImageView) contentView.findViewById(R.id.btn_intention);
//        final ImageView btnLabel = (ImageView) contentView.findViewById(R.id.btn_label);
//        final ImageView btnConsultant = (ImageView) contentView.findViewById(R.id.btn_consultant);
//        final ImageView btnCollect = (ImageView) contentView.findViewById(R.id.btn_collect);
//        textLabel.setText(mPostCustomerListBean.getLabelName());//标签
//        textConsultant.setText(mPostCustomerListBean.getOwnManagerName());//会籍顾问
//        textReferences.setText(mPostCustomerListBean.getIntroduceMemberName());//介绍人
//        textIntention.setText(mPostCustomerListBean.getIntentName());//意向
//        textSource.setText(mPostCustomerListBean.getSourceName());//来源
//        switch (layoutId) {
//            case R.layout.pop_view_customer_screening:
//                //客户列表
//                break;
//            case R.layout.pop_view_non_customer_screening:
//                //过期会员列表
//                TextView textCoachPos = (TextView) contentView.findViewById(R.id.text_coach_pos);
//                TextView textCoachTrack = (TextView) contentView.findViewById(R.id.text_coach_track);
//                textCoachPos.setText(mPostCustomerListBean.getPOSTeacherName());//POS教练
//                textCoachTrack.setText(mPostCustomerListBean.getOwnTeacherName());//跟踪教练
//                break;
//        }
//
//        popupWindow.update();
////        backgroundAlpha(0.5f);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
//                final Intent intent = new Intent(PublicSeaListActivity.this, FilterListActivity.class);
//                final String mStrType = "com.member.gufei.bigfitness.com.GuFei.Ui.main.type";
////                //要传递的值
////                intent.putExtra("reValue", "Main Send Data!");
//                //启动Activity
//                btnPublicSea.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        //标签
//                        popupWindow.dismiss();
//                        intent.putExtra(mStrType, PUBLICSEATYPEID);
////                        startActivity(intent);
//                        startActivityForResult(intent, PUBLICSEATYPEID);//使用时需定义变量requestCode
//                    }
//                });

                return false;

                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));
        // 设置好参数之后再show
        //获取点击View的坐标

        int[] point = {0, 0};

        v.getLocationOnScreen(point);

//        popupWindow.showAtLocation(v, Gravity.CENTER, 0, point[1] + v.getHeight());
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 150);


//        popupWindow.setAnimationStyle(R.style.take_photo_anim);
    }

//    @OnClick(R.id.btn_time_begin)
//    public void onViewClicked(View view) {
//
//        SelectPopup(view,0);
//
//    }
}


