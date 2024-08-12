package com.example.myapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.myapp.adapter.BannerMoviesPagerAdapter;
import com.example.myapp.model.BannerMovies;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.ArrayDeque;

public class MainActivity extends AppCompatActivity {

    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout tabLayout;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> bannerMoviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();

        bannerMoviesList = new ArrayList<>();
        bannerMoviesList.add(new BannerMovies(1, "test", "", ""));
        bannerMoviesList.add(new BannerMovies(1, "test", "", ""));
        bannerMoviesList.add(new BannerMovies(1, "test", "", ""));
        bannerMoviesList.add(new BannerMovies(1, "test", "", ""));
        bannerMoviesList.add(new BannerMovies(1, "test", "", ""));

        setBannerMoviesPagerAdapter(bannerMoviesList);

    }
    public void getData(){
        Toast.makeText(getApplicationContext(),"Hello ",Toast.LENGTH_SHORT).show();
    }

    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMovies){

        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this, bannerMoviesList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);

    }
}