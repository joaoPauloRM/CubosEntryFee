package com.joaoPaulo.cubosentryfee.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.joaoPaulo.cubosentryfee.R;
import com.joaoPaulo.cubosentryfee.adapter.MoviesAdapter;
import com.joaoPaulo.cubosentryfee.fragment.ActionFragment;
import com.joaoPaulo.cubosentryfee.fragment.DramaFragment;
import com.joaoPaulo.cubosentryfee.fragment.FantasiaFragment;
import com.joaoPaulo.cubosentryfee.fragment.FictionFragment;
import com.joaoPaulo.cubosentryfee.rest.MovieApiService;
import com.joaoPaulo.cubosentryfee.model.Movie;
import com.joaoPaulo.cubosentryfee.model.MovieResponse;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setElevation(0);


        viewPager = findViewById(R.id.viewpager);
        smartTabLayout = findViewById(R.id.viewpagertab);

        FragmentPagerItemAdapter viewPagerAdapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Ação", ActionFragment.class)
                        .add("Drama", DramaFragment.class)
                        .add("Fantasia", FantasiaFragment.class)
                        .add("Ficção", FictionFragment.class)
                        .create()
        );

        viewPager.setAdapter(viewPagerAdapter);
        smartTabLayout.setViewPager(viewPager);
    }


}
