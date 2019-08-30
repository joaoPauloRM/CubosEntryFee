package com.joaoPaulo.cubosentryfee.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joaoPaulo.cubosentryfee.R;
import com.joaoPaulo.cubosentryfee.helper.InitializeList;
import com.joaoPaulo.cubosentryfee.rest.API;

public class FictionFragment extends Fragment {

    public FictionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fiction, container, false);

        InitializeList recycler = new InitializeList();
        recycler.onCreate(view, getActivity(), R.id.recyclerFictionId, API.initRetrofit().getFictionMovies(API.API_KEY));

        return view;
    }



}


