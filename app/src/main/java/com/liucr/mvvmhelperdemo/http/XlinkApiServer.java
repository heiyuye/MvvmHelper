package com.liucr.mvvmhelperdemo.http;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by liucr on 2018/4/24.
 */

public interface XlinkApiServer {

    @POST("v2/user_auth")
    Observable<UserAuth> login(@Field("phone") HashMap body);

    @POST("v2/user_auth")
    Observable<HashMap> refreshToken();

    @GET("v2/user/{user_id}?filter=setting")
    Observable<User> getUser(@Path("user_id") String user_id);

}
