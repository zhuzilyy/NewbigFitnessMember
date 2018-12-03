package com.member.gufei.bigfitness.util;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Description
 *
 * @author GuFei
 * @version 2016 10 05 23:11
 * Toast提示工具类
 *
 */
public class SnackbarUtil {
    public static void l(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }

    public static void s(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }
}
