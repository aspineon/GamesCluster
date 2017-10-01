package com.wawa_applications.gamescluster.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wawa_applications.gamescluster.R;
import com.wawa_applications.gamescluster.model.details.GameDetailsResultModel;
import com.wawa_applications.gamescluster.network.GiantBombService;

import java.util.List;
import java.util.Random;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Wojtek on 2017-10-01.
 */

public class GameSimilarAdapter extends RecyclerView.Adapter<GameSimilarAdapter.GameSimilarHolder> {

    private List<String> mGameNamesList;
    private List<String> mGameIdList;
    Context context;
    private TypedArray gradientArray;


    public GameSimilarAdapter(Context context, List<String> gamesNameList, List<String> gamesIdsList) {
        this.context = context;
        this.mGameNamesList = gamesNameList;
        this.mGameIdList = gamesIdsList;
        gradientArray = context.getResources().obtainTypedArray(R.array.gradient_list);
    }

    @Override
    public GameSimilarAdapter.GameSimilarHolder onCreateViewHolder(ViewGroup parent, int type) {

        View singleCard = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.similar_game_layout, parent, false);
        setCardBackgroundGradient(singleCard);
        GameSimilarAdapter.GameSimilarHolder holder = new GameSimilarAdapter.GameSimilarHolder(singleCard);
        return holder;
    }

    @Override
    public void onBindViewHolder(GameSimilarAdapter.GameSimilarHolder holder, int position) {
        String gameName = mGameNamesList.get(position);

        holder.getGameNameField().setText(gameName);
    }

    @Override
    public int getItemCount() {
        return mGameNamesList.size();
    }


    public class GameSimilarHolder extends RecyclerView.ViewHolder {

        private TextView gameNameField;

        public GameSimilarHolder(View rowView) {
            super(rowView);

            gameNameField = rowView.findViewById(R.id.similar_game_text);

            rowView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    startDetailActivityOfSimilarGame(position);
                }
            });
        }

        private void startDetailActivityOfSimilarGame(int position) {

            final int gamePosition = position;
            final Intent intent = new Intent(context, GameDetailsActivity.class);

            String gameFullId = context.getString(R.string.gameResource) + mGameIdList.get(gamePosition);
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
                            intent.putExtra(context.getString(R.string.key_game_name), mGameNamesList.get(gamePosition));
                            context.startActivity(intent);
                        }
                    });
        }

        public TextView getGameNameField() {
            return gameNameField;
        }

    }

    private void setCardBackgroundGradient(View view){

        CardView cardView = (CardView) view;
        Drawable randomGradient = gradientArray.getDrawable(new Random().nextInt(gradientArray.length()));
        cardView.setBackground(randomGradient);
    }
}
