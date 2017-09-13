package com.wawa_applications.gamescluster.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
    private String gameQueryResult = "";
    private int progressVisibility;
    private int recyclerVisibility;

    public MainViewModel(@NotNull Context context){
        this.context = context;
        gamesList = new ArrayList<>();

        progressVisibility = View.GONE;
        recyclerVisibility = View.GONE;
    }

    public void onClickSearchGames(View view) {
        recyclerVisibility = View.GONE;
        progressVisibility = View.VISIBLE;
        hideKeyboard();
        notifyPropertyChanged(BR._all);
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
                        progressVisibility = View.GONE;
                        recyclerVisibility = View.VISIBLE;
                        notifyPropertyChanged(BR._all);
                    }

                    @Override
                    public void onError(Throwable e) {
                        progressVisibility = View.GONE;
                        notifyPropertyChanged(BR._all);
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

    private void hideKeyboard(){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    @Bindable
    public List<GameResultModel> getGamesList() {
        return gamesList;
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

    @Bindable
    public int getProgressVisibility() {
        return progressVisibility;
    }

    @Bindable
    public int getRecyclerVisibility() {
        return recyclerVisibility;
    }
}
