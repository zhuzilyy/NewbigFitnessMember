package com.member.gufei.bigfitness.util;

import com.orhanobut.logger.Logger;
//import com.soujuw.ego.BuildConfig;


/**
 * 日志工具类
 *
 * @author GuFei
 * @version 2016 10 04 10:24
 */
public class LogUtil {

    private static boolean isDebug = true;
    private static final String TAG ="com.tre.GuFei";

    public static void e(String tag, Object o) {
        if (isDebug) {
            Logger.e(tag, o);
        }
    }

    public static void e(Object o) {
        LogUtil.e(TAG, o);
    }

    public static void w(String tag, Object o) {
        if (isDebug) {
            Logger.w(tag, o);
        }
    }

    public static void w(Object o) {
        LogUtil.w(TAG, o);
    }

    public static void d(String msg) {
        if (isDebug) {
            Logger.d(msg);
        }
    }

    public static void i(String msg) {
        Logger.i(msg);
    }
}