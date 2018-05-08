package com.kuluo.mvvmhelper.view.recyclerview.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kuluo.mvvmhelper.view.recyclerview.listener.OnItemChildClickListener;
import com.kuluo.mvvmhelper.view.recyclerview.listener.OnItemChildLongClickListener;
import com.kuluo.mvvmhelper.view.recyclerview.listener.OnItemClickListener;
import com.kuluo.mvvmhelper.view.recyclerview.listener.OnItemLongClickListener;

import java.util.List;

/**
 * Created by liucr on 2018/5/7.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    /**
     * 子View点击事件
     */
    private OnItemChildClickListener mOnItemChildClickListener;

    /**
     * 子View长按事件
     */
    private OnItemChildLongClickListener mOnItemChildLongClickListener;

    /**
     * RecyclerView Item点击事件
     */
    private OnItemClickListener mOnItemClickListener;

    /**
     * RecyclerView Item点击事件
     */
    private OnItemLongClickListener mOnItemLongClickListener;

    /**
     * 子View点击事件Id
     */
    private List<Integer> mOnClickChildIdList;
    /**
     * 子View长按事件Id
     */
    private List<Integer> mOnLongClickChildIdList;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public void build() {
        initItemClick();
        initItemChildClick();
    }

    /**
     * 初始化RecyclerView Item各种点击事件
     */
    private void initItemClick() {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener(getAdapterPosition());
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemLongClickListener(getAdapterPosition());
                return true;
            }
        });
    }

    /**
     * 初始化Child View 各种点击事件
     */
    private void initItemChildClick() {
        if (mOnClickChildIdList != null && mOnClickChildIdList.size() > 0) {
            for (Integer id : mOnClickChildIdList) {
                checkViewExisted(id).setOnClickListener(this);
            }
        }

        if (mOnLongClickChildIdList != null && mOnLongClickChildIdList.size() > 0) {
            for (Integer id : mOnLongClickChildIdList) {
                checkViewExisted(id).setOnLongClickListener(this);
            }
        }
    }

    private View checkViewExisted(int id) {
        View view = itemView.findViewById(id);
        if (view == null) {
            throw new IllegalArgumentException("can not find view(id: " + id + ")");
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        onItemChildClickListener(v.getId(), getAdapterPosition());
    }

    @Override
    public boolean onLongClick(View v) {
        onItemChildLongClickListener(v.getId(), getAdapterPosition());
        return true;
    }

    public void setOnClickChildIdList(List<Integer> onClickChildIdList) {
        mOnClickChildIdList = onClickChildIdList;
    }

    public void setOnLongClickChildIdList(List<Integer> onLongClickChildIdList) {
        mOnLongClickChildIdList = onLongClickChildIdList;
    }

    private void onItemChildClickListener(int viewId, int position) {
        if (mOnItemChildClickListener != null) {
            mOnItemChildClickListener.onItemChildClick(position, viewId);
        }
    }

    private void onItemClickListener(int position) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(position);
        }
    }

    private void onItemChildLongClickListener(int viewId, int position) {
        if (mOnItemChildLongClickListener != null) {
            mOnItemChildLongClickListener.onItemChildLongClick(position, viewId);
        }
    }

    private void onItemLongClickListener(int position) {
        if (mOnItemLongClickListener != null) {
            mOnItemLongClickListener.onItemLongClick(position);
        }
    }

    public void setOnItemChildClickListener(OnItemChildClickListener onItemChildClickListener) {
        mOnItemChildClickListener = onItemChildClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public OnItemChildLongClickListener getOnItemChildLongClickListener() {
        return mOnItemChildLongClickListener;
    }

    public void setOnItemChildLongClickListener(OnItemChildLongClickListener onItemChildLongClickListener) {
        mOnItemChildLongClickListener = onItemChildLongClickListener;
    }

    public OnItemLongClickListener getOnItemLongClickListener() {
        return mOnItemLongClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        mOnItemLongClickListener = onItemLongClickListener;
    }
}
