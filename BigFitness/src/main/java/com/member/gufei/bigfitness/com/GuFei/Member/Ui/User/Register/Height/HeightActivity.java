package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Register.Height;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bigkoo.pickerview.HeightPickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Register.FitnessDemand.FitnessDemandActivity;
import com.member.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import yanzhikai.ruler.BooheeRuler;
import yanzhikai.ruler.KgNumberLayout;

import static com.member.gufei.bigfitness.Constants.SELECTHEIGHTKEY;
import static com.member.gufei.bigfitness.Constants.SELECTWEIGHTKEY;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 登录页面 实现
 */


public class HeightActivity extends BaseActivity<HeightActivityPresenter> implements HeightActivityContract.View, PopupWindow.OnDismissListener {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.edit_height)
    EditText editHeight;
    @BindView(R.id.edit_weight)
    EditText editWeight;
    @BindView(R.id.btn_next)
    ImageView btnNext;

    String mHeight="";
    String mWeight="";
      KgNumberLayout mTextWeight;

    private HeightPickerView mHeightPickerView;

    @Override
    protected void initInject() {

        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_height;
    }

    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("");
        editHeight.setFocusable(false);
        editWeight.setFocusable(false);

    }


    @Override
    protected void initData() {

//        JPushInterface.init(getApplicationContext());

    }


    @Override
    public void showError(String msg) {

        s(this, msg);

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void outLogin() {

//        Intent intent = new Intent(mContext, LoginActivity.class);
//        startActivity(intent);

    }


    @Override
    public void Loading() {

    }

    @OnClick({R.id.edit_height, R.id.edit_weight, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.edit_height:
                initHeightPicker((EditText) view, "身高");
                mHeightPickerView.show();
                break;
            case R.id.edit_weight:
                SelectPopup(view,0);

                break;
            case R.id.btn_next:

                if (!mWeight.equals("") && !mHeight.equals("")){
                    SpUtil.put(mContext, SELECTHEIGHTKEY, mHeight);
                    SpUtil.put(mContext, SELECTWEIGHTKEY, mWeight);
                    Intent intent = new Intent(HeightActivity.this, FitnessDemandActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

    private void initHeightPicker(final EditText view, String title) {

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

                editHeight.setText(mHeight+"cm");

                if (!mWeight.equals("") && !mHeight.equals("")){

                    btnNext.setImageResource(R.mipmap.img_btn_next_selected);
                }


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
                .setCancelColor(Color.WHITE)
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
                            public void onClick(View v) {
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
        mHeightPickerView.setSelectOptions(70);
        mHeightPickerView.setNPicker(mOptions1Items);

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
        Button btnSubmit = (Button)contentView.findViewById(R.id.btnSubmit_sure);
        mTextWeight = (KgNumberLayout) contentView.findViewById(R.id.text_weight);
        final BooheeRuler scaleScrollView = (BooheeRuler) contentView.findViewById(R.id.hsScale);
        mTextWeight.bindRuler(scaleScrollView);

//        scaleScrollView.setIsIntegarl(false);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWeight=mTextWeight.tv_scale.getText().toString();
                editWeight.setText(mWeight+"kg");
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

    @Override
    public void onDismiss() {

        mWeight=mTextWeight.tv_scale.getText().toString();
        editWeight.setText(mWeight+"kg");
        if (!mWeight.equals("") && !mHeight.equals("")){

            btnNext.setImageResource(R.mipmap.img_btn_next_selected);
        }

    }
}

