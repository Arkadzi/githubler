package me.gumenny.githubler.presentation.fragment;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import me.gumenny.githubler.domain.model.FullUser;
import me.gumenny.githubler.presentation.adapter.viewholder.BaseViewHolder;
import me.gumenny.githubler.presentation.adapter.viewholder.ProfileViewHolder;
import me.gumenny.githubler.presentation.adapter.viewholder.RepoViewHolder;

/**
 * Created by arkadius on 8/30/17.
 */

public class ProfileAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public static final int TYPE_PROFILE = 1;
    public static final int TYPE_REPO = 0;
    private final LayoutInflater inflater;
    @Nullable
    private FullUser user;

    public ProfileAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_PROFILE;
        }
        return TYPE_REPO;
    }

    public void setUser(@Nullable FullUser user) {
        this.user = user;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_PROFILE) {
            return new ProfileViewHolder(inflater, parent);
        }
        return new RepoViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (holder instanceof ProfileViewHolder) {
            ((ProfileViewHolder) holder).bind(user);
        } else if (holder instanceof RepoViewHolder) {
            ((RepoViewHolder) holder).bind(user.getRepositories().get(position - 1));
        }
    }

    @Override
    public int getItemCount() {
        return user == null ? 0 : user.getRepositories().size() + 1;
    }
}
