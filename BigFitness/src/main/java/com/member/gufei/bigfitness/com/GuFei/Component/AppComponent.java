package com.member.gufei.bigfitness.com.GuFei.Component;

import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.com.GuFei.Moudel.AppModule;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;


import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * Created by GuFei_lyf on 2017/3/21
 * 三方依赖注入工具
 *
 */


@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(App app);

    /**
     * 提供 App 的 Context
     */
    @Named("application")
    App getContext();

    /**
     * 提供请求类对象
     */
    Api getApi();





    /**
     * 提供数据库服务类
     */
//    RealmService getRealmService();

    /**
     * 百度定位
     */
//    LocationClient getLocationClient();

    /**
     * 微信
     */
//    IWXAPI getIWXapi();

    /**
     * OkHttp
     */
    OkHttpClient getOkHttpClient();



}
