package com.liucr.mvvmhelperdemo.http;

import com.liucr.mvvmhelper.http.HttpManager;
import com.liucr.mvvmhelperdemo.http.api.ApiConstant;
import com.liucr.mvvmhelperdemo.http.api.DouBanApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by liucr on 2018/4/25.
 */
public class DouBanHttpManager extends HttpManager {

    private DouBanApi mDouBanApi;
    private OkHttpClient mDouBanHttpClient;

    private static class LazyHolder {
        private static final DouBanHttpManager INSTANCE = new DouBanHttpManager();
    }

    public static DouBanHttpManager getInstance() {
        return DouBanHttpManager.LazyHolder.INSTANCE;
    }

    private DouBanHttpManager() {
        initDouBanApi();
    }

    private void initDouBanApi() {
        mDouBanHttpClient = new OkHttpClient.Builder()
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .writeTimeout(10000, TimeUnit.MILLISECONDS)
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        mDouBanApi = createService(DouBanApi.class, ApiConstant.BASE_URL, mDouBanHttpClient);
    }

    public static DouBanApi getDouBanApi() {
        return DouBanHttpManager.getInstance().mDouBanApi;
    }

}
