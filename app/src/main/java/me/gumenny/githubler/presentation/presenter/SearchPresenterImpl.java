package me.gumenny.githubler.presentation.presenter;

import me.gumenny.githubler.domain.model.User;
import me.gumenny.githubler.domain.usecase.SearchUsersUseCase;
import me.gumenny.githubler.presentation.utils.Messages;
import me.gumenny.githubler.presentation.view.UserSearchView;

/**
 * Created by arkadius on 8/29/17.
 */

public class SearchPresenterImpl extends ProgressPresenter<UserSearchView>
        implements SearchPresenter {

    private final SearchUsersUseCase searchUsersUseCase;

    public SearchPresenterImpl(Messages messages, SearchUsersUseCase searchUsersUseCase) {
        super(messages);
        this.searchUsersUseCase = searchUsersUseCase;
    }

    @Override
    public void onSearchSubmit(String query) {

    }

    @Override
    public void onItemClick(User user) {

    }
}
