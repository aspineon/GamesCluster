package com.wawa_applications.gamescluster.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wawa_applications.gamescluster.BR;
import com.wawa_applications.gamescluster.R;
import com.wawa_applications.gamescluster.databinding.FragmentGameDetailsBinding;
import com.wawa_applications.gamescluster.model.details.GameDetailsModel;
import com.wawa_applications.gamescluster.viewmodel.GameDetailsViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameDetailsFragment extends Fragment {

    private FragmentGameDetailsBinding gameDetailsBinding;
    private GameDetailsViewModel gameDetailsViewModel;
    private RecyclerView imagesRecyclerView;
    private GameImagesAdapter gameImagesAdapter;
    private RecyclerView similarGamesRecyclerView;
    private GameSimilarAdapter gameSimilarAdapter;

    public GameDetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        GameDetailsModel model = (GameDetailsModel) getActivity().getIntent().getSerializableExtra(getString(R.string.key_details_model));

        gameDetailsViewModel = new GameDetailsViewModel(model);
        gameDetailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_details, container, false);
        gameDetailsBinding.setViewModel(gameDetailsViewModel);
        gameDetailsBinding.setVariable(BR.model, model);

        imagesRecyclerView = gameDetailsBinding.imageRecyclerview;
        gameImagesAdapter = new GameImagesAdapter(getContext(), gameDetailsViewModel.getImagesUrlList());
        imagesRecyclerView.setAdapter(gameImagesAdapter);
        imagesRecyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        imagesRecyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(imagesRecyclerView.getContext(), layoutManager.getOrientation());
        imagesRecyclerView.addItemDecoration(dividerItemDecoration);

        similarGamesRecyclerView = gameDetailsBinding.similarRecyclerview;
        gameSimilarAdapter = new GameSimilarAdapter(getContext(), gameDetailsViewModel.getSimilarGamesNames(), gameDetailsViewModel.getSimilarGamesId());
        similarGamesRecyclerView.setAdapter(gameSimilarAdapter);
        similarGamesRecyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManagerSimilar = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        similarGamesRecyclerView.setLayoutManager(layoutManagerSimilar);
        DividerItemDecoration dividerItemDecorationSimilar = new DividerItemDecoration(similarGamesRecyclerView.getContext(), layoutManager.getOrientation());
        similarGamesRecyclerView.addItemDecoration(dividerItemDecorationSimilar);

        return gameDetailsBinding.getRoot();
    }



}
