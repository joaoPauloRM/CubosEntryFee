package com.joaoPaulo.cubosentryfee.rest;

import com.joaoPaulo.cubosentryfee.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {
    @GET("discover/movie?with_genres=28")
    Call<MovieResponse> getActionMovies(@Query("api_key") String apiKey);

    @GET("discover/movie?with_genres=18")
    Call<MovieResponse> getDramaMovies(@Query("api_key") String apiKey);

    @GET("discover/movie?with_genres=14")
    Call<MovieResponse> getFantasyMovies(@Query("api_key") String apiKey);

    @GET("discover/movie?with_genres=878")
    Call<MovieResponse> getFictionMovies(@Query("api_key") String apiKey);


}

