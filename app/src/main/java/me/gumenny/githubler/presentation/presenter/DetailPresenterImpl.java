package me.gumenny.githubler.presentation.presenter;

import android.support.annotation.NonNull;

import me.gumenny.githubler.domain.model.FullUser;
import me.gumenny.githubler.domain.subscribers.BaseProgressSubscriber;
import me.gumenny.githubler.domain.usecase.GetFullUserUseCase;
import me.gumenny.githubler.presentation.utils.Messages;
import me.gumenny.githubler.presentation.view.DetailView;

/**
 * Created by arkadius on 8/30/17.
 */

public class DetailPresenterImpl extends ProgressPresenter<DetailView> implements DetailPresenter {
    private GetFullUserUseCase getFullUserUseCase;

    public DetailPresenterImpl(Messages messages, GetFullUserUseCase getFullUserUseCase) {
        super(messages);
        this.getFullUserUseCase = getFullUserUseCase;
    }

    @Override
    public void onCreate(DetailView view) {
        super.onCreate(view);
        if (view.getUser() == null) {
            getFullUserUseCase.setLogin(view.getLogin());
            getFullUserUseCase.execute(getSubscriber());
        } else if(getFullUserUseCase.isWorking()) {
            getFullUserUseCase.execute(getSubscriber());
        }
    }

    @Override
    public void onRelease() {
        getFullUserUseCase.unsubscribe();
        super.onRelease();
    }

    @Override
    public void onErrorViewClick() {
        DetailView view = getView();
        if (view != null) {
            getFullUserUseCase.setLogin(view.getLogin());
            getFullUserUseCase.execute(getSubscriber());
        }
    }

    @NonNull
    private BaseProgressSubscriber<FullUser> getSubscriber() {
        return new BaseProgressSubscriber<FullUser>(this) {
            @Override
            public void onNext(FullUser response) {
                super.onNext(response);
                DetailView view = getView();
                if (view != null) {
                    view.renderUser(response);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                DetailView view = getView();
                if (view != null) {
                    view.renderErrorView();
                }
            }
        };
    }
}
