package com.joaoPaulo.cubosentryfee.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("overview")
    @Expose
    private String overview;

    @SerializedName("poster_path")
    @Expose
    private String posterPath;

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {

        return title;
    }

    public String getOverview() {
        return overview;
    }

}
