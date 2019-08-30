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
import com.squareup.picasso.Picasso;

import java.util.List;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    private List<Movie> movieList;
    public static final String IMAGE_URL_BASE_PATH="http://image.tmdb.org/t/p/w342//";


    public MoviesAdapter(List<Movie> movieList){
        this.movieList = movieList;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemList = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_movie, viewGroup, false);
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        Movie movie = movieList.get(position);
        String image_url = IMAGE_URL_BASE_PATH + movie.getPosterPath();
        Picasso.get().load(image_url).into(myViewHolder.poster);

        myViewHolder.title.setText(movie.getTitle());

    }

    @Override
    public int getItemCount() {
        return this.movieList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private  ImageView poster;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleId);
            poster = itemView.findViewById(R.id.posterId);
        }
    }
}
