package me.gumenny.githubler.presentation.presenter;


import me.gumenny.githubler.presentation.view.View;

public interface Presenter<V extends View> {
    void onCreate(V view);
    void onRelease();
}
