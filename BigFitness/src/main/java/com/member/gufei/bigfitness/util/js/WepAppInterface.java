package com.member.gufei.bigfitness.util.js;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by GuFei on 2017/6/4.
 * 用于原生于js调用
 *
 */
public class WepAppInterface {

    private Context mContext;

    public WepAppInterface(Context context) {
        this.mContext = context;
    }

    /**
     * 显示Toast在Webiew调用
     */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    /**
     * 读取文件
     *
     * @param
     * @return
     */
    @JavascriptInterface
    public String readFile() {

        return "这是返回值";
    }
    /**
     * 页面加载提示
     *
     * @param
     * @return
     */
    @JavascriptInterface
    public String onPageLoad() {
        Toast.makeText(mContext, "页面加载中...", Toast.LENGTH_SHORT).show();
        return "onPageLoad";
    }
}
