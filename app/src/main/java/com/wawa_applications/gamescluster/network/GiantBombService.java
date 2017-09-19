package com.wawa_applications.gamescluster.network;


import com.wawa_applications.gamescluster.model.details.GameDetailsResultModel;
import com.wawa_applications.gamescluster.model.search.GiantBombSearchModel;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Wojtek Krzywiec on 23/08/2017.
 */

public interface GiantBombService {

    @GET("api/search/?api_key=[API-KEY]&format=json&resources=game&limit=70")
    Observable<GiantBombSearchModel> searchForGames(@Query("query") String gameName);


    @GET("api/game/{gameId}/?api_key=[API-KEY]&format=json")
    Observable<GameDetailsResultModel> getGameDetails(@Path("gameId") String gameId);
}
