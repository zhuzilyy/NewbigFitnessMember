package com.member.gufei.bigfitness.util.MyScroll;

/**
 * Created by GuFei_lyf on 2017/3/28
 * 用于自定义ScrollView的接口
 */

public interface ScrollViewListener {
    void onScrollChanged(MyScrollView scrollView, int x, int y, int oldx, int oldy);
}
