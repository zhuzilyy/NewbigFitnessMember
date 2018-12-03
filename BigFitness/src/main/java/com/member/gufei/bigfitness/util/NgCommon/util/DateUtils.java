package com.member.gufei.bigfitness.util.NgCommon.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jiangzn on 16/12/5.
 */

public class DateUtils {

    public static String dateFormat(long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        return formatter.format(date);
    }

    public static String dateFormat24(long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(time);
        return formatter.format(date);
    }
}
