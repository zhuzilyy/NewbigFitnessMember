package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyGroupClass.Details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyGroupClass.ClassEvaluationing.MyGroupClassEvaluationingActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyGroupLessonDetailBean;
import com.member.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.MEMBERIDKEY;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.RESULT_ID;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.TYPEGTOUPLESSON;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;

public class DetailsActivity extends BaseActivity<DetailsActivityPresenter> implements DetailsActivityContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_status)
    TextView textStatus;
    @BindView(R.id.text_name_lesson)
    TextView textNameLesson;
    @BindView(R.id.text_number_lesson)
    TextView textNumberLesson;
    @BindView(R.id.text_money_total)
    TextView textMoneyTotal;
    @BindView(R.id.text_teacher_lesson)
    TextView textTeacherLesson;
    @BindView(R.id.text_time_begin)
    TextView textTimeBegin;
    @BindView(R.id.text_time_expire)
    TextView textTimeExpire;
    @BindView(R.id.text_time_buy)
    TextView textTimeBuy;
    @BindView(R.id.btn_evaluate)
    TextView btnEvaluate;

    private MyGroupLessonDetailBean myGroupLessonDetailBean;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_details_my_groupclass;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
//
        setToolBar(toolbar, "");

        tvTitle.setText("团体课详情");

        btnComplete.setVisibility(View.GONE);


    }

    @Override
    protected void initData() {


        Intent intent = getIntent();
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        int Id =intent.getIntExtra(PUT_STR + "Id",0);
        final String MemberId = (String) SpUtil.get(mContext, MEMBERIDKEY, "");

        mPresenter.getMyGroupLessonDetail(ClubId,MemberId,Id,token);

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
    public void succeed(MyGroupLessonDetailBean myGroupLessonDetailBean)
  {
      this.myGroupLessonDetailBean=myGroupLessonDetailBean;
        textStatus.setText(TYPEGTOUPLESSON[myGroupLessonDetailBean.getRows().get(0).getStatus()]);
        textNameLesson.setText(myGroupLessonDetailBean.getRows().get(0).getGLessonName());

        textNumberLesson.setText(myGroupLessonDetailBean.getRows().get(0).getAmount()+"节");
        textMoneyTotal.setText(myGroupLessonDetailBean.getRows().get(0).getBuyMoney()+"元");
        textTeacherLesson.setText(myGroupLessonDetailBean.getRows().get(0).getLessonTeacherNames());
        textTimeBegin.setText(myGroupLessonDetailBean.getRows().get(0).getStartTime());
        textTimeExpire.setText(myGroupLessonDetailBean.getRows().get(0).getEndTime());
        textTimeBuy.setText(myGroupLessonDetailBean.getRows().get(0).getBuyTime());


    }


    @OnClick(R.id.btn_evaluate)
    public void onViewClicked() {
        Intent mDetailsActivity = new Intent(mContext, MyGroupClassEvaluationingActivity.class);
        mDetailsActivity.putExtra(PUT_STR + "GroupLessonId", myGroupLessonDetailBean.getRows().get(0).getGroupLessonId());
        mDetailsActivity.putExtra(PUT_STR + "GroupLessonName", myGroupLessonDetailBean.getRows().get(0).getGLessonName());
        mDetailsActivity.putExtra(RESULT_ID, "9999");
        startActivityForResult(mDetailsActivity, 9999);

    }
}


