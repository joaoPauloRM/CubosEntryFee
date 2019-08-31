package com.joaoPaulo.cubosentryfee.helper;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.view.View;
import android.widget.AdapterView;

import com.joaoPaulo.cubosentryfee.activity.MovieInformation;
import com.joaoPaulo.cubosentryfee.adapter.MoviesAdapter;
import com.joaoPaulo.cubosentryfee.model.Movie;
import com.joaoPaulo.cubosentryfee.model.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class InitializeList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Movie> movies = new ArrayList<>();
    private MoviesAdapter moviesAdapter;

    public MoviesAdapter getMoviesAdapter() {
        return moviesAdapter;
    }

    public void onCreate(View view, final Context context , Integer recyclerId, Call<MovieResponse> call) {

        recyclerView = view.findViewById(recyclerId);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(context, 2);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(context,
                recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Movie selectedMovie = movies.get(position);
                Intent intent = new Intent(context, MovieInformation.class);
                intent.putExtra("selectedMovie", selectedMovie);
                context.startActivity(intent);

            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));


        call.enqueue(new Callback<MovieResponse>() {

            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                movies = response.body().getMovieList();
                moviesAdapter = new MoviesAdapter(movies);
                recyclerView.setAdapter(moviesAdapter);
                Log.i("INFO", "Movies" + movies.size());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.i("ERROR", t.toString());
            }
        });
    }



}
