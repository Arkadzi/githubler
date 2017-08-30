package me.gumenny.githubler.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by arkadius on 8/30/17.
 */

public class RepoEntity {
    private String id;
    private String name;
    @SerializedName("created_at")
    private String createdAt;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
