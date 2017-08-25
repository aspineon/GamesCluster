package com.wawa_applications.gamescluster.viewmodel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.wawa_applications.gamescluster.model.search.GamePlatformModel;
import com.wawa_applications.gamescluster.model.search.GameResultModel;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Wojtek Krzywiec on 25/08/2017.
 */

public class GameCardViewModel {

    private Context context;
    private GameResultModel gameResult;


    public GameCardViewModel (Context context, GameResultModel gameResult){

        this.context = context;
        this.gameResult = gameResult;

    }


    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        /*
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.placeholder)
                .into(view);

//albo Glide

        Glide.with(view.getContext()).load(imageUrl).into(view);*/
    }


    public String getImageUrl() {
        return gameResult.getImage().getSmallUrl();
    }


    public String getFullTitle(){

        String releaseYear = "N/A";

        if(gameResult.getExpectedReleaseYear() != null) releaseYear = String.valueOf(gameResult.getExpectedReleaseYear());

        if(gameResult.getOriginalReleaseDate() != null) releaseYear = String.valueOf(gameResult.getOriginalReleaseDate().get(Calendar.YEAR));

        return gameResult.getName() + " (" + releaseYear + ")";

    }


    public String getGamePlatforms(){

        String platformString = "";

        List<GamePlatformModel> platformsList = gameResult.getPlatforms();

        for ( GamePlatformModel platform : platformsList) {

            platformString = platformString.concat(", " + platform);

        }

        return platformString;
    }
}
