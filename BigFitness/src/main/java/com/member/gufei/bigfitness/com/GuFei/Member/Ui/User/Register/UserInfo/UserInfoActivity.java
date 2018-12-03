package com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Register.UserInfo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.BirthdayPickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnDismissListener;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.base.BaseActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Register.Height.HeightActivity;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.User.Register.Sex.SexActivity;
import com.member.gufei.bigfitness.util.SpUtil;

import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.member.gufei.bigfitness.Constants.SELECTBRITHADAYEY;
import static com.member.gufei.bigfitness.Constants.SELECTNAMEKEY;
import static com.member.gufei.bigfitness.Constants.SELECTSEXKEY;
import static com.member.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by GuFei_lyf on 2017/3/22
 * 登录页面 实现
 */


public class UserInfoActivity extends BaseActivity<UserInfoActivityPresenter> implements UserInfoActivityContract.View {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.edit_birthday)
    EditText editBirthday;
    @BindView(R.id.btn_next)
    ImageView btnNext;

    private BirthdayPickerView mBirthdayPickerView;
    private int year,month,day;
    private Calendar cal;

    @Override
    protected void initInject() {

        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.member_activity_user_info;
    }

    /**
     *
     */
    @Override
    protected void initView() {
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("");
        editBirthday.setFocusable(false);

        editName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!editName.getText().equals("") && !editBirthday.getText().equals("")){

                    btnNext.setImageResource(R.mipmap.img_btn_next_selected);
                }
            }
        });
       //获取当前日期
        getDate();

    }

    private void getDate() {
        cal=Calendar.getInstance();
        year=cal.get(Calendar.YEAR);       //获取年月日时分秒
        month=cal.get(Calendar.MONTH);   //获取到的月份是从0开始计数
        day=cal.get(Calendar.DAY_OF_MONTH);
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


    @OnClick({R.id.edit_birthday, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.edit_birthday:
//                initBirthdayPicker((EditText) view, "开始时间");
//                mBirthdayPickerView.show();
                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        editBirthday.setText(year + "-" + (++month) +  "-" + day);
                        //将选择的日期显示到EditText中,因为之前获取month直接使用，所以不需要+1，这个地方需要显示，所以+1
                    }
                };
                DatePickerDialog dialog = new DatePickerDialog(this, 0, listener, year,
                        month, day);//后边三个参数为显示dialog时默认的日期，月份从0开始，0-11对应1-12个月
                dialog.show();

                break;
            case R.id.btn_next:

                if(editName.getText().toString().length() != 0 && editBirthday.getText().toString().length() != 0){
                    SpUtil.put(mContext, SELECTNAMEKEY, editName.getText());
                    SpUtil.put(mContext, SELECTBRITHADAYEY,editBirthday.getText());
                    Intent intent = new Intent(UserInfoActivity.this, HeightActivity.class);
                    startActivity(intent);

                }
                break;
        }
    }

    private void initBirthdayPicker(final EditText view, String title) {

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
        mBirthdayPickerView = new BirthdayPickerView.Builder(this, null)
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

        mBirthdayPickerView.setTimeSelectListener(new BirthdayPickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {

            }

            @Override
            public void onTimeSelect(Date date) {
                view.setText(getTime(date));
                if (!editName.getText().equals("") && !editBirthday.getText().equals("")){

                    btnNext.setImageResource(R.mipmap.img_btn_next_selected);
                }
//                mBirthdayPickerView.dismiss();
            }
        });


    }
}

