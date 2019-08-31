package com.joaoPaulo.cubosentryfee.activity;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.joaoPaulo.cubosentryfee.R;
import com.joaoPaulo.cubosentryfee.model.Movie;
import com.joaoPaulo.cubosentryfee.rest.API;
import com.squareup.picasso.Picasso;

public class MovieInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Movie currentMovie;
        setContentView(R.layout.activity_movie_information);
        TextView overView = findViewById(R.id.infoOverviewId);
        ImageView poster_path = findViewById(R.id.infoImageId);
        getSupportActionBar().setTitle("MovieInformation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        currentMovie = (Movie) getIntent().getSerializableExtra("selectedMovie");

        if(currentMovie!=null){
            overView.setText(currentMovie.getOverview());
            String image_url = API.IMAGE_URL_BASE_PATH + currentMovie.getBackDropPath();
            Picasso.get().load(image_url).into(poster_path);
        }
    }


}
