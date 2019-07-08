package com.arkainfoteck.kahani.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.arkainfoteck.kahani.R;

public class writerOnlyLifeEvents extends AppCompatActivity {
    CardView viewAsReaderLifeEvent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writer_only_life_events);
        viewAsReaderLifeEvent = findViewById(R.id.viewAsReaderLifeEvent);
        viewAsReaderLifeEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),LifeEventDescription.class);
                startActivity(intent);
            }
        });
    }
}
