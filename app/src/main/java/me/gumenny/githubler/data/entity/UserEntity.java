package me.gumenny.githubler.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by arkadius on 8/29/17.
 */

public class UserEntity {
    String login;
    String id;
    @SerializedName("avatar_url")
    String avatarUrl;

    public String getLogin() {
        return login;
    }

    public String getId() {
        return id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
