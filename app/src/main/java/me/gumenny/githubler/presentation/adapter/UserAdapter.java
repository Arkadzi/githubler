package me.gumenny.githubler.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.gumenny.githubler.domain.model.User;
import me.gumenny.githubler.presentation.adapter.viewholder.UserViewHolder;

/**
 * Created by arkadius on 8/29/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private final LayoutInflater inflater;
    private final List<User> data = new ArrayList<>();

    public UserAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    public void setData(List<User> data) {
        this.data.clear();
        this.data.addAll(data);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
