package me.gumenny.githubler.data.rest;

import android.content.Context;

import java.util.List;

import me.gumenny.githubler.data.entity.GetResult;
import me.gumenny.githubler.data.entity.UserEntity;
import rx.Observable;

public class RestApi {
    private RetrofitApi api;
    private Context context;

    public RestApi(RetrofitApi api, Context context) {
        this.api = api;
        this.context = context;
    }

    public Observable<GetResult<UserEntity>> searchUsers(String query) {
        return api.searchUsers(query);
    }


}
