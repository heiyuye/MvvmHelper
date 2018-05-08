package com.kuluo.mvvmhelper.event;

import android.arch.lifecycle.MutableLiveData;

/**
 * Created by liucr on 2018/4/25.
 */
public class DialogData {

    public final SingleLiveEvent<Void> show = new SingleLiveEvent<>();

    public final SingleLiveEvent<Void> dismiss = new SingleLiveEvent<>();

    public final MutableLiveData<String> content = new MutableLiveData<>();

    public final MutableLiveData<Integer> contentRes = new MutableLiveData<>();

    public DialogData dismiss() {
        dismiss.call();
        return this;
    }

    public DialogData show() {
        show.call();
        return this;
    }

}
