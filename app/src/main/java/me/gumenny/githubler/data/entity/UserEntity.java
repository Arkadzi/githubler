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
    private String company;
    private String email;
    @SerializedName("followers")
    private int followersCount;
    @SerializedName("following")
    private int followingCount;
    private String name;

    public String getLogin() {
        return login;
    }

    public String getId() {
        return id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
