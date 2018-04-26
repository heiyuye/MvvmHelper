package com.liucr.mvvmhelperdemo.module.search.viewmodel;

import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.liucr.mvvmhelper.base.BaseViewModel;
import com.liucr.mvvmhelper.bindingadapter.ImageViewBindingAdapter;
import com.liucr.mvvmhelper.event.DialogData;
import com.liucr.mvvmhelper.event.SingleLiveEvent;
import com.liucr.mvvmhelper.utils.LogUtil;
import com.liucr.mvvmhelperdemo.BR;
import com.liucr.mvvmhelperdemo.R;
import com.liucr.mvvmhelperdemo.mode.Book;
import com.liucr.mvvmhelperdemo.mode.BookListResult;
import com.liucr.mvvmhelperdemo.module.search.model.SearchModel;

import io.reactivex.functions.Consumer;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.collections.MergeObservableList;
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass;

/**
 * 搜索页面
 * Created by liucr on 2018/4/25.
 */
public class SearchViewModel extends BaseViewModel {

    public final MutableLiveData<String> mKeyword = new MutableLiveData<>();
    public final DialogData mDialogData = new DialogData();

    private SearchModel mSearchModel;

    private ObservableList<Book> books = new ObservableArrayList<>();
    public final MergeObservableList<Object> items = new MergeObservableList<>()
            .insertList(books);
    public final OnItemBindClass<Object> itemBinding = new OnItemBindClass()
            .map(Book.class, BR.book, R.layout.item_book);

    public SearchViewModel(@NonNull Application application) {
        super(application);
        mSearchModel = new SearchModel(mBookListResultConsumer, mThrowableConsumer);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        LogUtil.d("onCleared");
        mSearchModel.destroy();
    }

    /**
     * 根据关键字搜索
     *
     * @param keyword 关键字
     */
    public void searchByKey(String keyword) {

        mDialogData.show.call();
        mSearchModel.setKeyword(keyword)
                .setStart(1)
                .setCount(5)
                .search();
    }

    /**
     * 刷新
     */
    public void refresh() {
        mDialogData.show.call();
        mSearchModel
                .setStart(1)
                .setCount(5)
                .search();
    }

    /**
     * 加载更多
     */
    public void loadMore() {
        mSearchModel.loadMore();
    }

    /**
     * 搜索成功结果
     */
    private final Consumer<BookListResult> mBookListResultConsumer = new Consumer<BookListResult>() {
        @Override
        public void accept(BookListResult bookListResult) {
            mDialogData.dismiss.call();
            books.addAll(bookListResult.getBooks());
        }
    };

    /**
     * 搜索异常
     */
    private final Consumer<Throwable> mThrowableConsumer = new Consumer<Throwable>() {
        @Override
        public void accept(Throwable throwable) {
            mDialogData.dismiss.call();
        }
    };
}
