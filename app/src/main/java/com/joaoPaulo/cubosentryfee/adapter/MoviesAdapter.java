package com.joaoPaulo.cubosentryfee.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.joaoPaulo.cubosentryfee.model.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter {
    public MoviesAdapter(List<Movie> movies, int list_item_movie, Context applicationContext) {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
