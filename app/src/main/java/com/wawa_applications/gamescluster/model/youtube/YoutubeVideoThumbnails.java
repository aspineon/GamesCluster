package com.wawa_applications.gamescluster.model.youtube;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Wojtek on 2017-10-05.
 */

public class YoutubeVideoThumbnails implements Serializable {

    @SerializedName("medium")
    @Expose
    private YoutubeMediumVideoThumbnail youtubeVideoMediumThumbnail;


    public YoutubeMediumVideoThumbnail getYoutubeVideoMediumThumbnail() {
        return youtubeVideoMediumThumbnail;
    }

    public void setYoutubeVideoMediumThumbnail(YoutubeMediumVideoThumbnail youtubeVideoMediumThumbnail) {
        this.youtubeVideoMediumThumbnail = youtubeVideoMediumThumbnail;
    }
}
