package me.gumenny.githubler.presentation.adapter.viewholder;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by arkadius on 8/30/17.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder{
    public BaseViewHolder(LayoutInflater inflater, ViewGroup parent, @LayoutRes int resId) {
        super(inflater.inflate(resId, parent, false));
    }

    public abstract void bind(T data);
}
