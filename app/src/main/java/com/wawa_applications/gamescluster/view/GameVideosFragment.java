package com.wawa_applications.gamescluster.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wawa_applications.gamescluster.R;
import com.wawa_applications.gamescluster.databinding.FragmentGameVideosBinding;
import com.wawa_applications.gamescluster.model.youtube.YoutubeResultModel;
import com.wawa_applications.gamescluster.model.youtube.YoutubeVideoItem;
import com.wawa_applications.gamescluster.viewmodel.GameVideosViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameVideosFragment extends Fragment {

    private FragmentGameVideosBinding gameVideosBinding;
    private GameVideosViewModel gameVideosViewModel;
    private String gameName;
    private List<YoutubeVideoItem> youtubeTrailers;
    private RecyclerView trailersRecyclerView;
    private YoutubeVideoAdapter trailersVideoAdapter;
    private List<YoutubeVideoItem> youtubeReviews;
    private RecyclerView reviewsRecyclerView;
    private YoutubeVideoAdapter reviewsVideoAdapter;
    private List<YoutubeVideoItem> youtubeGameplays;
    private RecyclerView gameplaysRecyclerView;
    private YoutubeVideoAdapter gameplaysVideoAdapter;

    public GameVideosFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.getGameName();
        this.getVideoItems();
        gameVideosViewModel = new GameVideosViewModel(this.getContext(), gameName);
        gameVideosBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_videos, container, false);
        gameVideosBinding.setVideosViewModel(gameVideosViewModel);


        trailersRecyclerView = gameVideosBinding.trailerRecyclerview;
        trailersVideoAdapter = new YoutubeVideoAdapter(getActivity(), youtubeTrailers);
        LinearLayoutManager layoutManagerTrailers = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        trailersRecyclerView.setAdapter(trailersVideoAdapter);
        trailersRecyclerView.setLayoutManager(layoutManagerTrailers);
        trailersRecyclerView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        reviewsRecyclerView = gameVideosBinding.reviewRecyclerview;
        reviewsVideoAdapter = new YoutubeVideoAdapter(getActivity(), youtubeReviews);
        LinearLayoutManager layoutManagerReviews = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        reviewsRecyclerView.setAdapter(reviewsVideoAdapter);
        reviewsRecyclerView.setLayoutManager(layoutManagerReviews);
        reviewsRecyclerView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        gameplaysRecyclerView = gameVideosBinding.gameplayRecyclerview;
        gameplaysVideoAdapter = new YoutubeVideoAdapter(getActivity(), youtubeGameplays);
        LinearLayoutManager layoutManagerGameplays = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        gameplaysRecyclerView.setAdapter(gameplaysVideoAdapter);
        gameplaysRecyclerView.setLayoutManager(layoutManagerGameplays);
        gameplaysRecyclerView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        return gameVideosBinding.getRoot();
    }

    private void getGameName(){
        Bundle bundle = this.getArguments();

        if (bundle != null) {
            gameName = bundle.getString(getString(R.string.app_name), "Space Invader");
        }
    }

    private void getVideoItems(){

            YoutubeResultModel youtubeTrailersModel = (YoutubeResultModel) getActivity().getIntent().getSerializableExtra(getString(R.string.key_video_trailers));
            youtubeTrailers =  youtubeTrailersModel.getYoutubeVideoItems();

            YoutubeResultModel youtubeReviewsModel = (YoutubeResultModel) getActivity().getIntent().getSerializableExtra(getString(R.string.key_video_reviews));
            youtubeReviews = youtubeReviewsModel.getYoutubeVideoItems();

            YoutubeResultModel youtubeGameplaysModel = (YoutubeResultModel) getActivity().getIntent().getSerializableExtra(getString(R.string.key_video_gameplays));
            youtubeGameplays = youtubeGameplaysModel.getYoutubeVideoItems();
    }

}
