package com.wawa_applications.gamescluster.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Wojtek on 2017-09-15.
 */

public class GameDetailsResultModel {

    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("results")
    @Expose
    private GameDetailsModel gameDetailsModel;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public GameDetailsModel getGameDetailsModel() {
        return gameDetailsModel;
    }

    public void setGameDetailsModel(GameDetailsModel gameDetailsModel) {
        this.gameDetailsModel = gameDetailsModel;
    }
}
