package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.DetailsActivated;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.MyPrivateRenewal.MyPrivateRenewalActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Schedule.WeekViewForDay.WeekViewForDayActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonDetailBean;
import com.member.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.ID_ACTIVITY_APPOINTMEN;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;

public class MyPrivateDetailsActivatedActivity extends BaseActivity<MyPrivateDetailsActivatedActivityPresenter> implements MyPrivateDetailsActivatedActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_status)
    TextView textStatus;
    @BindView(R.id.text_contract_number)
    TextView textContractNumber;
    @BindView(R.id.text_lesson)
    TextView textLesson;
    @BindView(R.id.text_lesson_number)
    TextView textLessonNumber;
    @BindView(R.id.text_lesson_money)
    TextView textLessonMoney;
    @BindView(R.id.text_nam_coach)
    TextView textNamCoach;
    @BindView(R.id.text_residue_number)
    TextView textResidueNumber;
    @BindView(R.id.text_time)
    TextView textTime;
    @BindView(R.id.btn4)
    TextView btn4;
    @BindView(R.id.btn5)
    TextView btn5;
    int LessonId;
    private AppGetMyMemberLessonDetailBean detailBean;
    int Id;
    String LessonName;
    int OnlineAddFeeMinAmount;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_activated_my_private;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("私教课详情");

        Intent intent = getIntent();
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        Id = intent.getIntExtra(PUT_STR + "id", 0);
        String Status = intent.getStringExtra(PUT_STR + "Status");
        LessonId= intent.getIntExtra(PUT_STR + "LessonId", 0);
        OnlineAddFeeMinAmount = intent.getIntExtra(PUT_STR + "AddFeeMinAmount", 0);
        int type = intent.getIntExtra(PUT_STR + "type",0);
        if (type==ID_ACTIVITY_APPOINTMEN) {
            btn4.setVisibility(View.INVISIBLE);
            btn5.setVisibility(View.INVISIBLE);

            btnComplete.setText("");
            btnComplete.setVisibility(View.VISIBLE);
        }else {
            btn5.setVisibility(View.GONE);
        }
        textStatus.setText("已激活");
        String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        mPresenter.appGetMyMemberLessonDetail(String.valueOf(UserId), ClubId, String.valueOf(Id), Status, token);


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
    public void succeed(AppGetMyMemberLessonDetailBean appGetMyMemberLessonDetailBean) {
        detailBean=appGetMyMemberLessonDetailBean;
        LessonName = detailBean.getRows().getLessonName();
        textLesson.setText(appGetMyMemberLessonDetailBean.getRows().getLessonName());
        textContractNumber.setText(appGetMyMemberLessonDetailBean.getRows().getBargainNo());
        textLessonNumber.setText(appGetMyMemberLessonDetailBean.getRows().getTotalBuyCount() + "节");
        textLessonMoney.setText(appGetMyMemberLessonDetailBean.getRows().getTotalBuyMoney() + "元");
        textNamCoach.setText(appGetMyMemberLessonDetailBean.getRows().getTeacherName());
        textTime.setText(appGetMyMemberLessonDetailBean.getRows().getStopTime());
        textResidueNumber.setText(appGetMyMemberLessonDetailBean.getRows().getBalance() + "/" + appGetMyMemberLessonDetailBean.getRows().getTotalBuyCount() + "节");

    }


    @OnClick({R.id.btn4, R.id.btn5, R.id.btn_complete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn4:
                //续费
                Intent intent = new Intent(mContext, MyPrivateRenewalActivity.class);
                intent.putExtra(PUT_STR + "MemberLessonTypeId", Id);
                intent.putExtra(PUT_STR + "LessonName",LessonName);
                intent.putExtra(PUT_STR + "AddFeeMinAmount", OnlineAddFeeMinAmount);
                intent.putExtra(PUT_STR + "LessonId", LessonId);
                startActivity(intent);
                break;
            case R.id.btn5:
                //预约
                break;

            case R.id.btn_complete:


//                Intent intent = new Intent(mContext, WeekViewForDayActivity.class);
//
//                intent.putExtra(PUT_STR + "LessonId",LessonId);
//
//                intent.putExtra(PUT_STR + "LessonName",String.valueOf(detailBean.getRows().getLessonName()));
//                intent.putExtra(PUT_STR + "TeacherName",String.valueOf(detailBean.getRows().getTeacherName()));
//                startActivity(intent);


                break;
        }
    }
}


