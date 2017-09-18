package com.wawa_applications.gamescluster.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wawa_applications.gamescluster.BR;
import com.wawa_applications.gamescluster.R;
import com.wawa_applications.gamescluster.model.search.GameResultModel;

import java.util.List;
import java.util.Random;

/**
 * Created by Wojtek on 2017-09-06.
 */


public class GameSearchAdapter extends RecyclerView.Adapter<GameSearchAdapter.GameSearchBindingHolder> {
    private List<GameResultModel> mGamesList;
    private Context context;
    int[] colorArray;

    public GameSearchAdapter(Context context, List<GameResultModel> mGamesList) {
        this.mGamesList = mGamesList;
        this.context = context;
        colorArray = context.getResources().getIntArray(R.array.viewcard_colors);
    }

    @Override
    public GameSearchBindingHolder onCreateViewHolder(ViewGroup parent, int type) {
        View singleCard = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.game_card, parent, false);
        setCardBackgroundColor(singleCard);
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


    public class GameSearchBindingHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public GameSearchBindingHolder(View rowView) {
            super(rowView);
            binding = DataBindingUtil.bind(rowView);

            rowView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    Context context = v.getContext();
                    Intent intent = new Intent(context, GameDetailsActivity.class);
                    intent.putExtra(context.getString(R.string.key_game_id), mGamesList.get(position).getId());
                    intent.putExtra(context.getString(R.string.key_game_name), mGamesList.get(position).getName());
                    context.startActivity(intent);
                }
            });
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

    }
    private void setCardBackgroundColor(View view){

        CardView cardView = (CardView) view;
        int randomAndroidColor = colorArray[new Random().nextInt(colorArray.length)];
        cardView.setCardBackgroundColor(randomAndroidColor);


    }
}
