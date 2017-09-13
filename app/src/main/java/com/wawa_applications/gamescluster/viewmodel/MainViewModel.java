package com.wawa_applications.gamescluster.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wawa_applications.gamescluster.model.search.GameResultModel;
import com.wawa_applications.gamescluster.model.search.GiantBombSearchModel;
import com.wawa_applications.gamescluster.network.GiantBombService;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Wojtek Krzywiec on 23/08/2017.
 */

public class MainViewModel extends BaseObservable {

    private String gameQuery = "";
    private Context context;
    private List<GameResultModel> gamesList;
    public boolean gamesRecyclerVisibility = false;
    private String gameQueryResult = "";

    public MainViewModel(@NotNull Context context){
        this.context = context;
        gamesList = new ArrayList<>();
    }

    public void onClickSearchGames(View view) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.giantbomb.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        GiantBombService apiService = retrofit.create(GiantBombService.class);


        apiService.searchForGames(gameQuery)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GiantBombSearchModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GiantBombSearchModel respond) {
                        handleResult(respond);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(context, "Error occurs", Toast.LENGTH_SHORT).show();
                        Log.v("Games Cluster", "Error occurs", e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void handleResult(GiantBombSearchModel respond){
        gameQueryResult = "Znaleziono " + String.valueOf(respond.getResults().size()) + " gier.";
        gameQueryResult = gameQueryResult + " Są to: ";
        for (GameResultModel resultModel : respond.getResults()){
            gameQueryResult = gameQueryResult + ", " + resultModel.getName() + " " + resultModel.getReleaseYear();
        }

        gamesList.clear();
        gamesList.addAll(respond.getResults());
        notifyPropertyChanged(BR._all);
    }

    public void reset() {
    //TODO unsubscribe rxjava observer
        context = null;
    }

    @Bindable
    public List<GameResultModel> getGamesList() {
        return gamesList;
    }

    @Bindable
    public boolean getGamesRecyclerVisibility(){
        return gamesRecyclerVisibility;
    }


    public void setGamesRecyclerVisibility(boolean isVisible){
        this.gamesRecyclerVisibility = isVisible;
    }

    @Bindable
    public String getGameQuery() {
        return gameQuery;
    }

    public void setGameQuery(String gameQuery) {
        this.gameQuery = gameQuery;
        notifyPropertyChanged(BR._all);
    }

    @Bindable
    public String getGameQueryResult() {
        return gameQueryResult;
    }

    public void setGameQueryResult(String gameQueryResult) {
        this.gameQueryResult = gameQueryResult;
    }
}
