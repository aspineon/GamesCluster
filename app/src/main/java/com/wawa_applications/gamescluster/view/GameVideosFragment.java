package com.wawa_applications.gamescluster.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wawa_applications.gamescluster.BR;
import com.wawa_applications.gamescluster.R;
import com.wawa_applications.gamescluster.databinding.FragmentGameVideosBinding;
import com.wawa_applications.gamescluster.viewmodel.GameVideosViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameVideosFragment extends Fragment {

    private FragmentGameVideosBinding gameVideosBinding;
    private GameVideosViewModel gameVideosViewModel;
    private String gameName;

    public GameVideosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.getGameName();
        gameVideosViewModel = new GameVideosViewModel(this.getContext(), gameName);
        gameVideosBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_videos, container, false);
        gameVideosBinding.setVideosViewModel(gameVideosViewModel);

        return gameVideosBinding.getRoot();
    }

    private void getGameName(){
        Bundle bundle = this.getArguments();

        if (bundle != null) {
            gameName = bundle.getString(getString(R.string.app_name), "Space Invader");
        }

    }
}
