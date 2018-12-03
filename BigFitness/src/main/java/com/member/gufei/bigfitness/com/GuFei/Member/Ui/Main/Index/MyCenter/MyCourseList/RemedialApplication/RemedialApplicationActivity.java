package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCourseList.RemedialApplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;


/**
 * Created by LiuShengYuan on 2018/10/12
 */

public class RemedialApplicationActivity extends BaseActivity<RemedialApplicationActivityPresenter> implements RemedialApplicationActivityContract.View {
    @BindView(R.id.iv_remedial_back)
    ImageView ivRemedialBack;
    @BindView(R.id.edit_reason)
    EditText editReason;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;

     int UserId;
     String token;
     String ClubId;
     String AppointmentId;
     String LessonId;
     String Cause;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_remedial_application;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");

        AppointmentId = intent.getStringExtra(PUT_STR + "AppointmentId");
        LessonId = intent.getStringExtra(PUT_STR + "LessonId");
    }

    @Override
    protected void initData() {

    }

    @Override
    public void outLogin() {

    }

    @Override
    public void succeed(CodeBean codeBean) {
        Toast.makeText(mContext, "补课申请提交成功！", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void Loading() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_remedial_back, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_remedial_back:
                finish();
                break;
            case R.id.tv_submit:
                Cause = editReason.getText().toString();
                mPresenter.getAddLessonMakeUp(String.valueOf(UserId),
                        ClubId,
                        token,
                        LessonId,
                        AppointmentId,
                        Cause);
                break;
        }
    }
}
