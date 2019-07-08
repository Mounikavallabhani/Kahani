package com.arkainfoteck.kahani.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arkainfoteck.kahani.R;

public class WriterOnlyStory extends AppCompatActivity {
    CardView viewAsReaderStory;
    ImageView left_writer_only_story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writer_only_story);
        left_writer_only_story= findViewById(R.id.left_writer_only_story);
        left_writer_only_story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        viewAsReaderStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getBaseContext(),StoriesCardDescription.class);
                startActivity(intent);
            }
        });
    }
}
