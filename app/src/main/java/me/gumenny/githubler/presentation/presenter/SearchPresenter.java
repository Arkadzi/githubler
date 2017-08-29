package me.gumenny.githubler.presentation.presenter;

import me.gumenny.githubler.domain.model.User;
import me.gumenny.githubler.presentation.view.UserSearchView;
import me.gumenny.githubler.presentation.view.View;

/**
 * Created by arkadius on 8/29/17.
 */

public interface SearchPresenter extends Presenter<UserSearchView> {
    void onSearchSubmit(String query);
    void onItemClick(User user);

    void onSearchCollapsed();
}
