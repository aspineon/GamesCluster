package com.wawa_applications.gamescluster;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


import com.wawa_applications.gamescluster.databinding.ActivityMainBinding;
import com.wawa_applications.gamescluster.view.GameSearchAdapter;
import com.wawa_applications.gamescluster.viewmodel.MainViewModel;

import java.util.Observable;

import io.reactivex.Observer;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainActivityBinding;
    private MainViewModel mainViewModel;
    private RecyclerView recyclerView;
    GameSearchAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new MainViewModel(this);
        mainActivityBinding.setMainViewModel(mainViewModel);

        recyclerView = mainActivityBinding.listGames;
        mAdapter = new GameSearchAdapter(this, mainViewModel.getGamesList());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.smoothScrollToPosition(0);

    }

    public void onClickSearchGames(View view) {
        hideKeyboard();
        mainViewModel.onClickSearchGames(view);
        mAdapter.notifyDataSetChanged();

    }

    private void hideKeyboard(){
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

}
