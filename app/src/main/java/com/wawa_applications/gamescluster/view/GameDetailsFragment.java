package com.wawa_applications.gamescluster.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.wawa_applications.gamescluster.BR;
import com.wawa_applications.gamescluster.R;
import com.wawa_applications.gamescluster.databinding.FragmentGameDetailsBinding;
import com.wawa_applications.gamescluster.model.details.GameConcept;
import com.wawa_applications.gamescluster.model.details.GameDetailsModel;
import com.wawa_applications.gamescluster.viewmodel.GameDetailsViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameDetailsFragment extends Fragment {

    private FragmentGameDetailsBinding gameDetailsBinding;
    private GameDetailsViewModel gameDetailsViewModel;
    private RecyclerView recyclerView;
    private GameImagesAdapter gameImagesAdapter;

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

        recyclerView = gameDetailsBinding.imageRecyclerview;
        gameImagesAdapter = new GameImagesAdapter(getContext(), gameDetailsViewModel.getImagesUrlList());
        recyclerView.setAdapter(gameImagesAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());

        recyclerView.addItemDecoration(dividerItemDecoration);

        return gameDetailsBinding.getRoot();
    }



}
