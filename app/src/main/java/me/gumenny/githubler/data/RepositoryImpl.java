package me.gumenny.githubler.data;

import android.support.annotation.NonNull;

import java.util.List;

import me.gumenny.githubler.data.entity.GetResult;
import me.gumenny.githubler.data.entity.RepoEntity;
import me.gumenny.githubler.data.entity.UserEntity;
import me.gumenny.githubler.data.mappers.Mapper;
import me.gumenny.githubler.data.mappers.MapperFactory;
import me.gumenny.githubler.data.rest.RestApi;
import me.gumenny.githubler.domain.Repository;
import me.gumenny.githubler.domain.model.FullUser;
import me.gumenny.githubler.domain.model.Repo;
import me.gumenny.githubler.domain.model.User;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by arkadius on 8/29/17.
 */

public class RepositoryImpl implements Repository {
    private RestApi restApi;
    private MapperFactory mapperFactory;

    public RepositoryImpl(RestApi restApi) {
        this.restApi = restApi;
        this.mapperFactory = new MapperFactory();
    }

    @Override
    public Observable<List<User>> getUsers(String query) {
        Mapper<UserEntity, User> userMapper = mapperFactory.getUserMapper();
        return restApi.searchUsers(query)
                .map(GetResult::getItems)
                .flatMapIterable(l -> l)
                .map(userMapper::transform)
                .toList();
    }

    @Override
    public Observable<FullUser> getFullUser(String login) {
        return restApi.getUserByLogin(login)
                .map(entity -> mapperFactory.getFullUserMapper().transform(entity))
                .flatMap(new Func1<FullUser, Observable<List<Repo>>>() {
                    @Override
                    public Observable<List<Repo>> call(FullUser fullUser) {
                        return getUserRepos(login);
                    }
                }, (fullUser, repos) -> {
                    fullUser.setRepositories(repos);
                    return fullUser;
                });
    }

    @NonNull
    @Override
    public Observable<List<Repo>> getUserRepos(String login) {
        Mapper<RepoEntity, Repo> repoMapper = mapperFactory.getRepoMapper();
        return restApi.getUserRepos(login)
                .flatMapIterable(l -> l)
                .map(repoMapper::transform)
                .toList();
    }
}
