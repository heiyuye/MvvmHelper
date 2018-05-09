package com.liucr.mvvmhelper.base;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.liucr.mvvmhelper.event.DialogData;

public abstract class BaseVmActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setProgressDialogData(DialogData dialogData) {
        dialogData.dismiss.observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                getProgressDialog().dismiss();
            }
        });

        dialogData.show.observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                getProgressDialog().show();
            }
        });

        dialogData.contentRes.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                if (integer != null) {
                    getProgressDialog().setMessage(getString(integer));
                } else {
                    getProgressDialog().setMessage(null);
                }
            }
        });
    }

}
