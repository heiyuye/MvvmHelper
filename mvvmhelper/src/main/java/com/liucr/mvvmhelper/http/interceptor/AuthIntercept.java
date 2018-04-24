package com.liucr.mvvmhelper.http.interceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by liucr on 2018/4/24.
 */

public class AuthIntercept implements Interceptor {

    private AuthProvider mAuthProvider;

    public AuthIntercept(AuthProvider authProvider) {
        this.mAuthProvider = authProvider;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        // ok http请求
        Request okHttpRequest = chain.request();

        // 通过接口得到AccessToken，并为每个请求添加请求头
        Request.Builder newBuilder = okHttpRequest.newBuilder();
        HashMap<String, String> authHeader = mAuthProvider.getAuthHeader();
        for (HashMap.Entry<String, String> entry : authHeader.entrySet()) {
            newBuilder.addHeader(entry.getKey(), entry.getValue());
        }
        Request tryRequest = newBuilder.build();

        // 发出ok http请求
        okhttp3.Response response = chain.proceed(tryRequest);

        return null;
    }

}
