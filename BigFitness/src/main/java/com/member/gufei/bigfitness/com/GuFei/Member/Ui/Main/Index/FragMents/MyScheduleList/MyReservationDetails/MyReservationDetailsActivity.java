package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyReservationDetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.base.RecyclerviewBase.AdaptionLinearLayoutManager;
import com.member.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.member.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ItemPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ItemPlanBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyLessonAppDetailBean;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.widget.LinearLayout.VERTICAL;
import static com.member.gufei.bigfitness.Constants.MEMBERIDKEY;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.TYPEAPPOINTMENT;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.TimeUtil.compareNowDateTime;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

public class MyReservationDetailsActivity extends BaseActivity<MyReservationDetailsActivityPresenter> implements MyReservationDetailsActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_left)
    ImageView btnLeft;
    @BindView(R.id.btn_right)
    ImageView btnRight;
    @BindView(R.id.text_state)
    TextView textState;
    @BindView(R.id.text_name_lesson)
    TextView textNameLesson;
    @BindView(R.id.text_name_coach)
    TextView textNameCoach;
    @BindView(R.id.text_time)
    TextView textTime;

    @BindView(R.id.text_note_content)
    TextView textNoteContent;
    @BindView(R.id.btn_confirm)
    Button btnConfirm;
    @BindView(R.id.btn_cancel)
    Button btnCancel;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
    private List<String> list;
    private CommonAdapter<ItemPlanBean.PlanListBean> commonAdapter;
    private List<ItemPlanBean.PlanListBean> datas = new ArrayList<ItemPlanBean.PlanListBean>();
    int UserId;
    String token;
    String Clubid;
    String AppointmentId;
    String MemberId;
    int ClassStatus;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_resevation_details;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
//
        setToolBar(toolbar, "");

        tvTitle.setText("预约详情");

        btnLeft.setVisibility(View.GONE);
        btnRight.setVisibility(View.GONE);
        btnConfirm.setSelected(true);

        datas = new ArrayList<>();
        commonAdapter = new CommonAdapter<ItemPlanBean.PlanListBean>(R.layout.member_item_plan, mContext, datas) {
            @Override
            protected void convert(ViewHolder holder, final ItemPlanBean.PlanListBean msgBean, int position) {
                holder.setText(R.id.text_postion, msgBean.getPositionName());
                holder.setText(R.id.text_action, msgBean.getActionName());
            }
        };
        recyclerView.setAdapter(commonAdapter);
    }

    @Override
    protected void initData() {
        MemberId = (String) SpUtil.get(mContext, MEMBERIDKEY, "");
        Intent intent = getIntent();
        AppointmentId = intent.getStringExtra(PUT_STR + "AppointmentId");

        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        Clubid = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        mPresenter.getMyLessonAppDetail(
                String.valueOf(UserId), Clubid, token, MemberId, AppointmentId);

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
    public void succeed(MyLessonAppDetailBean myLessonAppDetailBean) {

        textNameLesson.setText(myLessonAppDetailBean.getRows().getLessonName());
        textNameCoach.setText(myLessonAppDetailBean.getRows().getTeacherName());
        textTime.setText(myLessonAppDetailBean.getRows().getStartTime() + "-" + myLessonAppDetailBean.getRows().getEndTime());
        ClassStatus = myLessonAppDetailBean.getRows().getClassStatus();
        textNoteContent.setText(myLessonAppDetailBean.getRows().getRemark());
//        if (ClassStatus == 1){
//            btnConfirm.setVisibility(View.GONE);
//            btnCancel.setVisibility(View.GONE);
//        }
//        if (myLessonAppDetailBean.getRows().getAppointmentCata() == 1) {
//
//            btnRight.setImageResource(R.mipmap.img_top_supply);
//            btnRight.setVisibility(View.VISIBLE);
//            btnConfirm.setVisibility(View.GONE);
//            btnCancel.setVisibility(View.GONE);
//        }
//        String n = "";
//
//        if (myLessonAppDetailBean.getRows().getIsExpire() == 0){
//            switch (myLessonAppDetailBean.getRows().getAppointmentStatus()) {
//                case 0:
//                    btnConfirm.setVisibility(View.VISIBLE);
//                    n = "自动取消";
//                    break;
//                case 1:
//                    btnConfirm.setVisibility(View.GONE);
////                    btnRight.setImageResource(R.mipmap.img_top_lesson);
//                    n = "成功预约";
//                    break;
//                default:
//                    btnConfirm.setVisibility(View.GONE);
//                    btnCancel.setVisibility(View.GONE);
//                    break;
//
//            }
//        }else {
//            btnConfirm.setVisibility(View.GONE);
//            btnCancel.setVisibility(View.GONE);
//        }


//        if (compareNowDateTime(myLessonAppDetailBean.getRows().getStartTime()) ) {
//
//            btnCancel.setVisibility(View.GONE);
//            btnConfirm.setVisibility(View.GONE);
//        }
        String n = "";
        if (myLessonAppDetailBean.getRows().getIsExpire() == 0){
            if (myLessonAppDetailBean.getRows().getAppointmentStatus() == 0){
                btnCancel.setVisibility(View.VISIBLE);
                n = "自动取消";
            }else {
                btnCancel.setVisibility(View.INVISIBLE);
                n = "成功预约";
            }
            switch (myLessonAppDetailBean.getRows().getAppointmentStatus()) {
                case 0:
                    if (myLessonAppDetailBean.getRows().getAppointmentOwner() == 0) {
                        btnConfirm.setVisibility(View.VISIBLE);
                    }else {
                        btnConfirm.setVisibility(View.INVISIBLE);
                    }
                    break;
                default:
                    btnConfirm.setVisibility(View.INVISIBLE);
                    break;

            }
        }else {
            btnConfirm.setVisibility(View.INVISIBLE);
            btnCancel.setVisibility(View.INVISIBLE);
        }
        textState.setText((myLessonAppDetailBean.getRows().getAppointmentOwner() == 0 ? "会员" : "教练") +
                TYPEAPPOINTMENT[myLessonAppDetailBean.getRows().getAppointmentStatus()] +
                (compareNowDateTime(myLessonAppDetailBean.getRows().getStartTime()) ? n: ""));

        datas = new ArrayList<ItemPlanBean.PlanListBean>();

        for (int i = 0; i < myLessonAppDetailBean.getRows().getPosition().size(); i++) {


            for (int j = myLessonAppDetailBean.getRows().getPosition().get(i).getActionName().size() - 1; j >= 0; j--) {
                ItemPlanBean.PlanListBean bean = new ItemPlanBean.PlanListBean();
                if (j == 0) {
                    bean.setPositionName(myLessonAppDetailBean.getRows().getPosition().get(i).getPositionName());
                } else {
                    bean.setPositionName("");
                }
                bean.setActionName(myLessonAppDetailBean.getRows().getPosition().get(i).getActionName().get(j));
                datas.add(bean);
            }


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


    }

    @Override
    public void succeedConfirm(CodeBean codeBean) {
        s(mContext, codeBean.getMsg());
        initData();
    }


    @OnClick({R.id.btn_left, R.id.btn_confirm, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_left:
                break;
            case R.id.btn_confirm:
                mPresenter.confirmLessonAppointment(
                        String.valueOf(UserId), Clubid, token, MemberId, AppointmentId
                );
                break;
            case R.id.btn_cancel:
                mPresenter.cancelMemberLessonAppointment(
                        String.valueOf(UserId), Clubid, token, MemberId, AppointmentId, "2");
                break;
        }
    }


}


