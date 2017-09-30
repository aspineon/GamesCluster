package com.wawa_applications.gamescluster.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Wojtek Krzywiec on 22/08/2017.
 */

public class GameImageModel implements Serializable {

    @SerializedName("small_url")
    @Expose
    private String smallUrl;

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }
}
