package me.gumenny.githubler.data.mappers;


import me.gumenny.githubler.data.entity.UserEntity;
import me.gumenny.githubler.domain.model.User;

public class MapperFactory {
    public Mapper<UserEntity, User> getUserMapper() {
        return obj -> new User(obj.getId(), obj.getLogin(), obj.getAvatarUrl());
    }
}
