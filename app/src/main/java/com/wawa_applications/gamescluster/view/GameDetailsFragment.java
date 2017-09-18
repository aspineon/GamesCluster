package com.wawa_applications.gamescluster.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wawa_applications.gamescluster.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameDetailsFragment extends Fragment {


    public GameDetailsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_game_details, container, false);
    }

}
