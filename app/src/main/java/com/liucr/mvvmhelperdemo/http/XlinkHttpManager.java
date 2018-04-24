package com.liucr.mvvmhelperdemo.http;

import com.liucr.mvvmhelper.http.HttpManager;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by liucr on 2018/4/24.
 */

public class XlinkHttpManager extends HttpManager {

    private XlinkApiServer mXlinkApiServer;
    private OkHttpClient mXlinkOkHttpClient;

    private static class LazyHolder {
        private static final XlinkHttpManager INSTANCE = new XlinkHttpManager();
    }

    public static XlinkHttpManager getInstance() {
        return XlinkHttpManager.LazyHolder.INSTANCE;
    }

    public XlinkHttpManager(){
        initXlinkApiServer();
    }

    protected void initXlinkApiServer() {
        mXlinkOkHttpClient = new OkHttpClient.Builder()
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .writeTimeout(10000, TimeUnit.MILLISECONDS)
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        mXlinkApiServer = createService(XlinkApiServer.class, "url", mXlinkOkHttpClient);
    }

    public static XlinkApiServer getXlinkApiServer() {
        return XlinkHttpManager.getInstance().mXlinkApiServer;
    }
}
