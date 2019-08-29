package com.joaoPaulo.cubosentryfee.helper;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.joaoPaulo.cubosentryfee.adapter.MoviesAdapter;
import com.joaoPaulo.cubosentryfee.model.Movie;
import com.joaoPaulo.cubosentryfee.model.MovieResponse;
import com.joaoPaulo.cubosentryfee.rest.MovieApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitializeList {
    private RecyclerView recyclerView;
    private List<Movie> movies = new ArrayList<>();
    private MoviesAdapter moviesAdapter;

    public void onCreate(View view, final Context context, Integer recyclerId, Call<MovieResponse> call) {

        recyclerView = view.findViewById(recyclerId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), LinearLayout.VERTICAL));

        call.enqueue(new Callback<MovieResponse>() {

            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                movies = response.body().getMovieList();
                moviesAdapter = new MoviesAdapter(movies, context);
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
