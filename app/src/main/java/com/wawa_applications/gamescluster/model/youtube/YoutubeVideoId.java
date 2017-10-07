package com.wawa_applications.gamescluster.model.youtube;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Wojtek on 2017-10-05.
 */

public class YoutubeVideoId implements Serializable {

    @SerializedName("videoId")
    @Expose
    private String youtubeVideoId;

    public String getYoutubeVideoId() {
        return youtubeVideoId;
    }

    public void setYoutubeVideoId(String youtubeVideoId) {
        this.youtubeVideoId = youtubeVideoId;
    }
}
