package me.gumenny.githubler.presentation.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import me.gumenny.githubler.R;
import me.gumenny.githubler.domain.model.Repo;

/**
 * Created by arkadius on 8/30/17.
 */

public class RepoViewHolder extends BaseViewHolder<Repo> {
    TextView tvName;
    TextView tvCreatedAt;

    public RepoViewHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater, parent, R.layout.item_repo);
        tvName = (TextView) itemView.findViewById(R.id.tv_name);
        tvCreatedAt = (TextView) itemView.findViewById(R.id.tv_created);
    }

    @Override
    public void bind(Repo data) {
        tvName.setText(data.getName());
        tvCreatedAt.setText(data.getCreatedAt());
    }
}
