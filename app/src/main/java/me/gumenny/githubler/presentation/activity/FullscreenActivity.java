package me.gumenny.githubler.presentation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.gumenny.githubler.presentation.activity.FragmentContainerActivity;

public class FullscreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, FragmentContainerActivity.class));
        finish();
    }

}
