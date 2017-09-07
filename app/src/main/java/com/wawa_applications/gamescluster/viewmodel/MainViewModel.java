package com.wawa_applications.gamescluster.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import com.wawa_applications.gamescluster.model.search.GameResultModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wojtek Krzywiec on 23/08/2017.
 */

public class MainViewModel extends BaseObservable {

    public String gameQuery = "";
    private Context context;
    private List<GameResultModel> gamesList;

    public MainViewModel(@NotNull Context context){
        this.context = context;
        gamesList = new ArrayList<>();
    }

    public void onClickSearchGames(View view) {
    }

    public void reset() {
    //TODO unsubscribe rxjava observer
        context = null;
    }
}
