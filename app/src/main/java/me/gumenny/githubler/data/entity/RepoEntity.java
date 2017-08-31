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

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

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
