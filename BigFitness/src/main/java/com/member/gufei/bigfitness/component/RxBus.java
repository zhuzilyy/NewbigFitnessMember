package com.member.gufei.bigfitness.component;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * rxJava 实现的事件总线
 *
 * @author GuFei
 * @version 2016 10 05 15:50
 */
public class RxBus {

    private final Subject<Object, Object> bus;

    /**
     * PublishSubject只会把在订阅发生的时间点之后来自原始Observable的数据发射给观察者
     */
    private RxBus() {
        bus = new SerializedSubject<>(PublishSubject.create());
    }

    public static RxBus getDefault() {
        return RxBusHolder.sInstance;
    }

    /**
     * 静态内部类, 实现单例模式
     */
    private static class RxBusHolder {
        private static final RxBus sInstance = new RxBus();
    }

    /**
     * 提供了一个新的事件
     */
    public void post(Object o) {
        bus.onNext(o);
    }

    /**
     * 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
     */
    public <T> Observable<T> toObservable(Class<T> eventType) {
        return bus.ofType(eventType);
    }
}