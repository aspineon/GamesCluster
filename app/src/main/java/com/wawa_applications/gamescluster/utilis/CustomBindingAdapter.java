package com.wawa_applications.gamescluster.utilis;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wawa_applications.gamescluster.R;
import com.wawa_applications.gamescluster.model.details.GameConcept;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

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

    @BindingAdapter({"bind:openUrl"})
    public static void openUrl(Button view, String Url) {

        final Button button = view;
        final String webUrl = Url;
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(webUrl));
                button.getContext().startActivity(implicit);
            }
        });
    }

}

