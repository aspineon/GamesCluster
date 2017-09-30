package com.wawa_applications.gamescluster.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wawa_applications.gamescluster.BR;
import com.wawa_applications.gamescluster.R;
import com.wawa_applications.gamescluster.model.details.GameDetailsResultModel;
import com.wawa_applications.gamescluster.model.search.GameResultModel;
import com.wawa_applications.gamescluster.network.GiantBombService;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
                    context = v.getContext();

                    startDetailsActivity(position);


                }
            });
        }

        private void startDetailsActivity(int position) {

            final int gamePosition = position;
            final Intent intent = new Intent(context, GameDetailsActivity.class);

            String gameFullId = context.getString(R.string.gameResource) + mGamesList.get(gamePosition).getId();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://www.giantbomb.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            GiantBombService apiService = retrofit.create(GiantBombService.class);

            apiService.getGameDetails(gameFullId)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<GameDetailsResultModel>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(GameDetailsResultModel respond) {

                            intent.putExtra(context.getString(R.string.key_details_model), respond.getGameDetailsModel());
                        }

                        @Override
                        public void onError(Throwable e) {
                            Toast.makeText(context, "Error occurs", Toast.LENGTH_SHORT).show();
                            Log.v("Games Cluster", "Error occurs", e);
                        }

                        @Override
                        public void onComplete() {
                            intent.putExtra(context.getString(R.string.key_game_name), mGamesList.get(gamePosition).getName());
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
