package com.member.gufei.bigfitness.com.GuFei.Member.Ui.QRCode.MyQRCode;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyTwoDimensionCodeBean;
import com.member.gufei.bigfitness.util.SpUtil;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.LoadImage.loadBgImg;
import static com.member.gufei.bigfitness.util.LoadImage.loadImgForRadius;
import static com.member.gufei.bigfitness.util.TimeUtil.compareNowDateTime;
import static com.member.gufei.bigfitness.util.ToastUtil.s;
import static com.uuzuche.lib_zxing.encoding.EncodingHandler.createQRCode;

public class MyQRCodeActivity extends BaseActivity<MyQRCodeActivityPresenter> implements MyQRCodeActivityContract.View {


    @BindView(R.id.img_qrcode)
    ImageView imgQrcode;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;

    @BindView(R.id.img_user_head)
    ImageView imgUserHead;
    @BindView(R.id.img_sex)
    ImageView imgSex;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.text_age)
    TextView textAge;


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_qrcode_my;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
//
        setToolBar(toolbar, "");

        tvTitle.setText("我的二维码");

        btnComplete.setVisibility(View.GONE);


//        // 位图
//        try {
//
//
//            Bitmap bitmap = createQRCode("asd", 500);
//            // 设置图片
//            imgQrcode.setImageBitmap(bitmap);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }


    }

    @Override
    protected void initData() {
        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        mPresenter.getMyTwoDimensionCode(String.valueOf(UserId), token);

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
    public void succeed(MyTwoDimensionCodeBean myTwoDimensionCodeBean) {
        textName.setText("昵称：" + myTwoDimensionCodeBean.getRows().getNickName());
        textAge.setText("年龄：" + myTwoDimensionCodeBean.getRows().getAge() + "岁");
        if (myTwoDimensionCodeBean.getRows().getSex() == 1) {
            imgSex.setImageResource(R.mipmap.img_men);
        } else {
            imgSex.setImageResource(R.mipmap.img_women);
        }
        loadImgForRadius(mContext, myTwoDimensionCodeBean.getRows().getHeaderURL(), R.mipmap.user_head_img, imgUserHead);
        if (myTwoDimensionCodeBean.getRet() == 0) {

            Bitmap mBitmap = CodeUtils.createImage(myTwoDimensionCodeBean.getRows().getTwoDimensionCode(), imgQrcode.getWidth(), imgQrcode.getWidth(), null);
            imgQrcode.setImageBitmap(mBitmap);


        }
    }

}


