package me.gumenny.githubler.presentation.presenter;


import me.gumenny.githubler.domain.subscribers.BaseProgressSubscriber;
import me.gumenny.githubler.presentation.utils.Messages;
import me.gumenny.githubler.presentation.view.ProgressView;

public class ProgressPresenter<V extends ProgressView> extends BasePresenter<V>
        implements BaseProgressSubscriber.ProgressSubscriberListener {


    public ProgressPresenter(Messages messages) {
        super(messages);
    }

    @Override
    public void onError(Throwable t) {
        V view = getView();
        if (view != null) {
            view.hideProgress();
            String error = getMessages().getError(t);
            view.showMessage(error);
        }
    }

    @Override
    public void onCompleted() {
        V view = getView();
        if (view != null) {
            view.hideProgress();
        }
    }

    @Override
    public void onStartLoading() {
        V view = getView();
        if (view != null) {
            view.showProgress();
        }
    }
}
