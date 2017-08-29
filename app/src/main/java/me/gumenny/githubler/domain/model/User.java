package me.gumenny.githubler.domain.model;

/**
 * Created by arkadius on 8/29/17.
 */

public class User {
    private String id;
    private String login;
    private String avatarUrl;

    public User(String id, String login, String avatarUrl) {
        this.id = id;
        this.login = login;
        this.avatarUrl = avatarUrl;
    }

    public String getId() {
        return id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getLogin() {
        return login;
    }
}
