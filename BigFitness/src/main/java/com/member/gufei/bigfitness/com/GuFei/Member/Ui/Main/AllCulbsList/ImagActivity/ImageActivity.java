package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.ImagActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.util.LoadImage.loadBgImg;


public class ImageActivity extends BaseActivity<ImageActivityPresenter> implements ImageActivityContract.View {
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.image_view)
    ImageView imageView;
    private String imageUrl;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_image_layout;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        imageUrl = intent.getStringExtra(PUT_STR + "imageurl");
        loadBgImg(mContext, imageUrl, R.mipmap.img_club_list, imageView);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void outLogin() {

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

    @OnClick(R.id.image_back)
    public void onViewClicked() {
        finish();
    }
}
