package me.gumenny.githubler.domain.usecase;

import android.util.Log;

import me.gumenny.githubler.domain.schedulers.ObserveOn;
import me.gumenny.githubler.domain.schedulers.SubscribeOn;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public abstract class UseCase<T> {
    private SubscribeOn subscribeOn;
    private ObserveOn observeOn;
    private Subscription subscription = Subscriptions.empty();
    private Observable<T> observable;

    public UseCase(SubscribeOn subscribeOn, ObserveOn observeOn) {
        this.subscribeOn = subscribeOn;
        this.observeOn = observeOn;
    }

    public void execute(Subscriber<T> subscriber) {
        Log.e("subscription", "subscribe " + getClass() + " " + observable);
        if (observable == null)
            observable = getUseCaseObservable()
                    .subscribeOn(subscribeOn.getScheduler())
                    .observeOn(observeOn.getScheduler())
                    .cache()
                    .doOnError((t) -> observable = null)
                    .doOnCompleted(() -> observable = null);
        subscription = observable.subscribe(subscriber);
    }

    protected abstract Observable<T> getUseCaseObservable();

    public boolean isWorking() {
        return observable != null;
    }

    public void unsubscribe() {
        Log.e("subscription", "unsubscribe " + getClass());
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    public void stopExecution() {
        unsubscribe();
        observable = null;
    }
}
