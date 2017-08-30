package me.gumenny.githubler.presentation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import me.gumenny.githubler.R;
import me.gumenny.githubler.presentation.fragment.DetailFragment;
import me.gumenny.githubler.presentation.fragment.SearchFragment;
import me.gumenny.githubler.presentation.utils.Navigator;

/**
 * Created by arkadius on 8/28/17.
 */

public class FragmentContainerActivity extends AppCompatActivity implements Navigator {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, new SearchFragment())
                    .commit();
        }
    }


    @Override
    public void navigateToDetailScreen(String login) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, DetailFragment.newInstance(login))
                .addToBackStack(null)
                .commit();
    }
}
