package com.wawa_applications.gamescluster.model;

import com.wawa_applications.gamescluster.model.details.GameDetailsResultModel;
import com.wawa_applications.gamescluster.model.youtube.YoutubeResultModel;

/**
 * Created by Wojtek on 2017-10-07.
 */

public class CombinedApiCalls {

    public CombinedApiCalls(GameDetailsResultModel detailsResultModel,
                            YoutubeResultModel youtubeResultModelTrailers,
                            YoutubeResultModel youtubeResultModelReviews,
                            YoutubeResultModel youtubeResultModelGameplays){

        this.detailsResultModel = detailsResultModel;
        this.youtubeResultModelTrailers = youtubeResultModelTrailers;
        this.youtubeResultModelReviews = youtubeResultModelReviews;
        this.youtubeResultModelGameplays = youtubeResultModelGameplays;

    }

    private GameDetailsResultModel detailsResultModel;
    private YoutubeResultModel youtubeResultModelTrailers;
    private YoutubeResultModel youtubeResultModelReviews;
    private YoutubeResultModel youtubeResultModelGameplays;

    public GameDetailsResultModel getDetailsResultModel() {
        return detailsResultModel;
    }

    public void setDetailsResultModel(GameDetailsResultModel detailsResultModel) {
        this.detailsResultModel = detailsResultModel;
    }

    public YoutubeResultModel getYoutubeResultModelTrailers() {
        return youtubeResultModelTrailers;
    }

    public void setYoutubeResultModelTrailers(YoutubeResultModel youtubeResultModelTrailers) {
        this.youtubeResultModelTrailers = youtubeResultModelTrailers;
    }

    public YoutubeResultModel getYoutubeResultModelReviews() {
        return youtubeResultModelReviews;
    }

    public void setYoutubeResultModelReviews(YoutubeResultModel youtubeResultModelReviews) {
        this.youtubeResultModelReviews = youtubeResultModelReviews;
    }

    public YoutubeResultModel getYoutubeResultModelGameplays() {
        return youtubeResultModelGameplays;
    }

    public void setYoutubeResultModelGameplays(YoutubeResultModel youtubeResultModelGameplays) {
        this.youtubeResultModelGameplays = youtubeResultModelGameplays;
    }
}
