package me.gumenny.githubler.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arkadius on 8/30/17.
 */

public class FullUser extends User {

    private List<Repo> repositories;
    private String name;
    private String company;
    private String email;
    private int followersCount;
    private int followingCount;

    public FullUser(String id, String login, String avatarUrl, String name, String company, String email, int followersCount, int followingCount) {
        super(id, login, avatarUrl);
        repositories = new ArrayList<>();
        this.name = name;
        this.company = company;
        this.email = email;
        this.followersCount = followersCount;
        this.followingCount = followingCount;
    }


    public List<Repo> getRepositories() {
        return repositories;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public void setRepositories(List<Repo> repositories) {
        this.repositories = repositories;
    }
}
