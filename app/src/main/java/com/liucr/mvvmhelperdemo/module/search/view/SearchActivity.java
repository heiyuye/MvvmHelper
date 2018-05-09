package com.liucr.mvvmhelperdemo.module.search.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.liucr.mvvmhelper.base.BaseVmActivity;
import com.liucr.mvvmhelperdemo.R;
import com.liucr.mvvmhelperdemo.databinding.ActivitySearchBinding;
import com.liucr.mvvmhelperdemo.module.search.viewmodel.SearchViewModel;

/**
 * Created by liucr on 2018/4/25.
 */
public class SearchActivity extends BaseVmActivity {

    private ActivitySearchBinding viewDataBinding;
    private SearchViewModel searchViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        viewDataBinding.setLifecycleOwner(this);

        initViewModel();
        initView();
        getProgressDialog().setMessage("loading...");
        setProgressDialogData(searchViewModel.mDialogData);
        setSupportActionBar(viewDataBinding.tbSearch);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getLifecycle().removeObserver(searchViewModel);
    }

    public void initViewModel() {
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        getLifecycle().addObserver(searchViewModel);
        viewDataBinding.setSearchViewModel(searchViewModel);
    }

    public void initView() {

    }

}
