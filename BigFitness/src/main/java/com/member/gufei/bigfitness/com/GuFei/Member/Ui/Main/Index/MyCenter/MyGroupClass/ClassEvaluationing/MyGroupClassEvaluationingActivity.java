package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyGroupClass.ClassEvaluationing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.member.gufei.bigfitness.Presenter.SpinnerPopContract;
import com.member.gufei.bigfitness.Presenter.SpinnerPopupWindow;
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

import static com.member.gufei.bigfitness.Constants.ACTIVITY_REQUEST_SELECT_PHOTO;
import static com.member.gufei.bigfitness.Constants.CUSTOMERINTRODUCERID;
import static com.member.gufei.bigfitness.Constants.CUSTOMERSOURCEID;
import static com.member.gufei.bigfitness.Constants.CUSTOMERTAGID;
import static com.member.gufei.bigfitness.Constants.MEMBERIDKEY;
import static com.member.gufei.bigfitness.Constants.MEMBERINTENTID;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.RESULT_ID;
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
 * 课程评价
 *
 *
 * */
public class MyGroupClassEvaluationingActivity extends BaseActivity<MyGroupClassEvaluationingActivityPresenter> implements SpinnerPopContract, MyGroupClassEvaluationingActivityContract.View {


    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.btn_edit)
    TextView btnEdit;
    @BindView(R.id.main_head_layout)
    RelativeLayout mainHeadLayout;
    @BindView(R.id.text_name_class_grade)
    TextView textNameClassGrade;
    @BindView(R.id.layout_top_class)
    RelativeLayout layoutTopClass;
    @BindView(R.id.edit_evaluate)
    EditText editEvaluate;
    @BindView(R.id.line_1)
    LinearLayout line1;
    @BindView(R.id.img_1)
    ImageView img1;
    @BindView(R.id.btn_del_1)
    ImageView btnDel1;
    @BindView(R.id.img_2)
    ImageView img2;
    @BindView(R.id.btn_del_2)
    ImageView btnDel2;
    @BindView(R.id.img_3)
    ImageView img3;
    @BindView(R.id.btn_del_3)
    ImageView btnDel3;
    @BindView(R.id.layout_img)
    LinearLayout layoutImg;
    @BindView(R.id.line_2)
    LinearLayout line2;
    @BindView(R.id.layout_coach)
    LinearLayout layoutCoach;
    @BindView(R.id.rb_ecaluate)
    RadioButton rbEcaluate;
    @BindView(R.id.layout_rb_ecaluate)
    LinearLayout layoutRbEcaluate;
    @BindView(R.id.btn_submit)
    TextView btnSubmit;
    @BindView(R.id.ratingbar_star)
    MyRatingBar ratingbarStar;
    @BindView(R.id.activity_address_details)
    LinearLayout activityAddressDetails;


    private int GroupLessonId;
    private String GroupLessonName;
    int ImgSelected;
    int mStar;
    String MemberId;
    private String imgsrc;
    List<String> pathList = null;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_groupclass_evaluationing;

    }

    @Override
    protected void initView() {
        pathList = new ArrayList<String>();
//        toolbar.setNavigationIcon(R.mipmap.left);
//
//        setToolBar(toolbar, "");

        mainTitle.setText("评价");

        btnEdit.setVisibility(View.INVISIBLE);

//        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
//
//        int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
//
//        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
//
//        int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
//
        Intent intent = getIntent();
        MemberId = (String) SpUtil.get(mContext, MEMBERIDKEY, "");
        GroupLessonId = intent.getIntExtra(PUT_STR + "GroupLessonId", 0);
        GroupLessonName = intent.getStringExtra(PUT_STR + "GroupLessonName");
//
//        mPresenter.getCustomerInfoById(UserId, token, ClubId, UserName, CustomerId);
//
        ratingbarStar.setOnRatingChangeListener(new MyRatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float ratingCount) {
                mStar = (int) ratingCount;
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
        s(mContext, "评价成功");
        finish();
    }

    @OnClick({R.id.btn_back, R.id.img_1, R.id.btn_del_1, R.id.img_2, R.id.btn_del_2, R.id.img_3, R.id.btn_del_3, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.img_1:
                ImgSelected = 1;
                Album.startAlbum(this, ACTIVITY_REQUEST_SELECT_PHOTO
                        , 3                                                         // 指定选择数量。
                        , ContextCompat.getColor(this, R.color.colorPrimary)        // 指定Toolbar的颜色。
                        , ContextCompat.getColor(this, R.color.colorPrimaryDark));  // 指定状态栏的颜色。
                break;
            case R.id.btn_del_1:
                pathList.remove(0);
                delRefresh1();
                break;
            case R.id.img_2:
                ImgSelected = 2;
                Album.startAlbum(this, ACTIVITY_REQUEST_SELECT_PHOTO
                        , 3                                                         // 指定选择数量。
                        , ContextCompat.getColor(this, R.color.colorPrimary)        // 指定Toolbar的颜色。
                        , ContextCompat.getColor(this, R.color.colorPrimaryDark));  // 指定状态栏的颜色。
                break;
            case R.id.btn_del_2:
                pathList.remove(1);
                delRefresh1();
                break;
            case R.id.img_3:
                ImgSelected = 3;
                Album.startAlbum(this, ACTIVITY_REQUEST_SELECT_PHOTO
                        , 3                                                         // 指定选择数量。
                        , ContextCompat.getColor(this, R.color.colorPrimary)        // 指定Toolbar的颜色。
                        , ContextCompat.getColor(this, R.color.colorPrimaryDark));  // 指定状态栏的颜色。
                break;
            case R.id.btn_del_3:
                pathList.remove(2);
                delRefresh1();
                break;
            case R.id.btn_submit:

                for (int i = 0; i < pathList.size(); i++) {
                    imgsrc += Bitmap2StrByBase64(pathList.get(i));
                }


                int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

                String token = (String) SpUtil.get(mContext, TOKENKEY, "");

                String ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
//
                mPresenter.GroupLessonEvaluate(MemberId, ClubId, token, String.valueOf(GroupLessonId), String.valueOf(mStar), editEvaluate.getText().toString(), imgsrc, rbEcaluate.isChecked() ? "1" : "0");
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
                List<String> mTmpPathList = Album.parseResult(data);

//                imgsrc = "";

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 2;
                Bitmap bm = BitmapFactory.decodeFile(mTmpPathList.get(0), options);


                if (mTmpPathList.size() == 1) {

                    pathList.add(mTmpPathList.get(0));


//                    imgsrc = Bitmap2StrByBase64(pathList.get(0));
                    switch (ImgSelected) {
                        case 1:
                            img1.setImageBitmap(bm);
                            btnDel1.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            img2.setImageBitmap(bm);
                            btnDel2.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            img3.setImageBitmap(bm);
                            btnDel3.setVisibility(View.VISIBLE);
                            break;
                    }
                } else {
                    pathList.addAll(mTmpPathList);
                    for (int i = 0; i < pathList.size(); i++) {
//                    imgsrc += Bitmap2StrByBase64(pathList.get(i));
                        try {
                            ImageView imageView = (ImageView) id(R.id.class.getDeclaredField("img_" + String.valueOf(i + 1)).getInt(null));
                            ImageView imageView1 = (ImageView) id(R.id.class.getDeclaredField("btn_del_" + String.valueOf(i + 1)).getInt(null));
                            imageView1.setVisibility(View.VISIBLE);
                            ImagLoader(this, pathList.get(i), R.mipmap.null_img, imageView);

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

    public void delRefresh1() {
        img1.setImageDrawable(getResources().getDrawable(R.mipmap.img_evaluation));
        img2.setImageDrawable(getResources().getDrawable(R.mipmap.img_evaluation));
        img3.setImageDrawable(getResources().getDrawable(R.mipmap.img_evaluation));
        btnDel1.setVisibility(View.GONE);
        btnDel2.setVisibility(View.GONE);
        btnDel3.setVisibility(View.GONE);
        for (int i = 0; i < pathList.size(); i++) {
            ImageView imageView = null;
            try {
                imageView = (ImageView) id(R.id.class.getDeclaredField("img_" + String.valueOf(i + 1)).getInt(null));
                ImageView imageView1 = (ImageView) id(R.id.class.getDeclaredField("btn_del_" + String.valueOf(i + 1)).getInt(null));
                imageView1.setVisibility(View.VISIBLE);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            if (pathList.get(i).contains("uploadFiles")) {
                loadBgImg(this, pathList.get(i), R.mipmap.null_img, imageView);
            } else {
                ImagLoader(this, pathList.get(i), R.mipmap.null_img, imageView);
            }
        }
    }
}
