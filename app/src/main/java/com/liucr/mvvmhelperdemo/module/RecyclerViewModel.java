package com.liucr.mvvmhelperdemo.module;

import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.NonNull;

import com.liucr.bindinglibrary.recyclerview.listener.OnItemChildClickListener;
import com.liucr.bindinglibrary.recyclerview.listener.OnItemChildLongClickListener;
import com.liucr.bindinglibrary.recyclerview.listener.OnItemClickListener;
import com.liucr.bindinglibrary.recyclerview.listener.OnItemLongClickListener;
import com.liucr.mvvmhelper.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import me.tatarka.bindingcollectionadapter2.collections.MergeObservableList;
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass;

/**
 * Created by liucr on 2018/5/7.
 */
public abstract class RecyclerViewModel extends BaseViewModel implements OnItemClickListener, OnItemChildClickListener, OnItemLongClickListener, OnItemChildLongClickListener {

    public final MergeObservableList<Object> items = new MergeObservableList<>();
    public final OnItemBindClass<Object> itemBinding = new OnItemBindClass<>();

    public final List<Integer> mItemChildClickIds = new ArrayList<>();
    public final List<Integer> mItemChildLongClickIds = new ArrayList<>();

    public RecyclerViewModel(@NonNull Application application) {
        super(application);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        initRecyclerView();
    }

    public abstract void initRecyclerView();

    @Override
    public void onItemChildClick(int position, int viewId) {

    }

    @Override
    public void onItemChildLongClick(int Position, int viewId) {

    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onItemLongClick(int position) {

    }
}
