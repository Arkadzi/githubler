package me.gumenny.githubler.domain;

import android.support.annotation.NonNull;

import java.util.List;

import me.gumenny.githubler.domain.model.FullUser;
import me.gumenny.githubler.domain.model.Repo;
import me.gumenny.githubler.domain.model.User;
import rx.Observable;

/**
 * Created by arkadius on 8/29/17.
 */

public interface Repository {
    Observable<List<User>> getUsers(String query);

    Observable<FullUser> getFullUser(String login);

    @NonNull
    Observable<List<Repo>> getUserRepos(String login);
}
