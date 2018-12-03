package com.member.gufei.bigfitness.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description
 *
 * @author GuFei
 * @version 2016 09 28 14:12
 * 电话号工具类
 *
 */
@SuppressWarnings("unused")
public class MobileUtil {

    /**
     * 手机号验证
     *
     * @param  str
     * @return 验证通过返回true
     */
    public static boolean isMobile(String str) {
        if (str == null) {
            return false;
        }
        Pattern p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号  ;
        Matcher m = p.matcher(str);
        return m.matches();
    }
    /**
     * 电话号码验证
     *
     * @param  str
     * @return 验证通过返回true
     */
    public static boolean isPhone(String str) {
        if (str == null) {
            return false;
        }
        boolean b = false;
        Pattern p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的
        Pattern p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的
        if(str.length() >9)
        {
            Matcher m = p1.matcher(str);
            return m.matches();
        }else{
            Matcher m = p2.matcher(str);
            return m.matches();
        }
    }

}