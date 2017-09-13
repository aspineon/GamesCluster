package com.wawa_applications.gamescluster.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wawa_applications.gamescluster.BR;
import com.wawa_applications.gamescluster.R;
import com.wawa_applications.gamescluster.databinding.GameCardBinding;
import com.wawa_applications.gamescluster.model.search.GameResultModel;
import com.wawa_applications.gamescluster.viewmodel.GameCardViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wojtek on 2017-09-06.
 */


public class GameSearchAdapter extends RecyclerView.Adapter<GameSearchAdapter.GameSearchBindingHolder> {
    private List<GameResultModel> mGamesList;


    public GameSearchAdapter(List<GameResultModel> mGamesList) {
        this.mGamesList = mGamesList;
    }

    @Override
    public GameSearchBindingHolder onCreateViewHolder(ViewGroup parent, int type) {
        View singleCard = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.game_card, parent, false);
        GameSearchBindingHolder holder = new GameSearchBindingHolder(singleCard);
        return holder;
    }

    @Override
    public void onBindViewHolder(GameSearchBindingHolder holder, int position) {
        final GameResultModel gameResult = mGamesList.get(position);

        holder.getBinding().setVariable(BR.gameResult, gameResult);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mGamesList.size();
    }


    public static class GameSearchBindingHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public GameSearchBindingHolder(View rowView) {
            super(rowView);
            binding = DataBindingUtil.bind(rowView);
/*
            rowView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    Context context = v.getContext();
                    Intent intent = new Intent(context, GameDetailsActivity.class);
                    intent.putExtra(context.getString(R.string.key_game_id, mGamesList.get(position).getId());
                    context.startActivity(intent);
                }
            });*/
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }
}