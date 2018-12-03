package com.member.gufei.bigfitness.com.GuFei.Member.Ui.TestActivity;

import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;


import com.bigkoo.pickerview.BirthdayPickerView;
import com.bigkoo.pickerview.HeightPickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.Presenter.SpinnerPopContract;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.InformationClass.Notice.NoticeListActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.AerobicsClass.CoachDetails.CoachDetailsActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.CulbsEvaluateList.CulbsEvaluateListActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.RenewCard.Number.RenewNumberCardActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.main.MainActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.QRCode.MyQRCode.MyQRCodeActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.ReservationRecordClass.ClassEvaluationing.ClassEvaluationingActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Set.EditName.EditNameActivity;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;




import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;
import yanzhikai.ruler.BooheeRuler;
import yanzhikai.ruler.KgNumberLayout;

public class TestActivity extends BaseActivity<TestActivityPresenter> implements SpinnerPopContract, TestActivityContract.View {


    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.btn5)
    Button btn5;
    @BindView(R.id.btn6)
    Button btn6;
    @BindView(R.id.btn7)
    Button btn7;
    @BindView(R.id.btn8)
    Button btn8;
    @BindView(R.id.btn9)
    Button btn9;
    @BindView(R.id.btn10)
    Button btn10;
    @BindView(R.id.btn11)
    Button btn11;
    @BindView(R.id.btn12)
    Button btn12;
    @BindView(R.id.btn13)
    Button btn13;
    @BindView(R.id.btn14)
    Button btn14;


    private View contentView;
    private PopupWindow popupWindow;
    private BirthdayPickerView mBirthdayPickerView;
    private HeightPickerView mHeightPickerView;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {

        return R.layout.activity_test;

    }

    @Override
    protected void initView() {


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
    public void dismiss() {
        backgroundAlpha(1f);
    }


    @Override
    public void Success(CustomerInfoBean customerInfoBean) {


    }


    @Override
    public void EditSuccess(CodeBean codeBean) {


    }


    @OnClick({R.id.btn14, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10, R.id.btn11, R.id.btn12, R.id.btn13})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:

                Intent mMainActivity = new Intent(mContext, MainActivity.class);
                startActivity(mMainActivity);
                break;
            case R.id.btn2:

                Intent mNoticeListActivity = new Intent(mContext, NoticeListActivity.class);
                startActivity(mNoticeListActivity);
                break;

            case R.id.btn3:

                Intent mCulbsEvaluateListActivity = new Intent(mContext, CulbsEvaluateListActivity.class);
                startActivity(mCulbsEvaluateListActivity);
                break;
            case R.id.btn4:

                Intent mMyQRCodeActivity = new Intent(mContext, MyQRCodeActivity.class);
                startActivity(mMyQRCodeActivity);
                break;

            case R.id.btn5:

                Intent mEditNameActivity = new Intent(mContext, EditNameActivity.class);
                startActivity(mEditNameActivity);
                break;

            case R.id.btn6:

                Intent mClassEvaluationingActivity = new Intent(mContext, ClassEvaluationingActivity.class);
                startActivity(mClassEvaluationingActivity);
                break;
            case R.id.btn7:

                Intent mCoachDetailsActivity = new Intent(mContext, CoachDetailsActivity.class);
                startActivity(mCoachDetailsActivity);
                break;

            case R.id.btn8:

                Intent mUpGradeCardActivity = new Intent(mContext, RenewNumberCardActivity.class);
                startActivity(mUpGradeCardActivity);
                break;
            case R.id.btn9:
                SelectPopup(view, 0);

                break;
            case R.id.btn10:
//                SelectPopup(view, 0);
                initBirthdayPicker((Button) view, "开始时间");
                mBirthdayPickerView.show();
                break;
            case R.id.btn11:
                initHeightPicker((Button) view, "开始时间");
                mHeightPickerView.show();

                break;


            case R.id.btn12:
                Toast.makeText(this, "测试", Toast.LENGTH_SHORT).show();
//
//                Order order = new Order();
//
//                order.setBody("会员充值中心");
//                order.setParaTradeNo(System.currentTimeMillis() + "");
//                order.setTotalFee(20);
//                order.setAttach("json");//附加参数
//                order.setNofityUrl("http://www.baidu.com");//支付成功服务端回调通知的地址
//                order.setDeviceInfo("");
//
//                new WXPayTask(this).execute(order);
                break;
            case R.id.btn13:
                Toast.makeText(this, "支付宝测试", Toast.LENGTH_SHORT).show();

//                Order orderAli = new Order();
//                orderAli.setBody("会员充值中心");
//                orderAli.setParaTradeNo(System.currentTimeMillis() + "");
//                orderAli.setTotalFee(20);
//                orderAli.setAttach("json");//附加参数
//                orderAli.setNofityUrl("http://www.xxxx.com");//支付成功服务端回调通知的地址
//
//                new AliPayTask(this).execute(orderAli);

                break;
            case R.id.btn14:
                TabPopup(view,0);

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
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });

//        final TextView mTextWeight = (TextView)contentView. findViewById(R.id.text_weight);
        final KgNumberLayout mTextWeight = (KgNumberLayout) contentView.findViewById(R.id.text_weight);
        final BooheeRuler scaleScrollView = (BooheeRuler) contentView.findViewById(R.id.hsScale);
        mTextWeight.bindRuler(scaleScrollView);
//        scaleScrollView.setIsIntegarl(false);

//        scaleScrollView.setOnScrollListener(new HorizontalScaleScrollView.OnScrollListener() {
//            @Override
//            public void onScaleScroll(double scale) {
//                mTextWeight.setText(scale+"kg" );
//            }
//        });


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

    private void initBirthdayPicker(final Button view, String title) {

        /**
         * @description
         *
         * 注意事项：
         * 1.自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针.
         * 具体可参考demo 里面的两个自定义layout布局。
         * 2.因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
         * setRangDate方法控制起始终止时间(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
         */
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        startDate.set(2014, 1, 23);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2027, 2, 28);
        //时间选择器 ，自定义布局
        mBirthdayPickerView = new BirthdayPickerView.Builder(this, new BirthdayPickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调

                mBirthdayPickerView.dismiss();
            }

            @Override
            public void onTimeSelect(Date date) {

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
                .setDate(selectedDate)
                .isDialog(false)
                .setTitleText(title)
                .setRangDate(startDate, endDate)

                .setLayoutRes(R.layout.pickerview_birthday, new CustomListener() {

                    @Override
                    public void customLayout(View v) {
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
                .setType(BirthdayPickerView.Type.YEAR_MONTH_DAY)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setLabel("", "", "", "", "", "") //设置空字符串以隐藏单位提示   hide label
                .setDividerColor(R.color.no_back)
                .build();

    }

    private void initHeightPicker(final Button view, String title) {

        /**
         * @description
         *
         * 注意事项：
         * 1.自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针.
         * 具体可参考demo 里面的两个自定义layout布局。
         * 2.因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
         * setRangDate方法控制起始终止时间(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
         */
        ArrayList<String> mOptions1Items = new ArrayList<>();
        for (int i = 100; i < 210; i++) {
            mOptions1Items.add(i + "");
        }
        //时间选择器 ，自定义布局
        mHeightPickerView = new HeightPickerView.Builder(this, new HeightPickerView.OnOptionsSelectListener() {


            @Override
            public void onOptionsSelect(int options1, View v) {

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

        mHeightPickerView.setNPicker(mOptions1Items);

    }


    public void TabPopup(View v, final int tag) {
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
        popupWindow.setOutsideTouchable(false);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
//
////        final TextView mTextWeight = (TextView)contentView. findViewById(R.id.text_weight);
//        final KgNumberLayout mTextWeight = (KgNumberLayout) contentView.findViewById(R.id.text_weight);
//        final BooheeRuler scaleScrollView = (BooheeRuler) contentView.findViewById(R.id.hsScale);
//        mTextWeight.bindRuler(scaleScrollView);
//        scaleScrollView.setIsIntegarl(false);

//        scaleScrollView.setOnScrollListener(new HorizontalScaleScrollView.OnScrollListener() {
//            @Override
//            public void onScaleScroll(double scale) {
//                mTextWeight.setText(scale+"kg" );
//            }
//        });

        popupWindow.setFocusable(true);
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
//        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));
        // 设置好参数之后再show
        //获取点击View的坐标

        int[] point = {0, 0};

        v.getLocationOnScreen(point);

//        popupWindow.showAtLocation(v, Gravity.CENTER, 0, point[1] + v.getHeight());
        popupWindow.showAtLocation(v, Gravity.BOTTOM, 0, -100);

    }
}
