package com.example.myapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.myapp.adapter.BannerMoviesPagerAdapter;
import com.example.myapp.adapter.MainRecyclerAdapter;
import com.example.myapp.model.AllCategory;
import com.example.myapp.model.BannerMovies;
import com.example.myapp.model.CategoryItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout indicatorTab, categoryTab;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> homeBannerList;
    List<BannerMovies> tvShowsBannerList;
    List<BannerMovies> moviesBannerList;
    List<BannerMovies> kidsBannerList;

    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycler;
    List<AllCategory> allCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryTab = findViewById(R.id.tabLayout);
        indicatorTab = findViewById(R.id.tab_indicator);

        homeBannerList = new ArrayList<>();
        homeBannerList.add(new BannerMovies(1, "test1", "", ""));
        homeBannerList.add(new BannerMovies(2, "test2", "", ""));
        homeBannerList.add(new BannerMovies(3, "test3", "", ""));
        homeBannerList.add(new BannerMovies(4, "test4", "", ""));
        homeBannerList.add(new BannerMovies(5, "test5", "", ""));

        tvShowsBannerList = new ArrayList<>();
        tvShowsBannerList.add(new BannerMovies(1, "test1", "", ""));
        tvShowsBannerList.add(new BannerMovies(2, "test1", "", ""));
        tvShowsBannerList.add(new BannerMovies(3, "test1", "", ""));
        tvShowsBannerList.add(new BannerMovies(4, "test1", "", ""));

        moviesBannerList = new ArrayList<>();
        moviesBannerList.add(new BannerMovies(1, "test1", "", ""));
        moviesBannerList.add(new BannerMovies(2, "test1", "", ""));
        moviesBannerList.add(new BannerMovies(3, "test1", "", ""));
        moviesBannerList.add(new BannerMovies(4, "test1", "", ""));

        kidsBannerList = new ArrayList<>();
        kidsBannerList.add(new BannerMovies(1, "test1", "", ""));
        kidsBannerList.add(new BannerMovies(2, "test1", "", ""));
        kidsBannerList.add(new BannerMovies(3, "test1", "", ""));
        kidsBannerList.add(new BannerMovies(4, "test1", "", ""));

        setBannerMoviesPagerAdapter(homeBannerList);
        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        setBannerMoviesPagerAdapter(tvShowsBannerList);
                        return;
                    case 2:
                        setBannerMoviesPagerAdapter(moviesBannerList);
                        return;
                    case 3:
                        setBannerMoviesPagerAdapter(kidsBannerList);
                        return;
                    default:
                        setBannerMoviesPagerAdapter(homeBannerList);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //
        List<CategoryItem> homecatListItem1 =new  ArrayList<>();
        homecatListItem1.add(new CategoryItem(1,"","",""));
        homecatListItem1.add(new CategoryItem(2,"","",""));
        homecatListItem1.add(new CategoryItem(3,"","",""));
        homecatListItem1.add(new CategoryItem(4,"","",""));
        homecatListItem1.add(new CategoryItem(5,"","",""));

        //jem komecatlistitem1 banavi aem alag alag catogry mate banavani
        List<CategoryItem> homecatListItem2 =new  ArrayList<>();

        //movie in hindi
        homecatListItem2.add(new CategoryItem(1,"","",""));
        homecatListItem2.add(new CategoryItem(2,"","",""));
        homecatListItem2.add(new CategoryItem(3,"","",""));
        homecatListItem2.add(new CategoryItem(4,"","",""));
        homecatListItem2.add(new CategoryItem(5,"","",""));




        //kids and family movie
        List<CategoryItem> homecatListItem3 =new  ArrayList<>();
        homecatListItem3.add(new CategoryItem(1,"","",""));
        homecatListItem3.add(new CategoryItem(2,"","",""));
        homecatListItem3.add(new CategoryItem(3,"","",""));
        homecatListItem3.add(new CategoryItem(4,"","",""));
        homecatListItem3.add(new CategoryItem(5,"","",""));



        //Amazon Original series
        List<CategoryItem> homecatListItem4 =new  ArrayList<>();
        homecatListItem4.add(new CategoryItem(1,"","",""));
        homecatListItem4.add(new CategoryItem(2,"","",""));
        homecatListItem4.add(new CategoryItem(3,"","",""));
        homecatListItem4.add(new CategoryItem(4,"","",""));
        homecatListItem4.add(new CategoryItem(5,"","",""));



        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1,"Watch next Tv and movies",homecatListItem1));
        allCategoryList.add(new AllCategory(2,"Movies in Hindi",homecatListItem2));

        allCategoryList.add(new AllCategory(3,"Kids and family movies",homecatListItem3));
        allCategoryList.add(new AllCategory(4,"Amazon Original series",homecatListItem4));


        setMainRecycler(allCategoryList);

    }


    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMovies){

        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this, homeBannerList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager);

        Timer sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 4000, 6000);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager, true);

    }

    class AutoSlider extends TimerTask{

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(bannerMoviesViewPager.getCurrentItem()< homeBannerList.size()-1){
                        bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem()+1);
                    }
                    else{
                        bannerMoviesViewPager.setCurrentItem(0);
                    }
                }

            });

        }
    }

    public void setMainRecycler(List<AllCategory> allCategoryList){

        mainRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mainRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new  MainRecyclerAdapter(this, allCategoryList);
        mainRecycler.setAdapter(mainRecyclerAdapter);

    }
}