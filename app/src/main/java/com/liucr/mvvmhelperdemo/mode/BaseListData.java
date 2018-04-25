package com.liucr.mvvmhelperdemo.mode;

import com.google.gson.annotations.SerializedName;

/**
 * Created by liucr on 2018/4/25.
 */
public class BaseListData {
    /**
     * start : 0
     * count : 10
     * total : 30
     */

    @SerializedName("start")
    private int start;
    @SerializedName("count")
    private int count;
    @SerializedName("total")
    private int total;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
