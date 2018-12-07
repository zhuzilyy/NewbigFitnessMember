package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.HeightPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.Manifest;
import com.member.gufei.bigfitness.Presenter.SpinnerPopContract;
import com.member.gufei.bigfitness.Presenter.SpinnerPopupWindow;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Login.LoginActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.EditFitness.EditFitnessActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.EditName.EditNameActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MemberMyInfoBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MemberSetUserInfoBean;
import com.member.gufei.bigfitness.util.SpUtil;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import sun.misc.BASE64Encoder;
import yanzhikai.ruler.BooheeRuler;
import yanzhikai.ruler.KgNumberLayout;

import static com.member.gufei.bigfitness.App.SCREEN_WIDTH;
import static com.member.gufei.bigfitness.Constants.ACCOUNTKEY;
import static com.member.gufei.bigfitness.Constants.BIRTHDAYKEY;
import static com.member.gufei.bigfitness.Constants.DEVICECODEKEY;
import static com.member.gufei.bigfitness.Constants.FITNESSREQUESTKEY;
import static com.member.gufei.bigfitness.Constants.HEADERURLKEY;
import static com.member.gufei.bigfitness.Constants.HEIGHTKEY;
import static com.member.gufei.bigfitness.Constants.MOBLIEKEY;
import static com.member.gufei.bigfitness.Constants.NICKNAMEKEY;
import static com.member.gufei.bigfitness.Constants.RESULT_ID;
import static com.member.gufei.bigfitness.Constants.RESULT_STRING;
import static com.member.gufei.bigfitness.Constants.RESULT_SUCCESS;
import static com.member.gufei.bigfitness.Constants.RESULT_TYPE;
import static com.member.gufei.bigfitness.Constants.SELECTEDCULBIDKEY;
import static com.member.gufei.bigfitness.Constants.SEXKEY;
import static com.member.gufei.bigfitness.Constants.TOKENKEY;
import static com.member.gufei.bigfitness.Constants.USERIDKEY;
import static com.member.gufei.bigfitness.Constants.WEIGHTKEY;
import static com.member.gufei.bigfitness.util.BitmapUtil.Bitmap2StrByBase64;
import static com.member.gufei.bigfitness.util.LoadImage.ImagLoader;
import static com.member.gufei.bigfitness.util.LoadImage.loadBgImg;
import static com.member.gufei.bigfitness.util.LoadImage.loadImgForRadius;
import static com.member.gufei.bigfitness.util.ToastUtil.s;


public class SetInfoActivity extends BaseActivity<SetInfoActivityPresenter> implements SpinnerPopContract, SetInfoActivityContract.View, PopupWindow.OnDismissListener {
    @BindView(R.id.main_title)
    TextView tvTitle;
    @BindView(R.id.btn_edit)
    TextView btnEdit;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.head_text)
    TextView headText;
    @BindView(R.id.head_img_iv)
    ImageView headImgIv;
    @BindView(R.id.head_img_btn)
    RelativeLayout headImgBtn;
    @BindView(R.id.user_name_img)
    ImageView userNameImg;
    @BindView(R.id.user_name_text)
    EditText userNameText;
    @BindView(R.id.head_name_btn)
    RelativeLayout headNameBtn;
    //    @BindView(R.id.user_account_img)
//    ImageView userAccountImg;
    @BindView(R.id.user_account_text)
    EditText userAccountText;
    @BindView(R.id.head_account_btn)
    RelativeLayout headAccountBtn;
    @BindView(R.id.user_sex_img)
    ImageView userSexImg;
    @BindView(R.id.user_sex_text)
    EditText userSexText;
    @BindView(R.id.head_sex_btn)
    RelativeLayout headSexBtn;
    @BindView(R.id.user_age_img)
    ImageView userAgeImg;
    @BindView(R.id.user_age_text)
    TextView userAgeText;
    @BindView(R.id.head_age_btn)
    RelativeLayout headAgeBtn;
    @BindView(R.id.user_height_img)
    ImageView userHeightImg;
    @BindView(R.id.user_height_text)
    TextView userHeightText;
    @BindView(R.id.head_height_btn)
    RelativeLayout headHeightBtn;
    @BindView(R.id.user_weight_img)
    ImageView userWeightImg;
    @BindView(R.id.user_note_img)
    ImageView userNoteImg;
    @BindView(R.id.user_weight_text)
    EditText userWeightText;
    @BindView(R.id.head_weight_btn)
    RelativeLayout headWeightBtn;
    @BindView(R.id.details_note)
    TextView detailsNote;
    @BindView(R.id.details_note_text)
    TextView detailsNoteText;
    private List<String> mDatas;
    private int ItemSelected = 0;
    private SpinnerPopupWindow s;
    int UserId;
    String token = "";
    String ClubId = "";
    int mHeigt = 0;
    String mBirthday = "";
    String mWeight = "";
    float dWeight = 0;
    String mHeaderurl = "";
    String mNickname = "";
    int mUserSex = 0;
    private HeightPickerView mHeightPickerView;
    String mTel = "";
    String mAccount = "";
    String mFitnessRequest = "";
    String mDeviceCode = "";
    String mHeight="";
    String Headurl = "";
    KgNumberLayout mTextWeight;
    String url="";

    private View contentView;
    private PopupWindow popupWindow;
    private static final int REQUEST_CODE_CHOOSE = 23;//定义请求码常量


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }


    @Override
    protected int getLayout() {

        return R.layout.member_activity_personal_data;

    }

    @Override
    protected void initView() {

//        toolbar.setNavigationIcon(R.mipmap.left);
//
//        setToolBar(toolbar, "");

        tvTitle.setText("个人资料");

        btnEdit.setText("编辑");
//
//        String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
//
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        mAccount = (String) SpUtil.get(mContext, ACCOUNTKEY, "");
        mUserSex = (int) SpUtil.get(mContext, SEXKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        mTel = (String) SpUtil.get(mContext, MOBLIEKEY, "");

        mHeigt = (int) SpUtil.get(mContext, HEIGHTKEY, 0);
        mWeight = (String) SpUtil.get(mContext, WEIGHTKEY, "");
        mBirthday = (String) SpUtil.get(mContext, BIRTHDAYKEY, "");
        mHeaderurl = (String) SpUtil.get(mContext, HEADERURLKEY, "");
        mNickname = (String) SpUtil.get(mContext, NICKNAMEKEY, "");
        mFitnessRequest = (String) SpUtil.get(mContext, FITNESSREQUESTKEY, "");
        mDeviceCode = (String) SpUtil.get(mContext, DEVICECODEKEY, "");
        ClubId = (String) SpUtil.get(mContext, SELECTEDCULBIDKEY, "");

        userNameText.setText(mNickname);
        userAccountText.setText(mAccount);
        userAgeText.setText(mBirthday);
        userHeightText.setText(mHeigt + "");
        userWeightText.setText(mWeight + "");


//        userSexText.setText(mUserSex == 1 ? "男" : "女");

        if (mUserSex==1){
            userSexText.setText("男");
        }else {
            userSexText.setText("女");
        }
        detailsNoteText.setText( mFitnessRequest);
        boolean status = mHeaderurl.contains("uploadFiles");
        if (status){
            loadBgImg(mContext, mHeaderurl, R.mipmap.user_head_img, headImgIv);
        }else {
            ImagLoader(mContext, mHeaderurl, R.mipmap.user_head_img, headImgIv);
        }

        SetRightImg(View.INVISIBLE);
        SetEditStatus(false);




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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (null != data) {
            Bundle bundle = data.getExtras();
            if (bundle == null) {
                return;
            }
            if (bundle.getInt(RESULT_TYPE) == RESULT_SUCCESS) {
                if (requestCode == 8888) {
                    //昵称
                    mNickname = bundle.getString(RESULT_STRING);
                    userNameText.setText(mNickname);


                }

                if (requestCode == 8889) {
                    //昵称
//                    mFitnessRequest ="["+bundle.getString(RESULT_ID)+"]";
                    detailsNoteText.setText(bundle.getString(RESULT_STRING));
                    mFitnessRequest=bundle.getString(RESULT_STRING);
                }


            }


        }

        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {

            ArrayList<String> list = new ArrayList<String>();
            list = (ArrayList<String>) Matisse.obtainPathResult(data);
            if (list != null && list.size() > 0){
                for (String item : list){
                    Headurl += item +",";
                }
                Headurl = Headurl.substring(0, Headurl.length() - 1);
            }
//            mAdapter.setData(Matisse.obtainResult(data), Matisse.obtainPathResult(data));
//            Log.e("OnActivityResult ", String.valueOf(Matisse.obtainOriginalState(data)));
            ImagLoader(mContext, Headurl, R.mipmap.head_img_big, headImgIv);
//            url =  getImgBase64(headImgIv);
            if (!Headurl.equals("")){
                url = Bitmap2StrByBase64(Headurl);
            }else {
                url = Bitmap2StrByBase64(mHeaderurl);
            }


        }

    }

    //    /**
//     * @return
//     * @Description: 根据图片地址转换为base64编码字符串
//     * @Author:
//     * @CreateTime:
//     */
//    public static String getImageStr(String imgFile) {
//        InputStream inputStream = null;
//        byte[] data = null;
//        try {
//            inputStream = new FileInputStream(imgFile);
//            data = new byte[inputStream.available()];
//            inputStream.read(data);
//            inputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // 加密
//        BASE64Encoder encoder = new BASE64Encoder();
//        return encoder.encode(data);
//    }


        public String getImgBase64(ImageView imageView){
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();

        Bitmap bitmap = drawable.getBitmap();
//        Bitmap bm =((BitmapDrawable) ((ImageView) imageView).getDrawable()).getBitmap();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,bos);
        byte[] bb = bos.toByteArray();
        String image = Base64.encodeToString(bb, Base64.NO_WRAP);


        return image;
    }
    @OnClick({R.id.details_note_text, R.id.btn_edit, R.id.btn_back, R.id.head_img_btn, R.id.head_name_btn, R.id.head_account_btn, R.id.head_sex_btn, R.id.head_age_btn, R.id.head_height_btn, R.id.head_weight_btn})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;

            case R.id.btn_edit:
                if (btnEdit.getText().equals("编辑")) {
                    btnEdit.setText("完成");
                    SetRightImg(View.VISIBLE);
                    SetEditStatus(true);
                } else {

                    if (userAgeText.getText().equals("")) {
                        s(mContext, "生日不可为空!");
                        break;
                    } else {
                        mBirthday = userAgeText.getText().toString();
                    }

                    if (userNameText.getText().equals("")) {
                        s(mContext, "昵称不可为空!");
                        break;
                    } else {
                        mNickname = userNameText.getText().toString();

                    }

                    if (userHeightText.getText().equals("")) {
                        s(mContext, "身高不可为空!");
                        break;
                    } else {
                        mHeigt = Integer.parseInt(userHeightText.getText().toString());

                    }

                    if (userWeightText.getText().equals("")) {
                        s(mContext, "体重不可为空!");
                        break;
                    } else {
                        mWeight = userWeightText.getText().toString();

                    }

                    if (url.equals("")){
                        url = null;
                    }
                    mPresenter.updateAppUserInfo(String.valueOf(UserId),
                            url,
                            String.valueOf(mUserSex),
                            mNickname,
                            mBirthday,
                            String.valueOf(mHeigt),
                            mWeight,
                            mFitnessRequest, token);
                    btnEdit.setText("编辑");
                    SetRightImg(View.INVISIBLE);
                    SetEditStatus(false);

                }

                break;
            case R.id.head_img_btn:
                if (btnEdit.getText().equals("完成")) {
                    Matisse
                            .from(SetInfoActivity.this)
                            .choose(MimeType.ofAll(),false)//照片视频全部显示
                            .countable(false)//有序选择图片
                            .maxSelectable(1)//最大选择数量为9
                            .gridExpectedSize(120)//图片显示表格的大小getResources()
                            .gridExpectedSize(
                                    getResources().getDimensionPixelSize(R.dimen.grid_expected_size))//设置列宽
                            .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)//图像选择和预览活动所需的方向。
                            .thumbnailScale(0.85f)//缩放比例
                            .theme(R.style.Matisse_Zhihu)//主题  暗色主题 R.style.Matisse_Dracula
                            .imageEngine(new GlideEngine())//加载方式
                            .capture(true) //是否提供拍照功能
                            .captureStrategy(new CaptureStrategy(true, "com.member.gufei.bigfitness.fileprovider"))//存储到哪里
                            .forResult(REQUEST_CODE_CHOOSE);//请求码
                }
                break;
            case R.id.head_name_btn:
                if (btnEdit.getText().equals("完成")) {

                    intent = new Intent(SetInfoActivity.this, EditNameActivity.class);
                    intent.putExtra(RESULT_ID, "8888");
                    startActivityForResult(intent, 8888);
                }
                //意向
//
//                    startActivityForResult(intent, MEMBERINTENTID);//使用时需定义变量requestCode
                break;
            case R.id.head_account_btn:

                break;
            case R.id.head_sex_btn:
                if (btnEdit.getText().equals("完成")) SexPopup(view, 0);

                break;
            case R.id.head_age_btn:
                if (btnEdit.getText().equals("完成")) {
                    TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date, View v) {
                            userAgeText.setText(getTime(date));
                        }
                    })
                            .setType(TimePickerView.Type.YEAR_MONTH_DAY)// 默认全部显示
                            .setCancelText("取消")//取消按钮文字
                            .setSubmitText("确定")//确认按钮文字
//                .setContentSize(18)//滚轮文字大小
//                .setTitleSize(20)//标题文字大小
//                //.setTitleText("Title")//标题文字
//                .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
//                .isCyclic(true)//是否循环滚动
//                //.setTitleColor(Color.BLACK)//标题文字颜色
//                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
//                .setCancelColor(Color.BLUE)//取消按钮文字颜色
//                //.setTitleBgColor(0xFF666666)//标题背景颜色 Night mode
//                .setBgColor(0xFF333333)//滚轮背景颜色 Night mode
////                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
////                .setRangDate(startDate,endDate)//起始终止年月日设定
//                .setLabel("年","月","日")//默认设置为年月日时分秒
                            .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                            //.isDialog(true)//是否显示为对话框样式
                            .build();

                    pvTime.show();
                }
                break;
            case R.id.head_height_btn:
                if (btnEdit.getText().equals("完成")) {
                    initHeightPicker(userHeightText, "身高");
                    mHeightPickerView.show();

                }
                break;
            case R.id.head_weight_btn:
                if (btnEdit.getText().equals("完成")) {
                    SelectPopup(userWeightText, 0);
                }
                break;

            case R.id.details_note_text:
                if (btnEdit.getText().equals("完成")){
                    intent = new Intent(SetInfoActivity.this, EditFitnessActivity.class);
                intent.putExtra(RESULT_ID, "8889");
                startActivityForResult(intent, 8889);
               }
                break;


        }
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

        contentView = LayoutInflater.from(this).inflate(R.layout.member_pop_view_weight, null);
        popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);

//        final TextView mTextWeight = (TextView)contentView. findViewById(R.id.text_weight);
        mTextWeight = (KgNumberLayout) contentView.findViewById(R.id.text_weight);
        Button sure = (Button) contentView.findViewById(R.id.btnSubmit_sure);
        final BooheeRuler scaleScrollView = (BooheeRuler) contentView.findViewById(R.id.hsScale);
//        dWeight = Float.parseFloat(mWeight)*2;
//        scaleScrollView.setCurrentScale(dWeight);
//        scaleScrollView.getCurrentScale();
        mTextWeight.bindRuler(scaleScrollView);

//        scaleScrollView.setIsIntegarl(false);

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWeight = mTextWeight.tv_scale.getText().toString();
                userWeightText.setText(mWeight);
                popupWindow.dismiss();
            }
        });

        popupWindow.setOnDismissListener(this);

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
        popupWindow.showAtLocation(v, Gravity.BOTTOM, 0, -100);


    }
    private void
    initHeightPicker(final TextView view, String title) {

        /**
         * @description
         *
         * 注意事项：
         * 1.自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针.
         * 具体可参考demo 里面的两个自定义layout布局。
         * 2.因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
         * setRangDate方法控制起始终止时间(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
         */
        final ArrayList<String> mOptions1Items = new ArrayList<>();
        for (int i = 100; i < 210; i++) {
            mOptions1Items.add(i + "");
        }
        //时间选择器 ，自定义布局
        mHeightPickerView = new HeightPickerView.Builder(this, new HeightPickerView.OnOptionsSelectListener() {


            @Override
            public void onOptionsSelect(int options1, View v) {

                mHeight=mOptions1Items.get(options1) +"";

                view.setText(mHeight);

            }
        })

                /*.setType(TimePickerView.Type.ALL)//default is all
                .setCancelText("Cancel")
                .setSubmitText("Sure")
                .setContentSize(18)
                .setTitleSize(20)

                .setTitleColor(Color.BLACK)


               /*.setDividerColor(Color.WHITE)//设置分割线的颜色
                .setTextColorCenter(Color.LTGRAY)//设置选中项的颜色

                .setTitleBgColor(Color.DKGRAY)//标题背景颜色 Night mode
                .setBgColor(Color.BLACK)//滚轮背景颜色 Night mode
                .setSubmitColor(Color.WHITE)
                .setCancelColor(Color.WHITE)*/
                /*.gravity(Gravity.RIGHT)// default is center*/


                .setTextColorCenter(R.color.black)//设置选中项的颜色

                .setBgColor(R.color.no_back)//设置选中项的颜色
                .setLineSpacingMultiplier(2.0f)//设置两横线之间的间隔倍数
                .isDialog(false)
                .setTitleText(title)


                .setLayoutRes(R.layout.pickerview_height, new CustomListener() {

                    @Override
                    public void customLayout(View v) {
                        Button btSubmit = (Button) v.findViewById(R.id.btnSubmit);
                        btSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                mHeightPickerView.returnData();
                                mHeightPickerView.dismiss();
                            }
                        });
//                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
//                        TextView ivCancel = (TextView) v.findViewById(R.id.iv_cancel);
//                        tvSubmit.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                mBirthdayPickerView.returnData();
//                            }
//                        });
//                        ivCancel.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                mBirthdayPickerView.dismiss();
//                            }
//                        });
                    }
                })

                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。

                .setDividerColor(R.color.no_back)
                .build();
        mHeightPickerView.setSelectOptions(Integer.parseInt(view.getText().toString())-100);
        mHeightPickerView.setNPicker(mOptions1Items);

    }
    protected String getTime(Date date) {//可根据需要自行截取数据显示
        //"YYYY-MM-DD HH:MM:SS"        "yyyy-MM-dd"
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
    public void SetRightImg(int show) {
        userNameImg.setVisibility(show);
        userSexImg.setVisibility(show);
        userAgeImg.setVisibility(show);
        userHeightImg.setVisibility(show);
        userWeightImg.setVisibility(show);
        userNoteImg.setVisibility(show);
    }


    public void SetEditStatus(boolean show) {
//        userNameText.setEnabled(show);
        userAccountText.setEnabled(show);
        userAgeText.setEnabled(show);
        userHeightText.setEnabled(show);
        userWeightText.setEnabled(show);
    }

    @Override
    public void dismiss() {

    }

    @Override
    public void succeed(MemberSetUserInfoBean memberSetUserInfoBean) {

//        s(mContext,"修改完成");
        Toast.makeText(mContext, "修改完成！", Toast.LENGTH_SHORT).show();

        userNameText.setText(mNickname);
        userAgeText.setText(mBirthday);
        userHeightText.setText(mHeigt + "");
        userWeightText.setText(mWeight + "");
        if (mUserSex==1){
            userSexText.setText("男");
        }else {
            userSexText.setText("女");
        }
        detailsNoteText.setText( mFitnessRequest);
//        loadBgImg(mContext, Headurl, R.mipmap.head_img_big, headImgIv);
//        userAgeText.setText(memberMyInfoBean.getRows().getBirthday());
//        userHeightText.setText(memberMyInfoBean.getRows().getHeight() + "");
//        userWeightText.setText(memberMyInfoBean.getRows().getWeight() + "");

//        userSexText.setText(memberMyInfoBean.getRows().getSex().equals("1") ? "男" : "女");
//        detailsNoteText.setText(memberMyInfoBean.getRows().getFitnessRequest());
//        loadImgForRadius(mContext, memberMyInfoBean.getRows().getHeaderURL(), R.mipmap.user_head_img, headImgIv);

//        SpUtil.put(mContext, TOKENKEY, memberMyInfoBean.getRows().getToken());
        if (!Headurl.equals("")){
            SpUtil.put(mContext, HEADERURLKEY, Headurl);
        }else {
            SpUtil.put(mContext, HEADERURLKEY, mHeaderurl);
        }
//        SpUtil.put(mContext, HEADERURLKEY, Headurl);
        SpUtil.put(mContext, FITNESSREQUESTKEY,mFitnessRequest);
        SpUtil.put(mContext, NICKNAMEKEY, mNickname);
        SpUtil.put(mContext, SEXKEY, mUserSex);
        SpUtil.put(mContext, BIRTHDAYKEY, mBirthday);
        SpUtil.put(mContext, HEIGHTKEY, mHeigt);
        SpUtil.put(mContext, WEIGHTKEY, mWeight);

    }

    public void SexPopup(View v, final int tag) {
        if (contentView != null) contentView = null;
        if (popupWindow != null) popupWindow = null;
        // 一个自定义的布局，作为显示的内容

        int Width = (int) (SCREEN_WIDTH * 0.8);

        contentView = LayoutInflater.from(this).inflate(R.layout.member_pop_view_sex, null);
        popupWindow = new PopupWindow(contentView, Width, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });

        final RadioGroup mRgSex = (RadioGroup) contentView.findViewById(R.id.rg_sex);

        final RadioButton RbMan = (RadioButton) mRgSex.getChildAt(0);
        final RadioButton RbWoman = (RadioButton) mRgSex.getChildAt(2);
        changeImageSize(RbMan);
        changeImageSize(RbWoman);
        RbWoman.setChecked(true);
        if (mUserSex == 1) RbMan.setChecked(true);


//
//            mRgSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(RadioGroup group, int checkedId) {
//
//                    RadioButton   rb = (RadioButton)findViewById(checkedId);
//
//                    s(mContext,rb.getText());
////                    if (checkedId==0){
////
////                    }else if (checkedId==3){
////                        mUserSex = 0;
////                    }
////                    userSexText.setText(mUserSex == 1 ? "男" : "女");
//                }
//            });

        popupWindow.setTouchInterceptor(new View.OnTouchListener() {


            @Override
            public boolean onTouch(View v, MotionEvent event) {

                RbMan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mUserSex = 1;
                        userSexText.setText("男");
                        popupWindow.dismiss();
                    }
                });
                RbWoman.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mUserSex = 0;
                        userSexText.setText("女");
                        popupWindow.dismiss();
                    }
                });

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

        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

    }


    private void changeImageSize(RadioButton radioButton) {
        //定义底部标签图片大小
        int Width = (int) (SCREEN_WIDTH * 0.8);
        Drawable drawableFirst = getResources().getDrawable(R.drawable.member_evaluation_checkbox);
        drawableFirst.setBounds(0, 0, 60, 60);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        radioButton.setCompoundDrawables(null, null, drawableFirst, null);//只放上面


    }

    @Override
    public void onDismiss() {
//        mWeight= Integer.parseInt();
       userWeightText.setText(mTextWeight.tv_scale.getText().toString());
//        if (!mWeight.equals("") && !mHeight.equals("")){
//
//            btnNext.setImageResource(R.mipmap.img_btn_next_selected);
//        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
