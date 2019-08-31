package com.joaoPaulo.cubosentryfee.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    public static final String IMAGE_URL_BASE_PATH="http://image.tmdb.org/t/p/w342//";
    public static final String KEY = "91ee4a0639ac8f28f717bdaa467ab393";

    public static MovieApiService initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(MovieApiService.class);
    }


}
