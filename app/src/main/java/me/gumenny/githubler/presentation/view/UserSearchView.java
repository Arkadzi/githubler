package me.gumenny.githubler.presentation.view;

import android.support.annotation.Nullable;

import java.util.List;

import me.gumenny.githubler.domain.model.User;

/**
 * Created by arkadius on 8/29/17.
 */

public interface UserSearchView extends ProgressView {
    void renderList(@Nullable List<User> users);
    void navigateToDetailScreen(User user);
}
