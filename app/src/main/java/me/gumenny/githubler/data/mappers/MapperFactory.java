package me.gumenny.githubler.data.mappers;


import me.gumenny.githubler.data.entity.RepoEntity;
import me.gumenny.githubler.data.entity.UserEntity;
import me.gumenny.githubler.domain.model.FullUser;
import me.gumenny.githubler.domain.model.Repo;
import me.gumenny.githubler.domain.model.User;

public class MapperFactory {
    public Mapper<UserEntity, User> getUserMapper() {
        return obj -> new User(obj.getId(), obj.getLogin(), obj.getAvatarUrl());
    }

    public Mapper<UserEntity, FullUser> getFullUserMapper() {
        return obj -> new FullUser(
                obj.getId(),
                obj.getLogin(),
                obj.getAvatarUrl(),
                obj.getName(),
                obj.getCompany(),
                obj.getEmail(),
                obj.getFollowersCount(),
                obj.getFollowingCount());
    }

    public Mapper<RepoEntity, Repo> getRepoMapper() {
        return obj -> new Repo(obj.getId(), obj.getName(), obj.getCreatedAt());
    }
}
