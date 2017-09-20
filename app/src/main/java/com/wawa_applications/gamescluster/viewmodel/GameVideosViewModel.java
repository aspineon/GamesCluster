package com.wawa_applications.gamescluster.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Wojtek on 2017-09-19.
 */

public class GameVideosViewModel extends BaseObservable {

    private String gameName;
    private Context context;


    public GameVideosViewModel (@NotNull Context context, @NotNull String gameName){

        this.context = context;
        this.gameName = gameName;
    }
}
