package me.gumenny.githubler.domain.model;

/**
 * Created by arkadius on 8/30/17.
 */

public class Repo {
    private String id;
    private String name;
    private String createdAt;

    public Repo(String id, String name, String createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getName() {
        return name;
    }
}
