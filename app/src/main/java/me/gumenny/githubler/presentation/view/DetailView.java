package me.gumenny.githubler.presentation.view;

import android.support.annotation.Nullable;

import me.gumenny.githubler.domain.model.FullUser;

/**
 * Created by arkadius on 8/30/17.
 */

public interface DetailView extends ProgressView {
    void renderUser(FullUser fullUser);
    void renderErrorView();
    @Nullable
    FullUser getUser();
    String getLogin();
}
