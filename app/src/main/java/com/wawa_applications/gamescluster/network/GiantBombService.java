package com.wawa_applications.gamescluster.network;

import android.database.Observable;

import com.wawa_applications.gamescluster.model.search.GiantBombSearchModel;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Wojtek Krzywiec on 23/08/2017.
 */

public interface GiantBombService {

    @GET("search/?api_key=[API-KEY]&format=json&resources=game")
    Observable<GiantBombSearchModel> searchForGames(@Query("query") String gameName);
}
