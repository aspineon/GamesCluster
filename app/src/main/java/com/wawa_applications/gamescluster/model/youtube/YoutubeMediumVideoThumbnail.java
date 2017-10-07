package com.wawa_applications.gamescluster.model.youtube;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Wojtek on 2017-10-05.
 */

public class YoutubeMediumVideoThumbnail implements Serializable {

    @SerializedName("url")
    @Expose
    private String youtubeVideoMediumThumbnailUrl;

    public String getYoutubeVideoMediumThumbnailUrl() {
        return youtubeVideoMediumThumbnailUrl;
    }

    public void setYoutubeVideoMediumThumbnailUrl(String youtubeVideoMediumThumbnailUrl) {
        this.youtubeVideoMediumThumbnailUrl = youtubeVideoMediumThumbnailUrl;
    }
}
