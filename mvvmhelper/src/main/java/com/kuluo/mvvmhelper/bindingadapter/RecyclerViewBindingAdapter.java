package com.kuluo.mvvmhelper.bindingadapter;

import android.databinding.BindingAdapter;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.kuluo.mvvmhelper.view.recyclerview.listener.OnItemChildClickListener;
import com.kuluo.mvvmhelper.view.recyclerview.listener.OnItemChildLongClickListener;
import com.kuluo.mvvmhelper.view.recyclerview.listener.OnItemClickListener;
import com.kuluo.mvvmhelper.view.recyclerview.listener.OnItemLongClickListener;
import com.kuluo.mvvmhelper.view.recyclerview.viewholder.BaseViewHolder;

import java.util.List;

import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * @author liucr on 2017/5/13.
 */

public class RecyclerViewBindingAdapter {

    // RecyclerView
    @SuppressWarnings("unchecked")
    @BindingAdapter(value = {"itemBinding", "items",
            "onItemChildClickListener", "itemChildClickIds",
            "onItemChildLongClickListener", "itemChildLongClickIds",
            "onItemClickListener", "onItemLongClickListener"},
            requireAll = false)
    public static <T> void setAdapter(RecyclerView recyclerView,
                                      ItemBinding<T> itemBinding,
                                      List<T> items,
                                      final OnItemChildClickListener onItemChildClickListener, final List<Integer> itemChildClickIds,
                                      final OnItemChildLongClickListener onItemChildLongClickListener, final List<Integer> itemChildLongClickIds,
                                      final OnItemClickListener onItemClickListener, final OnItemLongClickListener onItemLongClickListener) {
        if (itemBinding == null) {
            throw new IllegalArgumentException("itemBinding must not be null");
        }

        BindingRecyclerViewAdapter adapter = (BindingRecyclerViewAdapter) recyclerView.getAdapter();

        if (adapter == null) {
            adapter = new BindingRecyclerViewAdapter<>();
            recyclerView.setAdapter(adapter);
        }
        adapter.setItemBinding(itemBinding);
        adapter.setItems(items);
        adapter.setViewHolderFactory(new BindingRecyclerViewAdapter.ViewHolderFactory() {
            @Override
            public RecyclerView.ViewHolder createViewHolder(ViewDataBinding binding) {

                BaseViewHolder baseViewHolder = new BaseViewHolder(binding.getRoot());

                baseViewHolder.setOnItemClickListener(onItemClickListener);
                baseViewHolder.setOnItemLongClickListener(onItemLongClickListener);
                baseViewHolder.setOnItemChildClickListener(onItemChildClickListener);
                baseViewHolder.setOnItemChildLongClickListener(onItemChildLongClickListener);

                baseViewHolder.setOnLongClickChildIdList(itemChildLongClickIds);
                baseViewHolder.setOnClickChildIdList(itemChildClickIds);
                baseViewHolder.build();
                return baseViewHolder;
            }
        });
    }

    @BindingAdapter(value = {"animator"})
    public static void setItemDecoration(RecyclerView recyclerView, RecyclerView.ItemAnimator animator) {
        recyclerView.setItemAnimator(animator);
    }

    @BindingAdapter(value = {"itemDecoration"})
    public static void addItemDecoration(RecyclerView recyclerView, RecyclerView.ItemDecoration itemDecoration) {
        recyclerView.addItemDecoration(itemDecoration);
    }

    @BindingAdapter(value = "focusable")
    public static void setFocusable(RecyclerView recyclerView, boolean focusable) {
        recyclerView.setFocusable(focusable);
    }
}
