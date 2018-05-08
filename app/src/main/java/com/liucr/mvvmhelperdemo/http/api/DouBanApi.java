package com.liucr.mvvmhelperdemo.http.api;

import android.support.annotation.Nullable;

import com.liucr.mvvmhelperdemo.mode.Book;
import com.liucr.mvvmhelperdemo.mode.BookListResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by liucr on 2018/4/25.
 */
public interface DouBanApi {

    @GET("/v2/book/search")
    Observable<BookListResult> searchBook(@Query("q") @Nullable String keyword, @Query("tag") @Nullable String tag,
                                          @Query("start") int start, @Query("count") int count);

    @GET("https://api.douban.com/v2/book/:id")
    Observable<Book> getBookById(@Path(":id") String id);
}
