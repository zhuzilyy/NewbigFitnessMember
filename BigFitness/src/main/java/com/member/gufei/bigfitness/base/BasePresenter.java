package com.member.gufei.bigfitness.base;

/**
 * Presenter 基类
 * 两个方法用于处理 Activity 生命周期内存泄漏问题
 * eg: 在 Presenter 处理耗时操作(网络请求)时, activity 被销毁,
 * 在 Presenter 调用 view 的接口更新 UI 将发生内存泄漏
 *
 * 实现这两个法对 Presenter 进行模拟生命周期处理,
 * 即在 activity 的 onCreate 方法中调用 Presenter 的 attachView 持有 view
 * 在 activity 的 onDestroy 方法中调用 Presenter 的 detachView 清除 view
 * 这样防止了内存泄漏的问题, 但需要注意 Presenter 中 view 的空指针问题.
 *
 * @author GuFei
 * @version 2016 10 04 9:36
 */

public interface BasePresenter<T extends BaseView> {

    /**
     * 合并视图
     */
    void attachView(T view);

    /**
     * 分离视图
     */
    void detachView();
}
