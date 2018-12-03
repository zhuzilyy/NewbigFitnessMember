package com.bigkoo.pickerview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.bigkoo.pickerview.lib.WheelView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.view.BasePickerView;
import com.bigkoo.pickerview.view.WheelHeight;
import com.bigkoo.pickerview.view.WheelOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * 条件选择器
 * Created by Sai on 15/11/22.
 */
public class HeightPickerView<T> extends BasePickerView implements View.OnClickListener {

    WheelHeight<T> wheelHeight;
    private int layoutRes;
    private CustomListener customListener;
    private Button btnSubmit, btnCancel; //确定、取消按钮
    private TextView tvTitle;
    private RelativeLayout rv_top_bar;

    private static final String TAG_SUBMIT = "submit";
    private static final String TAG_CANCEL = "cancel";

    private OnOptionsSelectListener optionsSelectListener;

    private String Str_Submit;//确定按钮文字
    private String Str_Cancel;//取消按钮文字
    private String Str_Title;//标题文字

    private int Color_Submit;//确定按钮颜色
    private int Color_Cancel;//取消按钮颜色
    private int Color_Title;//标题颜色

    private int Color_Background_Wheel;//滚轮背景颜色
    private int Color_Background_Title;//标题背景颜色

    private int Size_Submit_Cancel;//确定取消按钮大小
    private int Size_Title;//标题文字大小
    private int Size_Content;//内容文字大小

    private int textColorOut; //分割线以外的文字颜色
    private int textColorCenter; //分割线之间的文字颜色
    private int dividerColor; //分割线的颜色
    // 条目间距倍数 默认1.6
    private float lineSpacingMultiplier = 1.6F;
    private boolean isDialog;//是否是对话框模式

    private boolean cancelable;//是否能取消
    private boolean linkage;//是否联动

    private boolean isCenterLabel ;//是否只显示中间的label

    private String label1;//单位


    private boolean cyclic1;//是否循环


    private Typeface font;//字体样式

    private int option1;//默认选中项

    private WheelView.DividerType dividerType;//分隔线类型

    //构造方法
    public HeightPickerView(Builder builder) {
        super(builder.context);
        this.optionsSelectListener = builder.optionsSelectListener;
        this.Str_Submit = builder.Str_Submit;
        this.Str_Cancel = builder.Str_Cancel;
        this.Str_Title = builder.Str_Title;

        this.Color_Submit = builder.Color_Submit;
        this.Color_Cancel = builder.Color_Cancel;
        this.Color_Title = builder.Color_Title;
        this.Color_Background_Wheel = builder.Color_Background_Wheel;
        this.Color_Background_Title = builder.Color_Background_Title;

        this.Size_Submit_Cancel = builder.Size_Submit_Cancel;
        this.Size_Title = builder.Size_Title;
        this.Size_Content = builder.Size_Content;

        this.cyclic1 = builder.cyclic1;

        this.cancelable = builder.cancelable;
        this.linkage = builder.linkage;
        this.isCenterLabel = builder.isCenterLabel;

        this.label1 = builder.label1;

        this.font = builder.font;


        this.option1 = builder.option1;

        this.textColorCenter = builder.textColorCenter;
        this.textColorOut = builder.textColorOut;
        this.dividerColor = builder.dividerColor;
        this.lineSpacingMultiplier = builder.lineSpacingMultiplier;
        this.customListener = builder.customListener;
        this.layoutRes = builder.layoutRes;
        this.isDialog = builder.isDialog;
        this.dividerType = builder.dividerType;

        initView(builder.context);
    }


    //建造器
    public static class Builder {
        private int layoutRes = R.layout.pickerview_birthday;
        private CustomListener customListener;
        private Context context;
        private OnOptionsSelectListener optionsSelectListener;

        private String Str_Submit;//确定按钮文字
        private String Str_Cancel;//取消按钮文字
        private String Str_Title;//标题文字

        private int Color_Submit;//确定按钮颜色
        private int Color_Cancel;//取消按钮颜色
        private int Color_Title;//标题颜色

        private int Color_Background_Wheel;//滚轮背景颜色
        private int Color_Background_Title;//标题背景颜色

        private int Size_Submit_Cancel = 17;//确定取消按钮大小
        private int Size_Title = 18;//标题文字大小
        private int Size_Content = 18;//内容文字大小

        private boolean cancelable = true;//是否能取消
        private boolean linkage = true;//是否联动
        private boolean isCenterLabel = true;//是否只显示中间的label

        private int textColorOut; //分割线以外的文字颜色
        private int textColorCenter; //分割线之间的文字颜色
        private int dividerColor; //分割线的颜色
        // 条目间距倍数 默认1.6
        private float lineSpacingMultiplier = 1.6F;
        private boolean isDialog;//是否是对话框模式

        private String label1;


        private boolean cyclic1 = false;//是否循环，默认否


        private Typeface font;

        private int option1;//默认选中项



        private WheelView.DividerType dividerType;//分隔线类型

        //Required
        public Builder(Context context, OnOptionsSelectListener listener) {
            this.context = context;
            this.optionsSelectListener = listener;
        }

        //Option

        public Builder setSubmitText(String Str_Cancel) {
            this.Str_Submit = Str_Cancel;
            return this;
        }

        public Builder setCancelText(String Str_Cancel) {
            this.Str_Cancel = Str_Cancel;
            return this;
        }

        public Builder setTitleText(String Str_Title) {
            this.Str_Title = Str_Title;
            return this;
        }

        public Builder isDialog(boolean isDialog) {
            this.isDialog = isDialog;
            return this;
        }

        public Builder setSubmitColor(int Color_Submit) {
            this.Color_Submit = Color_Submit;
            return this;
        }

        public Builder setCancelColor(int Color_Cancel) {
            this.Color_Cancel = Color_Cancel;
            return this;
        }

        public Builder setLayoutRes(int res, CustomListener listener) {
            this.layoutRes = res;
            this.customListener = listener;
            return this;
        }

        public Builder setBgColor(int Color_Background_Wheel) {
            this.Color_Background_Wheel = Color_Background_Wheel;
            return this;
        }

        public Builder setTitleBgColor(int Color_Background_Title) {
            this.Color_Background_Title = Color_Background_Title;
            return this;
        }

        public Builder setTitleColor(int Color_Title) {
            this.Color_Title = Color_Title;
            return this;
        }

        public Builder setSubCalSize(int Size_Submit_Cancel) {
            this.Size_Submit_Cancel = Size_Submit_Cancel;
            return this;
        }

        public Builder setTitleSize(int Size_Title) {
            this.Size_Title = Size_Title;
            return this;
        }

        public Builder setContentTextSize(int Size_Content) {
            this.Size_Content = Size_Content;
            return this;
        }


        public Builder setOutSideCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        /**
         * 此方法已废弃
         * 不联动的情况下，请调用 setNPicker 方法。
         * */
        @Deprecated
        public Builder setLinkage(boolean linkage) {
            this.linkage = linkage;
            return this;
        }

        public Builder setLabels(String label1) {
            this.label1 = label1;

            return this;
        }

        /**
         * 设置间距倍数,但是只能在1.2-2.0f之间
         *
         * @param lineSpacingMultiplier
         */
        public Builder setLineSpacingMultiplier(float lineSpacingMultiplier) {
            this.lineSpacingMultiplier = lineSpacingMultiplier;
            return this;
        }

        /**
         * 设置分割线的颜色
         *
         * @param dividerColor
         */
        public Builder setDividerColor(int dividerColor) {
            this.dividerColor = dividerColor;
            return this;
        }

        /**
         * 设置分割线的类型
         *
         * @param dividerType
         */
        public Builder setDividerType(WheelView.DividerType dividerType) {
            this.dividerType = dividerType;
            return this;
        }

        /**
         * 设置分割线之间的文字的颜色
         *
         * @param textColorCenter
         */
        public Builder setTextColorCenter(int textColorCenter) {
            this.textColorCenter = textColorCenter;
            return this;
        }

        /**
         * 设置分割线以外文字的颜色
         *
         * @param textColorOut
         */
        public Builder setTextColorOut(int textColorOut) {
            this.textColorOut = textColorOut;
            return this;
        }

        public Builder setTypeface(Typeface font) {
            this.font = font;
            return this;
        }

        public Builder setCyclic(boolean cyclic1, boolean cyclic2, boolean cyclic3) {
            this.cyclic1 = cyclic1;

            return this;
        }

        public Builder setSelectOptions( int option1) {
            this.option1 = option1;
            return this;
        }





        public Builder isCenterLabel(boolean isCenterLabel) {
            this.isCenterLabel = isCenterLabel;
            return this;
        }

        public HeightPickerView build() {
            return new HeightPickerView(this);
        }
    }


    private void initView(Context context) {
        setDialogOutSideCancelable(cancelable);
        initViews();
        init();
        initEvents();
        if (customListener == null) {
            LayoutInflater.from(context).inflate(layoutRes, contentContainer);

            //顶部标题
            tvTitle = (TextView) findViewById(R.id.tvTitle);
            rv_top_bar = (RelativeLayout)findViewById(R.id.rv_topbar);

            //确定和取消按钮
            btnSubmit = (Button) findViewById(R.id.btnSubmit);
            btnCancel.setVisibility(View.GONE);
            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                }
            });
            btnCancel = (Button) findViewById(R.id.btnCancel);
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                }
            });
            btnSubmit.setTag(TAG_SUBMIT);
            btnCancel.setTag(TAG_CANCEL);
            btnSubmit.setOnClickListener(this);
            btnCancel.setOnClickListener(this);
            btnSubmit.setVisibility(View.GONE);
            btnCancel.setVisibility(View.GONE);
            //设置文字
            btnSubmit.setText(TextUtils.isEmpty(Str_Submit) ? context.getResources().getString(R.string.pickerview_submit) : Str_Submit);
            btnCancel.setText(TextUtils.isEmpty(Str_Cancel) ? context.getResources().getString(R.string.pickerview_cancel) : Str_Cancel);
            tvTitle.setText(TextUtils.isEmpty(Str_Title) ? "" : Str_Title);//默认为空

            //设置color
            btnSubmit.setTextColor(Color_Submit == 0 ? pickerview_timebtn_nor : Color_Submit);
            btnCancel.setTextColor(Color_Cancel == 0 ? pickerview_timebtn_nor : Color_Cancel);
            tvTitle.setTextColor(Color_Title == 0 ? pickerview_topbar_title : Color_Title);
            rv_top_bar.setBackgroundColor(Color_Background_Title == 0 ? pickerview_bg_topbar : Color_Background_Title);

            //设置文字大小
            btnSubmit.setTextSize(Size_Submit_Cancel);
            btnCancel.setTextSize(Size_Submit_Cancel);
            tvTitle.setTextSize(Size_Title);
            tvTitle.setText(Str_Title);
        } else {
            customListener.customLayout(LayoutInflater.from(context).inflate(layoutRes, contentContainer));
        }

        // ----滚轮布局
//        final LinearLayout optionsPicker = (LinearLayout) findViewById(R.id.optionspicker);
        final LinearLayout optionsPicker = (LinearLayout) findViewById(R.id.Heightpicker);
//        optionsPicker.setBackgroundColor(Color_Background_Wheel == 0 ? bgColor_default : Color_Background_Wheel);
        optionsPicker.setBackgroundColor(Color.parseColor("#FFFFFF"));
        wheelHeight = new WheelHeight(optionsPicker, linkage);
        wheelHeight.setTextContentSize(Size_Content);




        wheelHeight.setTypeface(font);

        setOutSideCancelable(cancelable);

        if (tvTitle!= null){
            tvTitle.setText(Str_Title);
        }

        wheelHeight.setDividerColor(dividerColor);
        wheelHeight.setDividerType(dividerType);
        wheelHeight.setLineSpacingMultiplier(lineSpacingMultiplier);
        wheelHeight.setTextColorOut(textColorOut);
        wheelHeight.setTextColorCenter(textColorCenter);
        wheelHeight.isCenterLabel(isCenterLabel);

    }


    /**
     * 设置默认选中项
     *
     * @param option1
     */
    public void setSelectOptions(int option1) {
        this.option1 = option1;
        SetCurrentItems(option1);
    }


    private void SetCurrentItems(int option1) {
        if(wheelHeight !=null){
            wheelHeight.setCurrentItems(option1);
        }
    }


    @Override
    public void dismiss() {
        returnData();
        super.dismiss();
    }

    //不联动情况下调用
    public void setNPicker(List<T> options1Items ) {

        wheelHeight.setNPicker(options1Items );
//        SetCurrentItems();
    }

    @Override
    public void onClick(View v) {
        String tag = (String) v.getTag();
        if (tag.equals(TAG_SUBMIT)) {
            returnData();
        }

        dismiss();
    }

    //抽离接口回调的方法
    public void returnData() {
        if (optionsSelectListener != null) {
            int[] optionsCurrentItems = wheelHeight.getCurrentItems();
            optionsSelectListener.onOptionsSelect(optionsCurrentItems[0],  clickView);
        }
    }

    public interface OnOptionsSelectListener {
        void onOptionsSelect(int options1, View v);
    }

    @Override
    public boolean isDialog() {
        return isDialog;
    }
}
