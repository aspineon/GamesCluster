package com.wawa_applications.gamescluster.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wawa_applications.gamescluster.R;
import com.wawa_applications.gamescluster.model.details.GameDetailsResultModel;
import com.wawa_applications.gamescluster.model.youtube.YoutubeVideoItem;
import com.wawa_applications.gamescluster.network.GiantBombService;

import java.util.List;


/**
 * Created by Wojtek on 2017-10-05.
 */

public class YoutubeVideoAdapter extends RecyclerView.Adapter<YoutubeVideoAdapter.YoutubeVideoHolder> {

    private List<YoutubeVideoItem> youtubeVideoItemList;
    private Context context;

    public YoutubeVideoAdapter(Context context, List<YoutubeVideoItem> youtubeVideoItemList) {
        this.context = context;
        this.youtubeVideoItemList = youtubeVideoItemList;
    }

    @Override
    public YoutubeVideoAdapter.YoutubeVideoHolder onCreateViewHolder(ViewGroup parent, int type) {

        View singleCard = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.youtube_video_card, parent, false);
        YoutubeVideoAdapter.YoutubeVideoHolder holder = new YoutubeVideoAdapter.YoutubeVideoHolder(singleCard);
        return holder;
    }

    @Override
    public void onBindViewHolder(YoutubeVideoAdapter.YoutubeVideoHolder holder, int position) {
        String videoTitle = youtubeVideoItemList.get(position).getYoutubeVideoSnippet().getYoutubeVideoTitle();
        String imageUrl = youtubeVideoItemList.get(position).getYoutubeVideoSnippet().getYoutubeVideoThumbnails().getYoutubeVideoMediumThumbnail().getYoutubeVideoMediumThumbnailUrl();

        holder.getVideoTitle().setText(videoTitle);

        Glide.with(context)
                .load(imageUrl)
                .fitCenter()
                .crossFade()
                .into(holder.getVideoImage());
    }

    @Override
    public int getItemCount() {
        return youtubeVideoItemList.size();
    }


    public class YoutubeVideoHolder extends RecyclerView.ViewHolder {

        private ImageView videoImage;
        private TextView videoTitle;

        public YoutubeVideoHolder(final View rowView) {
            super(rowView);

            videoImage = rowView.findViewById(R.id.video_image);
            videoTitle = rowView.findViewById(R.id.video_title);

            rowView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    startPlayingYoutubeVideo(position);
                }
            });
        }

        public ImageView getVideoImage() {
            return videoImage;
        }

        public TextView getVideoTitle() {
            return videoTitle;
        }

        private void startPlayingYoutubeVideo(int position) {

            String youtubeVideoId =  youtubeVideoItemList.get(position).getYoutubeVideoId().getYoutubeVideoId();
            Intent intent = YouTubeStandalonePlayer.createVideoIntent(
                    (Activity) context,
                    context.getString(R.string.youtube_key),
                    youtubeVideoId);
            context.startActivity(intent);

        }



    }
}
