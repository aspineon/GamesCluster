package com.wawa_applications.gamescluster.model.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wojtek Krzywiec on 22/08/2017.
 */

public class GiantBombSearchModel {

    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("status_code")
    @Expose
    private int statusCode;
    @SerializedName("results")
    @Expose
    private List<GameResultModel> results = new ArrayList<GameResultModel>();

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<GameResultModel> getResults() {
        return results;
    }

    public void setResults(List<GameResultModel> results) {
        this.results = results;
    }

}
