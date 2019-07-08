package com.arkainfoteck.kahani.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.arkainfoteck.kahani.R;

public class addingEpisode extends AppCompatActivity {
    EditText title,titleInEnglish;
    TextView nextPageEpisode;
    ImageView back_addingEpisode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_episode);
        title = findViewById(R.id.title_addEpi);
        nextPageEpisode = findViewById(R.id.nextPageEpisode);
        nextPageEpisode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getBaseContext(),addingEpisodeStoryPage.class);
                startActivity(intent);
            }
        });
        back_addingEpisode = findViewById(R.id.back_addingEpisode);
        back_addingEpisode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //titleInEnglish = findViewById(R.id.titleinEnglish_addEpi);
    }
}
