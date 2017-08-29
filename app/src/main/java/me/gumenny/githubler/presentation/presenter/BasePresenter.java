package me.gumenny.githubler.presentation.presenter;


import android.support.annotation.Nullable;

import me.gumenny.githubler.presentation.utils.Messages;
import me.gumenny.githubler.presentation.view.View;


public class BasePresenter<V extends View> implements Presenter<V> {
    @Nullable
    private V view;
    private Messages messages;

    public BasePresenter(Messages messages) {
        this.messages = messages;
    }

    @Nullable
    public V getView() {
        return view;
    }

    @Override
    public void onCreate(V view) {
        this.view = view;
    }

    @Override
    public void onRelease() {
        view = null;
    }

    public Messages getMessages() {
        return messages;
    }

    protected void showMessage(int messageId) {
        showMessage(messages.convertError(messageId));
    }

    protected void showMessage(String message) {
        V view = getView();
        if (view != null) {
            view.showMessage(message);
        }
    }
}
