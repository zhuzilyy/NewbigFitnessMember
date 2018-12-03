package com.member.gufei.bigfitness.com.GuFei.Moudel;


import com.member.gufei.bigfitness.App;
import com.member.gufei.bigfitness.Constants;
import com.member.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.member.gufei.bigfitness.component.PersistentCookieStore;
import com.member.gufei.bigfitness.util.SystemUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by GuFei_lyf on 2017/3/21
 * App Module 基类
 */

@Module
public class AppModule {

    private final App application;

    public AppModule(App application) {
        this.application = application;
    }



    @Provides
    @Singleton
    @Named("application")
    App provideApplicationContext() {
        return application;
    }

    /**
     * 提供 Gson
     * @return Gson
     */
    @Provides
    @Singleton
    Gson providerGson() {
        //Jun 23, 2016 1:32:14 PM
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                //.setDateFormat("MMM dd, yyyy hh:mm:ss toggle_button_selector")
                .setPrettyPrinting().create();
    }




    /**
     * 提供 OkHttpClient
     * 添加缓存,日志拦截器,超时时间设置,cookie 自动化管理
     * @return OkHttpClient
     */
    @Provides
    @Singleton
    OkHttpClient providerOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // 添加日志拦截器
//        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
//        }
        // 配置缓存
        Cache cache = new Cache(application.getCacheDir(), Constants.CACHE_SIZE);
        builder.cache(cache);
        // 配置缓存拦截器,实现无网络时也可以显示数据
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!SystemUtil.isNetworkConnected()) { // 无网络时请求使用缓存
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }

                Response response = chain.proceed(request);
                if (SystemUtil.isNetworkConnected()) {
                    int maxAge = 0;
                    // 有网络时, 不缓存, 最大保存时长为0
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };
        builder.addInterceptor(cacheInterceptor);
        // 设置超时
        builder.connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS);
        // 错误重连
        builder.retryOnConnectionFailure(true);
        // 设置 cookie
        builder.cookieJar(new CookieJar() {
            private final PersistentCookieStore cookieStore = new PersistentCookieStore(application);
            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                if (cookies != null && cookies.size() > 0) {
                    for (Cookie item : cookies) {
                        cookieStore.add(url, item);
                    }
                }
            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                return cookieStore.get(url);
            }
        });
        return builder.build();
    }

    /**
     * 提供 网络请求
     * @param gson gson
     * @param okHttpClient okHttpClient
     * @return NetService
     */


    @Provides
    @Singleton
    Api providerNetService(Gson gson, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
        return retrofit.create(Api.class);
    }

//    @Provides
//    @Singleton
//    RealmService providerRealmService() {
//        return new RealmService();
//    }



}
