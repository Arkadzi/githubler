package me.gumenny.githubler.data;

import android.support.annotation.NonNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import me.gumenny.githubler.data.entity.GetResult;
import me.gumenny.githubler.data.entity.UserEntity;
import me.gumenny.githubler.data.rest.RestApi;
import me.gumenny.githubler.domain.model.User;
import rx.Observable;
import rx.observers.TestSubscriber;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyString;

/**
 * Created by arkadius on 8/31/17.
 */

public class RepositoryImplTest {
    @Mock
    RestApi restApi;
    private RepositoryImpl repository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        repository = new RepositoryImpl(restApi);
    }

    @Test
    public void whenSearchUsersSuccessThenReturnUser() {
        Mockito.when(restApi.searchUsers(anyString())).thenReturn(Observable.just(getValidGetResult()));
        TestSubscriber<List<User>> subscriber = new TestSubscriber<>();
        repository.getUsers("").subscribe(subscriber);
        subscriber.awaitTerminalEvent();
        assertEquals(subscriber.getOnNextEvents().size(), 1);
    }

    @Test
    public void whenSearchUsersFailureThenReturnError() {
        Mockito.when(restApi.searchUsers(anyString())).thenReturn(Observable.error(new RuntimeException()));
        TestSubscriber<List<User>> subscriber = new TestSubscriber<>();
        repository.getUsers("").subscribe(subscriber);
        subscriber.awaitTerminalEvent();
        assertEquals(subscriber.getOnErrorEvents().size(), 1);
    }

    @NonNull
    private GetResult<UserEntity> getValidGetResult() {
        GetResult<UserEntity> getResult = new GetResult<>();
        ArrayList<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity());
        getResult.setItems(userEntities);
        return getResult;
    }
    // TODO: 8/31/17 add tests for other methods
}
