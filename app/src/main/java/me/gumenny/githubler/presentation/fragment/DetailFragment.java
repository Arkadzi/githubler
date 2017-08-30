package me.gumenny.githubler.presentation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.gumenny.githubler.R;
import me.gumenny.githubler.app.Application;
import me.gumenny.githubler.domain.model.FullUser;
import me.gumenny.githubler.presentation.view.DetailView;


/**
 * Created by arkadius on 8/30/17.
 */

public class DetailFragment extends Fragment implements DetailView {

    public static final String ARG_USER_LOGIN = "arg_user_login";
    @Bind(R.id.error_view)
    View errorView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    @Bind(R.id.progress_bar)
    ProgressBar progressBar;
    private ProfileAdapter adapter;
    @Nullable
    private FullUser user;

    public static DetailFragment newInstance(String login) {

        Bundle args = new Bundle();
        args.putString(ARG_USER_LOGIN, login);

        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Application.getApp(getActivity()).getUserComponent().inject(this);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this, view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ProfileAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        if (user != null) {
            renderUser(user);
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }


    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        errorView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void renderUser(FullUser fullUser) {
        this.user = fullUser;
        adapter.setUser(fullUser);
    }

    @Override
    public void renderErrorView() {
        errorView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
    }

    @Nullable
    @Override
    public FullUser getUser() {
        return user;
    }

    @Override
    public String getLogin() {
        return getArguments().getString(ARG_USER_LOGIN);
    }
}
