package com.wawa_applications.gamescluster.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Html;
import android.util.Log;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wawa_applications.gamescluster.model.details.GameConcept;
import com.wawa_applications.gamescluster.model.details.GameDetailsModel;
import com.wawa_applications.gamescluster.model.details.GameDetailsResultModel;
import com.wawa_applications.gamescluster.model.details.GameDeveloper;
import com.wawa_applications.gamescluster.model.details.GameFranchise;
import com.wawa_applications.gamescluster.model.details.GameGenre;
import com.wawa_applications.gamescluster.model.details.GameImageModel;
import com.wawa_applications.gamescluster.model.details.GamePlatform;
import com.wawa_applications.gamescluster.model.details.GamePublisher;
import com.wawa_applications.gamescluster.model.details.GameScreenshots;
import com.wawa_applications.gamescluster.model.details.GameSimilarGame;
import com.wawa_applications.gamescluster.model.details.OriginalGameRatingModel;
import com.wawa_applications.gamescluster.network.GiantBombService;

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wojtek on 2017-09-19.
 */

public class GameDetailsViewModel extends BaseObservable {


    private GameDetailsModel gameDetailsModel;
    private boolean showImages = true;
    private boolean fixedView = true;


    public GameDetailsViewModel(@NotNull GameDetailsModel gameDetailsModel){
        this.gameDetailsModel = gameDetailsModel;

    }


    @Bindable
    public String getGameReleaseDate(){
        String gameReleaseDate = "N/A";
        if(gameDetailsModel.getExpectedReleaseYear() != null) gameReleaseDate = String.valueOf(gameDetailsModel.getExpectedReleaseYear());

        if(gameDetailsModel.getOriginalReleaseDate() != null){
            String day = gameDetailsModel.getOriginalReleaseDate().substring(8, 10);
            String month = gameDetailsModel.getOriginalReleaseDate().substring(5, 7);
            String year = gameDetailsModel.getOriginalReleaseDate().substring(0, 4);
            gameReleaseDate = day + "." + month + "." + year;
        }
        return gameReleaseDate;
    }

    @Bindable
    public String getFranchises(){
        String franchiseString = "N/A";
        List<GameFranchise> franchiseList = gameDetailsModel.getFranchisesList();

        if (franchiseList != null){
            for(GameFranchise gameFranchise : franchiseList){
                franchiseString = franchiseString + " | " + gameFranchise.getName();
            }
            franchiseString = franchiseString.substring(6);
        }
        return franchiseString;
    }

    @Bindable
    public String getGenres(){
        String genreString = "N/A";
        List<GameGenre> genreList = gameDetailsModel.getGenresList();

        if (genreList != null){
            for(GameGenre gameGenre : genreList){
                genreString = genreString + " | " + gameGenre.getName();
            }
            genreString = genreString.substring(6);
        }
        return genreString;
    }

    @Bindable
    public String getPlatforms(){
        String platformString = "N/A";
        List<GamePlatform> platformsList = gameDetailsModel.getPlatformsList();

        if (platformsList != null){
            for(GamePlatform gamePlatform : platformsList){
                platformString = platformString + " | " + gamePlatform.getName();
            }
            platformString = platformString.substring(6);
        }
        return platformString;
    }

    @Bindable
    public String getRatings(){
        String ratingString = "N/A";
        List<OriginalGameRatingModel> ratingModelList = gameDetailsModel.getOriginalGameRatingList();

        if (ratingModelList != null){
            for(OriginalGameRatingModel gameRatingModel : ratingModelList){
                ratingString = ratingString + " | " + gameRatingModel.getName();
            }
            ratingString = ratingString.substring(6);
        }
        return ratingString;
    }

    @Bindable
    public String getDevelopers(){
        String developersString = "N/A";
        List<GameDeveloper> developerList = gameDetailsModel.getDevelopersList();

        if (developerList != null){
            for(GameDeveloper gameDeveloper : developerList){
                developersString = developersString + " | " + gameDeveloper.getName();
            }
            developersString = developersString.substring(6);
        }
        return developersString;
    }

    @Bindable
    public String getPublishers(){
        String publisherString = "N/A";
        List<GamePublisher> developerList = gameDetailsModel.getPublishersList();

        if (developerList != null){
            for(GamePublisher gamePublisher : developerList){
                publisherString = publisherString + " | " + gamePublisher.getName();
            }
            publisherString = publisherString.substring(6);
        }
        return publisherString;
    }


    @Bindable
    public String getDescription(){
        String description = "Sorry to say, but this game does not have any description. :( ";
        String htmlText = gameDetailsModel.getDescription();

        if (htmlText != null){
            Document document = Jsoup.parse(htmlText);
            document.outputSettings(new Document.OutputSettings().prettyPrint(false));
            document.select("br").append("\\n");
            document.select("p").prepend("\\n\\n");
            document.select("h2").prepend("\\n\\n\\n");
            document.select("ul").prepend("\\n");
            document.select("li").append("\\n");
            String str = document.html().replaceAll("\\\\n", "\n");

            description = Jsoup.clean(str, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false));
        }

        description = description.substring(3,description.length()-1);
        return description;
    }

    @Bindable
    public String getTags(){

        String gameTags = "What a pity, there is no tags for this game. :(";

        List<GameConcept> conceptList = gameDetailsModel.getConceptList();
        if (conceptList != null){
            gameTags = "";
            for (GameConcept concept : conceptList){
                gameTags = gameTags + "\t#" + concept.getName();
            }
        }

        return gameTags;
    }

    @Bindable
    public boolean isShowImages() {
        return showImages;
    }

    @Bindable
    public boolean isFixedView() {
        return fixedView;
    }

    public List<String> getImagesUrlList(){
        List<String> imagesUrlList = new ArrayList<String>();

        List<GameScreenshots> screenshotsListList = gameDetailsModel.getGameScreenshotsList();

        if (screenshotsListList != null) {
            for (GameScreenshots screenshots : screenshotsListList){
                imagesUrlList.add(screenshots.getMediumUrl());
            }
        }
        return imagesUrlList;
    }

    public List<String> getSimilarGamesNames(){
        List<String> similarGamesNamesList = new ArrayList<String>();

        List<GameSimilarGame> similarGamesList = gameDetailsModel.getSimilarGamesList();

        if (similarGamesList != null) {
            for (GameSimilarGame similarGame : similarGamesList){
                similarGamesNamesList.add(similarGame.getName());
            }
        }
        return similarGamesNamesList;
    }

    public List<String> getSimilarGamesId(){
        List<String> similarGamesIdList = new ArrayList<String>();

        List<GameSimilarGame> similarGamesList = gameDetailsModel.getSimilarGamesList();

        if (similarGamesList != null) {
            for (GameSimilarGame similarGame : similarGamesList){
                similarGamesIdList.add(String.valueOf(similarGame.getId()));
            }
        }
        return similarGamesIdList;
    }
}
