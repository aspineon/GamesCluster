package com.wawa_applications.gamescluster.utilis;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Wojtek on 2017-09-13.
 */

public class CustomBindingAdapter {

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {

        Glide.with(view.getContext())
                .load(imageUrl)
                .fitCenter()
                .crossFade()
                .into(view);

    }
}
