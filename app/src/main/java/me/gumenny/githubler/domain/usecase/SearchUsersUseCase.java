package me.gumenny.githubler.domain.usecase;

import java.util.List;

import javax.inject.Inject;

import me.gumenny.githubler.data.di.scope.UserScope;
import me.gumenny.githubler.domain.Repository;
import me.gumenny.githubler.domain.model.User;
import me.gumenny.githubler.domain.schedulers.ObserveOn;
import me.gumenny.githubler.domain.schedulers.SubscribeOn;
import rx.Observable;

/**
 * Created by arkadius on 8/29/17.
 */

public class SearchUsersUseCase extends UseCase<List<User>> {

    private Repository repository;
    private String query;

    @Inject
    public SearchUsersUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, Repository repository) {
        super(subscribeOn, observeOn);
        this.repository = repository;
    }

    @Override
    protected Observable<List<User>> getUseCaseObservable() {
        return repository.getUsers(query);
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
