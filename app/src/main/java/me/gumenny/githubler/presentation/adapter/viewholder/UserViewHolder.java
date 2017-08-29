package me.gumenny.githubler.presentation.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import me.gumenny.githubler.R;
import me.gumenny.githubler.domain.model.User;

/**
 * Created by arkadius on 8/29/17.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {

    private final ImageView ivAvatar;
    private final TextView tvNickname;

    public UserViewHolder(LayoutInflater layoutInflater, ViewGroup parent) {
        super(layoutInflater.inflate(R.layout.item_user, parent, false));
        ivAvatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
        tvNickname = (TextView) itemView.findViewById(R.id.tv_nickname);
    }

    public void bind(User user) {
        Picasso.with(ivAvatar.getContext())
                .load(user.getAvatarUrl())
                .into(ivAvatar);
        tvNickname.setText(user.getLogin());
    }
}
