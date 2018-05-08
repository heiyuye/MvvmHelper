package com.kuluo.mvvmhelper.base;

import android.app.ProgressDialog;
import android.arch.lifecycle.LifecycleOwner;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kuluo.mvvmhelper.utils.StatusBarCompat;

/**
 * @author liucr on 2018/3/26/026.
 */

public class BaseActivity extends AppCompatActivity implements LifecycleOwner {

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (StatusBarCompat.isMiui()) {
                StatusBarCompat.setMiuiStatusBarTextColor(this.getWindow(), !isDarkMode());
            }

            if (StatusBarCompat.isFlyme()) {
                StatusBarCompat.setFlymeStatusBarTextColor(this.getWindow(), !isDarkMode());
            }
        }
        super.onStart();
    }

    /**
     * 状态栏文字颜色
     *
     * @return true is dark mode
     */
    protected boolean isDarkMode() {
        return false;
    }

    public ProgressDialog getProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
        return progressDialog;
    }
}
