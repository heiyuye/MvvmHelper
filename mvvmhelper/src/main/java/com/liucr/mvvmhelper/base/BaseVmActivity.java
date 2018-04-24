package com.liucr.mvvmhelper.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.liucr.rapiddevelopmenthelper.R;

public abstract class BaseVmActivity<VB extends ViewDataBinding> extends BaseActivity {

    // 视图绑定对象
    protected VB viewDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 得到DataBinding
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        setupToolbar();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initViewModel();

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
