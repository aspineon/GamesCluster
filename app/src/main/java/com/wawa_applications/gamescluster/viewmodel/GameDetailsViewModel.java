package com.wawa_applications.gamescluster.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;

import com.wawa_applications.gamescluster.R;
import com.wawa_applications.gamescluster.model.details.GameDetailsModel;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Wojtek on 2017-09-19.
 */

public class GameDetailsViewModel extends BaseObservable {

    private String gameFullId;
    private Context context;
    private GameDetailsModel gameDetailsModel;


    public GameDetailsViewModel(@NotNull Context context, @NotNull String gameId){

        this.context = context;
        gameFullId = context.getString(R.string.key_game_name) + gameId;

    }

    public GameDetailsModel getGameDetailsModel() {
        return gameDetailsModel;
    }
}
