package me.gumenny.githubler.data.rest;


import java.util.List;

import me.gumenny.githubler.data.entity.GetResult;
import me.gumenny.githubler.data.entity.UserEntity;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface RetrofitApi {

    @GET("search/users")
    Observable<GetResult<UserEntity>> searchUsers(@Query("q") String query);
}
