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
public class GameVideosFragment extends Fragment {


    public GameVideosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_videos, container, false);
    }

}
