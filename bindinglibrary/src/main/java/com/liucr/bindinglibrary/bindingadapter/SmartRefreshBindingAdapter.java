package com.liucr.bindinglibrary.bindingadapter;

import android.databinding.BindingAdapter;

import com.liucr.bindinglibrary.view.smartrefreshlayout.LoadMoreState;
import com.liucr.bindinglibrary.view.smartrefreshlayout.RefreshState;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * Created by liucr on 2018/5/9.
 */
public class SmartRefreshBindingAdapter {

    @BindingAdapter("refreshListener")
    public static void refreshListener(SmartRefreshLayout smartRefreshLayout, OnRefreshListener onRefreshListener) {
        smartRefreshLayout.setOnRefreshListener(onRefreshListener);
    }

    @BindingAdapter("loadMoreListener")
    public static void loadMoreListener(SmartRefreshLayout smartRefreshLayout, OnLoadMoreListener onLoadMoreListener) {
        smartRefreshLayout.setOnLoadMoreListener(onLoadMoreListener);
    }

    @BindingAdapter("refreshState")
    public static void refreshState(SmartRefreshLayout smartRefreshLayout, int refreshState) {
        switch (refreshState) {
            case RefreshState.REFRESH_TRIGGER:
                smartRefreshLayout.autoRefresh();
                break;
            case RefreshState.REFRESH_SUCCESS:
                smartRefreshLayout.finishRefresh(true);
                break;
            case RefreshState.REFRESH_FAIL:
                smartRefreshLayout.finishRefresh(false);
                break;
            default:
                break;
        }
    }

    @BindingAdapter("loadMoreState")
    public static void loadMoreState(SmartRefreshLayout smartRefreshLayout, int loadMoreState) {
        switch (loadMoreState) {
            case LoadMoreState.LOAD_MORE_COMPLETE:
                smartRefreshLayout.finishLoadMore(true);
                break;
            case LoadMoreState.LOAD_MORE_END:
                smartRefreshLayout.finishLoadMoreWithNoMoreData();
                break;
            case LoadMoreState.LOAD_MORE_FAIL:
                smartRefreshLayout.finishLoadMore(false);
                break;
            default:
                break;
        }
    }
}
