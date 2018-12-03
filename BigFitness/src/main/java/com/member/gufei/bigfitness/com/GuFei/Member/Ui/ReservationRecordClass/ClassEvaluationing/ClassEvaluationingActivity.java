package com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.ClassEvaluationing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.member.gufei.bigfitness.Presenter.SpinnerPopContract;
import com.member.gufei.bigfitness.Presenter.SpinnerPopupWindow;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.GetLessonEvaluateBean;
import com.member.gufei.bigfitness.util.MyRatingBar;
import com.member.gufei.bigfitness.util.SpUtil;
import com.yanzhenjie.album.Album;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sun.misc.BASE64Encoder;

import static com.member.gufei.bigfitness.Constants.ACTIVITY_REQUEST_SELECT_PHOTO;
import static com.member.gufei.bigfitness.Constants.MEMBERIDKEY;
import static com.member.gufei.bigfitness.Constants.PUT_STR;
import static com.member.gufei.bigfitness.Constants.RESULT_SEX;
import static com.member.gufei.bigfitness.Constants.RESULT_STRING;
import static com.member.gufei.bigfitness.Constants.RESULT_SUCCESS;
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
public class ClassEvaluationingActivity extends BaseActivity<ClassEvaluationingActivityPresenter> implements SpinnerPopContract, ClassEvaluationingActivityContract.View {


    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.btn_edit)
    TextView btnEdit;
    @BindView(R.id.class_score)
    MyRatingBar classScore;
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
    @BindView(R.id.coach_score)
    MyRatingBar coachScore;
    //    @BindView(R.id.serve_score)
//    MyRatingBar serveScore;
    @BindView(R.id.edit_club_evaluate)
    EditText editClubEvaluate;
    @BindView(R.id.img4)
    ImageView img4;
    @BindView(R.id.btn_del_4)
    ImageView btnDel4;
    @BindView(R.id.img5)
    ImageView img5;
    @BindView(R.id.btn_del_5)
    ImageView btnDel5;
    @BindView(R.id.img6)
    ImageView img6;
    @BindView(R.id.btn_del_6)
    ImageView btnDel6;
    @BindView(R.id.tv_anonymous)
    TextView tvAnonymous;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.rb_ecaluate)
    CheckBox rbEcaluate;
    @BindView(R.id.tv_subtext)
    TextView tvSubtext;
    private List<String> mDatas;
    private int ItemSelected = 0;
    private SpinnerPopupWindow s;
    String mUserName = "";
    String mUserSex = "";
    int UserId;
    String token;
    String ClubId;
    int classStar;
    int coachStar;
    int serveStar;
    int ImgSelected;
    int ImgSelected1;
    List<String> pathList = null;
    List<String> pathList1 = null;
    String imgsrc;
    String imgsrc1;
    String AppointmentId;
    String ComeLogId;
    String MemberId;
    String EvaluateContent;
    String TeacherEvaluateContent;
    String eCode;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_class_evaluationing;

    }

    @Override
    protected void initView() {

//        toolbar.setNavigationIcon(R.mipmap.left);
//
//        setToolBar(toolbar, "");
        pathList = new ArrayList<String>();
        pathList1 = new ArrayList<String>();
        mainTitle.setText("评价");

        btnEdit.setVisibility(View.INVISIBLE);

        Intent intent = getIntent();
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");
        MemberId = (String) SpUtil.get(mContext, MEMBERIDKEY, "");
        ComeLogId = intent.getStringExtra(PUT_STR + "ComeLogId");
        AppointmentId = intent.getStringExtra(PUT_STR + "AppointmentId");
        eCode = intent.getStringExtra(PUT_STR + "eCode");
        if (eCode.equals("1")) {
            mPresenter.getEvaluate(String.valueOf(UserId),
                    ClubId,
                    token,
                    MemberId,
                    AppointmentId,
                    ComeLogId);
        }

        classScore.setOnRatingChangeListener(new MyRatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float ratingCount) {
                classStar = (int) ratingCount;
            }
        });

        coachScore.setOnRatingChangeListener(new MyRatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float ratingCount) {
                coachStar = (int) ratingCount;
            }
        });

//        serveScore.setOnRatingChangeListener(new MyRatingBar.OnRatingChangeListener() {
//            @Override
//            public void onRatingChange(float ratingCount) {
//                serveStar = (int) ratingCount;
//            }
//        });

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
    public void succeed(CodeBean codeBean) {
        tvSubtext.setVisibility(View.GONE);
        Toast.makeText(mContext, "提交评价成功！", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void Evaluatesucceed(GetLessonEvaluateBean getLessonEvaluateBean) {
        classScore.setStar(getLessonEvaluateBean.getRows().getLessonEvaluate().getEvaluateStar());
        editEvaluate.setText(getLessonEvaluateBean.getRows().getLessonEvaluate().getEvaluateContent());
        coachScore.setStar(getLessonEvaluateBean.getRows().getLessonEvaluate().getTeacherEvaluateStar());
//        serveScore.setStar(getLessonEvaluateBean.getRows().getLessonEvaluate().getServiceEvaluateStar());
        editClubEvaluate.setText(getLessonEvaluateBean.getRows().getLessonEvaluate().getTeacherEvaluateContent());
        String str = getLessonEvaluateBean.getRows().getLessonEvaluate().getImageURL();
        String str1 = getLessonEvaluateBean.getRows().getLessonEvaluate().getTeacherImageURL();
        List<String> result = Arrays.asList(str.split(","));
        List<String> result1 = Arrays.asList(str1.split(","));
        for (int i = 0; i < result.size(); i++) {
            ImageView imageView = null;
            try {
                pathList.add(result.get(i));
                imageView = (ImageView) id(R.id.class.getDeclaredField("img" + String.valueOf(i + 1)).getInt(null));
                ImageView imageView1 = (ImageView) id(R.id.class.getDeclaredField("btn_del_" + String.valueOf(i + 1)).getInt(null));
                imageView1.setVisibility(View.VISIBLE);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            loadBgImg(this, result.get(i), R.mipmap.null_img, imageView);
        }
        for (int i = 0; i < result1.size(); i++) {
            ImageView imageView = null;
            try {
                pathList1.add(result1.get(i));
                imageView = (ImageView) id(R.id.class.getDeclaredField("img" + String.valueOf(i + 4)).getInt(null));
                ImageView imageView1 = (ImageView) id(R.id.class.getDeclaredField("btn_del_" + String.valueOf(i + 4)).getInt(null));
                imageView1.setVisibility(View.VISIBLE);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            loadBgImg(this, result1.get(i), R.mipmap.null_img, imageView);
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
//                List<String>  mTmpPathList1 = Album.parseResult(data);

//                imgsrc = "";

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 2;
                Bitmap bm = BitmapFactory.decodeFile(mTmpPathList.get(0), options);
//                Bitmap bm1 = BitmapFactory.decodeFile(mTmpPathList1.get(0), options);


                if (mTmpPathList.size() == 1) {

//                    pathList.set(ImgSelected - 1, mTmpPathList.get(0));


//                    imgsrc = Bitmap2StrByBase64(pathList.get(0));
                    switch (ImgSelected) {
                        case 1:
                            pathList.add(mTmpPathList.get(0));
                            img1.setImageBitmap(bm);
                            btnDel1.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            pathList.add(mTmpPathList.get(0));
                            img2.setImageBitmap(bm);
                            btnDel2.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            pathList.add(mTmpPathList.get(0));
                            img3.setImageBitmap(bm);
                            btnDel3.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            pathList1.add(mTmpPathList.get(0));
                            img4.setImageBitmap(bm);
                            btnDel4.setVisibility(View.VISIBLE);
                            break;
                        case 5:
                            pathList1.add(mTmpPathList.get(0));
                            img5.setImageBitmap(bm);
                            btnDel5.setVisibility(View.VISIBLE);
                            break;
                        case 6:
                            pathList1.add(mTmpPathList.get(0));
                            img6.setImageBitmap(bm);
                            btnDel6.setVisibility(View.VISIBLE);
                            break;
                    }
                } else {
                    try {
                        if (ImgSelected == 1 || ImgSelected == 2 || ImgSelected == 3) {
                            pathList.addAll(mTmpPathList);
                            for (int i = 0; i < pathList.size(); i++) {
                                ImageView imageView = (ImageView) id(R.id.class.getDeclaredField("img" + String.valueOf(i + 1)).getInt(null));
                                ImageView imageView1 = (ImageView) id(R.id.class.getDeclaredField("btn_del_" + String.valueOf(i + 1)).getInt(null));
                                imageView1.setVisibility(View.VISIBLE);
                                ImagLoader(this, pathList.get(i), R.mipmap.null_img, imageView);
                            }
                        } else {
                            pathList1.addAll(mTmpPathList);
                            for (int i = 0; i < pathList1.size(); i++) {
                                ImageView imageView = (ImageView) id(R.id.class.getDeclaredField("img" + String.valueOf(i + 4)).getInt(null));
                                ImageView imageView1 = (ImageView) id(R.id.class.getDeclaredField("btn_del_" + String.valueOf(i + 4)).getInt(null));
                                imageView1.setVisibility(View.VISIBLE);
                                ImagLoader(this, pathList1.get(i), R.mipmap.null_img, imageView);
                            }
                        }

                    } catch (IllegalAccessException e) {

                        e.printStackTrace();

                    } catch (NoSuchFieldException e) {

                        e.printStackTrace();

                    }
//                    for (int i = 0; i < mTmpPathList.size(); i++) {
////                        pathList.set(ImgSelected - 1, mTmpPathList.get(i));
//
////                    imgsrc += Bitmap2StrByBase64(pathList.get(i));
//                        try {
//                            if (ImgSelected == 1 || ImgSelected == 2 || ImgSelected == 3) {
//                                pathList.add(mTmpPathList.get(i));
//                                ImageView imageView = (ImageView) id(R.id.class.getDeclaredField("img" + String.valueOf(i + 1)).getInt(null));
//                                ImageView imageView1 = (ImageView) id(R.id.class.getDeclaredField("btn_del_" + String.valueOf(i + 1)).getInt(null));
//                                imageView1.setVisibility(View.VISIBLE);
//                                ImagLoader(this, mTmpPathList.get(i), R.mipmap.null_img, imageView);
//                            } else {
//                                pathList1.add(mTmpPathList.get(i));
//                                ImageView imageView = (ImageView) id(R.id.class.getDeclaredField("img" + String.valueOf(i + 4)).getInt(null));
//                                ImageView imageView1 = (ImageView) id(R.id.class.getDeclaredField("btn_del_" + String.valueOf(i + 4)).getInt(null));
//                                imageView1.setVisibility(View.VISIBLE);
//                                ImagLoader(this, mTmpPathList.get(i), R.mipmap.null_img, imageView);
//                            }
//
//
//                        } catch (IllegalAccessException e) {
//
//                            e.printStackTrace();
//
//                        } catch (NoSuchFieldException e) {
//
//                            e.printStackTrace();
//
//                        }
//
//                    }
                }

            }

        } else if (resultCode == RESULT_CANCELED) { // 用户取消选择。
            // 根据需要提示用户取消了选择。
        }
//        super.onActivityResult(requestCode, resultCode, data);


    }


    @Override
    public void dismiss() {
        backgroundAlpha(1f);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent resultIntent = new Intent();

        Bundle bundle = new Bundle();

        bundle.putInt(RESULT_TYPE, RESULT_SUCCESS);

//        bundle.putString(RESULT_ID, String.valueOf(listBean.getID()));

        bundle.putString(RESULT_STRING, mUserName);

        bundle.putString(RESULT_SEX, mUserSex);

        resultIntent.putExtras(bundle);

        this.setResult(RESULT_OK, resultIntent);

//         this.finish();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_back, R.id.img1, R.id.btn_del_1, R.id.img2, R.id.btn_del_2, R.id.img3, R.id.btn_del_3, R.id.img4, R.id.btn_del_4, R.id.img5, R.id.btn_del_5, R.id.img6, R.id.btn_del_6, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.img1:
                ImgSelected = 1;
                Album.startAlbum(this, ACTIVITY_REQUEST_SELECT_PHOTO
                        , 3                                                       // 指定选择数量。
                        , ContextCompat.getColor(this, R.color.colorPrimary)        // 指定Toolbar的颜色。
                        , ContextCompat.getColor(this, R.color.colorPrimaryDark));  // 指定状态栏的颜色。
                break;
            case R.id.btn_del_1:
                pathList.remove(0);
                delRefresh1();
//                img1.setImageDrawable(getResources().getDrawable(R.mipmap.null_img));
//                btnDel1.setVisibility(View.GONE);
                break;
            case R.id.img2:
                ImgSelected = 2;
                Album.startAlbum(this, ACTIVITY_REQUEST_SELECT_PHOTO
                        , 3                                                       // 指定选择数量。
                        , ContextCompat.getColor(this, R.color.colorPrimary)        // 指定Toolbar的颜色。
                        , ContextCompat.getColor(this, R.color.colorPrimaryDark));  // 指定状态栏的颜色。
                break;
            case R.id.btn_del_2:
                pathList.remove(1);
                delRefresh1();
//                img2.setImageDrawable(getResources().getDrawable(R.mipmap.null_img));
//                btnDel2.setVisibility(View.GONE);
                break;
            case R.id.img3:
                ImgSelected = 3;
                Album.startAlbum(this, ACTIVITY_REQUEST_SELECT_PHOTO
                        , 3                                                        // 指定选择数量。
                        , ContextCompat.getColor(this, R.color.colorPrimary)        // 指定Toolbar的颜色。
                        , ContextCompat.getColor(this, R.color.colorPrimaryDark));  // 指定状态栏的颜色。
                break;
            case R.id.btn_del_3:
                pathList.remove(2);
                delRefresh1();
//                img3.setImageDrawable(getResources().getDrawable(R.mipmap.null_img));
//                btnDel3.setVisibility(View.GONE);
                break;
            case R.id.img4:
                ImgSelected = 4;
                Album.startAlbum(this, ACTIVITY_REQUEST_SELECT_PHOTO
                        , 3                                                         // 指定选择数量。
                        , ContextCompat.getColor(this, R.color.colorPrimary)        // 指定Toolbar的颜色。
                        , ContextCompat.getColor(this, R.color.colorPrimaryDark));  // 指定状态栏的颜色。
                break;
            case R.id.btn_del_4:
                pathList1.remove(0);
                delRefresh2();
//                img4.setImageDrawable(getResources().getDrawable(R.mipmap.null_img));
//                btnDel4.setVisibility(View.GONE);
                break;
            case R.id.img5:
                ImgSelected = 5;
                Album.startAlbum(this, ACTIVITY_REQUEST_SELECT_PHOTO
                        , 3                                                        // 指定选择数量。
                        , ContextCompat.getColor(this, R.color.colorPrimary)        // 指定Toolbar的颜色。
                        , ContextCompat.getColor(this, R.color.colorPrimaryDark));  // 指定状态栏的颜色。
                break;
            case R.id.btn_del_5:
                pathList1.remove(1);
                delRefresh2();
//                img5.setImageDrawable(getResources().getDrawable(R.mipmap.null_img));
//                btnDel5.setVisibility(View.GONE);
                break;
            case R.id.img6:
                ImgSelected = 6;
                Album.startAlbum(this, ACTIVITY_REQUEST_SELECT_PHOTO
                        , 3                                                         // 指定选择数量。
                        , ContextCompat.getColor(this, R.color.colorPrimary)        // 指定Toolbar的颜色。
                        , ContextCompat.getColor(this, R.color.colorPrimaryDark));  // 指定状态栏的颜色。
                break;
            case R.id.btn_del_6:
                pathList1.remove(2);
                delRefresh2();
//                img6.setImageDrawable(getResources().getDrawable(R.mipmap.null_img));
//                btnDel6.setVisibility(View.GONE);
                break;
            case R.id.tv_submit:
                EvaluateContent = editEvaluate.getText().toString();
                TeacherEvaluateContent = editClubEvaluate.getText().toString();
                for (int i = 0; i < pathList.size(); i++) {
                    String everyImage = "";
                    if (pathList.get(i).contains("uploadFiles")) {
                        everyImage = getBase64(pathList.get(i));
                    } else {
                        everyImage = Bitmap2StrByBase64(pathList.get(i));
                    }

                    imgsrc += everyImage;
                }
                for (int i = 0; i < pathList1.size(); i++) {
                    String everyImage = "";
                    if (pathList1.get(i).contains("uploadFiles")) {
                        everyImage = getBase64(pathList1.get(i));
                    } else {
                        everyImage = Bitmap2StrByBase64(pathList1.get(i));
                    }

                    imgsrc1 += everyImage;
                }
                mPresenter.getLessonEvaluate(String.valueOf(UserId),
                        ClubId,
                        token,
                        MemberId,
                        ComeLogId,
                        AppointmentId,
                        String.valueOf(classStar),
                        EvaluateContent,
                        String.valueOf(coachStar),
                        "0",
                        TeacherEvaluateContent,
                        imgsrc,
                        imgsrc1,
                        rbEcaluate.isChecked() ? "1" : "0");
                tvSubtext.setVisibility(View.VISIBLE);
                break;
        }
    }

    public static String getBase64(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
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
                imageView = (ImageView) id(R.id.class.getDeclaredField("img" + String.valueOf(i + 1)).getInt(null));
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

    public void delRefresh2() {
        img4.setImageDrawable(getResources().getDrawable(R.mipmap.img_evaluation));
        img5.setImageDrawable(getResources().getDrawable(R.mipmap.img_evaluation));
        img6.setImageDrawable(getResources().getDrawable(R.mipmap.img_evaluation));
        btnDel4.setVisibility(View.GONE);
        btnDel5.setVisibility(View.GONE);
        btnDel6.setVisibility(View.GONE);
        for (int i = 0; i < pathList1.size(); i++) {
            ImageView imageView = null;
            try {
                imageView = (ImageView) id(R.id.class.getDeclaredField("img" + String.valueOf(i + 4)).getInt(null));
                ImageView imageView1 = (ImageView) id(R.id.class.getDeclaredField("btn_del_" + String.valueOf(i + 4)).getInt(null));
                imageView1.setVisibility(View.VISIBLE);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            if (pathList1.get(i).contains("uploadFiles")) {
                loadBgImg(this, pathList1.get(i), R.mipmap.null_img, imageView);
            } else {
                ImagLoader(this, pathList1.get(i), R.mipmap.null_img, imageView);
            }


        }
    }
}
