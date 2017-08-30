package me.gumenny.githubler.presentation.presenter;

import me.gumenny.githubler.presentation.view.DetailView;
import me.gumenny.githubler.presentation.view.View;

/**
 * Created by arkadius on 8/30/17.
 */

public interface DetailPresenter extends Presenter<DetailView> {
    void onErrorViewClick();
}
