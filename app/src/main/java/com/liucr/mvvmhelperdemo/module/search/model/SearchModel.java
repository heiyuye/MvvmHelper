package com.liucr.mvvmhelperdemo.module.search.model;

import android.support.annotation.NonNull;

import com.liucr.mvvmhelperdemo.http.DouBanHttpManager;
import com.liucr.mvvmhelperdemo.mode.BookListResult;
import com.liucr.mvvmhelperdemo.module.common.model.BaseModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by liucr on 2018/4/25.
 */
public class SearchModel implements BaseModel {

    /**
     * 搜索关键字
     */
    private String mKeyword;

    /**
     * 搜索标签
     */
    private String mTag;

    /**
     * 开始条目
     */
    private int mStart = 1;

    /**
     * 条目数量
     */
    private int mCount = 10;

    /**
     * 搜索成功消费者
     */
    private Consumer<BookListResult> mSearchSuccessConsumer;

    /**
     * 搜索失败消费者
     */
    private Consumer<Throwable> mSearchFailConsumer;

    private Disposable mDisposable;

    public SearchModel(@NonNull Consumer<BookListResult> searchSuccessConsumer, Consumer<Throwable> searchFailConsumer) {
        super();
        this.mSearchSuccessConsumer = searchSuccessConsumer;
        this.mSearchFailConsumer = searchFailConsumer;
    }

    public SearchModel setKeyword(String keyword) {
        this.mKeyword = keyword;
        return this;
    }

    public SearchModel setTag(String tag) {
        this.mTag = tag;
        return this;
    }

    public SearchModel setStart(int start) {
        this.mStart = start;
        return this;
    }

    public int getStart() {
        return mStart;
    }

    public SearchModel setCount(int count) {
        this.mCount = count;
        return this;
    }

    public void search() {
        if (mDisposable != null) {
            mDisposable.dispose();
        }
        mDisposable = DouBanHttpManager.getDouBanApi().searchBook(mKeyword, mTag, mStart, mCount)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mSearchSuccessConsumer, mSearchFailConsumer);
    }

    public void loadMore() {
        if (!mDisposable.isDisposed()) {
            return;
        }
        search();
    }


    @Override
    public void destroy() {
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }

}
