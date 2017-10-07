package com.wawa_applications.gamescluster.model.youtube;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Wojtek on 2017-10-05.
 */

public class YoutubeVideoItem implements Serializable {

    @SerializedName("id")
    @Expose
    private YoutubeVideoId youtubeVideoId;

    @SerializedName("snippet")
    @Expose
    private YoutubeVideoSnippet youtubeVideoSnippet;

    public YoutubeVideoId getYoutubeVideoId() {
        return youtubeVideoId;
    }

    public void setYoutubeVideoId(YoutubeVideoId youtubeVideoId) {
        this.youtubeVideoId = youtubeVideoId;
    }

    public YoutubeVideoSnippet getYoutubeVideoSnippet() {
        return youtubeVideoSnippet;
    }

    public void setYoutubeVideoSnippet(YoutubeVideoSnippet youtubeVideoSnippet) {
        this.youtubeVideoSnippet = youtubeVideoSnippet;
    }
}
