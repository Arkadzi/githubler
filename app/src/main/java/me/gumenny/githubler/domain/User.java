package me.gumenny.githubler.domain;

/**
 * Created by arkadius on 8/29/17.
 */

public class User {
    private String nickname;
    private String avatarUrl;

    public User(String nickname, String avatarUrl) {
        this.nickname = nickname;
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getNickname() {
        return nickname;
    }
}
