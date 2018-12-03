package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.CardEvaluationing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.member.gufei.bigfitness.Presenter.SpinnerPopContract;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;

import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;
import com.member.gufei.bigfitness.util.MyRatingBar;
import com.member.gufei.bigfitness.util.SpUtil;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.yanzhenjie.album.Album;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.App.context;
import static com.member.gufei.bigfitness.Constants.ACTIVITY_REQUEST_SELECT_PHOTO;
import static com.member.gufei.bigfitness.Constants.CUSTOMERINTRODUCERID;
import static com.member.gufei.bigfitness.Constants.CUSTOMERSOURCEID;
import static com.member.gufei.bigfitness.Constants.CUSTOMERTAGID;
import static com.member.gufei.bigfitness.Constants.MEMBERINTENTID;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.RESULT_ID;
import static com.member.gufei.bigfitness.Constants.RESULT_SEX;
import static com.member.gufei.bigfitness.Constants.RESULT_STRING;
import static com.member.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.member.gufei.bigfitness.Constants.RESULT_TEL;
import static com.member.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.util.BitmapUtil.Bitmap2StrByBase64;
import static com.member.gufei.bigfitness.util.LoadImage.ImagLoader;
import static com.member.gufei.bigfitness.util.LoadImage.loadBgImg;
import static com.member.gufei.bigfitness.util.ToastUtil.s;


/*
* 修改昵称
*
*
* */
public class CardEvaluationingActivity extends BaseActivity<CardEvaluationingActivityPresenter> implements SpinnerPopContract, CardEvaluationingActivityContract.View {


    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.text_name_card_grade)
    TextView textNameCardGrade;
    @BindView(R.id.text_type_card)
    TextView textTypeCard;
    @BindView(R.id.ratingbar_star)
    MyRatingBar ratingbarStar;
    @BindView(R.id.edit_evaluate)
    EditText editEvaluate;
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.btn_del_1)
    ImageView btnDel1;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.btn_del_2)
    ImageView btnDel2;
    @BindView(R.id.img3)
    ImageView img3;
    @BindView(R.id.btn_del_3)
    ImageView btnDel3;
    @BindView(R.id.rb_ecaluate)
    RadioButton rbEcaluate;

    private String imgsrc;
    int UserId;
    String token;
    String Id;
    int ImgSelected;
    int mStar;
    List<String> pathList=null;
    String MemberCardId;
    String MemberCardType;
    String NumberRemaining;
    String TimeExpire;
    String ClubId;
    String EvaluateContent;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_card_evaluationing;

    }

    @Override
    protected void initView() {

//        toolbar.setNavigationIcon(R.mipmap.left);
//
//        setToolBar(toolbar, "");

        mainTitle.setText("评价");
        Intent intent = getIntent();
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");

        // TODO: 2018/4/7 ClubId为假数据
        ClubId =(String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        Id = intent.getStringExtra(PUT_STR + "Id");
        MemberCardId = intent.getStringExtra(PUT_STR + "MemberCardId");
        NumberRemaining = intent.getStringExtra(PUT_STR + "NumberRemaining");
        MemberCardType = intent.getStringExtra(PUT_STR + "MemberCardType");
        TimeExpire = intent.getStringExtra(PUT_STR + "TimeExpire");

        textTypeCard.setText(MemberCardType);

        ratingbarStar.setOnRatingChangeListener(new MyRatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float ratingCount) {
                mStar= (int) ratingCount;
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

        s(this, "您的帐号在其他设备登录");
        Intent intent = new Intent(mContext, LoginActivity.class);
        remove();

        startActivity(intent);

    }


    @Override
    public void dismiss() {
        backgroundAlpha(1f);
    }

    @Override
    public void Success(CodeBean codeBean) {

        if (codeBean.getRet()==0){

            s(this, "评价成功!");
            finish();
        }

    }

    @OnClick({R.id.btn_back, R.id.img1, R.id.btn_del_1, R.id.img2, R.id.btn_del_2, R.id.img3, R.id.btn_del_3, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.img1:
                ImgSelected=1;
                Album.startAlbum(this, ACTIVITY_REQUEST_SELECT_PHOTO
                        , 3                                                         // 指定选择数量。
                        , ContextCompat.getColor(this, R.color.colorPrimary)        // 指定Toolbar的颜色。
                        , ContextCompat.getColor(this, R.color.colorPrimaryDark));  // 指定状态栏的颜色。
                break;
            case R.id.btn_del_1:
                pathList.set(0,"");
                img1.setImageDrawable(getResources().getDrawable(R.mipmap.img_evaluation));
                break;
            case R.id.img2:
                ImgSelected=2;
                Album.startAlbum(this, ACTIVITY_REQUEST_SELECT_PHOTO
                        , 3                                                         // 指定选择数量。
                        , ContextCompat.getColor(this, R.color.colorPrimary)        // 指定Toolbar的颜色。
                        , ContextCompat.getColor(this, R.color.colorPrimaryDark));  // 指定状态栏的颜色。
                break;
            case R.id.btn_del_2:
                pathList.set(1,"");
                img2.setImageDrawable(getResources().getDrawable(R.mipmap.img_evaluation));
                break;
            case R.id.img3:
                ImgSelected=3;
                Album.startAlbum(this, ACTIVITY_REQUEST_SELECT_PHOTO
                        , 3                                                         // 指定选择数量。
                        , ContextCompat.getColor(this, R.color.colorPrimary)        // 指定Toolbar的颜色。
                        , ContextCompat.getColor(this, R.color.colorPrimaryDark));  // 指定状态栏的颜色。
                break;
            case R.id.btn_del_3:
                pathList.set(2,"");
                img3.setImageDrawable(getResources().getDrawable(R.mipmap.img_evaluation));
                break;
            case R.id.btn_submit:
                EvaluateContent = editEvaluate.getText().toString();
                for (int i = 0; i < pathList.size(); i++) {
                    imgsrc += Bitmap2StrByBase64(pathList.get(i));
                }

                mPresenter.ClubEvaluate(String.valueOf(UserId),
                        ClubId,
                        token,
                        String.valueOf(mStar),
                        EvaluateContent,
                        imgsrc,
                        rbEcaluate.isChecked()?"1":"0");
                break;
        }
    }

    /*
  *
  * 图片回调
  * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) { // 判断是否成功。
                // 拿到用户选择的图片路径List：
                List<String>  mTmpPathList = Album.parseResult(data);
               pathList = new ArrayList<String>();
//                imgsrc = "";

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 2;
                Bitmap bm = BitmapFactory.decodeFile(mTmpPathList.get(0), options);


                if (mTmpPathList.size() == 1) {

//                    pathList.set(ImgSelected - 1, mTmpPathList.get(0));

                    pathList.add(mTmpPathList.get(0));

//                    imgsrc = Bitmap2StrByBase64(pathList.get(0));
                    switch (ImgSelected) {
                        case 1:
                            img1.setImageBitmap(bm);
                            break;
                        case 2:
                            img2.setImageBitmap(bm);
                            break;
                        case 3:
                            img3.setImageBitmap(bm);
                            break;
                    }
                } else {

                    for (int i = 0; i < mTmpPathList.size(); i++) {
//                        pathList.set(ImgSelected - 1, mTmpPathList.get(i));
                        pathList.add(mTmpPathList.get(i));
//                    imgsrc += Bitmap2StrByBase64(pathList.get(i));
                        try {
                            ImageView imageView = (ImageView) id(R.id.class.getDeclaredField("img" + String.valueOf(i + 1)).getInt(null));


                            ImagLoader(this,mTmpPathList.get(i),R.mipmap.null_img,imageView);

                        } catch (IllegalAccessException e) {

                            e.printStackTrace();

                        } catch (NoSuchFieldException e) {

                            e.printStackTrace();

                        }

                    }
                }
            }

        } else if (resultCode == RESULT_CANCELED) { // 用户取消选择。
            // 根据需要提示用户取消了选择。
        }
    }
}


