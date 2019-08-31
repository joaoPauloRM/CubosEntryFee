package com.joaoPaulo.cubosentryfee.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.joaoPaulo.cubosentryfee.R;
import com.joaoPaulo.cubosentryfee.fragment.ActionFragment;
import com.joaoPaulo.cubosentryfee.fragment.DramaFragment;
import com.joaoPaulo.cubosentryfee.fragment.FantasiaFragment;
import com.joaoPaulo.cubosentryfee.fragment.FictionFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setElevation(0);

        ViewPager viewPager = findViewById(R.id.viewpager);
        SmartTabLayout smartTabLayout = findViewById(R.id.viewpagertab);

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
