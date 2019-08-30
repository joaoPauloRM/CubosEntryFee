package com.joaoPaulo.cubosentryfee.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Movie implements Serializable {
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("overview")
    @Expose
    private String overview;

    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("backdrop_path")
    @Expose
    private String backDropPath;

    public String getBackDropPath() {
        return backDropPath;
    }

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
