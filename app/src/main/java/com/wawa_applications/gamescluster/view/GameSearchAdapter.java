package com.wawa_applications.gamescluster.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wawa_applications.gamescluster.R;
import com.wawa_applications.gamescluster.databinding.GameCardBinding;
import com.wawa_applications.gamescluster.model.search.GameResultModel;
import com.wawa_applications.gamescluster.viewmodel.GameCardViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wojtek on 2017-09-06.
 */

public class GameSearchAdapter extends RecyclerView.Adapter<GameSearchAdapter.GameSearchAdapterViewHolder> {

    private List<GameResultModel> gameList;

    public GameSearchAdapter() {
        gameList = new ArrayList<GameResultModel>();
    }

    @Override
    public GameSearchAdapter.GameSearchAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        GameCardBinding gameCardBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.game_card,
                parent,
                false);

        return new GameSearchAdapterViewHolder(gameCardBinding);
    }

    @Override
    public void onBindViewHolder(GameSearchAdapter.GameSearchAdapterViewHolder holder, int position) {
        holder.bindGameSearch(gameList.get(position));
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    public void setGameList(List<GameResultModel> gameList){
        this.gameList = gameList;
        notifyDataSetChanged();
    }

    public static class GameSearchAdapterViewHolder extends RecyclerView.ViewHolder {

        GameCardBinding gameCardBinding;

        public GameSearchAdapterViewHolder(GameCardBinding gameCardBinding){
            super(gameCardBinding.gameItem);
            this.gameCardBinding = gameCardBinding;
        }

        void bindGameSearch(GameResultModel game){
            if (gameCardBinding.getCardViewModel() == null) {
                gameCardBinding.setCardViewModel(
                        new GameCardViewModel(itemView.getContext(), game));
            } else {
                gameCardBinding.getCardViewModel().setGameResult(game);
            }
        }
    }
}
