package com.joaoPaulo.cubosentryfee.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.joaoPaulo.cubosentryfee.R;
import com.joaoPaulo.cubosentryfee.activity.MainActivity;
import com.joaoPaulo.cubosentryfee.helper.InitializeList;
import com.joaoPaulo.cubosentryfee.rest.API;

public class ActionFragment extends Fragment {
    private InitializeList init = new InitializeList();

    public ActionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_action, container, false);
        MainActivity main = (MainActivity) getActivity();
        init.onCreate(view, main, R.id.recyclerActionId, API.initRetrofit().getActionMovies(API.KEY));
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_movies, menu);
        super.onCreateOptionsMenu(menu, inflater);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                init.getMoviesAdapter().getFilter().filter(s);
                return false;
            }
        });
    }
}
