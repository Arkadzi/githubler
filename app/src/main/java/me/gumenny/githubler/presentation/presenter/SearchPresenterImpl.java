package me.gumenny.githubler.presentation.presenter;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import me.gumenny.githubler.domain.model.User;
import me.gumenny.githubler.domain.subscribers.BaseProgressSubscriber;
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
    public void onCreate(UserSearchView view) {
        super.onCreate(view);
        if (searchUsersUseCase.isWorking()) {
            searchUsersUseCase.execute(getSubscriber());
        }
    }

    @Override
    public void onRelease() {
        searchUsersUseCase.unsubscribe();
        super.onRelease();
    }

    @Override
    public void onSearchSubmit(String query) {
        if (searchUsersUseCase.isWorking()) {
            searchUsersUseCase.stopExecution();
        }
        searchUsersUseCase.setQuery(query);
        searchUsersUseCase.execute(getSubscriber());
    }

    @NonNull
    private BaseProgressSubscriber<List<User>> getSubscriber() {
        return new BaseProgressSubscriber<List<User>>(this) {
            @Override
            public void onNext(List<User> response) {
                super.onNext(response);
                UserSearchView view = getView();
                if (view != null) {
                    view.renderList(response);
                }
            }
        };
    }

    @Override
    public void onItemClick(User user) {

    }

    @Override
    public void onSearchCollapsed() {
        if (searchUsersUseCase.isWorking()) {
            searchUsersUseCase.stopExecution();
        }
        UserSearchView view = getView();
        if (view != null) {
            view.renderList(new ArrayList<>());
        }
    }
}
