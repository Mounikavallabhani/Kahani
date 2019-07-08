package com.arkainfoteck.kahani.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arkainfoteck.kahani.Adapter.TopStoriesAdapter;
import com.arkainfoteck.kahani.Model.TopSeries;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class GenersDescriptionActivity extends AppCompatActivity {
    RecyclerView topstoriesrecyclerview,lateststories;
    TopStoriesAdapter topStoriesAdapter;
    ArrayList<TopSeries>topSeries;
    GridLayoutManager gridLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geners_description);
        topstoriesrecyclerview=findViewById(R.id.topstoriesrecyclerview);
        gridLayoutManager=new GridLayoutManager(getApplicationContext(),2);
        topstoriesrecyclerview.setLayoutManager(gridLayoutManager);
        topSeries=new ArrayList<>();
        topSeries.add(new TopSeries(R.drawable.dammy,"mounika","narasimha","1 min","1","1"));
        topSeries.add(new TopSeries(R.drawable.dammy,"mounika","narasimha","1 min","1","1"));
        topSeries.add(new TopSeries(R.drawable.dammy,"mounika","narasimha","1 min","1","1"));
        topSeries.add(new TopSeries(R.drawable.dammy,"mounika","narasimha","1 min","1","1"));
          topStoriesAdapter=new TopStoriesAdapter(getApplicationContext(),topSeries);
          topstoriesrecyclerview.setAdapter(topStoriesAdapter);


        lateststories=findViewById(R.id.lateststories);
        gridLayoutManager=new GridLayoutManager(getApplicationContext(),2);
        lateststories.setLayoutManager(gridLayoutManager);
        topSeries=new ArrayList<>();
        topSeries.add(new TopSeries(R.drawable.dammy,"mounika","narasimha","1 min","1","1"));
        topSeries.add(new TopSeries(R.drawable.dammy,"mounika","narasimha","1 min","1","1"));
        topSeries.add(new TopSeries(R.drawable.dammy,"mounika","narasimha","1 min","1","1"));
        topSeries.add(new TopSeries(R.drawable.dammy,"mounika","narasimha","1 min","1","1"));
        topStoriesAdapter=new TopStoriesAdapter(getApplicationContext(),topSeries);
        lateststories.setAdapter(topStoriesAdapter);

    }


}
