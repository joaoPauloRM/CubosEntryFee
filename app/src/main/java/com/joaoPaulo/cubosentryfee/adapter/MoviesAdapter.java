package com.joaoPaulo.cubosentryfee.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.joaoPaulo.cubosentryfee.R;
import com.joaoPaulo.cubosentryfee.model.Movie;

import java.util.List;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    private List<Movie> movieList;
    private  Context context;

    public MoviesAdapter(List<Movie> movieList, Context context){
        this.movieList = movieList;
        this.context=context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemList = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_movie, viewGroup, false);
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Movie movie = movieList.get(i);
        myViewHolder.title.setText(movie.getTitle());

    }

    @Override
    public int getItemCount() {
        return this.movieList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleId);
        }
    }
}
