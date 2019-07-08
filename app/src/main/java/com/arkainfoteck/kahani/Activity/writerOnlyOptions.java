package com.arkainfoteck.kahani.Activity;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.arkainfoteck.kahani.R;

public class writerOnlyOptions extends AppCompatActivity {
    RadioButton completed,ongoing;
    RadioGroup radios;
    CardView addEpisode,viewAsReader;
    View view;
    ImageView left_series;





@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writer_only_options);
        addEpisode = findViewById(R.id.addEpisode);
        completed = (RadioButton)findViewById(R.id.completedStory);
        ongoing = findViewById(R.id.onGoing);
        radios = findViewById(R.id.radios);
        left_series = findViewById(R.id.left_series);
        ongoing.setChecked(true);
        radios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(group.getCheckedRadioButtonId()==completed.getId()){
                    //System.out.println(completed.getId()+"  fgsdfsdg   "+checkedId);
                    addEpisode.setVisibility(View.INVISIBLE);
                } else {
                    addEpisode.setVisibility(View.VISIBLE);
                }
            }
        });
        //System.out.println(radios.getCheckedRadioButtonId()+" ioioiodfsdg");
        viewAsReader = findViewById(R.id.viewAsReader);
        viewAsReader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),SeriesCardDescription.class);
                startActivity(intent);
                //finish();
            }
        });
        addEpisode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getBaseContext(),addingEpisode.class);
                startActivity(intent1);
                //finish();
            }
        });
        left_series.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
