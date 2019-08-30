package com.joaoPaulo.cubosentryfee.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joaoPaulo.cubosentryfee.R;
import com.joaoPaulo.cubosentryfee.helper.InitializeList;
import com.joaoPaulo.cubosentryfee.rest.API;

public class FantasiaFragment extends Fragment {

    public FantasiaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fantasia, container, false);

        InitializeList recycler = new InitializeList();
        recycler.onCreate(view, getActivity(), R.id.recyclerFantasyId, API.initRetrofit().getFantasyMovies(API.API_KEY) );

        return view;
    }

}


