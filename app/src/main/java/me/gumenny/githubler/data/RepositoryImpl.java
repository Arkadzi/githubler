package me.gumenny.githubler.data;

import java.util.ArrayList;
import java.util.List;

import me.gumenny.githubler.data.entity.GetResult;
import me.gumenny.githubler.data.entity.UserEntity;
import me.gumenny.githubler.data.mappers.Mapper;
import me.gumenny.githubler.data.mappers.MapperFactory;
import me.gumenny.githubler.data.rest.RestApi;
import me.gumenny.githubler.domain.Repository;
import me.gumenny.githubler.domain.model.FullUser;
import me.gumenny.githubler.domain.model.User;
import rx.Observable;

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
        return null;
    }
}
