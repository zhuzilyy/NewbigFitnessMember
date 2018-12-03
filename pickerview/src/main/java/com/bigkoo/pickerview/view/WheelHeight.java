package com.bigkoo.pickerview.view;

import android.graphics.Typeface;
import android.view.View;

import com.bigkoo.pickerview.R;
import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.bigkoo.pickerview.lib.ImgWheelView;
import com.bigkoo.pickerview.lib.WheelView;
import com.bigkoo.pickerview.listener.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class WheelHeight<T> {
    private View view;
    private WheelView wv_option1;
    private ImgWheelView wv_left;
    private ImgWheelView wv_right;

    private List<T> mOptions1Items;

    private boolean linkage;
    private OnItemSelectedListener wheelListener_option1;


    //文字的颜色和分割线的颜色
    int textColorOut;
    int textColorCenter;
    int dividerColor;

    private WheelView.DividerType dividerType;

    // 条目间距倍数
    float lineSpacingMultiplier = 1.6F;

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public WheelHeight(View view, Boolean linkage) {
        super();
        this.linkage = linkage;
        this.view = view;
        wv_option1 = (WheelView) view.findViewById(R.id.options1);// 初始化时显示的数据
        // 左侧
        wv_left = (ImgWheelView) view.findViewById(R.id.left);
        // 右侧
        wv_right = (ImgWheelView) view.findViewById(R.id.right);

    }


    //不联动情况下
    public void setNPicker(List<T> options1Items) {
        this.mOptions1Items = options1Items;

        int len = ArrayWheelAdapter.DEFAULT_LENGTH;



        List<String> mOptions=new ArrayList<String>();


        mOptions.add("      ");

        wv_left.setAdapter(new ArrayWheelAdapter(mOptions, 1));// 设置显示数据
//        wv_left.setCurrentItem(0);// 初始化时显示的数据
        wv_left.setIsLeft(true);
        wv_left.setisRight(false);

        wv_right.setAdapter(new ArrayWheelAdapter(mOptions, 1));// 设置显示数据
//        wv_right.setCurrentItem(0);// 初始化时显示的数据
        wv_right.setIsLeft(false);
        wv_right.setisRight(true);

        // 选项1
        wv_option1.setAdapter(new ArrayWheelAdapter(mOptions1Items, len));// 设置显示数据
//        wv_option1.setCurrentItem(0);// 初始化时显示的数据
        wv_option1.setIsOptions(true);

    }


    public void setTextContentSize(int textSize) {
        wv_option1.setTextSize(textSize);
        wv_left.setTextSize(textSize);
        wv_right.setTextSize(textSize);

    }

    private void setTextColorOut() {
        wv_option1.setTextColorOut(textColorOut);
        wv_left.setTextColorOut(textColorOut);
        wv_right.setTextColorOut(textColorOut);


    }

    private void setTextColorCenter() {
        wv_option1.setTextColorCenter(textColorCenter);
        wv_left.setTextColorCenter(textColorCenter);
        wv_right.setTextColorCenter(textColorCenter);

    }

    private void setDividerColor() {
        wv_option1.setDividerColor(dividerColor);
        wv_left.setDividerColor(dividerColor);
        wv_right.setDividerColor(dividerColor);

    }

    private void setDividerType() {
        wv_option1.setDividerType(dividerType);
//        wv_left.setDividerType(dividerType);
//        wv_right.setDividerType(dividerType);

    }

    private void setLineSpacingMultiplier() {
        wv_option1.setLineSpacingMultiplier(lineSpacingMultiplier);
        wv_left.setLineSpacingMultiplier(lineSpacingMultiplier);
        wv_right.setLineSpacingMultiplier(lineSpacingMultiplier);


    }

    /**
     * 设置选项的单位
     *
     * @param label1 单位

     */
    public void setLabels(String label1, String label2, String label3) {
        if (label1 != null)
            wv_option1.setLabel(label1);

    }

    /**
     * 设置是否循环滚动
     *
     * @param cyclic 是否循环
     */
    public void setCyclic(boolean cyclic) {
        wv_option1.setCyclic(cyclic);
        wv_left.setCyclic(cyclic);
        wv_right.setCyclic(cyclic);

    }

    /**
     * 设置字体样式
     *
     * @param font 系统提供的几种样式
     */
    public void setTypeface(Typeface font) {
        wv_option1.setTypeface(font);
        wv_left.setTypeface(font);
        wv_right.setTypeface(font);

    }

    /**
     * 分别设置第一二三级是否循环滚动
     *
     * @param cyclic1,cyclic2,cyclic3 是否循环
     */
    public void setCycliccyclic1(boolean cyclic1) {
        wv_option1.setCyclic(cyclic1);



    }


    /**
     * 返回当前选中的结果对应的位置数组 因为支持三级联动效果，分三个级别索引，0，1，2。
     * 在快速滑动未停止时，点击确定按钮，会进行判断，如果匹配数据越界，则设为0，防止index出错导致崩溃。
     *
     * @return 索引数组
     */
    public int[] getCurrentItems() {
        int[] currentItems = new int[3];
        currentItems[0] = wv_option1.getCurrentItem();


        return currentItems;
    }

    public void setCurrentItems(int option1) {
        if (linkage) {
            itemSelected(option1);
        }
        wv_option1.setCurrentItem(option1);

    }

    private void itemSelected(int opt1Select) {

    }

    /**
     * 设置间距倍数,但是只能在1.2-2.0f之间
     *
     * @param lineSpacingMultiplier
     */
    public void setLineSpacingMultiplier(float lineSpacingMultiplier) {
        this.lineSpacingMultiplier = lineSpacingMultiplier;
        setLineSpacingMultiplier();
    }

    /**
     * 设置分割线的颜色
     *
     * @param dividerColor
     */
    public void setDividerColor(int dividerColor) {
        this.dividerColor = dividerColor;
        setDividerColor();
    }

    /**
     * 设置分割线的类型
     *
     * @param dividerType
     */
    public void setDividerType(WheelView.DividerType dividerType) {
        this.dividerType = dividerType;
        setDividerType();
    }

    /**
     * 设置分割线之间的文字的颜色
     *
     * @param textColorCenter
     */
    public void setTextColorCenter(int textColorCenter) {
        this.textColorCenter = textColorCenter;
        setTextColorCenter();
    }

    /**
     * 设置分割线以外文字的颜色
     *
     * @param textColorOut
     */
    public void setTextColorOut(int textColorOut) {
        this.textColorOut = textColorOut;
        setTextColorOut();
    }

    /**
     * Label 是否只显示中间选中项的
     *
     * @param isCenterLabel
     */

    public void isCenterLabel(Boolean isCenterLabel) {
        wv_option1.isCenterLabel(isCenterLabel);

    }

}
