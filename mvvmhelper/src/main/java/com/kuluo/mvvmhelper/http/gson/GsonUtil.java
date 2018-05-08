package com.kuluo.mvvmhelper.http.gson;

import com.google.gson.Gson;

/**
 * Created by liucr on 2018/4/24.
 */

public class GsonUtil {

    private static class LazyHolder {
        private static final Gson INSTANCE = new Gson();
    }

    public static Gson getInstance() {
        return LazyHolder.INSTANCE;
    }

}
