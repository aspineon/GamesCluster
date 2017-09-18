package com.wawa_applications.gamescluster.model.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Wojtek on 2017-09-15.
 */

public class GameDetailsModel {

    @SerializedName("api_detail_url")
    @Expose
    private String apiDetailUrl;

    @SerializedName("deck")
    @Expose
    private String deck;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("expected_release_day")
    @Expose
    private int expectedReleaseDay;

    @SerializedName("expected_release_month")
    @Expose
    private int expectedReleaseMonth;

    @SerializedName("expected_release_year")
    @Expose
    private int expectedReleaseYear;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("image")
    @Expose
    private GameImageModel image;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("number_of_user_reviews")
    @Expose
    private int numberOfUserReviews;

    @SerializedName("original_game_rating")
    @Expose
    private List<OriginalGameRatingModel> originalGameRatingList = null;

    @SerializedName("original_release_date")
    @Expose
    private String originalReleaseDate;

    @SerializedName("platforms")
    @Expose
    private List<GamePlatform> platformsList = null;

    @SerializedName("site_detail_url")
    @Expose
    private String siteDetailUrl;

    @SerializedName("images")
    @Expose
    private List<GameScreenshots> gameScreenshotsList = null;

    @SerializedName("videos")
    @Expose
    private List<GameVideo> gameVideosList = null;

    @SerializedName("concept")
    @Expose
    private List<GameConcept> conceptList = null;

    @SerializedName("genres")
    @Expose
    private List<GameGenre> genresList = null;

    @SerializedName("publishers")
    @Expose
    private List<GamePublisher> publishersList = null;

    @SerializedName("releases")
    @Expose
    private List<GameRelease> releasesList = null;

    @SerializedName("developers")
    @Expose
    private List<GameDeveloper> developersList = null;
    @SerializedName("franchises")
    @Expose
    private List<GameFranchise> franchisesList = null;
    @SerializedName("similar_games")
    @Expose
    private List<GameSimilarGame> similarGamesList = null;


    public String getApiDetailUrl() {
        return apiDetailUrl;
    }

    public void setApiDetailUrl(String apiDetailUrl) {
        this.apiDetailUrl = apiDetailUrl;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getExpectedReleaseDay() {
        return expectedReleaseDay;
    }

    public void setExpectedReleaseDay(Integer expectedReleaseDay) {
        this.expectedReleaseDay = expectedReleaseDay;
    }

    public Integer getExpectedReleaseMonth() {
        return expectedReleaseMonth;
    }

    public void setExpectedReleaseMonth(Integer expectedReleaseMonth) {
        this.expectedReleaseMonth = expectedReleaseMonth;
    }

    public Integer getExpectedReleaseYear() {
        return expectedReleaseYear;
    }

    public void setExpectedReleaseYear(Integer expectedReleaseYear) {
        this.expectedReleaseYear = expectedReleaseYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GameImageModel getImage() {
        return image;
    }

    public void setImage(GameImageModel image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfUserReviews() {
        return numberOfUserReviews;
    }

    public void setNumberOfUserReviews(int numberOfUserReviews) {
        this.numberOfUserReviews = numberOfUserReviews;
    }

    public List<OriginalGameRatingModel> getOriginalGameRatingList() {
        return originalGameRatingList;
    }

    public void setOriginalGameRatingList(List<OriginalGameRatingModel> originalGameRatingList) {
        this.originalGameRatingList = originalGameRatingList;
    }

    public String getOriginalReleaseDate() {
        return originalReleaseDate;
    }

    public void setOriginalReleaseDate(String originalReleaseDate) {
        this.originalReleaseDate = originalReleaseDate;
    }

    public List<GamePlatform> getPlatformsList() {
        return platformsList;
    }

    public void setPlatformsList(List<GamePlatform> platformsList) {
        this.platformsList = platformsList;
    }

    public String getSiteDetailUrl() {
        return siteDetailUrl;
    }

    public void setSiteDetailUrl(String siteDetailUrl) {
        this.siteDetailUrl = siteDetailUrl;
    }

    public List<GameScreenshots> getGameScreenshotsList() {
        return gameScreenshotsList;
    }

    public void setGameScreenshotsList(List<GameScreenshots> gameScreenshotsList) {
        this.gameScreenshotsList = gameScreenshotsList;
    }

    public List<GameVideo> getGameVideosList() {
        return gameVideosList;
    }

    public void setGameVideosList(List<GameVideo> gameVideosList) {
        this.gameVideosList = gameVideosList;
    }

    public List<GameConcept> getConceptList() {
        return conceptList;
    }

    public void setConceptList(List<GameConcept> conceptList) {
        this.conceptList = conceptList;
    }

    public List<GameGenre> getGenresList() {
        return genresList;
    }

    public void setGenresList(List<GameGenre> genresList) {
        this.genresList = genresList;
    }

    public List<GamePublisher> getPublishersList() {
        return publishersList;
    }

    public void setPublishersList(List<GamePublisher> publishersList) {
        this.publishersList = publishersList;
    }

    public List<GameRelease> getReleasesList() {
        return releasesList;
    }

    public void setReleasesList(List<GameRelease> releasesList) {
        this.releasesList = releasesList;
    }

    public List<GameDeveloper> getDevelopersList() {
        return developersList;
    }

    public void setDevelopersList(List<GameDeveloper> developersList) {
        this.developersList = developersList;
    }

    public List<GameFranchise> getFranchisesList() {
        return franchisesList;
    }

    public void setFranchisesList(List<GameFranchise> franchisesList) {
        this.franchisesList = franchisesList;
    }

    public List<GameSimilarGame> getSimilarGamesList() {
        return similarGamesList;
    }

    public void setSimilarGamesList(List<GameSimilarGame> similarGamesList) {
        this.similarGamesList = similarGamesList;
    }
}
