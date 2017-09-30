package com.wawa_applications.gamescluster.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Wojtek on 2017-09-15.
 */

public class GameScreenshots implements Serializable {

    @SerializedName("medium_url")
    @Expose
    private String mediumUrl;

    public String getMediumUrl() {
        return mediumUrl;
    }

    public void setMediumUrl(String smallUrl) {
        this.mediumUrl = smallUrl;
    }
}
