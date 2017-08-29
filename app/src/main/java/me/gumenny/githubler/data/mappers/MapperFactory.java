package me.gumenny.githubler.data.mappers;


import me.gumenny.githubler.data.entity.UserEntity;
import me.gumenny.githubler.domain.model.User;

public class MapperFactory {
    public Mapper<UserEntity, User> getUserMapper() {
        return new Mapper<UserEntity, User>() {
            @Override
            public User transform(UserEntity obj) throws RuntimeException {
                return null;
            }
        };
    }
}
