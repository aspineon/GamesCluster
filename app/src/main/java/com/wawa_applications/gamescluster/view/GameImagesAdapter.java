package com.wawa_applications.gamescluster.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wawa_applications.gamescluster.R;

import java.util.List;


/**
 * Created by Wojtek on 2017-09-29.
 */

public class GameImagesAdapter extends RecyclerView.Adapter<GameImagesAdapter.GameImagesHolder> {

    private List<String> mGameImages;
    Context context;


    public GameImagesAdapter(Context context, List<String> gameImages) {
        this.mGameImages = gameImages;
        this.context = context;
    }

    @Override
    public GameImagesAdapter.GameImagesHolder onCreateViewHolder(ViewGroup parent, int type) {

        View singleCard = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_layout, parent, false);
        GameImagesAdapter.GameImagesHolder holder = new GameImagesAdapter.GameImagesHolder(singleCard);
        return holder;
    }

    @Override
    public void onBindViewHolder(GameImagesAdapter.GameImagesHolder holder, int position) {
        String imageUrl = mGameImages.get(position);

        Glide.with(context)
                .load(imageUrl)
                .fitCenter()
                .crossFade()
                .placeholder(R.drawable.ic_action_name)
                .into(holder.gameImage);
    }

    @Override
    public int getItemCount() {
        return mGameImages.size();
    }


    public class GameImagesHolder extends RecyclerView.ViewHolder {

        private ImageView gameImage;

        public GameImagesHolder(View rowView) {
            super(rowView);

            gameImage = rowView.findViewById(R.id.single_image);

            rowView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                }
            });
        }

        public ImageView getGameImage() {
            return gameImage;
        }
    }
}
