package com.arkainfoteck.kahani.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arkainfoteck.kahani.Adapter.EpisodeAdapter;
import com.arkainfoteck.kahani.Model.EpisodeModel;
import com.arkainfoteck.kahani.R;

import java.util.ArrayList;

public class EpisodesActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    EpisodeAdapter episodeAdapter;
    ArrayList<EpisodeModel>episodeModels;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodes);
        recyclerView=(RecyclerView)findViewById(R.id.episodes);
        episodeModels=new ArrayList<>();
        episodeModels.add(new EpisodeModel("Meet MR and mrs vihaan"));
        episodeModels.add(new EpisodeModel("Meet MR and mrs vihaan"));
        episodeModels.add(new EpisodeModel("Meet MR and mrs vihaan"));
        episodeModels.add(new EpisodeModel("Meet MR and mrs vihaan"));
        episodeModels.add(new EpisodeModel("Meet MR and mrs vihaan"));
        episodeModels.add(new EpisodeModel("Meet MR and mrs vihaan"));
        gridLayoutManager=new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);
        episodeAdapter=new EpisodeAdapter(getApplicationContext(),episodeModels);
        recyclerView.setAdapter(episodeAdapter);



    }
}
