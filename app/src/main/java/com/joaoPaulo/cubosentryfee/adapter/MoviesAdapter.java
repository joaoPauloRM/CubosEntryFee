package com.joaoPaulo.cubosentryfee.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.joaoPaulo.cubosentryfee.R;
import com.joaoPaulo.cubosentryfee.model.Movie;
import com.joaoPaulo.cubosentryfee.rest.API;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> implements Filterable {
    private List<Movie> movieList;
    private List<Movie> movieListFull;


    public MoviesAdapter(List<Movie> movieList){
        this.movieList = movieList;
        movieListFull = new ArrayList<>(movieList);
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
        String image_url = API.IMAGE_URL_BASE_PATH + movie.getPosterPath();
        Picasso.get().load(image_url).into(myViewHolder.poster);

        myViewHolder.title.setText(movie.getTitle());

    }

    @Override
    public int getItemCount() {
        return this.movieList.size();
    }


    protected class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private  ImageView poster;

        protected MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleId);
            poster = itemView.findViewById(R.id.posterId);
        }
    }

    @Override
    public Filter getFilter() {
        return movieFilter;
    }

    private Filter movieFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Movie> filteredList = new ArrayList<>();
            if(constraint == null || constraint.length()==0){
                filteredList.addAll(movieListFull);
            }else{
                String filterPatter = constraint.toString().toLowerCase().trim();
                for (Movie movie: movieListFull
                     ) {
                    if(movie.getTitle().toLowerCase().contains(filterPatter)){
                        filteredList.add(movie);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            movieList.clear();
            movieList.addAll((List)results.values);
            notifyDataSetChanged();

        }
    };
}
