package com.member.gufei.bigfitness.base;

/**
 * View 基类
 *
 * @author GuFei
 * @version 2016 10 04 9:36
 */

public interface BaseView {

    /**
     * 显示错误信息
     */
    void showError(String msg);

    /**
     * 没有数据
     */
    void showEmpty();

    /**
     * 加载中
     */
    void Loading();

}
