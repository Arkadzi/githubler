package me.gumenny.githubler.presentation.adapter.viewholder;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import me.gumenny.githubler.R;
import me.gumenny.githubler.domain.model.FullUser;
import me.gumenny.githubler.presentation.utils.CircleTransform;

/**
 * Created by arkadius on 8/30/17.
 */

public class ProfileViewHolder extends BaseViewHolder<FullUser> {
    private ImageView ivAvatar;
    private TextView tvNickname;
    private TextView tvEmail;
    private TextView tvCompany;
    private TextView tvFollowers;
    private TextView tvFollowing;

    public ProfileViewHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater, parent, R.layout.item_profile);
        ivAvatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
        tvNickname = (TextView) itemView.findViewById(R.id.tv_nickname);
        tvEmail = (TextView) itemView.findViewById(R.id.tv_email);
        tvCompany = (TextView) itemView.findViewById(R.id.tv_company);
        tvFollowers = (TextView) itemView.findViewById(R.id.tv_followers);
        tvFollowing = (TextView) itemView.findViewById(R.id.tv_following);
        TextView tvEmailHint = (TextView) itemView.findViewById(R.id.tv_email_hint);
        TextView tvCompanyHint = (TextView) itemView.findViewById(R.id.tv_company_hint);
        TextView tvFollowersHint = (TextView) itemView.findViewById(R.id.tv_followers_hint);
        TextView tvFollowingHint = (TextView) itemView.findViewById(R.id.tv_following_hint);
        Resources resources = parent.getResources();
        tvEmailHint.setHint(String.format("%s:", resources.getString(R.string.hint_email)));
        tvCompanyHint.setHint(String.format("%s:", resources.getString(R.string.hint_company)));
        tvFollowersHint.setHint(String.format("%s:", resources.getString(R.string.hint_followers_count)));
        tvFollowingHint.setHint(String.format("%s:", resources.getString(R.string.hint_following_count)));
    }

    @Override
    public void bind(FullUser data) {
        Picasso.with(ivAvatar.getContext())
                .load(data.getAvatarUrl())
                .transform(new CircleTransform())
                .into(ivAvatar);
        tvNickname.setText(data.getLogin());
        tvEmail.setText(data.getEmail());
        tvCompany.setText(data.getCompany());
        tvFollowers.setText(String.valueOf(data.getFollowersCount()));
        tvFollowing.setText(String.valueOf(data.getFollowingCount()));
    }
}
