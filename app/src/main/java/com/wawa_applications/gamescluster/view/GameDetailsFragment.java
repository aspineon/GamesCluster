package com.wawa_applications.gamescluster.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wawa_applications.gamescluster.BR;
import com.wawa_applications.gamescluster.R;
import com.wawa_applications.gamescluster.databinding.FragmentGameDetailsBinding;
import com.wawa_applications.gamescluster.viewmodel.GameDetailsViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameDetailsFragment extends Fragment {

    private FragmentGameDetailsBinding gameDetailsBinding;
    private GameDetailsViewModel gameDetailsViewModel;
    private String fullGameId;

    public GameDetailsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.getFullGameId();
        gameDetailsViewModel = new GameDetailsViewModel(this.getContext(), fullGameId);
        gameDetailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_details, container, false);
        gameDetailsBinding.setDetailsViewModel(gameDetailsViewModel);
        gameDetailsBinding.setVariable(BR.detailsModel, gameDetailsViewModel.getGameDetailsModel());

        return gameDetailsBinding.getRoot();
    }

    private void getFullGameId() {
        Bundle bundle = this.getArguments();

        if (bundle != null) {
            fullGameId = getString(R.string.gameResource) + String.valueOf(bundle.getInt(getString(R.string.key_game_id), 1));
        }

    }
}
