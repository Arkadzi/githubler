package me.gumenny.githubler.presentation.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import me.gumenny.githubler.domain.model.FullUser;
import me.gumenny.githubler.domain.subscribers.BaseProgressSubscriber;
import me.gumenny.githubler.domain.usecase.GetFullUserUseCase;
import me.gumenny.githubler.presentation.utils.Messages;
import me.gumenny.githubler.presentation.view.DetailView;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by arkadius on 8/31/17.
 */

public class DetailPresenterImplTest {

    private DetailPresenterImpl detailPresenter;

    @Mock DetailView mockDetailView;
    @Mock GetFullUserUseCase mockGetFullUserUseCase;
    @Mock Messages mockMessages;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        detailPresenter = new DetailPresenterImpl(mockMessages, mockGetFullUserUseCase);
    }

    @Test
    public void testUserDetailsPresenterFirstCreate() {
        when(mockDetailView.getLogin()).thenReturn("login");
        when(mockDetailView.getUser()).thenReturn(null);
        detailPresenter.onCreate(mockDetailView);
        verify(mockGetFullUserUseCase).execute(any(BaseProgressSubscriber.class));
    }

    @Test
    public void testUserDetailsPresenterWhenUserLoadedFirstCreate() {
        when(mockDetailView.getLogin()).thenReturn("login");
        when(mockDetailView.getUser()).thenReturn(new FullUser());
        detailPresenter.onCreate(mockDetailView);
        verify(mockGetFullUserUseCase, never()).execute(any(BaseProgressSubscriber.class));
    }

    @Test
    public void testUserDetailsPresenterOnErrorViewClick() {
        when(mockDetailView.getLogin()).thenReturn("login");
        when(mockDetailView.getUser()).thenReturn(new FullUser());
        detailPresenter.onCreate(mockDetailView);
        detailPresenter.onErrorViewClick();
        verify(mockGetFullUserUseCase).execute(any(BaseProgressSubscriber.class));
    }

    @Test
    public void testUserDetailsPresenterOnRelease() {
        when(mockDetailView.getLogin()).thenReturn("login");
        when(mockDetailView.getUser()).thenReturn(new FullUser());
        detailPresenter.onCreate(mockDetailView);
        detailPresenter.onRelease();
        verify(mockGetFullUserUseCase).unsubscribe();
    }
}
