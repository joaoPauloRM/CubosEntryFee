package com.joaoPaulo.cubosentryfee.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;


import com.joaoPaulo.cubosentryfee.R;
import com.joaoPaulo.cubosentryfee.adapter.MoviesAdapter;
import com.joaoPaulo.cubosentryfee.fragment.ActionFragment;
import com.joaoPaulo.cubosentryfee.fragment.DramaFragment;
import com.joaoPaulo.cubosentryfee.fragment.FantasiaFragment;
import com.joaoPaulo.cubosentryfee.fragment.FictionFragment;

import com.joaoPaulo.cubosentryfee.helper.InitializeList;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;


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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_movies, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                return false;
            }
        });
        return true;
    }
}
