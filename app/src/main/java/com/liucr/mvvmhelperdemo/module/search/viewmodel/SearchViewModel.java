package com.liucr.mvvmhelperdemo.module.search.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.util.Log;

import com.liucr.bindinglibrary.view.smartrefreshlayout.LoadMoreState;
import com.liucr.bindinglibrary.view.smartrefreshlayout.RefreshState;
import com.liucr.mvvmhelperdemo.module.RecyclerViewModel;
import com.liucr.mvvmhelper.event.DialogData;
import com.liucr.mvvmhelperdemo.BR;
import com.liucr.mvvmhelperdemo.R;
import com.liucr.mvvmhelperdemo.mode.Book;
import com.liucr.mvvmhelperdemo.mode.BookListResult;
import com.liucr.mvvmhelperdemo.module.search.model.SearchModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import io.reactivex.functions.Consumer;

/**
 * 搜索页面
 * Created by liucr on 2018/4/25.
 */
public class SearchViewModel extends RecyclerViewModel implements OnRefreshListener, OnLoadMoreListener {

    private ObservableList<Book> dataList = new ObservableArrayList<>();
    public final MutableLiveData<String> mKeyword = new MutableLiveData<>();
    public final DialogData mDialogData = new DialogData();
    public final MutableLiveData<Integer> refreshState = new MutableLiveData<>();
    public final MutableLiveData<Integer> loadMoreState = new MutableLiveData<>();

    private SearchModel mSearchModel;

    public SearchViewModel(@NonNull Application application) {
        super(application);
        mSearchModel = new SearchModel(mBookListResultConsumer, mThrowableConsumer);
    }

    @Override
    public void initRecyclerView() {
        itemBinding.map(Book.class, BR.book, R.layout.item_book);
        items.insertList(dataList);
        mItemChildClickIds.add(R.id.book_name);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mSearchModel.destroy();
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        mSearchModel.loadMore();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mSearchModel
                .setStart(1)
                .search();
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
                .search();
    }

    /**
     * 搜索成功结果
     */
    private final Consumer<BookListResult> mBookListResultConsumer = new Consumer<BookListResult>() {
        @Override
        public void accept(BookListResult bookListResult) {
            mDialogData.dismiss();

            if (bookListResult.getStart() == 1) {
                dataList.clear();
                refreshState.setValue(RefreshState.REFRESH_SUCCESS);
            } else {
                loadMoreState.setValue(LoadMoreState.LOAD_MORE_COMPLETE);
            }

            dataList.addAll(bookListResult.getBooks());
            mSearchModel.setStart(bookListResult.getStart() + bookListResult.getCount());
        }
    };

    /**
     * 搜索异常
     */
    private final Consumer<Throwable> mThrowableConsumer = new Consumer<Throwable>() {
        @Override
        public void accept(Throwable throwable) {
            mDialogData.dismiss();
            if (mSearchModel.getStart() == 1) {
                refreshState.setValue(RefreshState.REFRESH_FAIL);
            } else {
                loadMoreState.setValue(LoadMoreState.LOAD_MORE_FAIL);
            }
        }
    };

    @Override
    public void onItemClick(int position) {
        Log.e("liucr", "onItemClick  " + position);
    }

    @Override
    public void onItemChildClick(int position, int viewId) {
        Log.e("liucr", "onItemChildClick  " + position);
    }

}
