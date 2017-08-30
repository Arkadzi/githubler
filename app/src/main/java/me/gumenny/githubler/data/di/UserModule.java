package me.gumenny.githubler.data.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import me.gumenny.githubler.data.RepositoryImpl;
import me.gumenny.githubler.data.di.scope.UserScope;
import me.gumenny.githubler.data.mappers.MapperFactory;
import me.gumenny.githubler.data.rest.RestApi;
import me.gumenny.githubler.data.rest.RetrofitApi;
import me.gumenny.githubler.domain.Repository;
import me.gumenny.githubler.domain.usecase.GetFullUserUseCase;
import me.gumenny.githubler.domain.usecase.SearchUsersUseCase;
import me.gumenny.githubler.presentation.presenter.DetailPresenter;
import me.gumenny.githubler.presentation.presenter.DetailPresenterImpl;
import me.gumenny.githubler.presentation.presenter.SearchPresenter;
import me.gumenny.githubler.presentation.presenter.SearchPresenterImpl;
import me.gumenny.githubler.presentation.utils.Messages;
import retrofit2.Retrofit;
/**
 * Created by arkadii on 3/5/17.
 */

@Module
public class UserModule {
    @Provides
    @UserScope
    public RestApi provideRestApi(Retrofit retrofit, Context context) {
        return new RestApi(retrofit.create(RetrofitApi.class), context);
    }

    @Provides
    @UserScope
    public Repository provideRepository(RestApi restApi) {
        return new RepositoryImpl(restApi);
    }

    @Provides
    @UserScope
    public SearchPresenter provideSearchPresenter(Messages messages,
                                                  SearchUsersUseCase searchUsersUseCase) {
        return new SearchPresenterImpl(messages, searchUsersUseCase);
    }

    @Provides
    @UserScope
    public DetailPresenter provideDetailPresenter(Messages messages,
                                                  GetFullUserUseCase getFullUserUseCase) {
        return new DetailPresenterImpl(messages, getFullUserUseCase);
    }

}
