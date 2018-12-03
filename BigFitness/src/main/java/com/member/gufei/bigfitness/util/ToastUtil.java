package com.member.gufei.bigfitness.util;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.member.gufei.bigfitness.R;


/**
 * Toast 工具类
 * 本类保持封装单体 Toast ,直接改变当前 Toast 内容,不会重复显示.
 *
 * @author GuFei
 * @version 2016 10 04 10:29
 */
public class ToastUtil {

    private ToastUtil() {
    }

    private static Toast toast;

    /**
     * 短时间 Toast
     *  @param context context
     * @param message message
     */
    public static void s(Context context, CharSequence message) {
        if (toast == null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            // 获取LayoutInflater对象
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // 由layout文件创建一个View对象
            View layout = inflater.inflate(R.layout.member_toast, null);
            TextView textView = (TextView) layout.findViewById(R.id.message);
            textView.setText(message);
            toast.setView(layout);
            toast.setGravity(Gravity.CENTER|Gravity.BOTTOM, 0, 100);
            toast.setDuration(Toast.LENGTH_SHORT);

        } else {
            // 获取LayoutInflater对象
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.member_toast, null);
            TextView textView = (TextView) layout.findViewById(R.id.message);
            textView.setText(message);
            toast.setView(layout);
            toast.setGravity(Gravity.CENTER|Gravity.BOTTOM, 0, 100);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    /**
     * 长时间 Toast
     *
     * @param context context
     * @param message message
     */
    public static void l(Context context, CharSequence message) {
        if (toast == null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        } else {
            toast.setText(message);
            toast.setDuration(Toast.LENGTH_LONG);
        }
        toast.show();
    }



}