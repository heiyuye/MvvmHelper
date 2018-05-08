package com.kuluo.mvvmhelper.bindingadapter;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ImageViewBindingAdapter {

    @BindingAdapter("image")
    public static void imageLoader(ImageView imageView, Object image) {
        imageLoader(imageView, image, new RequestOptions().centerInside());
    }

    @BindingAdapter(value = {"image", "requestOptions"})
    public static void imageLoader(ImageView imageView, Object image, RequestOptions requestOptions) {
        Glide.with(imageView.getContext())
                .load(image)
                .apply(requestOptions)
                .into(imageView);
    }
}
