package com.arkainfoteck.kahani.Activity;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.arkainfoteck.kahani.Adapter.ViewPagerAdapter;
import com.arkainfoteck.kahani.Fragments.Home;
import com.arkainfoteck.kahani.R;

public class FullContent extends AppCompatActivity {

    ViewPager viewPager;
    PagerAdapter adapter;
    int[] rank;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from viewpager_main.xml
        setContentView(R.layout.activity_full_content);

        // Generate sample data
        rank = new int[] { R.string.storie,R.string.storie,R.string.storie,R.string.storie,R.string.storie  };



        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.content);
        // Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(FullContent.this, rank);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);

    }
}

