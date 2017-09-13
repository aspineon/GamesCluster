package com.wawa_applications.gamescluster;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.wawa_applications.gamescluster.databinding.ActivityMainBinding;
import com.wawa_applications.gamescluster.view.GameSearchAdapter;
import com.wawa_applications.gamescluster.viewmodel.MainViewModel;

import java.util.Observable;

import io.reactivex.Observer;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainActivityBinding;
    private MainViewModel mainViewModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new MainViewModel(this);
        mainActivityBinding.setMainViewModel(mainViewModel);

        recyclerView = mainActivityBinding.listGames;
        GameSearchAdapter adapter = new GameSearchAdapter(mainViewModel.getGamesList());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}
