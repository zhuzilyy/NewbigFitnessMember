package com.member.gufei.bigfitness.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * 使用 CompositeSubscription 持有所有的 Subscription
 * 在 Activity 或 Fragment 生命周期结束时调用 unsubscribe() 解除所有订阅
 * 用于解决在 Presenter 持有 View 时的内存泄漏问题
 *
 * @author GuFei
 * @version 2016 10 04 9:37
 */
public abstract class RxPresenter<T extends BaseView> implements BasePresenter<T> {

    protected T mView;
    protected CompositeSubscription mCompositeSubscription;

    protected void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    protected void addSubscription(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        unSubscribe();
        this.mView = null;
    }
}