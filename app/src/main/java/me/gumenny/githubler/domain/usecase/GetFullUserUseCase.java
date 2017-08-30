package me.gumenny.githubler.domain.usecase;

import javax.inject.Inject;

import me.gumenny.githubler.domain.Repository;
import me.gumenny.githubler.domain.model.FullUser;
import me.gumenny.githubler.domain.schedulers.ObserveOn;
import me.gumenny.githubler.domain.schedulers.SubscribeOn;
import rx.Observable;

/**
 * Created by arkadius on 8/29/17.
 */

public class GetFullUserUseCase extends UseCase<FullUser> {

    private Repository repository;
    private String login;

    @Inject
    public GetFullUserUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, Repository repository) {
        super(subscribeOn, observeOn);
        this.repository = repository;
    }

    @Override
    protected Observable<FullUser> getUseCaseObservable() {
        return repository.getFullUser(login);
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
