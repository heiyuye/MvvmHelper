package com.kuluo.mvvmhelper.http.interceptor;

import java.util.HashMap;

/**
 * Created by liucr on 2018/4/24.
 */

public class AuthProvider {

    protected HashMap<String, String> mAuthHeader = new HashMap<>();

    public HashMap<String, String> getAuthHeader() {
        return mAuthHeader;
    }

    public void putAuthHeader(String key, String value) {
        mAuthHeader.put(key, value);
    }
}
