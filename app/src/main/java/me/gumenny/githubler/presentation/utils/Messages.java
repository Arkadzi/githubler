package me.gumenny.githubler.presentation.utils;

import android.content.Context;
import android.support.annotation.StringRes;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.inject.Inject;
import javax.inject.Singleton;

import me.gumenny.githubler.R;
import retrofit2.adapter.rxjava.HttpException;


/**
 * Created by sebastian on 21.06.16.
 */
@Singleton
public class Messages {

    private Context c;

    @Inject
    public Messages(Context c) {
        this.c = c;
    }

    public String getError(Throwable e) {
        if (e instanceof SocketTimeoutException
                || e instanceof ConnectException
                || e instanceof UnknownHostException) {
            return c.getString(R.string.error_check_network_connection);
        }
        return e.getMessage();
    }


    public String convertError(@StringRes int messageId) {
        return c.getString(messageId);
    }
}
