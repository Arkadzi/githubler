package me.gumenny.githubler.presentation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.gumenny.githubler.R;
import me.gumenny.githubler.app.Application;
import me.gumenny.githubler.domain.model.User;
import me.gumenny.githubler.presentation.adapter.UserAdapter;
import me.gumenny.githubler.presentation.presenter.SearchPresenter;
import me.gumenny.githubler.presentation.view.UserSearchView;

/**
 * Created by arkadius on 8/29/17.
 */

public class SearchFragment extends Fragment implements UserSearchView, SearchView.OnQueryTextListener {
    public static final String ARG_QUERY = "arg_query";
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    @Bind(R.id.progress_bar)
    ProgressBar progressBar;
    @Bind(R.id.empty_view)
    View emptyView;
    private SearchView searchView;
    private UserAdapter adapter;
    @Inject
    SearchPresenter presenter;
    @Nullable
    private List<User> users;
    private String lastQuery;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Application.getApp(getActivity()).getUserComponent().inject(this);
        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new UserAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        renderList(users);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.onCreate(this);
        if (savedInstanceState != null) {
            lastQuery = savedInstanceState.getString(ARG_QUERY);
        }
    }

    @Override
    public void onDestroyView() {
        presenter.onRelease();
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(ARG_QUERY, searchView.getQuery().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(SearchFragment.this);
        if (!TextUtils.isEmpty(lastQuery)) {
            MenuItemCompat.expandActionView(item);
            searchView.setQuery(lastQuery, false);
            searchView.clearFocus();
        }

        MenuItemCompat.setOnActionExpandListener(item, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                presenter.onSearchCollapsed();
                return true;
            }
        });
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        presenter.onSearchSubmit(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        emptyView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void renderList(@Nullable List<User> users) {
        this.users = users;
        if (users == null) {
            users = new ArrayList<>();
        }
        adapter.setData(users);
        emptyView.setVisibility(users.isEmpty() ? View.VISIBLE : View.GONE);
    }
}
