package com.wawa_applications.gamescluster.model.youtube;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Wojtek on 2017-10-05.
 */

public class YoutubeVideoSnippet implements Serializable {

    @SerializedName("title")
    @Expose
    private String youtubeVideoTitle;

    @SerializedName("thumbnails")
    @Expose
    private YoutubeVideoThumbnails youtubeVideoThumbnails;


    public String getYoutubeVideoTitle() {
        return youtubeVideoTitle;
    }

    public void setYoutubeVideoTitle(String youtubeVideoTitle) {
        this.youtubeVideoTitle = youtubeVideoTitle;
    }

    public YoutubeVideoThumbnails getYoutubeVideoThumbnails() {
        return youtubeVideoThumbnails;
    }

    public void setYoutubeVideoThumbnails(YoutubeVideoThumbnails youtubeVideoThumbnails) {
        this.youtubeVideoThumbnails = youtubeVideoThumbnails;
    }
}
