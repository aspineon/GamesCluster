package com.wawa_applications.gamescluster.view;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;


import com.wawa_applications.gamescluster.R;
import com.wawa_applications.gamescluster.databinding.ActivityMainBinding;
import com.wawa_applications.gamescluster.viewmodel.MainViewModel;



public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainActivityBinding;
    private MainViewModel mainViewModel;
    private RecyclerView recyclerView;
    private EditText editText;
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

        editText = (EditText) findViewById(R.id.game_search_input);

        editText.setOnEditorActionListener(new EditText.OnEditorActionListener(){

            @Override
            public boolean onEditorAction(TextView textView, int actionID, KeyEvent keyEvent) {
                if (actionID == EditorInfo.IME_ACTION_DONE){
                    onClickSearchGames(textView);
                    return true;
                }
                return false;
            }
        });

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
