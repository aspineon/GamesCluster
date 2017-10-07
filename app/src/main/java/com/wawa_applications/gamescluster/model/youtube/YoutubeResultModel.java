package com.wawa_applications.gamescluster.model.youtube;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Wojtek on 2017-10-05.
 */

public class YoutubeResultModel implements Serializable {

    @SerializedName("items")
    @Expose
    private List<YoutubeVideoItem> youtubeVideoItems;

    public List<YoutubeVideoItem> getYoutubeVideoItems() {
        return youtubeVideoItems;
    }

    public void setYoutubeVideoItems(List<YoutubeVideoItem> youtubeVideoItems) {
        this.youtubeVideoItems = youtubeVideoItems;
    }
}
