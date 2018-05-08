package com.kuluo.mvvmhelper.http;

import com.kuluo.mvvmhelper.http.gson.GsonUtil;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liucr on 2018/4/24.
 */

public abstract class HttpManager {

    protected <T> T createService(final Class<T> service, String baseUrl, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//用于返回Rxjava调用,非必须
                .addConverterFactory(GsonConverterFactory.create(GsonUtil.getInstance()))
                .client(okHttpClient)
                .build()
                .create(service);
    }
}
